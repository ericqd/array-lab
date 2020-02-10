import java.util.Arrays;
import java.util.Scanner;
public class ArrayLab{
    public static void main(String [] args){
        final int size = 10;
        int[] newArray = new int[size];
        populateArray(newArray);
        int selection;
        int valueInput;
        int locationInput;
        Scanner input = new Scanner(System.in);

        //while loop with switch case to display menu
        boolean isTrue = false;
        while(isTrue == false){
            System.out.println("1.Display Values" + "\n2.Display Reversed" + "\n3.Display Sum" + "\n4.Display Maximum" + "\n5.Search for a Value" + "\n6.Insert new Value" + "\n7.Reset Values" + "\n8.Quit");
            selection = CheckInput.getIntRange(1,8);
        switch (selection){

        case 1:
            displayValues(newArray);
            break;
        case 2:
            displayReverse(newArray);
            break;
        case 3:
            int sum = completeSum(newArray);
            System.out.println("Sum: " + sum);
            break;
        case 4:
            int max = maxValue(newArray);
            System.out.println("Max value: " + max);
            break;
        case 5:
            System.out.println("Enter value you would like to find: ");
            valueInput = CheckInput.getInt();
            int location = findValue(newArray, valueInput);
            if(location != -1){
                System.out.println("Location found at:" + location);
            }
            else{
                System.out.println("Not found");
            }
            break;
        case 6:
            System.out.println("Enter index location: ");
            locationInput = CheckInput.getIntRange(1,10);
            System.out.println("Enter value you would like to insert");
            valueInput = CheckInput.getInt();
            insertValue(newArray,locationInput,valueInput);
            break;
        case 7:
            populateArray(newArray);
            break;
        case 8:
            isTrue = true;
            System.out.println("Goodbye");
            break;
        }   
    } 
        }
/**
 * Populates the contents of an array with user input values
 * @param array
 * @return array with 10 integers
 */
    public static int[] populateArray(int [] array) {
        int userInput;
        System.out.println("Enter 10 integers: ");
        for(int i = 0; i < array.length; i++){
            Scanner input = new Scanner(System.in);
            userInput = CheckInput.getInt();
            array[i] = userInput;
        }
        return array;
    }
    /**
     * Displays the contents of the array
     * @param array
     */
    public static void displayValues(int [] array){
            System.out.println(Arrays.toString(array));
    }
    /**
     * Reverses the elements in an array and displays the reversed array
     * @param array
     */
    public static void displayReverse(int [] array){
        int reverse;
        int[] reversedArray = new int[array.length];
        for(int i =0; i < array.length; i++){
            reversedArray[i] = array[i];
        }
        for(int i = 0; i < reversedArray.length/2; i++){
            reverse = reversedArray[i];
            reversedArray[i] = reversedArray[reversedArray.length-1-i];
            reversedArray[reversedArray.length-1-i] = reverse;
        }
        System.out.println("Reversed array: " + Arrays.toString(reversedArray));
    }
    /**
     * Finds the index of a value given by the user in an array
     * @param array
     * @param value
     */
    public static int findValue(int [] array, int value){
        int index = -1;
        for(int i = 0; i < array.length; i++){
            if(value == array[i]){
                index = i + 1;
                System.out.println(Arrays.toString(array));
            }
        }
        return index;
        }
    /**
     * Inserts a value given by the user and prints the array with the new value
     * @param array
     * @param location
     * @param value
     */      
    public static void insertValue(int [] array, int location, int value){
        array[location -1] = value;
        System.out.println(Arrays.toString(array));
    }
    /**
     * Goes through an array and finds the highest integer value and prints it
     * @param array
     */
    public static int maxValue(int [] array){
        int hold = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > hold){
                hold = array[i];
            }
        }
        return hold;
    }
    /**
     * Goes through an array and adds up all the elements
     * @param array
     */
    public static int completeSum(int [] array){
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum+= array[i];
        }
        return sum;
    }
}