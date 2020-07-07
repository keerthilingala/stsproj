/**
 * 
 */

function adminvalidation() {
	
	var fname=document.getElementById("firstName").value;
	var lname=document.getElementById("lastName").value;
	var age=document.getElementById("age").value;
	var gender=document.getElementById("gender").value;
	var phone=document.getElementById("contactNumber").value;
	var id=document.getElementById("adminId").value;
	var pwd=document.getElementById("password").value;
	var pwd1=document.getElementById("Conformpassword").value;
	var qstn1 = document.getElementById("secretquestion1").value;
	var ans1 = document.getElementById("answer1").value;
	var qstn2 = document.getElementById("secretquestion2").value;
	var ans2 = document.getElementById("answer2").value;
	
	var pattern=/[A-Za-z0-9]{6,32}/;
	var pattern1=/^((\+[1-9]{1,4}[ \-]*)|(\([0-9]{2,3}\)[ \-]*)|([0-9]{2,4})[ \-]*)*?[0-9]{3,4}?[ \-]*[0-9]{3,4}?$/;
	var pattern2=/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
	var pattern3=/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
	if(pwd!=pwd1)
	{
	document.getElementById("Conformpassword").style.borderColor="red";
	alert("Password and ConformPassword are not same");
	return false;

	}
	if(fname==""){
		alert("Please update Mandatory fields");
		document.getElementById("firstName").style.borderColor="red";
		return false;
		}
	 if(lname==""){
		alert("Please update Mandatory fields");
		document.getElementById("lastName").style.borderColor="red";
		return false;
		}
	 if(age==""){
		 alert("Please update Mandatory fields");
		document.getElementById("Age").style.borderColor="red";		
		return false;
		}
	 if(gender==""){
		alert("Please update Mandatory fields");
			document.getElementById("Gender").style.borderColor="red";
			return false;
			}
	 if(phone==""){
		alert("Please update Mandatory fields");
		document.getElementById("contactNumber").style.borderColor="red";
		return false;
		}		
	 if(id==""){
		alert("Please update Mandatory fields");
		document.getElementById("adminId").style.borderColor="red";
		
		return false;
		}
	 if(pwd==""){
		alert("Password and ConformPassword are not same");
		document.getElementById("password").style.borderColor="red";		
		return false;
		}
	
	 
	 if (qstn1 == "") {
			alert("Please update Mandatory fields");
			document.getElementById("secretquestion1").style.borderColor = "red";
			return false;
		}

		if (ans1 == "") {
			alert("Please update Mandatory fields");
			document.getElementById("answer1").style.borderColor = "red";
			return false;
		}

		if (qstn2 == "") {
			alert("Please update Mandatory fields");
			document.getElementById("secretquestion2").style.borderColor = "red";
			return false;
		}

		if (ans2 == "") {
			alert("Please update Mandatory fields");
			document.getElementById("answer2").style.borderColor = "red";
			return false;
		}
		
	 if(!pattern.test(id)){
		alert("Please update Mandatory fields");
		document.getElementById("adminId").style.borderColor="red";
		return false;		
		}
	 if(!pattern1.test(phone)){
		alert("Please update Mandatory fields");
		document.getElementById("contactNumber").style.borderColor="red";
		return false;
		}
	 if(!pattern2.test(pwd)){
		alert("Please update Mandatory fields");
		document.getElementById("password").style.borderColor="red";
		return false;
		
		}	
	 if(!pattern3.test(pwd1)){
			alert("Please update Mandatory fields");
			document.getElementById("password").style.borderColor="red";
			return false;
			
			}	
}


function loginvalidate(){

	var id=document.getElementById("userId").value;
	var pwd=document.getElementById("password").value;
	if(id==""){
		document.getElementById("userId").style.borderColor = "red";
		alert("please update mandatory highlighted fields");
		return false;
		}else if(pwd==""){
			document.getElementById("password").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}
}



function supportvalidate() {
	var fn = document.getElementById("firstName").value;
	var pattern = /[A-Za-z]{6,32}/;
	var phone = document.getElementById("contactNumber").value;
	var pattern1 = /^((\+[1-9]{1,4}[ \-]*)|(\([0-9]{2,3}\)[ \-]*)|([0-9]{2,4})[ \-]*)*?[0-9]{3,4}?[ \-]*[0-9]{3,4}?$/;
	var pwd2 = document.getElementById("password").value;
	var pattern2 = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;

	var pattern3 = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
	var ln = document.getElementById("lastName").value;
	var gender = document.getElementById("gender").value;
	var supportLevel = document.getElementById("supportLevel").value;
	var id = document.getElementById("analystId").value;
	var qstn1 = document.getElementById("secretquestion1").value;
	var ans1 = document.getElementById("answer1").value;
	var qstn2 = document.getElementById("secretquestion2").value;
	var ans2 = document.getElementById("answer2").value;
	var pwd3=document.getElementById("Conformpassword").value;
	if(pwd2!=pwd3)
	{
	document.getElementById("Conformpassword").style.borderColor="red";
	alert("Password and conform password are not same");
	return false;

	} 
	if (fn == "") {
		document.getElementById("firstName").style.borderColor = "red";
		alert("Please update mandatory highlighted fields");
		return false;
	}
	if (ln == "") {
		document.getElementById("lastName").style.borderColor = "red";
		alert("Please update mandatory highlighted fields");
		return false;
	}
	
	if (gender == "") {
		document.getElementById("gender").style.borderColor = "red";
		alert("Please update mandatory highlighted fields");
		return false;
	}
	if (id == "") {
		document.getElementById("analystId").style.borderColor = "red";
		alert("Please update mandatory highlighted fields");
		return false;
	}
	if (pwd == "") {
		document.getElementById("password").style.borderColor = "red";
		alert("Please update mandatory highlighted fields");
		return false;
	}
	if (phnno == "") {
		document.getElementById("contactNumber").style.borderColor = "red";
		alert("Please update mandatory highlighted fields");
		return false;
	}
	if (supportlevel == "") {
		document.getElementById("supportLevel").style.borderColor = "red";
		alert("Please update mandatory highlighted fields");
		return false;
	}
	if (qstn1 == "") {
		alert("Please update Mandatory fields");
		document.getElementById("secretquestion1").style.borderColor = "red";
		return false;
	}

	if (ans1 == "") {
		alert("Please update Mandatory fields");
		document.getElementById("answer1").style.borderColor = "red";
		return false;
	}

	if (qstn2 == "") {
		alert("Please update Mandatory fields");
		document.getElementById("secretquestion2").style.borderColor = "red";
		return false;
	}

	if (ans2 == "") {
		alert("Please update Mandatory fields");
		document.getElementById("answer2").style.borderColor = "red";
		return false;
	}

	if (!pattern.test(fn)) {
		document.getElementById("firstName").style.borderColor = "red";
		alert("Firstname should be minimum of 6 characters");
		return false;
	}if (!pattern1.test(phone)) {
		document.getElementById("contactNumber").style.borderColor = "red";
		alert("Enter phone number with maximum of 10 digits ");
		return false;
	} if (!pattern2.test(pwd2)) {
		document.getElementById("Conformpassword").style.borderColor = "red";
		alert("Enter password with minimum of 7 characters with one special character and numerical value");
		return false;
	}
	if (!pattern3.test(pwd3)) {
		document.getElementById("Conformpassword").style.borderColor = "red";
		alert("Enter password with minimum of 7 characters with one special character and numerical value");
		return false;
	}
}



};