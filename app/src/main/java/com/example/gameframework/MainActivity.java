//package com.example.gameframework;
//
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.toolbox.Volley;
//
//import org.Game.RankRequest;
//import org.json.JSONObject;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Random;
//
//public class MainActivity extends AppCompatActivity {
//    private EditText et_playerID;
//    private Button btn_record;
//    private String playerID;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date time = new Date();
//        String recordDate = timeFormat.format(time);
//
//        Response.Listener<String> responseListener = new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonResponse = new JSONObject(response);
//                    boolean success = jsonResponse.getBoolean("success");
//
//                    if (success) {
//                        System.out.println("랭킹 등록 성공!");
//                        Toast.makeText(getApplicationContext(), "랭킹 등록 성공!", Toast.LENGTH_SHORT).show();
//                        finish();
//                    } else {
//                        System.out.println("랭킹 등록에 실패했습니다.");
//                        Toast.makeText(getApplicationContext(), "랭킹 등록에 실패했습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                } catch (Exception e) {
//                    System.out.println("오류");
//                    e.printStackTrace();
//                }
//            }
//        };
//        playerID = "kyh123";
//        Random random = new Random(); //임시 score 0~9999 랜덤값
//        RankRequest rankRequest = new RankRequest(playerID, "TYPE2",
//                random.nextInt(9999) + 1 + "", recordDate,
//                responseListener);
//
//        RequestQueue queue = Volley.newRequestQueue(MainActivity.this); //실제 서버에 저장하는 부분(게임뷰 실행과 동시에하면 저장은 되지만 게임뷰는 실행안됨)
//        queue.add(rankRequest);
//
//
//        //requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        //setContentView(new GameView(this));
//    }
//}
package com.example.gameframework;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static Activity mainact;
    public static Context mcontext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainact = MainActivity.this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mcontext = getApplicationContext();
        setContentView(new GameView(this,1)); //게임뷰 실행
    }
}