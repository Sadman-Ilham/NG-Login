ngLoginApp.controller('loginController', ['$scope', 'userService', '$location',
    function ($scope, userService, $location) {
    $scope.submit = function () {
        var userId = $scope.username;
        var password = $scope.password;
        userService.authenticate(
            {
                userId: userId,
                password: password
            }
        ).then(viewResponse);
    };

    var viewResponse = function (data) {
        if (data.responseCode === 401) $scope.error = data.responseMessage;
        else {
            userService.saveCookieCredential(data.item);
            $location.path('/dashboard');
        }
    };
}]);

ngLoginApp.controller('registrationController', ['$scope', 'userService', '$location',
    function ($scope, userService, $location) {
    $scope.submit = function () {
        var fullName = $scope.fullname;
        var dateOfBirth = $scope.dob;
        var sex = $scope.sex;
        var about = $scope.about;
        var userId = $scope.userid;
        var password = $scope.password;
        userService.register(
            {
                fullName: fullName,
                dateOfBirth: dateOfBirth,
                sex: sex,
                about: about,
                userId: userId,
                password: password
            }
        ).then(viewResponse);
    };

    var viewResponse = function (data) {
        if (data.responseCode === 101) $scope.error = data.responseMessage;
        else $location.path('/');
    };
}]);

ngLoginApp.controller('dashboardController', ['$scope', 'userService', '$routeParams', '$location',
    function ($scope, userService, $routeParams, $location) {
    var viewResponse = function (data) {
        if (data.responseCode === 401) $location.path('/');
        else if (data.responseCode === 101) $scope.error = data.responseMessage;
        else {
            data.item.dateOfBirth = new Date(data.item.dateOfBirth).toString("dd-MMM-yyyy");
            $scope.userDetails = data.item;
        }
    };

    userService.getUser().then(viewResponse);

    $scope.invalidate = function () {
        userService.invalidateUser();
        $location.path('/');
    };
}]);