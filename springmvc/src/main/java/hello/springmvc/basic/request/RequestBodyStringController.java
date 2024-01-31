package hello.springmvc.basic.request;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class RequestBodyStringController {

  @PostMapping("/request-body-string-v1")
  public void requestBodyString(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    ServletInputStream inputStream = request.getInputStream();
    String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
    log.info("message Body = {}", messageBody);
    response.getWriter().write("ok");
  }

  @PostMapping("/request-body-string-v2")
  public void requestBodyString(InputStream inputStream, Writer responseWriter)
      throws IOException {
    String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
    log.info("message Body = {}", messageBody);
    responseWriter.write("ok");
  }

  @PostMapping("/request-body-string-v3")
  public HttpEntity<String> requestBodyString(HttpEntity<String> httpEntity)
      throws IOException {
    String body = httpEntity.getBody();
    log.info("message Body = {}", body);
    return new HttpEntity<>("ok");
  }

  @ResponseBody
  @PostMapping("/request-body-string-v4")
  public String requestBodyString(@RequestBody String message)
  {
    log.info("message Body = {}", message);
    return "ok";
  }
}
