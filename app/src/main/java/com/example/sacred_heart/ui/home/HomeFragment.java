package com.example.sacred_heart.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.example.sacred_heart.R;
import com.example.sacred_heart.databinding.FragmentHomeBinding;
import java.util.ArrayList;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button applyButton = root.findViewById(R.id.applyButton);

        // Create image list
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.main_banner, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.aboutusbanner, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.b3, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.b4, ScaleTypes.CENTER_CROP));
        //imageList.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that.",ScaleTypes.CENTER_CROP));

        binding.imageSlider.setImageList(imageList);



        // Set the click listener for the button
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL to open in browser
                String url = "https://docs.google.com/forms/d/e/1FAIpQLSePsTL34yCSGUsHWiLqy4kqi-mjI38ijvhPTC7WCd2D-AyQIQ/viewform?embedded=true"; // Replace with your desired URL

                // Create an implicit intent
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                // Start the activity using the intent

                    startActivity(intent);

            }
        });

        // Access marqueeTextView and enable marquee
        binding.marqueeText.setSelected(true);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
