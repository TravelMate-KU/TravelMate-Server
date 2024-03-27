    function addAction1(event) {
        var t1 = event.currentTarget.myParam1;
        var t2 = event.currentTarget.myParam2;
        var t0 = event.currentTarget.myParam0;
        
        t1.style.display = "block";
        console.log("open");
        console.log(t1);
    }

    function addAction2(event) {
        var t1 = event.currentTarget.myParam1;
        var t2 = event.currentTarget.myParam2;
        var t0 = event.currentTarget.myParam0;
        
        t1.style.display = "none";
        console.log("close");
        console.log(t1);
    }

    var iter = document.getElementsByClassName("popup-button");
    for (var i = 0; i < iter.length; i++){
        var div_target = iter[i];
        var popup_target = document.getElementsByClassName("popup")[i];
        var popupclose_target = document.getElementsByClassName("popup-close")[i];

        div_target.addEventListener("click", (e) => { addAction1(e); }); 
        div_target.myParam1 = popup_target;
        div_target.myParam2 = popupclose_target;
        div_target.myParam0 = div_target;

        popupclose_target.addEventListener("click", (e) => { addAction2(e); }); 
        popupclose_target.myParam1 = popup_target;
        popupclose_target.myParam2 = popupclose_target;
        popupclose_target.myParam0 = div_target;
    }