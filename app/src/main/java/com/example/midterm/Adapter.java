package com.example.midterm;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        public interface ItemSelected{

            public void onItemClicked(int index);

      }

        ItemSelected myActivity;
       ArrayList<ListItems> listitem;
        public Adapter(Context context, ArrayList<ListItems> list)
        {
            myActivity = (ItemSelected) context;
            listitem = list;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvName, tvItems;
            ImageView ivPriority;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvName = itemView.findViewById(R.id.tvName);
                tvItems = itemView.findViewById(R.id.tvItems);
                ivPriority = itemView.findViewById(R.id.ivPriority);

              itemView.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      myActivity.onItemClicked(listitem.indexOf((ListItems)itemView.getTag()));

                  }
              });
            }
        }

        @NonNull
        @Override
        public  ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
            return new ViewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            ListItems obj;

            holder.itemView.setTag(listitem.get(position));
            holder.tvName.setText(listitem.get(position).getName());
            holder.tvItems.setText(listitem.get(position).getItems());
            if(listitem.get(position).getPriority().equals("HIGH"))
            {
                holder.ivPriority.setImageResource(R.drawable.greentag);
            }
            else if(listitem.get(position).getPriority().equals("MEDIUM"))
            {
                holder.ivPriority.setImageResource(R.drawable.yellowtag);
            }
            else if(listitem.get(position).getPriority().equals("LOW"))
            {
                holder.ivPriority.setImageResource(R.drawable.redtag);
            }
            else
            {
                holder.ivPriority.setImageResource(R.drawable.greentag);
            }
        }

        @Override
        public int getItemCount() {
            return listitem.size();
        }





    }
