<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="ui segment">
<br>
<br><sec:authorize access="hasRole('ADMIN')">
	<a
	href="<c:url value="/faculty/addFaculty"></c:url>"><b>Καταχώρηση νέου τμήματος</b></a>
	</sec:authorize>
	<h3>${pageTitle}</h3>
	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Όνομα Τμήματος</th>
			<th>Πανεπιστήμιο</th>
			<th>Χώρα</th>
			<th>Πόλη</th>
			<th>Ισοδύναμο Τμήμα</th>
			<th>Γλώσσα Διδασκαλίας</th>
			<th>Σύνολο θέσεων</th>
			<th>Διαθέσιμες θέσεις</th>
			<th>Στοιχεία Επικοινωνίας</th>
			<th>Ενέργειες</th>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempFaculty" items="${faculties}">
			<tr>
				<td>${tempFaculty.name}</td>
				<td>${tempFaculty.university}</td>				
				<td>${tempFaculty.country}</td>				
				<td>${tempFaculty.city}</td>
				<td>${tempFaculty.department}</td>
				<td>${tempFaculty.language}</td>
				<td>${tempFaculty.totalNumberOfSpots}</td>
				<td>${tempFaculty.numberOfSpotsAvailable}</td>
				<td>${tempFaculty.contactInfo}</td>				
				<td><a style="color:SlateBlue;"
					href="<c:url value="/application/faculty/${tempFaculty.id}/list"></c:url>">Λίστα Κατάταξης</a>
					<br>
					<br>
					<sec:authorize access="hasRole('ADMIN')">
					<a
					href="<c:url value="/faculty/${tempFaculty.id}"></c:url>">Ενημέρωση στοιχείων</a>					
					<br>
					<br>
					<a style="color:Tomato;"
					href="<c:url value="/faculty/delete/${tempFaculty.id}"></c:url>">Διαγραφή τμήματος</a>
					</sec:authorize>										
				</td>					
			</tr>
		</c:forEach>
	</table>
</div>
