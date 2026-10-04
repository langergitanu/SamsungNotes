package com.samsung.android.spr.drawable.document.debug;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.spr.drawable.document.SprDocument;
import com.samsung.android.spr.drawable.document.shape.SprObjectBase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprDebug {
    public static final int DEBUG_HIGH = 3;
    public static final int DEBUG_LOW = 1;
    public static final int DEBUG_MID = 2;
    public static boolean IsDebug;
    private static Integer mDebugLevel;
    private static Paint mTextOutlinePaint;
    private static Paint mTextPaint;

    static {
        if ("eng".equals(Build.TYPE)) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                mDebugLevel = (Integer) cls.getMethod("getInt", String.class, Integer.TYPE).invoke(cls, "persist.sys.spr.debug", 0);
            } catch (Exception e) {
                e.printStackTrace();
                mDebugLevel = 0;
            }
        } else {
            mDebugLevel = 0;
        }
        IsDebug = mDebugLevel.intValue() >= 1;
    }

    public static void drawDebugInfo(Canvas canvas, SprDocument sprDocument, int i, int i2, int i4) {
        if (mDebugLevel.intValue() >= 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(sprDocument.isNinePatch() ? "N" : sprDocument.isIntrinsic() ? "" : FeedbackDetailConstants.PREFIX_CLIENT_ERROR);
            sb.append(String.valueOf(sprDocument.hashCode() % 10000));
            drawText(canvas, sb.toString(), 20);
            drawText(canvas, sprDocument.mName, 40);
            drawText(canvas, i4 + ")" + i + "x" + i2, 60);
            if (mDebugLevel.intValue() >= 3) {
                drawText(canvas, sprDocument.getLoadingTime() + "ms E:" + sprDocument.getTotalElementCount() + " S:" + sprDocument.getTotalSegmentCount() + " A:" + sprDocument.getTotalAttributeCount(), 80);
            }
        }
    }

    public static void drawRect(Canvas canvas, SprDocument sprDocument, int i, int i2) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65536);
        float f = sprDocument.mLeft;
        float f4 = sprDocument.mTop;
        canvas.drawRect(f, f4, f + i, f4 + i2, paint);
    }

    private static void drawText(Canvas canvas, String str, int i) {
        if (mTextOutlinePaint == null) {
            Paint paint = new Paint();
            mTextOutlinePaint = paint;
            paint.setAntiAlias(true);
            mTextOutlinePaint.setTextSize(20.0f);
            mTextOutlinePaint.setStyle(Paint.Style.STROKE);
            mTextOutlinePaint.setColor(-16777216);
            mTextOutlinePaint.setStrokeWidth(4.0f);
        }
        if (mTextPaint == null) {
            Paint paint2 = new Paint();
            mTextPaint = paint2;
            paint2.setAntiAlias(true);
            mTextPaint.setTextSize(20.0f);
            mTextPaint.setStyle(Paint.Style.FILL);
            mTextPaint.setColor(-1);
        }
        float f = i;
        canvas.drawText(str, 5.0f, f, mTextOutlinePaint);
        canvas.drawText(str, 5.0f, f, mTextPaint);
    }

    public static void preDraw(SprObjectBase sprObjectBase) {
        Paint paint;
        if (mDebugLevel.intValue() < 3 || (paint = sprObjectBase.strokePaint) == null) {
            return;
        }
        sprObjectBase.isVisibleStroke = true;
        paint.setColor(Color.rgb(255, 0, 255));
        if (sprObjectBase.strokePaint.getStrokeWidth() < 2.0f) {
            sprObjectBase.strokePaint.setStrokeWidth(2.0f);
        }
    }

    public void dumpPNG(SprDocument sprDocument, int i, int i2, int i4) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        sprDocument.draw(new Canvas(bitmapCreateBitmap), i, i2, 0, i4);
        try {
            File file = new File("/sdcard/spr_debug");
            if (!file.mkdir() && !file.isDirectory()) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, String.valueOf(sprDocument.hashCode() % 10000) + ".png"));
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
