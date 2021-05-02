package Klasser;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@WebServlet(name = "LoggInnServlet", urlPatterns = "/logginn")
public class LoggInnServlet extends HttpServlet {

    @EJB
    private DeltagerEAO eao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mob = (String) request.getParameter("mobil");
        String pass = (String) request.getParameter("passord");

        MessageDigest digest = null;
        byte[] hash = null;
        String encoded = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
            encoded = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        Deltager person = eao.getDeltager(mob);
        if(person == null || !person.getPassord().equals(encoded)){
            response.sendRedirect("/Dat108_%20Gr25_Obl3/logginn?err=err");
        }else {

            HttpSession s = request.getSession(true);

            s.setAttribute("fn", person.getFn());
            s.setAttribute("en", person.getEn());
            s.setAttribute("mob", person.getTlf());
            s.setAttribute("kjon", person.getKjonn());

            response.sendRedirect("/Dat108_%20Gr25_Obl3/PB");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession SS = request.getSession(false);
        if(SS!=null) SS.invalidate();
        request.getRequestDispatcher("WEB-INF/jsp/logginn_MAL.jsp").forward(request, response);
    }
}
