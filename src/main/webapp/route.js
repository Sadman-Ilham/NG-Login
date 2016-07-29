ngLoginApp.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'login.html',
            controller: 'loginController'
        })
        .when('/registration', {
            templateUrl: 'registration.html',
            controller: 'registrationController'
        })
        .when('/dashboard', {
            templateUrl: 'dashboard.html',
            controller: 'dashboardController'
        })
        .otherwise({ redirectTo: '/' })
});