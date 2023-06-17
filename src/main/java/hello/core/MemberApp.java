package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    //psvm 엔터
    public static void main(String[] args) {

       //MemberService  memberService = new MemberServiceImpl();


        AppConfig appConfig = new AppConfig();
        MemberService  memberService = appConfig.memberService();




        //new부터 작성하고 앞에서 ctr + alt + v
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("Member = " + member.getName());

        System.out.println("findMember = " + findMember.getName());


    }
}
