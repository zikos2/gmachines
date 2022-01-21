const deleteMachine = (id)=>{

		fetch(`/GMachineAajax/MachineController?op=delete&id=${id}`,{methode: "POST"})
		.then(res=>res.json())
		.then(data=>console.log(data))
		.catch(err=>console.log(err));
}

function fillModal(id){

	fetch("/GMachineAajax/Salle?op=load")
		.then((res)=> res.json())
		.then((data)=> {
		$("#modalListSalles").html("");
			data.map((salle)=>{
				const option = document.createElement("option");
				option.value = salle.id;
				option.innerText = salle.code;
				document.querySelector("#modalListSalles").appendChild(option);
			})
		})
	.catch(err=>console.log(err));



		fetch(`/GMachineAajax/MachineController?op=find&id=${id}`,{methode: "POST"})
		.then(res=>res.json())
		.then(data=>{
		const machineId = document.querySelector("#machineId");
		const modalReference = document.querySelector("#modalReference");
		const modalPrix = document.querySelector("#modalPrix");
		const modalDate =document.querySelector("#modalDate");
		const modalListSalle = document.querySelector("#modalListSalles");
		const modalStatusOn = document.querySelector("#statusOn");
		const modalStatusOff = document.querySelector("#statusOff");
		console.log(data)
		
		machineId.value = data.id;
		modalReference.value = data.reference;
		modalPrix.value = data.prix;
		const date = new Date(data.dateAchat);
		date.setDate(new Date(data.dateAchat).getDate() + 1)
		modalDate.valueAsDate = date;
		modalListSalle.value = data.salle.id;
		if(data.status === "on"){
		modalStatusOn.checked = true;
		}else if(data.status === "off"){
		modalStatusOff.checked = true;
		}
		
		})
		.catch(err=>console.log(err));
	}


$(document).ready(function () {
	const addForm = document.querySelector("#addMachineForm");
	const listSalles = document.querySelector("#listSalles");
	
	
	
	
	/*
	* Modal control
	*/
	
	
	/*
	* Add new machine
	*/
	addForm.addEventListener("submit",(e)=>{
	e.preventDefault();
		const reference = document.querySelector("#reference").value;
		const prix = document.querySelector("#prix").value;
		const date = document.querySelector("#date").value;
		const idSalle =listSalles.value;
		
		console.log(idSalle);
		
		fetch(`/GMachineAajax/MachineController?reference=${reference}&prix=${prix}&date=${date}&salle=${idSalle}`,{
			methode: "POST",
		})
		.then(res => res.json())
		.then(data => console.log(data))
		.catch(err=>console.log(err))
		
	
	});
	
	
	/*
	*Update Machine
	*/
	document.querySelector("#updateMachine").addEventListener("click",(e)=>{
	    const machineId = document.querySelector("#machineId").value;
	    const reference = document.querySelector("#modalReference").value;
		const prix = document.querySelector("#modalPrix").value;
		const date = document.querySelector("#modalDate").value;
		const modalListSalle = document.querySelector("#modalListSalles").value;
		const modalStatusOn = document.querySelector("#statusOn");
		const modalStatusOff = document.querySelector("#statusOff");
		let status = "";
		if(modalStatusOn.checked){
		status = "on"
		}else if(modalStatusOff.checked){
			status="off"
		}
		
		
		fetch(`/GMachineAajax/MachineController?op=update&machineId=${machineId}&reference=${reference}&prix=${prix}&date=${date}&salle=${modalListSalle}&status=${status}`,{
			methode: "POST",
		})
		.then(res => res.json())
		.then(data => console.log(data))
		.catch(err=>console.log(err))
	
	
	})
	
	/*
	* Get machines between two date
	*/
	
	document.querySelector("#findDate").addEventListener("submit",(e)=>{
		e.preventDefault();
	    const startDate = document.querySelector("#startDate").value;
		const endDate = document.querySelector("#endDate").value;
		
		
		fetch(`/GMachineAajax/MachineController?op=findDate&startDate=${startDate}&endDate=${endDate}`,{
			methode: "POST",
		})
		.then(res => res.json())
		.then(data => {console.log(data);remplir(data); })
		.catch(err=>console.log(err))
	
	
	})
	
	
	

	fetch("/GMachineAajax/MachineController?op=load")
	.then((res)=>res.json())
	.then((data)=>{
	console.log(data);
	  remplir(data);
	})
	.catch((err)=>console.log(err));

	fetch("/GMachineAajax/Salle?op=load")
	.then((res)=> res.json())
	.then((data)=> {
		data.map((salle)=>{
			const option = document.createElement("option");
			option.value = salle.id;
			option.innerText = salle.code;
			listSalles.appendChild(option);
		})
	})
	.catch(err=>console.log(err));
	

    $("#add").click(function () {
        var reference = $("#reference").val();
        var dateAchat = $("#dateAchat").val();
        var prix = $("#prix").val();
        var id = $("#salles").val();
        console.log(id);
        
        $.ajax({
            url: "MachineController",
            data: {reference, dateAchat, prix, id},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                remplir(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });

    });


	

	
    function remplir(data) {
        var ligne = "";
        for (var i = 0; i < data.length; i++) {
            ligne += `<tr style="background-color:${data[i].status === "on" ? '#c5ffc5' : '#ffc5c5'}"><td>` + data[i].id + "</td><td>" + data[i].reference + "</td><td>" + data[i].dateAchat + "</td><td>" + data[i].prix + "</td><td>" + data[i].salle.code + `</td><td><button class="btn btn-danger" onclick='deleteMachine(${data[i].id})'>X</button></td><td><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModal" onclick='fillModal(${data[i].id})'>Modifier</button></td></tr>`;
        }
        $("#machines").html(ligne);
    }
});


