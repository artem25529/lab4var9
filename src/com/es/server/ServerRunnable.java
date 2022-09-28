package com.es.server;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import parall.ParallMover;
import parall.ParallMoverHelper;

public class ServerRunnable implements Runnable {
    @Override
    public void run() {
        try {
            ORB orb = ORB.init(new String[]{}, null);
            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();

            ParallMoverServant servant = new ParallMoverServant();
            servant.setOrb(orb);

            org.omg.CORBA.Object ref = rootPoa.servant_to_reference(servant);
            ParallMover href = ParallMoverHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent[] path = ncRef.to_name("ABC");
            ncRef.rebind(path, href);

            while (true) {
                orb.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
