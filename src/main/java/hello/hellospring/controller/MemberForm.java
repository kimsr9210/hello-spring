package hello.hellospring.controller;

public class MemberForm {
    /**
     * members/createMemberFrom.html -> name 매칭이 되면서 값이 들어옴
     * 웹 등록 화면에서 데이터를 전달 받은 폼 객체
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
