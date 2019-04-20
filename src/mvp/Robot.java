/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

import java.util.Date;

/**
 *
 * @author hal-9000
 */
public class Robot {

    private long serialNumber;
    private String model;
    private String brain;
    private String mobility;
    private String vision;
    private String arms;
    private String mediaCenter;
    private String powerPlant;
    private static int donatorCount;

    public Robot(
            String model,
            String brain,
            String mobility,
            String vision,
            String arms,
            String mediaCenter,
            String powerPlant) {

        this.model = model;
        this.brain = brain;
        this.mobility = mobility;
        this.vision = vision;
        this.arms = arms;
        this.mediaCenter = mediaCenter;
        this.powerPlant = powerPlant;
        this.serialNumber = System.nanoTime();
    }

    public void attachModel(String model) {
        this.model = model;
    }

    public void attachBrain(String brain) {
        this.brain = brain;
    }

    public void attachMobility(String mobility) {
        this.mobility = mobility;
    }

    public void attchVision(String vision) {
        this.vision = vision;
    }

    public void attchArms(String arms) {
        this.arms = arms;
    }

    public void attachMediaCenter(String mediaCenter) {
        this.mediaCenter = mediaCenter;
    }

    public void attachPowerPlant(String powerPlant) {
        this.powerPlant = powerPlant;
    }

    public long attachSerialNumber() {
        return serialNumber;
    }

    public String donateBrain() {
        String brainDonated = model;
        this.brain = "";
        ++donatorCount;
        return brainDonated;
    }

    public String doateMobility() {
        String mobilityDonated = model;
        this.mobility = "";
        ++donatorCount;
        return mobilityDonated;
    }

    public String donateVision() {
        String visionDonated = model;
        this.vision = "";
        ++donatorCount;
        return visionDonated;
    }

    public String donateArms() {
        String armsDonated = model;
        this.arms = "";
        ++donatorCount;
        return armsDonated;
    }

    public String donateMediaCenter() {
        String mediaCenterDonated = model;
        this.mediaCenter = "";
        ++donatorCount;
        return mediaCenterDonated;
    }

    public String donatePowerPlant() {
        String powerPlantDonated = model;
        this.powerPlant = "";
        ++donatorCount;
        return powerPlantDonated;
    }

    public String donateModel() {
        String modelDonated = model;
        this.model = "";
        ++donatorCount;
        return modelDonated;
    }

    public long getSerialNumber() {
        return this.serialNumber;
    }

    public boolean isDonate() {
        return donatorCount != 2;
    }

    @Override
    public String toString() {
        return "------------ v1 Android Information --------------\n"
                + "Model: " + model + "\n"
                + "SerialNum: " + serialNumber + "\n"
                + "Brain:" + brain + "\n"
                + "Mobility:" + mobility + "\n"
                + "Vision:" + vision + "\n"
                + "Arms: " + arms + "\n"
                + "Media Center:" + mediaCenter + "\n"
                + "Power Plant:" + powerPlant + "\n"
                + "--------------------------------------------------";
    }

}
