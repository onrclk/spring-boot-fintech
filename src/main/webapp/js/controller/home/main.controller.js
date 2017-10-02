'use strict';

angular.module(appName)
    .controller('MainController',
        function ($scope, $rootScope, $http
            , $controller, $state, Principal) {

            $scope.userData = {};
            $scope.coloursOutbox = [{ // green
                fillColor: 'rgba(70,191,189,0.2)',
                strokeColor: 'rgba(70,191,189,1)',
                pointColor: 'rgba(70,191,189,1)',
                pointStrokeColor: '#fff',
                pointHighlightFill: '#fff',
                pointHighlightStroke: 'rgba(70,191,189,0.8)'

            }];

            Principal.identity()
                .then(function (identity) {
                    console.log('user: ',identity);
                    $scope.userData = identity;
                }).catch(function () {
                console.log('identity could not be resolved')
            })

        });

