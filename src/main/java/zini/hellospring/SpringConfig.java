package zini.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zini.hellospring.aop.TimeTraceAop;
import zini.hellospring.repository.JdbcMemberRepository;
import zini.hellospring.repository.JdbcTemplateMemberRepository;
import zini.hellospring.repository.JpaMemberRepository;
import zini.hellospring.repository.MemberRepository;
import zini.hellospring.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    // @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

    // Spring JPA에 등록했기 때문에 설정 필요 X
//    @Bean
//    public MemberRepository memberRepository(){
//        return new JpaMemberRepository(em);
//    }

}
