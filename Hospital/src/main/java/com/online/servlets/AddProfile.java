package com.online.servlets;


import com.online.dao.DAOprofile;
import com.online.entities.Profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Tanya Ohotnik on 15.10.2016.
 */
@WebServlet("/addProfile")
public class AddProfile extends HttpServlet {
    private static Logger log = Logger.getLogger(AddProfile.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {


            DAOprofile daoProfile = new DAOprofile();
            Profile profile = new Profile();
            profile.setPhone(request.getParameter("phone"));
            profile.setAddress(request.getParameter("address"));
            profile.setEmail(request.getParameter("email"));
            profile.setPassword(request.getParameter("password"));
            profile.setName(request.getParameter("name"));
            profile.setBirthday(request.getParameter("birthday"));
            daoProfile.add(profile);
        } catch (Exception e) {
            request.setAttribute("name", "Profile wasn't added in database");
            log.log(Level.SEVERE, "Something bad happened. Can`t add information in database. " + e);
        } finally {
            request.setAttribute("name", "Profile was added in database");
            request.getRequestDispatcher("addProfile.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
