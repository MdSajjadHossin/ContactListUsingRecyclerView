package com.example.recyclerviewproject;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

        ContactModel model = (ContactModel) arrContact.get(position);
        holder.imageView.setImageResource(arrContact.get(position).img);
        holder.textName.setText(arrContact.get(position).name);
        holder.textNumber.setText(arrContact.get(position).number);

        //update operation
        holder.contactRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_layout);

                EditText editName = dialog.findViewById(R.id.nameFiled);
                EditText editNumber = dialog.findViewById(R.id.numberFiled);
                Button addButton = dialog.findViewById(R.id.addBtn);
                TextView titleText = dialog.findViewById(R.id.titleText);

                //changing add layout title and button name
                addButton.setText("Update");
                titleText.setText("Update Contact");

                //getting clicked contact value
                editName.setText((arrContact.get(position)).name);
                editNumber.setText((arrContact.get(position)).number);




                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String name = "", number = "";
                        if(!editName.getText().toString().equals("")){
                            name = editName.getText().toString();
                        }else{
                            Toast.makeText(context, "Please Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!editNumber.getText().toString().equals("")){
                            number = editNumber.getText().toString();
                        }else{
                            Toast.makeText(context, "Please Enter Contact Number", Toast.LENGTH_SHORT).show();
                        }
                        arrContact.set(position, new ContactModel(name, number));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrContact.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textName, textNumber;
        ImageView imageView;
        LinearLayout contactRow;

        public ViewHolder( View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.ContactName);
            textNumber = itemView.findViewById(R.id.ContactNumber);
            imageView = itemView.findViewById(R.id.contactImage);
            contactRow = itemView.findViewById(R.id.contactRow);

        }
    }
}
