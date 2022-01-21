$(document).ready(function () {
	const sallesList = document.getElementById("salles");
	fetch("/GMachineAajax/Salle?op=load")
	.then((res)=> res.json())
	.then((data)=> {
		data.map((salle)=>{
			const option = document.createElement("option");
			option.value = salle.id;
			option.innerText = salle.code;
			sallesList.appendChild(option);
		})
	})
	.catch(err=>console.log(err));



	fetch("/GMachineAajax/MachineController?op=load")
	.then((res)=>res.json())
	.then((data)=>{
	console.log(data);
	  remplir(data);
	})
	.catch((err)=>console.log(err));


    $.ajax({
        url : "MachineController",
        data:{op:"load"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            remplir(data);
        }
    });
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
            ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].reference + "</td><td>" + data[i].dateAchat + "</td><td>" + data[i].prix + "</td><td>" + data[i].salle.code + "</td><td><button onclick='delete(data[i].id)'>X</button></td><td><button>Modifier</button></td></tr>";
        }
        $("#machines").html(ligne);
    }
});


