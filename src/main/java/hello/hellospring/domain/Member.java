package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {
    //getter setter 만는법 우마우스 -> 그랜트 -> 겟터셋터

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //@Column(name = "username") db에 컬럼 이름이 username 이라면
    private Long id; //시스템이 저장하는 아이디
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
