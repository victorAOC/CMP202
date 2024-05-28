public class myArray {

    public static void main(String[] args) {

        int[] numbersArray = new int[10];
        numbersArray[0] = 25;
        numbersArray[1] = 32;
        numbersArray[2] = 45;
        numbersArray[3] = 56;
        numbersArray[4] = 67;
        numbersArray[5] = 78;
        numbersArray[6] = 89;
        numbersArray[7] = 90;
        numbersArray[8] = 12;
        numbersArray[9] = 23;

        for (int i = numbersArray.length - 1; i >= 0; i--) {
            System.out.println(numbersArray[i]);
        }

    }

}
