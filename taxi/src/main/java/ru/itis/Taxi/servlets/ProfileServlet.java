package ru.itis.Taxi.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfileServlet extends HttpServlet {
    private Statement statement;
    private Connection connection;
    private DriverService service;
    @Override
    @SneakyThrows
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qazwsxedc");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qazwsxedc");
        statement = connection.createStatement();
        DriverRepository driverRepository = new DriverRepositoryJdbcImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        service = new DriverServiceImpl(driverRepository, authRepository);
    }

    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie[] = req.getCookies();
        int driverId;
        String firstName;
        String lastName;
        String phoneNumber;
        List<Object> list = new ArrayList<>();
        for (Cookie cook : cookie) {
            if (cook.getName().equals("driverId")) {
                driverId = Integer.parseInt(cook.getValue());
                ResultSet set = statement.executeQuery("select * from driver where driver.id=" + driverId + "");
                set.next();
//                int sum=service.getSumForOrderForDay(driverId);
                firstName = set.getString("first_name");
                lastName = set.getString("last_name");
                phoneNumber = set.getString("phone_number");
                list.add(firstName);
                list.add(lastName);
                list.add(phoneNumber);
//                list.add(sum);
            }
        }
        String json = objectMapper.writeValueAsString(list);
        req.setAttribute("json", json);
        resp.setContentType("application/json");
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
