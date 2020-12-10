package com.example.android.mathematicsapp.settings.numpad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.homescreen.HomeScreenActivity;
import com.example.android.mathematicsapp.settings.SettingsActivity;
import com.example.android.mathematicsapp.single_game.SingleGameActivity;

public class NumpadActivity extends AppCompatActivity {

    private RelativeLayout _numpadActionBar;
    private LinearLayout _numpadBackground;

    private View _numpadOne;
    private View _numpadTwo;

    private RelativeLayout _numpad_above_num_one, _numpad_above_num_two, _numpad_above_num_three,
            _numpad_above_num_four, _numpad_above_num_five, _numpad_above_num_six, _numpad_above_num_seven,
            _numpad_above_num_eight, _numpad_above_num_nine, _numpad_above_num_zero,
            _numpad_above_backspace,
            _numpad_above_option;

    private RelativeLayout _numpad_below_num_one, _numpad_below_num_two, _numpad_below_num_three,
            _numpad_below_num_four, _numpad_below_num_five, _numpad_below_num_six, _numpad_below_num_seven,
            _numpad_below_num_eight, _numpad_below_num_nine, _numpad_below_num_zero,
            _numpad_below_backspace,
            _numpad_below_option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numpad);
        applyTheme();
        buttonIntents();
    }

    private void applyTheme() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));
        }

        _numpadActionBar = (RelativeLayout) findViewById(R.id.numpad_action_bar);
        _numpadBackground = (LinearLayout) findViewById(R.id.numpad_background);
        _numpadActionBar.setBackgroundColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));
        _numpadBackground.setBackgroundColor(prefs.getInt("currentBgKey", getApplicationContext().getResources().getColor(R.color.light_bg)));

        _numpadOne = findViewById(R.id.numpad_one);
        _numpadTwo = findViewById(R.id.numpad_two);

        //numpad above (aka numpad one)
        _numpad_above_num_one = (RelativeLayout) _numpadOne.findViewById(R.id.numpad_above_num_one);
        _numpad_above_num_one.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNumpadAboveNumOne = (GradientDrawable) _numpad_above_num_one.getBackground();
        drawableNumpadAboveNumOne.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _numpad_above_num_two = (RelativeLayout) _numpadOne.findViewById(R.id.numpad_above_num_two);
        _numpad_above_num_two.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNumpadAboveNumTwo = (GradientDrawable) _numpad_above_num_two.getBackground();
        drawableNumpadAboveNumTwo.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _numpad_above_num_three = (RelativeLayout) _numpadOne.findViewById(R.id.numpad_above_num_three);
        _numpad_above_num_three.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNumpadAboveNumThree = (GradientDrawable) _numpad_above_num_three.getBackground();
        drawableNumpadAboveNumThree.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _numpad_above_num_four = (RelativeLayout) _numpadOne.findViewById(R.id.numpad_above_num_four);
        _numpad_above_num_four.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNumpadAboveNumFour = (GradientDrawable) _numpad_above_num_four.getBackground();
        drawableNumpadAboveNumFour.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _numpad_above_num_five = (RelativeLayout) _numpadOne.findViewById(R.id.numpad_above_num_five);
        _numpad_above_num_five.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNumpadAboveNumFive = (GradientDrawable) _numpad_above_num_five.getBackground();
        drawableNumpadAboveNumFive.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _numpad_above_num_six = (RelativeLayout) _numpadOne.findViewById(R.id.numpad_above_num_six);
        _numpad_above_num_six.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNumpadAboveNumSix = (GradientDrawable) _numpad_above_num_six.getBackground();
        drawableNumpadAboveNumSix.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _numpad_above_num_seven = (RelativeLayout) _numpadOne.findViewById(R.id.numpad_above_num_seven);
        _numpad_above_num_seven.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNumpadAboveNumSeven = (GradientDrawable) _numpad_above_num_seven.getBackground();
        drawableNumpadAboveNumSeven.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _numpad_above_num_eight = (RelativeLayout) _numpadOne.findViewById(R.id.numpad_above_num_eight);
        _numpad_above_num_eight.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNumpadAboveNumEight = (GradientDrawable) _numpad_above_num_eight.getBackground();
        drawableNumpadAboveNumEight.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _numpad_above_num_nine = (RelativeLayout) _numpadOne.findViewById(R.id.numpad_above_num_nine);
        _numpad_above_num_nine.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNumpadAboveNumNine = (GradientDrawable) _numpad_above_num_nine.getBackground();
        drawableNumpadAboveNumNine.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _numpad_above_num_zero = (RelativeLayout) _numpadOne.findViewById(R.id.numpad_above_num_zero);
        _numpad_above_num_zero.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNumpadAboveNumZero = (GradientDrawable) _numpad_above_num_zero.getBackground();
        drawableNumpadAboveNumZero.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _numpad_above_backspace = (RelativeLayout) _numpadOne.findViewById(R.id.numpad_above_backspace);
        _numpad_above_backspace.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNumpadAboveBackspace = (GradientDrawable) _numpad_above_backspace.getBackground();
        drawableNumpadAboveBackspace.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        _numpad_above_option = (RelativeLayout) _numpadOne.findViewById(R.id.numpad_above_option);
        _numpad_above_option.setBackgroundResource(R.drawable.customborder1);
        GradientDrawable drawableNumpadAboveOption = (GradientDrawable) _numpad_above_option.getBackground();
        drawableNumpadAboveOption.setColor(prefs.getInt("currentNonBgKey", getApplicationContext().getResources().getColor(R.color.neon_blue)));

        //numpad below (aka numpad two)
    }

    private void buttonIntents() {
        findViewById(R.id.numpad_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NumpadActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}
