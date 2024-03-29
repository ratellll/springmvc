package hello.springmvc.basic.request;



import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;


@Slf4j
@Controller
public class RequestParamController {


    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        int size = Integer.parseInt(request.getParameter("size"));
        int account = Integer.parseInt(request.getParameter("account"));
        log.info(username + "====" + age + "====" + size + "====" + account);

        response.getWriter().write("ok");
    }


    /**
     * @RequestParam 사용
     * - 파라미터 이름으로 바인딩
     * @ResponseBody 추가
     * - View 조회를 무시하고, HTTP message body에 직접 해당 내용 입력
     */
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") String memberage,
                                 @RequestParam("size") String membersize,
                                 @RequestParam("account") String memberaccount) throws IOException {

        log.info(memberName + "====" + memberage + "====" + membersize + "====" + memberaccount);
        return "ok";
    }


    /**
     * @RequestParam 사용
     * HTTP 파라미터 이름이 변수 이름과 같으면 @RequestParam(name="xx") 생략 가능
     * 변수이름은 무조건 같아야함
     */
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age,
                                 @RequestParam int size,
                                 @RequestParam int account) throws IOException {

        log.info(username + "====" + age + "====" + size + "====" + account);
        return "ok";
    }

    /**
     * @RequestParam 사용
     * String, int 등의 단순 타입이면 @RequestParam 도 생략 가능
     */

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username,
                                 int age,
                                 int size,
                                 int account) throws IOException {

        log.info(username + "====" + age + "====" + size + "====" + account);
        return "ok";
    }

    /**
     * @RequestParam.required /request-param-required -> username이 없으므로 예외 *
     * 주의!
     * /request-param-required?username= -> 빈문자로 통과 *
     * 주의!
     * <p>
     * /request-param-required
     * int age -> null을 int에 입력하는 것은 불가능, 따라서 Integer 변경해야 함(또는 다음에 나오는 defaultValue 사용)
     * <p>
     * required 가 true 이면 파라미터 필수
     * required=false 이면 파라미터 필수 아님
     */
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = false) String username,
                                       @RequestParam(required = false) Integer age,
                                       @RequestParam(required = false) Integer size,
                                       @RequestParam(required = false) Integer account) throws IOException {

        log.info(username + "====" + age + "====" + size + "====" + account);
        return "ok";
    }


    /*
     * @RequestParam - defaultValue 사용
     * 참고: defaultValue는 빈 문자의 경우에도 적용
     *
     * "guest" 라는 문자가 들어올 경우에는 defaultValue가 적용되지 않음
     * "-1" 라는 문자가 들어올 경우에는 defaultValue가 적용됨
     */
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(required = false, defaultValue = "-1") String username,
                                      @RequestParam(required = false, defaultValue = "-1") Integer age,
                                      @RequestParam(required = false) Integer size,
                                      @RequestParam(required = false) Integer account) throws IOException {

        log.info(username + "====" + age + "====" + size + "====" + account);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) throws IOException {

        log.info(paramMap.get("username") + "====" + paramMap.get("age") + "====" + paramMap.get("size") + "====" + paramMap.get("account"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info(helloData.getUsername() +"=="+ helloData.getAge() + "===" + helloData.getSize()+ "==="+ helloData.getAccount());
        return "ok";

    }
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info(helloData.getUsername() +"=="+ helloData.getAge() + "===" + helloData.getSize()+ "==="+ helloData.getAccount());
        return "ok";

    }
}