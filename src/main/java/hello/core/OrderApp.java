package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl(memberRepository);
        //OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Long member2Id = 2L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        Member member2 = new Member(member2Id, "memberB", Grade.BASIC);

        memberService.join(member);
        memberService.join(member2);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Order order2 = orderService.createOrder(member2Id, "itemA", 10000);

        System.out.println("order = " + order.toString());
        System.out.println("order2 = " + order2.toString());

        System.out.println("order = " + order.calculatePrice());
        System.out.println("order2 = " + order2.calculatePrice());


    }
}
