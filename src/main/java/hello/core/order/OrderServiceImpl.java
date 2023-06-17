package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // 잘설계된 케이스 :  orderService는 할인에 관한건 모르겠고, discountPolicy 쪽에서 알아서 해주고 결과만 던져줘.
    // 할인이 바뀌면  주문은 놔두고 할인쪽(discountPolicy)만 변경하면 됨.


    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    /*
       1.
         // as-is (변경되기전 정액 할인 적용)
            //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

       2.
        // to-be (변경 후 정률 할인 적용)
            //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

          => 위처럼 to-be로 변경하게 되면 OrderServiceImpl의 소스코드를 수정하게 되므로 OCP를 위반하게 된다.
          여기서 문제는 클라이언트 코드인 OrderServiceImpl는 DiscountPolicy의 인터페이스뿐 아니라 구체 클래스(Fix~,Rate~)도 함께
          의존하고 있다는 것이다. 그래서 구체 클래스를 변경할 때 클라이언트 코드도 함께 변경해야 한다.
          => DIP 위반 : 추상에만 의존하도록 변경(인터페이스에만 의존)
          DIP를 위반하지 않도록 인터페이스에만 의존할 수 있게 변경하면 된다.
     */

    // 3. 인터페이스에만 의존하도록 변경   ->  구현체가 없어서 NPE 발생한다.
    //private  DiscountPolicy discountPolicy;

    // 4. 구현객체를 생성하고 별도로 연결해주는 AppConfig를 생성해서 작업 (생성자주입)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        //1. 회원정보 조회
        Member member = memberRepository.findById(memberId);

        //2. 할인정책에 회원정보 넘김
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
