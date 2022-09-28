package com.es.server;

import javafx.scene.shape.Box;
import org.omg.CORBA.ORB;
import parall.ParallMoverPOA;

public class ParallMoverServant extends ParallMoverPOA {

    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }

    @Override
    public void moveParall(double x, double y, double z) {
        final Box box = App.box;

        box.setTranslateX(box.getTranslateX() + x);
        box.setTranslateY(box.getTranslateY() + y);
        box.setTranslateZ(box.getTranslateZ() + z);
    }
}
