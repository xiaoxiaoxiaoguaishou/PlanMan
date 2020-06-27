package com.zszdevelop.planman.view_holder;


import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zszdevelop.planman.R;


/**
 * @version 创建时间：2015年11月23日 类说明
 */

public class ConsumeRecordViewHolder extends RecyclerView.ViewHolder{

	public TextView tv_cr_time;
	public TextView tv_consume_cc;
	public LinearLayout ll_consume_content;


	public ConsumeRecordViewHolder(View itemView) {
		super(itemView);
		tv_cr_time = (TextView) itemView.findViewById(R.id.tv_cr_time);
		tv_consume_cc = (TextView) itemView.findViewById(R.id.tv_consume_cc);
		ll_consume_content = (LinearLayout) itemView.findViewById(R.id.ll_consume_content);

	}

	
}
