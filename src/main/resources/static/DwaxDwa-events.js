$(() => {

    // ------------STUDENT GROUP LIST-------------- //

    const groupList = $("#group-list");

    const addEventToDropdownBtn = function () {

        groupList.on("click", e => {
           e.preventDefault();
           if (e.target.tagName === "BUTTON" || e.target.parentElement.tagName === "BUTTON"
               || e.target.parentElement.parentElement.tagName === "BUTTON") {
               const parentDiv = e.target.closest("div");
               const descriptionDiv = parentDiv.nextElementSibling.parentElement.nextElementSibling;
               $(descriptionDiv).slideToggle();
           }
        });
    };

    const addEventToStudentName = function () {

        groupList.on("click", e => {
            console.log(e.target);
           if (e.target.tagName === "STRONG" || e.target.firstElementChild.tagName === "STRONG") {
               $(e.target.parentElement.nextElementSibling).slideToggle();
           }
        });
    };


    $(".message-body").hide();
    $(".single-student").hide();
    addEventToDropdownBtn();
    addEventToStudentName();


    // ------------EXERCISE SOLVING PAGE-------------- //

    const form = $("#exercise-solve");

    form.submit(() => {
        const correctAnswer = $("#correct-answer").val();
        let answerInput = $("#user-answer");
        const okIcon = $(` <span class="icon is-large is-right has-text-success" style="margin-top: 10%"> 
  <i class="fas fa-check fa-3x"></i> </span> `);
        const nokIcon = $(` <span class="icon is-large is-right has-text-danger" style="margin-top: 10%">
   <i class="fas fa-times fa-3x"></i> </span> `);

        if (answerInput.val() === correctAnswer) {
            answerInput.after(okIcon);
        } else {
            answerInput.after(nokIcon);
        }
        setTimeout(() => {}, 3000);
        return true;
    });
});