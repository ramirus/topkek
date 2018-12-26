package ru.itis.Taxi.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.Taxi.models.RatingComment;
import ru.itis.Taxi.repositories.CommonRepository;
import ru.itis.Taxi.repositories.CommonRepositoryImpl;
import ru.itis.Taxi.services.CommonService;
import ru.itis.Taxi.services.CommonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/rating")
public class RatingServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private CommonService commonService;

    @Override
    @SneakyThrows
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qazwsxedc");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        CommonRepository commonRepository = new CommonRepositoryImpl(dataSource);
        commonService = new CommonServiceImpl(commonRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List allRat = commonService.getAllRatingCom();
        String json=objectMapper.writeValueAsString(allRat);
        req.setAttribute("json", json);
        resp.setContentType("application/json");
//        resp.getWriter().write(json);
        req.getRequestDispatcher("rating.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RatingComment ratingComment = RatingComment.builder()
                .clientPhone(req.getParameter("phone"))
                .comment(req.getParameter("comment"))
                .ratingCount(Integer.parseInt(req.getParameter("ratingCount")))
                .build();
        commonService.newRatingComment(ratingComment);
        resp.sendRedirect("/rating");
    }
}
