package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원을 저장하면 저장된 회원이 반환
    Optional<Member> findById(Long id); //아이디로 회원을 찾음
    Optional<Member> findByName(String name); //이름으로 회원을 찾음
    List<Member> findAll(); //지금까지 저장된 모든 회원 리스트를 다 반환
    //Optional : null로 반환되는 대신 Optional로 감싸서 반환되는 방식을 선호 
}
