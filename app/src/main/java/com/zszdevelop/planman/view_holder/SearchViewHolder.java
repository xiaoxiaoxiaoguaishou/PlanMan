package com.zszdevelop.planman.view_holder;


import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zszdevelop.planman.R;



public class SearchViewHolder extends RecyclerView.ViewHolder{


	public TextView tv_search_title;
	public TextView tv_calory_cc;
	public ImageView iv_add_search;


	public SearchViewHolder(View itemView) {
		super(itemView);
		tv_search_title = (TextView) itemView.findViewById(R.id.tv_search_title);
		tv_calory_cc = (TextView) itemView.findViewById(R.id.tv_calory_cc);
		iv_add_search = (ImageView) itemView.findViewById(R.id.iv_add_search);

	}


		
		
	
}
