package com.samsung.android.support.senl.p148nt.data.common.utils;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.data.common.constructor.AndroidClassConstructor;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class VoiceTimeDataUtils {
    private static final String TAG = DataLogger.createTag("VoiceTimeDataUtils");

    public static String convertPlayTime(String str) {
        int i;
        int i2;
        int i4 = 0;
        if (!TextUtils.isEmpty(str) && str.contains(":")) {
            String[] strArrSplit = str.split(":");
            if (strArrSplit.length < 3) {
                i = Integer.parseInt(strArrSplit[0]);
                i2 = Integer.parseInt(strArrSplit[1]);
            } else {
                i4 = Integer.parseInt(strArrSplit[0]);
                i = Integer.parseInt(strArrSplit[1]);
                i2 = Integer.parseInt(strArrSplit[2]);
            }
            i4 = ((i * 60) + (i4 * 3600) + i2) * 1000;
        }
        return String.valueOf(i4);
    }

    public static String createTimeString(int i, boolean z) {
        int i2 = i / 3600;
        int i4 = (i % 3600) / 60;
        int i5 = i % 60;
        return (z || i2 > 0) ? i2 > 9 ? String.format(Locale.getDefault(), "%02d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.getDefault(), "%d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static int getPlayTime(String str) {
        if (str == null) {
            return -1;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                int i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                AbstractC8014b.m7203e(mediaMetadataRetriever);
                return i;
            } finally {
            }
        } catch (Exception e) {
            DataLogger.m12303e(TAG, "getPlayTime() - e : " + e.getMessage());
            MediaPlayer mediaPlayerCreateMediaPlayer = AndroidClassConstructor.createMediaPlayer();
            try {
                mediaPlayerCreateMediaPlayer.reset();
                mediaPlayerCreateMediaPlayer.setDataSource(str);
                mediaPlayerCreateMediaPlayer.prepare();
                int duration = mediaPlayerCreateMediaPlayer.getDuration();
                mediaPlayerCreateMediaPlayer.reset();
                return duration;
            } catch (IOException unused) {
                return -1;
            } finally {
                mediaPlayerCreateMediaPlayer.release();
            }
        }
    }

    public static String createTimeString(String str) {
        return createTimeString(getPlayTime(str) / 1000, false);
    }
}
