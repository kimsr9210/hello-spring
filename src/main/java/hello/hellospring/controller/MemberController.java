package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {


    // private final MemberService ms = new MemberService(); 기존코드
    //별 기능이 없어서, 하나만 생성해놓고 공용으로 쓰면됨
    private final MemberService memberService; //스프링 컨테이너에 등록

    //생성자
    @Autowired //(의존 관계 주입)컨트롤러랑 서비스랑 연결
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member.getNamme::::::::::::" + member.getName());

        memberService.join(member);
    return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
