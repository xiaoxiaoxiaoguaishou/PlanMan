package com.zszdevelop.planman.view_holder;


import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zszdevelop.planman.R;



public class ShowTypeViewHolder extends RecyclerView.ViewHolder{

	public TextView btn_select_type;

	
	public ShowTypeViewHolder(View itemView) {
		super(itemView);
		btn_select_type = (TextView) itemView.findViewById(R.id.btn_select_type);

	}


		
		
	
}
