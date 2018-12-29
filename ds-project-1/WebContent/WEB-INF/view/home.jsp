<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="ui segment">
<img src="${pageContext.request.contextPath}/resources/img/erasmus.png" alt="Erasmus" width="1490" height="430">
<div class="home">
  <h2>Ζήστε μία αξέχαστη φοιτητική εμπειρία!</h2>
  <p>Δηλώστε συμμετοχή στο Πρόγραμμα Μαθησιακής Κινητικότητας και κυνηγήστε τα όνειρα σας 
  σε καταρτισμένα Εκπαιδευτικά Ιδρύματα του εξωτερικού.</p>
  <a href="${pageContext.request.contextPath}/student/submitApplication/{id}" 
  target="_blank"><b>Υπεύθυνη Δήλωση Συμμετοχής 2018-2019</b></a>
</div>
<sec:authorize access="hasAnyRole('USER','ADMIN')">
<div class="home">
  <h2>Συνεισφέρετε στον έλεγχο δηλώσεων</h2>
  <a href="${pageContext.request.contextPath}/application/list/approved" >Εγκεκριμένες</a>
  <br>
  <a href="${pageContext.request.contextPath}/application/list/disapproved" >Μη εγκεκριμένες</a>
  <br>
  <a href="${pageContext.request.contextPath}/application/list/unchecked" >Υπό έλεγχο</a>
</div>
</sec:authorize>
</div>