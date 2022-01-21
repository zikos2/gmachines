$(document).ready(function () {
	document.querySelector("#loginUser").addEventListener("submit",(e)=>{
	e.preventDefault();
	const data = {
		email: $("#email").val(),
		password: $("#password").val(),
	}
		console.log(data);
		fetch("/GMachineAajax/User?op=login", {method: "POST", body: JSON.stringify(data)})
	.then((res)=> res.json())
	.then((data)=> {
		console.log(data)
		if(data == "true"){
		console.log("true statement");
		window.location.replace("http://localhost:8082/GMachineAajax/Dashboard/machines.jsp");
		}else{
		document.querySelector("#authError").innerText = "Password/email wrong please try again"
		}
	})
	.catch(err=>console.log(err));
	
	
	})

});