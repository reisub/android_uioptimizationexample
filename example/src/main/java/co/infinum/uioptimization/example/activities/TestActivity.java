package co.infinum.uioptimization.example.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.infinum.uioptimization.example.R;
import co.infinum.uioptimization.example.adapters.LeftListAdapter;
import co.infinum.uioptimization.example.adapters.RightListAdapter;

/**
 * Created by dino on 27/05/14.
 */
public class TestActivity extends Activity {

    private long mStartTimeMillis;

    private boolean mOptimized;

    @InjectView(R.id.text_time)
    protected TextView mTimeText;

    @InjectView(R.id.list_left)
    protected ListView mLeftList;

    @InjectView(R.id.list_right)
    protected ListView mRightList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mOptimized = getIntent().getBooleanExtra(MainActivity.KEY_VARIANT, false);

        if (mOptimized) {
            setContentView(R.layout.activity_test_optimized);
        } else {
            setContentView(R.layout.activity_test);
        }

        ButterKnife.inject(this);

        List<String> leftItems = new ArrayList<>();
        leftItems.add("A");
        leftItems.add("long");
        leftItems.add("time");
        leftItems.add("ago");
        leftItems.add("in");
        leftItems.add("a");
        leftItems.add("galaxy");
        leftItems.add("far");
        leftItems.add("far");
        leftItems.add("away");
        leftItems.add("...");

        int[] rightValues = {90, 10, 80, 20, 70, 30, 60, 40, 50};

        ListAdapter leftAdapter;

        if (mOptimized) {
            leftAdapter = new LeftListAdapter(this, leftItems, R.layout.list_item_left_optimized);
        } else {
            leftAdapter = new LeftListAdapter(this, leftItems, R.layout.list_item_left);
        }

        mLeftList.setAdapter(leftAdapter);

        mRightList.setAdapter(new RightListAdapter(this, rightValues, mOptimized));
    }
}
