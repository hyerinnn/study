package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    //psvm 엔터
    public static void main(String[] args) {

       //MemberService  memberService = new MemberServiceImpl();
/*

        AppConfig appConfig = new AppConfig();
        MemberService  memberService = appConfig.memberService();

*/

        //위에 두줄을 스프링으로 변환
        //appconfig에 대한 설정정보@Bean들을 스프링 컨터이너에 다 등록해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService  memberService = applicationContext.getBean("memberService", MemberService.class); // 이름은 첫번째인자 이고 타입은 두번째 인자

        //new부터 작성하고 앞에서 ctr + alt + v
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("Member = " + member.getName());

        System.out.println("findMember = " + findMember.getName());


    }
}
