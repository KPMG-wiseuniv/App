package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//RecyclerView Adapter contains list of items in cart, it's just for UX/UI
public class Cart_Adapter extends RecyclerView.Adapter {
    ArrayList<Cart_Item> data;
    Context context;
    OnCartItemClickListener listener;

    public interface OnCartItemClickListener{//interface for deleting item in cart
        void deleteItemClick(CartViewHolder holder, View view, int position);
    }

    public Cart_Adapter(ArrayList<Cart_Item> data, Context context){
        this.data=data;
        this.context=context;
    }

    public void setOnCartItemClickListener(OnCartItemClickListener listener){
        this.listener=listener;
    }

    static final class CartViewHolder extends RecyclerView.ViewHolder{//viewholder for Cart_Adapter
        TextView product_name;
        TextView product_price;
        ImageView product_delete_btn;

        OnCartItemClickListener listener;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name=itemView.findViewById(R.id.product_name);
            product_price=itemView.findViewById(R.id.product_price);
            product_delete_btn=itemView.findViewById(R.id.product_delete_btn);

            product_delete_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    if(listener!=null){
                        listener.deleteItemClick(CartViewHolder.this, v, position);
                    }
                }
            });
        }
        public void setItem(Cart_Item item){
            product_name.setText(item.getName());
            product_price.setText(item.getPrice());
        }

        public void setOnCartItemClickListener(OnCartItemClickListener listener){
            this.listener=listener;
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.cart_recyclerview_item, parent, false);
        return new CartViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CartViewHolder vh=(CartViewHolder)holder;
        vh.setItem(data.get(position));

        vh.setOnCartItemClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    public void changeData(ArrayList<Cart_Item> newdata){
        if(data!=null){
            data=null;
        }
        data=newdata;
        notifyDataSetChanged();
    }
}
