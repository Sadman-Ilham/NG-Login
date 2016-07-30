ngLoginApp.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            resolve: {
                "check": function (userService, $location) {
                    if (userService.isUserAuthenticated()) {
                        $location.path('/dashboard');
                    }
                }
            },
            templateUrl: 'login.html',
            controller: 'loginController'
        })
        .when('/registration', {
            resolve: {
                "check": function (userService, $location) {
                    if (userService.isUserAuthenticated()) {
                        $location.path('/dashboard');
                    }
                }
            },
            templateUrl: 'registration.html',
            controller: 'registrationController'
        })
        .when('/dashboard', {
            templateUrl: 'dashboard.html',
            controller: 'dashboardController'
        })
        .otherwise({ redirectTo: '/' })
});