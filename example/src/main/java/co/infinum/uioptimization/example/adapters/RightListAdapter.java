package co.infinum.uioptimization.example.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import co.infinum.uioptimization.example.CompoundProgressView;

/**
 * Created by dino on 27/05/14.
 */
public class RightListAdapter extends BaseAdapter {

    private final Context mContext;

    private final int[] mItems;

    private boolean mOptimized;

    public RightListAdapter(Context context, int[] items, boolean optimized) {

        mContext = context;
        mItems = items;
        mOptimized = optimized;
    }

    @Override
    public int getCount() {
        return mItems.length;
    }

    @Override
    public Integer getItem(int position) {
        return mItems[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = new CompoundProgressView(mContext, "Item " + position, getItem(position),
                    mOptimized);
        }

        return convertView;
    }
}
