package ru.itis.Taxi.filter;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.Taxi.repositories.AuthRepository;
import ru.itis.Taxi.repositories.AuthRepositoryImpl;
import ru.itis.Taxi.repositories.DriverRepository;
import ru.itis.Taxi.repositories.DriverRepositoryJdbcImpl;
import ru.itis.Taxi.services.DriverService;
import ru.itis.Taxi.services.DriverServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/profile")
public class AuthFilter implements Filter {
    private DriverService driverService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qazwsxedc");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        DriverRepository driverRepository = new DriverRepositoryJdbcImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        driverService = new DriverServiceImpl(driverRepository, authRepository);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        Cookie cookies[] = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("auth")) {
                    if (driverService.isExistByCookie(cookie.getValue())) {
                        chain.doFilter(request, response);
                    }
                }
            }
            response.sendRedirect("/signIn");
            return;
        }
        response.sendRedirect("/signIn");
        return;
    }

    @Override
    public void destroy() {

    }
}

