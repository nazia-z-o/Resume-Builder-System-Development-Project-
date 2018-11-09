package com.example.asus.navjava;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
//    private ImageView image;
//    private Button btnCamera,btnGallery;
    private final int REQUEST_IMAGE_CAPTURE =1, REQUEST_IMAGE_GALLERY = 2;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    selectedFragment = new AcademicFragment();
                    break;
                case R.id.navigation_contacts:
                    selectedFragment = new ContFragment();
                    break;
                case R.id.navigation_notifications:
                    selectedFragment = new ExpFragment();
                    break;
                case R.id.navigation_Ref:
                    selectedFragment = new RefFragment();
                    break;
                case R.id.navigation_photo:
                    selectedFragment = new PhotoFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        image= (ImageView) findViewById(R.id.image);
//        btnCamera = (Button) findViewById(R.id.btnCamera);
//        btnCamera.setOnClickListener(this);
//        btnGallery = (Button) findViewById(R.id.btnGallery);
//        btnGallery.setOnClickListener(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
    }

//    @Override
//    public void onClick ( View view )
//    {
//        switch (view.getId())
//        {
//            case R.id.btnCamera:
//                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                if(iCamera.resolveActivity(getPackageManager()) != null )
//                {
//                    startActivityForResult(iCamera, REQUEST_IMAGE_CAPTURE);
//                }
//                break;
//            case R.id.btnGallery:
//                Intent iGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                iGallery.setType("image/^");
//                startActivityForResult(iGallery, REQUEST_IMAGE_GALLERY);
//                break;
//        }
//    }


}
