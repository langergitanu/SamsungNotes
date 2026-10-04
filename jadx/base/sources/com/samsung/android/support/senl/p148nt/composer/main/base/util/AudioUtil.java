package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AudioUtil {
    public static final String TAG = Logger.createTag("AudioUtil");

    public static String getAudioFileName(Context context, Uri uri) throws Throwable {
        String contentName = UriFileUtils.getContentName(context.getContentResolver(), uri);
        return TextUtils.isEmpty(contentName) ? uri.getLastPathSegment() : contentName;
    }

    public static String getAudioFilePath(String str, String str2) {
        return getAudioFilePath(str, str2, true);
    }

    public static String getFilenameWithoutExtension(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOfExtension = indexOfExtension(str);
        return iIndexOfExtension == -1 ? str : str.substring(0, iIndexOfExtension);
    }

    private static int indexOfExtension(String str) {
        if (str == null) {
            return -1;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (str.lastIndexOf(File.separator) <= iLastIndexOf) {
            return iLastIndexOf;
        }
        Logger.m11000e(TAG, "A directory separator appears after the file extension, assuming there is no file extension");
        return -1;
    }

    public static boolean isSupportedAudio(String str) {
        if (str != null && str.toLowerCase().matches(".*\\.(m4a|aac|flac|mp3|ogg|mid|amr|rtttl|imy|wav|mxmf|mka|3gp)")) {
            Logger.m10999d(TAG, "isSupportedAudio# supported: true");
            return true;
        }
        Logger.m10999d(TAG, "isSupportedAudio# filePath: " + Logger.getEncode(str));
        return false;
    }

    public static void setName(SpenVoiceData spenVoiceData, String str) {
        if (str != null && str.length() > 50) {
            str = str.substring(0, 50);
        }
        spenVoiceData.setName(str);
    }

    public static void setTitle(SpenObjectVoice spenObjectVoice, String str) {
        if (str != null && str.length() > 50) {
            str = str.substring(0, 50);
        }
        spenObjectVoice.setTitle(str);
    }

    public static String getAudioFilePath(String str, String str2, boolean z) {
        int iLastIndexOf;
        String strSubstring = (!z || (iLastIndexOf = str2.lastIndexOf(46)) <= 0) ? Constants.VOICE_EXTENSION : str2.substring(iLastIndexOf + 1);
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        sbM1324q.append(FileExtensions.getFileNameByTime("", strSubstring));
        return sbM1324q.toString();
    }
}
