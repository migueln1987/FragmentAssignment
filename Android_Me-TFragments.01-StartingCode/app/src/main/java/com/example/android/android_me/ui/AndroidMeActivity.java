/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    BodyPartFragment headPartFragment;
    BodyPartFragment bodyPartFragment;
    BodyPartFragment legPartFragment;
    FragmentManager headFragmentManager;
    FragmentManager bodyFragmentManager;
    FragmentManager legFragmentManager;

    int headIndex = 0;
    int bodyIndex = 0;
    int legIndex = 0;

    @BindView(R.id.head_container)
    FrameLayout headContainer;
    @BindView(R.id.body_container)
    FrameLayout bodyContainer;
    @BindView(R.id.leg_container)
    FrameLayout legContainer;

    //TODO(1) Create a layout that displays the one body part image named fragment_body_part.xml
        // This layout should contain one single ImageView
    //TODO(2) Create a new class called BodyPartFargment to display  an image of an Android-Me body part
        // in this class, you'll need to implement an empty constructor and the onCreateView()
    //TODO(3) Show the first image in the list of head  image
        //Soon, you'll update this image display code to show any image you want
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        ButterKnife.bind(this);
        // TODO (5) Create a new instance of BodyPartFragment and display it using FragmentManager
        createManagers();


        headPartFragment.setDisplayIndex(headIndex);
        headPartFragment.setImageIds(AndroidImageAssets.getHeads());
        headFragmentManager = getSupportFragmentManager();
        headFragmentManager.beginTransaction().add(R.id.head_container, headPartFragment).commit();
        bodyPartFragment.setDisplayIndex(bodyIndex);
        bodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
        legPartFragment.setDisplayIndex(legIndex);
        legPartFragment.setImageIds(AndroidImageAssets.getLegs());
    }

    public void createManagers() {
        // Make instance of headPartFragment
        headPartFragment = new BodyPartFragment();
        // Make instance of BodyPartFragment
        bodyPartFragment = new BodyPartFragment();
        // Make instance of legPartFragment
        legPartFragment = new BodyPartFragment();

        // Head


        // Body
        bodyFragmentManager = getSupportFragmentManager();
        bodyFragmentManager.beginTransaction().add(R.id.body_container, bodyPartFragment).commit();

        // Leg
        legFragmentManager = getSupportFragmentManager();
        legFragmentManager.beginTransaction().add(R.id.leg_container, legPartFragment).commit();
    }

    @OnClick({R.id.head_container, R.id.body_container, R.id.leg_container})
    public void showToastChangePic(FrameLayout frameLayout){
        switch(frameLayout.getId()) {
            case R.id.head_container:
                Toast.makeText(frameLayout.getContext(), "Head is pressed", Toast.LENGTH_SHORT).show();
                if (headIndex < AndroidImageAssets.getHeads().size() - 1) {
                    headIndex++;
                    Log.d("showToastChangePic", "headIndex = " + headIndex);

                    this.headPartFragment = new BodyPartFragment();
                    this.headPartFragment.setImageIds(AndroidImageAssets.getHeads());
                    this.headPartFragment.setDisplayIndex(headIndex);
                    headFragmentManager = getSupportFragmentManager();
                    headFragmentManager.beginTransaction().replace(R.id.head_container, headPartFragment).commit();
                } else {
                    headIndex = 0;
                    Log.d("showToastChangePic", "headIndex = " + headIndex);
                    this.headPartFragment = new BodyPartFragment();
                    this.headPartFragment.setImageIds(AndroidImageAssets.getHeads());
                    this.headPartFragment.setDisplayIndex(headIndex);
                    headFragmentManager = getSupportFragmentManager();
                    headFragmentManager.beginTransaction().replace(R.id.head_container, headPartFragment).commit();
                }
                break;
            case R.id.body_container:
                Toast.makeText(frameLayout.getContext(), "Body is pressed", Toast.LENGTH_SHORT).show();
                if (bodyIndex < AndroidImageAssets.getBodies().size() - 1) {
                    bodyIndex++;
                    Log.d("showToastChangePic", "bodyIndex = " + bodyIndex);
                    this.bodyPartFragment = new BodyPartFragment();
                    this.bodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
                    this.bodyPartFragment.setDisplayIndex(bodyIndex);
                    bodyFragmentManager = getSupportFragmentManager();
                    bodyFragmentManager.beginTransaction().replace(R.id.body_container, bodyPartFragment).commit();
                } else {
                    bodyIndex = 0;
                    Log.d("showToastChangePic", "bodyIndex = " + bodyIndex);
                    this.bodyPartFragment = new BodyPartFragment();
                    this.bodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
                    this.bodyPartFragment.setDisplayIndex(bodyIndex);
                    bodyFragmentManager = getSupportFragmentManager();
                    bodyFragmentManager.beginTransaction().replace(R.id.body_container, bodyPartFragment).commit();
                }
                break;
            case R.id.leg_container:
                Toast.makeText(frameLayout.getContext(), "Leg is pressed", Toast.LENGTH_SHORT).show();
                if (legIndex < AndroidImageAssets.getLegs().size() - 1) {
                    legIndex++;
                    Log.d("showToastChangePic", "legIndex = " + legIndex);
                    this.legPartFragment = new BodyPartFragment();
                    this.legPartFragment.setImageIds(AndroidImageAssets.getLegs());
                    this.legPartFragment.setDisplayIndex(legIndex);
                    legFragmentManager = getSupportFragmentManager();
                    legFragmentManager.beginTransaction().replace(R.id.leg_container, legPartFragment).commit();
                } else {
                    legIndex = 0;
                    Log.d("showToastChangePic", "legIndex = " + legIndex);
                    this.legPartFragment = new BodyPartFragment();
                    this.legPartFragment.setImageIds(AndroidImageAssets.getLegs());
                    this.legPartFragment.setDisplayIndex(legIndex);
                    legFragmentManager = getSupportFragmentManager();
                    legFragmentManager.beginTransaction().replace(R.id.leg_container, legPartFragment).commit();
                }
                break;
        }
    }
}
