package com.qred.android.give_qred;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.qred.android.R;
import com.qred.android.profile.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomanderson on 9/6/14.
 */
public class GiveCredFragment extends Fragment {


    private GridView mGridView;
    private GiveCredBadgesAdapter mGiveCredBadgesAdapter;
    private List<Category> mCategories;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mCategories = new ArrayList<Category>();

        mCategories.add(new Category("Hello", "Hello", 1));
        mCategories.add(new Category("Hello", "Hello", 1));
        mCategories.add(new Category("Hello", "Hello", 1));
        mCategories.add(new Category("Hello", "Hello", 1));
        mCategories.add(new Category("Hello", "Hello", 1));


        View view = inflater.inflate(R.layout.fragment_give_qred, container, false);

        mGiveCredBadgesAdapter = new GiveCredBadgesAdapter(mCategories);
        mGridView = (GridView) view.findViewById(R.id.give_cred_gv);

        mGridView.setAdapter(mGiveCredBadgesAdapter);

        return view;
    }


    private class GiveCredBadgesAdapter extends BaseAdapter {


        private List<Category> categories;

        public GiveCredBadgesAdapter(List<Category> categories) {
            this.categories = categories;
        }

        @Override
        public int getCount() {
            return categories.size();
        }

        @Override
        public Category getItem(int position) {
            return categories.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_cred_badge, parent, false);


            return view;
        }
    }



}
