/**
 * INSPINIA - Responsive Admin Theme
 *
 * Inspinia theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written state for all view in theme.
 *
 */
function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, IdleProvider, KeepaliveProvider, localStorageServiceProvider, $httpProvider) {

    // Configure Idle settings
    IdleProvider.idle(5); // in seconds
    IdleProvider.timeout(120); // in seconds


    localStorageServiceProvider.setPrefix(appName);

    $urlRouterProvider.otherwise("/anasayfa");

    $ocLazyLoadProvider.config({
        // Set to true if you want to see what and when is dynamically loaded
        debug: false
    });

    $httpProvider.interceptors.push('JWTAuthInterceptor');
    $httpProvider.interceptors.push('authExpiredInterceptor');

    $stateProvider

        .state('site', {
            'abstract': true,
            views: {
                'navbar@': {
                    templateUrl: 'views/common/topnavbar.html',
                    controller: 'NavbarController'
                },
                'navigation': {
                    templateUrl: 'views/common/navigation.html',
                    controller: 'NavigationController'
                },
                'footer': {
                    templateUrl: 'views/common/footer.html',
                    controller: 'NavigationController'
                }
            }
        })
        .state('home', {
            parent: 'site',
            url: "/anasayfa",
            // templateUrl: "views/home.html",
            views: {
                'content@': {
                    templateUrl: 'views/home.html',
                    controller: 'MainController'
                }
            },
            data: {pageTitle: 'Ana sayfa'},
            resolve: {
                authorize: ['AuthService', function (AuthService) {
                    return AuthService.authorize();
                }],
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'angles',
                            files: ['js/plugins/chartJs/angles.js', 'js/plugins/chartJs/Chart.min.js']
                        },
                        {
                            name: 'angular-peity',
                            files: ['js/plugins/peity/jquery.peity.min.js', 'js/plugins/peity/angular-peity.js']
                        },
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: ['js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js',]
                        }
                    ]);
                }
            }
        })
        .state('transactions', {
            parent: 'site',
            url: '/transactions',
            data: {pageTitle: 'Islemler'}
        })
        .state('transactions.report', {
            url: '/report',
            data: {
                pageTitle: 'Transaction Report'
            },
            views: {
                'content@': {
                    templateUrl: 'views/transactions/transactions.report.html',
                    controller: 'TransactionsReportController',
                }
            }
        })
        .state('transactions.query', {
            url: '/query',
            data: {
                pageTitle: 'Transaction Query'
            },
            views: {
                'content@': {
                    templateUrl: 'views/transactions/transactions.query.html',
                    controller: 'TransactionsQueryController',
                }
            }
        })
        .state('transactions.search', {
            url: '/search',
            data: {
                pageTitle: 'Transaction Search'
            },
            views: {
                'content@': {
                    templateUrl: 'views/transactions/transaction.search.html',
                    controller: 'TransactionSearchController',
                }
            }
        })
        .state('login', {
            url: "/login",
            views: {
                'login@': {
                    templateUrl: 'views/login.html',
                    controller: 'LoginController',
                    controllerAs: 'loginController'
                }
            },
            data: {pageTitle: 'Login', specialClass: 'gray-bg'}
        })


}

angular
    .module(appName)
    .config(config)
    .run(function ($rootScope, $state, Principal, AuthService, FintechCommonService) {
        $rootScope.$state = $state;

        $rootScope.errorTypes = FintechCommonService.getErrorTypes();
        $rootScope.paymentMethodTypes = FintechCommonService.getPaymentMethodTypes();
        $rootScope.statusTypes = FintechCommonService.getStatusTypes();
        $rootScope.operationTypes = FintechCommonService.getOperationTypes();
        $rootScope.filterTypes = FintechCommonService.getFilterTypes();

        $rootScope.$on('$stateChangeStart',
            function (event, toState, toStateParams) {
                // track the state the user wants to go to;
                // authorization service needs this
                $rootScope.toState = toState;
                $rootScope.toStateParams = toStateParams;
                $rootScope.isAuthenticated = Principal.isAuthenticated;

                // if the principal is resolved, do an
                // authorization check immediately. otherwise,
                // it'll be done when the state it resolved.
                if (Principal.isIdentityResolved())
                    AuthService.authorize();
            });

    });
