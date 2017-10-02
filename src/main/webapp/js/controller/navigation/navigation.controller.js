'use strict';

angular.module(appName)
    .controller('NavigationController', function ($rootScope, $scope, $location, $state, AuthProvider, Principal, localStorageService) {
        $scope.isAuthenticated = Principal.isAuthenticated;
        $scope.$state = $state;

        $rootScope.userName = localStorageService.get('username');

    });
