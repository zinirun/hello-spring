package zini.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zini.hellospring.domain.Member;

import java.util.Optional;

// 인터페이스가 인터페이스를 받을때: extends
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // findBy + ~ => JPA가 알아서 만들어줌 (인터페이스 이름만으로)
    @Override
    Optional<Member> findByName(String name);
}
