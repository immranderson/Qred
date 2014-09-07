package com.qred.android.give_qred;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.qred.android.R;
import com.qred.android.profile.Category;

/**
 * Created by tomanderson on 9/6/14.
 */
public class GiveQredPointsDialogFragment extends DialogFragment {


    private static final String CATEGORY_NAME = "category_name";
    private static final String CATEGORY_ICON = "category_icon";
    private static final String CATEGORY_DESCRIPTION = "category_description";

    private ImageView mIconImageView;
    private TextView mNameTextView;
    private TextView mDescriptionTextView;

    private SeekBar mSeekBar;
    private TextView mPointsToGiveTextView;

    public static GiveQredPointsDialogFragment newInstance(Category category) {
        GiveQredPointsDialogFragment fragment = new GiveQredPointsDialogFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY_NAME, category.getName());
        args.putInt(CATEGORY_ICON, category.getIcon());
        args.putString(CATEGORY_DESCRIPTION, category.getDescription());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_fragment_give_qred_points, null);

        mIconImageView = (ImageView) view.findViewById(R.id.qred_points_iv);
        mNameTextView = (TextView) view.findViewById(R.id.qred_points_name_tv);
        mDescriptionTextView = (TextView) view.findViewById(R.id.qred_points_description_tv);
        mSeekBar = (SeekBar) view.findViewById(R.id.qred_points_seekBar);
        mPointsToGiveTextView = (TextView) view.findViewById(R.id.qred_points_number_to_give_tv);


        mIconImageView.setImageResource(getArguments().getInt(CATEGORY_ICON));

        mNameTextView.setText(getArguments().getString(CATEGORY_NAME));

        mDescriptionTextView.setText(getArguments().getString(CATEGORY_DESCRIPTION));


        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mPointsToGiveTextView.setText("Give " + progress + " " + getArguments().getString(CATEGORY_NAME) + " Points!");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        builder.setView(view);

        builder.setPositiveButton("Give Points", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        Dialog dialog = builder.create();


        return dialog;
    }
}
