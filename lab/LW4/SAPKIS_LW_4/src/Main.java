import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.SimpleTimeZone;

import static java.lang.Math.random;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        game(rand());

    }

    public static void game(String rand){
        String[] tempRand = rand.split("");
        System.out.println(Arrays.toString(tempRand));
        int kol=0;
        String[] myNum;
       try {
        while (kol <= 7) {
            int bull = 0;
            int cow = 0;
            System.out.print("\nВаше припущення: ");
            myNum = scanner.nextLine().split("");
            if(Arrays.equals(tempRand, myNum)){
                kol++;
                System.out.println("\nГра пройдена\nВи витаратили "+kol+" спроб(-и)!"+"\n");
                return;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (tempRand[i].equals(myNum[j])) {
                        if (i == j) {
                            bull++;
                        } else {
                            cow++;
                        }
                    }
                }
            }
            if (bull > 0) {
                System.out.println("Биків - " + bull);
            }
            if(cow>0){
                System.out.println("Корів - " + cow);
            }
            kol++;
        }
        System.out.println("\n\nВи програли");
        }catch (Exception e){
            System.out.println("\nВиникла помилка\n");
        }
    }

    public static String rand(){
        StringBuilder rand = new StringBuilder(Integer.toString((int) (random() * 9)));
        for(int i = 0; i < 3; ) {
            boolean check = false;
            String temp = Integer.toString((int)(random()*9));
            for(int j = 0; j < rand.toString().split("").length; j++){
                if(Objects.equals(rand.toString().split("")[j], temp)){
                    check = true;
                    break;
                }
            }
            if(!check){
                rand.append(temp);
                i++;
            }
        }
        return rand.toString();
    }

}