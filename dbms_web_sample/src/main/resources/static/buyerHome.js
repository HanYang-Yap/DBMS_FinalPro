$(document).ready(function () {

            var nickname = localStorage.getItem('nickname');
            $('#user-nickname').text(nickname);

            $('#logout-button').click(function () {
                $.ajax({
                    url: '/api/user/logout',
                    type: 'POST',
                    success: function () {
                        localStorage.removeItem('nickname');
                        window.location.href = '/login';
                    },
                    error: function () {
                        alert('Error logging out. Please try again.');
                    }
                });
            });

            $('#search-product-form').submit(function (e) {
                e.preventDefault();
                var search = $('#search').val();
                console.log(search);
                $.ajax({
                    url: '/api/products',
                    type: 'GET',
                    data: {
                        keyword: search
                    },
                    success: function (products) {
                        $('#product-list').empty();
                        products.forEach(function (product) {
                            $('#product-list').append(`
                                <div class="col-lg-4 col-md-6 mb-4">
                                    <div class="card h-100">
                                        <img class="card-img-top" src="${product.image}" alt="${product.name}" height="300px">
                                        <div class="card-body">
                                            <h4 class="card-title">Name: ${product.name}</h4>
                                            <p class="card-text">Category: ${product.category}</p>
                                            <p class="card-text">Description: ${product.description}</p>
                                            <div class="d-flex justify-content-between">
                                                <h5>Price: $${product.price}</h5>
                                                <p class="card-text">Quantity: ${product.quantity}</p>
                                            </div>
                                        </div>
                                        <div class="card-footer">
                                            <button class="btn btn-primary" onclick="updateProduct(${product.id})">Update</button>
                                            <button class="btn btn-danger" onclick="deleteProduct(${product.id})">Delete</button>
                                        </div>
                                    </div>
                                </div>
                            `);
                        });
                    },
                    error: function () {
                        alert('Error fetching products. Please try again.');
                    }
                });
            });

            $.ajax({
                url: '/api/products',
                type: 'GET',
                success: function (products) {
                    products.forEach(function (product) {
                        $('#product-list').append(`
                            <div class="col-lg-4 col-md-6 mb-4">
                                <div class="card h-100">
                                    <img class="card-img-top" src="${product.image}" alt="${product.name}" height="300px">
                                    <div class="card-body">
                                        <h4 class="card-title">Name: ${product.name}</h4>
                                        <p class="card-text">Category: ${product.category}</p>
                                        <p class="card-text">Description: ${product.description}</p>
                                        <p class="card-text">Seller: ${product.user.nickname}</p>
                                    </div>
                                    <div class="card-footer d-flex justify-content-between">
                                        <h5>$${product.price}</h5>
                                        <p class="card-text">Quantity: ${product.quantity}</p>
                                    </div>
                                </div>
                            </div>
                        `);
                    });
                }
            });

            $('#sellerOption').click(function () {
                window.location.href = '/sellerhome';
            });

            $('.dropdown-menu a.dropdown-item').click(function () {
                $('#navbarDropdown').text($(this).text());
            });
        });