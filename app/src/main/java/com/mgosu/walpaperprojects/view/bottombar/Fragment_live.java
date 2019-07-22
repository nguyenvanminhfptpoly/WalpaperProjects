package com.mgosu.walpaperprojects.view.bottombar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mgosu.walpaperprojects.R;
import com.mgosu.walpaperprojects.adapter.Adapter_Image;
import com.mgosu.walpaperprojects.model.wallpaper.ListItem;
import com.mgosu.walpaperprojects.model.wallpaper.Wallpaper;
import com.mgosu.walpaperprojects.ultil.APIUltil;
import com.mgosu.walpaperprojects.ultil.OnItemListener;
import com.mgosu.walpaperprojects.view.detail.DetailActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_live extends Fragment {


    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView mRycFaglive;
    
    private Adapter_Image adapter_image;

    public Fragment_live() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v2 = inflater.inflate(R.layout.fragment_fragment_live, container, false);
        mRycFaglive = v2.findViewById(R.id.ryc_faglive);

        mRycFaglive.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getActivity(),2);
        mRycFaglive.setLayoutManager(layoutManager);


        APIUltil.getData().getWallpaper("list_item", "3d", "1", "20").enqueue(new Callback<Wallpaper>() {
            @Override
            public void onResponse(Call<Wallpaper> call, Response<Wallpaper> response) {
                final List<ListItem> listItems = response.body().getData().getListItems();


                adapter_image = new Adapter_Image(listItems, getActivity(), new OnItemListener() {
                    @Override
                    public void OnItemlistener(int position) {
                        Intent intent = new Intent(getActivity(), DetailActivity.class);
                        intent.putExtra("imageinfo", listItems.get(position));
                        startActivity(intent);
                    }
                });
                mRycFaglive.setAdapter(adapter_image);
                Log.d("abc",response.body().getData().getListItems().toString());
                // khoi tao adapter roi bo vao hien thi thoi e

            }

            @Override
            public void onFailure(Call<Wallpaper> call, Throwable t) {
                Log.e("FF", t.getMessage());

            }
        });
        return v2;
    }



}
