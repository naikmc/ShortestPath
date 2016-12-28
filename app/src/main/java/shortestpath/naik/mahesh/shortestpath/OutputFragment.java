package shortestpath.naik.mahesh.shortestpath;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;


public class OutputFragment extends Fragment implements  OutputContract{


    private LowestPathUtil lowestPathUtil;
    String pathpossible;
    String pathsum;
    String pathlements;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lowestPathUtil = new LowestPathUtil();
        lowestPathUtil.initiate();
        if(lowestPathUtil.isPathpossible()) {
            pathpossible= "Yes";
        }else{
            pathpossible = "No";
        }
        pathsum = lowestPathUtil.getpathSum()+"";
        pathlements = Arrays.toString(lowestPathUtil.pathElements())+"";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         TextView pathpossible;
         TextView pathsum;
         TextView pathlements;
        View root = inflater.inflate(R.layout.output_layout, container, false);
        pathpossible = (TextView) root.findViewById(R.id.pathpossible);
        pathsum = (TextView) root.findViewById(R.id.pathsum);
        pathlements = (TextView) root.findViewById(R.id.pathlements);
        showPathpossible(pathpossible);
        showPathSum(pathsum);
        showPathElements(pathlements);
        return root;

    }

    @Override
    public void showPathpossible(TextView pathpossible) {
        pathpossible.setText(this.pathpossible);
    }

    @Override
    public void showPathSum(TextView pathsum) {
        pathsum.setText(this.pathsum);
    }

    @Override
    public void showPathElements(TextView pathlements) {
        pathlements.setText(this.pathlements);
    }
}
