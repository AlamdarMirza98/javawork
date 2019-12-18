<%@ include file="layout/header.jsp"%>
<div class="container">
		<div class="row">
			<div class="col-10">
				<form method="post" action="/add-author">
				<fieldset>
				<legend>Author Registration Form</legend>
					<div class="form-group">
						<label for="name">Name</label> 
						<input type="text" name="name"class="form-control" placeholder="Enter name">
					</div>
					<div class="form-group">
						<label for="email">Email</label> 
						<input type="text" name="email" class="form-control" placeholder="Enter email">
					</div>

					<div class="form-group">
						<label for="phone">Phone</label> 
						<input type="text" name="phone" class="form-control" placeholder="Enter phone">
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>
				</fieldset>
				</form>
			</div>
		</div>
	</div>
<%@ include file="layout/footer.jsp"%>