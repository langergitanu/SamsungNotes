package com.samsung.android.support.senl.p148nt.model.base.utils.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.collection.AbstractC0622a;
import androidx.core.content.ContextCompat;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.model.C11397R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class AiWaterMarkUtil {
    private static void drawTextToCanvas(@NonNull Context context, @NonNull Canvas canvas, @NonNull Paint paint, @NonNull String str, float f, float f4, float f5, float f6) {
        float waterMarkPaddingTop = getWaterMarkPaddingTop(context, f, f4, f5);
        float waterMarkPadding = getWaterMarkPadding(context, f4, f5) + getWaterMarkIconPaddingEnd(context, f4, f5) + f6;
        float waterMarkMsgSize = getWaterMarkMsgSize(context, f, f4, f5);
        paint.setTextSize(waterMarkMsgSize);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        float fMin = Math.min(waterMarkMsgSize, ((f4 - waterMarkPadding) * waterMarkMsgSize) / r2.width());
        paint.setTextSize(fMin);
        canvas.drawText(str, waterMarkPadding, AbstractC0622a.m1155a(getWaterMarkIconSize(context, f, f4, f5), fMin, 2.0f, waterMarkPaddingTop + r2.height()), paint);
    }

    public static void drawVisibleWaterMarkToImage(@NonNull Context context, @DrawableRes int i, @StringRes int i2, @NonNull Bitmap bitmap, float f) {
        float height = bitmap.getHeight();
        float width = bitmap.getWidth();
        Canvas canvas = new Canvas(bitmap);
        float waterMarkIconSize = getWaterMarkIconSize(context, height, width, f);
        drawWaterMarkIcon(context, canvas, i, waterMarkIconSize, height, width, f);
        String string = context.getString(i2);
        drawWaterMarkMsgBorder(context, canvas, string, height, width, f, waterMarkIconSize);
        drawWaterMarkMsg(context, canvas, string, height, width, f, waterMarkIconSize);
    }

    private static void drawWaterMarkIcon(@NonNull Context context, @NonNull Canvas canvas, @DrawableRes int i, float f, float f4, float f5, float f6) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable == null) {
            return;
        }
        float waterMarkPadding = getWaterMarkPadding(context, f5, f6);
        float waterMarkPaddingTop = getWaterMarkPaddingTop(context, f4, f5, f6);
        drawable.setBounds((int) waterMarkPadding, (int) waterMarkPaddingTop, (int) (waterMarkPadding + f), (int) (waterMarkPaddingTop + f));
        drawable.draw(canvas);
    }

    private static void drawWaterMarkMsg(@NonNull Context context, @NonNull Canvas canvas, @NonNull String str, float f, float f4, float f5, float f6) {
        Paint paintForText = getPaintForText();
        paintForText.setStyle(Paint.Style.FILL);
        paintForText.setColor(Color.argb(102, 242, 242, 243));
        drawTextToCanvas(context, canvas, paintForText, str, f, f4, f5, f6);
    }

    private static void drawWaterMarkMsgBorder(@NonNull Context context, @NonNull Canvas canvas, @NonNull String str, float f, float f4, float f5, float f6) {
        Paint paintForText = getPaintForText();
        paintForText.setStyle(Paint.Style.STROKE);
        paintForText.setColor(Color.argb(102, 71, 71, 74));
        paintForText.setStrokeWidth(getWaterMarkMsgStrokeWidth(context, f4, f5));
        drawTextToCanvas(context, canvas, paintForText, str, f, f4, f5, f6);
    }

    @NonNull
    private static Paint getPaintForText() {
        Paint paint = new Paint();
        paint.setTypeface(28 <= Build.VERSION.SDK_INT ? Typeface.create(Typeface.create("sec", 0), 400, false) : Typeface.create("sec-roboto-light", 0));
        paint.setAntiAlias(true);
        paint.setSubpixelText(true);
        paint.setLinearText(true);
        return paint;
    }

    private static float getWaterMarkIconPaddingEnd(@NonNull Context context, float f, float f4) {
        return (context.getResources().getDimension(C11397R.dimen.ai_drawing_water_mark_icon_padding_end) * f) / f4;
    }

    private static float getWaterMarkIconSize(@NonNull Context context, float f, float f4, float f5) {
        if (!CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            return (context.getResources().getDimension(C11397R.dimen.ai_drawing_water_mark_icon_size) * f4) / f5;
        }
        return Math.min(f, f4) * ResourceUtils.getFloatRes(context.getResources(), C11397R.dimen.ai_drawing_water_mark_size_chn);
    }

    public static float getWaterMarkMsgSize(@NonNull Context context, float f, float f4, float f5) {
        if (!CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            return (context.getResources().getDimension(C11397R.dimen.ai_drawing_water_mark_msg_size) * f4) / f5;
        }
        return Math.min(f, f4) * ResourceUtils.getFloatRes(context.getResources(), C11397R.dimen.ai_drawing_water_mark_size_chn);
    }

    public static float getWaterMarkMsgStrokeWidth(@NonNull Context context, float f, float f4) {
        return (context.getResources().getDimension(C11397R.dimen.ai_drawing_water_mark_msg_stroke_width) * f) / f4;
    }

    private static float getWaterMarkPadding(@NonNull Context context, float f, float f4) {
        return (context.getResources().getDimension(C11397R.dimen.ai_drawing_water_mark_padding) * f) / f4;
    }

    public static float getWaterMarkPaddingTop(@NonNull Context context, float f, float f4, float f5) {
        return (f - getWaterMarkPadding(context, f4, f5)) - getWaterMarkIconSize(context, f, f4, f5);
    }
}
