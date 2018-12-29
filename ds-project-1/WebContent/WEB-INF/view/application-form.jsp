<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="ui segment">
<br>
	<h3>${pageTitle}</h3>
	<form:form action="saveApplication" modelAttribute="application" method="POST" class="ui form">
		<div class="field">
			<label>Όνομα</label> 
			<form:input path="firstName"/>
		</div>
		<div class="field">
			<label>Επώνυμο</label> 
			<form:input path="lastName"/>
		</div>	
		<div class="field">
			<label>Email</label> 
			<form:input path="email"/>
		</div>
		<div class="field">
			<label>Τρέχον Εξάμηνο</label> 
			<select name="currentSemester">
				<option value="5th-6th">5ο - 6ο</option>
				<option value="7th-8th">7ο - 8ο</option>
			</select>
		</div>
		<div class="field">
			<label>Τμήμα</label> 
			<select name="department">
				<option value="Informatics">Πληροφορικής και Τηλεματικής</option>
				<option value="Home Economics">Οικιακής Οικονομίας & Οικολογίας</option>
				<option value="Health Science">Επιστήμης Διαιτολογίας - Διατροφής</option>
				<option value="Geography">Γεωγραφίας</option>				
			</select>
		</div>
		<div class="field">
			<label>Όνομα Συνεργαζόμενου Τμήματος</label> 
			<select name="facultyId" name="nameOfFaculty">
				<c:forEach items="${faculties}" var="tempFaculty">
					<option value="${tempFaculty.id}">${tempFaculty.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="field">
			<label>Πανεπιστήμιο</label>
			<form:input path="university"/>
		</div>
		<div class="field">
			<label>Πιστοποιητικό ξένης γλώσσας</label> 
			<form:input path="languageCertification"/>
		</div>
		<div class="field">
			<label>Υπόλοιπο μαθημάτων</label> 
			<form:input path="numberOfRemainingClasses"/>
		</div>
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
		<button class="ui button" type="submit">Υποβολή</button>
	</form:form>
</div>