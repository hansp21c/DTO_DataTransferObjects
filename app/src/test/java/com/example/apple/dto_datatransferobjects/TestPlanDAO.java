package com.example.apple.dto_datatransferobjects;

import com.example.apple.dto_datatransferobjects.dao.IPlantDAO;
import com.example.apple.dto_datatransferobjects.dao.PlantDaoStub;
import com.example.apple.dto_datatransferobjects.dto.PlantDTO;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Created by apple on 9/12/17.
 */

public class TestPlanDAO {

    // define a variable for the DAO we are testing
    IPlantDAO plantDAO;

    @Before
    public void setup() {
        plantDAO = new PlantDaoStub();
    }

    @Test
    public void testPlantDAO_searchForRedbudShouldReturnAtLeastOneResult() {

        // assume we do not have a match
        boolean redbudFound = false;

        List<PlantDTO> plants = plantDAO.fetchPlants("Redbud12"); // Eastern Redbud, or Redbud1이어도 에러 없음. PlantDatoStub보면 filter 값 처리하는 것 없음

        for (PlantDTO plant : plants) {
            if (plant.getCommon().contains("Redbud")) { // Eastern Redbud 에 들어가 있음
                redbudFound = true;
            }
        }
        // did we find a redbud ?
        assertTrue(redbudFound);

    }
}
