package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {
    //getter setter 만는법 우마우스 -> 그랜트 -> 겟터셋터

    @Id //PK
    //아이덴티티 : DB가 알아서 생성해 주는것을 아이덴티티라고 함 오라클에서는 시퀀스라고 함
    //아이덴티티 전략 => 쿼리에 ID를 넣는게 아니라 DB가 아이디를 자동을 생성해주는 거를 아이덴티티라고 함
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    //@Column(name = "username") db에 컬럼 이름이 username 이라면
    private Long id; //시스템이 저장하는 아이디

    //@Column(name = "username") 만약에 db 컬럼명이 USER NAME 이면 username에 맵핑해줌
    //private String name;
    private String name; //이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
