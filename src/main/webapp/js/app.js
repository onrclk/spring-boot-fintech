var appName = 'finTechApp';

(function () {
    angular.module(appName, [
        'ui.router',                    // Routing
        'oc.lazyLoad',                  // ocLazyLoad
        'ui.bootstrap',                 // Ui Bootstrap
        'pascalprecht.translate',       // Angular Translate
        'ngIdle',                       // Idle timer
        'ngSanitize',                    // ngSanitize
        'LocalStorageModule',
        'daterangepicker',
        'ngResource',
        'ngMessages',
        'datatables',
        'datatables.columnfilter', 'datatables.bootstrap', 'datatables.colvis',
        'datatables.tabletools', 'datatables.colreorder', 'datatables.scroller',
        'ngAnimate'
    ])
})();
