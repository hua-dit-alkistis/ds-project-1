<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<img src="${pageContext.request.contextPath}/resources/img/erasmus.png" alt="Erasmus" width="1532" height="452">
<div class="ui segment">
  <h2>Συνεισφέρετε στον έλεγχο δηλώσεων</h2>
  <a href="${pageContext.request.contextPath}/application/list/approved" ><b>Εγκεκριμένες</b></a>
  <br>
  <a href="${pageContext.request.contextPath}/application/list/disapproved" ><b>Μη εγκεκριμένες</b></a>
  <br>
  <a href="${pageContext.request.contextPath}/application/list/unchecked" ><b>Υπό έλεγχο</b></a>
  <br>
  <br>
  <a style="color:SlateBlue;" 
  href="<c:url value="/application/list"></c:url>">Δείτε όλες τις δηλώσεις του εξαμήνου</a>	
</div>