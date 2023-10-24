package com.example.th4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee>
{
    private Activity context;


    public EmployeeAdapter(Activity context, int layoutID, List<Employee>
            objects) {
        super(context, layoutID, objects);
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return super.getCount();
    }
    @NonNull
    @Override
    public View getView( int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if (convertView == null) {
            convertView =
                    LayoutInflater.from(context).inflate(R.layout.item_employee, null,
                            false);
        }

        TextView tvFullName = (TextView) convertView.findViewById(R.id.item_employee_tv_fullname);
        TextView tvPosition = (TextView) convertView.findViewById(R.id.item_employee_tv_position);
        ImageView ivManager = (ImageView) convertView.findViewById(R.id.item_employee_iv_manager);
        LinearLayout llParent = (LinearLayout) convertView.findViewById(R.id.item_employee_ll_parent);

        Employee employee =getItem(position);

        if (employee.getName()!=null) {
            tvFullName.setText(employee.getName());
        }
        else tvFullName.setText("");
        // If this is a manager -> show icon manager. Otherwise, show Staff in tvPosition
        if (employee.isManager())
        {
            ivManager.setVisibility(View.VISIBLE);
            tvPosition.setVisibility(View.GONE);
        }
        else
        {
            ivManager.setVisibility(View.GONE);
            tvPosition.setVisibility(View.VISIBLE);
            tvPosition.setText("Staff");
        }
        // Show different color backgrounds for 2 continuous employees
        if (position%2==0)
        {
            llParent.setBackgroundResource(R.color.white);
        }
        else
        {
            llParent.setBackgroundResource(R.color.white);
        }

        return convertView;
    }
}

