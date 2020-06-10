package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

    @Autowired
    DistilleryRepository distilleryRepository;

    @Autowired
    WhiskyRepository whiskyRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void canFindWhiskyByYear() {
        List<Whisky> foundWhiskies = whiskyRepository.findByYear(2018);
        assertEquals(6, foundWhiskies.size());
    }

    @Test
    public void canFindDistilleryByRegion() {
        List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Highland");
        assertEquals(3, foundDistilleries.size());
    }

    @Test
    public void canFindWhiskyByDistilleryAndAge() {
        List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryNameAndAge("Talisker", 1);
        assertEquals(2, foundWhiskies.size());
    }

    @Test
    public void canFindWhiskyByDistilleryRegion() {
        List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryRegion("Highland");
        assertEquals(7, foundWhiskies.size());
    }

    @Test
    public void canFindDistilleryWithWhiskyOfASetAge() {
        List<Distillery> foundDistilleries = distilleryRepository.findByWhiskiesAgeIs(12);
        assertEquals(6, foundDistilleries.size());
    }
}
