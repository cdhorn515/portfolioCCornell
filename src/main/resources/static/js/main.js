(function(){

    "use strict";

    var counter = 0;

    var aboutMeBioNode = document.getElementById("aboutMeContainer");
    aboutMeBioNode.addEventListener("click", function() {
        if (counter % 2===0) {

        aboutMeBioNode.setAttribute("style", "width: 100%");
        } else {
            aboutMeBioNode.setAttribute("style", "width: 70%");
        }
        counter++;
        console.log(counter);
    })


})();
