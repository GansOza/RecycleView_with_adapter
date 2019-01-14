package com.example.admin_pc.recycleviewwithmvvm.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin_pc.recycleviewwithmvvm.R;

import java.util.ArrayList;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerviewAdapter
        extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {
    private static final String Tag="recyclerView";

    private ArrayList<String> mimageName = new ArrayList<>();
    private ArrayList<String> mimageUrl = new ArrayList<>();
    private Context context;

    public RecyclerviewAdapter(ArrayList<String> imageName, ArrayList<String> imageUrl, Context context) {
        this.mimageName = imageName;
        this.mimageUrl = imageUrl;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listview_activity,viewGroup,false);

        ViewHolder holder = new ViewHolder(view);
        return holder;

    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        Log.d(Tag,"Binded data");

        //set all images with url
        Glide.with(context)
                .asBitmap()
                .load(mimageUrl.get(i))
                .into(viewHolder.circleImageView);

        //set images name
        viewHolder.imageName.setText(mimageName.get(i));

        //onclick method
        viewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mimageName.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mimageName.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

  //  @BindView(R.id.image_circle)
    CircleImageView circleImageView;

    //@BindView(R.id.image_name)
    TextView imageName;

    //@BindView(R.id.parent_layout)
    RelativeLayout parent_layout;



    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        circleImageView = itemView.findViewById(R.id.image_circle);
        imageName = itemView.findViewById(R.id.image_name);
        parent_layout = itemView.findViewById(R.id.parent_layout);

    }

    }
}
