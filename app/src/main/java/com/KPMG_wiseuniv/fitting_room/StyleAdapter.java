package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class StyleAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener {

    private Context context;
    private List list;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
    }

    class ViewHolder {
        public TextView style_name;
        public TextView style_desc;
        public ImageView style_image;
    }

    public StyleAdapter(Context context, ArrayList list){
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.single_style_list, parent, false);
        }

        viewHolder = new ViewHolder();
        viewHolder.style_name = (TextView) convertView.findViewById(R.id.styleText1);
        viewHolder.style_desc = (TextView) convertView.findViewById(R.id.styleText2);
        viewHolder.style_image = (ImageView) convertView.findViewById(R.id.styleImage);

        final SingleStyle singleStyle = (SingleStyle) list.get(position);
        viewHolder.style_name.setText(singleStyle.getStyle());
        viewHolder.style_desc.setText(singleStyle.getDesc());
        Glide
                .with(context)
                .load(singleStyle.getResId())
                .apply(new RequestOptions().override(100, 70))
                .into(viewHolder.style_image);
        viewHolder.style_name.setTag(singleStyle.getStyle());

//        //아이템 클릭 방법2 - 클릭시 아이템 반전 효과가 안 먹힘
//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, " " + actor.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

        //Return the completed view to render on screen
        return convertView;
    }
}