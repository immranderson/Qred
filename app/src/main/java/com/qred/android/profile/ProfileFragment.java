package com.qred.android.profile;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.qred.android.R;

import java.util.List;

/**
 * Created by tomanderson on 9/6/14.
 */
public class ProfileFragment extends Fragment {


    private ImageView mProfileImageView;
    private ListView mStatsListView;


    public static ProfileFragment newInstance(int sectionNumber) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        mStatsListView = (ListView) rootView.findViewById(R.id.profile_stats_lv);

        return rootView;
    }

    private class StatsListBaseAdapter extends BaseAdapter {


        private List<Statistics> mStatistics;

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }



}
