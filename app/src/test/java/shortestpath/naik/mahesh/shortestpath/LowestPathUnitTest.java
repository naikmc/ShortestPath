package shortestpath.naik.mahesh.shortestpath;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class LowestPathUnitTest {

    @Mock
    private InputContract inputContract;

    @Mock
    private InputFragment inputFragment;

    @Mock
    private OutputContract outputContract;

    @Mock
    private OutputFragment outputFragment;

    @Mock
    private TextView arrayHeight;

    @Mock
    private TextView arrayWidth;

    @Mock
    private TextView inputArray;

    @Mock
    private TextView pathpossible;

    @Mock
    private TextView pathsum;

    @Mock
    private TextView pathlements;

    @Before
    public void setupNotesPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        inputFragment = new InputFragment();
        outputFragment = new OutputFragment();
    }



    @Test
    public void test_showArrayHeight() {

      //  inputFragment.showArrayHeight();
        inputFragment.showArrayHeight(arrayHeight);
        // Then an empty not error is shown in the UI
        verify(arrayHeight).setText(any(String.class));
    }

    @Test
    public void test_showArrayWidth() {

        //  inputFragment.showArrayHeight();
        inputFragment.showArrayHeight(arrayWidth);
        // Then an empty not error is shown in the UI
        verify(arrayWidth).setText(any(String.class));
    }

    @Test
    public void test_showInputArray() {

        //  inputFragment.showArrayHeight();
        inputFragment.showInputAray(inputArray);
        // Then an empty not error is shown in the UI
        verify(inputArray,times(8)).append(any(String.class));
    }

    @Test
    public void test_showPathPossible() {

        //  inputFragment.showArrayHeight();
        outputFragment.showPathpossible(pathpossible);
        // Then an empty not error is shown in the UI
        verify(pathpossible).setText(any(String.class));
    }

    @Test
    public void test_showPathSum() {

        //  inputFragment.showArrayHeight();
        outputFragment.showPathSum(pathsum);
        // Then an empty not error is shown in the UI
        verify(pathsum).setText(any(String.class));
    }

    @Test
    public void test_showPathElements() {

        //  inputFragment.showArrayHeight();
        outputFragment.showPathElements(pathlements);
        // Then an empty not error is shown in the UI
        verify(pathlements).setText(any(String.class));
    }
}