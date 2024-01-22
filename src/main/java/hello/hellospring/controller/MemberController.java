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

/*디펜던시인젝션 3가지 방법
    1. 생성자를 통해서 들어오는 방법 ======> 요즘은 이 방법을 권장함
    2. 필드주입 -> @Autowired private final MemberService ms;
    *필드주입 단점 : 별로 안좋음 바꿀 수 있는 방법이 없음
    3.셋터 주입
    @Autowired //컨트롤러랑 서비스랑 연결
    public  MemberContorller(MemberService memberService) {
        this.memberService = memberService;
        memberService.memberRepository();
    }
    *셋터주입 단점 : 누군가 멤버컨트롤을 호출했을때 퍼블릭으로 열려있어야함
*/

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
