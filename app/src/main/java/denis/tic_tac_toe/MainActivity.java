package denis.tic_tac_toe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    int clicksCount = 0;
    int crossesCountWins = 0;
    int noughtsCountWins = 0;
    TextView score;
    Switch noughtsCrosses;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = findViewById(R.id.score);

        noughtsCrosses = findViewById(R.id.noughts_crosses);
        noughtsCrosses.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                beginWithCrossesOrNoughts();
            }
        });

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
            view.setBackgroundResource(android.R.drawable.ic_delete); // 17301533
            view.setContentDescription("cross");
        }
        else {
            view.setBackgroundResource(android.R.drawable.btn_radio);
            view.setContentDescription("nought");
        }
        clicksCount++;
        view.setEnabled(false);

        if (clicksCount > 0) {
            noughtsCrosses.setEnabled(false);
        }
    }


    public void onButton1Click(View view) {
        setSign(view);
        checkWin();
    }

    public void onButton2Click(View view) {
        setSign(view);
        checkWin();
    }

    public void onButton3Click(View view) {
        setSign(view);
        checkWin();
    }

    public void onButton4Click(View view) {
        setSign(view);
        checkWin();
    }

    public void onButton5Click(View view) {
        setSign(view);
        checkWin();
    }

    public void onButton6Click(View view) {
        setSign(view);
        checkWin();
    }

    public void onButton7Click(View view) {
        setSign(view);
        checkWin();
    }

    public void onButton8Click(View view) {
        setSign(view);
        checkWin();
    }

    public void onButton9Click(View view) {
        setSign(view);
        checkWin();
    }

    // Нажатие на кнопку "Начать заново"
    public void onResetButtonClick(View view) {
        reset();
    }

    // Сброс игры ("Начать заново")
    private void reset() {
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

        button1.setContentDescription("");
        button2.setContentDescription("");
        button3.setContentDescription("");
        button4.setContentDescription("");
        button5.setContentDescription("");
        button6.setContentDescription("");
        button7.setContentDescription("");
        button8.setContentDescription("");
        button9.setContentDescription("");

        beginWithCrossesOrNoughts();

        noughtsCrosses.setEnabled(true);
    }


    // Начать игру с крестиков, если количесво кликов по кнопкам чётное,
    // начать игру с ноликов, если количесво кликов по кнопкам нечётное
    private void beginWithCrossesOrNoughts() {
        // TODO Баг: ползунок на ноликах, но первым ставится крестик
        // После сброса игры, свитч не реагирует на переключение
        if (noughtsCrosses.isChecked()) {
            clicksCount = 1;
            //Toast.makeText(this, Integer.toString(clicksCount), Toast.LENGTH_SHORT).show();
        }
        else {
            clicksCount = 0;
            //Toast.makeText(this, Integer.toString(clicksCount), Toast.LENGTH_SHORT).show();
        }
    }

    // Проверяем выигрышную ситуацию. Выводим диалоговое окно.
    // сброс игры. Начисление очков.
    private void checkWin() {

        boolean b1_cr = button1.getContentDescription().equals("cross");
        boolean b2_cr = button2.getContentDescription().equals("cross");
        boolean b3_cr = button3.getContentDescription().equals("cross");
        boolean b4_cr = button4.getContentDescription().equals("cross");
        boolean b5_cr = button5.getContentDescription().equals("cross");
        boolean b6_cr = button6.getContentDescription().equals("cross");
        boolean b7_cr = button7.getContentDescription().equals("cross");
        boolean b8_cr = button8.getContentDescription().equals("cross");
        boolean b9_cr = button9.getContentDescription().equals("cross");

        boolean b1_nt = button1.getContentDescription().equals("nought");
        boolean b2_nt = button2.getContentDescription().equals("nought");
        boolean b3_nt = button3.getContentDescription().equals("nought");
        boolean b4_nt = button4.getContentDescription().equals("nought");
        boolean b5_nt = button5.getContentDescription().equals("nought");
        boolean b6_nt = button6.getContentDescription().equals("nought");
        boolean b7_nt = button7.getContentDescription().equals("nought");
        boolean b8_nt = button8.getContentDescription().equals("nought");
        boolean b9_nt = button9.getContentDescription().equals("nought");

        boolean b1 = button1.getContentDescription().equals("");
        boolean b2 = button2.getContentDescription().equals("");
        boolean b3 = button3.getContentDescription().equals("");
        boolean b4 = button4.getContentDescription().equals("");
        boolean b5 = button5.getContentDescription().equals("");
        boolean b6 = button6.getContentDescription().equals("");
        boolean b7 = button7.getContentDescription().equals("");
        boolean b8 = button8.getContentDescription().equals("");
        boolean b9 = button9.getContentDescription().equals("");

        // Проверяем выигрышную ситуацию для крестиков
        if ( b1_cr && b2_cr && b3_cr || b4_cr && b5_cr && b6_cr || b7_cr && b8_cr && b9_cr ||
             b1_cr && b4_cr && b7_cr || b2_cr && b5_cr && b8_cr || b3_cr && b6_cr && b9_cr ||
             b1_cr && b5_cr && b9_cr || b3_cr && b5_cr && b7_cr) {
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.crosses_win);  // заголовок
                builder.setPositiveButton(R.string.resume, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        reset();
                    }
                });
                /*builder.setNegativeButton(R.string.finish, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });*/
                builder.show();

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);

                // TODO localization
                score.setText(Html.fromHtml(getResources().getString(R.string.crosses) +
                        " <b>" + ++crossesCountWins + "\t :\t" +
                        noughtsCountWins + "</b> " + getResources().getString(R.string.noughts)));
        }

        // Проверяем выигрышную ситуацию для ноликов
        else if ( b1_nt && b2_nt && b3_nt || b4_nt && b5_nt && b6_nt || b7_nt && b8_nt && b9_nt ||
                  b1_nt && b4_nt && b7_nt || b2_nt && b5_nt && b8_nt || b3_nt && b6_nt && b9_nt ||
                  b1_nt && b5_nt && b9_nt || b3_nt && b5_nt && b7_nt) {
                    builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(R.string.noughts_win);  // заголовок
                    builder.setPositiveButton(R.string.resume, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            reset();
                        }
                    });
                    /*builder.setNegativeButton(R.string.finish, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });*/
                    builder.show();

                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);

                    // TODO localization
                    score.setText(Html.fromHtml(getResources().getString(R.string.crosses)
                            + " <b>" + crossesCountWins + "\t :\t " +
                            ++noughtsCountWins + "</b> " + getResources().getString(R.string.noughts)));
        }

        // ничья
        else if ( !b1 && !b2 && !b3 && !b4 && !b5 && !b6 && !b7 && !b8 && !b9 ) {
            builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.draw);  // заголовок
            builder.setPositiveButton(R.string.resume, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    reset();
                }
            });
            builder.show();
        }

    }


    // Работа с меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, R.string.clear_score);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            // TODO localization
            score.setText(R.string.score);
            noughtsCountWins = 0;
            crossesCountWins = 0;
        }
        return super.onOptionsItemSelected(item);
    }
}
