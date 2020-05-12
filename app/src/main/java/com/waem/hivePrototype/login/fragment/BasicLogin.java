package com.waem.hivePrototype.login.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.waem.hivePrototype.BuildConfig;
import com.waem.hivePrototype.MainActivity;
import com.waem.hivePrototype.R;


public class BasicLogin extends Fragment {

    private CardView cardView;
    private EditText etBasicLoginId,etBasicLoginPw;
    private Button btnBasicLogin;
    private View view;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        view = (LinearLayout) inflater.inflate(R.layout.fragment_basic_login, container, false);

        context = container.getContext();

        init();
        listener();

        return view;
    }
    private void init(){
        etBasicLoginId = view.findViewById(R.id.et_basic_login_id);
        etBasicLoginPw = view.findViewById(R.id.et_basic_login_pw);
        btnBasicLogin = view.findViewById(R.id.btn_basic_login);
    }

    private void listener(){

        btnBasicLogin.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity.class);
            startActivity(intent);
        });

    }
}
