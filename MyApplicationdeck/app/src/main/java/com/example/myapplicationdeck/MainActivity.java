package com.example.myapplicationdeck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


   // ImageView one , tow , three ,four ,five ,six,seven,eight,nine,ten,result;
   
    Button roll = binding.ivBackButton;
    
    ImageView result = binding.ivBackButton;
    ImageView[] images = {roll, roll, roll, roll, roll, roll, roll, roll, roll, };
    ImageView userSelection = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        for(ImageView image : images){
            image.setOnClickListener(view -> {
                userSelection = (ImageView) view;
            });
        }

        roll.setOnClickListener(view -> {
            try {
                ImageView selection = images[new Random().nextInt(images.length - 1)];

                if(selection != null) {
                    result.setImageDrawable(selection.getDrawable());

                    if(userSelection != null){
                        if (userSelection.getId() == selection.getId()){
                            Toast.makeText(this, "You Won!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(this, "You Lost!", Toast.LENGTH_LONG).show();
                        }
                    }
                }

            } catch (Exception exception){
                exception.printStackTrace();
            }
        });
    }
}
