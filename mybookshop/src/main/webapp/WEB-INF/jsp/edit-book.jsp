<%@ include file="layout/header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-10">
				<form method="post" action="/edit">
				<fieldset>
				<legend>Update Book Form</legend>
					<input type="hidden" name="id" value="${book.id}">
					<div class="form-group">
						<label for="title">Title</label> <input type="text" name="title" value=${book.title}
							class="form-control">
					</div>
					<div class="form-group">
						<label for="author">Author</label> <input type="text"
							name="author"  value="${book.author}"class="form-control">
					</div>

					<div class="form-group">
						<label for="price">Price</label> <input type="text" name="price" value="${book.price}"
							class="form-control">
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>
				</fieldset>
				</form>

			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>