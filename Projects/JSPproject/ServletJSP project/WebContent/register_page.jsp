<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>

<style type="text/css">
.banner-background {
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 98%, 76% 87%, 44% 97%, 0 99%, 0 0);
}
</style>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/NewFile.css" rel="stylesheet" type="text/css" />





</head>
<body>

		<%@ include file="normal_navbar.jsp"%>

	<main class="primary-background  banner-background" style="padding-bottom:100px">
	<div class="container">

		<div class="col-md-6 offset-md-3">

			<div class="card">

				<div class="card-header text-center primary-background text-white">
					<span class="fa fa-3x fa-user-circle"></span> <br /> Register
					here..
				</div>

				<div class="card-body">




					<form  id="reg-form"   action="RegisterServlet" method="POST">
						<div class="form-group">
							<label for="exampleInputuname">User name</label> 
							<input
								type="text" class="form-control" id="user_name" name="user_name"
								aria-describedby="emailHelp" placeholder="Enter name">
							
						</div>
						
						<div class="form-group">
							<label for="exampleInputEmail1">Email address</label> 
							<input
								type="email" class="form-control" id="exampleInputEmail1" name="user_email"
								aria-describedby="emailHelp" placeholder="Enter email">
							<small id="emailHelp" class="form-text text-muted">We'll
								never share your email with anyone else.</small>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" id="exampleInputPassword1" name="user_password"
								placeholder="Password">
						</div>
						
							<div class="form-group">
							<label for="gender">select Gender</label>
							<br> 
							<input type="radio"  id="gender" name="gender" value="male"> Male<br>
							<input type="radio"  id="gender" name="gender" value="female"> Female
						</div>
						<div class="form-group">
						
							<textarea rows="5" class="form-control"  name="about" placeholder="Enter something about yourself"></textarea>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input"  name="check"
								id="exampleCheck1"> <label class="form-check-label"
								for="exampleCheck1">Agree term and condition</label>
						</div>
						<br/>
						<div class="container text-center" id="loader" style="display: none">
							
							<span class="fa fa-refresh fa-spin fa-4x"></span>
							<h4>please wait..</h4>
						
						</div>
						<button id="sub_btn" type="submit" class="btn btn-primary">Submit</button>
					</form>
















				</div>

				<div class="card-footer"></div>


			</div>

		</div>

	</div>
	</main>








	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

	<script src="js/javas.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.js"></script>
<!--  	<script type="text/javascript">
	 $(document).ready(function(){
		
		console.log("loaded");
		
		$("#reg-form").on('submit' , function(event){
			
			
			event.preventDefault();
			
			let form = new FormData(this);
			
			//send register servlet
			$("#sub_btn").hide();
			$("#loader").show();
			
			
			$.ajax({
				
			
			
				url:"RegisterServlet",
				type:"POST",
				data:form,
				success:function(data , textStatus , jqXHR){
					console.log(data);
					$("#sub_btn").show();
					$("#loader").hide();
					
					},
				error:function(jqXHR , textStatus , errorThrown){
					console.log(jqXHR);
					$("#sub_btn").show();
					$("#loader").hide();
					swal("someting went wrong...");
				},
				processData:false,
				contentType:false
			});
			
			
		})
		
		
	})
	</script> -->
</body>
</html>