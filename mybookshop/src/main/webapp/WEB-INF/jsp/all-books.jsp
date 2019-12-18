	<%@ include file = "layout/header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-10">
				<c:forEach items="${books}" var="book">
					<div class="card my-2 bg-info text-white">
						<div class="card-header">${book.title}
						<a href="/delete?id=${book.id}"><i class="fa fa-times float-right" aria-hidden="true"></i></a>
						<a href="/edit?id=${book.id}"><i class="fa fa-pencil-square-o float-right mx-1" aria-hidden="true"></i></a>
						</div>
						<div class="card-body">
							<ul class="list-group text-dark">
								<li class="list-group-item">Author: ${author.name}</li>
								<li class="list-group-item">Price: £${book.price}</li>
							</ul>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
	<%@ include file="layout/footer.jsp" %>