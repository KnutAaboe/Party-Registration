package Klasser;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@WebServlet(name = "OpprettBrukerServlet", urlPatterns = "/")
public class OpprettBrukerServlet extends HttpServlet {
    @EJB
    private DeltagerEAO eao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fn = (String) request.getParameter("fornavn");
        String en = (String) request.getParameter("etternavn");
        String mob = (String) request.getParameter("mobil");
        String pass = (String) request.getParameter("passord");
        String pass2 = (String) request.getParameter("passordRepetert");
        String kjonn = (String) request.getParameter("kjonn");


    Validator v = new Validator();
        if(eao.getDeltager(mob)==null && v.isMobilValid(mob) && v.isFornavnValid(fn)&& v.isEtternavnValid(en) && v.isPassordValid(pass, pass2) && v.isKjonnValid(kjonn)){
            HttpSession s = request.getSession(true);

            s.setAttribute("fn", fn);
            s.setAttribute("en", en);
            s.setAttribute("mob", mob);
            s.setAttribute("kjon", kjonn);

            //Hash pass
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

            System.out.println("passord: " + encoded);


            if(hash==null || encoded==null){
                s.setAttribute("err", "Feil med passord");
                response.sendRedirect("/Dat108_%20Gr25_Obl3");
            }else {
                //OPRETT BRUKER I JPA
                Deltager deltager = new Deltager(mob, fn, en, kjonn, encoded);

                eao.leggTilDeltager(deltager);

                response.sendRedirect("/Dat108_%20Gr25_Obl3/PB");
            }
        }else{
            HttpSession s = request.getSession(true);

            String err = "Feil ved innlogging:";

            if(v.isFornavnValid(fn))
                s.setAttribute("fn", fn); else err += "\nFeil med navn";

            if(v.isEtternavnValid(en))
                s.setAttribute("en", en); else err += "\nFeil med etternavn";

            if(v.isMobilValid(mob) && (eao.getDeltager(mob)==null))
                s.setAttribute("mob", mob); else if((eao.getDeltager(mob)!=null)) err += "\nNummeret er allerede registrert."; else err += "\nFeil med nummeret";

            if(v.isKjonnValid(kjonn))
                s.setAttribute("kjon", kjonn); else err += "\nFeil med kjønn, lul";

            if(pass!=null && pass.length()>=6)
                s.setAttribute("pass", pass); else err += "\nFeil med passord";

            if(pass2.equals(pass))
                s.setAttribute("pass2", pass2); else err += "\nPassordene er ikke like";

            s.setAttribute("err",err);
            response.sendRedirect("/Dat108_%20Gr25_Obl3");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema_MAL.jsp").forward(request, response);


    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
