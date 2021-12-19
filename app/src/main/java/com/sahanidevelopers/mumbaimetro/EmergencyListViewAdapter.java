package com.sahanidevelopers.mumbaimetro;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmergencyListViewAdapter extends BaseAdapter {
    //variables
    Context mContext;
    LayoutInflater inflater;
    List<ModelList> modellist;
    ArrayList<ModelList> arrayList;

    //constructor
    public EmergencyListViewAdapter(Context context, List<ModelList> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ModelList>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder {
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = (TextView) view.findViewById(R.id.mainTitle);
            holder.mDescTv = (TextView) view.findViewById(R.id.mainDesc);
            holder.mIconIv = (ImageView) view.findViewById(R.id.mainIcon);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (modellist.get(postition).getTitle().equals("National Emergency")) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:112"));
                    if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    mContext.startActivity(callIntent);
                }
                if (modellist.get(postition).getTitle().equals("Police")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:100"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Fire")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:101"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Ambulance")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:102"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Women Helpline")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:1091"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Air Ambulance")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:9540161344"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Anti Poison")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:1066"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Disaster Management")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:01126701728"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("EARTHQUAKE / FLOOD")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:01124363260"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Missing Child And Women")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:1094"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Railway Enquiry")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:139"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Senior Citizen Helpline")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:1091"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Medical Helpline")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:108"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Railway Accident")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:1072"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Road Accident")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:1073"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Relief Commissioner")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:1070"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Children In Difficult Situation")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:1098"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Central Vigilance Commission")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:1964"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("Tourist Helpline")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:1800111363"));
                    mContext.startActivity(callIntent);

                }
                if (modellist.get(postition).getTitle().equals("LPG Leak Helpline")){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:1906"));
                    mContext.startActivity(callIntent);

                }
            }
        });


        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (ModelList modelList : arrayList){
                if (modelList.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(modelList);
                }
            }
        }
        notifyDataSetChanged();
    }
}
