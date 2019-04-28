/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.tuple.MutablePair;

/**
 * Provide a way to create robot.
 *
 * @author hal-9000
 */
public class Robot {

    private final long serialNumber;
    private final String model;
    private final List<MutablePair<Long, Component>> components = new ArrayList();
    private int donatorCount;

    /**
     * Creating a robot instance.
     *
     * @param model
     */
    public Robot(String model) {
        this.model = model;
        this.serialNumber = System.nanoTime();
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
     * @param mapComponent Adding a component.
     */
    public void attachComponent(MutablePair<Long, Component> mapComponent) {
        this.components.add(mapComponent);
    }

    /**
     * @param mapComponents Adding a list of component.
     */
    public void attachComponent(List<MutablePair<Long, Component>> mapComponents) {
        this.components.addAll(mapComponents);
    }

    public List<MutablePair<Long, Component>> getComponents() {
        return this.components;
    }

    /**
     * Donating brain
     *
     * @param type
     * @return
     */
    public MutablePair<Long, Component> donateComponent(Component.Type type) {
        MutablePair<Long, Component> auxMap = null;
        for (MutablePair<Long, Component> mapComp : components) {
            if (mapComp.getValue().getType() == type) {
                //auxMap = copy(mapComp);
                mapComp.getValue().setAvailable(false);
                //mapComp.getValue().setValue("");
                donatorCount++;
                return mapComp;
            }
        }
        return auxMap;
    }

    public MutablePair<Long, Component> copy(MutablePair<Long, Component> oldObject) {
        MutablePair<Long, Component> newObject = new MutablePair();
        newObject.left = oldObject.left;
        newObject.right= new Component(oldObject.right.getValue(), oldObject.right.getType());
        return newObject;
    }

    /**
     * @return Printing robot.
     */
    @Override
    public String toString() {
        var label = "";
        for (MutablePair<Long, Component> map : components) {
            label += "" + map.getValue().getLabel() + " - " + map.getValue().getValue() + "\n";

        }
        return "-----------------------------\n"
                + "Model: " + model + "\n"
                + "SerialNum: " + serialNumber + "\n"
                + label + "\n"
                + "----------------------------";
    }
}
