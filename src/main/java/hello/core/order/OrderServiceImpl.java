package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDistcountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // 잘설계된 케이스 :  orderService는 할인에 관한건 모르겠고, discountPolicy 쪽에서 알아서 해주고 결과만 던져줘.
    // 할인이 바뀌면  주문은 놔두고 할인쪽(discountPolicy)만 변경하면 됨.


    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // as-is (변경되기전 정액 할인 적용)
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // to-be (변경 후 정률 할인 적용)
    private final DiscountPolicy discountPolicy = new RateDistcountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        //1. 회원정보 조회
        Member member = memberRepository.findById(memberId);

        //2. 할인정책에 회원정보 넘김
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
