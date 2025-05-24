<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Request Access</title>
</head>
<body>
    <h2>Request Access to Software</h2>

    <form action="requestAccess" method="post">
        Software Name: <input type="text" name="softwareName" required /><br/>
        Access Type: 
        <select name="accessType" required>
            <option value="Read">Read</option>
            <option value="Write">Write</option>
            <option value="Admin">Admin</option>
        </select><br/>
        Reason: <textarea name="reason" required></textarea><br/>
        <input type="submit" value="Submit Request" />
    </form>

    <p style="color:green;"><%= request.getParameter("message") != null ? request.getParameter("message") : "" %></p>
    <p style="color:red;"><%= request.getParameter("error") != null ? request.getParameter("error") : "" %></p>
</body>
</html>
