package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
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



    /**
     * @RequestParam 사용
     * - 파라미터 이름으로 바인딩
     * @ResponseBody 추가
     * - View 조회를 무시하고, HTTP message body에 직접 해당 내용 입력
     */


    /**
     * @RequestParam 사용
     * HTTP 파라미터 이름이 변수 이름과 같으면 @RequestParam(name="xx") 생략 가능
     */



    /**
     * @RequestParam 사용
     * String, int 등의 단순 타입이면 @RequestParam 도 생략 가능
     */

    /**
     * @RequestParam.required
     *
     * /request-param-required -> username이 없으므로 예외 *
     * 주의!
     * /request-param-required?username= -> 빈문자로 통과 *
     * 주의!
     *
     * /request-param-required
     * int age -> null을 int에 입력하는 것은 불가능, 따라서 Integer 변경해야 함(또는 다음에 나오는 defaultValue 사용)
     *
     * required 가 true 이면 파라미터 필수
     * required=false 이면 파라미터 필수 아님
     */


    /*
    * @RequestParam - defaultValue 사용
    * 참고: defaultValue는 빈 문자의 경우에도 적용
    *
    * "guest" 라는 문자가 들어올 경우에는 defaultValue가 적용되지 않음
    * "-1" 라는 문자가 들어올 경우에는 defaultValue가 적용됨
     */





}