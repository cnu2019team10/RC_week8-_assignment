package service;

import domain.CrewMember;
import repository.MockRepository;

import java.util.List;

public class MockService {
    private final MockRepository mockRepository;

    public MockService(MockRepository mockRepository){
        this.mockRepository = mockRepository;
    }

    public List<CrewMember> findAllCrewMembers() { //
        return mockRepository.findAll();
    }

    public CrewMember findByNmae(String name) { //
        CrewMember CM = mockRepository.findByName(name);
        return CM;
    }

    public CrewMember updatePositionByName(String name, String position){
        CrewMember CM = findByNmae(name);
        CM.setName(position);
        return CM;
    }

    public  void addCrewMember(CrewMember CM){
        CrewMember addCM = new CrewMember(CM.getName(), CM.getPosition(), CM.getStudentID());
        mockRepository.addCrewMember(addCM);
        return;
    }
}
