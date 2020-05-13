package com.brocas.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.ViewHolder> {

    private List<VerificationItem> verificationItem;
    private InformationCallback callback;

    public BankAdapter(List<VerificationItem> verificationItem,InformationCallback callback) {
        this.verificationItem = verificationItem;
        this.callback=callback;
    }

    @NonNull
    @Override
    public BankAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BankAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bank_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BankAdapter.ViewHolder holder, final int position) {
        if(position!=0){
            holder.topline.setVisibility(View.GONE);
        }
        holder.itemimg.setImageResource(verificationItem.get(position).getImg());
        holder.txt_title.setText(verificationItem.get(position).getTitle());
        holder.Bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onInformationClicked(verificationItem.get(position).getTitle(),verificationItem.get(position).getImg());
            }
        });
    }

    @Override
    public int getItemCount() {
        return verificationItem.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout Bank;
        ImageView itemimg;
        TextView txt_title;
        View topline;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Bank=itemView.findViewById(R.id.Bank);
            itemimg = itemView.findViewById(R.id.itemimg);
            txt_title = itemView.findViewById(R.id.txt_title);
            topline=itemView.findViewById(R.id.topline);
        }
    }
}
