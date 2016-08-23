package com.example.sss.careerandfuturemajor;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RVCadpaterCreator extends RecyclerView.Adapter<RVCadpaterCreator.viewHolder> {
    private Context mc;
    private ArrayList<Creator> c;
    public Context getContext(){
        return mc;
    }
    public RVCadpaterCreator(){

    }
    public RVCadpaterCreator(Context mc,ArrayList<Creator> c){
        this.mc=mc;
        this.c=c;
    }
    public class viewHolder extends RecyclerView.ViewHolder{
        public TextView txtName,txtFb,txtPhone;
        public ImageView imgPhoto;
        public viewHolder(View v){
            super(v);
            txtName=(TextView)v.findViewById(R.id.txtName);
            txtFb=(TextView)v.findViewById(R.id.txtFb);
            txtPhone=(TextView)v.findViewById(R.id.txtPhone);
            imgPhoto=(ImageView)v.findViewById(R.id.imgCreator);
        }
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        TextView Name,Fb,Phone;
        ImageView Photo;
        Name=holder.txtName;
        Fb=holder.txtFb;
        Phone=holder.txtPhone;
        Photo=holder.imgPhoto;
        Name.setText(c.get(position).getName());
        Fb.setText(c.get(position).getFacebook());
        Phone.setText(c.get(position).getPhone());
        Photo.setImageResource(c.get(position).getPic());
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View creatorView = inflater.inflate(R.layout.creator_layout, parent, false);

        // Return a new holder instance
        viewHolder mviewholder = new viewHolder(creatorView);
        return mviewholder;
    }

    @Override
    public int getItemCount() {
        return c.size();
    }
}
