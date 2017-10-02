angular.module(appName)
    .controller('TransactionSearchController', TransactionSearchController);

TransactionSearchController.$inject = ['$rootScope', '$scope', 'TransactionService', 'DTOptionsBuilder'];


function TransactionSearchController($rootScope, $scope, TransactionService, DTOptionsBuilder) {


    $scope.searchTransaction = function () {


        TransactionService.searchTransaction({id: $scope.transactionId}, {},
            function (response) {
                console.log('data : ', response);
                $scope.transaction = response;

            }, function (err) {
                console.error('error :)', err);
            })

    }

}
