package com.example.sacred_heart.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.sacred_heart.R;
import com.example.sacred_heart.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private GridLayout gridLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        gridLayout = binding.gridLayout;

        // List of drawable resource IDs
        int[] imageResIds = {
                R.drawable.im1,
                R.drawable.im2,
                R.drawable.im3,
                R.drawable.im4,
                R.drawable.im5,
                R.drawable.im6,
                R.drawable.im7,
                R.drawable.im8,
                R.drawable.im9,
                R.drawable.im10,
                R.drawable.im11,
                R.drawable.im12,
        };

        // Loop through and add images to GridLayout
        for (int imageResId : imageResIds) {
            addImageToGrid(imageResId);
        }

        return root;
    }

    private void addImageToGrid(int imageResId) {
        // Create a new ImageView for each image
        ImageView imageView = new ImageView(getContext());

        // Set GridLayout parameters
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.width = 0;  // Set the width to 0 for flexible grid layout
        layoutParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
        layoutParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);  // Equal width for each item
        layoutParams.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);  // Equal height for each item
        layoutParams.setMargins(8, 8, 8, 8);  // Set margins for spacing between items

        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);  // Scale the image to fill the view

        // Set the image using the resource ID
        imageView.setImageResource(imageResId);

        // Add the image to the grid layout
        gridLayout.addView(imageView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;  // Clean up binding to avoid memory leaks
    }
}
