package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository  implements MemberRepository {

    //jpa는 엔티티매니저라는 것으로 모든게 동작을함
    //데이터 소스를 들고 있어서 DB랑 통신하는것을 내부에서 처리를 해줌
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //persist() : 영구 저장하다
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class,id); //find() : 조회 -> find(조회할타입, pk)
        return Optional.ofNullable(member); //Optional() : 값이 없을경우
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
