package co.infinum.uioptimization.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dino on 16/05/14.
 */
public class CompoundProgressView extends RelativeLayout {

    @InjectView(R.id.text_label)
    protected TextView mLabelText;

    @InjectView(R.id.progress_compound)
    protected ProgressBar mProgressBar;

    public CompoundProgressView(Context context, String label, int value, boolean optimized) {
        super(context);

        View view;

        if (optimized) {
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.view_compound_progress_optimized, this, true);
        } else {
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.view_compound_progress, this, true);
        }
        ButterKnife.inject(this, view);

        mLabelText.setText(label);
        mProgressBar.setProgress(value);
    }

}
