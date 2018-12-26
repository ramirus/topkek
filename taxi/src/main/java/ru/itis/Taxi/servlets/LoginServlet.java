package ru.itis.Taxi.servlets;

import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.Taxi.forms.LoginForm;
import ru.itis.Taxi.repositories.*;
import ru.itis.Taxi.services.DriverService;
import ru.itis.Taxi.services.DriverServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginServlet extends HttpServlet {
    private DriverService service;
    private Statement statement;
    private Connection connection;
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
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qazwsxedc");
        statement = connection.createStatement();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginForm form = LoginForm.builder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();

        String cookieValue = service.login(form);
        if (cookieValue != null) {
            Cookie auth = new Cookie("auth", cookieValue);
            auth.setMaxAge(60*60*6);
            int id;
            ResultSet set=statement.executeQuery("select max(driver_id) as id from auth");
            set.next();
            id=set.getInt("id");
            System.out.println(id);
            set = statement.executeQuery("select driver.id from driver join auth on auth.driver_id=driver.id where auth.id=" + id + "");
            set.next();
            int driverId = set.getInt("id");
            Cookie cooki = new Cookie("driverId", "" + driverId);
            cooki.setMaxAge(60*60*12);
            response.addCookie(cooki);
            response.addCookie(auth);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/signIn");
        }

    }
}
