package co.infinum.uioptimization.example.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import co.infinum.uioptimization.example.R;

public class MainActivity extends Activity {

    public static final String KEY_VARIANT = "variant";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
    }

    @OnClick(R.id.button_slower_activity)
    protected void launchSlowerActivity() {
        launchTestActivity(false);
    }

    @OnClick(R.id.button_faster_activity)
    protected void launchFasterActivity() {
        launchTestActivity(true);
    }

    private void launchTestActivity(boolean optimized) {
        Intent intent = new Intent(this, TestActivity.class);
        intent.putExtra(KEY_VARIANT, optimized);
        startActivity(intent);
    }

}
