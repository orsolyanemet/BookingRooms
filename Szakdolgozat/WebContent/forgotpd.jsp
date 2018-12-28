<!--Nemet Orsolya, noim1553-->
<!DOCTYPE html>
<html>
<head>
	<title>Forgotten Password</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="styles/login.css">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
                <div class="card-header">
                  <h3><i class="fa fa-lock fa-4x"></i></h3>
                  <h3>Forgot Password?</h3>
                  <p>You can reset your password here.</p>
                 </div>
                 <div class="card-body">
                    <form action="forgotpd.do" method="POST">
                      <div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-at"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="email">
					</div>
                    <div class="form-group">
                      <input type="submit" value="Reset password" class="btn float-right reset_btn">
                    </div>
                    </form>
                  </div>
          </div>
	</div>
</div>
</body>
</html>