package Klasser;

import javax.ejb.EJB;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeltagerlisteServlet", urlPatterns = "/DL")
public class DeltagerlisteServlet extends HttpServlet {
    @EJB
    private DeltagerEAO eao;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession(false);
        if(s == null){
            response.sendRedirect("/Dat108_%20Gr25_Obl3/logginn");
        }
        //FIKS SLIK AT VI HENTER DELTAKERE FRA DATABASE MED JPA
        List<Deltager> deltagere = eao.getDeltagere();
        s.setAttribute("deltagere", deltagere);

        request.getRequestDispatcher("WEB-INF/jsp/deltagerliste_MAL.jsp").forward(request, response);
    }
}
