package com.es.client;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import parall.ParallMover;
import parall.ParallMoverHelper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            ParallMover parallMover = ParallMoverHelper.narrow(ncRef.resolve_str("ABC"));

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Enter x translation");
                double x = scanner.nextDouble();

                System.out.println("Enter Y translation");
                double y = scanner.nextDouble();

                System.out.println("Enter z translation");
                double z = scanner.nextDouble();

                parallMover.moveParall(x, y, z);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
