package denis.tic_tac_toe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends Activity {

    int clicksCount = 0;
    Switch noughtsCrosses;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noughtsCrosses = findViewById(R.id.noughts_crosses);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
    }

    private void setSign(View view) {
        if (clicksCount % 2 == 0) {
            view.setBackgroundResource(android.R.drawable.ic_delete);
        }
        else {
            view.setBackgroundResource(android.R.drawable.btn_radio);
        }
        clicksCount++;
        view.setEnabled(false);

        if (clicksCount > 0) {
            noughtsCrosses.setEnabled(false);
        }
    }

    public void onButton1Click(View view) {
        setSign(view);
    }

    public void onButton2Click(View view) {
        setSign(view);
    }

    public void onButton3Click(View view) {
        setSign(view);
    }

    public void onButton4Click(View view) {
        setSign(view);
    }

    public void onButton5Click(View view) {
        setSign(view);
    }

    public void onButton6Click(View view) {
        setSign(view);
    }

    public void onButton7Click(View view) {
        setSign(view);
    }

    public void onButton8Click(View view) {
        setSign(view);
    }

    public void onButton9Click(View view) {
        setSign(view);
    }

    public void onResetButtonClick(View view) {
        button1.setBackgroundResource(R.drawable.pressed_button);
        button2.setBackgroundResource(R.drawable.pressed_button);
        button3.setBackgroundResource(R.drawable.pressed_button);
        button4.setBackgroundResource(R.drawable.pressed_button);
        button5.setBackgroundResource(R.drawable.pressed_button);
        button6.setBackgroundResource(R.drawable.pressed_button);
        button7.setBackgroundResource(R.drawable.pressed_button);
        button8.setBackgroundResource(R.drawable.pressed_button);
        button9.setBackgroundResource(R.drawable.pressed_button);

        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);

        noughtsCrosses.setEnabled(true);
        clicksCount = 0;
    }
}
