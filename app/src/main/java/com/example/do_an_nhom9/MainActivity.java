package com.example.do_an_nhom9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import android.util.Pair;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, sologan;

    private Socket socket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        image = findViewById(R.id.imageview);
        logo = findViewById(R.id.textView);
        sologan = findViewById(R.id.textView2);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        sologan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(logo, "logo_text");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent, options.toBundle());


            }
        }, SPLASH_SCREEN);

        this.bindingEventListener();
    }

    private void bindingEventListener() {

        try{
            IO.Options opts = new IO.Options();
            opts.forceNew=true;
            opts.reconnection =true;
            socket = IO.socket("http://192.168.1.121:8888/port",opts);
        }catch (URISyntaxException e){
            e.printStackTrace();
        }

        socket.on(Socket.EVENT_CONNECT,this.onConnectEvent);
        socket.on(Socket.EVENT_DISCONNECT,this.onDisconnectEvent);

        socket.connect();
    }
    private Emitter.Listener onConnectEvent = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.d("SOCKET","connected to server!");
        }
    };

    private  Emitter.Listener onDisconnectEvent = (args) -> {
      Log.d("SOCKET","disconnect");
    };
}