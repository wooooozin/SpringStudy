package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestModelAttributeController {

  @ResponseBody
  @RequestMapping("/model-attribute-v1")
  public String modelAttributeV1(
      @RequestParam String username,
      @RequestParam int age
  ) {
    HelloData helloData = new HelloData();
    helloData.setUsername(username);
    helloData.setAge(age);
    log.info("hello Data = {}", helloData.toString());
    return "ok";
  }

  @ResponseBody
  @RequestMapping("/model-attribute-v2")
  public String modelAttributeV2(
      @ModelAttribute HelloData helloData // @ModelAttribute 셍략 가능
  ) {
    HelloData newHelloData = new HelloData();
    newHelloData.setUsername(helloData.getUsername());
    newHelloData.setAge(helloData.getAge());
    log.info("hello Data = {}", newHelloData.toString());
    return "ok";
  }
}
