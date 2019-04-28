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
     * Donating count.
     *
     * @return counter.
     */
    public int getDonatorCount() {
        return donatorCount;
    }

    /**
     * Getting serial number.
     *
     * @return
     */
    public long getSerialNumber() {
        return this.serialNumber;
    }

    /**
     * Checking if robot is a donator.
     *
     * @return
     */
    public boolean isDonate() {
        return donatorCount <= 2;
    }

    /**
     * Getting model
     *
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     * Getting brain.
     *
     * @return
     */
    public MutablePair<Long, String> getBrain() {
        return brain;
    }

    /**
     * Getting mobility.
     *
     * @return
     */
    public MutablePair<Long, String> getMobility() {
        return mobility;
    }

    /**
     * Getting vision.
     *
     * @return
     */
    public MutablePair<Long, String> getVision() {
        return vision;
    }

    /**
     * Getting media center
     *
     * @return
     */
    public MutablePair<Long, String> getMediaCenter() {
        return mediaCenter;
    }

    /**
     * Getting power plant.
     *
     * @return
     */
    public MutablePair<Long, String> getPowerPlant() {
        return powerPlant;
    }

    /**
     * Getting arms.
     *
     * @return
     */
    public MutablePair<Long, String> getArms() {
        return arms;
    }

    /**
     * Attaching model
     *
     * @param model
     */
    public void attachModel(String model) {
        this.model = model;
    }

    /**
     * Attaching brain
     *
     * @param brain
     */
    public void attachBrain(MutablePair<Long, String> brain) {
        this.brain = brain;
    }

    /**
     * Attaching mobility
     *
     * @param mobility
     */
    public void attachMobility(MutablePair<Long, String> mobility) {
        this.mobility = mobility;
    }

    /**
     * Attaching vision
     *
     * @param vision
     */
    public void attachVision(MutablePair<Long, String> vision) {
        this.vision = vision;
    }

    /**
     * Attaching arms
     *
     * @param arms
     */
    public void attachArms(MutablePair<Long, String> arms) {
        this.arms = arms;
    }

    /**
     * Attaching media center
     *
     * @param mediaCenter
     */
    public void attachMediaCenter(MutablePair<Long, String> mediaCenter) {
        this.mediaCenter = mediaCenter;
    }

    /**
     * Attaching power plant
     *
     * @param powerPlant
     */
    public void attachPowerPlant(MutablePair<Long, String> powerPlant) {
        this.powerPlant = powerPlant;
    }

    /**
     * Donating brain
     *
     * @return
     */
    public MutablePair<Long, String> donateBrain() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, brain.getValue());
        donatorCount++;
        this.brain.setValue("");
        return part;
    }

    /**
     * Donating powerPlant
     *
     * @return
     */
    public MutablePair<Long, String> donatePowerPlant() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, powerPlant.getValue());
        donatorCount++;
        this.powerPlant.setValue("");
        return part;
    }

    /**
     * Donating mobility
     *
     * @return
     */
    public MutablePair<Long, String> donateMobility() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, mobility.getValue());
        donatorCount++;
        this.mobility.setValue("");
        return part;
    }

    /**
     * Donating vision
     *
     * @return
     */
    public MutablePair<Long, String> donateVision() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, vision.getValue());
        donatorCount++;
        this.vision.setValue("");
        return part;
    }

    /**
     * Donating arms
     *
     * @return
     */
    public MutablePair<Long, String> donatehArms() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, arms.getValue());
        donatorCount++;
        this.arms.setValue("");
        return part;
    }

    /**
     * Donating media center
     *
     * @return
     */
    public MutablePair<Long, String> donateMediaCenter() {
        MutablePair<Long, String> part = new MutablePair(serialNumber, mediaCenter.getValue());
        donatorCount++;
        this.mediaCenter.setValue("");
        return part;
    }

    /**
     * Printing robot.
     *
     * @return
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
