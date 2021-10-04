package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertEquals("Product tester", job3.getName());
        Assert.assertEquals("ACME", job3.getEmployer().getValue());
        Assert.assertEquals("Desert",job3.getLocation().getValue());
        Assert.assertEquals("Quality control", job3.getPositionType().getValue());
        Assert.assertEquals("Persistence",job3.getCoreCompetency().getValue());
        Assert.assertTrue(job3.getEmployer() instanceof Employer);
        Assert.assertTrue(job3.getLocation() instanceof Location);
        Assert.assertTrue(job3.getPositionType() instanceof PositionType);
        Assert.assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        Assert.assertTrue(job3 instanceof Job);
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        assertFalse(job1.getId() != job2.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
       String text = job1.toString();
        assertEquals('\n',text.charAt(0));
        assertEquals('\n', text.charAt(text.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String text = '\n' +
                "ID: 1\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence"+
                '\n';
        assertEquals(text,job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String text = '\n' +
                "ID: 1\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Persistence"+
                '\n';
        assertEquals(text,job1.toString());
    }
}
