angular.module(appName)
    .factory('FintechCommonService', ['$resource', function ($resource) {
        return $resource('api/v3', {}, {
            'getErrorTypes': {
                url: 'api/v3/common/errorTypes',
                method: 'GET',
                isArray: true
            },
            'getPaymentMethodTypes': {
                url: 'api/v3/common/paymentMethods',
                method: 'GET',
                isArray: true
            },
            'getStatusTypes': {
                url: 'api/v3/common/statusTypes',
                method: 'GET',
                isArray: true
            },
            'getOperationTypes': {
                url: 'api/v3/common/operationTypes',
                method: 'GET',
                isArray: true
            },
            'getFilterTypes': {
                url: 'api/v3/common/filterTypes',
                method: 'GET',
                isArray: true
            }
        })
    }]);