/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import org.apache.commons.lang3.tuple.MutablePair;

/**
 * Provide a way to create robot.
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

    /**
     * Creating a robot instance.
     */
    public Robot() {
        this.serialNumber = System.nanoTime();
    }

    /**
     * Creating robot.
     *
     * @param model
     * @param brain
     * @param mobility
     * @param vision
     * @param arms
     * @param mediaCenter
     * @param powerPlant
     */
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

    /**
     * @return Donating count.
     */
    public int getDonatorCount() {
        return donatorCount;
    }

    /**
     * @return Getting serial number.
     */
    public long getSerialNumber() {
        return this.serialNumber;
    }

    /**
     * @return Checking if robot is a donator.
     */
    public boolean isDonate() {
        return donatorCount <= 2;
    }

    /**
     * @return Getting model
     */
    public String getModel() {
        return model;
    }

    /**
     * @return Getting brain.
     */
    public MutablePair<Long, String> getBrain() {
        return brain;
    }

    /**
     * @return Getting mobility.
     */
    public MutablePair<Long, String> getMobility() {
        return mobility;
    }

    /**
     * @return Getting vision.
     */
    public MutablePair<Long, String> getVision() {
        return vision;
    }

    /**
     * @return Getting media center
     */
    public MutablePair<Long, String> getMediaCenter() {
        return mediaCenter;
    }

    /**
     * @return Getting power plant.
     */
    public MutablePair<Long, String> getPowerPlant() {
        return powerPlant;
    }

    /**
     * @return Getting arms.
     */
    public MutablePair<Long, String> getArms() {
        return arms;
    }

    /**
     * @param model Attaching model
     */
    public void attachModel(String model) {
        this.model = model;
    }

    /**
     * @param brain Attaching brain
     */
    public void attachBrain(MutablePair<Long, String> brain) {
        this.brain = brain;
    }

    /**
     * @param mobility Attaching mobility
     */
    public void attachMobility(MutablePair<Long, String> mobility) {
        this.mobility = mobility;
    }

    /**
     * @param vision Attaching vision
     */
    public void attachVision(MutablePair<Long, String> vision) {
        this.vision = vision;
    }

    /**
     * @param arms Attaching arms
     */
    public void attachArms(MutablePair<Long, String> arms) {
        this.arms = arms;
    }

    /**
     * @param mediaCenter Attaching media center
     */
    public void attachMediaCenter(MutablePair<Long, String> mediaCenter) {
        this.mediaCenter = mediaCenter;
    }

    /**
     * @param powerPlant Attaching power plant
     */
    public void attachPowerPlant(MutablePair<Long, String> powerPlant) {
        this.powerPlant = powerPlant;
    }

    /**
     * @return Donating brain
     */
    public MutablePair<Long, String> donateBrain() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, brain.getValue());
        donatorCount++;
        this.brain.setValue("");
        return part;
    }

    /**
     * @return Donating powerPlant
     */
    public MutablePair<Long, String> donatePowerPlant() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, powerPlant.getValue());
        donatorCount++;
        this.powerPlant.setValue("");
        return part;
    }

    /**
     * @return Donating mobility
     */
    public MutablePair<Long, String> donateMobility() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, mobility.getValue());
        donatorCount++;
        this.mobility.setValue("");
        return part;
    }

    /**
     * @return Donating vision
     */
    public MutablePair<Long, String> donateVision() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, vision.getValue());
        donatorCount++;
        this.vision.setValue("");
        return part;
    }

    /**
     * @return Donating arms
     */
    public MutablePair<Long, String> donatehArms() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, arms.getValue());
        donatorCount++;
        this.arms.setValue("");
        return part;
    }

    /**
     * @return Donating media center
     */
    public MutablePair<Long, String> donateMediaCenter() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, mediaCenter.getValue());
        donatorCount++;
        this.mediaCenter.setValue("");
        return part;
    }

    /**
     * @return Printing robot.
     */
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
}
