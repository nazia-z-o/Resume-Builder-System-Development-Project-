package com.example.asus.navjava;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class PhotoFragment extends Fragment implements View.OnClickListener  {

     private ImageView image;
     private Button btnCamera,btnGallery;
     private final int REQUEST_IMAGE_CAPTURE =1, REQUEST_IMAGE_GALLERY = 2;
    @Nullable

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentphoto, container, false);
        image= (ImageView) v.findViewById(R.id.image);
        btnCamera = (Button) v.findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(this);
        btnGallery = (Button) v.findViewById(R.id.btnGallery);
        btnGallery.setOnClickListener(this);
        return v;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK )
        {
            if(requestCode == REQUEST_IMAGE_CAPTURE)
            {
                Bitmap bitmap= (Bitmap) data.getExtras().get("data");
                image.setImageBitmap(bitmap);
            } else if(requestCode == REQUEST_IMAGE_GALLERY)
            {
                Uri uri =data.getData();
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);
                    image.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCamera:
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(iCamera.resolveActivity(getContext().getPackageManager()) != null )
                {
                    startActivityForResult(iCamera, REQUEST_IMAGE_CAPTURE);
                }
                break;
            case R.id.btnGallery:
                Intent iGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                iGallery.setType("image/^");
                startActivityForResult(iGallery, REQUEST_IMAGE_GALLERY);
                break;
        }
    }
}

 /*   @Override
    public void onClick ( View view )
    {
        switch (view.getId())
        {
            case R.id.btnCamera:
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(iCamera.resolveActivity(getPackageManager()) != null )
                {
                    startActivityForResult(iCamera, REQUEST_IMAGE_CAPTURE);
                }
                break;
            case R.id.btnGallery:
                Intent iGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                iGallery.setType("image/^");
                startActivityForResult(iGallery, REQUEST_IMAGE_GALLERY);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK )
        {
            if(requestCode == REQUEST_IMAGE_CAPTURE)
            {
                Bitmap bitmap= (Bitmap) data.getExtras().get("data");
                image.setImageBitmap(bitmap);
            } else if(requestCode == REQUEST_IMAGE_GALLERY)
            {
                Uri uri =data.getData();
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    image.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}







/*public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image= (ImageView) findViewById(R.id.image);
        btnCamera = (Button) findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(this);
        btnGallery = (Button) findViewById(R.id.btnGallery);
        btnGallery.setOnClickListener(this);
    }



}*/

