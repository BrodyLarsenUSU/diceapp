package com.usu.brodylarsendiceapp;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import com.usu.brodylarsendiceapp.CustomAdapter;
import com.usu.brodylarsendiceapp.Result;

public class ResultsAdapter extends CustomAdapter<Result> {
    ResultClickedListener listener;
    public ResultsAdapter(ObservableArrayList<Result> data, ResultClickedListener listener) {
        super(data);
        this.listener = listener;
    }

    @Override
    public int getLayout() {
        return R.layout.result_item;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = data.get(position);
        TextView resultDisplay = holder.getItemView().findViewById(R.id.resultsItem);
        resultDisplay.setText(result.number);
    }
}
