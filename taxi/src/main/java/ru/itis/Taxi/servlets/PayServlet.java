package ru.itis.Taxi.servlets;

import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.Taxi.forms.OrderForm;
import ru.itis.Taxi.repositories.OrderRepository;
import ru.itis.Taxi.repositories.OrderRepositoryImpl;
import ru.itis.Taxi.services.OrderService;
import ru.itis.Taxi.services.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PayServlet extends HttpServlet {
    private OrderService orderService;

    @Override
    @SneakyThrows
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qazwsxedc");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        OrderRepository orderRepository = new OrderRepositoryImpl(dataSource);
        orderService = new OrderServiceImpl(orderRepository);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderForm orderForm = OrderForm.builder()
                .clientNumber(request.getParameter("clientNumber"))
                .startPoint(request.getParameter("startPoint"))
                .endPoint(request.getParameter("endPoint"))
                .comment(request.getParameter("comment"))
                .price(Integer.parseInt(request.getParameter("price")))
                .build();
        orderService.createNewOrder(orderForm);
    }
}
