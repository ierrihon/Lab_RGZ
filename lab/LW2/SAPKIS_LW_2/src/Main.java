import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        getKolFill(new int[] {4, 1, 3});
        getKolFill(new int[] {4, 0, 1, 3});
        getKolFill(new int[] {2, 1, 5, 2, 7, 4, 10});
        getKolFill(new int[] {2, 0, 1, 5, 2, 7});
        getKolFill(new int[] {2, 4, 2});
        getKolFill(new int[] {7, 4});
        getKolFill(new int[] {36, 48, 13, 3, 15, 24, 12, 7, 12, 18, 45, 48, 1, 2, 24, 15, 28, 7, 12, 44, 4, 44, 27, 4});

    }
    public static int[] arrayReverse(int[] arr){
        int j = 0;
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--, j++) {
            res[j] = arr[i];
        }
        return res;
    }
    public static void getKolFill(int[] arr){
        int[] currentArr = arr;
        int length = currentArr.length-1,
                i = 0,
                idMax = 0,
                temp = 0;
        do {
            if(currentArr[currentArr.length-1]==0) length--;
            if (currentArr[0]==0) {
                i++; idMax++;
            }
            if(currentArr[idMax] <= currentArr[length]){
                for(; i < length; i++){
                    if(currentArr[idMax] > currentArr[i+1]) {
                        temp += currentArr[idMax] - currentArr[i + 1];
                    }else{
                        idMax = i+1;
                    }
                    if(idMax == length || idMax+1==length){
                        System.out.println("\nУ массиві: " + Arrays.toString(arr)+"\nкількість заповнених комірок становить: " + temp);return;
                    }
                }
            }else{
                currentArr = arrayReverse(arr);
                length = currentArr.length - idMax-1;
                idMax = 0;
            }
        }while (true);
    }
}