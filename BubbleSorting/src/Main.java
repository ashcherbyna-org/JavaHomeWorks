import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static int minValue = 0;
    static int maxValue = 50;
    static Random random = new Random();

    public static void main(String[] args) {
        int[] array = createArray(50);
        printArray(array);
        System.out.println("After sorting");
        sortArray(array);
        printArray(array);
    }
    static int[] createArray(int count){
        int[] array = new int[count];
        for (int b = 0; b < count; b++){
            array[b] = getRandomValue();
        }
        return array;
    }
    static int getRandomValue() {
        int value = minValue + random.nextInt(maxValue - minValue);
        return value;
    }
    static void printArray(int[] array){
        int a = 0;
        for (int item: array){
            System.out.println(a + " :: " + item);
            a++;//a=a+1

        }
    }
    static void sortArray(int[] array){
        for (int a = 1; a < array.length; a++){
            for (int b = 0; b < a; b++){
                if (array[a] < array[b]){
                    int temp = array[a];
                    array[a] = array[b];
                    array[b] = temp;
                }
            }
        }
    }
}
