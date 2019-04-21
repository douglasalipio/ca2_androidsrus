/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import org.apache.commons.lang3.tuple.MutablePair;

/**
 *
 * @author hal-9000
 */
public class Robot {

    private final long serialNumber;
    private String model;
    private MutablePair<Long, String> brain;
    private MutablePair<Long, String> mobility;
    private MutablePair<Long, String> vision;
    private MutablePair<Long, String> arms;
    private MutablePair<Long, String> mediaCenter;
    private MutablePair<Long, String> powerPlant;
    private int donatorCount;

    public Robot() {
        this.serialNumber = System.nanoTime();
    }

    public Robot(
            String model,
            String brain,
            String mobility,
            String vision,
            String arms,
            String mediaCenter,
            String powerPlant) {

        this.serialNumber = System.nanoTime();
        this.model = model;
        this.brain = new MutablePair(serialNumber, brain);
        this.mobility = new MutablePair(serialNumber, mobility);
        this.vision = new MutablePair(serialNumber, vision);
        this.arms = new MutablePair(serialNumber, arms);
        this.mediaCenter = new MutablePair(serialNumber, mediaCenter);
        this.powerPlant = new MutablePair(serialNumber, powerPlant);
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

    public String getModel() {
        return model;
    }

    public MutablePair<Long, String> getBrain() {
        return brain;
    }

    public MutablePair<Long, String> getMobility() {
        return mobility;
    }

    public MutablePair<Long, String> getVision() {
        return vision;
    }

    public MutablePair<Long, String> getMediaCenter() {
        return mediaCenter;
    }

    public MutablePair<Long, String> getPowerPlant() {
        return powerPlant;
    }

    public MutablePair<Long, String> getArms() {
        return arms;
    }

    public void attachModel(String model) {
        this.model = model;
    }

    public void attachBrain(MutablePair<Long, String> brain) {
        this.brain = brain;
    }

    public void attachMobility(MutablePair<Long, String> mobility) {
        this.mobility = mobility;
    }

    public void attachVision(MutablePair<Long, String> vision) {
        this.vision = vision;
    }

    public void attachArms(MutablePair<Long, String> arms) {
        this.arms = arms;
    }

    public void attachMediaCenter(MutablePair<Long, String> mediaCenter) {
        this.mediaCenter = mediaCenter;
    }

    public void attachPowerPlant(MutablePair<Long, String> powerPlant) {
        this.powerPlant = powerPlant;
    }

    public MutablePair<Long, String> donateBrain() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, brain.getValue());
        donatorCount++;
        this.brain.setValue("");
        return part;
    }

    public MutablePair<Long, String> donatePowerPlant() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, powerPlant.getValue());
        donatorCount++;
        this.powerPlant.setValue("");
        return part;
    }

    public MutablePair<Long, String> donateMobility() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, mobility.getValue());
        donatorCount++;
        this.mobility.setValue("");
        return part;
    }

    public MutablePair<Long, String> donateVision() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, vision.getValue());
        donatorCount++;
        this.vision.setValue("");
        return part;
    }

    public MutablePair<Long, String> donatehArms() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, arms.getValue());
        donatorCount++;
        this.arms.setValue("");
        return part;
    }

    public MutablePair<Long, String> donateMediaCenter() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, mediaCenter.getValue());
        donatorCount++;
        this.mediaCenter.setValue("");
        return part;
    }

    @Override
    public String toString() {
        return "-----------------------------\n"
                + "Model: " + model + "\n"
                + "SerialNum: " + serialNumber + "\n"
                + "Brain: " + brain.getValue() + "\n"
                + "Mobility: " + mobility.getValue() + "\n"
                + "Vision: " + vision.getValue() + "\n"
                + "Arms: " + arms.getValue() + "\n"
                + "Media Center: " + mediaCenter.getValue() + "\n"
                + "Power Plant: " + powerPlant.getValue() + "\n"
                + "----------------------------";
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
