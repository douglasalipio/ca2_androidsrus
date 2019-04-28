/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hal-9000
 */
public class Component {

    private String label;
    private String value;
    private long serialNumber;
    private Type type;
    private boolean available = true;

    public Component(String value, Type type) {
        this.label = type.name();
        this.value = value;
        this.type = type;
        this.serialNumber = System.nanoTime();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
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

    public static List<Type> list() {
        var typeList = new ArrayList();
        typeList.add(Type.BRAIN);
        typeList.add(Type.MOBILITY);
        typeList.add(Type.VISION);
        typeList.add(Type.ARMS);
        typeList.add(Type.MEDIA_CENTER);
        typeList.add(Type.POWER_PLANT);
        return typeList;
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
