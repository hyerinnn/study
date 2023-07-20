package hello.core.member;


import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
// 부모 MemberRepository는 선언만 하고, 여기서 메소드내용을 구현한다.(implements, 오버라이딩)
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
