angular.module('finTechApp')
    .factory('AuthService', ['$rootScope', '$state', '$q', '$http', 'Principal', 'AuthProvider',
        function ($rootScope, $state, $q, $http, Principal, AuthProvider) {
            return {

                login: function (credentials, callback) {

                    var cb = callback || angular.noop;
                    var deferred = $q.defer();

                    AuthProvider.login(credentials).then(function (data) {
                        // retrieve the logged account information
                        Principal.identity(true).then(function (account) {
                            // After the login the language will be changed to
                            // the language selected by the user during his registration
                            deferred.resolve(data);
                        });
                        return cb();
                    }).catch(function (err) {
                        // todo logout
                        deferred.reject(err);
                        return cb(err);
                    }.bind(this));

                    return deferred.promise;
                },
                getToken: function () {
                    return AuthProvider.getToken();
                },
                goLogin : function(){
                    $state.go('login');
                },
                authorize: function (force) {
                    Principal.identity(force).then(function () {

                        var isAuthenticated = Principal.isAuthenticated();

                        if (!isAuthenticated) {
                            $rootScope.returnToState
                                = $rootScope.toState;
                            $rootScope.returnToStateParams
                                = $rootScope.toStateParams;

                            $state.go('login');
                        }
                    })
                }
            }
        }]);