package com.store.servlet;


import com.store.util.Item;
import com.store.util.User;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Item", urlPatterns = { "/Item" })

public class ItemServlet extends HttpServlet {
    static Logger logger = Logger.getLogger(RegisterServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
        protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

//            RequestDispatcher rd = getServletContext().getRequestDispatcher("item-list.jsp");


            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                ps = con.prepareStatement("select name, description, category, price from item ");

                rs = ps.executeQuery();
//                if(rs != null){
//                    rs.next();
//                    Item item = new Item(rs.getString("name"), rs.getString("description"), rs.getString("category"), rs.getLong("price"));
//                    logger.info("Item found "+item);
//                    HttpSession session = request.getSession();
//                    session.setAttribute("itemList", item);
//                    response.sendRedirect("item-list.jsp");
//
//
//                }

//                 ArrayList item = new ArrayList();
//
//                    while (rs.next()) {
//                        String[] row = new String[3];
//                        row[0]=rs.getString(2);
//                        item.add(row[0]);
//                    }
//
//                    request.setAttribute("itemList", item);
//                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("item-list.jsp");
//                    dispatcher.forward(request,response);

                String name = request.getParameter("name");
                String description = request.getParameter("description");
                String category = request.getParameter("category");

                ArrayList item = new ArrayList();                do {
                    item.add(rs.getString("item"));
                } while (rs.next());

                // Create a new HTTPSession and save the username and roles
                // First, invalidate the session. if any
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.invalidate();
                }
                session = request.getSession(true);
                synchronized (session) {
                    session.setAttribute("name", name);
                    session.setAttribute("roles", description);
                    session.setAttribute("category", category);

                }

            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("Database connection problem");
                try {
                    throw new ServletException("DB Connection problem.");
                } catch (ServletException e1) {
                    e1.printStackTrace();
                }
            }finally{
                try {
                    rs.close();
                    ps.close();
                } catch (SQLException e) {
                    logger.error("SQLException in closing PreparedStatement or ResultSet");
                }

            }

//            request.getRequestDispatcher("item-list.jsp").forward(request, response);
    }
}

