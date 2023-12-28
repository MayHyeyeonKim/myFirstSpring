package May.myFirstSpring.repository;

import May.myFirstSpring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("스프링");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
//        System.out.println("result =  " + (result == member));
//        Assertions.assertEquals(member,result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void FindByName() {
        Member member1 = new Member();
        member1.setName("프링글스1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("프링글스2");
        repository.save(member2);

        Member result = repository.findByName("프링글스1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("스핑크스1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("스핑크스2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }



}
