//package com.nb.myijklibrary.services;
//
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.os.IBinder;
//
//import tv.danmaku.ijk.media.player.IMediaPlayer;
//
///**
// * 媒体播放服务
// * <p/>
// *
// */
//public class MediaPlayerService extends Service {
//
//    private static IMediaPlayer sMediaPlayer;
//
//    public static Intent newIntent(Context context) {
//        Intent intent = new Intent(context, MediaPlayerService.class);
//        return intent;
//    }
//
//    public static void intentToStart(Context context) {
//        context.startService(newIntent(context));
//    }
//
//    public static void intentToStop(Context context) {
//        context.stopService(newIntent(context));
//    }
//
//    /**
//     * 设置播放器来源,无论是否在播放中
//     *
//     * @param mp
//     */
//    public static void setMediaPlayer(IMediaPlayer mp) {
//        if (sMediaPlayer != null && sMediaPlayer != mp) {
//            if (sMediaPlayer.isPlaying())
//                sMediaPlayer.stop();
//            sMediaPlayer.release();
//            sMediaPlayer = null;
//        }
//        sMediaPlayer = mp;
//    }
//
//    public static IMediaPlayer getMediaPlayer() {
//        return sMediaPlayer;
//    }
//
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//}
