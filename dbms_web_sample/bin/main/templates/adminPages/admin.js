// Get the current date
var currentDate = new Date().toLocaleString();

// Concatenate "Login time:" with the date string
var dateTimeString = "(登入時間) " + currentDate;

// Set the concatenated string as the inner HTML of the div
document.getElementById("current_date").innerHTML = dateTimeString;
