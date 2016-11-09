package com.online.servlets;


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
@WebServlet("/addSickDoctor")
public class AddSickDoctor extends HttpServlet {
    private static Logger log = Logger.getLogger(AddSickDoctor.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int selectedDoctor;
        int selectedSick;
        try {
//
//            DAOdoctor daoDoctor = new DAOdoctor();
//            DAOsick daoSick = new DAOsick();
//
//
//            selectedDoctor = Integer.parseInt(request.getParameter("doctorList"));
//            selectedSick = Integer.parseInt(request.getParameter("sickList"));
//
//            System.out.println(selectedDoctor + " " + selectedSick);
//            if (selectedDoctor < 1 || selectedSick < 1)
//                throw new Exception();
//           Sick sick = daoSick.get(selectedSick);
//            Doctor doctor = daoDoctor.get(selectedDoctor);
//
//
//            sick.addDoctor(daoDoctor.get(doctor.getId()));
//
//            doctor.addSick(daoSick.get(sick.getId()));
//            daoDoctor.update(doctor);
//            daoSick.update(sick);
        } catch (Exception e) {
            request.setAttribute("name", "Info wasn't added in database" + e);
            log.log(Level.SEVERE, "Something bad happened. Can`t add information in database. " + e);
        } finally {
            request.setAttribute("name", "Info was added in database");
            request.getRequestDispatcher("addSickDoctor.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
