package com.example.loginapicalldemo.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginapicalldemo.R;
import com.example.loginapicalldemo.adapter.EmployeeListAdapter;
import com.example.loginapicalldemo.global;
import com.example.loginapicalldemo.model.ResponseDataClass;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeeListActivity extends AppCompatActivity {

    @BindView(R.id.rcylist)
    RecyclerView rcylist;
    ArrayList<ResponseDataClass> employeelist=new ArrayList<>();
    EmployeeListAdapter employeeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        ButterKnife.bind(this);

        String name = global.arry.get(0).getEmployeeName();
        Log.v("name",name);
        Integer empId = global.arry.get(0).getEmployeeId();
        Log.v("eid", String.valueOf(empId));
        Integer subId = global.arry.get(0).getSubscriptionId();
        Log.v("subId", String.valueOf(subId));
        String sub = global.arry.get(0).getSubscription();
        Log.v("sub",sub);
        Integer verticalId = global.arry.get(0).getVerticalId();
        Log.v("verticalID", String.valueOf(verticalId));
        String screenname = global.arry.get(0).getScreenName();
        Log.v("screenname",screenname);

        employeeListAdapter = new EmployeeListAdapter(global.arry,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcylist.setLayoutManager(mLayoutManager);
        rcylist.setAdapter(employeeListAdapter);
    }
}