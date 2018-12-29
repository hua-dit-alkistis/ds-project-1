<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="ui segment">
	<br> <br>
	<sec:authorize access="hasRole('ADMIN')">
		<a href="<c:url value="/student/addStudent"></c:url>"><b>Καταχώρηση νέου φοιτητή</b></a>
	</sec:authorize>
	<h3>${pageTitle}</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Όνομα</th>
			<th>Επωνυμο</th>
			<th>Email</th>
			<th>Αριθμός μητρώου</th>
			<th>Τμήμα</th>
			<th>Έτος φοίτησης</th>
			<th>Ενέργειες</th>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempStudent" items="${students}">

			<tr>
				<td>${tempStudent.firstName}</td>
				<td>${tempStudent.lastName}</td>
				<td>${tempStudent.email}</td>
				<td>${tempStudent.id}</td>
				<td>${tempStudent.department}</td>
				<td>2018 - ${tempStudent.yearOfRegistration}</td>
				<td>
					<sec:authorize access="hasRole('ADMIN')">
						<a
							href="<c:url value="/student/${tempStudent.id}"></c:url>">Ενημέρωση
							στοιχείων</a>
					</sec:authorize> 
					<br> 
					<br> 
					<sec:authorize access="hasRole('ADMIN')">
						<a style="color: Tomato;"
							href="<c:url value="/student/delete/${tempStudent.id}"></c:url>">Διαγραφή φοιτητή</a>
					</sec:authorize>
			</tr>
		</c:forEach>
	</table>
</div>
