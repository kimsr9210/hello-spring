package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class MemoryMemberRepository implements MemberRepository{ //구현체

    private static Map<Long, Member> store = new HashMap<>(); //save할때 어딘가에 저장해야함 key : id(Long)
    private static long sequence = 0L; //시퀀스

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //회원을 저장할때마다 시퀀스 값을 하나씩 올려줌
        store.put(member.getId(),member); 
        return member; //저장된 결과 반환
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //store에서 아이디를 꺼내옴
        //Optional. : null이 반환될 가능성이 있을때 Optional 을 감싸줌
    }

    @Override
    public Optional<Member> findByName(String name) {
        //람다식
        //store에서 루프 돌림
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //member에서 member.getName이 파라미터로 넘어온 name이랑 같은지 확인
                .findAny(); //찾으면 반환해줌
                //.findAny() : 하나라도 찾음 => 루프를 돌렸는데 값이 없으면 null 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store.value : Member들..
    }
    //자바에서 실무할땐 list를 많이 씀 => 루프돌리기 편해서

    public void clearStore() {
		store.clear();
	}
}
