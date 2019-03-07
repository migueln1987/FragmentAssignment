package com.example.android.android_me.ui;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    ImageView fragmentPartImageView;
    int displayIndex;
    List<Integer> imageIds;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("BodyPartFragment", "onCreateViewHeadFragment");
        View view = inflater.inflate(R.layout.fragment_body_part, container, false);
        fragmentPartImageView = view.findViewById(R.id.fragment_image);
        if(imageIds != null) {
            fragmentPartImageView.setImageDrawable((getResources().getDrawable(imageIds.get(displayIndex))));
        }
        return view;
    }

    public void setDisplayIndex(int index) {
        this.displayIndex = index;
    }

    public void setImageIds(List<Integer> imageIds) {
        this.imageIds = imageIds;
    }
}
