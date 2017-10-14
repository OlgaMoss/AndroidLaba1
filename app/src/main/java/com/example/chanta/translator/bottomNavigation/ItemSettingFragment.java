package com.example.chanta.translator.bottomNavigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chanta.translator.R;

/**
 * Created by chanta on 07.10.17.
 */

public class ItemSettingFragment extends Fragment {
    public static ItemSettingFragment newInstance() {
        ItemSettingFragment fragment = new ItemSettingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_setting, container, false);
    }
}
