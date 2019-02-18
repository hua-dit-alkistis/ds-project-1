<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="ui segment">
<br>
<h3>${pageTitle}</h3>
<table class="ui celled  striped table">
		<thead>
			<th>Ημερομηνία υποβολής</th>			
			<th>Όνομα</th>
			<th>Επώνυμο</th>
			<th>Αριθμός μητρώου</th>
			<th>Τρέχον εξάμηνο</th>
			<th>Τμήμα</th>
			<th>Συνεργαζόμενο τμήμα</th>
			<th>Διαθέσιμες θέσεις</th>
			<th>Γλώσσα Διδασκαλίας</th>
			<th>Γλωσσική Υποστήριξη</th>
			<th>Υπόλοιπο Μαθημάτων</th>
			<th>Κατάσταση</th>
			<th>Ενέργειες</th>
		</thead>
		<c:forEach var="tempApplication" items="${applications}">
			<tr>
				<td>${tempApplication.dateOfSubmission}</td>								
				<td>${tempApplication.student.firstName}</td>	
				<td>${tempApplication.student.lastName}</td>			
				<td>${tempApplication.student.id}</td>
				<td>${tempApplication.currentSemester}</td>
				<td>${tempApplication.department}</td>
				<td>${tempApplication.nameOfFaculty}</td>
				<td>${tempApplication.faculty.numberOfSpotsAvailable}</td>
				<td>${tempApplication.faculty.language}</td>
				<td>${tempApplication.languageCertification}</td>
				<td>${tempApplication.student.numberOfRemainingClasses}</td>
				<td>${tempApplication.status}</td>
				<td><a
					href="<c:url value="/application/${tempApplication.id}/approve"></c:url>">Έγκριση</a>					
					<br>
					<br>
					<a style="color:Tomato;"
					href="<c:url value="/application/${tempApplication.id}/disapprove"></c:url>">Απόρριψη</a></td>
			</tr>
		</c:forEach>
</table>			
</div>