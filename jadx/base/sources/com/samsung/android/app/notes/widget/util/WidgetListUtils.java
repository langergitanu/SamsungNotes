package com.samsung.android.app.notes.widget.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.TypedValue;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.content.ContextCompat;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayData;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayDataHelper;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.io.File;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J*\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J*\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0014H\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0002J \u0010$\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0007H\u0007J&\u0010'\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0014J3\u0010(\u001a\u0004\u0018\u00010\u00182\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010,J \u0010-\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0018\u00100\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0018H\u0002J\u001e\u0010+\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/util/WidgetListUtils;", "Lcom/samsung/android/app/notes/widget/util/WidgetUtils;", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MAX_DISPLAY_CONTENTS", "", "getDate", "context", "Landroid/content/Context;", "milliSeconds", "", "changeTimeAccordingToLocale", "time", "getThumbnailFilePath", "uuid", "mainListDocumentData", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "isWidgetDarkTheme", "", "getMainThumbnailPath", "fileName", "getThumbnailBitmap", "Landroid/graphics/Bitmap;", "isDarkTheme", "getTextContent", "", "subSequenceContent", "textContent", "getDisplayContent", "blob", "", "addTrimTextContent", "Landroid/text/SpannableString;", "content", "getRoundedRectBitmap", "bitmap", "pageColor", "getCircularBitmapWithBorder", "getBitmapFromDrawable", "drawableId", "color", "isDarkThemeBitmap", "(Landroid/content/Context;ILjava/lang/Integer;Z)Landroid/graphics/Bitmap;", "getDarkBgColor", "defaultId", "antiGreenishId", "getDarkThumbnailBitmap", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListUtils extends WidgetUtils {
    private static final int MAX_DISPLAY_CONTENTS = 300;

    @NotNull
    private static final String TAG = "WidgetListUtils";

    @NotNull
    public static final WidgetListUtils INSTANCE = new WidgetListUtils();
    public static final int $stable = 8;

    private WidgetListUtils() {
    }

    private final SpannableString addTrimTextContent(CharSequence content) {
        while (content != null && content.length() >= 2 && (content.charAt(0) == '\n' || content.charAt(0) == '\t' || content.charAt(0) == ' ')) {
            content = content.subSequence(1, content.length());
        }
        return new SpannableString(content);
    }

    private final String changeTimeAccordingToLocale(String time) {
        return 1 == TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) ? AbstractC0541b.m773o("\u202a", time, "\u202c") : time;
    }

    private final Bitmap getBitmapFromDrawable(Context context, @DrawableRes int drawableId, Integer color, boolean isDarkThemeBitmap) {
        Drawable drawable = context.getResources().getDrawable(drawableId, null);
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof VectorDrawable)) {
            WidgetLogger.m5156w(TAG, "getBitmapFromDrawable# unsupported drawable type");
            return null;
        }
        VectorDrawable vectorDrawable = (VectorDrawable) drawable;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        if (color != null) {
            Paint paint = new Paint();
            paint.setColor(isDarkThemeBitmap ? ContextCompat.getColor(context, C11391R.color.widget_note_page_color_dark) : color.intValue());
            paint.setAntiAlias(true);
            canvasM4740a.drawPaint(paint);
        }
        vectorDrawable.setBounds(0, 0, canvasM4740a.getWidth(), canvasM4740a.getHeight());
        vectorDrawable.draw(canvasM4740a);
        return bitmapCreateBitmap;
    }

    private final int getDarkBgColor(Context context, int defaultId, int antiGreenishId) {
        return ModelFeature.getFeature().needAntiGreenish() ? ContextCompat.getColor(context, antiGreenishId) : ContextCompat.getColor(context, defaultId);
    }

    private final Bitmap getDarkThumbnailBitmap(Context context, Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(getDarkBgColor(context, C11391R.color.widget_list_thumbnail_opacity, C11391R.color.widget_list_anti_greenish_thumbnail_opacity), PorterDuff.Mode.SRC_ATOP));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    @JvmStatic
    @NotNull
    public static final String getDate(@Nullable Context context, long milliSeconds) {
        if (!DateUtils.isToday(milliSeconds)) {
            return ContentUtils.INSTANCE.getDateFormat(milliSeconds);
        }
        String str = DateFormat.getTimeFormat(context).format(Long.valueOf(milliSeconds));
        WidgetListUtils widgetListUtils = INSTANCE;
        Intrinsics.checkNotNull(str);
        return widgetListUtils.changeTimeAccordingToLocale(str);
    }

    private final String getMainThumbnailPath(Context context, String uuid, String fileName) {
        String rootCacheDirectoryPath = PageCacheUtils.getRootCacheDirectoryPath(context);
        String str = File.separator;
        return AbstractC0622a.m1170p(str, fileName, AbstractC2821a.m2228s(rootCacheDirectoryPath, str, uuid, str, Constants.MAIN_THUMBNAIL_PATH));
    }

    @JvmStatic
    @NotNull
    public static final Bitmap getRoundedRectBitmap(@NotNull Context context, @NotNull Bitmap bitmap, int pageColor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int iMax = (int) Math.max(bitmap.getWidth(), bitmap.getHeight());
        float dimensionPixelSize = (context.getResources().getDimensionPixelSize(C11391R.dimen.widget_list_thumbnail_radius) * iMax) / context.getResources().getDimensionPixelSize(C11391R.dimen.widget_list_thumbnail_size);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax, Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(pageColor);
        paint.setAntiAlias(true);
        float f = iMax;
        RectF rectF = new RectF(0.0f, 0.0f, f, f);
        canvasM4740a.drawRoundRect(rectF, dimensionPixelSize, dimensionPixelSize, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvasM4740a.drawRect(rectF, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvasM4740a.drawBitmap(bitmap, (rectF.width() - bitmap.getWidth()) / 2.0f, (rectF.height() - bitmap.getHeight()) / 2.0f, paint);
        return bitmapCreateBitmap;
    }

    private final CharSequence getTextContent(MainListDocumentData mainListDocumentData) {
        try {
            return getDisplayContent(mainListDocumentData.getDisplayContent());
        } catch (Exception unused) {
            String content = mainListDocumentData.getContent();
            Intrinsics.checkNotNullExpressionValue(content, "getContent(...)");
            return subSequenceContent(content);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b A[Catch: Exception -> 0x0068, TryCatch #0 {Exception -> 0x0068, blocks: (B:7:0x003e, B:9:0x0044, B:12:0x006b, B:15:0x0073, B:17:0x007a, B:21:0x0085), top: B:34:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    @JvmStatic
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap getThumbnailBitmap(@NotNull Context context, @NotNull String uuid, @NotNull MainListDocumentData mainListDocumentData, boolean isDarkTheme) {
        Bitmap bitmap;
        Bitmap bitmapDecodeFile;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(mainListDocumentData, "mainListDocumentData");
        int backgroundColor = mainListDocumentData.getBackgroundColor();
        WidgetListUtils widgetListUtils = INSTANCE;
        boolean zIsDarkThemeBitmap = widgetListUtils.isDarkThemeBitmap(context, mainListDocumentData, isDarkTheme);
        if (mainListDocumentData.getIsLock() == 5) {
            WidgetLogger.m5154d(TAG, "getThumbnailBitmap# lock");
            bitmapDecodeFile = widgetListUtils.getBitmapFromDrawable(context, C11391R.drawable.ic_lock, null, zIsDarkThemeBitmap);
        } else {
            String thumbnailFilePath = widgetListUtils.getThumbnailFilePath(context, uuid, mainListDocumentData, isDarkTheme);
            CharSequence textContent = widgetListUtils.getTextContent(mainListDocumentData);
            if (thumbnailFilePath != null) {
                try {
                    if (!TextUtils.isEmpty(thumbnailFilePath)) {
                        WidgetLogger.m5154d(TAG, "getThumbnailBitmap# path: " + WidgetLogger.INSTANCE.getEncode(thumbnailFilePath));
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = 4;
                        bitmapDecodeFile = BitmapFactory.decodeFile(thumbnailFilePath, options);
                    } else if (TextUtils.isEmpty(textContent) || (textContent != null && textContent.length() == 1 && textContent.charAt(0) == '\n')) {
                        WidgetLogger.m5154d(TAG, "getThumbnailBitmap# no content");
                        bitmapDecodeFile = widgetListUtils.getBitmapFromDrawable(context, C11391R.drawable.widget_list_item_thumbnail_blank, Integer.valueOf(backgroundColor), zIsDarkThemeBitmap);
                    } else {
                        bitmapDecodeFile = null;
                    }
                    if (bitmapDecodeFile == null) {
                        return null;
                    }
                    if (zIsDarkThemeBitmap) {
                        try {
                            bitmapDecodeFile = widgetListUtils.getDarkThumbnailBitmap(context, bitmapDecodeFile);
                            backgroundColor = widgetListUtils.getDarkBgColor(context, C11391R.color.widget_list_thumbnail_dark_bg_color, C11391R.color.widget_list_thumbnail_anti_greenish_dark_bg_color);
                        } catch (Exception e) {
                            bitmap = bitmapDecodeFile;
                            e = e;
                            WidgetLogger.INSTANCE.m5157e(TAG, "getThumbnailBitmap# " + e.getMessage());
                            bitmapDecodeFile = bitmap;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    bitmap = null;
                    WidgetLogger.INSTANCE.m5157e(TAG, "getThumbnailBitmap# " + e.getMessage());
                    bitmapDecodeFile = bitmap;
                    if (bitmapDecodeFile != null) {
                    }
                }
            }
        }
        if (bitmapDecodeFile != null) {
            return null;
        }
        return getRoundedRectBitmap(context, bitmapDecodeFile, backgroundColor);
    }

    private final String getThumbnailFilePath(Context context, String uuid, MainListDocumentData mainListDocumentData, boolean isWidgetDarkTheme) {
        String str = isDarkThemeBitmap(context, mainListDocumentData, isWidgetDarkTheme) ? Constants.MAIN_DARK_THUMBNAIL_FILE_NAME : "thumbnail";
        String[] strArr = {str, str.concat(Constants.MAIN_THUMBNAIL_FILE_NAME_TEXT)};
        for (int i = 0; i < 2; i++) {
            String mainThumbnailPath = getMainThumbnailPath(context, uuid, strArr[i]);
            if (AbstractC2322a.m1607A(mainThumbnailPath)) {
                return mainThumbnailPath;
            }
        }
        return null;
    }

    @NotNull
    public final Bitmap getCircularBitmapWithBorder(@NotNull Context context, @NotNull Bitmap bitmap, int pageColor, boolean isDarkTheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int iMax = (int) Math.max(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax, Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        float fApplyDimension = TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics());
        float f = iMax;
        float f4 = f / 2.0f;
        int color = isDarkTheme ? ContextCompat.getColor(context, C11391R.color.f7461x13c5a45c) : ContextCompat.getColor(context, C11391R.color.f7462x65631cf0);
        Paint paint = new Paint(1);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(fApplyDimension);
        Paint paint2 = new Paint(1);
        float f5 = 2;
        float f6 = (int) (f - (fApplyDimension * f5));
        float fMin = Math.min(f6 / bitmap.getWidth(), f6 / bitmap.getHeight());
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        Paint paint3 = new Paint(1);
        paint3.setColor(pageColor);
        Unit unit = Unit.INSTANCE;
        canvasM4740a.drawCircle(f4, f4, f4 - fApplyDimension, paint3);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvasM4740a.drawBitmap(bitmapCreateScaledBitmap, (iMax - r9) / 2.0f, (iMax - r5) / 2.0f, paint2);
        canvasM4740a.drawCircle(f4, f4, f4 - (fApplyDimension / f5), paint);
        bitmapCreateScaledBitmap.recycle();
        return bitmapCreateBitmap;
    }

    @Nullable
    public final CharSequence getDisplayContent(@Nullable byte[] blob) throws Exception {
        if (blob == null) {
            return null;
        }
        try {
            DisplayData displayData = (DisplayData) DisplayDataHelper.unmarshall(blob, DisplayData.CREATOR);
            String strValueOf = String.valueOf(displayData != null ? displayData.getContent() : null);
            if (TextUtils.isEmpty(strValueOf)) {
                return null;
            }
            int length = strValueOf.length();
            CharSequence charSequenceSubSequence = strValueOf;
            if (length > 300) {
                charSequenceSubSequence = strValueOf.subSequence(0, 300);
            }
            return addTrimTextContent(charSequenceSubSequence);
        } catch (Exception e) {
            throw new Exception(e.getMessage() == null ? "" : e.getMessage());
        }
    }

    public final boolean isDarkThemeBitmap(@NotNull Context context, @NotNull MainListDocumentData mainListDocumentData, boolean isWidgetDarkTheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mainListDocumentData, "mainListDocumentData");
        return mainListDocumentData.getBackgroundColor() == ContextCompat.getColor(context, C11391R.color.widget_note_page_color_light) && mainListDocumentData.getBackgroundColorInverted() == 1 && isWidgetDarkTheme;
    }

    @NotNull
    public final CharSequence subSequenceContent(@NotNull CharSequence textContent) {
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        return textContent.length() > 300 ? textContent.subSequence(0, 300) : textContent;
    }
}
