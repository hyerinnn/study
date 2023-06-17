package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MemberServiceTest {

    //MemberService memberService = new MemberServiceImpl();
    MemberService memberService;



    @BeforeEach // 테스트 실행전에 무조건 실행
    // 매 테스트 마다 초기화를 해주기 위해 beforeEach실행 -> memberService 객체를 초기화
    public void beforeEach(){
        System.out.println("before");
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    void join(){
        System.out.println("test");

        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("findMember : " + findMember);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }



}

