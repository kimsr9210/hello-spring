package hello.hellospring.controller;

public class MemberForm {
    /**
     * members/createMemberFrom.html -> name 매칭이 되면서 값이 들어옴
     * 웹 등록 화면에서 데이터를 전달 받은 폼 객체
     */
    private String name; //private이라 접근을 못 하기때문에 setName을 통해서 값을 넣어줌

    //값을 꺼냄
    public String getName() {
        return name;
    }

    //form에서 가져온 name을 set을 통해 넣어줌
    public void setName(String name) {
        this.name = name;
    }
}
