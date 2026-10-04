package com.samsung.android.support.senl.p148nt.model.utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.AndroidInstanceConstructor;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class SpenDocumentDisplayUtils {
    private static final String TAG = ModelLogger.createTag("SpenDocumentDisplayUtils");

    public static void adjustSize(SpenWPage spenWPage, int i, int i2) {
        int width = spenWPage.getWidth();
        int i4 = (int) spenWPage.getDrawnRectOfAllObject().bottom;
        String str = TAG;
        DataLogger.m12302d(str, "adjustSize, defaultPageHeight/defaultPageNumber : " + i + "/" + i2);
        int i5 = i4 / i;
        int i6 = i4 % i;
        int i7 = i6 == 0 ? i5 + 1 : i5 + 2;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i4, i5, "adjustSize, drawnRectHeight/quotient/remainder/pageCount/width/height : ", "/", "/");
        AbstractC2821a.m2235z(sbM1173s, i6, i7, "/", "/");
        sbM1173s.append(width);
        sbM1173s.append("/");
        int i8 = i7 * i;
        sbM1173s.append(i8);
        DataLogger.m12302d(str, sbM1173s.toString());
        spenWPage.setSize(width, i8);
    }

    private static void convertBlackColorOnWhiteBackground(SpenWPage spenWPage, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        spenWPage.clearCanvasCacheData();
        spenWPage.setBackgroundColor(i);
        Iterator<SpenObjectBase> it = spenWPage.getObjectList(1).iterator();
        while (it.hasNext()) {
            ((SpenObjectStroke) it.next()).setColor(-16777216);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        DataLogger.m12302d(TAG, "convertBlackColorOnWhiteBackground " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
    }

    public static void convertColors(int i, SpenWPage spenWPage, int i2, Map<Integer, Integer> map) {
        DataLogger.m12302d(TAG, "convertColors, type : " + i);
        if (i == 1) {
            convertPenColorOnWhiteBackground(spenWPage, i2, map);
        } else {
            if (i != 2) {
                return;
            }
            convertBlackColorOnWhiteBackground(spenWPage, i2);
        }
    }

    public static void convertLastPenInfo(SpenWNote spenWNote, int i, Map<Integer, Integer> map) {
        String str = TAG;
        DataLogger.m12302d(str, "convertLastPenInfo, type " + i);
        if (i == 0) {
            return;
        }
        SpenSettingUIPenInfo lastPenInfo = spenWNote.getLastPenInfo();
        int i2 = lastPenInfo.color;
        lastPenInfo.color = i == 1 ? map.get(Integer.valueOf(i2)).intValue() : -16777216;
        spenWNote.setLastPenInfo(lastPenInfo);
        DataLogger.m12302d(str, "convertLastPenInfo, lastPenColor/convertedPenColor : " + Integer.toHexString(i2) + "/" + Integer.toHexString(lastPenInfo.color));
    }

    private static void convertPenColorOnWhiteBackground(SpenWPage spenWPage, int i, Map<Integer, Integer> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        spenWPage.clearCanvasCacheData();
        spenWPage.setBackgroundColor(i);
        Iterator<SpenObjectBase> it = spenWPage.getObjectList(1).iterator();
        while (it.hasNext()) {
            SpenObjectStroke spenObjectStroke = (SpenObjectStroke) it.next();
            int color = spenObjectStroke.getColor();
            if (map.containsKey(Integer.valueOf(color))) {
                spenObjectStroke.setColor(map.get(Integer.valueOf(color)).intValue());
            } else {
                spenObjectStroke.setColor(-16777216);
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        DataLogger.m12302d(TAG, "convertPenColorOnWhiteBackground " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        Rect mainScreenSize = DisplayUtils.getMainScreenSize();
        if (mainScreenSize.isEmpty()) {
            DisplayUtils.init(context);
            mainScreenSize = DisplayUtils.getMainScreenSize();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (!mainScreenSize.isEmpty() || windowManager == null) {
            return Math.max(mainScreenSize.width(), mainScreenSize.height());
        }
        DisplayMetrics displayMetricsMakeDisplayMetrics = AndroidInstanceConstructor.makeDisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetricsMakeDisplayMetrics);
        return Math.max(displayMetricsMakeDisplayMetrics.widthPixels, displayMetricsMakeDisplayMetrics.heightPixels);
    }

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        Rect mainScreenSize = DisplayUtils.getMainScreenSize();
        if (mainScreenSize.isEmpty()) {
            DisplayUtils.init(context);
            mainScreenSize = DisplayUtils.getMainScreenSize();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (!mainScreenSize.isEmpty() || windowManager == null) {
            return Math.min(mainScreenSize.width(), mainScreenSize.height());
        }
        DisplayMetrics displayMetricsMakeDisplayMetrics = AndroidInstanceConstructor.makeDisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetricsMakeDisplayMetrics);
        return Math.min(displayMetricsMakeDisplayMetrics.widthPixels, displayMetricsMakeDisplayMetrics.heightPixels);
    }
}
