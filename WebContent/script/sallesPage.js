const deleteSalle = (id)=>{

		fetch(`/GMachineAajax/Salle?op=del&id=${id}`,{methode: "POST"})
		.then(res=>res.json())
		.then(data=>console.log(data))
		.catch(err=>console.log(err));
}

function fillModal(id){




		fetch(`/GMachineAajax/Salle?op=find&id=${id}`,{methode: "POST"})
		.then(res=>res.json())
		.then(data=>{
		const salleId = document.querySelector("#idSalle");
		const modalCode = document.querySelector("#modalCode");
		const modalType = document.querySelector("#modalType");
		console.log(data)
		
		modalCode.value = data.code;
		modalType.value = data.type;
		salleId.value = data.id;;
		})
		.catch(err=>console.log(err));
	}


$(document).ready(function () {
	const addForm = document.querySelector("#addSalleForm");
	
	/*
	* Modal control
	*/
	
	
	/*
	* Add Salle
	*/
	addForm.addEventListener("submit",(e)=>{
	e.preventDefault();
		const code = document.querySelector("#code").value;
		const type = document.querySelector("#type").value;
		
		
		fetch(`/GMachineAajax/Salle?op=add&code=${code}&type=${type}`,{
			methode: "POST",
		})
		.then(res => res.json())
		.then(data => console.log(data))
		.catch(err=>console.log(err))
		
	
	});
	
	/*
	*Update Salle
	*/
	document.querySelector("#updateSalle").addEventListener("click",(e)=>{
	    const modalCode = document.querySelector("#modalCode").value;
		const modalType = document.querySelector("#modalType").value;
		const salleId = document.querySelector("#idSalle").value;
		
		
		fetch(`/GMachineAajax/Salle?op=update&code=${modalCode}&type=${modalType}&salleId=${salleId}`,{
			method: "POST",
		})
		.then(res => res.json())
		.then(data => console.log(data))
		.catch(err=>console.log(err))
	
	
	})
	
	



	fetch("/GMachineAajax/Salle?op=load")
	.then((res)=> res.json())
	.then((data)=> {
	console.log(data);
		remplir(data);
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
            ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].code + "</td><td>" + data[i].type + `</td><td><button class="btn btn-danger" onclick='deleteSalle(${data[i].id})'>X</button></td><td><button type='button' class='btn btn-warning' data-toggle='modal' data-target='#exampleModal' onclick='fillModal(${data[i].id})'>Modifier</button></td></tr>`;
        }
        $("#salles").html(ligne);
    }

	
    
});


