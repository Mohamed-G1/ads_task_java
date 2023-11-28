package com.example.adstask_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gamify.space.Gamify;
import com.gamify.space.GamifyError;
import com.rad.RXError;
import com.rad.RXSDK;
import com.rad.out.RXAdInfo;
import com.rad.out.RXSdkAd;
import com.rad.out.banner.RXBannerAd;
import com.rad.out.banner.RXBannerEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gamify.initSDK("O6Z1x4LpMl6jKSmq1GJdMhZZB999Otk3");
        initGspaceAd();

        Button loadRoulaxButton = findViewById(R.id.loadARoulaxdButton);
        loadRoulaxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadAndShowRoulaxAd();
            }
        });


        Button loadGspaceButton = findViewById(R.id.loadGspaceButton);
        loadGspaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadAndShowGspaceAd();
            }
        });


    }

    private void initGspaceAd() {
        Gamify.setListener(new Gamify.GamifyListener() {
            @Override
            public void onInitSuccess() {
                Log.d("onInitSuccess", "success");

            }

            @Override
            public void onInitFailed(GamifyError gamifyError) {
                Log.d("onInitFailed", gamifyError.getMsg());

            }

            @Override
            public void onIconReady(String s) {

            }

            @Override
            public void onIconLoadFailed(String s, GamifyError gamifyError) {

            }

            @Override
            public void onIconShowFailed(String s, GamifyError gamifyError) {

            }

            @Override
            public void onIconClick(String s) {

            }

            @Override
            public void onInteractiveOpen(String s) {

            }

            @Override
            public void onInteractiveOpenFailed(String s, GamifyError gamifyError) {

            }

            @Override
            public void onInteractiveClose(String s) {

            }

            @Override
            public void onOfferWallOpen(String s) {

            }

            @Override
            public void onOfferWallOpenFailed(String s, GamifyError gamifyError) {

            }

            @Override
            public void onOfferWallClose(String s) {

            }

            @Override
            public void onGSpaceOpen(String s) {

            }

            @Override
            public void onGSpaceOpenFailed(String s, GamifyError gamifyError) {

            }

            @Override
            public void onGSpaceClose(String s) {

            }

            @Override
            public void onUserInteraction(String s, String s1) {

            }
        });
    }

    private void loadAndShowRoulaxAd() {
        RXSDK.INSTANCE.createRXSdkAd().loadBanner(this, "495", new RXSdkAd.RXBannerAdListener() {
            @Override
            public void success(@NonNull RXAdInfo rxAdInfo, @NonNull RXBannerAd rxBannerAd) {

                rxBannerAd.setRXBannerListener(new RXBannerEventListener() {
                    @Override
                    public void onAdClick(@NonNull RXAdInfo rxAdInfo) {

                    }

                    @Override
                    public void onAdClose(@NonNull RXAdInfo rxAdInfo) {

                    }

                    @Override
                    public void onAdShow(@NonNull RXAdInfo rxAdInfo) {

                    }

                    @Override
                    public void onRenderFail(@NonNull RXAdInfo rxAdInfo, @NonNull RXError rxError) {

                    }

                    @Override
                    public void onRenderSuccess(@NonNull View view) {
                        ViewGroup linearLayout = findViewById(R.id.linearLayout);
                        linearLayout.addView(view);
                    }
                });

                rxBannerAd.render();
            }

            @Override
            public void failure(@NonNull RXAdInfo rxAdInfo, @NonNull RXError rxError) {
                Log.d("failure,,", rxError.getMsg());
                Toast.makeText(getApplicationContext(), rxError.getMsg(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadAndShowGspaceAd() {
//        Gamify.loadIcon("10882");
//        if (Gamify.isIconReady("10882")) {
//            LinearLayout mLinearLayout = findViewById(R.id.linearLayout);
//            View iconView = Gamify.showIcon("10882");
//            if (iconView != null) {
//                if (iconView.getParent() != null) {
//                    ((ViewGroup) iconView.getParent()).removeView(iconView);
//                }
//                iconView.setLayoutParams(new ViewGroup.LayoutParams(
//                        ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.MATCH_PARENT
//                ));
//                mLinearLayout.addView(iconView);
//            }
//        }

        Gamify.loadIcon("10882");
        LinearLayout mLinearLayout = findViewById(R.id.linearLayout);
        View iconView = Gamify.showIcon("10882");
        if (iconView != null) {
            if (iconView.getParent() != null) {
                ViewGroup viewGroup = (ViewGroup) iconView.getParent();
                viewGroup.removeView(iconView);
            }
            iconView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            mLinearLayout.addView(iconView);
        }

    }

}