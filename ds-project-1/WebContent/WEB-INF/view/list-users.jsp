<div class="ui segment">
<br>
<br>
<a
	href="<c:url value="/user/addUser"></c:url>"><b>Καταχώρηση νέου χρήστη</b></a>
	<h3>${pageTitle}</h3>
	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Όνομα χρήστη</th>
			<th>Ενέργειες</th>
		</thead>
		<!-- loop over and print our students -->
		<c:forEach var="tempUser" items="${users}">
			<tr>
				<td>${tempUser.username}</td>
				<td><a href="<c:url value="/user/assignRole/${tempUser.username}"></c:url>"><i
						class="add user icon"></i>Καταχώρηση ρόλου</a></td>
			</tr>
		</c:forEach>
	</table>
</div>