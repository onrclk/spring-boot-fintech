angular.module(appName)
    .controller('LoginController', ['$scope', '$state', 'AuthService', 'localStorageService',
        function ($scope, $state, AuthService,localStorageService) {

            var self = this;
            self.login = login;

            function login() {
                console.log(self.username + " " + self.password);

                AuthService.login({
                    username: self.username,
                    password: self.password,
                }).then(function () {

                    console.log('login success');
                    localStorageService.set('username', self.username);
                    $state.go('home');
                }).catch(function () {
                    console.log('LOGIN HATASI !!!');
                })
            }
        }]);