package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


public class MealRaterActivity extends AppCompatActivity {

    private TextView textViewRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_rater);

        textViewRating = findViewById(R.id.textViewRating);
        Button buttonRateMeal = findViewById(R.id.buttonRateMeal);
        buttonRateMeal.setOnClickListener(v -> showRatingDialog());
    }

    private void showRatingDialog() {
        RatingDialogFragment ratingDialogFragment = new RatingDialogFragment();
        ratingDialogFragment.show(getSupportFragmentManager(), "ratingDialog");
    }

    public void applyRating(float rating) {
        textViewRating.setText(String.format(Locale.getDefault(), "Rating: " + rating));
    }
}


