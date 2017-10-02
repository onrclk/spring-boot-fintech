angular.module(appName)
    .factory('JWTAuthInterceptor', function (localStorageService) {
        return {
            request: function (config) {
                config.headers = config.headers || {};
                var jwtToken = localStorageService.get('token');

                if (jwtToken) {
                    config.headers['Authorization'] = jwtToken;
                }

                return config;
            }
        }
    })
    .factory('authExpiredInterceptor', function ($rootScope, $q, $injector, localStorageService) {
        return {
            responseError: function (response) {
                if (response.status === 401 && response.data.message === 'Token expired') {
                    // token has expired

                    localStorageService.remove('token');
                    var Principal = $injector.get('Principal');
                    var Auth = $injector.get('AuthService');
                    Auth.goLogin();
                }

                return $q.reject(response);
            }
        };
    });