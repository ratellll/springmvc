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