package com.waem.hivePrototype.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.waem.hivePrototype.R;


public class Biometric extends CardFragment {

    private CardView cardView;

    @Override
    public Fragment getInstance(int position) {
        return super.getInstance(position);
    }

    @Override
    public CardView getCardView() {
        return cardView;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.biometric, container, false);
        return view;
    }

}
