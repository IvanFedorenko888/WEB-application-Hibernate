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
 * Created by ivan on 31.05.17.
 */
@WebServlet("/add")
public class list_editServlet extends HttpServlet{
    @Inject
    private AircraftService aircraftService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("edit") != null){
            String aircraft_code = req.getParameter("edit");
            AircraftEntity aircraftEntity = aircraftService.editAircraft(aircraft_code);

            req.setAttribute("aircraft", aircraftEntity);
        }

        req.getRequestDispatcher("/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String aircrafts_code = req.getParameter("aircraft_code");
        String model = req.getParameter("model");
        Integer range = Integer.valueOf(req.getParameter("range"));

        // если id есть, то выполняется редактирование
        // а если нет id, то - это значит, что создается новый пользователь
            AircraftEntity aircraftEntity = aircraftService.editAircraft(aircrafts_code);
        if (aircraftEntity == null)
            aircraftService.createAircraft(aircrafts_code, model, range.toString());
        else {
            aircraftEntity.setModel(model);
            aircraftEntity.setRange(range);
            aircraftService.updateAircrafts(aircraftEntity);
            }

        // перенаправляем на сервлет, который выводит все пользователей
        resp.sendRedirect("list");
    }
}
