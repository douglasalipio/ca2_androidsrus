/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Comparator;

/**
 *
 * @author hal-9000
 */
public class IComponent implements Comparator<Component> {

    @Override
    public int compare(Component o1, Component o2) {
        if (o1.getType() == o2.getType()) {
            return 0;
        } else {
            return -1;
        }
    }
}
