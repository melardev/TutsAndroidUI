package com.melardev.tutorialstheming;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ActivityCropImage extends AppCompatActivity {
    private static final int MAX_HEIGHT = 300;
    private static final int MAX_WIDTH = 300;
    private static final int RC_GET_IMG = 100;
    private ImageView imgCrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_image);
        imgCrop = (ImageView) findViewById(R.id.imgCrop);

    }

    public static Uri getImageContentUri(Context context, File imageFile) {
        String filePath = imageFile.getAbsolutePath();
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID},
                MediaStore.Images.Media.DATA + "=? ",
                new String[]{filePath}, null);
        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex(MediaStore.MediaColumns._ID));
            cursor.close();
            return Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "" + id);
        } else {
            if (imageFile.exists()) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATA, filePath);
                return context.getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            } else {
                return null;
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK)
            return;

        if (requestCode == RC_GET_IMG) {
            Toast.makeText(this, data.getDataString(), Toast.LENGTH_SHORT).show();
            Uri newUri = getImageContentUri(this, new File(data.getData().getPath()));
            Toast.makeText(this, newUri.getPath(), Toast.LENGTH_SHORT).show();
        }

        if (requestCode == UCrop.REQUEST_CROP) {
            final Uri resultUri = UCrop.getOutput(data);
            Toast.makeText(this, resultUri.getPath(), Toast.LENGTH_SHORT).show();
            imgCrop.setImageDrawable(null); //otherwise the imageView does not refresh after the first try
            imgCrop.setImageURI(resultUri);
        } else if (resultCode == UCrop.RESULT_ERROR) {
            final Throwable cropError = UCrop.getError(data);
        } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                imgCrop.setImageDrawable(null); //otherwise the imageView does not refresh after the first try
                imgCrop.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void uCropDemo(View view) {
        //https://github.com/Yalantis/uCrop
        //    Intent intent = new Intent(Intent.ACTION_GET_CONTENT).setType("image/*");
        //      startActivityForResult(intent, RC_GET_IMG);

        try {
            File tempFile = new File(getCacheDir(), "tempImgOriginal.png");
            if (!tempFile.exists()) {
                InputStream is = getAssets().open("imgForCrop.JPG"); //Case sensitive!!!
                FileOutputStream fos = new FileOutputStream(tempFile);
                byte[] buffer = new byte[1024];
                int size;
                while ((size = is.read(buffer)) != -1)
                    fos.write(buffer, 0, size);
                fos.close();
            }

            File tempCropped = new File(getCacheDir(), "tempImgCropped.png");
            Uri sourceUri = Uri.fromFile(tempFile);
            Uri destinationUri = Uri.fromFile(tempCropped);
            UCrop.of(sourceUri, destinationUri)
                    //.withAspectRatio(3, 2)
                    //.withMaxResultSize(MAX_WIDTH, MAX_HEIGHT)
                    .start(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cropperDemo(View view) {
        //https://github.com/ArthurHub/Android-Image-Cropper
        InputStream is = null; //Case sensitive!!!
        try {
            is = getAssets().open("imgForCrop.JPG");

            File tempFile = new File(getCacheDir(), "tempImgOriginal.png");
            if (!tempFile.exists()) {
                FileOutputStream fos = new FileOutputStream(tempFile);
                byte[] buffer = new byte[1024];
                int size;
                while ((size = is.read(buffer)) != -1)
                    fos.write(buffer, 0, size);
                fos.close();
            }

            //File tempCropped = new File(getCacheDir(), "tempImgCropped.png");
            Uri sourceUri = Uri.fromFile(tempFile);
            CropImage.activity(sourceUri)
                    .setActivityTitle("Cropper Demo")
                    .setGuidelines(CropImageView.Guidelines.ON).start(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
            start cropping activity for pre-acquired image saved on the device
            CropImage.activity(imageUri).start(this);
        */
            /*
            for fragment (DO NOT use `getActivity()`)
            CropImage.activity().start(getContext(), this);
            */
    }

}
