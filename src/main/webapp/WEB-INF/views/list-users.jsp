
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<br>

<div class="container">
	
	<table class="table table-striped">
		<caption><spring:message code="todo.caption" /></caption>
		
	</table>
	
	
	 <div class="content-wrapper">
        <section class="content">
          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title"></h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <table id=example class="table table-bordered table-striped">
                   <thead>
			<tr>
				<th>First Name</th>
				<th>Last name</th>
				<th>Age</th>
				<th>Operation </th>
			</tr>
		</thead>
		
                    
                    <tbody>
			<c:forEach items="${studentObj}" var="obj">
				<tr>
					<td>${obj.firstName}</td>
					<td>${obj.lastName}</td>
					<td>${obj.age}</td>
					<td><a type="button" class="btn btn-primary"
						href="/update-user?id=${obj.id}">Edit</a> <a type="button"
						class="btn btn-warning" href="/delete-user?id=${obj.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
                    
                   <tfoot>
              <tr>
               <th>First Name</th>
				<th>Last name</th>
				<th>Age</th>
				<th>Operation </th>
                      </tr>
                    </tfoot>
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div><!-- /.col -->
          </div><!-- /.row -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
	<div>
		<a type="button" class="btn btn-success" href="/add-user">Add</a>
	</div>
	
</div>

<%@ include file="common/footer.jspf"%>
