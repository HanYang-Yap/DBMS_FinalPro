function confirmDelete() {
            var r = confirm("Are you sure you want to delete this product?");
            if (r == true) {
                // Call the function to delete the product
                deleteProduct();
            }
        }
        $(document).ready(function () {
            var userId = localStorage.getItem('userId');
            console.log(userId)
            var nickname = localStorage.getItem('nickname');
            var currentProductId = null;
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
                        userId: userId,
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
            // Function to create or update a product
            $('#product-form').submit(function (e) {
                e.preventDefault();
                var product = {
                    name: $('#productName').val(),
                    category: $('#productCategory').val(),
                    description: $('#productDescription').val(),
                    price: $('#productPrice').val(),
                    quantity: $('#productQuantity').val(),
                    image: $('#productImage').val(),
                    user: { id: userId }
                };
                var url = '/api/products';
                var type = 'POST';
                if (currentProductId) {
                    url += '/' + currentProductId;
                    type = 'PUT';
                }
                console.log(product)
                $.ajax({
                    url: url,
                    type: type,
                    contentType: 'application/json',
                    data: JSON.stringify(product),
                    success: function () {
                        var message = currentProductId ? 'Product updated successfully!' : 'Product created successfully!';
                        alert(message);
                        $('#product-form')[0].reset();
                        currentProductId = null; // Reset currentProductId after form submission
                        $('#productModal').modal('hide');
                        // Reload the page
                        location.reload();
                    },
                    error: function () {
                        var message = currentProductId ? 'Error updating product. Please try again.' : 'Error creating product. Please try again.';
                        alert(message);
                    }
                });
            });
            $.ajax({
                url: '/api/products',
                type: 'GET',
                data: {
                    userId: userId
                },
                success: function (products) {
                    products.forEach(function (product) {
                        $('#product-list').append(`
                            <div class="col-lg-4 col-md-6 mb-4">
                                <div class="card h-100">
                                    <img class="card-img-top" src="${product.image}" alt="${product.name}" height="300">
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
            $('#buyerOption').click(function () {
                window.location.href = '/buyerhome';
            });
            // Function to update a product
            window.updateProduct = function (id) {
                // Fetch the product details
                $.ajax({
                    url: '/api/products/' + id,
                    type: 'GET',
                    success: function (product) {
                        // Fill the form fields
                        $('#productName').val(product.name);
                        $('#productCategory').val(product.category);
                        $('#productDescription').val(product.description);
                        $('#productPrice').val(product.price);
                        $('#productQuantity').val(product.quantity);
                        $('#productImage').val(product.image);
                        // Change the modal title and the text of the submit button
                        $('#productModalLabel').text('Update Product');
                        $('#product-form button[type="submit"]').text('Update');
                        // Show the modal
                        $('#productModal').modal('show');
                        // Set currentProductId to the id of the product being updated
                        currentProductId = id;
                    },
                    error: function () {
                        alert('Error fetching product. Please try again.');
                    }
                });
            };

            // Function to delete a product
            window.deleteProduct = function (id) {
                if (confirm("Are you sure you want to delete this product?")) {
                    $.ajax({
                        url: '/api/products/' + id,
                        type: 'DELETE',
                        success: function () {
                            alert('Product deleted successfully!');
                            // Reload the page
                            location.reload();
                        },
                        error: function () {
                            alert('Error deleting product. Please try again.');
                        }
                    });
                }
            };

            $('.dropdown-menu a.dropdown-item').click(function () {
                $('#navbarDropdown').text($(this).text());
            });
        });