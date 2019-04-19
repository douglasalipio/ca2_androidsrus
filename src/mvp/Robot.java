/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvp;

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
        this.serialNumber = System.currentTimeMillis();
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrain(String brain) {
        this.brain = brain;
    }

    public void setMobility(String mobility) {
        this.mobility = mobility;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public void setMediaCenter(String mediaCenter) {
        this.mediaCenter = mediaCenter;
    }

    public void setPowerPlant(String powerPlant) {
        this.powerPlant = powerPlant;
    }

    public long getSerialNumber() {
        return serialNumber;
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
