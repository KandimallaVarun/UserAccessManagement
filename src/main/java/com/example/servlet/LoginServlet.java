package com.example.servlet;

import com.example.util.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT role FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", role);

                switch (role) {
                    case "Employee":
                        resp.sendRedirect("requestAccess.jsp");
                        break;
                    case "Manager":
                        resp.sendRedirect("pendingRequests.jsp");
                        break;
                    case "Admin":
                        resp.sendRedirect("createSoftware.jsp");
                        break;
                    default:
                        resp.sendRedirect("login.jsp?error=Unknown role.");
                }
            } else {
                resp.sendRedirect("login.jsp?error=Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("login.jsp?error=Database error.");
        }
    }
}
