package br.usjt.pi.androidnotificationchannel;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;

public class NotificationHelper extends ContextWrapper {

    private static final String MEU_CHAANEL_ID = "br.usjt.pi.androidnotificationchannel.MEUCANAL";
    private static final String MEU_CHANNEL_NAME = "MEUCANAL Channel";
    private NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);
        createChannels();
    }

    private void createChannels() {
        NotificationChannel myChannel = new NotificationChannel(MEU_CHAANEL_ID,MEU_CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH);
        myChannel.enableLights(true);
        myChannel.enableVibration(true);
        myChannel.setLightColor(Color.GREEN);
        myChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

        getManager().createNotificationChannel(myChannel);
    }

    public NotificationManager getManager() {
        if(manager == null){
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return manager;
    }

    public Notification.Builder getMyChannelNotification(String title, String body){
        return new Notification.Builder(getApplicationContext(), MEU_CHAANEL_ID)
                .setContentText(body)
                .setContentTitle(title)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true);

    }
}
