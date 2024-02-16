// 기본 색상 설정
var purple = "#2467bf";
var yellow = "#cde4ff";


// 모든 rectangle에 기본 색상 적용
var rectangles = document.getElementsByClassName("rectangle-2");
for (var i = 0; i < rectangles.length; i++) {
  rectangles[i].style.backgroundColor = yellow;
}
// 모든 rectangle에 기본 색상 적용
var rectangles = document.getElementsByClassName("rectangle-3");
for (var i = 0; i < rectangles.length; i++) {
  rectangles[i].style.backgroundColor = yellow;
}
// 모든 rectangle에 기본 색상 적용
var rectangles = document.getElementsByClassName("rectangle-4");
for (var i = 0; i < rectangles.length; i++) {
  rectangles[i].style.backgroundColor = yellow;
}

// rectangle-1만 보라색으로 변경
var rectangles = document.getElementsByClassName("rectangle-1");
for (var i = 0; i < rectangles.length; i++) {
  rectangles[i].style.backgroundColor = purple;
}


// rectangle을 클릭하면 색상 변경하는 함수
function changeColor(event, it, me) {
  it = event.currentTarget.myParam;
  var element = document.getElementsByClassName("component")[it];
  element.getElementsByClassName("rectangle-1")[0].style.backgroundColor = yellow;
  element.getElementsByClassName("rectangle-2")[0].style.backgroundColor = yellow;
  element.getElementsByClassName("rectangle-3")[0].style.backgroundColor = yellow;
  element.getElementsByClassName("rectangle-4")[0].style.backgroundColor = yellow;

  if(me == 1){
  element.getElementsByClassName("rectangle-1")[0].style.backgroundColor = purple;
  }
  if(me == 2){
  element.getElementsByClassName("rectangle-2")[0].style.backgroundColor = purple;
  }
  if(me == 3){
  element.getElementsByClassName("rectangle-3")[0].style.backgroundColor = purple;
  }
  if(me == 4){
  element.getElementsByClassName("rectangle-4")[0].style.backgroundColor = purple;
  }
}

var iter = document.getElementsByClassName("component");
for (var i = 0; i < rectangles.length; i++) {
    var div1 = iter[i].getElementsByClassName("rectangle-1")[0];
    //div1.addEventListener("click", function(){changeColor(i, 1);});
    div1.addEventListener("click", (e) => { changeColor(e, i, 1); });
    div1.myParam = i;

    var div2 = iter[i].getElementsByClassName("rectangle-2")[0];
    //div2.addEventListener("click", function(){changeColor(i, 2);});
    div2.addEventListener("click", (e) => { changeColor(e, i, 2); });
    div2.myParam = i;

    var div3 = iter[i].getElementsByClassName("rectangle-3")[0];
    //div3.addEventListener("click", function(){changeColor(i, 3);});
    div3.addEventListener("click", (e) => { changeColor(e, i, 3); });
    div3.myParam = i;

    var div4 = iter[i].getElementsByClassName("rectangle-4")[0];
    //div4.addEventListener("click", function(){changeColor(i, 4);});
    div4.addEventListener("click", (e) => { changeColor(e, i, 4); });
    div4.myParam = i;
}


// 모든 rectangle에 기본 색상 적용
var rectangles = document.getElementsByClassName("rectangle-2");
for (var i = 0; i < rectangles.length; i++) {
  rectangles[i].style.backgroundColor = yellow;
}
// 모든 rectangle에 기본 색상 적용
var rectangles = document.getElementsByClassName("rectangle-3");
for (var i = 0; i < rectangles.length; i++) {
  rectangles[i].style.backgroundColor = yellow;
}
// 모든 rectangle에 기본 색상 적용
var rectangles = document.getElementsByClassName("rectangle-4");
for (var i = 0; i < rectangles.length; i++) {
  rectangles[i].style.backgroundColor = yellow;
}

// rectangle-1만 보라색으로 변경
var rectangles = document.getElementsByClassName("rectangle-1");
for (var i = 0; i < rectangles.length; i++) {
  rectangles[i].style.backgroundColor = purple;
}



// POST REQUEST

// Get the elements by their class names
var username = document.getElementsByClassName("user-name-field-text")[0].getElementsByClassName("text-wrapper-2")[0];
var email = document.getElementsByClassName("email-field-text")[0].getElementsByClassName("text-wrapper-2")[0];
var phone = document.getElementsByClassName("phone-number-field")[0].getElementsByClassName("text-wrapper-2")[0];
var signup = document.getElementsByClassName("signup-field-text")[0];

var see = 3;
var walk = 3;
var talk = 3;
var listen = 3;
var iq = 3;
var bipolar_disorder = 3;
var depression = 3;

// Add an event listener to the signup div
signup.addEventListener("click", function() {

var element = document.getElementsByClassName("cat-see")[0];
if(element.getElementsByClassName("rectangle-1")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
see = 3;
}
if(element.getElementsByClassName("rectangle-2")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
see = 2;
}
if(element.getElementsByClassName("rectangle-3")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
see = 1;
}
if(element.getElementsByClassName("rectangle-4")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
see = 0;
}

var element = document.getElementsByClassName("cat-walk")[0];
if(element.getElementsByClassName("rectangle-1")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
walk = 3;
}
if(element.getElementsByClassName("rectangle-2")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
walk = 2;
}
if(element.getElementsByClassName("rectangle-3")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
walk = 1;
}
if(element.getElementsByClassName("rectangle-4")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
walk = 0;
}

var element = document.getElementsByClassName("cat-talk")[0];
if(element.getElementsByClassName("rectangle-1")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
talk = 3;
}
if(element.getElementsByClassName("rectangle-2")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
talk = 2;
}
if(element.getElementsByClassName("rectangle-3")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
talk = 1;
}
if(element.getElementsByClassName("rectangle-4")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
talk = 0;
}

var element = document.getElementsByClassName("cat-listen")[0];
if(element.getElementsByClassName("rectangle-1")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
listen = 3;
}
if(element.getElementsByClassName("rectangle-2")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
listen = 2;
}
if(element.getElementsByClassName("rectangle-3")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
listen = 1;
}
if(element.getElementsByClassName("rectangle-4")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
listen = 0;
}

var element = document.getElementsByClassName("cat-intel")[0];
if(element.getElementsByClassName("rectangle-1")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
iq = 3;
}
if(element.getElementsByClassName("rectangle-2")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
iq = 2;
}
if(element.getElementsByClassName("rectangle-3")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
iq = 1;
}
if(element.getElementsByClassName("rectangle-4")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
iq = 0;
}

var element = document.getElementsByClassName("cat-mental")[0];
if(element.getElementsByClassName("rectangle-1")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
bipolar_disorder = 3;
}
if(element.getElementsByClassName("rectangle-2")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
bipolar_disorder = 2;
}
if(element.getElementsByClassName("rectangle-3")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
bipolar_disorder = 1;
}
if(element.getElementsByClassName("rectangle-4")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
bipolar_disorder = 0;
}

var element = document.getElementsByClassName("cat-depre")[0];
if(element.getElementsByClassName("rectangle-1")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
depression = 3;
}
if(element.getElementsByClassName("rectangle-2")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
depression = 2;
}
if(element.getElementsByClassName("rectangle-3")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
depression = 1;
}
if(element.getElementsByClassName("rectangle-4")[0].style.backgroundColor == 'rgb(36, 103, 191)'){
depression = 0;
}

  // Create a new XMLHttpRequest object
  var xhr = new XMLHttpRequest();

  // Specify the URL and the method (POST)
  xhr.open("POST", "http://localhost:8080/login/signup/disable");

  // Set the request header to indicate the content type
  xhr.setRequestHeader("Content-Type", "application/json");

  // Create a JSON object with the field values
  var data = {
    name: username.innerText,
    email: email.innerText,
    phoneNum: phone.value,
    see: see,
    walk: walk,
    talk: talk,
    listen: listen,
    iq: iq,
    bipolar_disorder: bipolar_disorder,
    depression: depression
  };

  // Send the JSON object as a string
  xhr.send(JSON.stringify(data));
console.log(JSON.stringify(data));

  // Handle the response
  xhr.onload = function() {
    // Check the status code
    if (xhr.status == 200) {
      location.href='http://localhost:8080/login/disable';
    } else {
      // Error
      alert("Signup failed: " + xhr.statusText);
    }
  };
});
