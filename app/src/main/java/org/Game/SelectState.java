package org.Game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.gameframework.AppManager;
import com.example.gameframework.IState;
import com.example.gameframework.R;
import com.example.gameframework.SoundManager;

public class SelectState implements IState {
    int width = AppManager.getInstance().getDeviceSize().x;
    int height = AppManager.getInstance().getDeviceSize().y;
    private Bitmap player1, player2, player3, gamestart;
    private BackGround back;
    int flag;//비행기 선택 변수

    private static SelectState select = new SelectState();
    public SelectState(){

    }

    public static SelectState getInstance(){
        return select;
    }


    @Override
    public void Init() {
        flag = 3;

        back = new BackGround(1);
        player1 = AppManager.getInstance().getBitmap(R.drawable.air1);
        player1 = Bitmap.createScaledBitmap(player1,300, 300, true);//비행기 1의 비트맵을 받아와 사이즈까지 조절 함
        player2 = AppManager.getInstance().getBitmap(R.drawable.air2);
        player2 = Bitmap.createScaledBitmap(player2,300, 300, true);
        player3 = AppManager.getInstance().getBitmap(R.drawable.air3);
        player3 = Bitmap.createScaledBitmap(player3,300, 300, true);
        gamestart = AppManager.getInstance().getBitmap(R.drawable.gamestart);
//        back = new BackGround(1);
//        player1 = AppManager.getInstance().getBitmap(R.drawable.air1);
//        player1 = Bitmap.createScaledBitmap(player1, (int) (width*0.286), (int) (height*0.17), true);//비행기 1의 비트맵을 받아와 사이즈까지 조절 함
//        player2 = AppManager.getInstance().getBitmap(R.drawable.air2);
//        player2 = Bitmap.createScaledBitmap(player2,(int) (width*0.286), (int) (height*0.17), true);
//        player3 = AppManager.getInstance().getBitmap(R.drawable.air3);
//        player3 = Bitmap.createScaledBitmap(player3,(int) (width*0.286), (int) (height*0.17), true);
//        gamestart = AppManager.getInstance().getBitmap(R.drawable.gamestart);
    }

    @Override
    public void Destroy() {
        AppManager.getInstance().m_gameState = GameState.getInstance();
    }

    @Override
    public void Update() {
        long GameTime = System.currentTimeMillis();
        back.Update(GameTime);
    }

    @Override
    public void Render(Canvas canvas) {
        back.Draw(canvas);

        Paint p=new Paint();//화면 상단에 캐릭터 선택하라는 문구를 띄움
        p.setTextSize((float) (width*0.0762));
        p.setColor(Color.GREEN);
        canvas.drawText("비행기를 선택하세요!", (float) (width*0.19), (float) (height*0.11), p);

        canvas.drawBitmap(player1, (float) (width*0.124), (float) (height*0.286), null);
        canvas.drawBitmap(player2, (float) (width*0.6), (float) (height*0.286), null);
        canvas.drawBitmap(player3, (float) (width*0.35), (float) (height*0.514), null);
        canvas.drawBitmap(gamestart, (float) (width*0.286), (float) (height*0.743), null);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {//비행기 선택,
        int x = (int)event.getX(0);
        int y = (int)event.getY(0);
//        Log.d("", "" + x +"," + y);
        if (x > width*0.15 && x < width*0.44
                && y > height*0.27 && y < height*0.46)//비행기 1의 좌표를 선택했을 시 선택 이미지를 불러옴
        {//비행기 1 선택 시
            SoundManager.getInstance().play(4);
            player1 = Bitmap.createScaledBitmap(AppManager.getInstance().getBitmap(R.drawable.air1s),300, player1.getHeight(), true);
            flag = 0;

            player2 = Bitmap.createScaledBitmap(AppManager.getInstance().getBitmap(R.drawable.air2),300, player2.getHeight(), true);
            player3 = Bitmap.createScaledBitmap(AppManager.getInstance().getBitmap(R.drawable.air3),300, player3.getHeight(), true);
        }

        else if (x > width*0.6 && x < width*0.89
                && y > height*0.29 && y < height*0.46)//비행기 2 선택 시 위의 if문과 처리는 같음
        {//비행기 2 선택 시
            SoundManager.getInstance().play(4);
            player2 = Bitmap.createScaledBitmap(AppManager.getInstance().getBitmap(R.drawable.air2s),300, player2.getHeight(), true);
            flag = 1;

            player1 = Bitmap.createScaledBitmap(AppManager.getInstance().getBitmap(R.drawable.air1),300, player1.getHeight(), true);
            player3 = Bitmap.createScaledBitmap(AppManager.getInstance().getBitmap(R.drawable.air3),300, player3.getHeight(), true);
        }
        else if(x > width*0.35 && x < width*0.64
                && y > height*0.51 && y < height*0.69){
            SoundManager.getInstance().play(4);
            player3 = Bitmap.createScaledBitmap(AppManager.getInstance().getBitmap(R.drawable.air3s),300, player3.getHeight(), true);
            flag = 2;

            player2 = Bitmap.createScaledBitmap(AppManager.getInstance().getBitmap(R.drawable.air2),300, player2.getHeight(), true);
            player1 = Bitmap.createScaledBitmap(AppManager.getInstance().getBitmap(R.drawable.air1),300, player1.getHeight(), true);
        }

        //게임시작을 눌렀을 경우
        if(flag != 3 && x > width*0.29 && x < width*0.71
                && y > height*0.74 && y < height*0.83){
            SoundManager.getInstance().play(4);
            GameState.getInstance().playertype = flag;
            AppManager.getInstance().getGameView().changeGameState(GameState.getInstance());
        }
        return true;
    }
}
