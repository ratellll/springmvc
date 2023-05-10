Controoler는 반환값이 String이면 View의 이름으로 인식한다.
그래서 뷰를 찾고 뷰를 랜더링한다.
```
RestController는 반환 값으로 String을 반환하면 View를 찾는 것이 아니라 HTTP Message Body에 해당 String을 직접 넣어준다.
```



/**
* HttpEntity: HTTP header, body 정보를 편리하게 조회
* - 메시지 바디 정보를 직접 조회(@RequestParam X, @ModelAttribute X)
* - HttpMessageConverter 사용 -> StringHttpMessageConverter 적용 *
* 응답에서도 HttpEntity 사용 가능
* * */
- 메시지 바디 정보 직접 반환(view 조회X)
- HttpMessageConverter 사용 -> StringHttpMessageConverter 적용


MVC는 다음 파라미터를 지원함

HttpEntity: HTTP header, body 정보를 편리하게 조회
- 메시지 바디 정보를 직접 조회(@RequestParam X, @ModelAttribute X)
- HttpMessageConverter 사용 -> StringHttpMessageConverter 적용
- HttpEntity는 응답에서도 사용 가능하다. 메시지 바디 정보를 직접 반환하고 싶은 경우에는 ResponseEntity를 사용하면 된다.
- ResponseEntity는 응답 코드를 설정할 수 있고, 응답 내용(body)뿐만 아니라, 헤더 정보도 포함 가능하다.

스프링MVC 내부에서 HTTP 메시지 바디를 읽어서 문자나 객체로 변환해서 전달해주는데, 이때 HTTP
메시지 컨버터( HttpMessageConverter )라는 기능을 사용한다.



요청 파라미터를 조회하는 기능: @RequestParam , @ModelAttribute 
HTTP 메시지 바디를 직접 조회하는 기능: @RequestBody

@ResponseBody 를 사용하면 응답 결과를 HTTP 메시지 바디에 직접 담아서 전달할 수 있다. 물론 이 경우에도 view를 사용하지 않는다.


* @RequestBody
    * - 메시지 바디 정보를 직접 조회(@RequestParam X, @ModelAttribute X)
    * - HttpMessageConverter 사용 -> StringHttpMessageConverter 적용 *
    - 
    * @ResponseBody
    * - 메시지 바디 정보 직접 반환(view 조회X)
    * - HttpMessageConverter 사용 -> StringHttpMessageConverter 적용



스프링(서버)에서 응답 데이터를 만드는 방법은 크게 3가지이다.
정적 리소스
예) 웹 브라우저에 정적인 HTML, css, js를 제공할 때는, 정적 리소스를 사용한다.
뷰 템플릿 사용
예) 웹 브라우저에 동적인 HTML을 제공할 때는 뷰 템플릿을 사용한다.
HTTP 메시지 사용
HTTP API를 제공하는 경우에는 HTML이 아니라 데이터를 전달해야 하므로, HTTP 메시지 바디에 JSON 같은 형식으로 데이터를 실어 보낸다.



String을 반환하는 경우 - View or HTTP 메시지
@ResponseBody 가 없으면 response/hello 로 뷰 리졸버가 실행되어서 뷰를 찾고, 렌더링 한다. 
@ResponseBody 가 있으면 뷰 리졸버를 실행하지 않고, HTTP 메시지 바디에 직접 response/hello 라는 문자가 입력된다.
여기서는 뷰의 논리 이름인 response/hello 를 반환하면 다음 경로의 뷰 템플릿이 렌더링 되는 것을 확인할 수 있다.

