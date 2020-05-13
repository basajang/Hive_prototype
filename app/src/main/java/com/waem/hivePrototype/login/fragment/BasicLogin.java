package com.waem.hivePrototype.login.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.waem.hivePrototype.BuildConfig;
import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.MainActivity;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.util.dbmanager.RealmManager;


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
            String id = etBasicLoginId.getText().toString();
            String pw = etBasicLoginPw.getText().toString();


            if(RealmManager.getInstance().getUserTest().getIdLoginUser(id,pw).size()==1){

                Log.d(GlobalConst.TAG,"로그인 : "+RealmManager.getInstance().getUserTest().getIdLoginUser(id,pw).size());
                Log.d(GlobalConst.TAG,"로그인 : " +RealmManager.getInstance().getUserTest().getIdLoginUser(id,pw));

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                Toast.makeText(context," 로그인 되었습니다.",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context,"로그인에 실패하였습니다.",Toast.LENGTH_SHORT).show();
            }

        });

    }
}
