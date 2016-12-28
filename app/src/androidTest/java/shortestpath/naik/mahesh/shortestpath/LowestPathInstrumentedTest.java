package shortestpath.naik.mahesh.shortestpath;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LowestPathInstrumentedTest {

    int [] pathlements ={0,3,0,1};
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
    }
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("shortestpath.naik.mahesh.shortestpath", appContext.getPackageName());
    }

    @Test
    public void checkPathpossible() {
        onView(withId(R.id.pathpossible))
                .check(matches(withText("Yes")));
    }


    @Test
    public void checkTotalcost() {
        onView(withId(R.id.pathsum))
                .check(matches(withText("27")));
    }

    @Test
    public void checkPathElements() {
        onView(withId(R.id.pathlements))
                .check(matches(withText(Arrays.toString(pathlements))));
    }
}
