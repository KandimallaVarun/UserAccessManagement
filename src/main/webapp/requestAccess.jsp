<!DOCTYPE html>
<html>
<head>
    <title>Request Access - Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4">Request Software Access</h2>

    <form action="RequestServlet" method="post">
        <div class="mb-3">
            <label class="form-label">Software Name</label>
            <input type="text" name="softwareName" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Access Type</label>
            <select name="accessType" class="form-select" required>
                <option value="Read">Read</option>
                <option value="Write">Write</option>
                <option value="Admin">Admin</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Reason</label>
            <textarea name="reason" class="form-control" rows="3" required></textarea>
        </div>

        <button type="submit" class="btn btn-primary">Submit Request</button>
        <a href="login.jsp" class="btn btn-secondary ms-2">Cancel</a>
    </form>
</div>

</body>
</html>
