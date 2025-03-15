package tpo;

import tpo.task3.objects.Committee;
import tpo.task3.objects.Suit.LabCoat;
import tpo.task3.objects.Suit.Prism;
import tpo.task3.objects.participants.*;
import tpo.task3.objects.profession.Engineer;
import tpo.task3.objects.profession.Scientist;

public class SinPowerSeries {
    public static void main(String[] args) {

        Committee committee = new Committee();
        System.out.println(committee.describe());

        committee.addNewCreature(new Huluwu());
        committee.addNewCreature(new Huluwu());
        committee.addNewCreature(new Humanoid());
        committee.addNewCreature(new Maximegalactic());
        committee.addNewCreature(new Reptiloid());
        Huluwu huluwu = new Huluwu();
        System.out.println(huluwu.addClothes(new LabCoat()));
        System.out.println(huluwu.addClothes(new Prism()));
        System.out.println(huluwu.addProfession(new Engineer()));
        System.out.println(huluwu.addProfession(new Engineer()));
        System.out.println(huluwu.addProfession(new Scientist()));
        committee.addNewCreature(huluwu);
        committee.addNewCreature(new Octopoid());

        System.out.println(committee.describe());

//        MyHashTable table = new MyHashTable();
//        table.addElem(1);
//        table.addElem(2);
//        table.addElem(3);
//        table.addElem(4);
//        table.addElem(14);
//        table.addElem(53);
//        table.addElem(14);
//        table.addElem(14);
//        table.addElem(27);
//        table.addElem(40);
//        table.addElem(16);
//        System.out.println(table.getCountOfElems());
//        table.printStruct();

//        for (int i = 0; i < 60; i++) {
//            double zn = Math.PI * (i - 30) / 20;
//            System.out.printf("%.20f%n", Math.abs(calcWithPowerSeries(zn) - Math.sin(zn)));
////            System.out.printf("%.20f%n", Math.sin(zn));
//        }
    }

    public static int factorial(int x) {
        if (x < 2) {
            return 1;
        }
        return factorial(x-1) * x;
    }

    public static double calcWithPowerSeries(double x) {
        double result = 0;
        for (int n = 0; n < 6; ++n) {
            result += Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
        }
        return result;
    }
}