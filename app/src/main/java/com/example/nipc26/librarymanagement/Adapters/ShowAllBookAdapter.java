package com.example.nipc26.librarymanagement.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nipc26.librarymanagement.R;
import com.example.nipc26.librarymanagement.activities.BookDetailsMainActivity;
import com.example.nipc26.librarymanagement.activities.UserDetailMainActivity;
import com.example.nipc26.librarymanagement.model.BookModel;

import java.util.List;

/**
 * Created by NI PC 26 on 10/27/2016.
 */

public class ShowAllBookAdapter  extends RecyclerView.Adapter<ShowAllBookAdapter.ShowAllBookHolder> implements View.OnClickListener {

    private Context context;
    private List<BookModel> bookModels;


    public ShowAllBookAdapter(Context context, List<BookModel> bookModels) {
        this.context = context;
        this.bookModels = bookModels;
    }

    @Override
    public ShowAllBookAdapter.ShowAllBookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_show_all_user_layout, parent, false);
        view.setOnClickListener(this);
        return new ShowAllBookAdapter.ShowAllBookHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowAllBookAdapter.ShowAllBookHolder holder, final int position) {
        holder.reportID.setText(bookModels.get(position).getBookName());
        holder.reportID.setTag(position);
        holder.tvHCEId.setText(bookModels.get(position).getBookType());
        holder.ivFrontArrow.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return bookModels.size();
    }

    @Override
    public void onClick(View v) {
        TextView reportID = (TextView) v.findViewById(R.id.tvReportingItemGeneration);
        int position = Integer.parseInt( reportID.getTag().toString());
        Intent intent = new Intent(context, BookDetailsMainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("bookModel",bookModels.get(position));
        intent.putExtras(bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);

    }


    public class ShowAllBookHolder extends RecyclerView.ViewHolder {
        ImageView imageViewReport;
        TextView reportID;
        TextView tvHCEId;
        ImageView ivFrontArrow;


        public ShowAllBookHolder(View itemView) {
            super(itemView);
            this.imageViewReport = (ImageView) itemView.findViewById(R.id.ivReportingItemGeneration);
            this.reportID = (TextView) itemView.findViewById(R.id.tvReportingItemGeneration);
            this.tvHCEId = (TextView) itemView.findViewById(R.id.tvHCEId);
            this.ivFrontArrow = (ImageView)itemView.findViewById(R.id.ivFrontArrow);

        }
    }
}

