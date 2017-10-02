angular.module(appName)
    .controller('TransactionsQueryController', TransactionsQueryController);

TransactionsQueryController.$inject = ['$rootScope', '$scope', 'TransactionService', 'DTOptionsBuilder'];


function TransactionsQueryController($rootScope, $scope, TransactionService, DTOptionsBuilder) {


    console.log('filtertypes: ',$rootScope.filterTypes);

    $scope.dtOptions = DTOptionsBuilder.newOptions()
        .withOption('paging', true)// required
        .withPaginationType('full_numbers')
        .withBootstrap();

    // date range options
    $scope.options = {
        applyClass: 'btn-green',
        locale: {
            applyLabel: "Onayla",
            fromLabel: "From",
            format: "YYYY-MM-DD", //will give you 2017-01-06
            //format: "D-MMM-YY", //will give you 6-Jan-17
            //format: "D-MMMM-YY", //will give you 6-January-17
            toLabel: "To",
            cancelLabel: 'İptal',
            customRangeLabel: 'Custom range'
        },
        ranges: {
            'Last 7 Days': [moment().subtract(6, 'days'), moment()],
            'Last 30 Days': [moment().subtract(29, 'days'), moment()]
        }
    };

    $scope.datePicker = {
        date: {startDate: null, endDate: null}
    };


    $scope.postData = {};

    $scope.queryTransactions = function () {

        if ($scope.datePicker.date.startDate && $scope.datePicker.date.endDate) {

            $scope.postData.fromDate = moment($scope.datePicker.date.startDate).format('YYYY-MM-DD');
            $scope.postData.toDate = moment($scope.datePicker.date.endDate).format('YYYY-MM-DD');
        }


        TransactionService.queryTransactions($scope.postData, {},
            function (response) {
                console.log('data : ', response)
                $scope.transactions = response.data;
            }, function (err) {
                console.error('error :)', err);

            })

    }

}
