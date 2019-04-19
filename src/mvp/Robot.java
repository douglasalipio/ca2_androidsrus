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
        return brain;
    }

    public String doateMobility() {
        return mobility;
    }

    public String donateVision() {
        return vision;
    }

    public String donateArms() {
        return arms;
    }

    public String donateMediaCenter() {
        return mediaCenter;
    }

    public String donatePowerPlant() {
        return powerPlant;
    }

    public void attachModel() {
        this.model = model;
    }

    public String donateModel() {
        return model;
    }

    public long getSerialNumber() {
        return this.serialNumber;
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
