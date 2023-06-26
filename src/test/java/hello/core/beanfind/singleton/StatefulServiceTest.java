package hello.core.beanfind.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void StatefulServiceSingleton(){


        /**
            * !!!!!중요!! 실무에서 종종 발생하는 케이스!!!!!!!
            * 사용자A가 10000을 주문하고 주문금액을 조회하는 사이에 사용자B가 20000원을 주문하는 경우,
            * 싱글톤의 객체를 재사용하는 바람에,  사용자A가 조회한 주문금액은 20000원이 되어버린다.
            *
            * StatefulService 의 price가 10000 -> 20000으로 셋팅되어버림
            *
            *  => 스프링빈은 무상태(stateless)로 설계해야한다.
        * */

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자 10000원 주문
        statefulService1.order("userA", 10000);
        // ThreadB : B사용자 20000원 주문
        statefulService2.order("userB", 20000);

        // ThreadA : A사용자 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }


    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}