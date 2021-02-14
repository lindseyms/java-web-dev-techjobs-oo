package org.launchcode.techjobs_oo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        id = nextId;
        nextId++;

    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        return id == job.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString(){
        String dataIsNull = "Data not available";
        ArrayList<String> nullReplacedWithString = new ArrayList<>();
        ArrayList<String> originalDataFromConstructor = new ArrayList<>();
        Collections.addAll(originalDataFromConstructor, this.getName(), this.getEmployer().getValue(), this.getLocation().getValue(), this.getPositionType().getValue(), this.getCoreCompetency().getValue());

        for(String value : originalDataFromConstructor){
            if(value == null || value.isEmpty()){
                nullReplacedWithString.add(dataIsNull);

            }else{
                nullReplacedWithString.add(value);
            }

        }

        return String.format("\nID: %s\nName: %s\nEmployer: %s\nLocation: %s\nPosition Type: %s\nCore Competency: %s\n",
                this.getId(),nullReplacedWithString.get(0), nullReplacedWithString.get(1), nullReplacedWithString.get(2),
                nullReplacedWithString.get(3), nullReplacedWithString.get(4));
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
