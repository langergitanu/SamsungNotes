package com.samsung.android.imagetranslation.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Environment;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.imagetranslation.jni.SceneText;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Dump {
    public static boolean DISABLE_INPAINTING = false;
    public static boolean DUMP_ENABLE = true;
    public static String INPAINTING_MASK_LEVEL = "L";
    public static float INPAINTING_MASK_PADDING = 0.0f;
    private static boolean IS_ANNOTATION_ENABLED = false;
    public static boolean IS_INIT_DUMP_SUCCESS = false;
    public static boolean IS_INPAINTED_FRAME_ENABLED = false;
    public static boolean IS_INPAINTED_UPSCALED_IMAGE_DUMP = false;
    public static boolean IS_INPAINTING_MASK_DUMP_ENABLE = false;
    public static boolean IS_MASK_DUMP_ENABLE = false;
    public static boolean IS_OCR_DUMP_ENABLE = false;
    public static boolean IS_OCR_JSON_DUMP_ENABLED = false;
    public static boolean IS_ORIGINAL_IMAGE_DUMP = false;
    public static boolean IS_ORIGINAL_UPSCALED_IMAGE_DUMP = false;
    public static boolean IS_PADDED_POLY_ENABLED = false;
    public static boolean IS_RENDERED_FRAME_ENABLED = false;
    public static boolean IS_TRANSLATED_DUMP_ENABLED = false;
    public static boolean IS_UNIFORM_FONT_ENABLED = true;
    private static boolean LEVEL_CHAR = false;
    private static boolean LEVEL_LINE = false;
    private static boolean LEVEL_PARAGRAPH = false;
    private static boolean LEVEL_WORD = false;
    private static int LINE_WIDTH = 0;
    private static final String PREF_NAME = "LttEngineSharedPreference";
    public static boolean PRINT_BLOCK_TYPE = false;
    public static String RENDERING_TYPE = "H";
    private static final String TAG = "Dump";
    private static int TEXT_SIZE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Key {
        PARAGRAPH,
        LINE,
        WORD,
        CHAR,
        OCR,
        MASK,
        INPAINTING_MASK,
        PADDED,
        ANNOTATION,
        RENDERED_FRAME,
        DUMP_OCR_JSON,
        DUMP_TRANSLATION_STRING,
        DUMP_INPAINTED_FRAME,
        DISABLE_INPAINTING,
        PRINT_BLOCK_TYPE,
        TEXT_RENDERED_FRAME,
        RENDERING_TYPE,
        LINE_WIDTH,
        TEXT_SIZE,
        INPAINTING_MASK_PADDING,
        INPAINTING_MASK_LEVEL,
        IS_UNIFORM_FONT_ENABLED
    }

    private static void annotatePolys(Point[] pointArr, Canvas canvas, Paint paint, float f, Paint paint2) {
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
            canvas.drawText(AbstractC2322a.m1615e(i, ""), point.x, point.y, paint2);
            i++;
        }
    }

    public static void createFolder(String str) {
        String str2 = TAG;
        LTTLogger.m5458d(str2, "make directory : " + str);
        File file = new File(str);
        if (file.isDirectory() || file.mkdirs()) {
            return;
        }
        LTTLogger.m5458d(str2, "make directory!!, fail");
    }

    public static void drawOCR(Bitmap bitmap, CopyOnWriteArrayList<SceneText> copyOnWriteArrayList, boolean z) {
        char c;
        if (!IS_INIT_DUMP_SUCCESS || !IS_OCR_DUMP_ENABLE) {
            LTTLogger.m5458d(TAG, "OCR Dump is not enabled");
            return;
        }
        char c2 = 1;
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmapCopy);
        float f = TEXT_SIZE;
        float f4 = LINE_WIDTH;
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        paint2.setColor(-16776961);
        paint2.setStrokeWidth(f4);
        paint.setColor(-65536);
        paint.setTextSize(f);
        int i = 0;
        for (SceneText sceneText : copyOnWriteArrayList) {
            paint2.setColor(-16776961);
            if (LEVEL_PARAGRAPH) {
                Point[] poly = sceneText.getPoly();
                String str = sceneText.isParagraphRendering() ? "H" : "L";
                if (PRINT_BLOCK_TYPE) {
                    Point point = poly[0];
                    c = c2;
                    canvas.drawText(str, point.x - 5, point.y - 2, paint);
                    Point point2 = poly[c];
                    canvas.drawText("B-" + (i + 1), point2.x + 5, point2.y - 2, paint);
                } else {
                    c = c2;
                }
                if (sceneText.getBlockType() == LttOcrResult.BlockInfo.BLOCK_TYPE.TABULAR.ordinal()) {
                    paint2.setColor(-256);
                }
                drawRect(z ? sceneText.getPaddedBoxPoly() : sceneText.getPoly(), paint2, canvas, 15.0f, paint);
            } else {
                c = c2;
            }
            for (SceneText sceneText2 : sceneText.getComponents()) {
                paint2.setColor(VUtilString.GREEN);
                if (LEVEL_LINE) {
                    drawRect(sceneText2.getPoly(), paint2, canvas, 15.0f, paint);
                }
                for (SceneText sceneText3 : sceneText2.getComponents()) {
                    paint2.setColor(-65536);
                    if (LEVEL_WORD) {
                        drawRect(sceneText3.getPoly(), paint2, canvas, 15.0f, paint);
                    }
                    for (SceneText sceneText4 : sceneText3.getComponents()) {
                        paint2.setColor(-256);
                        if (LEVEL_CHAR) {
                            drawRect(sceneText4.getPoly(), paint2, canvas, 15.0f, paint);
                        }
                    }
                }
            }
            i++;
            c2 = c;
        }
        dumpBitmap(bitmapCopy, "ocr_dump_" + System.currentTimeMillis() + ".png", "OCR");
    }

    private static void drawRect(Point[] pointArr, Paint paint, Canvas canvas, float f, Paint paint2) {
        Point point;
        Point point2;
        if (pointArr == null) {
            return;
        }
        int i = 0;
        while (i < pointArr.length) {
            if (i == pointArr.length - 1) {
                point = new Point(pointArr[i]);
                point2 = new Point(pointArr[0]);
            } else {
                point = new Point(pointArr[i]);
                point2 = new Point(pointArr[i + 1]);
            }
            Paint paint3 = paint;
            Canvas canvas2 = canvas;
            canvas2.drawLine(point.x, point.y, point2.x, point2.y, paint3);
            if (IS_ANNOTATION_ENABLED) {
                annotatePolys(pointArr, canvas2, paint3, f, paint2);
            }
            i++;
            canvas = canvas2;
            paint = paint3;
        }
    }

    public static void dumpBitmap(Bitmap bitmap, String str, String str2) {
        FileOutputStream fileOutputStream;
        String str3 = TAG;
        LTTLogger.m5458d(str3, "Dump bitmap");
        if (!IS_INIT_DUMP_SUCCESS) {
            LTTLogger.m5458d(str3, "Dump is not initialized");
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(getStoragePath(str2) + str);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                LTTLogger.m5458d(str3, "bitmap dump success");
                fileOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                LTTLogger.m5459e(TAG, e.getMessage());
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public static void dumpFile(String str, String str2, String str3) {
        String str4 = TAG;
        LTTLogger.m5458d(str4, "dumpFile");
        if (!IS_INIT_DUMP_SUCCESS) {
            LTTLogger.m5458d(str4, "Dump is not initialized");
            return;
        }
        try {
            File file = new File(getStoragePath(str3) + str2);
            if (!file.exists() && !file.createNewFile()) {
                throw new IOException("Failed to create file: " + file.getAbsolutePath());
            }
            FileWriter fileWriter = new FileWriter(file, true);
            try {
                fileWriter.write(str);
                fileWriter.close();
            } finally {
            }
        } catch (Exception e) {
            LTTLogger.m5459e(TAG, e.getMessage());
        }
    }

    public static void dumpStringListToJsonFile(List<String> list, String str, String str2) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(list, new TypeToken<List<String>>() { // from class: com.samsung.android.imagetranslation.common.Dump.1
        }.getType());
        try {
            File file = new File(getStoragePath(str2) + str);
            if (!file.exists() && !file.createNewFile()) {
                throw new IOException("Failed to create file: " + file.getAbsolutePath());
            }
            FileWriter fileWriter = new FileWriter(file, true);
            try {
                fileWriter.write(json);
                fileWriter.close();
            } finally {
            }
        } catch (Exception e) {
            LTTLogger.m5459e(TAG, e.getMessage());
        }
    }

    public static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(PREF_NAME, 0);
    }

    public static String getStoragePath(String str) {
        String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath() + "/LttDump/" + str + "/";
        createFolder(str2);
        return str2;
    }

    public static void initDump(Context context) {
        if (!Config.IS_USER_DEBUG) {
            LTTLogger.m5458d(TAG, "Dump not supported as device is not userdebug binary");
            return;
        }
        SharedPreferences sharedPreference = getSharedPreference(context);
        Key key = Key.OCR;
        if (!sharedPreference.contains(key.toString()) || !DUMP_ENABLE) {
            IS_INIT_DUMP_SUCCESS = false;
            LTTLogger.m5458d(TAG, "Dump not initialized as dump file is not present");
            return;
        }
        IS_INIT_DUMP_SUCCESS = true;
        String str = TAG;
        LTTLogger.m5458d(str, "Dump initialized");
        if (sharedPreference.contains(key.toString())) {
            IS_OCR_DUMP_ENABLE = sharedPreference.getBoolean(key.toString(), false);
        }
        Key key2 = Key.MASK;
        if (sharedPreference.contains(key2.toString())) {
            IS_MASK_DUMP_ENABLE = sharedPreference.getBoolean(key2.toString(), false);
        }
        Key key3 = Key.INPAINTING_MASK;
        if (sharedPreference.contains(key3.toString())) {
            IS_INPAINTING_MASK_DUMP_ENABLE = sharedPreference.getBoolean(key3.toString(), false);
        }
        Key key4 = Key.PARAGRAPH;
        if (sharedPreference.contains(key4.toString())) {
            LEVEL_PARAGRAPH = sharedPreference.getBoolean(key4.toString(), false);
        }
        Key key5 = Key.LINE;
        if (sharedPreference.contains(key5.toString())) {
            LEVEL_LINE = sharedPreference.getBoolean(key5.toString(), false);
        }
        Key key6 = Key.WORD;
        if (sharedPreference.contains(key6.toString())) {
            LEVEL_WORD = sharedPreference.getBoolean(key6.toString(), false);
        }
        Key key7 = Key.CHAR;
        if (sharedPreference.contains(key7.toString())) {
            LEVEL_CHAR = sharedPreference.getBoolean(key7.toString(), false);
        }
        Key key8 = Key.PADDED;
        if (sharedPreference.contains(key8.toString())) {
            IS_PADDED_POLY_ENABLED = sharedPreference.getBoolean(key8.toString(), false);
        }
        Key key9 = Key.ANNOTATION;
        if (sharedPreference.contains(key9.toString())) {
            IS_ANNOTATION_ENABLED = sharedPreference.getBoolean(key9.toString(), false);
        }
        Key key10 = Key.RENDERED_FRAME;
        if (sharedPreference.contains(key10.toString())) {
            IS_RENDERED_FRAME_ENABLED = sharedPreference.getBoolean(key10.toString(), false);
        }
        Key key11 = Key.DUMP_OCR_JSON;
        if (sharedPreference.contains(key11.toString())) {
            IS_OCR_JSON_DUMP_ENABLED = sharedPreference.getBoolean(key11.toString(), false);
        }
        Key key12 = Key.DUMP_TRANSLATION_STRING;
        if (sharedPreference.contains(key12.toString())) {
            IS_TRANSLATED_DUMP_ENABLED = sharedPreference.getBoolean(key12.toString(), false);
        }
        Key key13 = Key.DUMP_INPAINTED_FRAME;
        if (sharedPreference.contains(key13.toString())) {
            IS_INPAINTED_FRAME_ENABLED = sharedPreference.getBoolean(key13.toString(), false);
        }
        Key key14 = Key.DISABLE_INPAINTING;
        if (sharedPreference.contains(key14.toString())) {
            DISABLE_INPAINTING = sharedPreference.getBoolean(key14.toString(), false);
        }
        Key key15 = Key.PRINT_BLOCK_TYPE;
        if (sharedPreference.contains(key15.toString())) {
            PRINT_BLOCK_TYPE = sharedPreference.getBoolean(key15.toString(), false);
        }
        Key key16 = Key.RENDERING_TYPE;
        if (sharedPreference.contains(key16.toString())) {
            RENDERING_TYPE = sharedPreference.getString(key16.toString(), "H");
        }
        Key key17 = Key.LINE_WIDTH;
        if (sharedPreference.contains(key17.toString())) {
            LINE_WIDTH = sharedPreference.getInt(key17.toString(), 5);
        }
        Key key18 = Key.TEXT_SIZE;
        if (sharedPreference.contains(key18.toString())) {
            TEXT_SIZE = sharedPreference.getInt(key18.toString(), 100);
        }
        Key key19 = Key.INPAINTING_MASK_PADDING;
        if (sharedPreference.contains(key19.toString())) {
            INPAINTING_MASK_PADDING = sharedPreference.getFloat(key19.toString(), 0.0f);
        }
        Key key20 = Key.INPAINTING_MASK_LEVEL;
        if (sharedPreference.contains(key20.toString())) {
            INPAINTING_MASK_LEVEL = sharedPreference.getString(key20.toString(), "L");
        }
        Key key21 = Key.IS_UNIFORM_FONT_ENABLED;
        if (sharedPreference.contains(key21.toString())) {
            IS_UNIFORM_FONT_ENABLED = sharedPreference.getBoolean(key21.toString(), true);
        }
        LTTLogger.m5458d(str, "IS_OCR_DUMP_ENABLE : " + IS_OCR_DUMP_ENABLE + "\nIS_MASK_DUMP_ENABLE : " + IS_MASK_DUMP_ENABLE + "\nIS_INPAINTING_MASK_DUMP_ENABLE : " + IS_INPAINTING_MASK_DUMP_ENABLE + "\nLEVEL_PARAGRAPH : " + LEVEL_PARAGRAPH + "\nLEVEL_LINE : " + LEVEL_LINE + "\nLEVEL_WORD : " + LEVEL_WORD + "\nLEVEL_CHAR : " + LEVEL_CHAR + "\nIS_PADDED_POLY_ENABLED : " + IS_PADDED_POLY_ENABLED + "\nIS_ANNOTATION_ENABLED : " + IS_ANNOTATION_ENABLED + "\nIS_RENDERED_FRAME_ENABLED :" + IS_RENDERED_FRAME_ENABLED + "\nIS_INPAINTED_FRAME_ENABLED :" + IS_INPAINTED_FRAME_ENABLED + "\nDISABLE_INPAINTING :" + DISABLE_INPAINTING + "\nPRINT_BLOCK_TYPE :" + PRINT_BLOCK_TYPE + "\nIS_OCR_JSON_DUMP_ENABLED :" + IS_OCR_JSON_DUMP_ENABLED + "\nTRANSLATED_RESULT_DUMP :" + IS_TRANSLATED_DUMP_ENABLED + "\nRENDERING_TYPE :" + RENDERING_TYPE + "\nLINE_WIDTH : " + LINE_WIDTH + "\nTEXT_SIZE : " + TEXT_SIZE + "\nINPAINTING_MASK_PADDING : " + INPAINTING_MASK_PADDING + "\nINPAINTING_MASK_LEVEL : " + INPAINTING_MASK_LEVEL + "\nIS_UNIFORM_FONT_ENABLED : " + IS_UNIFORM_FONT_ENABLED);
    }

    public static Bitmap intArrayToBitmap(int[] iArr, int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            bitmapCreateBitmap.setPixel(i4 % i, i4 / i, Color.rgb(i5, i5, i5));
        }
        return bitmapCreateBitmap;
    }

    public static boolean isDumpEnabled() {
        return IS_INIT_DUMP_SUCCESS;
    }
}
