/**
 * JS */
// document.addEventListener("DOMContentLoaded", function() {
//
//     alert("TEST JS LOADED!") // ok
//
// });

/**
 * jQuery
 * */
$(document).ready(function() {

    //alert("TEST JS/JQUERY LOADED!"); // ok

    /** var definitions */

    var hospitalsAll = $(".card-hospital");
    var departmentsAll = hospitalsAll.children("div:nth-child(2)");

    var buttons = $("button");

    var buttonsHospital = $(".btn-hospital");
    var buttonsDepartment = $(".btn-department");
    var buttonsRoom = $(".btn-room");

    hideAllCards();
    // showAllDepartments(); // test ok


    /** function definitions */

    //buttonsHospital.each(function () {
    buttons.each(function () {
        $(this).on("click", function () {

            var parentCard = $(this).parent().parent().parent().parent().parent().children("div:nth-child(2)");

            if ($(this).children().text() === "COLLAPSE") {
                // alert("test click to collapse"); // ok
                $(this).children().text("EXPAND");
                hideShowCard("hide", parentCard);
            } else if ($(this).children().text() === "EXPAND") {
                // alert("test click to expand"); // ok
                $(this).children().text("COLLAPSE");
                hideShowCard("show", parentCard);
            }

        });
    });

    function hideShowCard(action, card) {
        card.each(function () {

            if (action === "hide") {
                card.each(function () {
                    // $(this).fadeOut(5000);
                    $(this).hide();
                });
            }

            if (action === "show") {
                card.each(function () {
                    $(this).show();
                });
            }

        });
    }

    function hideAllCards() {
        buttons.each(function () {
            var parentCard = $(this).parent().parent().parent().parent().parent().children("div:nth-child(2)");
            hideShowCard("hide", parentCard);
        });
    }

    function showAllCards() {
        var parentCard = $(this).parent().parent().parent().parent().parent().children("div:nth-child(2)");
        hideShowCard("show", parentCard);
    }

});