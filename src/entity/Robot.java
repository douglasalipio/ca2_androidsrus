/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author hal-9000
 */
public class Robot {

    private final long serialNumber;
    private String model;
    private String brain;
    private String mobility;
    private String vision;
    private String arms;
    private String mediaCenter;
    private String powerPlant;
    private int donatorCount;

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

    public Robot() {
        this.serialNumber = System.nanoTime();
    }

    public void attachMoodel(String model) {
        this.model = model;
    }

    public void attachBrain(String brain) {
        this.brain = brain;
    }

    public void attachMobility(String mobility) {
        this.mobility = mobility;
    }

    public void attachVision(String vision) {
        this.vision = vision;
    }

    public void attachArms(String arms) {
        this.arms = arms;
    }

    public void attachMediaCenter(String mediaCenter) {
        this.mediaCenter = mediaCenter;
    }

    public void attachPowerPlant(String powerPlant) {
        this.powerPlant = powerPlant;
    }

    public String getModel() {
        return model;
    }

    public String getBrain() {
        return brain;
    }

    public String getMobility() {
        return mobility;
    }

    public String getVision() {
        return vision;
    }

    public String getArms() {
        return arms;
    }

    public String getMediaCenter() {
        return mediaCenter;
    }

    public String getPowerPlant() {
        return powerPlant;
    }

    public int getDonatorCount() {
        return donatorCount;
    }

    public long getSerialNumber() {
        return this.serialNumber;
    }

    public boolean isDonate() {
        return donatorCount <= 2;
    }

    @Override
    public String toString() {
        return "---------------Android Information --------------\n"
                + "Model: " + model + "\n"
                + "SerialNum: " + serialNumber + "\n"
                + "Brain: " + brain + "\n"
                + "Mobility: " + mobility + "\n"
                + "Vision: " + vision + "\n"
                + "Arms: " + arms + "\n"
                + "Media Center: " + mediaCenter + "\n"
                + "Power Plant: " + powerPlant + "\n"
                + "--------------------------------------------------";
    }

    public enum Component {
        BRAIN,
        MOBILITY,
        VISION,
        ARMS,
        MEDI_CENTER,
        POWER_PLANT,
        UNAVAILABLE
    }

}
