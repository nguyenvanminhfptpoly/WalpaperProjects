package com.mgosu.walpaperprojects.view.detail;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mgosu.walpaperprojects.R;
import com.mgosu.walpaperprojects.model.wallpaper.ListItem;
import com.mgosu.walpaperprojects.view.home.MainActivity;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class DetailActivity extends AppCompatActivity {

    private ImageView mImgDetail;
    private Button mBtnSetWall;
    private ImageView mImageView3;
    private TextView mTvLove;
    private ImageView mImageView4;
    private TextView mTvDown;
    private WallpaperManager wallpaperManager;
    private Bitmap bitmap1, bitmap2 ;
    private DisplayMetrics displayMetrics ;
    private int width, height;
    private BitmapDrawable bitmapDrawable ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Khaibao();
        GetInfomation();
        SetWallpaper();
    }
    private void Khaibao(){
        mImgDetail = findViewById(R.id.img_detail);
        mBtnSetWall = findViewById(R.id.btnSetWall);
        mImageView3 = findViewById(R.id.imageView3);
        mTvLove = findViewById(R.id.tvLove);
        mImageView4 = findViewById(R.id.imageView4);
        mTvDown = findViewById(R.id.tvDown);
    }
    private void GetInfomation(){
        ListItem listItem =(ListItem) getIntent().getSerializableExtra("imageinfo");
        Picasso.with(getApplicationContext()).load("http://192.168.200.216/dev/media/calltools/wallpaper/"+listItem.getThumbLarge())
                .error(R.drawable.imgerror)
                .into(mImgDetail);
        mTvDown.setText(listItem.getDownload()+"");
        mTvLove.setText(listItem.getLoveCount()+"");
    }

    private void SetWallpaper(){
        wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        bitmapDrawable = (BitmapDrawable) mImgDetail.getDrawable();
        bitmap1 = bitmapDrawable.getBitmap();

        mBtnSetWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetScreenWidthHeight();

                SetBitmapSize();

                wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

                try {

                    wallpaperManager.setBitmap(bitmap2);

                    wallpaperManager.suggestDesiredDimensions(width, height);
                    Toast.makeText(DetailActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void GetScreenWidthHeight(){

        displayMetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        width = displayMetrics.widthPixels;

        height = displayMetrics.heightPixels;

    }

    public void SetBitmapSize(){

        bitmap2 = Bitmap.createScaledBitmap(bitmap1, width, height, false);

    }
}
