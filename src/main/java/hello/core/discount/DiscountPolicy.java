package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @return 할인 대상 금액 (얼마를 할인해주는지)
     */
    int discount(Member member, int price);


}
