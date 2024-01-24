package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/*
* SPRING JPA : 구현클래스를 작성할 필요없이 인터페이스 만으로 데이터베이스에 접근할 수 있음
*
* */

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{ //interface 끼리 상속 받을때에는 implement가 아니라 "extends"를 해줘야함!!
    //JpaRepository<Member, Entity 식별자 pk 타입>
    //인터페이스는 다중 상속 가능함

    //스프링 데이터 JPA가 리포지토리(인터페이스)를 보고 스프링 빈을 자동으로 만들어서 객체를 (프로시라는 기술이 있음) 생성해서 스프링 빈을 올림
    //우리는 그걸 인젝션 해서 사용함
    //기본적인 메소드 CRUD는 JpaRepository여기에 다 있음


    //select m from Member m where m.name = ? jap가 이렇게 짜줌 이게 sql로 번역이 되서 실행됨
    @Override
    Optional<Member> findByName(String name);
    //Optional<Member> findByNameAndId(String name, Long id);

    //QueryDSL : 실무에서 동적쿼리를 사용하는 방법
    
    //네이티브쿼리 : 쌩짜로 sql을 짜는것
}
