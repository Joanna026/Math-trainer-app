$(() => {

    const groupList = $("#group-list");

    const addEventToDropdownBtn = function () {

        groupList.on("click", e => {
           e.preventDefault();
           console.log(e.target);
           if (e.target.tagName === "BUTTON" || e.target.parentElement.tagName === "BUTTON"
               || e.target.parentElement.parentElement.tagName === "BUTTON") {
               const parentDiv = e.target.closest("div");
               const descriptionDiv = parentDiv.nextElementSibling;
               $(descriptionDiv).slideToggle();
           }
        });

    };

    $(".message-body").hide();
    addEventToDropdownBtn();

});