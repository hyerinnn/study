package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDistcountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
// 각각의 역할을 분명하게!


    public MemberService memberService(){
        // Service 객체에 memberRepository의 구현체를 생성해 주입
        //return new MemberServiceImpl(new MemoryMemberRepository());
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


    public OrderService orderService() {

        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
        //return new OrderServiceImpl(new MemoryMemberRepository(), new RateDistcountPolicy());

    }

    public DiscountPolicy distcountPolicy() {
        return new FixDiscountPolicy();
    }


}
