public class Main {
    public static void main(String[] args) {
        posledovatelnost(5);
        posledovatelnost(7);
        posledovatelnost(9);
        posledovatelnost(18);
        posledovatelnost(23);
    }
    public static void posledovatelnost(int num){
        System.out.println("\nДано '" + num + "' \nРезультат:");
        int i = 0;
        while (i<20/*num > 1*/) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = 3 * num + 1;
            }
            System.out.print("'"+num+"' ");
            i++;
        }
        System.out.println();
    }
}