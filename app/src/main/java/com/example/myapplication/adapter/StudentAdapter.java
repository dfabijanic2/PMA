package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.classes.StudentInfoView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final int HEADER = -1;
    final int STUDENT = -2;
    List<Object> dataList;

    public StudentAdapter(List<Object> myDataset) {

        dataList = myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType == HEADER){
            View view = inflater.inflate(R.layout.header_holder, parent, false);
            return new HeaderViewHolder(view);
        } else if(viewType == STUDENT){
            View view = inflater.inflate(R.layout.student_holder, parent, false);
            return new StudentViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == HEADER){
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.tvNaslov.setText((String)dataList.get(position));
        }
        else if(getItemViewType(position) == STUDENT){
            StudentViewHolder studentViewHolder = (StudentViewHolder) holder;
            StudentInfoView student = (StudentInfoView) dataList.get(position);
            studentViewHolder.tvName.setText(student.FirstName);
            studentViewHolder.tvPrezime.setText(student.LastName);
            studentViewHolder.tvPredmet.setText(student.ClassName);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if( dataList.get(position) instanceof StudentInfoView )
        {
            return STUDENT;
        }
        else
        {
            return HEADER;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvPrezime;
        private TextView tvPredmet;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrezime = itemView.findViewById(R.id.tvPrezime);
            tvPredmet = itemView.findViewById(R.id.tvPredmet);
        }

    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNaslov;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNaslov = itemView.findViewById(R.id.tvNaslov);

        }


    }

}
