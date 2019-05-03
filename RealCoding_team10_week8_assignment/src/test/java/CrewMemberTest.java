import domain.CrewMember;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import repository.MockRepository;
import service.MockService;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CrewMemberTest {
    private List<CrewMember> crewMemberList = new ArrayList<CrewMember>();

    @Mock
    private MockRepository mockRepository;

    @InjectMocks
    private MockService mockService;

    @Before
    public void setUp() {

        //6개의 동아리 멤버 객체를 만들어줌.
        CrewMember chairman = new CrewMember("지효", "회장", 201502012);
        CrewMember vicechairman = new CrewMember("채영", "부회장", 201502013);
        CrewMember manager = new CrewMember("정연", "총무", 201502014);
        CrewMember member1 = new CrewMember("나연", "회원1", 201802039);
        CrewMember member2 = new CrewMember("모모", "회원2", 201802040);
        CrewMember newmember = new CrewMember("다현", "신입생", 201902039);

        //동아리멤버 리스트에 각 회원들을 추가해줌.
        crewMemberList.add(chairman);
        crewMemberList.add(vicechairman);
        crewMemberList.add(manager);
        crewMemberList.add(member1);
        crewMemberList.add(member2);
        crewMemberList.add(newmember);
    }
    @Test
    public void CrewMemberCountSix(){
        assertThat(crewMemberList.size(), is(6));
        assertThat(crewMemberList, hasSize(6));
    } 	//동아리 회원수가 6명인지 아닌지 확인하는 test

    @Test
    public void shouldNewmemberIsDaHyun(){
        Optional<CrewMember> filterCrewMember = crewMemberList.stream().filter(c -> c.getPosition().equals("신입생")).findFirst();
        String CrewmemberName = filterCrewMember.get().getName();
        assertTrue(CrewmemberName.equals("다현"));
        assertThat("다현",is(CrewmemberName));
        System.out.println("다현이는 신입생이다!");
    } //다현이가 신입생임을 확인하는 test

    @Test
    public void FakeObjectReturnTimes(){
        //given
        given(mockRepository.findByName("쯔위")).willReturn(new CrewMember("쯔위", "교육부장", 201502145));
        given(mockRepository.findByName("사나")).willReturn(new CrewMember("사나", "신입생3", 201902423));
        given(mockRepository.findByName("미나")).willReturn(new CrewMember("미나", "회원3", 201802411));
        //when
        CrewMember crewMember = mockService.findByNmae("쯔위");
        CrewMember crewMember1 = mockService.findByNmae("사나");
        //then
        verify(mockRepository, atLeast(2)).findByName(anyString());
        assertThat(crewMember.getName(),is("쯔위"));
        assertThat(crewMember1.getName(), is("사나"));
    }
}
