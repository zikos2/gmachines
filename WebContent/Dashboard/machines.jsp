<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>PolluxUI Admin</title>
<!-- base:css -->
<link rel="stylesheet" href="../vendors/typicons/typicons.css">
<link rel="stylesheet" href="../vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="../css/vertical-layout-light/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="../images/favicon.png" />
</head>
<body>
	<div class="row d-none" id="proBanner">
		<div class="col-12">
			<span class="d-flex align-items-center purchase-popup">
				<p>Get tons of UI components, Plugins, multiple layouts, 20+
					sample pages, and more!</p> <a
				href="https://bootstrapdash.com/demo/polluxui/template/index.html?utm_source=organic&utm_medium=banner&utm_campaign=free-preview"
				target="_blank" class="btn download-button purchase-button ml-auto">Upgrade
					To Pro</a> <i class="typcn typcn-delete-outline" id="bannerClose"></i>
			</span>
		</div>
	</div>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<%@include file="../template/navBar.jsp"%>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_settings-panel.html -->
			<%@include file="../template/themeSettings.jsp"%>
			<!-- partial -->
			<!-- partial:partials/_sidebar.html -->
			<%@include file="../template/sideBar.jsp"%>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">

					<div class="row">
						<div class="col-xl-12 grid-margin stretch-card flex-column">
							<div class="row h-100">
								<div class="col-md-12 stretch-card">
									<div class="card">
										<div class="card-body">
											<h5 class="mb-2 text-titlecase mb-4">Machines</h5>
											<div class="row">
												<form id="addMachineForm" class="form-sample"
													style="width: 100%">
													<div class="row">
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Reference
																</label>
																<div class="col-sm-9">
																	<input type="text" id="reference" class="form-control" />
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Prix</label>
																<div class="col-sm-9">
																	<input type="text" id="prix" class="form-control" />
																</div>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Salle</label>
																<div class="col-sm-9">
																	<select id="listSalles" class="form-control">

																	</select>
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Date
																	d'achat</label>
																<div class="col-sm-9">
																	<input class="form-control" id="date" type="date"
																		placeholder="dd/mm/yyyy" />
																</div>
															</div>
														</div>
													</div>
													<div class="row flex-row-reverse">
														<button class="btn btn-primary mr-5" type="submit"
															id="addMachine">Ajouter</button>
													</div>
												</form>

											</div>
											<div class="row my-3">
												<form id="findDate" class="form-sample" style="width: 100%">
													<div class="row">
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Date
																	debut</label>
																<div class="col-sm-9">
																	<input class="form-control" id="startDate" type="date"
																		placeholder="dd/mm/yyyy" />
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Date fin</label>
																<div class="col-sm-9">
																	<input class="form-control" id="endDate" type="date"
																		placeholder="dd/mm/yyyy" />
																</div>
															</div>
														</div>
													</div>
													<div class="row flex-row-reverse">
														<button class="btn btn-primary mr-5" type="submit">Search</button>
													</div>
												</form>
											</div>
											<div class="row">
												<div class="table-responsive">
													<table class="table table-hover">
														<thead>
															<tr>
																<th>ID</th>
																<th>Référence</th>
																<th>Date Achat</th>
																<th>Prix</th>
																<th>Code Salle</th>
															</tr>
														</thead>
														<tbody id="machines">
															<tr>
																<td>Jacob</td>
																<td>Photoshop</td>
																<td class="text-danger">28.76% <i
																	class="typcn typcn-arrow-down-thick"></i></td>
																<td><label class="badge badge-danger">Pending</label></td>
															</tr>


														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="max-width: 650px" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="addMachineForm" class="form-sample" style="width: 100%">
							<div class="row">
								<div class="col-md-6">
									<input type="hidden" id="machineId" />
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Reference </label>
										<div class="col-sm-9">
											<input type="text" id="modalReference" class="form-control" />
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Prix</label>
										<div class="col-sm-9">
											<input type="text" id="modalPrix" class="form-control" />
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Salle</label>
										<div class="col-sm-9">
											<select id="modalListSalles" class="form-control">

											</select>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Date d'achat</label>
										<div class="col-sm-9">
											<input class="form-control" id="modalDate" type="date"
												placeholder="dd/mm/yyyy" />
										</div>
									</div>
									<div class="form-group row">
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio" name="status"
												id="statusOn" value="on"> <label
												class="form-check-label" for="on">On</label> <input
												class="form-check-input" type="radio" name="status"
												id="statusOff" value="off"> <label
												class="form-check-label" for="off">Off</label>
										</div>
									</div>

								</div>
							</div>


						</form>

					</div>
					<div class="modal-footer">
						<button id="updateMachine" type="button" class="btn btn-primary">Update
							changes</button>
					</div>
				</div>
			</div>
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->

	<!-- base:js -->
	<script src="../vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<script src="../vendors/chart.js/Chart.min.js"></script>
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="../js/off-canvas.js"></script>
	<script src="../js/hoverable-collapse.js"></script>
	<script src="../js/template.js"></script>
	<script src="../js/settings.js"></script>
	<script src="../js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="../js/dashboard.js"></script>
	<script src="../script/machinesPage.js"></script>
	<!-- End custom js for this page-->
</body>

</html>

