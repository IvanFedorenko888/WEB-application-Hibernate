package servlet;

import context.AircraftService;
import ru.fedorenko.Beans.AirBean;
import ru.fedorenko.Domain.AircraftEntity;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ivan on 01.06.17.
 */
@WebServlet("/list")
public class listServlet extends HttpServlet{
        @Inject
        private AircraftService airBean;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            List<AircraftEntity> allAir = airBean.getAll();

            req.getSession().setAttribute("airs", allAir);
            RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
            dispatcher.forward(req, resp);
        }

}
