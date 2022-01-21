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
											<h5 class="mb-2 text-titlecase mb-4">Salles</h5>
											<div class="row">
												<form id="addSalleForm" class="form-sample"
													style="width: 100%">
													<div class="row">
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Code </label>
																<div class="col-sm-9">
																	<input type="text" id=code class="form-control" />
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group row">
																<label class="col-sm-3 col-form-label">Type</label>
																<div class="col-sm-9">
																	<input type="text" id="type" class="form-control" />
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
											<div class="row">
												<div class="table-responsive">
													<table class="table table-hover">
														<thead>
															<tr>
																<th>ID</th>
																<th>Code</th>
																<th>Type</th>
															</tr>
														</thead>
														<tbody id="salles">


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
						<form id="updateSalleForm" class="form-sample" style="width: 100%">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Code </label>
										<div class="col-sm-9">
											<input type="hidden" id="idSalle" class="form-control" /> 
											<input
												type="text" id="modalCode" class="form-control" />
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Type</label>
										<div class="col-sm-9">
											<input type="text" id="modalType" class="form-control" />
										</div>
									</div>
								</div>
							</div>
						</form>

					</div>
					<div class="modal-footer">
						<button id="updateSalle" type="button" class="btn btn-primary">Update
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
	<script src="../script/sallesPage.js"></script>
	<!-- End custom js for this page-->
</body>

</html>

