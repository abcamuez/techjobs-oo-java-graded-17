package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.text.Position;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job job = new Job();
        Job job2 = new Job();
        assertNotEquals(job.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){

        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        assertTrue(job.getName().equals("Product tester"));
        assertTrue(job instanceof Job);
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality(){

        Job job1 = new Job("Web developer", new Employer("ACME"), new Location("Dallas"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Web developer", new Employer("ACME"), new Location("Dallas"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

//    @Test
//    public void testObjectToString(){
//        Job job = new Job(1, "Software Enginner", new Employer("ABC Corp"), new Location("Dallas"), new PositionType("Web Developer"), new CoreCompetency("Persistence"));
//        String jobString = job.toString();
//
//        assertTrue(jobString.contains("ID: "));
//        assertTrue(jobString.contains("Name: "));
//        assertTrue(jobString.contains("Employer: "));
//        assertTrue(jobString.contains("Location: "));
//        assertTrue(jobString.contains("Position Type: "));
//        assertTrue(jobString.contains("Core Competency: "));
//    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();
        String actual = job.toString();
        assertTrue("String should start with new line", actual.startsWith(System.lineSeparator()));
        assertTrue("String should end with new line", actual.endsWith(System.lineSeparator()));
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job.toString();
        assertTrue(jobString.contains("ID: " + job.getId()));
        assertTrue(jobString.contains("Name: " + job.getName()));
        assertTrue(jobString.contains("Employer: " + job.getEmployer()));
        assertTrue(jobString.contains("Location: " + job.getLocation()));
        assertTrue(jobString.contains("Position Type: " + job.getPositionType()));
        assertTrue(jobString.contains("Core Competency: " + job.getCoreCompetency()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Web Developer", new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));
        String expected = String.format(
                "ID: %d%nName: Web Developer%nEmployer: Data not available%nLocation: StL%nPosition Type: Data not available%nCore Competency: Java%n",
                job.getId()
        );
        assertEquals(expected, job.toString());
    }


}
