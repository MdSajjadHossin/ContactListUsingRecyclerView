package com.example.recyclerviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.slider.LabelFormatter;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>{

    Context context;
    ArrayList<ContactModel> arrContact;
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
        this.context = context;
        this.arrContact = arrContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contact_card_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(arrContact.get(position).img);
        holder.textName.setText(arrContact.get(position).name);
        holder.textNumber.setText(arrContact.get(position).number);

    }

    @Override
    public int getItemCount() {
        return arrContact.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textName, textNumber;
        ImageView imageView;

        public ViewHolder( View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.ContactName);
            textNumber = itemView.findViewById(R.id.ContactNumber);
            imageView = itemView.findViewById(R.id.contactImage);

        }
    }
}
