'use strict';

angular.module(appName)
    .factory('AuthProvider', function loginService($http, localStorageService) {
            return {
                login: function (credentials) {
                    var data = {
                        username: credentials.username,
                        password: credentials.password
                    };
                    return $http.post('api/v3/merchant/login', data, {
                        transformResponse: function (data, headers, status, config) {
                            var heds = headers();
                            var jwtToken = heds['authorization'];
                            localStorageService.set('token', jwtToken);
                            return data;
                        }
                    }).success(function (response) {
                        return response;
                    });
                },
                getJwtUserToken: function () {
                   return $http.get('api/v3/activeUserToken',{},{})
                        .success(function (response) {
                            return response
                        })
                },
                logout: function () {
                    localStorageService.remove('token');
                },
                getToken: function () {
                    return localStorageService.get('token');
                }
            };
        }
    );
