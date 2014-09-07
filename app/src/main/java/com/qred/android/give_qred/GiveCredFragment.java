package com.qred.android.give_qred;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

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

        mCategories.add(new Category("Cool", "Hello", R.drawable.ic_cool));
        mCategories.add(new Category("Funny", "Hello", R.drawable.ic_funny));
        mCategories.add(new Category("Fashion", "Hello", R.drawable.ic_fashionable));
        mCategories.add(new Category("Celebrity", "Hello", R.drawable.ic_celebrity));

        View view = inflater.inflate(R.layout.fragment_give_qred, container, false);

        mGiveCredBadgesAdapter = new GiveCredBadgesAdapter(mCategories);
        mGridView = (GridView) view.findViewById(R.id.give_cred_gv);

        mGridView.setAdapter(mGiveCredBadgesAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category selectedCategory = mGiveCredBadgesAdapter.getItem(position);

                GiveQredPointsDialogFragment giveQredPointsDialogFragment = GiveQredPointsDialogFragment.newInstance(selectedCategory);

                giveQredPointsDialogFragment.show(getFragmentManager(), "TAG");
            }
        });

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

            Category category = categories.get(position);

            ImageView badgeImageView = (ImageView) view.findViewById(R.id.cred_badge_iv);
            TextView badgeTextView = (TextView) view.findViewById(R.id.cred_badge_tv);


            badgeImageView.setImageResource(category.getIcon());
            badgeTextView.setText(category.getName());

            return view;
        }
    }



}
