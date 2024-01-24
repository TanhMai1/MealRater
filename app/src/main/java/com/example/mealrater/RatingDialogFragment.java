package com.example.mealrater;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class RatingDialogFragment extends DialogFragment {

    private RatingBar ratingBar;
    private Button buttonSave;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_rate_meal, null);

        ratingBar = view.findViewById(R.id.ratingBar);
        buttonSave = view.findViewById(R.id.buttonSave);

        // Build the dialog
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(view);
        dialog.setTitle("Rate this meal");

        // Set the action for the save button
        buttonSave.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            // You can define an interface to pass the rating back to the activity
            ((MealRaterActivity) getActivity()).applyRating(rating);
            dialog.dismiss();
        });

        return dialog;
    }
}
