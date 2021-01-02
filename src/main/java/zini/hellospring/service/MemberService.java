package zini.hellospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zini.hellospring.domain.Member;
import zini.hellospring.repository.MemberRepository;
import zini.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// Test 자동 생성 -> Ctrl Shift T
//@Service
public class MemberService {
    private final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입 (같은 이름 중복 X)
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // 메소드 추출 -> Ctrl Alt M
    private void validateDuplicateMember(Member member) {
        // Ctrl + Alt + V -> Optional 자동
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
