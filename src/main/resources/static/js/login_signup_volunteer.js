// POST REQUEST

// Get the elements by their class names
var username = document.getElementsByClassName("user-name-field-text")[0].getElementsByClassName("text-wrapper-2")[0];
var email = document.getElementsByClassName("email-field-text")[0].getElementsByClassName("text-wrapper-2")[0];
var phone = document.getElementsByClassName("phone-number-field")[0].getElementsByClassName("text-wrapper-2")[0];
var signup = document.getElementsByClassName("signup-field-text")[0];

// Add an event listener to the signup div
signup.addEventListener("click", function() {

  // Create a new XMLHttpRequest object
  var xhr = new XMLHttpRequest();

  // Specify the URL and the method (POST)
  xhr.open("POST", "http://localhost:8080/login/signup/volunteer");

  // Set the request header to indicate the content type
  xhr.setRequestHeader("Content-Type", "application/json");

  // Create a JSON object with the field values
  var data = {
    name: username.innerText,
    email: email.innerText,
    phoneNum: phone.innerText
  };

  // Send the JSON object as a string
  xhr.send(JSON.stringify(data));
console.log(JSON.stringify(data));

  // Handle the response
  xhr.onload = function() {
    location.href="http://localhost:8080/requests";
    // Check the status code
    if (xhr.status == 200) {
      // Success

    } else {
      // Error
      alert("Signup failed: " + xhr.statusText);
    }
  };
});
