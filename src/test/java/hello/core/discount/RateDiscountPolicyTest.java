package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy distcountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_ok() {
        //given
        Member member = new Member(1L, "VIP", Grade.VIP);
        //when
        int discount = distcountPolicy.discount(member, 10000);
        //then

        // static import 하면 좋음
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_no() {
        //given
        Member member = new Member(2L, "VIP", Grade.BASIC);
        //when
        int discount = distcountPolicy.discount(member, 10000);
        //then
        //assertThat(discount).isEqualTo(1000);
        assertThat(discount).isEqualTo(0);
    }
}