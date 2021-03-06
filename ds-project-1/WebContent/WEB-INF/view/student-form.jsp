<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="ui segment">
<br>
	<h3>${pageTitle}</h3>

	<form:form action="saveStudent" modelAttribute="student" method="POST"
		class="ui form">
		<div class="field">
			<label>Επώνυμο</label>
			<form:input path="lastName" />
		</div>
		<div class="field">
			<label>Όνομα</label>
			<form:input path="firstName" />
		</div>
		<div class="field">
			<label>Όνομα χρήστη</label>
			<form:input path="username" />
		</div>
		<div class="field">
			<label>Email</label>
			<form:input path="email" />
		</div>
		<div class="field">
			<label>Όνομα Πατρός</label>
			<form:input path="nameOfFather" />
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
			<label>Έτος έναρξης σπουδών</label>
			<form:input path="yearOfRegistration" />
		</div>
		<div class="field">
			<label>Έτος γέννησης</label>
			<form:input path="yearOfBirth" />
		</div>
		<div class="field">
			<label>Υπόλοιπο μαθημάτων</label> 
			<form:input path="numberOfRemainingClasses"/>
		</div>

		<button class="ui button" type="submit">Save</button>
	</form:form>
</div>