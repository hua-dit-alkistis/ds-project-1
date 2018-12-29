<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="ui segment">
<br> 
<br>
	<a href="<c:url value="/secretary/addMember"></c:url>"><b>Καταχώρηση νέου μέλους</b></a>
	<h3>${pageTitle}</h3>
	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Επώνυμο</th>
			<th>Όνομα</th>
			<th>Email</th>
			<th>Τμήμα</th>
			<th>Ενέργειες</th>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempMember" items="${members}">

			<tr>
				<td>${tempMember.lastName}</td>
				<td>${tempMember.firstName}</td>
				<td>${tempMember.email}</td>
				<td>${tempMember.department}</td>
				<td>
						<a href="<c:url value="/secretary/${tempMember.id}"></c:url>">Ενημέρωση στοιχείων</a>
				<br> <br>
						<a style="color: Tomato;"
							href="<c:url value="/secretary/delete/${tempMember.id}"></c:url>">Διαγραφή χρήστη</a>
			</tr>
		</c:forEach>
	</table>
</div>