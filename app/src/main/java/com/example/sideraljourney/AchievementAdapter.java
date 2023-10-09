package com.example.sideraljourney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AchievementAdapter extends RecyclerView.Adapter<AchievementAdapter.ViewHolder> {
    private List<Achievement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public AchievementAdapter(List<Achievement> achievementList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = achievementList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public AchievementAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element, null);
        return new AchievementAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AchievementAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<Achievement> items){ mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView title, description;

        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            title = itemView.findViewById(R.id.titleTextView);
            description = itemView.findViewById(R.id.descriptionTextView);
        }

        void bindData(final Achievement item){
            title.setText(item.getName());
            description.setText(item.getDescription());
        }
    }
}
