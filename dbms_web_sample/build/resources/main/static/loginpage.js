$(document).ready(function () {
    $('#loginForm').on('submit', function (e) {
        e.preventDefault();

        //var email = $('#email').val();
        var id = $('id').val();
        var password = $('#password').val();

        $.ajax({ 
            url: '/api/user/login',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify({ id: id, password: password }),
            success: function (response) {
                alert('Welcome, ' + response.username);
                localStorage.setItem('username', response.username);
                localStorage.setItem('id', response.id);
                window.location.href = '/homepage';
            },
            error: function (response) {
                alert('Error: ' + response.responseText);
            }
        });
    });
});