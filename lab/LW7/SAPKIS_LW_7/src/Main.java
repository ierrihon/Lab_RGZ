import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num;
        do {
            try {
                System.out.print("Введите натуральное число(1<=k<=99): ");
                num = Integer.parseInt(reader.readLine());
                if(num > 0 && num < 1000) break;
            } catch (NumberFormatException e) {
                System.out.println("Число задано не правильно");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while (true);

        int oldNum = num;
        do{
            char[] charArray = String.valueOf(num).toCharArray();
            num += oldNum;

            int temp = 0;
            for (int i = 0; i < charArray.length-1; i++){
                if(charArray[i] == charArray[i+1]){
                    temp++;
                }
            }
            if(temp != 0 && temp == charArray.length - 1){
                System.out.println("Число с одинаковыми символами: " + String.valueOf(charArray));
                break;
            }
            if(charArray.length == 9){
                System.out.println("Число с тремя одинаковыми символами не найдено");
                break;
            }
            System.out.println("num = " + num);
        }while (true);
    }
}
