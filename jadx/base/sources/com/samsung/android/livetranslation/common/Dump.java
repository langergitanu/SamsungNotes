package com.samsung.android.livetranslation.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Environment;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.livetranslation.text.SceneText;
import com.samsung.android.livetranslation.util.LTTLogger;
import com.samsung.android.livetranslation.util.Util;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Dump {
    public static boolean DUMP_ENABLE = true;
    private static boolean IS_ANNOTATION_ENABLED = false;
    public static boolean IS_INIT_DUMP_SUCCESS = false;
    public static boolean IS_MASK_DUMP_ENABLE = false;
    public static boolean IS_OCR_DUMP_ENABLE = false;
    public static boolean IS_OCR_JSON_DUMP_ENABLED = false;
    public static boolean IS_PADDED_POLY_ENABLED = false;
    public static boolean IS_RENDERED_FRAME_ENABLED = false;
    public static boolean IS_TRANSLATED_DUMP_ENABLED = false;
    private static boolean LEVEL_CHAR = false;
    private static boolean LEVEL_LINE = false;
    private static boolean LEVEL_PARAGRAPH = false;
    private static boolean LEVEL_WORD = false;
    private static int LINE_WIDTH = 0;
    private static final String PREF_NAME = "LttEngineSharedPreference";
    public static String RENDERING_TYPE = "H";
    private static final String TAG = "Dump";
    private static int TEXT_SIZE;
    private static boolean isScaledImage;
    private static Bitmap originalImage;
    private static Bitmap scaledImage;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Key {
        PARAGRAPH,
        LINE,
        WORD,
        CHAR,
        OCR,
        MASK,
        PADDED,
        ANNOTATION,
        RENDERED_FRAME,
        DUMP_OCR_JSON,
        DUMP_TRANSLATION_STRING,
        RENDERING_TYPE,
        LINE_WIDTH,
        TEXT_SIZE
    }

    private static void annotatePolys(Point[] pointArr, Canvas canvas, Paint paint, float f, Paint paint2, Paint paint3) {
        Point point;
        Point point2;
        int i = 1;
        for (int i2 = 0; i2 < pointArr.length; i2++) {
            if (i2 == pointArr.length - 1) {
                point = new Point(pointArr[i2]);
                point2 = new Point(pointArr[0]);
            } else {
                point = new Point(pointArr[i2]);
                point2 = new Point(pointArr[i2 + 1]);
            }
            canvas.drawLine(point.x, point.y, point2.x, point2.y, paint);
            canvas.drawText(AbstractC2322a.m1615e(i, ""), point.x, point.y, paint3);
            i++;
        }
    }

    public static void createFolder(String str) {
        String str2 = TAG;
        LTTLogger.m5581d(str2, "make directory : " + str);
        File file = new File(str);
        if (file.isDirectory() || file.mkdirs()) {
            return;
        }
        LTTLogger.m5581d(str2, "make directory!!, fail");
    }

    public static void drawOCR(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList, boolean z, String str) {
        LTTLogger.m5581d(TAG, "Padding enabled : " + z);
        Bitmap bitmap = originalImage;
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmapCopy = bitmap.copy(config, true);
        if ((str.equals("upscaled") || str.contains("padded")) && isScaledImage) {
            bitmapCopy = scaledImage.copy(config, true);
        }
        Canvas canvas = new Canvas(bitmapCopy);
        float f = TEXT_SIZE;
        float f4 = LINE_WIDTH;
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        paint2.setColor(-16776961);
        paint2.setStrokeWidth(f4);
        Paint paint3 = new Paint();
        paint.setTextSize(f);
        paint.setColor(VUtilString.GREEN);
        paint3.setColor(-65536);
        for (SceneText sceneText : copyOnWriteArrayList) {
            paint2.setColor(-16776961);
            Paint paint4 = paint2;
            float f5 = 15.0f;
            if (LEVEL_PARAGRAPH) {
                drawRect(z ? sceneText.getPaddedBoxPoly() : sceneText.getPoly(), paint4, canvas, 15.0f, paint, paint3);
            }
            for (SceneText sceneText2 : sceneText.getComponents()) {
                paint4.setColor(VUtilString.GREEN);
                if (LEVEL_LINE) {
                    drawRect(sceneText2.getPoly(), paint4, canvas, f5, paint, paint3);
                }
                for (SceneText sceneText3 : sceneText2.getComponents()) {
                    paint4.setColor(-65536);
                    if (LEVEL_WORD) {
                        drawRect(sceneText3.getPoly(), paint4, canvas, f5, paint, paint3);
                    }
                    for (SceneText sceneText4 : sceneText3.getComponents()) {
                        paint4.setColor(-256);
                        if (LEVEL_CHAR) {
                            f5 = 15.0f;
                            drawRect(sceneText4.getPoly(), paint4, canvas, 15.0f, paint, paint3);
                        } else {
                            f5 = 15.0f;
                        }
                    }
                }
            }
            paint2 = paint4;
        }
        StringBuilder sbM12325j = AbstractC11014a.m12325j("ocr_dump_", str);
        sbM12325j.append(Util.getTimeInMilliSecond());
        sbM12325j.append(".png");
        dumpBitmap(bitmapCopy, sbM12325j.toString(), "OCR");
    }

    private static void drawRect(Point[] pointArr, Paint paint, Canvas canvas, float f, Paint paint2, Paint paint3) {
        Point point;
        Point point2;
        if (pointArr == null) {
            return;
        }
        for (int i = 0; i < pointArr.length; i++) {
            if (i == pointArr.length - 1) {
                point = new Point(pointArr[i]);
                point2 = new Point(pointArr[0]);
            } else {
                point = new Point(pointArr[i]);
                point2 = new Point(pointArr[i + 1]);
            }
            canvas.drawLine(point.x, point.y, point2.x, point2.y, paint);
            if (IS_ANNOTATION_ENABLED) {
                annotatePolys(pointArr, canvas, paint, f, paint2, paint3);
            }
        }
    }

    public static void dumpBitmap(Bitmap bitmap, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        String str3 = TAG;
        LTTLogger.m5581d(str3, "Dump bitmap");
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(getStoragePath(str2) + str);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            LTTLogger.m5581d(str3, "dump success: " + getStoragePath(str2) + str);
            fileOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            LTTLogger.m5582e(TAG, e.getMessage());
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void dumpStringToFile(String str, String str2, String str3) {
        String str4 = TAG;
        LTTLogger.m5581d(str4, "dumpStringToFile");
        try {
            File file = new File(getStoragePath(str3) + str2);
            LTTLogger.m5581d(str4, "dump path: " + getStoragePath(str3) + str2);
            if (!file.exists() && !file.createNewFile()) {
                throw new IOException("Failed to create file: " + file.getAbsolutePath());
            }
            FileWriter fileWriter = new FileWriter(file);
            try {
                fileWriter.write(str);
                fileWriter.close();
            } finally {
            }
        } catch (Exception e) {
            LTTLogger.m5582e(TAG, e.getMessage());
        }
    }

    public static void dumpYUV(byte[] bArr, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    File file = new File(getStoragePath("YUV"), str);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            LTTLogger.m5582e(TAG, e.getMessage());
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(PREF_NAME, 0);
    }

    public static String getStoragePath(String str) {
        String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath() + "/Dump/" + str + "/";
        createFolder(str2);
        return str2;
    }

    public static void initDump(Context context, Bitmap bitmap) {
        SharedPreferences sharedPreference = getSharedPreference(context);
        Key key = Key.OCR;
        if (!sharedPreference.contains(key.toString()) || !DUMP_ENABLE) {
            IS_INIT_DUMP_SUCCESS = false;
            LTTLogger.m5581d(TAG, "Dump not initialized");
            return;
        }
        String str = TAG;
        LTTLogger.m5581d(str, "Dump initialized");
        IS_INIT_DUMP_SUCCESS = true;
        originalImage = bitmap;
        if (sharedPreference.contains(key.toString())) {
            IS_OCR_DUMP_ENABLE = sharedPreference.getBoolean(key.toString(), false);
        }
        Key key2 = Key.MASK;
        if (sharedPreference.contains(key2.toString())) {
            IS_MASK_DUMP_ENABLE = sharedPreference.getBoolean(key2.toString(), false);
        }
        Key key3 = Key.PARAGRAPH;
        if (sharedPreference.contains(key3.toString())) {
            LEVEL_PARAGRAPH = sharedPreference.getBoolean(key3.toString(), false);
        }
        Key key4 = Key.LINE;
        if (sharedPreference.contains(key4.toString())) {
            LEVEL_LINE = sharedPreference.getBoolean(key4.toString(), false);
        }
        Key key5 = Key.WORD;
        if (sharedPreference.contains(key5.toString())) {
            LEVEL_WORD = sharedPreference.getBoolean(key5.toString(), false);
        }
        Key key6 = Key.CHAR;
        if (sharedPreference.contains(key6.toString())) {
            LEVEL_CHAR = sharedPreference.getBoolean(key6.toString(), false);
        }
        Key key7 = Key.PADDED;
        if (sharedPreference.contains(key7.toString())) {
            IS_PADDED_POLY_ENABLED = sharedPreference.getBoolean(key7.toString(), false);
        }
        Key key8 = Key.ANNOTATION;
        if (sharedPreference.contains(key8.toString())) {
            IS_ANNOTATION_ENABLED = sharedPreference.getBoolean(key8.toString(), false);
        }
        Key key9 = Key.RENDERED_FRAME;
        if (sharedPreference.contains(key9.toString())) {
            IS_RENDERED_FRAME_ENABLED = sharedPreference.getBoolean(key9.toString(), false);
        }
        Key key10 = Key.DUMP_OCR_JSON;
        if (sharedPreference.contains(key10.toString())) {
            IS_OCR_JSON_DUMP_ENABLED = sharedPreference.getBoolean(key10.toString(), false);
        }
        Key key11 = Key.DUMP_TRANSLATION_STRING;
        if (sharedPreference.contains(key11.toString())) {
            IS_TRANSLATED_DUMP_ENABLED = sharedPreference.getBoolean(key11.toString(), false);
        }
        Key key12 = Key.RENDERING_TYPE;
        if (sharedPreference.contains(key12.toString())) {
            RENDERING_TYPE = sharedPreference.getString(key12.toString(), "H");
        }
        Key key13 = Key.LINE_WIDTH;
        if (sharedPreference.contains(key13.toString())) {
            LINE_WIDTH = sharedPreference.getInt(key13.toString(), 5);
        }
        Key key14 = Key.TEXT_SIZE;
        if (sharedPreference.contains(key14.toString())) {
            TEXT_SIZE = sharedPreference.getInt(key14.toString(), 100);
        }
        LTTLogger.m5581d(str, "IS_OCR_DUMP_ENABLE : " + IS_OCR_DUMP_ENABLE + "\nIS_MASK_DUMP_ENABLE : " + IS_MASK_DUMP_ENABLE + "\nLEVEL_PARAGRAPH : " + LEVEL_PARAGRAPH + "\nLEVEL_LINE : " + LEVEL_LINE + "\nLEVEL_WORD : " + LEVEL_WORD + "\nLEVEL_CHAR : " + LEVEL_CHAR + "\nIS_PADDED_POLY_ENABLED : " + IS_PADDED_POLY_ENABLED + "\nIS_ANNOTATION_ENABLED : " + IS_ANNOTATION_ENABLED + "\nIS_RENDERED_FRAME_ENABLED :" + IS_RENDERED_FRAME_ENABLED + "\nIS_OCR_JSON_DUMP_ENABLED :" + IS_OCR_JSON_DUMP_ENABLED + "\nTRANSLATED_RESULT_DUMP :" + IS_TRANSLATED_DUMP_ENABLED + "\nRENDERING_TYPE :" + RENDERING_TYPE + "\nLINE_WIDTH : " + LINE_WIDTH + "\nTEXT_SIZE : " + TEXT_SIZE + "\n");
    }

    public static void setScaledImage(Bitmap bitmap) {
        scaledImage = bitmap;
        isScaledImage = true;
    }
}
