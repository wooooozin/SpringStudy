package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestJsonController {

  private ObjectMapper objectMapper = new ObjectMapper();

  @PostMapping("/request-body-json-v1")
  public void requestJsonV1(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    ServletInputStream inputStream = request.getInputStream();
    String message = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

    log.info("message Body = {}", message);
    HelloData helloData = objectMapper.readValue(message, HelloData.class);
    log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
    response.getWriter().write("ok");
  }

  @PostMapping("/request-body-json-v2")
  public String requestJsonV2(@RequestBody String messageBody)
      throws IOException {

    log.info("message Body = {}", messageBody);
    HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
    log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
    return "ok";
  }

  @PostMapping("/request-body-json-v3")
  public String requestJsonV3(@RequestBody HelloData messageBody)
      throws IOException {

    log.info("message Body = {}", messageBody);
    log.info("username = {}, age = {}", messageBody.getUsername(), messageBody.getAge());
    return "ok";
  }

  @ResponseBody
  @PostMapping("/request-body-json-v4")
  public String requestJsonV4(HttpEntity<HelloData> data)
      throws IOException {
    HelloData helloData = data.getBody();
    log.info("message Body = {}", helloData);
    log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
    return "ok";
  }

  @ResponseBody
  @PostMapping("/request-body-json-v5")
  public HelloData requestJsonV5(@RequestBody HelloData data)
      throws IOException {
    log.info("message Body = {}", data);
    log.info("username = {}, age = {}", data.getUsername(), data.getAge());
    return data;
  }

}
