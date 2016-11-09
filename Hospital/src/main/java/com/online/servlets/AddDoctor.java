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
@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {
    private static Logger log = Logger.getLogger(AddDoctor.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
//
//            DAOdoctor daoDoctor = new DAOdoctor();
//            DAOspecialization daoSpecialization = new DAOspecialization();
//            Doctor doctor = new Doctor();
//            Specialization sp = new Specialization();
//
//            sp.setName(request.getParameter("spec"));
//
//            sp = daoSpecialization.add(sp);
//            doctor.setCabinet(request.getParameter("cabinet"));
//            doctor.setName(request.getParameter("name"));
//            doctor.setBirthday(request.getParameter("birthday"));
//
//            doctor = daoDoctor.add(doctor);
//
//            doctor.setSpecialization(daoSpecialization.get(sp.getId()));
//            daoDoctor.update(doctor);
//            sp.addDoctor(daoDoctor.get(doctor.getId()));
//            daoSpecialization.update(sp);

        } catch (Exception e) {
            request.setAttribute("name", "Doctor wasn't added in database");
            log.log(Level.SEVERE, "Something bad happened. Can`t add information in database. " + e);

        } finally {
            request.setAttribute("name", "Doctor was added in database");
            request.getRequestDispatcher("addDoctor.jsp").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
