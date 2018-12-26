package ru.itis.Taxi.servlets;

import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.Taxi.forms.RegDriverForm;
import ru.itis.Taxi.repositories.*;
import ru.itis.Taxi.services.DriverService;
import ru.itis.Taxi.services.DriverServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegDriverServlet extends HttpServlet {

    private DriverService driverService;

    @Override
    @SneakyThrows
    public void init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qazwsxedc");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        DriverRepository driverRepository = new DriverRepositoryJdbcImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        driverService=new DriverServiceImpl(driverRepository,authRepository);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("regDriver.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegDriverForm form = RegDriverForm.builder()
                .email(request.getParameter("email"))
                .firstName(request.getParameter("firstname"))
                .lastName(request.getParameter("lastname"))
                .password(request.getParameter("password"))
                .phoneNumber(request.getParameter("phone"))
                .haveCar(request.getParameter("haveCar"))
                .build();

        driverService.register(form);

        response.sendRedirect("/signIn");
    }
}
