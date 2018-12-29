<div class="ui segment">
<br>
	<h3>Login</h3>


	<form:form action="${pageContext.request.contextPath}/authUser"
		method="POST" class="ui form">
		<c:if test="${param.error != null}">
			<div class="ui negative message">
				<i class="close icon"></i>
				<div class="header">Oops!</div>
				<p>Either username or password is invalid</p>
			</div>
		</c:if>
		
		<c:if test="${param.logout != null}">
			<div class="ui info message">
				<i class="close icon"></i>
				<div class="header">Goodbye!</div>
				<p>You have been logged out!</p>
			</div>
		</c:if>
		<div class="field">
			<label>Username</label> <input type="text" name="username" />
		</div>
		<div class="field">
			<label>Password</label> <input type="password" name="password" />
		</div>
		<div class="field">
			<input type="submit" value="Login" />
		</div>
	</form:form>

</div>

<script>
$('.close')
.on('click', function() {
  $(this)
    .closest('.message')
    .transition('fade')
  ;
})
;
</script>