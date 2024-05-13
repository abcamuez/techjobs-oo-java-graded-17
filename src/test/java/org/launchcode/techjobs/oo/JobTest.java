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
}
