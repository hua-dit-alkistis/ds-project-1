<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<img src="${pageContext.request.contextPath}/resources/img/erasmus.png" alt="Erasmus" width="1532" height="452">
<div class="ui segment">
	<h3>Συνεργαζόμενα Εκπαιδευτικά Ιδρύματα</h3>
	<br>
	<a
	href="<c:url value="/faculty/list/Informatics"></c:url>"><b>Πληροφορικής και Τηλεματικής</b></a>
	<br>
	<br>
	<a
	href="<c:url value="/faculty/list/HomeEconomics"></c:url>"><b>Οικιακής Οικονομίας & Οικολογίας</b></a>
	<br>
	<br>
	<a
	href="<c:url value="/faculty/list/HealthScience"></c:url>"><b>Επιστήμης Διαιτολογίας - Διατροφής</b></a>
	<br>
	<br>
	<a
	href="<c:url value="/faculty/list/Geography"></c:url>"><b>Γεωγραφίας</b></a>
</div>
