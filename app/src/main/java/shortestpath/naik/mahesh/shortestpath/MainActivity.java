package shortestpath.naik.mahesh.shortestpath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // input Array hardcoded
    int [][] myArray = {  {3, 81, 6, 60},
                         {37, 81, 96, 10},
                          {38, 81, 6, 100},
                          {91, 8, 83, 400}  };
    int arrayHeight =myArray.length;
    int lengthOfpath =myArray[0].length;
    int [] sumArray = new int[arrayHeight];
    int [] shortPath = new int[lengthOfpath];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayInputAryay();

        for (int i=0 ;i< arrayHeight;i++){
            sumArray[i]= myArray[i][lengthOfpath-1];
        }

        //adding the first element.
         shortPath[lengthOfpath-1] = findMininArray(sumArray);

        findLowestsumandUpdate(lengthOfpath-2 , sumArray);
       // System.out.println("######"+Arrays.toString(sumArray));
       // System.out.println("######kk"+Arrays.toString(shortPath));

        int total =0;
        for (int i = 0; i<  shortPath.length; i++){
            total =total+ myArray[ shortPath[i]][i];
        }

        TextView pathpossible = (TextView) findViewById(R.id.pathpossible);
        TextView pathsum = (TextView) findViewById(R.id.pathsum);
        TextView pathlements = (TextView) findViewById(R.id.pathlements);

        if(total>50){
            pathpossible.setText("No");
        }else{
            pathpossible.setText("Yes");

        }
        pathsum.setText(""+total);

        pathlements.setText(Arrays.toString(shortPath));
       // System.out.println("######total="+total);
    }


    /**
     * Only for Display Array
     */
    private void displayInputAryay() {
        TextView iArray = (TextView) findViewById(R.id.inputarray);
        for (int i=0 ;i< myArray.length;i++){
            iArray.append(Arrays.toString(myArray[i]));
            iArray.append("\n");
        }


    }

    /** Recursive function to find low cost path
     * @param k
     * @param sumArray
     */
    void findLowestsumandUpdate(int k , int[] sumArray){

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
    private int  findMininArray(int arr[]){

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
