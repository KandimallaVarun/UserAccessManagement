<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pending Requests</title>
</head>
<body>
    <h2>Pending Requests List (Manager)</h2>

    <!-- You can later use JSTL or scriptlets here to dynamically list requests -->

    <p>List of pending access requests will be shown here.</p>

    <p style="color:green;"><%= request.getParameter("message") != null ? request.getParameter("message") : "" %></p>
    <p style="color:red;"><%= request.getParameter("error") != null ? request.getParameter("error") : "" %></p>
</body>
</html>
