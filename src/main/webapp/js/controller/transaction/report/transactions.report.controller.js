angular.module(appName)
    .controller('TransactionsReportController', TransactionsReportController);

TransactionsReportController.$inject = ['$rootScope', '$scope', 'TransactionService', 'DTOptionsBuilder'];


function TransactionsReportController($rootScope, $scope, TransactionService, DTOptionsBuilder) {


    $scope.dtOptions = DTOptionsBuilder.newOptions()


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
            cancelLabel: 'iptal',
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


    $scope.postData = {
        merchant: null,
        acquirer: null
    };

    $scope.getReports = function () {

        if ($scope.reportForm.$valid) {
            // query

            $scope.postData.fromDate = moment($scope.datePicker.date.startDate).format(
                'YYYY-MM-DD');
            $scope.postData.toDate = moment($scope.datePicker.date.endDate).format('YYYY-MM-DD');

            TransactionService.getTransactionReport($scope.postData, {},
                function (data) {
                    console.log('data : ', data);
                    $scope.status = data.status;
                    $scope.reports = data.response;
                }, function (err) {
                    console.error('error : ', err);

                })
        } else {
            $scope.reportForm.$submitted = true;
        }

    }

}
