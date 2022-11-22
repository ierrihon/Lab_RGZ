import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean bool = false;
        do {
            System.out.print("Рядок 1: ");
            String line1 = scanner.nextLine();
            System.out.print("Рядок 2: ");
            String line2 = scanner.nextLine();

            if (Arrays.equals(workWithStr(line1), workWithStr(line2))) {
                System.out.println("Рядки є анаграмою");
            } else System.out.println("Рядки не є анаграмою");


            System.out.println("Бажаете повторити операцію? (y/n)");
            String ans = scanner.nextLine();
            if(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("н")) bool = true;
            System.out.println();
        }while (bool);
    }
    public static char[] workWithStr(String myStr){
        StringBuilder stringBuilder = new StringBuilder();
        String string = myStr.toLowerCase();
        for(char ch : string.toCharArray()){
            if(Character.toString(ch).matches("^[a-zA-ZА-Яа-я]*$")){
                stringBuilder.append(ch);
            }
        }
        char[] sortArr = stringBuilder.toString().toCharArray();
        Arrays.sort(sortArr);
        return sortArr;
    }
}
