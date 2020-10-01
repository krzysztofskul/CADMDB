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

    var buttonHospital = $(".btn-hospital");

    hideAllDepartments();
    // showAllDepartments(); // test ok


    /** function definitions */

    buttonHospital.each(function () {
        $(this).on("click", function () {

            var departments = $(this).parent().parent().parent().parent().parent().children("div:nth-child(2)");

            if ($(this).children().text() === "COLLAPSE") {
                // alert("test click to collapse"); // ok
                $(this).children().text("EXPAND");
                hideShowDepartments("hide", departments);
            } else if ($(this).children().text() === "EXPAND") {
                // alert("test click to expand"); // ok
                $(this).children().text("COLLAPSE");
                hideShowDepartments("show", departments);
            }

        });
    });

    function hideShowDepartments(action, departments) {
        departments.each(function () {
            // $(this).addClass("bg-danger");

            if (action === "hide") {
                departments.each(function () {
                    // $(this).fadeOut(5000);
                    $(this).hide();
                });
            }

            if (action === "show") {
                departments.each(function () {
                    $(this).show();
                });
            }

        });
    }

    function hideAllDepartments() {
        hideShowDepartments("hide", departmentsAll);
    }

    function showAllDepartments() {
        hideShowDepartments("show", departmentsAll);
    }

});