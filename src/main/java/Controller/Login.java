/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Julian
 */
package Controller;

import Dao.LoginDAO;
import Model.Validador;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.servlet.ServletException;    
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author
 */
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int hacer = Integer.parseInt(request.getParameter("hidden").trim());
        if (hacer == 1) {// inicio de sesion
            HttpSession respuesta = request.getSession(true);
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Pattern p = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
            Matcher m = p.matcher(email);
            Validador v = new Validador();
            LoginDAO d = null;
            String r = "";
            try {
                d = new LoginDAO();
            } catch (URISyntaxException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            //campos vacios
            if (email.isEmpty() || password.isEmpty()) {
                r = "hay casillas vacias";
            } else //No hay campos vacios, veo que la direccion de email sea válida
            {
                if (m.find()) {
                    //La direccion de email si es correcta, verifico que la contraseña tambien lo sea
                    if (v.isUsernameOrPasswordValid(password)) {
                        try {
                            if (d.isAcountExists(email.trim(), password.trim())) {
                                //Significa que la cuenta si existe
                                //OBTENGO EL NOMBRE DEL USUARIO Y LO GUARDO EN UNA SESION
                                String NombreUsuario = d.getNameByEmail(email);
                                String tipoUsuario = d.gettypeByEmail(email);
                                respuesta.setAttribute("sessionNombre", NombreUsuario);
                                respuesta.setAttribute("sessionEmail", email);
                                r = tipoUsuario.trim();
                            } else {
                                r = "usuario o contraseña erroneo";
                            }
                        } catch (Exception e) {
                            r = "usuario o contraseña erroneo";
                        }
                    } else {
                        r = "contraseña no valida";
                    }
                } else {
                    r = "direccion de correo incorrecta";
                }
            }
            System.out.println(""+r);
            response.setContentType("html/text");
            response.getWriter().write(r.trim());
        } else if (hacer == 2) { //cerrar sesion
            HttpSession session = request.getSession();
            session.invalidate();
        } else if (hacer == 3) { //validar sesion
            HttpSession session = request.getSession();
            String nombre = (String) session.getAttribute("nombre");
            if (nombre == null) {
                response.sendRedirect("login.html");
            } else {
                //devolver nombre del usuario 
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}
