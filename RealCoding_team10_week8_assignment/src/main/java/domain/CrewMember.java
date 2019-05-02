package domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CrewMember {
    private String Name;    //동아리 회원 이름
    private String Position;    //동아리 내에서의 직책
    private int StudentID;  //학번

}
