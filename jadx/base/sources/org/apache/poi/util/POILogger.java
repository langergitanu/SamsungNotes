package org.apache.poi.util;

import androidx.exifinterface.media.ExifInterface;
import com.microsoft.identity.client.internal.MsalUtils;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import opennlp.tools.tokenize.TokenizerME;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public abstract class POILogger {
    public static final int DEBUG = 1;
    public static final int ERROR = 7;
    public static final int FATAL = 9;
    public static final int INFO = 3;
    public static final int WARN = 5;
    protected static final String[] LEVEL_STRINGS_SHORT = {MsalUtils.QUERY_STRING_SYMBOL, DiagMonUtil.AGREE_TYPE_DIAGNOSTIC, MsalUtils.QUERY_STRING_SYMBOL, "I", MsalUtils.QUERY_STRING_SYMBOL, "W", MsalUtils.QUERY_STRING_SYMBOL, ExifInterface.LONGITUDE_EAST, MsalUtils.QUERY_STRING_SYMBOL, TokenizerME.NO_SPLIT, MsalUtils.QUERY_STRING_SYMBOL};
    protected static final String[] LEVEL_STRINGS = {"?0?", "DEBUG", "?2?", "INFO", "?4?", "WARN", "?6?", "ERROR", "?8?", "FATAL", "?10+?"};

    public abstract void _log(int i, Object obj);

    public abstract void _log(int i, Object obj, Throwable th);

    public abstract boolean check(int i);

    public abstract void initialize(String str);

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void log(int i, Object... objArr) {
        if (check(i)) {
            StringBuilder sb = new StringBuilder(32);
            Throwable th = null;
            for (int i2 = 0; i2 < objArr.length; i2++) {
                if (i2 == objArr.length - 1) {
                    Object obj = objArr[i2];
                    if (obj instanceof Throwable) {
                        th = (Throwable) obj;
                    } else {
                        sb.append(objArr[i2]);
                    }
                }
            }
            String strReplaceAll = sb.toString().replaceAll("[\r\n]+", " ");
            if (th == null) {
                _log(i, strReplaceAll);
            } else {
                _log(i, strReplaceAll, th);
            }
        }
    }
}
