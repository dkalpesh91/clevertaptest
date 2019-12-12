package com.example.clevertapintegapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.clevertap.android.sdk.CTInboxListener;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.CleverTapAPI;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity  {

    CleverTapAPI mClevertap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClevertap = CleverTapAPI.getDefaultInstance(getApplicationContext());
        if (mClevertap != null) {
            mClevertap.enableDeviceNetworkInfoReporting(false);
            //Initialize the inbox and wait for callbacks on overridden methods
            mClevertap.initializeInbox();
        }
        findViewById(R.id.trigger_event_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> prodViewedAction = new HashMap<>();
                prodViewedAction.put("Product ID", "1");
                prodViewedAction.put("Product Image", "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg");
                prodViewedAction.put("Product Name", "CleverTap");
                mClevertap.pushEvent("Product viewed", prodViewedAction);

                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
                profileUpdate.put("Email", "dk+dkalpesh91@clevertap.com");
                mClevertap.pushProfile(profileUpdate);



            }
        });

    }


}
