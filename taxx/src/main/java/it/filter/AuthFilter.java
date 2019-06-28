//package it.filter;
//
//
//import it.services.DriverService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class AuthFilter implements Filter {
//    @Autowired
//    @Lazy
//    DriverService driverService;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        Cookie cookies[] = request.getCookies();
//
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("auth")) {
//                    if (driverService.isExistByCookie(cookie.getValue())) {
//                        filterChain.doFilter(request, response);
//                    }
//                }
//            }
//            response.sendRedirect("/login");
//            return;
//        }
//        response.sendRedirect("/login");
//        return;
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
