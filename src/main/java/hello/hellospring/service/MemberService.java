package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional //데이터를 저장하고 변경할때 트랜젝선을 써야함, JPA는 join들어올때 모든데이터 변경이 트렌젝션 안에서 실행되어야함
public class MemberService {

    //기존코드
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    @Autowired //컨트롤러랑 서비스랑 연결
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입

    public Long join(Member member) {

        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    //검증 메서드
    public void validateDuplicateMember(Member member){
        //같은 이름이 있는 중복 회원 x
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { //값이 있으면
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    //전체회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

