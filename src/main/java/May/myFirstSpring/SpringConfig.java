package May.myFirstSpring;

import May.myFirstSpring.repository.JdbcMemberRepository;
import May.myFirstSpring.repository.JdbcTemplateMemberRepository;
import May.myFirstSpring.repository.MemberRepository;
//import May.myFirstSpring.repository.MemoryMemberRepository;
import May.myFirstSpring.servics.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
//import javax.xml.crypto.Data;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
