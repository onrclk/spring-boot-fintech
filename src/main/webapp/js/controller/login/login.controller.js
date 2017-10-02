angular.module(appName)
    .controller('LoginController', ['$scope', '$state', 'AuthService', 'localStorageService',
        function ($scope, $state, AuthService,localStorageService) {

            var self = this;
            self.login = login;

            function login() {
                console.log(self.username + " " + self.password);

                AuthService.login({
                    username: self.username,
                    password: self.password
                }).then(function () {

                    console.log('login success');
                    localStorageService.set('username', self.username);
                    $scope.error = true;
                    $state.go('home');
                }).catch(function (err) {
                    console.log('LOGIN HATASI');
                    $scope.error = true;
                    $scope.message = 'Kullanıcı ismi ya da şifreniz hatalı';
                })
            }
        }]);