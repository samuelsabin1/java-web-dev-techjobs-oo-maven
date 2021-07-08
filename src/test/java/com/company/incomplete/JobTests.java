package com.company.incomplete;

import com.company.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JobTests {
    // you can rename the tests, or delete them and rewrite them from scratch, but I went ahead and provided you the names of tests I created -- I followed the writeup pretty honestly
    static Job job1, job2,job3;

    @BeforeAll
    static void createJob(){
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType(
                "Front-end" +
                " developer"), new CoreCompetency("JavaScript"));
        job3 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"),
                new CoreCompetency("Tasting ability"));
        System.out.println(job3.getId());
        System.out.println(job3.toString());

    }


    @Test
    public void testSettingJobId() {
        System.out.println(job1.getId());
        System.out.println(job2.getId());
        assertEquals(1, ((job2.getId())-(job1.getId())));
    }




    @Test
    public void testJobConstructorSetsAllFields() {
       Integer id1 = job1.getId();
//        assertTrue(id1 != 0);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getPositionType() instanceof  PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getName() != "");

    }

    @Test
    public void testJobsForEquality() {
        Integer id1 = job1.getId();
        Integer id2 = job2.getId();
        assertTrue(id1 != id2);
        assertTrue(job1.getEmployer() == job2.getEmployer());
        assertTrue(job1.getPositionType() == job2.getPositionType());
        assertTrue(job1.getCoreCompetency() == job2.getCoreCompetency());
        assertTrue(job1.getLocation() == job2.getLocation());
        assertTrue(job1.getName() != "");

    }

    // I found the instructions around the three toString() tests a little confusing, so I created three tests following the three bullet points:
    // you can follow TDD if you want, or you can write the implementation first and then get the tests to pass, either is a fine approach
    @Test
    public void testToStringContainsBlankLines() {
        String newline = System.getProperty("line.separator");
    assertTrue(job3.toString().contains(newline));
    assertTrue(job3.toString().startsWith("\n"));
    assertTrue(job3.toString().endsWith("\n"));

    }

    @Test
    public void testToStringHasLabelsForEachField() {
    String expected = String.format("\nID: %d\nName: %s\nEmployer: %s\nLocation: %s\nPositionType: " +
                    "%s\nCoreCompetency: %s\n", job2.getId(),
            job2.getName(), job2.getEmployer().getValue(), job2.getLocation().getValue(),
            job2.getPositionType().getValue(), job2.getCoreCompetency().getValue());
    String correct = job2.toString();
    assertEquals(expected, correct);


    }

    @Test
    public void testToStringDataNotAvailable() {
        String expected = String.format("\nID: %d\nName: %s\nEmployer: Data Not Available\nLocation: " +
                        "%s\nPositionType: " +
                        "%s\nCoreCompetency: %s\n", job3.getId(), job3.getName(),
                job3.getLocation().getValue(),
                job3.getPositionType().getValue(), job3.getCoreCompetency().getValue());
        String correct = job3.toString();
        assertEquals(expected, correct);
//    assertTrue(job3.toString().contains("Data Not Available"));
//    assertFalse(job2.toString().contains("Data Not Available"));
//    assertFalse(job1.toString().contains("Data Not Available"));
    }

}
