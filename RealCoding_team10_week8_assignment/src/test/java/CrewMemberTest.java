import domain.CrewMember;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CrewMemberTest {
    private List<CrewMember> crewMemberList = new ArrayList<CrewMember>();

    @Before
    public void setUp(){

        //6개의 동아리 멤버 객체를 만들어줌.
        CrewMember chairman = new CrewMember("지효","회장", 201502012);
        CrewMember vicechairman = new CrewMember("채영","부회장", 201502013);
        CrewMember manager = new CrewMember("정연","총무", 201502014);
        CrewMember member1 = new CrewMember("나연","회원1", 201802039);
        CrewMember member2 = new CrewMember("모모","회원2", 201802040);
        CrewMember newmember = new CrewMember("다현","신입생", 201902039);

        //동아리멤버 리스트에 각 회원들을 추가해줌.
        crewMemberList.add(chairman);
        crewMemberList.add(vicechairman);
        crewMemberList.add(manager);
        crewMemberList.add(member1);
        crewMemberList.add(member2);
        crewMemberList.add(newmember);
    }
}