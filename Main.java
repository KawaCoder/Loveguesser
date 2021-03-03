import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void progressPercentage(int remain, int total) {
        if (remain > total) {
            throw new IllegalArgumentException();
        }
        int maxBareSize = 10; // 10unit for 100%
        int remainProcent = ((100 * remain) / total) / maxBareSize;
        char defaultChar = '-';
        String icon = "*";
        String bare = new String(new char[maxBareSize]).replace('\0', defaultChar) + "]";
        StringBuilder bareDone = new StringBuilder();
        bareDone.append("[");
        for (int i = 0; i < remainProcent; i++) {
            bareDone.append(icon);
        }
        String bareRemain = bare.substring(remainProcent, bare.length());
        System.out.print("\r" + bareDone + bareRemain + " Computing compatibility...: " + remainProcent * 10 + "%");
        if (remain == total) {
            System.out.print("\n");
        }
    }

    public static void main(String args[]) {
        Random rand = new Random();
        int randlow = 50;
        int randhigh = 200;
        int randomNumber = rand.nextInt(200);
        int age1;
        int age2;
        int calcul = 0;
        String prenom1;
        String prenom2;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n\n\nEnter your name:");
            prenom1 = scan.nextLine();
            System.out.println("Enter his/her name:");
            prenom2 = scan.nextLine();
            System.out.println("Enter your age:");
            age1 = scan.nextInt();
            System.out.println("Enter his/her age:");
            age2 = scan.nextInt();


            ArrayList<Character> liste1 = new ArrayList<Character>();
            ArrayList<Integer> liste11 = new ArrayList<Integer>();
            ArrayList<Character> liste2 = new ArrayList<Character>();
            ArrayList<Integer> liste22 = new ArrayList<Integer>();
            for (int z = 0; z < prenom1.length(); z++) {
                liste1.add(prenom1.charAt(z));
                liste11.add((int) liste1.get(z));

            }
            for (int z = 0; z < prenom2.length(); z++) {
                liste2.add(prenom2.charAt(z));
                liste22.add((int) liste2.get(z));
            }

            for (int z = 0; z < liste11.size(); z++) {
                liste11.set(z, liste11.get(z) + age2);
            }

            for (int z = 0; z < liste22.size(); z++) {
                liste22.set(z, liste22.get(z) + age1);
            }

            for (int z = 0; z < liste11.size(); z++) {
                calcul = calcul + liste11.get(z);
            }

            for (int z = 0; z < liste22.size(); z++) {
                calcul = calcul + liste22.get(z);
            }


            calcul = (calcul / (age1 / 5)) / 10;

            for (int z = 0; z <= 200; z = z + 20) {
                randomNumber = rand.nextInt(randhigh - randlow) + randlow;

                progressPercentage(z, 200);
                try {
                    Thread.sleep(randomNumber);
                } catch (Exception e) {
                }
            }

            System.out.println("Compatibility: " + calcul + "/100");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
