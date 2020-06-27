package com.zszdevelop.planman.view_holder;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.zszdevelop.planman.R;


public class MeterialHeaderViewHolder extends RecyclerView.ViewHolder {

    public ImageView iv_meterial;

    public MeterialHeaderViewHolder(View itemView) {
        super(itemView);
        iv_meterial = (ImageView) itemView.findViewById(R.id.iv_meterial);
    }
}
