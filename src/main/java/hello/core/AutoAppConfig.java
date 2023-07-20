package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component 애노테이션이 붙은 클래스를 찾아서 다 스프링빈으로 등록해줌
@ComponentScan (
        //basePackages = "hello.core.member",      // 탐색할 패키지의 시작위치를 지정한다.
        // 컴포넌트 스캔으로 등록할때 그중에서 빼야 될 것을 지정해줌
        //Configuration가 붙은 클래스는 다 빼겠다. (수동으로 빈으로 등록하는 예제인 AppConfig가 등록되는 것을 막기 위해서.)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {


}
