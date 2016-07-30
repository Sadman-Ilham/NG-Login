ngLoginApp.factory('userService', ['$http', function ($http) {

    var register = function (user) {
        return $http.post("http://localhost:8085/api/user/register", user).then(function (response) {
            return response.data;
        });
    };

    var authenticate = function (credential) {
        return $http.post("http://localhost:8085/api/user/authenticate", credential,
            {headers: {userId: credential.userId, password: credential.password}}).then(function (response) {
            return response.data;
        });
    };

    var getUser = function () {
        var cookieCredential = loadCookieCredential();
        return $http.get("http://localhost:8085/api/user/details/" + cookieCredential.userId,
            {headers: {userId: cookieCredential.userId, password: cookieCredential.password}}).then(function (response) {
            return response.data;
        });
    };

    var invalidateUser = function () {
        deleteCookieValue("ng-userId");
        deleteCookieValue("ng-userPass");
    };

    var isUserAuthenticated = function () {
        var credential = loadCookieCredential();
        return credential.userId && credential.password;
    };

    var saveCookieCredential = function (credential) {
        saveCookieValue("ng-userId", credential.userId);
        saveCookieValue("ng-userPass", credential.password);
    };

    var loadCookieCredential = function () {
        return {
            userId: loadCookieValue("ng-userId"),
            password: loadCookieValue("ng-userPass")
        };
    };

    var saveCookieValue = function (key, value) {
        document.cookie = key + "=" + value;
    };

    var loadCookieValue = function (cookieKey) {
        var nameEQ = cookieKey + "=";
        var ca = document.cookie.split(';');
        for(var i=0;i < ca.length;i++) {
            var c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1,c.length);
            if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
        }
        return null;
    };

    var deleteCookieValue = function (cookieKey) {
        document.cookie = cookieKey + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    };

    return {
        authenticate: authenticate,
        register: register,
        getUser: getUser,
        invalidateUser: invalidateUser,
        isUserAuthenticated: isUserAuthenticated,
        saveCookieCredential: saveCookieCredential
    };

}]);