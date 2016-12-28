package shortestpath.naik.mahesh.shortestpath;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;


public class InputFragment extends Fragment implements InputContract
{
    TextView iArray;
    EditText arrayWidth;
    EditText arrayHeight;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =inflater.inflate(R.layout.input_layout, container, false);
         iArray = (TextView) root.findViewById(R.id.inputarray);
        arrayWidth = (EditText)root.findViewById(R.id.array_width);
        arrayHeight = (EditText)root.findViewById(R.id.array_height);
        showInputAray(iArray);
        showArrayWidth(arrayWidth);
        showArrayHeight(arrayHeight);

        return root;

    }

    @Override
    public void showArrayWidth(TextView arrayWidth) {
        arrayWidth.setText(""+LowestPathUtil.lengthOfpath);
    }

    @Override
    public void showArrayHeight(TextView arrayHeight) {
        arrayHeight.setText(""+LowestPathUtil.lengthOfpath);
    }

    @Override
    public void showInputAray(TextView inputArray) {
        for (int i=0 ;i< LowestPathUtil.myArray.length;i++){
            inputArray.append(Arrays.toString(LowestPathUtil.myArray[i]));
            inputArray.append("\n");
        }
    }
}
