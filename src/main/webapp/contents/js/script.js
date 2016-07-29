$(document).ready(function() {
    $.ajax({
        url: "http://localhost:9090/api/user/test"
    }).then(function(data) {
        $.each(data.item, function (index, str) {
            $('#content').append(str).append('<br/>');
        })
    });
});