<html>
<head>
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"> -->
<link rel="stylesheet" href="theme.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<!-- Include chart.js for the reports visualization -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/0.2.0/Chart.min.js"></script>

<link rel="stylesheet" href="global.css">

<style>
textarea {
	resize: none;
}
</style>
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top bar-logo"
		role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" href="./news.html"><span
				class="glyphicon glyphicon-tree-deciduous" aria-hidden="true"></span>
				PhinkeyHR</a>
		</div>
	</nav>
	<nav class="navbar navbar-default navbar-fixed-top bar-nav"
		role="navigation">
		<div>
			<ul class="nav navbar-nav">
				<li><a href="./news.html">News Feed</a></li>
				<li><a href="./details.html">My Info</a></li>
				<li><a href="./employees.html">Employees</a></li>
				<li><a href="./applications.html">Applications</a></li>
				<li class="active"><a href="./reports.html">Reports</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse"
									data-parent="#accordion" href="#collapseOne"
									aria-expanded="true" aria-controls="collapseOne"
									style="text-decoration: none;"> Birthdays by Month </a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								<canvas id="birthdays" width="800" height="400"></canvas>
								<div style="margin-top: 10px; text-align: right;">
									<button id="save-btn-birthdays" type="button"
										class="btn btn-default">
										<span class="glyphicon glyphicon-floppy-save"
											aria-hidden="true"></span> Save as Image
									</button>
									<button type="button" class="btn btn-default print">
										<span class="glyphicon glyphicon-print" aria-hidden="true"></span>
										Print
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingTwo">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse"
									data-parent="#accordion" href="#collapseTwo"
									aria-expanded="false" aria-controls="collapseTwo"
									style="text-decoration: none;"> Total Salary Expenses by
									Month </a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="headingTwo">
							<div class="panel-body">
								<canvas id="salary" width="800" height="400"></canvas>
								<div style="margin-top: 10px; text-align: right;">
									<button id="save-btn-salary" type="button"
										class="btn btn-default">
										<span class="glyphicon glyphicon-floppy-save"
											aria-hidden="true"></span> Save as Image
									</button>
									<button type="button" class="btn btn-default print">
										<span class="glyphicon glyphicon-print" aria-hidden="true"></span>
										Print
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingThree">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse"
									data-parent="#accordion" href="#collapseThree"
									aria-expanded="false" aria-controls="collapseThree"
									style="text-decoration: none;"> Current Salary by Employee
								</a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="headingThree">
							<div class="panel-body">
								<div class="panel-body">
									<canvas id="employees" width="800" height="400"></canvas>
									<div style="margin-top: 10px; text-align: right;">
										<button id="save-btn-employees" type="button"
											class="btn btn-default">
											<span class="glyphicon glyphicon-floppy-save"
												aria-hidden="true"></span> Save as Image
										</button>
										<button type="button" class="btn btn-default print">
											<span class="glyphicon glyphicon-print" aria-hidden="true"></span>
											Print
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		// birthdays chart
		var birthdaysData = {
			labels : [ "January", "February", "March", "April", "May", "June",
					"July", "August", "September", "October", "November",
					"December" ],
			datasets : [ {
				data :
	<%= request.getAttribute("birthdayData") %>
		//[1, 5, 6, 2, 8, 0, 1, 1, 2, 1, 10, 1]
			} ]
		};
		var birthdaysCanvas = document.getElementById("birthdays");
		var birthdaysCtx = birthdaysCanvas.getContext("2d");
		var birthdaysChart = new Chart(birthdaysCtx).Bar(birthdaysData, {
			scaleGridLineWidth : 2,
			scaleOverride : true,
			scaleStartValue : 0,
			scaleStepWidth : 1,
			scaleSteps : 15
		});
		$('#save-btn-birthdays').click(function() {
			var birthdaysImage = birthdaysCanvas.toDataURL("image/png");
			var tab = window.open(birthdaysImage, '_blank');
			tab.focus();
		});

		// total salary chart
		var salaryData = {
			labels : [ "January", "February", "March", "April", "May", "June",
					"July", "August", "September", "October", "November",
					"December" ],
			datasets : [ {
				data :
	<%= request.getAttribute("salaryExpenses") %>
		//[120000, 125000, 125000, 125000, 140000, 110000, 110000, 160000, 200000, 200000, 210000, 190000]
			} ]
		};
		var salaryCanvas = document.getElementById("salary");
		var salaryCtx = salaryCanvas.getContext("2d");
		var salaryChart = new Chart(salaryCtx).Bar(salaryData, {
			scaleGridLineWidth : 2,
			scaleOverride : true,
			scaleStartValue : 0,
			scaleStepWidth : 20000,
			scaleSteps : 15
		});
		$('#save-btn-salary').click(function() {
			var salaryImage = salaryCanvas.toDataURL("image/png");
			var tab = window.open(salaryImage, '_blank');
			tab.focus();
		});

		// employees chart
		var employeesData = {
			labels : <%= request.getAttribute("employees") %>,//[ "Mario Ampov", "Blagoja Evkoski", "Milan Nedeljkovic","Hristina Todevska" ],
			datasets : [ {
				data : <%= request.getAttribute("salaries") %>//[ 84000, 75000, 64000, 75000 ]
			} ]
		};
		var employeesCanvas = document.getElementById("employees");
		var employeesCtx = employeesCanvas.getContext("2d");
		var employeesChart = new Chart(employeesCtx).Bar(employeesData, {
			scaleGridLineWidth : 2,
			scaleOverride : true,
			scaleStartValue : 0,
			scaleStepWidth : 6000,
			scaleSteps : 15
		});
		$('#save-btn-employees').click(function() {
			var employeesImage = employeesCanvas.toDataURL("image/png");
			var tab = window.open(employeesImage, '_blank');
			tab.focus();
		});

		// handle printing
		$('.print').click(function() {
			window.print();
		});
	</script>

</body>
</html>