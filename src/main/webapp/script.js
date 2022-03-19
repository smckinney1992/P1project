function display() {
		var name = "Shane"
		for (i = 1; i <= 5; i++) {
			document.write("<h1>" + name)
		}
		document.write("<br/>");
		grade = 100
		document.write(name + " your grade is " + grade)
	}
	function addNumbers() {
		alert("Welcome in add numbers");
		var num1 = prompt("enter number 1")
		var num2 = prompt("enter number 2")
		result = parseInt(num1) + parseInt(num2);
		var data = confirm("Do you want to see the sum ")
		if (data) {
			alert("Sum of the two numbers are :" + result);
		} else {
			alert("Thanks for using my app")
		}
	}
	function disp(message) {
		var name = "Richard";
		var city = new String("London")

		if (message == null) {
			message = "Guest"
		}
		alert(message);
		alert(Math.PI);
		r = Math.random();
		alert(r);
		var r = Math.floor(Math.random() * 10) + 1
		alert(r);
	}
	function Name(message) {
		var fname = prompt("enter first name")
		var lname = prompt("enter last name")
		result = String(fname + "" + lname)
		if (result) {
			alert(" Welcome " + fname.charAt(0) + " " + lname);
		} else {
			alert("Thanks");
		}
	}
	function LastDateCheck() {
		var today = new Date();
		var lastdate = new Date();
		lastdate.setFullYear(2022, 2, 31);//31st March 2022
		if (lastdate > today) {
			var day = 1000 * 60 * 60 * 24;
			x = (lastdate - today) / day;
			days = Math.floor(x)
			alert("Number of days left " + x);
		} else {
			alert("time up and you cannot apply for interview");
		}
	}