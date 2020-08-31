package com.example.covid2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class DonorAdapter extends ArrayAdapter<DonorInfo> {
    private static class ViewHolder {
        TextView name;
        TextView phoneNo;
    }

    public DonorAdapter(Context context, ArrayList<DonorInfo> users) {
        super(context, R.layout.donor_info, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DonorInfo user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.donor_info, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.DONOR_NAME);
            viewHolder.phoneNo = (TextView) convertView.findViewById(R.id.DONOR_PHONE_NO);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.name.setText(user.name);
        viewHolder.phoneNo.setText(user.phoneNo);
        // Return the completed view to render on screen
        return convertView;
    }
}
