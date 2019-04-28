package builder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

/**
 *
 * Build Robot components.
 *
 * @author hal-9000
 */
public class ToolsBuilder {

    private final Random random;
    private static final ToolsBuilder INSTANCE = new ToolsBuilder();

    private ToolsBuilder() {
        this.random = new Random();
    }

    public static ToolsBuilder instance() {
        if (INSTANCE == null) {
            return new ToolsBuilder();
        }
        return INSTANCE;
    }

    /**
     * Build a brain component.
     *
     * @return brain
     */
    public String brain() {
        String[] brains = {"2.5GHZ", "3.5GHZ", "4.5GHZ"};
        int brainIndex = random.nextInt(brains.length);
        return brains[brainIndex];
    }

    /**
     * Build a mobility component.
     *
     * @return mobility
     */
    public String mobility() {
        String mobilities[] = {"Catapilar tracks", "wheels", "legs"};
        int mobilityIndex = random.nextInt(mobilities.length);
        return mobilities[mobilityIndex];
    }

    /**
     * Build a vision component.
     *
     * @return vision
     */
    public String vision() {
        String visions[] = {"Heat vision", "Full colour", "Night vision"};
        int mobilityIndex = random.nextInt(visions.length);
        return visions[mobilityIndex];
    }

    /**
     * Build arms component.
     *
     * @return
     */
    public String arms() {
        String arms[] = {"Claws", "Grippers", "Articulated fingers"};
        int armsIndex = random.nextInt(arms.length);
        return arms[armsIndex];
    }

    /**
     * Build a media center component.
     *
     * @return
     */
    public String mediaCenter() {
        String mediaCenters[] = {"Sony", "JVC", "Meridian"};
        int mediaCentersIndex = random.nextInt(mediaCenters.length);
        return mediaCenters[mediaCentersIndex];
    }

    /**
     * Build a power plat component.
     *
     * @return
     */
    public String powerPlant() {
        String powerPlants[] = {"Lithium", "Hydrogen", "Plasma"};
        int powerPlantsIndex = random.nextInt(powerPlants.length);
        return powerPlants[powerPlantsIndex];
    }

    /**
     * Build a model component.
     *
     * @return
     */
    public String v1Model() {
        String models[] = {"Android mk1 ",
            "Android mk2 ",
            "Android mk3 ",
            "Android mk4 ",
            "Android mk5 "};
        int modelsIndex = random.nextInt(models.length);
        return models[modelsIndex];
    }

    /**
     * Build a model component.
     *
     * @return
     */
    public String v2Model() {
        String models[] = {"Andy",
            "Betty",
            "Bobi",
            "Fred"};
        int modelsIndex = random.nextInt(models.length);
        return models[modelsIndex];
    }

}
