package com.waem.hivePrototype.login;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.login.interfaces.CardAdapter;

import java.util.ArrayList;
import java.util.List;

public class CardFragmentPagerAdapter extends FragmentPagerAdapter implements ViewPager.PageTransformer {

    private List<Fragment> fragments;

    public final static float BIG_SCALE = 1.0f;
    public final static float SMALL_SCALE = 0.7f;
    public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;

    private MyLinearLayout cur = null;
    private MyLinearLayout next = null;
    private LoginActivity context;
    private FragmentManager fm;
    private float scale;

    public CardFragmentPagerAdapter(LoginActivity context, FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fm = fm;
        this.context = context;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {

        // make the first pager bigger than others
        if (position == LoginActivity.FIRST_PAGE)
            scale = BIG_SCALE;
        else
            scale = SMALL_SCALE;

        position = position % fragments.size();

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void transformPage(View page, float position) {
        MyLinearLayout myLinearLayout = (MyLinearLayout) page.findViewById(R.id.root);
        float scale = BIG_SCALE;
        if (position > 0) {
            scale = scale - position * DIFF_SCALE;
        } else {
            scale = scale + position * DIFF_SCALE;
        }
        if (scale < 0) scale = 0;
        myLinearLayout.setScaleBoth(scale);
    }
    public void addFragment(Fragment myFragment){

        if(null == fragments){
            fragments = new ArrayList<>();
        }
        fragments.add(myFragment);

    }
}