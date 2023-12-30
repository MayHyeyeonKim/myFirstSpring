package May.myFirstSpring;

import May.myFirstSpring.repository.MemberRepository;
import May.myFirstSpring.repository.MemoryMemberRepository;
import May.myFirstSpring.servics.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
