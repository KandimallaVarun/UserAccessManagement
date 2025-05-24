package com.example.servlet;

import com.example.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//@WebServlet("/software")
public class SoftwareServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"Admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp?error=Unauthorized access");
            return;
        }

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String[] accessLevels = req.getParameterValues("accessLevels");
        String accessLevelsStr = String.join(",", accessLevels != null ? accessLevels : new String[]{});

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO software(name, description, access_levels) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, accessLevelsStr);

            int result = ps.executeUpdate();
            if (result > 0) {
                resp.sendRedirect("createSoftware.jsp?message=Software added successfully");
            } else {
                resp.sendRedirect("createSoftware.jsp?error=Failed to add software");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("createSoftware.jsp?error=Database error");
        }
    }
}
