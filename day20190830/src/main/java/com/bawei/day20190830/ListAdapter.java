package com.bawei.day20190830;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * author: 盖磊
 * data: 2019/8/30 21:21:03
 * function:
 */
public class ListAdapter extends BaseAdapter {
    private List<ListBean.ResultInfo> list;
    private Context context;

    public ListAdapter(List<ListBean.ResultInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = View.inflate(context,R.layout.item_list,null);
            holder = new ViewHolder();
            holder.iv = convertView.findViewById(R.id.iv);
            holder.tv = convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.iv);
        holder.tv.setText(list.get(position).getName());

        return convertView;
    }

    class ViewHolder{
        ImageView iv;
        TextView tv;
    }
}
