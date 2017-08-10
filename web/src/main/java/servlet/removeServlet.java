package servlet;

import context.AircraftService;
import ru.fedorenko.Domain.AircraftEntity;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivan on 02.06.17.
 */
@WebServlet("/remove")
public class removeServlet extends HttpServlet {
    @Inject
    private AircraftService service;

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String aircraft_code = request.getParameter("del");
        AircraftEntity aircraftEntity = service.editAircraft(aircraft_code);
        if (aircraftEntity != null)
            service.removeAircraft(aircraftEntity);
        response.sendRedirect("list");
    }

}
