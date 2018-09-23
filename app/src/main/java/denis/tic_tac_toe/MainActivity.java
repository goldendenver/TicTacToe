package denis.tic_tac_toe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends Activity {

    int clicksCount = 0;
    int crossesCountWins = 0;
    int noughtsCountWins = 0;
    TextView score;
    Switch noughtsCrosses;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // устанавливаем заголовок приложения в соотв-ии с текущей локалью
        setTitle(R.string.app_name);

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
            noughtsCrosses.setThumbResource(android.R.color.darker_gray);
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

        button1.clearAnimation();
        button2.clearAnimation();
        button3.clearAnimation();
        button4.clearAnimation();
        button5.clearAnimation();
        button6.clearAnimation();
        button7.clearAnimation();
        button8.clearAnimation();
        button9.clearAnimation();

        beginWithCrossesOrNoughts();

        noughtsCrosses.setEnabled(true);
        noughtsCrosses.setThumbResource(android.R.color.holo_blue_bright);
    }


    // Начать игру с крестиков, если количесво кликов по кнопкам чётное,
    // начать игру с ноликов, если количесво кликов по кнопкам нечётное
    private void beginWithCrossesOrNoughts() {
        if (noughtsCrosses.isChecked()) {
            clicksCount = 1;
        }
        else {
            clicksCount = 0;
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
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.crosses_win);  // заголовок
                builder.setPositiveButton(R.string.resume, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        reset();
                    }
                });
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

                score.setText(Html.fromHtml(getResources().getString(R.string.crosses) +
                        " <b>" + ++crossesCountWins + "\t :\t " +
                        noughtsCountWins + "</b> " + getResources().getString(R.string.noughts)));
        }

        // Проверяем выигрышную ситуацию для ноликов
        else if ( b1_nt && b2_nt && b3_nt || b4_nt && b5_nt && b6_nt || b7_nt && b8_nt && b9_nt ||
                  b1_nt && b4_nt && b7_nt || b2_nt && b5_nt && b8_nt || b3_nt && b6_nt && b9_nt ||
                  b1_nt && b5_nt && b9_nt || b3_nt && b5_nt && b7_nt) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(R.string.noughts_win);  // заголовок
                    builder.setPositiveButton(R.string.resume, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            reset();
                        }
                    });
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

                    score.setText(Html.fromHtml(getResources().getString(R.string.crosses)
                            + " <b>" + crossesCountWins + "\t :\t " +
                            ++noughtsCountWins + "</b> " + getResources().getString(R.string.noughts)));
        }

        // ничья
        else if ( !b1 && !b2 && !b3 && !b4 && !b5 && !b6 && !b7 && !b8 && !b9 ) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.draw);  // заголовок
            builder.setPositiveButton(R.string.resume, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    reset();
                }
            });
            builder.show();
        }

        // Анимация выигрышной комбинации (для кнопок)
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotation);;

        if (b1_cr && b2_cr && b3_cr || b1_nt && b2_nt && b3_nt) {
            button1.startAnimation(animation);
            button2.startAnimation(animation);
            button3.startAnimation(animation);
        }
        else if (b4_cr && b5_cr && b6_cr || b4_nt && b5_nt && b6_nt) {
            button4.startAnimation(animation);
            button5.startAnimation(animation);
            button6.startAnimation(animation);
        }
        else if (b7_cr && b8_cr && b9_cr || b7_nt && b8_nt && b9_nt) {
            button7.startAnimation(animation);
            button8.startAnimation(animation);
            button9.startAnimation(animation);
        }
        else if (b1_cr && b4_cr && b7_cr || b1_nt && b4_nt && b7_nt) {
            button1.startAnimation(animation);
            button4.startAnimation(animation);
            button7.startAnimation(animation);
        }
        else if (b2_cr && b5_cr && b8_cr || b2_nt && b5_nt && b8_nt) {
            button2.startAnimation(animation);
            button5.startAnimation(animation);
            button8.startAnimation(animation);
        }
        else if (b3_cr && b6_cr && b9_cr || b3_nt && b6_nt && b9_nt) {
            button3.startAnimation(animation);
            button6.startAnimation(animation);
            button9.startAnimation(animation);
        }
        else if (b1_cr && b5_cr && b9_cr || b1_nt && b5_nt && b9_nt) {
            button1.startAnimation(animation);
            button5.startAnimation(animation);
            button9.startAnimation(animation);
        }
        else if (b3_cr && b5_cr && b7_cr || b3_nt && b5_nt && b7_nt) {
            button3.startAnimation(animation);
            button5.startAnimation(animation);
            button7.startAnimation(animation);
        }

    }


    // Работа с меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, R.string.clear_score);
        menu.add(0, 1, 0, R.string.choose_language);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                score.setText(R.string.score);
                noughtsCountWins = 0;
                crossesCountWins = 0;
                break;

            case 1:
                final String[] chooseLanguage = { "Русский", "English" };
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.change_language);


                // считываем текущую локаль
                Locale current = getResources().getConfiguration().locale;

                // устанавливаем переключатель в соотв-ии с текущей локалью
                int checkedItem = 0;
                if (String.valueOf(current).equals("ru")) {
                    checkedItem = 0;
                }
                else if(String.valueOf(current).equals("en")) {
                    checkedItem = 1;
                }

                // добавляем переключатели
                builder.setSingleChoiceItems(chooseLanguage, checkedItem, null);

                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {

                        //http://qaru.site/questions/5618887/alertdialog-builder-setsinglechoiceitems-from-enum
                        ListView lw = ((AlertDialog) dialog).getListView();
                        int checkedItemId = lw.getCheckedItemPosition();

                        // русский
                        if (checkedItemId == 0 && !(String.valueOf(getResources().getConfiguration().locale).equals("ru"))) {
                            Locale locale = new Locale("ru");
                            Locale.setDefault(locale);
                            Configuration configuration = new Configuration();
                            configuration.locale = locale;
                            getBaseContext().getResources().updateConfiguration(configuration, null);

                            recreate();
                            // заголовок элемента switch не меняется почему-то после смены локали,
                            // поэтому меняем его программно
                            noughtsCrosses.setText(R.string.start_with);
                        }

                        // английский
                        else if (checkedItemId == 1 && !(String.valueOf(getResources().getConfiguration().locale).equals("en"))) {
                            Locale locale = new Locale("en");
                            Locale.setDefault(locale);
                            Configuration configuration = new Configuration();
                            configuration.locale = locale;
                            getBaseContext().getResources().updateConfiguration(configuration, null);

                            recreate();
                            // заголовок элемента switch не меняется почему-то после смены локали,
                            // поэтому меняем его программно
                            noughtsCrosses.setText(R.string.start_with);

                        }
                    }
                });
                builder.setNegativeButton(R.string.cancel, null);
                builder.show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
