package zini.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import zini.hellospring.service.MemberService;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired // Spring이 멤버 서비스를 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
