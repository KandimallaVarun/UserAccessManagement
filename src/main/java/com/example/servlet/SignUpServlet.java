package com.example.servlet;

import com.example.util.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = "Employee"; // default

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO users(username, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);

            int result = ps.executeUpdate();
            if (result > 0) {
                resp.sendRedirect("login.jsp?message=Registered successfully, please login.");
            } else {
                resp.sendRedirect("signup.jsp?error=Registration failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("signup.jsp?error=Database error.");
        }
    }
}
