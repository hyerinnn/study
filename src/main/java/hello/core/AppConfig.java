package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        // Service 객체에 memberRepository의 구현체를 생성해 주입
        return new MemberServiceImpl(new MemoryMemberRepository());
    }


    public OrderService orderService() {

        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }




}
