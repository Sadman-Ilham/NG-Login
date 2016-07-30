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
            templateUrl: '/app/views/login.html',
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
            templateUrl: '/app/views/registration.html',
            controller: 'registrationController'
        })
        .when('/dashboard', {
            templateUrl: '/app/views/dashboard.html',
            controller: 'dashboardController'
        })
        .otherwise({ redirectTo: '/' })
});