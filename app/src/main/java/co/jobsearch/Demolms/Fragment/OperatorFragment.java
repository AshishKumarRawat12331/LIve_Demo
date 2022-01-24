package co.jobsearch.Demolms.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import co.jobsearch.Demolms.R;

public class OperatorFragment extends BottomSheetDialogFragment implements View.OnClickListener {

RelativeLayout rlCancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_opeartorlist, container, false);

        getIds(v);

        return v;


    }

    private void getIds(View v) {
        rlCancel = (RelativeLayout)v.findViewById(R.id.rl_close);

        setListners();

    }




    private void setListners() {
        rlCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==rlCancel)
        {
            dismiss();
        }
    }


}
