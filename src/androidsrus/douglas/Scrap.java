/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package androidsrus.douglas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author hal-9000
 */
public class Scrap {

    private Random random = new Random();

    public String generateBrain() {
        String[] brains = {"2.5GHZ", "3.5GHZ", "4.5GHZ"};
        int brainIndex = random.nextInt(brains.length);
        return brains[brainIndex];
    }

    public String generateMobility() {
        String mobilities[] = {"Catapilar tracks", "wheels", "legs"};
        int mobilityIndex = random.nextInt(mobilities.length);
        return mobilities[mobilityIndex];
    }

    public String generateVision() {
        String visions[] = {"Heat vision", "Full colour", "Night vision"};
        int mobilityIndex = random.nextInt(visions.length);
        return visions[mobilityIndex];
    }

    public String generateArms() {
        String arms[] = {"Heat vision", "Full colour", "Night vision"};
        int armsIndex = random.nextInt(arms.length);
        return arms[armsIndex];
    }

    public String generateMediaCenter() {
        String mediaCenters[] = {"Sony", "JVC", "Meridian"};
        int mediaCentersIndex = random.nextInt(mediaCenters.length);
        return mediaCenters[mediaCentersIndex];
    }

    public String generatePowerPlant() {
        String powerPlants[] = {"Lithium", "Hydrogen", "Plasma"};
        int powerPlantsIndex = random.nextInt(powerPlants.length);
        return powerPlants[powerPlantsIndex];
    }

    public String generateModel() {
        String models[] = {"Android mk1 ",
            "Android mk2 ",
            "Android mk3 ",
            "Android mk4 ",
            "Android mk5 "};
        int modelsIndex = random.nextInt(models.length);
        return models[modelsIndex];
    }
}
