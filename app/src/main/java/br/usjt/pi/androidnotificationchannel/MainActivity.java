package br.usjt.pi.androidnotificationchannel;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    NotificationHelper helper;
    Button btnSend;
    EditText edTitle, edContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new NotificationHelper(this);

        edTitle = findViewById(R.id.edTitle);
        edContent = findViewById(R.id.edContent);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edTitle.getText().toString();
                String content = edContent.getText().toString();
//                  String title = "Titulo da minha Notificação";
//                  String content = "Conteúdo fixo da minha notificação";

                Notification.Builder builder = helper.getMyChannelNotification(title, content);
                helper.getManager().notify(new Random().nextInt(), builder.build());
            }
        });
    }
}
