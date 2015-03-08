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


            request.getRequestDispatcher("item-list.jsp").forward(request,response);
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<Item> itemList = new ArrayList<Item>();
            try {
                ps = con.prepareStatement("select name, description, category, price from item");

                rs = ps.executeQuery();

                while(rs.next())
                {
                    String name = request.getParameter("name");
                    String description = request.getParameter("description");
                    String category = request.getParameter("category");
                    Double price = Double.parseDouble(request.getParameter("price"));

                    itemList.add(new Item(name, description, category, price));

                    itemList.add(new Item(rs.getString("name"), rs.getString("description"), rs.getString("category"), rs.getDouble("price")));
                    request.setAttribute("itemList", itemList);
                    request.getRequestDispatcher("item-list.jsp").forward(request, response);


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
            RequestDispatcher dispatcher = request.getRequestDispatcher("item-list.jsp");
            if (dispatcher != null){
                dispatcher.forward(request, response);
    }


        }

}

