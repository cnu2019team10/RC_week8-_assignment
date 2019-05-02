package repository;

import domain.CrewMember;

import java.util.List;

public abstract class MockRepository {
    public abstract List<CrewMember> findAll();
    public abstract CrewMember findByName(String name);
    abstract CrewMember updatePositionByName(String Name, String Position);

    public abstract void addCrewMember(CrewMember member);
}
