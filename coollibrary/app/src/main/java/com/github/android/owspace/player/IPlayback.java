package com.github.android.owspace.player;

/**
 * 媒体后台播放的接口
 */

public interface IPlayback {

    boolean play();

    boolean play(String song);

    boolean pause();

    boolean isPlaying();

    int getProgress();

    int getDuration();

    boolean seekTo(int progress);

    void registerCallback(Callback callback);

    void unregisterCallback(Callback callback);

    void removeCallbacks();

    void releasePlayer();

    interface Callback {

        void onComplete(PlayState state);

        void onPlayStatusChanged(PlayState status);

        void onPosition(int position);
    }
}
