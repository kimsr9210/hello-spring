package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

	//테스트 하나가 끝나면 데이터를 클리어 해줘야함
	 @AfterEach //메서드가 끝날때마다 동작을함
	 public void afterEach() {
		repository.clearStore(); //테스트가 실행이 되고 끝날때마다 한번씩 저장소를 다 치움
	 }

    @Test
    public void save(){
		 //given
		Member member = new Member();
		member.setName("spring"); //이름 셋팅

		repository.save(member); //저장

		//when
		Member result = repository.findById(member.getId()).get();
		//반환타입이 옵셔널이면? => 옵셔널에서 값을 꺼낼때는 .get()으로 꺼내야함

		//then 검증
		//System.out.println("result = " + (result == member));
		//Assertions.assertEquals(member, result);
		assertThat(member).isEqualTo(result); //같은지 확인
    }

	@Test
	public void findByName(){
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member1);

		Member result = repository.findByName("spring1").get();
		assertThat(result).isEqualTo(member1); //같은지 확인
	}

	@Test
	public void findAll(){
		Member member1 = new Member();
		member1.setName("spring1"); //저장
		repository.save(member1);
		

		Member member2 = new Member();
		member1.setName("spring2"); //저장
		repository.save(member2);

		List<Member> result = repository.findAll();
		assertThat(result.size()).isEqualTo(2); //회원이 두명이 맞는지 확인
	}
}
