package May.myFirstSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MayController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api") //HTTP GET 요청이 "/hello-api" 경로로 올 때 이 메서드를 처리함
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){ //HTTP 요청의 "name" 파라미터 값을 메서드의 name 파라미터에 매핑함
        Hello hello = new Hello(); // Hello 클래스의 인스턴스 생성
        hello.setName(name); // Hello 인스턴스의 setName 메서드를 사용하여 name 값을 설정
        return hello; // 클라이언트에게 Hello 인스턴스를 JSON 형태로 응답함
    }

    static class Hello{ // Hello 클래스: 데이터를 담는 간단한 모델 클래스
        private String name;

        public String getName() { // getName(): name 변수의 값을 반환하는 Getter 메서드
            return name;
        }

        public void setName(String name) { // setName(String name): name 변수의 값을 설정하는 Setter 메서드
            this.name = name;
        }
    }
}
