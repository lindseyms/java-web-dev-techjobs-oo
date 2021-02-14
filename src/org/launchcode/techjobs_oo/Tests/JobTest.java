package org.launchcode.techjobs_oo.Tests;

import org.junit.*;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private static Job job1;
    private static Job job2;
    private static Job job3;
    private static Job job4;

    @BeforeClass
    public static void createJobObjects(){
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job(null, new Employer(), new Location(""), new PositionType(), new CoreCompetency());
    }

    @Test
    public void testSettingJobId(){
        assertEquals(1, job1.getId());
        assertEquals(2, job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(3, job3.getId());
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testJobToStringReturnsCorrectIDLabelAndField(){
        assertTrue(job3.toString().contains("\nID: 3\n"));
    }

    @Test
    public void testJobToStringReturnsNameLabelAndFieldIfNotNull(){
        assertTrue(job3.toString().contains("Name: Product tester\n"));
    }

    @Test
    public void testJobToStringNameIsNull(){
        assertTrue(job4.toString().contains("Name: Data not available\n"));
    }

    @Test
    public void testJobToStringReturnsEmployerLabelAndFieldIfNotNull(){
        assertTrue(job3.toString().contains("Employer: ACME\n"));
    }

    @Test
    public void testJobToStringEmployerIsNull(){
        assertTrue(job4.toString().contains("Employer: Data not available\n"));
    }

    @Test
    public void testJobToStringReturnsLocationLabelAndFieldIfNotNull(){
        assertTrue(job3.toString().contains("Location: Desert\n"));
    }

    @Test
    public void testJobToStringPositionTypeIsNull(){
        assertTrue(job4.toString().contains("Position Type: Data not available\n"));
    }

    @Test
    public void testJobToStringReturnsPositionTypeLabelAndFieldIfNotNull(){
        assertTrue(job3.toString().contains("Core Competency: Persistence\n"));
    }

    @Test
    public void testJobToStringCoreCompetencyIsNull(){
        assertTrue(job4.toString().contains("Core Competency: Data not available\n"));
    }




}
