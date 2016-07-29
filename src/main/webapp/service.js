var UserIdStorage;

ngLoginApp.factory('userService', function userService($http) {

    var authenticate = function (credential) {
        return $http.post("http://localhost:8085/api/user/authenticate", credential).then(function (response) {
            return response.data;
        });
    };

    var register = function (user) {
        return $http.post("http://localhost:8085/api/user/register", user).then(function (response) {
            return response.data;
        });
    };

    var getUser = function (userId) {
        return $http.get("http://localhost:8085/api/user/details/" + userId, {headers: {userId: userId}}).then(function (response) {
            return response.data;
        });
    };

    var invalidate = function (userId) {
        return $http.post("http://localhost:8085/api/user/invalidate", userId, {headers: {userId: userId}}).then(function (response) {
            return response.data;
        });
    };

    var saveUser = function (userId) {
        document.cookie = "ng-loggedInUserId=" + userId;
    };

    var loadUser = function () {
        var nameEQ = "ng-loggedInUserId=";
        var ca = document.cookie.split(';');
        for(var i=0;i < ca.length;i++) {
            var c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1,c.length);
            if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
        }
        return null;
    };

    return {
        authenticate: authenticate,
        register: register,
        getUser: getUser,
        invalidate: invalidate,
        saveUser: saveUser,
        loadUser: loadUser
    };
});