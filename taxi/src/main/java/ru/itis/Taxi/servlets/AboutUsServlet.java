package ru.itis.Taxi.servlets;

import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.Taxi.repositories.AuthRepository;
import ru.itis.Taxi.repositories.AuthRepositoryImpl;
import ru.itis.Taxi.repositories.DriverRepository;
import ru.itis.Taxi.repositories.DriverRepositoryJdbcImpl;
import ru.itis.Taxi.services.DriverService;
import ru.itis.Taxi.services.DriverServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AboutUsServlet extends HttpServlet {

    private DriverService service;

    @Override
    @SneakyThrows
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qazwsxedc");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        DriverRepository driverRepository = new DriverRepositoryJdbcImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        service = new DriverServiceImpl(driverRepository, authRepository);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    req.getRequestDispatcher("aboutUs.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
