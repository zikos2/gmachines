console.log("Visualiser");

function fillSalles(data){
	let salles = "";
	data.forEach(salle=>{
			salles += salleCard(salle)
	})
	
	 
	 $("#sallesList").html(salles);
}

const salleCard = (data)=>{
	return `
		<div class="col-md-4 stretch-card">
			<div class="card">
				<button class="btn salleBtn" onclick="fillMachines(${data.id})">
					<h5 class="text-titlecase">Salle: ${data.code}</h5>
					<p class="text-titlecase">type: ${data.type}</p>
				</button>
			</div>
		</div>
	`
}

const machineCard = (data)=>{
	return `
		<div class="col-md-4 stretch-card">
			<div style="background-color:${data.status === "on" ? "#c5ffc5" : "#ffc5c5"}" class="card">
				<button class="btn" onclick="fillMachines(${data.id})">
					<h5 class="text-titlecase">Machine: ${data.reference}</h5>
					<p class="text-titlecase">date d'achat: ${data.dateAchat}</p>
				</button>
			</div>
		</div>
	`;
};


async function fillMachines(id){
	const response = await fetch(`/GMachineAajax/MachineController?op=findBySalle&idSalle=${id}`);
	const data = await response.json();
	
	console.log(data);
	let machines = "";
	data.forEach(machine=>{
			machines += machineCard(machine)
	})
	
	 
	 $("#machinesList").html(machines);
}


$(document).ready(function() {

	fetch("/GMachineAajax/Salle?op=load")
		.then((res) => res.json())
		.then((data) => {
			console.log(data);
			fillSalles(data);
		})
		.catch(err => console.log(err));

});