package com.samsung.android.app.notes.widget.glance.single.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.Shape;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenComposerSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010$J\u0018\u0010%\u001a\u00020\f2\u0010\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010'J\u0018\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010'2\u0006\u0010*\u001a\u00020\fJ\"\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010'2\u0006\u0010*\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0005H\u0002J\"\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010'2\u0006\u0010*\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0005H\u0002J.\u0010.\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0005H\u0002J\u0014\u00102\u001a\u0004\u0018\u00010(2\b\u00103\u001a\u0004\u0018\u00010(H\u0002J\u0010\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020(H\u0002J\u0006\u00106\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u00068"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/single/common/WidgetSingleGlanceUtils;", "", "mContext", "Landroid/content/Context;", "mAppWidgetId", "", "mUuid", "", "mProviderName", "<init>", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V", "isViewMore", "", "()Z", "setViewMore", "(Z)V", "isAddLine", "setAddLine", "width", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "getShape", "Landroidx/glance/oneui/template/Shape;", "shapeBG", "backgroundOnOff", "size", "Landroidx/glance/oneui/common/AppWidgetSize;", "getShape-nwm-oUQ", "(IZI)Landroidx/glance/oneui/template/Shape;", DynamicActionBarProvider.METHOD_GET_DATA, "mainListEntry", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentEntity;", "isBitmapNull", "bitmaps", "", "Landroid/graphics/Bitmap;", "createContent", "isDarkMode", "addWidget", "targetPageCount", "addTextOnlyWidget", "getTextOnlyBitmap", "targetIndex", "widgetWidth", "orientation", "addWidgetWithBitmap", "source", "getBitmap", "bitmap", "getViewMore", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetSingleGlanceUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetSingleGlanceUtils.kt\ncom/samsung/android/app/notes/widget/glance/single/common/WidgetSingleGlanceUtils\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,245:1\n71#2,2:246\n*S KotlinDebug\n*F\n+ 1 WidgetSingleGlanceUtils.kt\ncom/samsung/android/app/notes/widget/glance/single/common/WidgetSingleGlanceUtils\n*L\n222#1:246,2\n*E\n"})
public final class WidgetSingleGlanceUtils {
    private static final int BYTE_PIXEL_ARGB_8888 = 4;
    private static final float SCALE_FACTORY = 2.0f;

    @NotNull
    public static final String TAG = "WidgetSingleGlanceUtils";
    private static final float WIDGET_QUALITY_RATIO = 0.3f;
    private int height;
    private boolean isAddLine;
    private boolean isViewMore;
    private final int mAppWidgetId;

    @NotNull
    private final Context mContext;

    @NotNull
    private final String mProviderName;

    @NotNull
    private final String mUuid;
    private int width;
    public static final int $stable = 8;

    public WidgetSingleGlanceUtils(@NotNull Context mContext, int i, @NotNull String mUuid, @NotNull String mProviderName) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mUuid, "mUuid");
        Intrinsics.checkNotNullParameter(mProviderName, "mProviderName");
        this.mContext = mContext;
        this.mAppWidgetId = i;
        this.mUuid = mUuid;
        this.mProviderName = mProviderName;
        this.isViewMore = true;
    }

    private final List<Bitmap> addTextOnlyWidget(boolean isDarkMode, int targetPageCount) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        int widgetOrientationPref = BaseWidgetPreferenceManager.INSTANCE.getWidgetOrientationPref(this.mAppWidgetId);
        WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
        float widgetWidth = companion.getWidgetWidth(this.mContext, this.mAppWidgetId);
        if (widgetWidth <= 0.0f && Build.VERSION.SDK_INT > 31) {
            widgetWidth = companion.getWidgetSizeF(this.mContext, this.mAppWidgetId).getFirst().floatValue();
        }
        int iDipToPixels = (int) companion.dipToPixels(this.mContext, widgetWidth);
        List<Bitmap> textOnlyBitmap = getTextOnlyBitmap(targetPageCount, iDipToPixels, isDarkMode, widgetOrientationPref);
        if (textOnlyBitmap.isEmpty() || Intrinsics.areEqual(this.mProviderName, BaseWidgetConstant.WIDGET_SINGLE_MEDIUM_COVER_PROVIDER_NAME)) {
            WidgetLogger.INSTANCE.m5157e(TAG, "addTextOnlyWidget# capture new bitmap");
            z = isDarkMode;
            textOnlyBitmap = CacheFileManager.INSTANCE.getInstance().captureTextOnlyBitmap(this.mContext, this.mUuid, this.mAppWidgetId, iDipToPixels, z, false, this.mProviderName);
        } else {
            WidgetLogger.INSTANCE.m5157e(TAG, "addTextOnlyWidget# get cache bitmap");
            z = isDarkMode;
        }
        List<Bitmap> list = textOnlyBitmap;
        if (list == null || list.isEmpty()) {
            WidgetLogger.INSTANCE.m5157e(TAG, "addTextOnlyWidget# textOnly fail capture");
            return null;
        }
        int size = textOnlyBitmap.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (i == 0) {
                this.isAddLine = CacheFileManager.INSTANCE.getInstance().isListPageMode(this.mUuid) && textOnlyBitmap.size() > 1;
            }
            arrayList.add(addWidgetWithBitmap(textOnlyBitmap.get(i)));
            i++;
        }
        CacheFileManager companion2 = CacheFileManager.INSTANCE.getInstance();
        Context context = this.mContext;
        String str = this.mUuid;
        List<Bitmap> list2 = textOnlyBitmap;
        companion2.saveTextOnlyData(context, str, list2, str, z, iDipToPixels, widgetOrientationPref);
        WidgetUtils.Companion companion3 = WidgetUtils.INSTANCE;
        Context context2 = this.mContext;
        this.isViewMore = (size == 1 && list2.get(0).getHeight() >= ((int) companion3.dipToPixels(context2, companion3.getWidgetHeight(context2, this.mAppWidgetId)))) || size > 1;
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<Bitmap> addWidget(boolean isDarkMode, int targetPageCount) {
        int size;
        boolean z;
        Bitmap bitmap;
        ArrayList arrayList = new ArrayList();
        List<Bitmap> bitmapList = CacheFileManager.INSTANCE.getInstance().getBitmapList(this.mUuid, isDarkMode);
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= targetPageCount) {
                break;
            }
            if (i == 0) {
                this.isAddLine = CacheFileManager.INSTANCE.getInstance().isListPageMode(this.mUuid);
            }
            List<Bitmap> list = bitmapList;
            if (list == null || list.isEmpty()) {
                CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
                Bitmap cacheThumbnailFile = WidgetUtils.INSTANCE.getCacheThumbnailFile(companion.getInstance().getThumbnailPath(this.mUuid, i, isDarkMode));
                if (i == 0) {
                    this.isAddLine = this.isAddLine && companion.getInstance().isNextPage(this.mUuid);
                }
                if (cacheThumbnailFile != null) {
                    arrayList2.add(cacheThumbnailFile);
                }
                bitmap = cacheThumbnailFile;
            } else {
                if (i == 0) {
                    this.isAddLine = this.isAddLine && bitmapList.size() > 1;
                }
                bitmap = i < bitmapList.size() ? bitmapList.get(i) : null;
            }
            arrayList.add(addWidgetWithBitmap(bitmap));
            i++;
        }
        WidgetUtils.Companion companion2 = WidgetUtils.INSTANCE;
        Context context = this.mContext;
        int iDipToPixels = (int) companion2.dipToPixels(context, companion2.getWidgetHeight(context, this.mAppWidgetId));
        List<Bitmap> list2 = bitmapList;
        if (list2 == null || list2.isEmpty()) {
            size = arrayList2.size();
            bitmapList = arrayList2;
        } else {
            size = bitmapList.size();
        }
        if (size == 1) {
            Bitmap bitmap2 = bitmapList.get(0);
            Intrinsics.checkNotNull(bitmap2);
            if (bitmap2.getHeight() < iDipToPixels) {
                z = size > 1;
            }
        }
        this.isViewMore = z;
        return arrayList;
    }

    private final Bitmap addWidgetWithBitmap(Bitmap source) {
        Runtime runtime;
        if (source == null) {
            WidgetLogger.INSTANCE.m5157e(TAG, "get bitmap fail");
            return null;
        }
        try {
            runtime = Runtime.getRuntime();
        } catch (Exception e) {
            WidgetLogger.INSTANCE.m5158e(TAG, e.getMessage(), e);
        } catch (OutOfMemoryError e2) {
            WidgetLogger.INSTANCE.m5158e(TAG, e2.getMessage(), e2);
        }
        if (runtime.maxMemory() * 0.9f >= runtime.totalMemory() - runtime.freeMemory()) {
            WidgetLogger.m5154d(TAG, "widgetOK " + this.mAppWidgetId);
            return getBitmap(source);
        }
        WidgetLogger.INSTANCE.m5157e(TAG, "widget " + this.mAppWidgetId + " low memory - load fail");
        return null;
    }

    private final Bitmap getBitmap(Bitmap bitmap) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        int i = displayMetrics.densityDpi;
        int i2 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        int i5 = (int) (i2 * i4 * 4 * 2.0f * 0.3f);
        int height = bitmap.getHeight() * bitmap.getWidth() * 4;
        int width = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        int allocationByteCount = bitmap.getAllocationByteCount();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i5, i2, "bitmapSize# maxBitmapBytes: ", ", screenWH: ", " - ");
        AbstractC2821a.m2235z(sbM1173s, i4, i, ", dip: ", ", ratio: 0.3, original: ");
        AbstractC2821a.m2235z(sbM1173s, width, height2, "x", ", size: ");
        sbM1173s.append(allocationByteCount);
        sbM1173s.append(", byte: ");
        sbM1173s.append(height);
        WidgetLogger.m5154d(TAG, sbM1173s.toString());
        if (height <= i5) {
            return bitmap;
        }
        double dSqrt = Math.sqrt(((double) i5) / ((double) height));
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.max(1, (int) (((double) bitmap.getWidth()) * dSqrt)), Math.max(1, (int) (((double) bitmap.getHeight()) * dSqrt)), true);
        int height3 = bitmapCreateScaledBitmap.getHeight() * bitmapCreateScaledBitmap.getWidth() * 4;
        int width2 = bitmapCreateScaledBitmap.getWidth();
        int height4 = bitmapCreateScaledBitmap.getHeight();
        int allocationByteCount2 = bitmapCreateScaledBitmap.getAllocationByteCount();
        StringBuilder sbM1173s2 = AbstractC0622a.m1173s(width2, height4, "bitmapSize# scaled: ", "x", ", size: ");
        sbM1173s2.append(allocationByteCount2);
        sbM1173s2.append(", bytes: ");
        sbM1173s2.append(height3);
        WidgetLogger.m5154d(TAG, sbM1173s2.toString());
        return bitmapCreateScaledBitmap;
    }

    private final List<Bitmap> getTextOnlyBitmap(int targetIndex, int widgetWidth, boolean isDarkMode, int orientation) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < targetIndex) {
            int i2 = widgetWidth;
            boolean z = isDarkMode;
            int i4 = orientation;
            String strValueOf = String.valueOf(CacheFileManager.INSTANCE.getInstance().getTextOnlyThumbnailPath(this.mUuid, i, z, i4, i2));
            if (TextUtils.isEmpty(strValueOf)) {
                WidgetLogger.m5154d(TAG, "addTextOnlyWidget: error getBitmap from idx, path: " + i + " " + strValueOf);
            } else {
                Bitmap cacheThumbnailFile = WidgetUtils.INSTANCE.getCacheThumbnailFile(strValueOf);
                if (cacheThumbnailFile != null) {
                    WidgetLogger.m5154d(TAG, "addTextOnlyWidget: add source, width: " + cacheThumbnailFile.getWidth() + " height: " + cacheThumbnailFile.getHeight());
                    arrayList.add(cacheThumbnailFile);
                }
            }
            i++;
            isDarkMode = z;
            orientation = i4;
            widgetWidth = i2;
        }
        return arrayList;
    }

    @Nullable
    public final List<Bitmap> createContent(boolean isDarkMode) {
        CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
        int pageCount = companion.getInstance().getPageCount(this.mUuid);
        if (pageCount > 2) {
            pageCount = 2;
        }
        StringBuilder sbM2226q = AbstractC2821a.m2226q("createContent#", this.mAppWidgetId, ", isDarkMode: ", isDarkMode, ", page: ");
        sbM2226q.append(pageCount);
        WidgetLogger.m5155i(TAG, sbM2226q.toString());
        return companion.getInstance().isTextOnlyNote(this.mUuid) ? addTextOnlyWidget(isDarkMode, pageCount) : addWidget(isDarkMode, pageCount);
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* JADX INFO: renamed from: getShape-nwm-oUQ, reason: not valid java name */
    public final Shape m22143getShapenwmoUQ(int shapeBG, boolean backgroundOnOff, int size) {
        return (AppWidgetSize.m21550equalsimpl0(size, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) && backgroundOnOff) ? shapeBG != 1 ? shapeBG != 2 ? shapeBG != 3 ? shapeBG != 4 ? Shape.None : Shape.RightSpeechBalloon : Shape.LeftSpeechBalloon : Shape.LeftLeaf : Shape.RightLeaf : Shape.None;
    }

    @Nullable
    public final String getTitle(@Nullable NotesDocumentEntity mainListEntry) {
        SpenSdkInitializer.initialize(this.mContext);
        SpenComposerSdkInitializer.initialize(this.mContext);
        if (mainListEntry != null) {
            return mainListEntry.getTitle();
        }
        return null;
    }

    public final boolean getViewMore() {
        CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
        return companion.getInstance().isListPageMode(this.mUuid) ? this.isViewMore && companion.getInstance().getPageCount(this.mUuid) > 2 : this.isViewMore && companion.getInstance().getPageCount(this.mUuid) >= 2;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: isAddLine, reason: from getter */
    public final boolean getIsAddLine() {
        return this.isAddLine;
    }

    public final boolean isBitmapNull(@Nullable List<Bitmap> bitmaps) {
        return bitmaps == null || bitmaps.isEmpty() || bitmaps.get(0) == null;
    }

    /* JADX INFO: renamed from: isViewMore, reason: from getter */
    public final boolean getIsViewMore() {
        return this.isViewMore;
    }

    public final void setAddLine(boolean z) {
        this.isAddLine = z;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setViewMore(boolean z) {
        this.isViewMore = z;
    }

    public final void setWidth(int i) {
        this.width = i;
    }
}
