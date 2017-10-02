angular.module(appName)
    .factory('TransactionService', ['$resource', function ($resource) {
        return $resource('api/v3', {}, {

            'getTransactionReport': {
                url: 'api/v3/transactions/report',
                method: 'GET',
                /* transformResponse: function (data, headers, status, config) {
                     return data.data;
                 },*/
                isArray: false
            },

            'queryTransactions': {
                url: 'api/v3/transactions/query',
                method: 'GET',
                isArray: false
            },
            'searchTransaction': {
                url: 'api/v3/transaction/:id',
                method: 'GET',
                isArray: false
            }
        })
    }]);