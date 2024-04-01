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
var search = document.getElementsByClassName("search-button-field")[0];

var see = 3;
var walk = 3;
var talk = 3;
var listen = 3;
var iq = 3;
var bipolar_disorder = 3;
var depression = 3;

// Add an event listener to the signup div
search.addEventListener("click", function() {

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

/* POST Method
  // Create a new XMLHttpRequest object
  var xhr = new XMLHttpRequest();

  // Specify the URL and the method (POST)
  xhr.open("POST", "http://localhost:8080/matching/list");

  // Set the request header to indicate the content type
  xhr.setRequestHeader("Content-Type", "application/json");

  // Create a JSON object with the field values
  var data = {
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
      location.href='unwell_search.html';
    } else {
      // Error
      alert("Signup failed: " + xhr.statusText);
    }
  };
*/

/* GET METHOD */
// Create a new XMLHttpRequest object
var xhr = new XMLHttpRequest();

// 파라미터를 쿼리 스트링 형식으로 변환
var params = "see=" + see + "&walk=" + walk + "&talk=" + talk + "&listen=" + listen + "&iq=" + iq + "&depression=" + depression + "&bipolarDisorder=" + bipolar_disorder;

// 요청 URL 설정
var url = "http://localhost:8080/requests";

// 요청 방식과 URL을 열기
xhr.open("GET", url + "?" + params);

// 요청 보내기
xhr.send();
console.log(url + "?" + params);

xhr.onload = () => {
    if(xhr.status == 200){
        console.log(xhr);
        const res = xhr.responseText;
        document.body.innerHTML = "";
        //document.write("");
        document.write(res);
        /*
        const parser = new DOMParser();
        const doc = parser.parseFromString(res, "text/html");
        const title = doc.querySelector("title").;
        const body = doc.querySelector("body").innerHTML;

        document.title = title;
        document.body.innerHTML = body;
*/

    }

};
/*
// 요청 상태 변화에 대한 이벤트 핸들러 정의
xhr.onreadystatechange = function() {
  // 요청이 완료되고 응답이 성공적인 경우
  if (xhr.readyState == 4 && xhr.status == 200) {
    console.log(xhr.responseText);
      //location.href="http://localhost:8080/matching";
  }
};
*/
});


// Get all the button elements by their class name
var buttons = document.querySelectorAll('.request-area');

// Loop through the button elements
for (var i = 0; i < buttons.length; i++) {
    // Add an event listener to each button element
    buttons[i].addEventListener('click', function(event) {
        // Prevent the default behavior of the button element
        event.preventDefault();
        // Get the parent form element of the button element
        var form = event.target.closest('form');
        // Get the requestId from the form
        var requestId = form.querySelector('input[name="requestId"]').value;
        // Construct the URL with the requestId
        var url = 'http://localhost:8080/requests/' + requestId + "/matchings";
        // Create a new XMLHttpRequest object
        var xhr = new XMLHttpRequest();
        // Open a POST request to the specified URL
        xhr.open('POST', url);
        // Set the onload event handler
        xhr.onload = function() {
            // Check if the request was successful
            if (xhr.status == 200) {
                // Redirect to the specified URL
                window.location.href = 'http://localhost:8080/matchings';
            } else {
                // Log the error message
                console.error('Error:', xhr.statusText);
                // Display an alert message
                alert('Error occurred while processing the request.');
            }
        };
        // Send the request
        xhr.send();
        // Log the URL for debugging
        console.log('POST request sent to:', url);
        // Hide the parent form element
        form.style.display = 'none';
        // Display an alert message
        alert('Matching Requested');
    });
}
