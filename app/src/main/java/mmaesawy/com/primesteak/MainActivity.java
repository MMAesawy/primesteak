package mmaesawy.com.primesteak;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    private Button[] mNumberButtons = new Button[10];
    private SeekBar mProbPicker;
    private TextView mPrimeLabel;
    private TextView mNumberLabel;
    private TextView mProbLabel;
    private Button mClearButton;
    private Button mDeleteButton;
    private Button mCheckButton;
    private CheckBox mCheckOnEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberLabel = (TextView) findViewById(R.id.number_label);
        mPrimeLabel = (TextView) findViewById(R.id.is_prime_label);
        mProbLabel = (TextView) findViewById(R.id.prob_label);

        mProbPicker = (SeekBar) findViewById(R.id.prob_picker);

        mNumberButtons[0] = (Button) findViewById(R.id.zero_button);
        mNumberButtons[1] = (Button) findViewById(R.id.one_button);
        mNumberButtons[2] = (Button) findViewById(R.id.two_button);
        mNumberButtons[3] = (Button) findViewById(R.id.three_button);
        mNumberButtons[4] = (Button) findViewById(R.id.four_button);
        mNumberButtons[5] = (Button) findViewById(R.id.five_button);
        mNumberButtons[6] = (Button) findViewById(R.id.six_button);
        mNumberButtons[7] = (Button) findViewById(R.id.seven_button);
        mNumberButtons[8] = (Button) findViewById(R.id.eight_button);
        mNumberButtons[9] = (Button) findViewById(R.id.nine_button);

        mClearButton = (Button) findViewById(R.id.clear_button);
        mDeleteButton = (Button) findViewById(R.id.delete_button);
        mCheckButton = (Button) findViewById(R.id.check_button);
        mCheckOnEntry = (CheckBox) findViewById(R.id.check_entry_toggle);

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberLabel.getEditableText().clear();
                mPrimeLabel.getEditableText().clear();
            }
        });
        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable text = mNumberLabel.getEditableText();
                if (text.length() == 0) return;
                text.delete(text.length() - 1, text.length());
                if (text.length() == 0) mPrimeLabel.getEditableText().clear();
                else checkPrime();
            }
        });


        mNumberButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberLabel.getEditableText().append('0');
                if (mCheckOnEntry.isChecked()) checkPrime();
            }
        });
        mNumberButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberLabel.getEditableText().append('1');
                if (mCheckOnEntry.isChecked()) checkPrime();
            }
        });
        mNumberButtons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberLabel.getEditableText().append('2');
                if (mCheckOnEntry.isChecked()) checkPrime();
            }
        });
        mNumberButtons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberLabel.getEditableText().append('3');
                if (mCheckOnEntry.isChecked()) checkPrime();
            }
        });
        mNumberButtons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberLabel.getEditableText().append('4');
                if (mCheckOnEntry.isChecked()) checkPrime();
            }
        });
        mNumberButtons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberLabel.getEditableText().append('5');
                if (mCheckOnEntry.isChecked()) checkPrime();
            }
        });
        mNumberButtons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberLabel.getEditableText().append('6');
                if (mCheckOnEntry.isChecked()) checkPrime();
            }
        });
        mNumberButtons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberLabel.getEditableText().append('7');
                if (mCheckOnEntry.isChecked()) checkPrime();
            }
        });
        mNumberButtons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberLabel.getEditableText().append('8');
                if (mCheckOnEntry.isChecked()) checkPrime();
            }
        });
        mNumberButtons[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberLabel.getEditableText().append('9');
                if (mCheckOnEntry.isChecked()) checkPrime();
            }
        });

        mProbPicker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mProbLabel.setText("Prime Probability: " + (i/100.0));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mProbLabel.setText("Prime Probability: " + (mProbPicker.getProgress()/100.0));

        mCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPrime();
            }
        });




    }

    public void checkPrime(){
        String number = mNumberLabel.getText().toString();
        if (number.length() == 0) return;
        boolean isPrime = PrimeChecker.isPrime(new BigInteger(number), mProbPicker.getProgress()/100.0);
        mPrimeLabel.setText(isPrime ? "Prime" : "Not Prime");
        mPrimeLabel.setTextColor(isPrime ? ColorStateList.valueOf(Color.GREEN) : ColorStateList.valueOf(Color.RED));
    }
}
