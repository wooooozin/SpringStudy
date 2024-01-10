package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-get-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 상태 코드 설정
        resp.setStatus(HttpServletResponse.SC_OK);

        // 응답 헤더 설정
        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-Header", "hello");

        // 쿠키 설정
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); // 쿠키의 유효 시간을 600초로 설정
        resp.addCookie(cookie);

        // 응답 본문에 데이터 쓰기 (리디렉션 전에만 사용 가능)
        // PrintWriter writer = resp.getWriter();
        // writer.println("ok");

        // 리디렉션 (응답 본문에 더 이상 쓰면 안 됨)
        resp.sendRedirect("/hello-form.html");
    }
}
