package com.example.homeaffairs;

import android.os.Bundle;
import android.view.Gravity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class UserMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create a vertical LinearLayout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        //add menu items to the LinearLayout
        addMenuItem(linearLayout, "Notifications");
        addMenuItem(linearLayout, "Calender");
        addMenuItem(linearLayout, "Upload Documents");
        addMenuItem(linearLayout, "Available Services");
        addMenuItem(linearLayout, "Application Status");

        // Set the content view to the user menu layout
        setContentView(linearLayout);
    }

    private void addMenuItem(LinearLayout linearLayout, String itemName) {
        // Create a horizontal LinearLayout for each menu item
        LinearLayout menuItemLayout = new LinearLayout(this);
        menuItemLayout.setOrientation(LinearLayout.HORIZONTAL);
        menuItemLayout.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
        menuItemLayout.setPadding(16, 16, 16, 16);

        //create imageview for the icom
        ImageView iconImageView = new ImageView(this);
        //iconImageView.setImageResource();
        menuItemLayout.addView(iconImageView);

        //create a text for menu item


        //set an onClickListener for each item
        menuItemLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //handle menu item click
                handleMenuItemClick(itemName);

            }
        });

        //Add the menu item layout to the main LinearLayout
        linearLayout.addView(menuItemLayout);

    }
    private void handleMenuItemClick(String itemName){

        Toast.makeText(this, "Clicked" + itemName, Toast.LENGTH_SHORT).show();
    }
}
