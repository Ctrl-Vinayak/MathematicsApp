package com.example.android.mathematicsapp.settings.theme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.mathematicsapp.R;
import com.example.android.mathematicsapp.settings.SettingsActivity;

public class ThemeActivity extends AppCompatActivity {

    // Activity Background.
    private LinearLayout _themeBg;

    // Action Bar.
    private RelativeLayout _actionBarBg;

    // Checkboxes
    private CheckBox _checkBoxLightBg;
    private CheckBox _checkBoxDarkBg;
    private CheckBox _checkBoxOceanBlueBg;
    private CheckBox _checkBoxLightPinkBg;

    // 5 color options for text and non-background colors.
    private LinearLayout _neonBlueBox;
    private LinearLayout _neonGreenBox;
    private LinearLayout _neonYellowBox;
    private LinearLayout _neonOrangeBox;
    private LinearLayout _neonRedBox;

    // Reset Style Text View, it is actually meant to be a button...
    private TextView _resetStyle;

    // CheckMarks for one of the 5 color options.
    private View _checkMarkNeonBlue;
    private View _checkMarkNeonGreen;
    private View _checkMarkNeonYellow;
    private View _checkMarkNeonOrange;
    private View _checkMarkNeonRed;

    // 4 theme background colors + current background color.
    private int _lightBg;
    private int _darkBg;
    private int _oceanBlueBg;
    private int _lightPinkBg;
    private int _currentBg;

    // 5 neon non background colors + current color of this.
    private int _neonBlue;
    private int _neonGreen;
    private int _neonYellow;
    private int _neonOrange;
    private int _neonRed;
    private int _currentNonBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        _checkBoxLightBg = (CheckBox) findViewById(R.id.checkbox_light_bg);
        _checkBoxDarkBg = (CheckBox) findViewById(R.id.checkbox_dark_bg);
        _checkBoxOceanBlueBg = (CheckBox) findViewById(R.id.checkbox_ocean_blue_bg);
        _checkBoxLightPinkBg = (CheckBox) findViewById(R.id.checkbox_light_pink_bg);

        _neonBlueBox = (LinearLayout) findViewById(R.id.neon_blue_box);
        _neonGreenBox = (LinearLayout) findViewById(R.id.neon_green_box);
        _neonYellowBox = (LinearLayout) findViewById(R.id.neon_yellow_box);
        _neonOrangeBox = (LinearLayout) findViewById(R.id.neon_orange_box);
        _neonRedBox = (LinearLayout) findViewById(R.id.neon_red_box);

        _checkMarkNeonBlue = findViewById(R.id.checkmark_neon_blue);
        _checkMarkNeonGreen = findViewById(R.id.checkmark_neon_green);
        _checkMarkNeonYellow = findViewById(R.id.checkmark_neon_yellow);
        _checkMarkNeonOrange = findViewById(R.id.checkmark_neon_orange);
        _checkMarkNeonRed = findViewById(R.id.checkmark_neon_red);

        _lightBg = getApplicationContext().getResources().getColor(R.color.light_bg);
        _darkBg = getApplicationContext().getResources().getColor(R.color.dark_bg);
        _oceanBlueBg = getApplicationContext().getResources().getColor(R.color.ocean_blue_bg);
        _lightPinkBg = getApplicationContext().getResources().getColor(R.color.light_pink_bg);

        _neonBlue = getApplicationContext().getResources().getColor(R.color.neon_blue);
        _neonGreen = getApplicationContext().getResources().getColor(R.color.neon_green);
        _neonYellow = getApplicationContext().getResources().getColor(R.color.neon_yellow);
        _neonOrange = getApplicationContext().getResources().getColor(R.color.neon_orange);
        _neonRed = getApplicationContext().getResources().getColor(R.color.neon_red);

        _themeBg = (LinearLayout) findViewById(R.id.theme_bg);
        _actionBarBg = (RelativeLayout) findViewById(R.id.theme_action_bar);
        _resetStyle = (TextView) findViewById(R.id.reset_style_btn);

        backBtn();
        checkBoxFunction();
        checkMarkFunction();
        resetStyleFunction();
        loadData();
        setCheckedAlready();
        changeThemeActivity();
    }

    private void backBtn() {
        findViewById(R.id.theme_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemeActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void saveData() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("currentBgKey", _currentBg);
        editor.putInt("currentNonBgKey", _currentNonBg);
        editor.apply();
    }

    public void loadData() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SharedPrefKey", Context.MODE_PRIVATE);
        _currentBg = prefs.getInt("currentBgKey", _lightBg);
        _currentNonBg = prefs.getInt("currentNonBgKey", _neonBlue);
    }

    private void setCheckedAlready() {
        // background
        if (_currentBg == _lightBg) {
            _checkBoxLightBg.setChecked(true);
        } else if (_currentBg == _darkBg) {
            _checkBoxDarkBg.setChecked(true);
        } else if (_currentBg == _oceanBlueBg) {
            _checkBoxOceanBlueBg.setChecked(true);
        } else if (_currentBg == _lightPinkBg) {
            _checkBoxLightPinkBg.setChecked(true);
        }

        // non background
        if (_currentNonBg == _neonBlue) {
            _checkMarkNeonBlue.setVisibility(View.VISIBLE);
        } else if (_currentNonBg == _neonGreen) {
            _checkMarkNeonGreen.setVisibility(View.VISIBLE);
        } else if (_currentNonBg == _neonYellow) {
            _checkMarkNeonYellow.setVisibility(View.VISIBLE);
        } else if (_currentNonBg == _neonOrange) {
            _checkMarkNeonOrange.setVisibility(View.VISIBLE);
        } else if (_currentNonBg == _neonRed) {
            _checkMarkNeonRed.setVisibility(View.VISIBLE);
        }
    }

    private void checkBoxFunction() {
        _checkBoxLightBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _checkBoxLightBg.setChecked(true);
                _checkBoxDarkBg.setChecked(false);
                _checkBoxOceanBlueBg.setChecked(false);
                _checkBoxLightPinkBg.setChecked(false);
                _currentBg = _lightBg;
                saveData();
                changeThemeActivity();
            }
        });

        _checkBoxDarkBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _checkBoxDarkBg.setChecked(true);
                _checkBoxLightBg.setChecked(false);
                _checkBoxOceanBlueBg.setChecked(false);
                _checkBoxLightPinkBg.setChecked(false);
                _currentBg = _darkBg;
                saveData();
                changeThemeActivity();
            }
        });

        _checkBoxOceanBlueBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _checkBoxOceanBlueBg.setChecked(true);
                _checkBoxLightBg.setChecked(false);
                _checkBoxDarkBg.setChecked(false);
                _checkBoxLightPinkBg.setChecked(false);
                _currentBg = _oceanBlueBg;
                saveData();
                changeThemeActivity();
            }
        });

        _checkBoxLightPinkBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _checkBoxLightPinkBg.setChecked(true);
                _checkBoxLightBg.setChecked(false);
                _checkBoxDarkBg.setChecked(false);
                _checkBoxOceanBlueBg.setChecked(false);
                _currentBg = _lightPinkBg;
                saveData();
                changeThemeActivity();
            }
        });
    }

    private void checkMarkFunction() {
        _checkMarkNeonBlue.setVisibility(View.GONE);
        _checkMarkNeonGreen.setVisibility(View.GONE);
        _checkMarkNeonYellow.setVisibility(View.GONE);
        _checkMarkNeonOrange.setVisibility(View.GONE);
        _checkMarkNeonRed.setVisibility(View.GONE);

        _neonBlueBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _checkMarkNeonBlue.setVisibility(View.VISIBLE);
                _checkMarkNeonGreen.setVisibility(View.GONE);
                _checkMarkNeonYellow.setVisibility(View.GONE);
                _checkMarkNeonOrange.setVisibility(View.GONE);
                _checkMarkNeonRed.setVisibility(View.GONE);
                _currentNonBg = _neonBlue;
                saveData();
                changeThemeActivity();
            }
        });

        _neonGreenBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _checkMarkNeonBlue.setVisibility(View.GONE);
                _checkMarkNeonGreen.setVisibility(View.VISIBLE);
                _checkMarkNeonYellow.setVisibility(View.GONE);
                _checkMarkNeonOrange.setVisibility(View.GONE);
                _checkMarkNeonRed.setVisibility(View.GONE);
                _currentNonBg = _neonGreen;
                saveData();
                changeThemeActivity();
            }
        });

        _neonYellowBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _checkMarkNeonBlue.setVisibility(View.GONE);
                _checkMarkNeonGreen.setVisibility(View.GONE);
                _checkMarkNeonYellow.setVisibility(View.VISIBLE);
                _checkMarkNeonOrange.setVisibility(View.GONE);
                _checkMarkNeonRed.setVisibility(View.GONE);
                _currentNonBg = _neonYellow;
                saveData();
                changeThemeActivity();
            }
        });

        _neonOrangeBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _checkMarkNeonBlue.setVisibility(View.GONE);
                _checkMarkNeonGreen.setVisibility(View.GONE);
                _checkMarkNeonYellow.setVisibility(View.GONE);
                _checkMarkNeonOrange.setVisibility(View.VISIBLE);
                _checkMarkNeonRed.setVisibility(View.GONE);
                _currentNonBg = _neonOrange;
                saveData();
                changeThemeActivity();
            }
        });

        _neonRedBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _checkMarkNeonBlue.setVisibility(View.GONE);
                _checkMarkNeonGreen.setVisibility(View.GONE);
                _checkMarkNeonYellow.setVisibility(View.GONE);
                _checkMarkNeonOrange.setVisibility(View.GONE);
                _checkMarkNeonRed.setVisibility(View.VISIBLE);
                _currentNonBg = _neonRed;
                saveData();
                changeThemeActivity();
            }
        });
    }

    private void resetStyleFunction() {
        _resetStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _currentBg = _lightBg;
                _currentNonBg = _neonBlue;
                changeThemeActivity();

                _checkBoxLightBg.setChecked(true);
                _checkBoxDarkBg.setChecked(false);
                _checkBoxOceanBlueBg.setChecked(false);
                _checkBoxLightPinkBg.setChecked(false);

                _checkMarkNeonBlue.setVisibility(View.VISIBLE);
                _checkMarkNeonGreen.setVisibility(View.GONE);
                _checkMarkNeonYellow.setVisibility(View.GONE);
                _checkMarkNeonOrange.setVisibility(View.GONE);
                _checkMarkNeonRed.setVisibility(View.GONE);

                saveData();
            }
        });
    }

    /** apply theme settings for theme activity. */
    private void changeThemeActivity() {
        _themeBg.setBackgroundColor(_currentBg);
        _actionBarBg.setBackgroundColor(_currentNonBg);
    }
}
