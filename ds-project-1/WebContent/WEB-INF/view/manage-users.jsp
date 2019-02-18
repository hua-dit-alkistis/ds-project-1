<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<img src="${pageContext.request.contextPath}/resources/img/erasmus.png" alt="Erasmus" width="1532" height="452">
<div class="ui segment">
	<h3>Διαχείριση χρηστών</h3>
	<br>
	<a
	href="<c:url value="/student/list"></c:url>"><b>Φοιτητές</b></a>
	<br>
	<br>
	<a
	href="<c:url value="/secretary/list"></c:url>"><b>Μέλη Γραμματείας</b></a>
	<br>
	<br>
	<a
	href="<c:url value="/user/list"></c:url>"><b>Λίστα χρηστών</b></a>
	<br>
</div>
