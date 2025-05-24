<!DOCTYPE html>
<html>
<head>
    <title>Create Software - Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4">Create New Software</h2>

    <form action="SoftwareServlet" method="post">
        <div class="mb-3">
            <label class="form-label">Software Name</label>
            <input type="text" name="name" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Description</label>
            <textarea name="description" class="form-control" rows="3" required></textarea>
        </div>

        <div class="mb-3">
            <label class="form-label">Access Levels</label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="accessLevels" value="Read">
                <label class="form-check-label">Read</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="accessLevels" value="Write">
                <label class="form-check-label">Write</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="accessLevels" value="Admin">
                <label class="form-check-label">Admin</label>
            </div>
        </div>

        <button type="submit" class="btn btn-danger">Add Software</button>
        <a href="login.jsp" class="btn btn-secondary ms-2">Cancel</a>
    </form>
</div>

</body>
</html>
