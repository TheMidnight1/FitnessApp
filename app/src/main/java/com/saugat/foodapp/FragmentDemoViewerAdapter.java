package com.saugat.foodapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentDemoViewerAdapter extends FragmentStateAdapter {
    public FragmentDemoViewerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragmentDemo();
            case 1:
                return new SettingFragment();
            default:
                return new HomeFragmentDemo();

        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
