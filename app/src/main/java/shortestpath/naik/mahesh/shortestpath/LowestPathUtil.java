package shortestpath.naik.mahesh.shortestpath;

/**
 * Created by Mahesh on 12/28/2016.
 */

public class LowestPathUtil {

    // input Array hardcoded
    public static int [][] myArray = {  {3, 81, 6, 60},
                          {37, 81, 96, 10},
                          {38, 81, 6, 100},
                         {91, 8, 83, 400}  };
    public static int arrayHeight =myArray.length;
    public static int lengthOfpath =myArray[0].length;
    int [] sumArray = new int[arrayHeight];
    int [] shortPath = new int[lengthOfpath];
    private boolean isPathpossible ;
    private  int total =0;


    public void initiate(){
        for (int i=0 ;i< arrayHeight;i++){
            sumArray[i]= myArray[i][lengthOfpath-1];
        }

        //adding the first element.
        shortPath[lengthOfpath-1] = findMininArray(sumArray);

        findLowestsumandUpdate(lengthOfpath-2 , sumArray);

        for (int i = 0; i<  shortPath.length; i++){
            total =total+ myArray[ shortPath[i]][i];
        }

        if(total>50){
            isPathpossible = false;
        }else{
            isPathpossible = true;

        }

    }

    public boolean isPathpossible(){
        return isPathpossible;

    }

    public int getpathSum(){
        return total;
    }

    public int[] pathElements(){
        return shortPath;
    }




    /** Recursive function to find low cost path
     * @param k
     * @param sumArray
     */
    public  void findLowestsumandUpdate(int k , int[] sumArray){

        if(k<0){
            return ;
        }
        int temp[] = new int [arrayHeight];
        for (int i=0 ;i< arrayHeight;i++){
            int r =  arrayHeight;
            int a = myArray[i][k]+sumArray[i];
            int b;
            int c;
            if(i-1 <0){
                b= myArray[i][k]+sumArray[r-1];
            }else{
                b= myArray[i][k]+sumArray[i-1];

            }
            if(i+1>=r){
                c= myArray[i][k]+sumArray[0];

            }else{
                c= myArray[i][k]+sumArray[i+1];
            }

            int  smallest=(a<b)?((a<c)?a:c):((b<c)?b:c);
            temp[i]= smallest;
        }

        shortPath[k] = findMininArray(temp);
        sumArray= temp;
        // System.out.println("@@@"+Arrays.toString(sumArray));
        findLowestsumandUpdate(k-1 , sumArray);
    }

    /** Get the lowest value index
     * @param arr
     * @return
     */
    public  int  findMininArray(int arr[]){

        if (arr.length == 0)
            return -1;
        int small = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < small) {
                small = arr[i];
                index = i;
            }
        }
        return  index;
    }
}
