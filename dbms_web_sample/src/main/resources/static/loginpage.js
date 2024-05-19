$(document).ready(function () {
    $('#loginForm').on('submit', function (e) {
        e.preventDefault();

        var email = $('#email').val();
        var password = $('#password').val();

        $.ajax({
            url: '/api/user/login',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify({ email: email, password: password }),
            success: function (response) {
                alert('Welcome, ' + response.nickname);
                localStorage.setItem('nickname', response.nickname);
                localStorage.setItem('userId', response.id);
                window.location.href = '/homepage';
            },
            error: function (response) {
                alert('Error: ' + response.responseText);
            }
        });
    });
});