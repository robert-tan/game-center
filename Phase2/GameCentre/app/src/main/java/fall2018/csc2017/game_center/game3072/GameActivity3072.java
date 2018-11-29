package fall2018.csc2017.game_center.game3072;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import fall2018.csc2017.game_center.LoginActivity;
import fall2018.csc2017.game_center.R;
import fall2018.csc2017.game_center.Score;

public class GameActivity3072 extends AppCompatActivity implements Observer {

    private static final int GAME_BG = 0xffbbada0;

    private GestureDetectGridLayout3072 gridLayout;
    private Board3072 board;
    private int score = 0;
    private TextView tvScore;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = getIntent().getStringExtra(LoginActivity.CURRENT_USER);
        setContentView(R.layout.activity_3072);

        gridLayout = findViewById(R.id.gameView);
        gridLayout.setColumnCount(Board3072.NUM_ROW_COL);
        gridLayout.setBackgroundColor(GAME_BG);
        board = new Board3072();
        addCards();
        gridLayout.setBoard(board);
        board.addObserver(this);

        tvScore = findViewById(R.id.tvScore);

        clearScore();
        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScore();
                board.startGame();
            }
        });
    }

    private void clearScore() {
        score = 0;
        showScore();
    }

    private void showScore() {
        tvScore.setText(String.valueOf(score));
    }


    private void addCards() {
        Card3072 c;
        for (int y = 0; y < Board3072.NUM_ROW_COL; y++) {
            for (int x = 0; x < Board3072.NUM_ROW_COL; x++) {
                c = new Card3072(gridLayout.getContext());
                c.setNum(0);
                gridLayout.addView(c, c.cardWidth, c.cardWidth);
                board.getBoard()[x][y] = c;
            }
        }
        board.startGame();
    }

    @Override
    public void update(Observable o, Object arg) {
        synchronized (this) {
            score = board.getScore();
            showScore();
            if (board.isFinished()) {
                Intent tmp = new Intent(this, Scoreboard3072.class);
                tmp.putExtra(Scoreboard3072.SCORE_EXTRA, new Score(username, board));
                startActivity(tmp);
                finish();
            }
        }
    }
}
