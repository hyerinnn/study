package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
//MyExcludeComponent 얘가 붙은거는 컴포넌트 스캔에서 제외할거야.

}
