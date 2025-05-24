<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5 style="width:40%"">
    <div class="card shadow">
        <div class="card-header bg-success text-white text-center">
            <h2>Create Account</h2>
        </div>
        <div class="card-body">
            <form action="SignUpServlet" method="post">
                <div class="mb-3">
                    <label class="form-label">Username</label>
                    <input type="text" name="username" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" required>
                </div>

                <input type="hidden" name="role" value="Employee">

                <button type="submit" class="btn btn-success w-100">Sign Up</button>
            </form>
            <div class="mt-3 text-center">
                <a href="login.jsp">Already have an account? Login</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
