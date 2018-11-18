package com.example.retrofitfirst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitfirst.entity.dino.Dino;
import com.example.retrofitfirst.entity.dino.DinoWrapper;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by Dmitry Titorenko on 17.11.2018.
 * <p>
 * load image use Glide
 * https://bumptech.github.io/glide/
 */
public class ViewDinoAdapter extends RecyclerView.Adapter<ViewDinoAdapter.DinoHolder> {

    private static DinoWrapper dinoWrapper;

    public void setDinoWrapper(DinoWrapper dinoWrapper) {
        this.dinoWrapper = dinoWrapper;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class DinoHolder extends RecyclerView.ViewHolder {

        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView dinosData;
        ImageView imageView;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public DinoHolder(View itemView) {

            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            dinosData = itemView.findViewById(R.id.tvItemDino);
            imageView = itemView.findViewById(R.id.imDino);
        }
    }


    // inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public ViewDinoAdapter.DinoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View dinoView = inflater.inflate(R.layout.item_dino, parent, false);

        // Return a new holder instance
        DinoHolder dinoHolder = new DinoHolder(dinoView);
        return dinoHolder;
    }


    // set the view attributes based on the data
    @Override
    public void onBindViewHolder(@NonNull DinoHolder holder, int position) {

        // Get the data model based on position
        Dino dino = dinoWrapper.getDinos().get(position);

        // Set item views based on your views and data model
        TextView textView = holder.dinosData;
        textView.setText("Title: " + dino.getDino().getDinoTitle() +
                "\n" + "Color: " + dino.getDino().getDinoColor() +
                "\n" + "Birthdate: " + dino.getDino().getDinoBirthdate() +
                "\n" + "About: " + dino.getDino().getDinoAbout());

        ImageView imageView = holder.imageView;

        // load and set image
        String url = dino.getDino().getDinoImage().getSrc();
        Glide.with(imageView)
                .load(url)
                .into(holder.imageView)
                .waitForLayout();
    }


    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        if (dinoWrapper.getDinos() == null)
            return 0;
        return dinoWrapper.getDinos().size();
    }

    ViewDinoAdapter(DinoWrapper dinoWrapper) {
        this.dinoWrapper = dinoWrapper;
    }
}
