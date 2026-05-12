package com.example.glyphdraw;

import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.nothing.ketchum.Glyph;
import com.nothing.ketchum.GlyphException;
import com.nothing.ketchum.GlyphMatrixManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int MATRIX_SIZE = 13;
    private GlyphMatrixManager mGM;
    private int[] mLedStates = new int[MATRIX_SIZE * MATRIX_SIZE];
    private View[] mViews = new View[MATRIX_SIZE * MATRIX_SIZE];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initGrid();
        initGlyph();

        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(v -> clearGrid());
    }

    private void initGrid() {
        GridLayout grid = findViewById(R.id.glyphGrid);
        int cellSize = getResources().getDisplayMetrics().widthPixels / (MATRIX_SIZE + 2);

        for (int i = 0; i < MATRIX_SIZE * MATRIX_SIZE; i++) {
            final int index = i;
            View cell = new View(this);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = cellSize;
            params.height = cellSize;
            params.setMargins(2, 2, 2, 2);
            cell.setLayoutParams(params);
            cell.setBackgroundColor(getResources().getColor(R.color.glyph_led_off));

            cell.setOnClickListener(v -> {
                toggleLed(index);
            });

            grid.addView(cell);
            mViews[i] = cell;
            mLedStates[i] = 0;
        }
    }

    private void toggleLed(int index) {
        if (mLedStates[index] == 0) {
            mLedStates[index] = 0xFFFFFFFF; // White / Full brightness
            mViews[index].setBackgroundColor(getResources().getColor(R.color.glyph_led_on));
        } else {
            mLedStates[index] = 0;
            mViews[index].setBackgroundColor(getResources().getColor(R.color.glyph_led_off));
        }
        updateGlyph();
    }

    private void clearGrid() {
        for (int i = 0; i < MATRIX_SIZE * MATRIX_SIZE; i++) {
            mLedStates[i] = 0;
            mViews[i].setBackgroundColor(getResources().getColor(R.color.glyph_led_off));
        }
        updateGlyph();
    }

    private void initGlyph() {
        mGM = GlyphMatrixManager.getInstance(getApplicationContext());
        mGM.init(new GlyphMatrixManager.Callback() {
            @Override
            public void onServiceConnected(ComponentName componentName) {
                Log.d(TAG, "onServiceConnected");
                try {
                    mGM.register(Glyph.DEVICE_25111p);
                } catch (Exception e) {
                    Log.e(TAG, "Error registering device", e);
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.d(TAG, "onServiceDisconnected");
            }
        });
    }

    private void updateGlyph() {
        if (mGM != null) {
            try {
                mGM.setAppMatrixFrame(mLedStates);
            } catch (GlyphException e) {
                Log.e(TAG, "Error updating Glyph Matrix", e);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mGM != null) {
            try {
                mGM.closeAppMatrix();
            } catch (GlyphException e) {
                Log.e(TAG, "Error closing app matrix", e);
            }
            mGM.unInit();
        }
    }
}
