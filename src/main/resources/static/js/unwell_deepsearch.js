// Get all the button elements by their class name
var buttons = document.querySelectorAll('.request-area');

// Loop through the button elements
for (var i = 0; i < buttons.length; i++) {
  // Add an event listener to each button element
  buttons[i].addEventListener('click', function(event) {
    // Prevent the default behavior of the button element
    event.preventDefault();
    // Get the parent element of the button element
    var parent = event.target.parentElement;

    // While the parent element is not a form element
    while (parent.tagName !== 'FORM') {
      // Get the parent element of the parent element
      parent = parent.parentElement;
    }

// startDate와 startTime을 합쳐서 startDatetime에 저장
var startDates = document.querySelectorAll(".startDate"); // startDate 클래스를 가진 모든 input 태그를 배열로 가져오기
var startTimes = document.querySelectorAll(".startTime"); // startTime 클래스를 가진 모든 input 태그를 배열로 가져오기
var startDatetimes = document.querySelectorAll(".startDatetime"); // startDatetime 클래스를 가진 모든 input 태그를 배열로 가져오기
for (var i = 0; i < startDates.length; i++) { // 배열의 길이만큼 반복하기
  var startDate = startDates[i].value; // i번째 input 태그의 value 값 가져오기
  var startTime = startTimes[i].value; // i번째 input 태그의 value 값 가져오기
  var startDatetime = startDate + " " + startTime + ":00"; // YYYY-MM-DD HH:MM:SS 형식의 문자열 만들기
  startDatetimes[i].value = startDatetime; // i번째 input 태그에 startDatetime 변수 넣기
}

// endDate와 endTime을 합쳐서 endDatetime에 저장
var endDates = document.querySelectorAll(".endDate"); // endDate 클래스를 가진 모든 input 태그를 배열로 가져오기
var endTimes = document.querySelectorAll(".endTime"); // endTime 클래스를 가진 모든 input 태그를 배열로 가져오기
var endDatetimes = document.querySelectorAll(".endDatetime"); // endDatetime 클래스를 가진 모든 input 태그를 배열로 가져오기
for (var i = 0; i < endDates.length; i++) { // 배열의 길이만큼 반복하기
  var endDate = endDates[i].value; // i번째 input 태그의 value 값 가져오기
  var endTime = endTimes[i].value; // i번째 input 태그의 value 값 가져오기
  var endDatetime = endDate + " " + endTime + ":00"; // YYYY-MM-DD HH:MM:SS 형식의 문자열 만들기
  endDatetimes[i].value = endDatetime; // i번째 input 태그에 endDatetime 변수 넣기
}


    // Submit the parent form element
    console.log(parent);
    parent.submit()
    console.log("부모");
    console.log(parent);
    alert("HELP Requested");
    //location.href="http://localhost:8080/course";

  });
}




// SET input date/time to NOW
// 현재 날짜와 시간을 가져옵니다.
var today = new Date();

// 현재 날짜를 yyyy-mm-dd 형식으로 변환합니다.
var date = today.getFullYear() + '-' + (today.getMonth() + 1).toString().padStart(2, '0') + '-' + today.getDate().toString().padStart(2, '0');

// 현재 시간을 hh:mm 형식으로 변환합니다.
var time = today.getHours().toString().padStart(2, '0') + ':' + today.getMinutes().toString().padStart(2, '0');

// HTML 문서에서 모든 input 요소를 선택합니다.
var inputs = document.querySelectorAll('input');

// 각 input 요소에 대해 반복합니다.
for (var i = 0; i < inputs.length; i++) {
  // input 요소의 type과 id를 확인합니다.
  var type = inputs[i].getAttribute('type');
  var cla = inputs[i].getAttribute('class');


  if (type === 'date' && cla === 'startDate') {
    // input 요소의 value를 현재 날짜로 설정합니다.
    inputs[i].value = date;
  }

  if (type === 'time' && cla === 'startTime') {
    // input 요소의 value를 현재 시간으로 설정합니다.
    inputs[i].value = time;
  }

  if (type === 'date' && cla === 'endDate') {
	var newDay = new Date();
        newDay.setDate(newDay.getDate() + 1);

	// 현재 날짜를 yyyy-mm-dd 형식으로 변환합니다.
	var newDate = newDay.getFullYear() + '-' + (newDay.getMonth() + 1).toString().padStart(2, '0') + '-' + 	newDay.getDate().toString().padStart(2, '0');

    // input 요소의 value를 현재 날짜로 설정합니다.
    inputs[i].value = newDate;
  }

  if (type === 'time' && cla === 'endTime') {
    // input 요소의 value를 현재 시간으로 설정합니다.
    inputs[i].value = time;
  }
}
