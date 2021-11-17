package com.zzangnet.IvrTest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HistoryRowAdapter extends ArrayAdapter<HistoryItem> {
    private History history;

    public HistoryRowAdapter(@NonNull Context context, int textViewResourceId) {
        super(context, textViewResourceId);

        this.history = new History(context);
        this.history.load();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.history_row, null);
        }

        HistoryItem h = history.get(position);
        if (h != null) {
            TextView tt = (TextView) v.findViewById(R.id.text);
            TextView bt = (TextView) v.findViewById(R.id.timestamp);
            if (tt != null)
            {
                tt.setText(h.getText());
            }
            if(bt != null)
            {
                bt.setText(h.getFormatedTimestamp());
            }
        }
        return v;
    }

    @Override
    public int getCount() {
        return this.history.getCount();
    }
}
