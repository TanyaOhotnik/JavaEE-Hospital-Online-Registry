package com.online.servlets;



import com.online.dao.DAOspecialization;
import com.online.entities.Specialization;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Tanya Ohotnik on 17.10.2016.
 */
@WebServlet("/addSpecialization")
public class AddSpecialization extends HttpServlet {
    private static Logger log = Logger.getLogger(AddSpecialization.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {

            DAOspecialization daoSpecialization = new DAOspecialization();

            Specialization sp = new Specialization();

            sp.setName(request.getParameter("name"));
            daoSpecialization.update(sp);
        } catch (Exception e) {
            request.setAttribute("name", "Specialization wasn't added in database");
            log.log(Level.SEVERE, "Something bad happened. Can`t add information in database. " + e);

        } finally {
            request.setAttribute("name", "Specialization was added in database");
            request.getRequestDispatcher("addSpecialization.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
