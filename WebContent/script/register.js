$(document).ready(function () {
	document.querySelector("#registerUser").addEventListener("submit",(e)=>{
	e.preventDefault();
	const data = {
		username: $("#username").val(),
		email: $("#email").val(),
		password: $("#password").val(),
	}
		console.log(data);
		fetch("/GMachineAajax/User?op=register", {method: "POST", body: JSON.stringify(data)})
	.then((res)=> res.json())
	.then((data)=> {
		console.log(data)
	})
	.catch(err=>console.log(err));
	
	
	})

});