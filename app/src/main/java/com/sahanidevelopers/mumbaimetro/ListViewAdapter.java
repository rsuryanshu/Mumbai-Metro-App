package com.sahanidevelopers.mumbaimetro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListViewAdapter extends ArrayAdapter {

    String[] timingArray;


    public ListViewAdapter(@NonNull Context context, String[] timingArrays) {
        super(context,R.layout.train_schedule_list,timingArrays);
        this.timingArray = timingArrays;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.train_schedule_list, parent, false);
        TextView mTextView = row.findViewById(R.id.TextViewTiming);
        mTextView.setText(timingArray[position]);
        return row;
    }
}
