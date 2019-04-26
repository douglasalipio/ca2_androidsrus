/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


/**
 *
 * @author hal-9000
 */
public class Component {

    private long serialNumber;
    private String value;
    private String name;
    private Type type;
    private boolean available = true;

    public Component(String value, Type type) {
        this.name = type.name();
        this.value = value;
        this.type = type;
        this.serialNumber = System.nanoTime();
    }

    public Component() {

    }

    public String getName() {
        return name;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public enum Type {
        BRAIN,
        MOBILITY,
        VISION,
        ARMS,
        MEDIA_CENTER,
        POWER_PLANT;
    }

}
