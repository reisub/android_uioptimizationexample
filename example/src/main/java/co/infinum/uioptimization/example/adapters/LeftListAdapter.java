package co.infinum.uioptimization.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import co.infinum.uioptimization.example.R;

/**
 * Created by dino on 27/05/14.
 */
public class LeftListAdapter extends BaseAdapter {

    private final Context mContext;

    private final List<String> mItems;

    private final int mLayoutResId;

    public LeftListAdapter(Context context, List<String> items, int layoutResId) {

        mContext = context;
        mItems = items;
        mLayoutResId = layoutResId;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public String getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mLayoutResId, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.text_description);
        textView.setText(getItem(position));

        return convertView;
    }
}
