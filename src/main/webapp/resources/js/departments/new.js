/**
 * 
 */

$(document).ready(function() {
	
	// alert("test /resources/js/departments/new.js"); //ok
	
	var inputBudget = $("#inputBudget");
	var inputBudgetRange = $("#inputBudgetRange");
	
	inputBudgetRange.on("mousemove", function() {
		inputBudget.val(inputBudgetRange.val());
	});
	
});