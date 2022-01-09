package com.example.loginapicalldemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ReportFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginapicalldemo.R;
import com.example.loginapicalldemo.model.ResponseDataClass;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewholder> {

    ArrayList<ResponseDataClass> employeelist;
    Context context;


    public EmployeeListAdapter(ArrayList<ResponseDataClass> employeelist, Context context) {
        this.employeelist = employeelist;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adap_employee_list, parent, false);

        return new EmployeeViewholder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull EmployeeViewholder holder, int position) {

        holder.tvEmpname.setText(employeelist.get(position).getEmployeeName());
        holder.tvEmpid.setText(employeelist.get(position).getEmployeeId().toString());
        holder.tvEmpname.setText(employeelist.get(position).getEmployeeName());
        holder.subscriptionid.setText(employeelist.get(position).getSubscriptionId().toString());
        holder.tvSubscription.setText(employeelist.get(position).getSubscription());
        holder.tvVerticalid.setText(employeelist.get(position).getVerticalId().toString());
        holder.tvScreenname.setText(employeelist.get(position).getScreenName());
        holder.tvTeams.setText(employeelist.get(position).getTeams().get(0).toString());
    }

    @Override
    public int getItemCount() {
        return employeelist.size();
    }

    public class EmployeeViewholder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_empid)
        AppCompatTextView tvEmpid;
        @BindView(R.id.tv_empname)
        AppCompatTextView tvEmpname;
        @BindView(R.id.subscriptionid)
        AppCompatTextView subscriptionid;
        @BindView(R.id.tv_subscription)
        AppCompatTextView tvSubscription;
        @BindView(R.id.tv_verticalid)
        AppCompatTextView tvVerticalid;
        @BindView(R.id.tv_teams)
        AppCompatTextView tvTeams;
        @BindView(R.id.tv_screenname)
        AppCompatTextView tvScreenname;
        public EmployeeViewholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
