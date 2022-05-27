package com.example.countrycode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class BottomSheetDataAdapter extends RecyclerView.Adapter<BottomSheetDataAdapter.VersionViewHolder> {

    Context mContext;
    ArrayList<String> arrayList;
    String selectedCountryName;

    public BottomSheetDataAdapter(Context context, ArrayList<String> data) {
        this.mContext = context;
        this.arrayList = data;
    }

    @Override
    public BottomSheetDataAdapter.VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_items, viewGroup, false);
        BottomSheetDataAdapter.VersionViewHolder viewHolder = new BottomSheetDataAdapter.VersionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BottomSheetDataAdapter.VersionViewHolder versionViewHolder, @SuppressLint("RecyclerView") final int position) {
        try {
            if (arrayList != null && arrayList.size() > 0) {
//                final FilterModel model  = arrayList.get(position);
                final String countryName = arrayList.get(position);
                if (countryName != null) {

//                    if (model.filter_name != null && model.filter_name.length() > 0) {
//                        versionViewHolder.tvFilterName.setText(model.filter_name);
//                    }

                    versionViewHolder.txtCountryName.setText(countryName);

                    versionViewHolder.txtCountryName.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try {
                                String selectedCountry = arrayList.get(position);
                                setSelectedData(selectedCountry);
//                                BottomSheetListFilter.super.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                                setSelectedData(null);
//                                BottomSheetListFilter.super.dismiss();
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class VersionViewHolder extends RecyclerView.ViewHolder {

        TextView txtCountryName;

        public VersionViewHolder(View itemView) {
            super(itemView);
            txtCountryName = itemView.findViewById(R.id.txt_country_name);

        }
    }


    public void setSelectedData(String countryName) {
        this.selectedCountryName = countryName;
    }

    public String getSelectedData() {
        return selectedCountryName;
    }
}