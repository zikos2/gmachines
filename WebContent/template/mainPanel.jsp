<div class="main-panel">
	<div class="content-wrapper">

		<div class="row h-150px">
			<div class="col-xl-12 grid-margin stretch-card flex-column">
				<h5 class="mb-2 text-titlecase mb-4">Machines par salle</h5>
				<div class="row h-100">
					<div class="col-md-12 stretch-card">
						<div class="card">
							<div class="card-body">
								<div
									class="d-flex justify-content-between align-items-start flex-wrap">
									<div>
										<p class="mb-3">Nombre des machines par salle</p>
									</div>

								</div>
								<canvas id="machinesCount"></canvas>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>




		<div class="row">
			<div class="col-xl-4 grid-margin stretch-card flex-column">
				<h5 class="mb-2 text-titlecase mb-4">Machines status</h5>
				<div class="">
					<div class=" grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<div class="chartjs-size-monitor">
									<div class="chartjs-size-monitor-expand">
										<div class=""></div>
									</div>
									<div class="chartjs-size-monitor-shrink">
										<div class=""></div>
									</div>
								</div>
								<canvas id="sales-chart-c" class="mt-2 chartjs-render-monitor"
									style="display: block; width: 277px; height: 138px;"
									width="277" height="138"></canvas>
								<div
									class="d-flex align-items-center justify-content-between border-bottom pb-3 mb-3 mt-4">
									<div
										class="d-flex flex-column justify-content-center align-items-center">
										<p class="text-muted">On</p>
										<h5 id="machinesOncount"></h5>
									</div>
									<div
										class="d-flex flex-column justify-content-center align-items-center">
										<p class="text-muted">Off</p>
										<h5 id="machinesOffcount"></h5>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xl-8 grid-margin stretch-card flex-column">
				<h5 class="mb-2 text-titlecase mb-4">Total par salle</h5>
				<div class="row h-100">
					<div class="col-md-12 stretch-card">
						<div class="card">
							<div class="card-body">
								<div
									class="d-flex justify-content-between align-items-start flex-wrap">
									<div>
										<p class="mb-3">Prix total des machines par salle</p>
									</div>

								</div>
								<canvas id="sumPerSalleChart"></canvas>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>
	<!-- content-wrapper ends -->
	<!-- partial:partials/_footer.html -->
	<%@include file="footer.jsp"%>
	<!-- partial -->
</div>