<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<br><br><br>
<div class="container">
	<form:form method="post" commandName="studentObj">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" type="text" class="form-control" />
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName" type="text" class="form-control" required="required" />
			<form:errors path="lastName" cssClass="text-warning" />
			<form:label path="age">Age </form:label>
			<form:input path="age" type="text" class="form-control" required="required" />
		</fieldset>
		
		<button type="submit" class="btn btn-success">Submit</button>
		
		
		
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>

<script>
	$('#targetDate').datepicker({
		format : 'dd/mm/yyyy'
	});
</script>
