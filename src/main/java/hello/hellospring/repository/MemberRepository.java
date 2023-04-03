package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //null 일때 (java8에 들어가 있는 기능)
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
