(function(){

    "use strict";

    var counter = 0;

    var aboutMeBioNode = document.getElementById("aboutMeContainer");
    aboutMeBioNode.addEventListener("click", function() {
        if (counter % 2===0) {

        aboutMeBioNode.setAttribute("style", "width: 45%");
        } else {
            aboutMeBioNode.setAttribute("style", "width: 25%");
        }
        counter++;
        console.log(counter);
    })


})();
