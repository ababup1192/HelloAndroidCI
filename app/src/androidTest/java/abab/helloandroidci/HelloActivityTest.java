package abab.helloandroidci;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import static android.test.ViewAsserts.assertOnScreen;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class HelloActivityTest extends ActivityInstrumentationTestCase2<HelloActivity> {
    private HelloActivity helloActivity;
    private TextView textCalcResult;

    @SuppressWarnings("deprecation")
    public HelloActivityTest() {
        super("abab.helloandroidci", HelloActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();

        helloActivity = getActivity();
        textCalcResult = (TextView) helloActivity.findViewById(R.id.text_calc_result);
    }

    public void testTextView() {
        assertOnScreen(helloActivity.getWindow().getDecorView(), textCalcResult);
    }

    public void testLabel() {
        onView(withId(R.id.text_calc_result)).check(matches(withText("2 x 3 = 6")));
    }

}

