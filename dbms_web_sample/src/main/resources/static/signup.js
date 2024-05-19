// Register form submit
        $('#registerForm').on('submit', function (e) {
            // Prevent default form submission
            e.preventDefault();
            // Create user object
            var user = {
                //email: $('#email').val(),
                //password: $('#password').val(),
                //nickname: $('#nickname').val()
                username: $('#username').val(),
                id: $('#id').val(),
                //studentID: $('#studentid').val(),      //idk how to combine studentid and adminid yet  
                //admindID: $('#adminid').val(),
                department: $('#department').val(),
                password: $('#password').val()          //idk confirm password
                
            };
            // Send POST request to /api/user
            $.ajax({
                type: 'POST',
                url: '/api/user',
                data: JSON.stringify(user),
                contentType: 'application/json',
                // If success, alert user and redirect to login page
                success: function (response) {
                    alert(response.username + ' registered successfully');
                    window.location.href = '/loginpage';
                },
                // If error, alert user
                error: function (error) {
                    alert(error.responseText);
                }
            });
        });