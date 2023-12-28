package May.myFirstSpring.repository;

import java.util.List;
import May.myFirstSpring.domain.Member;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원이 저장소에 저장되는 것
    Optional<Member> findById(Long id); //이건 있으면 찾고 없으면 null
    Optional<Member> findByName(String name);
    List<Member> findAll(); //모든 회원 리스트 반환

//    void clearStore();
}
