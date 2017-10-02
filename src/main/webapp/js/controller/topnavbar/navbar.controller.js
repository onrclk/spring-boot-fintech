'use strict';

angular.module(appName)
    .controller('NavbarController', function ($scope, $location, $state, AuthProvider, Principal) {
        $scope.isAuthenticated = Principal.isAuthenticated;
        $scope.$state = $state;

        $scope.logout = function () {
            AuthProvider.logout();
            $state.go('login');
        };
    });
