package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
/*      MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
*/

/*

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
*/
//스프링으로 변환
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService  memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Long member2Id = 2L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        Member member2 = new Member(member2Id, "memberB", Grade.BASIC);

        memberService.join(member);
        memberService.join(member2);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        Order order2 = orderService.createOrder(member2Id, "itemA", 10000);

        System.out.println("order = " + order.toString());
        System.out.println("order2 = " + order2.toString());

        System.out.println("order = " + order.calculatePrice());
        System.out.println("order2 = " + order2.calculatePrice());


    }
}
