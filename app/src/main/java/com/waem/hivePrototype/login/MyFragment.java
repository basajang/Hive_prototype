//package com.waem.hivePrototype.login;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.fragment.app.Fragment;
//
//import com.waem.hivePrototype.R;
//
//public class MyFragment extends Fragment {
//
//    public Fragment newInstance(Activity context, int pos, float scale) {
//        Bundle b = new Bundle();
//        b.putInt("pos", pos);
//        b.putFloat("scale", scale);
//        return Fragment.instantiate(context, MyFragment.class.getName(), b);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        if (container == null) {
//            return null;
//        }
//
//        LinearLayout l = (LinearLayout)
//                inflater.inflate(R.layout.fragment_biometric, container, false);
//
//        int pos = this.getArguments().getInt("pos");
////
//        TextView tv = (TextView) l.findViewById(R.id.text);
////        tv.setText("Position = " + pos);
//        MyLinearLayout root = (MyLinearLayout) l.findViewById(R.id.root);
//        float scale = this.getArguments().getFloat("scale");
//        root.setScaleBoth(scale);
//
//        return l;
//    }
//}