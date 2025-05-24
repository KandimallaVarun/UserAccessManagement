package com.example.servlet;

import com.example.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

//@WebServlet("/approval")
public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int requestId = Integer.parseInt(req.getParameter("requestId"));

        String status = "Pending";
        if ("approve".equalsIgnoreCase(action)) {
            status = "Approved";
        } else if ("reject".equalsIgnoreCase(action)) {
            status = "Rejected";
        }

        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE requests SET status = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, requestId);
            ps.executeUpdate();

            resp.sendRedirect("pendingRequests.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("pendingRequests.jsp?error=Database error");
        }
    }
}
