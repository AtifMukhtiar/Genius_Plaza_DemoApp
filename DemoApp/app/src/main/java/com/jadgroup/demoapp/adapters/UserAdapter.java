package com.jadgroup.demoapp.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jadgroup.demoapp.R;
import com.jadgroup.demoapp.models.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    ArrayList<User> userList;

    public UserAdapter(Activity context, ArrayList<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        User user = new User();
        user = userList.get(position);
        ViewHolder itemViewHolder = (ViewHolder) viewHolder;
        itemViewHolder.textView_name.setText(user.getFirstName() + " " + user.getLastName());

        Picasso.with(context)
                .load(user.getAvatar())
                .into(itemViewHolder.imgView_icon);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView_icon;
        TextView textView_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView_icon = itemView.findViewById(R.id.imgView_icon);
            textView_name = itemView.findViewById(R.id.txtView_name);
        }
    }


    public void addList(ArrayList<User> data) {
        userList = data;
    }
}
