<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="ui segment">
<br>
	<h3>${pageTitle}</h3>
	<form:form action="saveApplication" modelAttribute="application" method="POST" class="ui form">
		<sec:authorize access="hasAnyRole('USER','ADMIN')">
		<div class="field">
			<label>Κατάσταση</label> 
			<select name="status">
				<option value="approved">Εγκεκριμένη</option>
				<option value="disapproved">Μη εγκεκριμένη</option>
				<option value="unchecked">Υπό έλεγχο</option>
			</select>
		</div>
		</sec:authorize>
		<button class="ui button" type="submit">Αποθήκευση</button>
	</form:form>
</div>