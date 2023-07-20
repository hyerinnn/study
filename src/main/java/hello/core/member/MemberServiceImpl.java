package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// 서비스에 대한 구현체
public class MemberServiceImpl implements MemberService {

   // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    @Autowired //@Component 붙이고 의존관계 설정을 위해 @Autowired를 사용함.
    //생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {

        return memberRepository.findById(memberId);
    }

    // 테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
