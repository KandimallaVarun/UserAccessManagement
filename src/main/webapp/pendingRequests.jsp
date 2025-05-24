<%@ page import="java.sql.*, com.example.util.DBConnection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pending Requests - Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-warning text-dark text-center">
            <h2>Pending Access Requests</h2>
        </div>
        <div class="card-body">

            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr>
                        <th>Request ID</th>
                        <th>Employee Username</th>
                        <th>Software</th>
                        <th>Access Type</th>
                        <th>Reason</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        try (Connection con = DBConnection.getConnection()) {
                            String query = "SELECT r.id, u.username, s.name, r.access_type, r.reason " +
                                           "FROM requests r " +
                                           "JOIN users u ON r.user_id = u.id " +
                                           "JOIN software s ON r.software_id = s.id " +
                                           "WHERE r.status = 'Pending'";

                            PreparedStatement ps = con.prepareStatement(query);
                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) {
                    %>
                    <tr>
                        <td><%= rs.getInt("id") %></td>
                        <td><%= rs.getString("username") %></td>
                        <td><%= rs.getString("name") %></td>
                        <td><%= rs.getString("access_type") %></td>
                        <td><%= rs.getString("reason") %></td>
                        <td>
                            <form action="ApprovalServlet" method="post" class="d-flex gap-1">
                                <input type="hidden" name="requestId" value="<%= rs.getInt("id") %>">
                                <button type="submit" name="action" value="approve" class="btn btn-success btn-sm">Approve</button>
                                <button type="submit" name="action" value="reject" class="btn btn-danger btn-sm">Reject</button>
                            </form>
                        </td>
                    </tr>
                    <%
                            }
                        } catch (Exception e) {
                            out.println("<tr><td colspan='6' class='text-danger'>Database Error: " + e.getMessage() + "</td></tr>");
                        }
                    %>
                </tbody>
            </table>

        </div>
    </div>
</div>

</body>
</html>
