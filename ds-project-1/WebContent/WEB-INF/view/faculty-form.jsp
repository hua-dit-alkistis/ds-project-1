<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="ui segment">
<br>
	<h3>${pageTitle}</h3>

	<form:form action="saveFaculty" modelAttribute="faculty" method="POST" class="ui form">
		<div class="field">
			<label>Όνομα Τμήματος</label> 
			<form:input path="name"/>
		</div>
		<div class="field">
			<label>Πανεπιστήμιο</label>
			<form:input path="university"/>
		</div>
		<div class="field">
			<label>Συνεργαζόμενο τμήμα</label> 
			<select name="department">
				<option value="Informatics">Πληροφορικής και Τηλεματικής</option>
				<option value="Home Economics">Οικιακής Οικονομίας & Οικολογίας</option>
				<option value="Health Science">Επιστήμης Διαιτολογίας - Διατροφής</option>
				<option value="Geography">Γεωγραφίας</option>				
			</select>
		</div>
		<div class="field">
			<label>Χώρα</label> 
			<form:input path="country"/>
		</div>
		<div class="field">
			<label>Πόλη</label> 
			<form:input path="city"/>
		</div>
		<div class="field">
			<label>Γλώσσα Διδασκαλίας</label> 
			<form:input path="language"/>
		</div>
		<div class="field">
			<label>Σύνολο θέσεων</label> 
			<form:input path="totalNumberOfSpots"/>
		</div>
		<div class="field">
			<label>Υπόλοιπο διαθέσιμων θέσεων</label> 
			<form:input path="numberOfSpotsAvailable"/>
		</div>
		<div class="field">
			<label>Στοιχεία Επικοινωνίας</label> 
			<form:input path="contactInfo"/>
		</div>
		
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>