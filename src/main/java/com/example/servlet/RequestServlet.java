package com.example.servlet;

import com.example.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

//@WebServlet("/requestAccess")
public class RequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"Employee".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp?error=Unauthorized access");
            return;
        }

        String username = (String) session.getAttribute("username");
        String softwareName = req.getParameter("softwareName");
        String accessType = req.getParameter("accessType");
        String reason = req.getParameter("reason");

        try (Connection con = DBConnection.getConnection()) {
            // Get user_id
            PreparedStatement psUser = con.prepareStatement("SELECT id FROM users WHERE username = ?");
            psUser.setString(1, username);
            ResultSet rsUser = psUser.executeQuery();
            int userId = -1;
            if (rsUser.next()) {
                userId = rsUser.getInt("id");
            } else {
                resp.sendRedirect("requestAccess.jsp?error=User not found");
                return;
            }

            // Get software_id
            PreparedStatement psSoftware = con.prepareStatement("SELECT id FROM software WHERE name = ?");
            psSoftware.setString(1, softwareName);
            ResultSet rsSoftware = psSoftware.executeQuery();
            int softwareId = -1;
            if (rsSoftware.next()) {
                softwareId = rsSoftware.getInt("id");
            } else {
                resp.sendRedirect("requestAccess.jsp?error=Software not found");
                return;
            }

            // Insert request
            String sqlInsert = "INSERT INTO requests(user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, 'Pending')";
            PreparedStatement psInsert = con.prepareStatement(sqlInsert);
            psInsert.setInt(1, userId);
            psInsert.setInt(2, softwareId);
            psInsert.setString(3, accessType);
            psInsert.setString(4, reason);

            int result = psInsert.executeUpdate();
            if (result > 0) {
                resp.sendRedirect("requestAccess.jsp?message=Request submitted successfully");
            } else {
                resp.sendRedirect("requestAccess.jsp?error=Failed to submit request");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("requestAccess.jsp?error=Database error");
        }
    }
}
