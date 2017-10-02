'use strict';

angular.module(appName)
    .controller('FooterController', function ($scope, $location, $state, AuthProvider, Principal) {
        $scope.isAuthenticated = Principal.isAuthenticated;
        $scope.$state = $state;
    });
