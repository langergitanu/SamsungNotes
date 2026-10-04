package com.samsung.android.app.notes.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.theme.ThemeInfo;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.HomeScreenUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetService;", "Landroid/widget/RemoteViewsService;", "<init>", "()V", "onGetViewFactory", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "MemoViewsFactory", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetService extends RemoteViewsService {
    public static final int MAXIMUM_BITMAP_SIZE = 157286400;
    public static final int MB_SIZE = 1048576;

    @NotNull
    private static final String TAG = "WidgetService";
    private static final float WIDGET_QUALITY_RATIO = 0.7f;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\"\u001a\u00020#H\u0002J(\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J(\u0010*\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\tH\u0002J.\u0010,\u001a\b\u0012\u0004\u0012\u00020#0-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\tH\u0002J(\u00101\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\tH\u0002J:\u00102\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\b\u00103\u001a\u0004\u0018\u00010#2\u0006\u00104\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u00068"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetService$MemoViewsFactory;", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", "mContext", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "<init>", "(Landroid/content/Context;Landroid/content/Intent;)V", "mAppWidgetId", "", "mFilePath", "", "mUuid", "mTitle", "isViewMore", "", "onCreate", "", "onDataSetChanged", "onDestroy", "getCount", "getItemId", "", "position", "hasStableIds", "getViewAt", "Landroid/widget/RemoteViews;", "setFillIntent", "remoteViews", "setContentDescription", "createContent", "getLoadingView", "getViewTypeCount", "addWidgetContent", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "addPageDivider", "isAddLine", "isDarkMode", "themeInfo", "Lcom/samsung/android/app/notes/widget/theme/ThemeInfo;", "addTextOnlyWidget", "targetPageCount", "getTextOnlyBitmap", "", "targetIndex", "widgetWidth", "orientation", "addWidget", "addWidgetWithBitmap", "source", NotesConstants.KEY_CALLER, "viewMoreRemoteView", "getViewMoreRemoteView", "()Landroid/widget/RemoteViews;", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class MemoViewsFactory implements RemoteViewsService.RemoteViewsFactory {
        public static final int $stable = 8;
        private boolean isViewMore;
        private final int mAppWidgetId;

        @NotNull
        private final Context mContext;

        @Nullable
        private final String mFilePath;

        @Nullable
        private final String mTitle;

        @Nullable
        private final String mUuid;

        public MemoViewsFactory(@NotNull Context mContext, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.mContext = mContext;
            int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, 0);
            this.mAppWidgetId = intExtra;
            this.mFilePath = intent.getStringExtra(WidgetConstant.EXTRA_KEY_FILE_PATH);
            String stringExtra = intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID);
            this.mUuid = stringExtra;
            this.mTitle = intent.getStringExtra(WidgetConstant.EXTRA_KEY_TITLE);
            this.isViewMore = true;
            WidgetLogger.m5154d(WidgetService.TAG, "MemoViewsFactory.constructor : widget id " + intExtra + " , uuid : " + WidgetLogger.INSTANCE.getEncode(String.valueOf(stringExtra)));
        }

        private final void addPageDivider(boolean isAddLine, boolean isDarkMode, ThemeInfo themeInfo, RemoteViews remoteViews) {
            if (isAddLine) {
                RemoteViews remoteViews2 = new RemoteViews(this.mContext.getPackageName(), C11391R.layout.widget_page_line);
                int color = ((themeInfo.getMIsMatchWithDarkMode() || themeInfo.getMTransparency() != 100) && isDarkMode) ? this.mContext.getResources().getColor(C11391R.color.widget_page_stroke_dark_color, null) : this.mContext.getResources().getColor(C11391R.color.widget_page_stroke_color, null);
                remoteViews.addView(C11391R.id.widget_content, remoteViews2);
                remoteViews2.setInt(C11391R.id.background, BaseWidgetConstant.SET_COLOR_FILTER, color);
            }
        }

        private final void addTextOnlyWidget(RemoteViews remoteViews, ThemeInfo themeInfo, boolean isDarkMode, int targetPageCount) {
            int widgetOrientationPref = BaseWidgetPreferenceManager.INSTANCE.getWidgetOrientationPref(this.mAppWidgetId);
            WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
            Context context = this.mContext;
            int iDipToPixels = (int) companion.dipToPixels(context, companion.getWidgetWidth(context, this.mAppWidgetId));
            List<Bitmap> textOnlyBitmap = getTextOnlyBitmap(targetPageCount, iDipToPixels, isDarkMode, widgetOrientationPref);
            if (textOnlyBitmap == null || textOnlyBitmap.isEmpty()) {
                WidgetLogger.INSTANCE.m5157e(WidgetService.TAG, "addTextOnlyWidget# capture new bitmap");
                textOnlyBitmap = CacheFileManager.INSTANCE.getInstance().captureTextOnlyBitmap(this.mContext, String.valueOf(this.mUuid), this.mAppWidgetId, iDipToPixels, isDarkMode, false, (64 & 64) != 0 ? BaseWidgetConstant.WIDGET_SINGLE_PROVIDER_NAME : null);
            } else {
                WidgetLogger.INSTANCE.m5157e(WidgetService.TAG, "addTextOnlyWidget# get cache bitmap");
            }
            List<Bitmap> list = textOnlyBitmap;
            if (list == null || list.isEmpty()) {
                WidgetLogger.INSTANCE.m5157e(WidgetService.TAG, "addTextOnlyWidget# textOnly fail capture");
                return;
            }
            int size = list.size();
            int i = 0;
            while (i < size) {
                addWidgetWithBitmap(remoteViews, themeInfo, isDarkMode, i == 0 && CacheFileManager.INSTANCE.getInstance().isListPageMode(String.valueOf(this.mUuid)) && list.size() > 1, list.get(i), "addTextOnlyWidget");
                i++;
            }
            CacheFileManager companion2 = CacheFileManager.INSTANCE.getInstance();
            Context context2 = this.mContext;
            String str = this.mUuid;
            companion2.saveTextOnlyData(context2, str, list, str, isDarkMode, iDipToPixels, widgetOrientationPref);
            WidgetUtils.Companion companion3 = WidgetUtils.INSTANCE;
            Context context3 = this.mContext;
            this.isViewMore = (size == 1 && list.get(0).getHeight() >= ((int) companion3.dipToPixels(context3, companion3.getWidgetHeight(context3, this.mAppWidgetId)))) || size > 1;
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00c8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void addWidget(RemoteViews remoteViews, ThemeInfo themeInfo, boolean isDarkMode, int targetPageCount) {
            int size;
            boolean z;
            Bitmap cacheThumbnailFile;
            boolean z2;
            List<Bitmap> bitmapList = CacheFileManager.INSTANCE.getInstance().getBitmapList(String.valueOf(this.mUuid), isDarkMode);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                if (i >= targetPageCount) {
                    break;
                }
                boolean z3 = i == 0 && CacheFileManager.INSTANCE.getInstance().isListPageMode(String.valueOf(this.mUuid));
                if (bitmapList == null || bitmapList.isEmpty()) {
                    CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
                    cacheThumbnailFile = WidgetUtils.INSTANCE.getCacheThumbnailFile(companion.getInstance().getThumbnailPath(String.valueOf(this.mUuid), i, isDarkMode));
                    z2 = z3 && companion.getInstance().isNextPage(String.valueOf(this.mUuid));
                    if (cacheThumbnailFile != null) {
                        arrayList.add(cacheThumbnailFile);
                    }
                } else {
                    z2 = z3 && bitmapList.size() > 1;
                    cacheThumbnailFile = i < bitmapList.size() ? bitmapList.get(i) : null;
                }
                boolean z4 = z2;
                if (remoteViews != null) {
                    addWidgetWithBitmap(remoteViews, themeInfo, isDarkMode, z4, cacheThumbnailFile, "addWidget");
                }
                i++;
            }
            WidgetUtils.Companion companion2 = WidgetUtils.INSTANCE;
            Context context = this.mContext;
            int iDipToPixels = (int) companion2.dipToPixels(context, companion2.getWidgetHeight(context, this.mAppWidgetId));
            if (bitmapList == null || bitmapList.isEmpty()) {
                size = arrayList.size();
                bitmapList = arrayList;
            } else {
                size = bitmapList.size();
            }
            if (size == 1) {
                Bitmap bitmap = bitmapList.get(0);
                Intrinsics.checkNotNull(bitmap);
                if (bitmap.getHeight() < iDipToPixels) {
                    z = size > 1;
                }
            }
            this.isViewMore = z;
        }

        private final void addWidgetContent(RemoteViews remoteViews, Bitmap bitmap) {
            RemoteViews remoteViews2 = new RemoteViews(this.mContext.getPackageName(), C11391R.layout.widget_item_col_img);
            remoteViews2.setImageViewBitmap(C11391R.id.content_image, getBitmap(bitmap));
            remoteViews.addView(C11391R.id.widget_content, remoteViews2);
        }

        private final void addWidgetWithBitmap(RemoteViews remoteViews, ThemeInfo themeInfo, boolean isDarkMode, boolean isAddLine, Bitmap source, String caller) {
            if (source == null) {
                WidgetLogger.INSTANCE.m5157e(WidgetService.TAG, "get bitmap fail :  " + caller);
                return;
            }
            try {
                Runtime runtime = Runtime.getRuntime();
                if (runtime.maxMemory() * 0.9f < runtime.totalMemory() - runtime.freeMemory()) {
                    WidgetLogger.INSTANCE.m5157e(WidgetService.TAG, "widget " + this.mAppWidgetId + " low memory - load fail :  " + caller);
                    return;
                }
                addWidgetContent(remoteViews, source);
                WidgetLogger.m5154d(WidgetService.TAG, "widgetOK " + this.mAppWidgetId + ":" + caller);
                addPageDivider(isAddLine, isDarkMode, themeInfo, remoteViews);
            } catch (Exception e) {
                WidgetLogger.INSTANCE.m5158e(WidgetService.TAG, e.getMessage(), e);
            } catch (OutOfMemoryError e2) {
                WidgetLogger.INSTANCE.m5158e(WidgetService.TAG, e2.getMessage(), e2);
            }
        }

        private final boolean createContent(RemoteViews remoteViews) {
            if (TextUtils.isEmpty(this.mFilePath)) {
                WidgetLogger.INSTANCE.m5157e(WidgetService.TAG, "createContent# file path is empty");
                return false;
            }
            if (!new File(this.mFilePath).exists()) {
                WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
                widgetLogger.m5157e(WidgetService.TAG, "createContent# file is not exist. path: " + widgetLogger.getEncode(String.valueOf(this.mFilePath)));
                WidgetBroadcast.sendUpdateAllWidgetBroadcast(this.mContext);
                return false;
            }
            ThemeInfo themeInfo = new ThemeInfo(this.mContext, this.mAppWidgetId);
            CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
            int pageCount = companion.getInstance().getPageCount(String.valueOf(this.mUuid));
            if (pageCount > 2) {
                pageCount = 2;
            }
            remoteViews.removeAllViews(C11391R.id.widget_content);
            boolean zIsWidgetBgDarkThemeColor = WidgetUtils.INSTANCE.isWidgetBgDarkThemeColor(this.mContext, companion.getInstance().getPageColor(String.valueOf(this.mUuid)), companion.getInstance().hasBackgroundImage(String.valueOf(this.mUuid)), themeInfo.isDarkMode());
            StringBuilder sbM2226q = AbstractC2821a.m2226q("createContent#", this.mAppWidgetId, ", isDarkMode: ", zIsWidgetBgDarkThemeColor, ", page: ");
            sbM2226q.append(pageCount);
            WidgetLogger.m5155i(WidgetService.TAG, sbM2226q.toString());
            if (companion.getInstance().isTextOnlyNote(String.valueOf(this.mUuid))) {
                addTextOnlyWidget(remoteViews, themeInfo, zIsWidgetBgDarkThemeColor, pageCount);
                return true;
            }
            addWidget(remoteViews, themeInfo, zIsWidgetBgDarkThemeColor, pageCount);
            return true;
        }

        private final Bitmap getBitmap(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            int iMin = (int) Math.min(this.mContext.getResources().getDisplayMetrics().widthPixels, this.mContext.getResources().getDisplayMetrics().heightPixels);
            WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
            Context context = this.mContext;
            int iDipToPixels = (int) companion.dipToPixels(context, companion.getWidgetWidth(context, this.mAppWidgetId));
            int height = DocumentPageRatio.PAGE_RATIO.getHeight(bitmap.getWidth()) * 2;
            int allocationByteCount = bitmap.getAllocationByteCount();
            if (bitmap.getHeight() > height || allocationByteCount > 157286400) {
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), height);
                Intrinsics.checkNotNullExpressionValue(bitmap, "createBitmap(...)");
            }
            if (HomeScreenUtils.INSTANCE.isCurrentCoverScreenMirroringDisplay(this.mContext) || iDipToPixels > iMin) {
                int width = (int) (bitmap.getWidth() * 0.7f);
                int height2 = (int) (bitmap.getHeight() * 0.7f);
                WidgetLogger.m5154d(WidgetService.TAG, "bitmapSize# resize " + width + "x" + height2);
                return Bitmap.createScaledBitmap(bitmap, width, height2, true);
            }
            WidgetLogger.m5154d(WidgetService.TAG, "bitmapSize# " + bitmap.getWidth() + "x" + bitmap.getHeight());
            return bitmap;
        }

        private final List<Bitmap> getTextOnlyBitmap(int targetIndex, int widgetWidth, boolean isDarkMode, int orientation) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < targetIndex) {
                int i2 = widgetWidth;
                boolean z = isDarkMode;
                int i4 = orientation;
                String strValueOf = String.valueOf(CacheFileManager.INSTANCE.getInstance().getTextOnlyThumbnailPath(String.valueOf(this.mUuid), i, z, i4, i2));
                if (TextUtils.isEmpty(strValueOf)) {
                    WidgetLogger.m5154d(WidgetService.TAG, "addTextOnlyWidget: error getBitmap from idx, path: " + i + " " + strValueOf);
                } else {
                    Bitmap cacheThumbnailFile = WidgetUtils.INSTANCE.getCacheThumbnailFile(strValueOf);
                    if (cacheThumbnailFile != null) {
                        WidgetLogger.m5154d(WidgetService.TAG, "addTextOnlyWidget: add source, width: " + cacheThumbnailFile.getWidth() + " height: " + cacheThumbnailFile.getHeight());
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

        private final RemoteViews getViewMoreRemoteView() {
            int color;
            int i;
            RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), C11391R.layout.widget_item_view_more_text);
            ThemeInfo themeInfo = new ThemeInfo(this.mContext, this.mAppWidgetId);
            CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
            int pageColor = companion.getInstance().getPageColor(String.valueOf(this.mUuid));
            if (WidgetUtils.INSTANCE.isWidgetBgDarkThemeColor(this.mContext, pageColor, companion.getInstance().hasBackgroundImage(String.valueOf(this.mUuid)), themeInfo.isDarkMode()) || pageColor == this.mContext.getResources().getColor(C11391R.color.composer_main_background_dark, null)) {
                color = ContextCompat.getColor(this.mContext, C11391R.color.widget_view_more_text_color_black_background);
                i = C11391R.drawable.widget_view_more_black_background;
            } else {
                color = ContextCompat.getColor(this.mContext, C11391R.color.widget_view_more_text_color_white_background);
                i = C11391R.drawable.widget_view_more_white_background;
            }
            remoteViews.setTextColor(C11391R.id.view_more, color);
            remoteViews.setInt(C11391R.id.view_more, BaseWidgetConstant.SET_BACKGROUND_RESOURCE, i);
            return remoteViews;
        }

        private final void setContentDescription(RemoteViews remoteViews) {
            if (TextUtils.isEmpty(this.mTitle)) {
                remoteViews.setContentDescription(C11391R.id.widget_content, this.mContext.getResources().getString(C11391R.string.widget_shortcut_to_untitled_note) + "," + this.mContext.getResources().getString(C11391R.string.widget_shortcut_open_note));
                return;
            }
            remoteViews.setContentDescription(C11391R.id.widget_content, this.mContext.getResources().getString(C11391R.string.widget_shortcut_to_title_note, this.mTitle) + "," + this.mContext.getResources().getString(C11391R.string.widget_shortcut_open_note));
        }

        private final void setFillIntent(RemoteViews remoteViews) {
            Intent intent = new Intent();
            intent.putExtra("type", 1);
            remoteViews.setOnClickFillInIntent(C11391R.id.widget_content, intent);
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getCount() {
            return 1;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        @NotNull
        public RemoteViews getLoadingView() {
            WidgetLogger.m5155i(WidgetService.TAG, "getLoadingView# " + this.mAppWidgetId);
            ThemeInfo themeInfo = new ThemeInfo(this.mContext, this.mAppWidgetId);
            CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
            boolean zIsWidgetTitleDarkThemeColor = WidgetUtils.INSTANCE.isWidgetTitleDarkThemeColor(this.mContext, companion.getInstance().getPageColor(String.valueOf(this.mUuid)), companion.getInstance().hasBackgroundImage(String.valueOf(this.mUuid)), themeInfo.isDarkMode());
            RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), C11391R.layout.widget_item_loading);
            if (!TextUtils.isEmpty(this.mTitle) && Build.VERSION.SDK_INT >= 31) {
                remoteViews.setViewLayoutMargin(C11391R.id.widget_item_text_loading, 1, this.mContext.getResources().getDimension(C11391R.dimen.widget_is_title_loading_top_margin) / this.mContext.getResources().getDisplayMetrics().density, 1);
                remoteViews.setViewLayoutMargin(C11391R.id.widget_item_text_loading, 3, this.mContext.getResources().getDimension(C11391R.dimen.widget_is_title_loading_bottom_margin) / this.mContext.getResources().getDisplayMetrics().density, 1);
            }
            if (zIsWidgetTitleDarkThemeColor) {
                remoteViews.setTextColor(C11391R.id.widget_item_text_loading, ContextCompat.getColor(this.mContext, C11391R.color.widget_text_loading_color_white));
                return remoteViews;
            }
            remoteViews.setTextColor(C11391R.id.widget_item_text_loading, ContextCompat.getColor(this.mContext, C11391R.color.widget_text_loading_color_black));
            return remoteViews;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        @NotNull
        public RemoteViews getViewAt(int position) {
            int i = this.mAppWidgetId;
            WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
            WidgetLogger.m5155i(WidgetService.TAG, "getViewAt# start " + i + " , uuid : " + widgetLogger.getEncode(String.valueOf(this.mUuid)));
            RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), C11391R.layout.widget_item);
            if (!SpenSdkInitializer.initialize(this.mContext)) {
                widgetLogger.m5157e(WidgetService.TAG, "getViewAt# fail to init Spen");
                return remoteViews;
            }
            CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
            if (!companion.getInstance().isInitialized()) {
                companion.getInstance().init(this.mContext);
            }
            if (!companion.getInstance().isValidFiles(String.valueOf(this.mUuid)) || !companion.getInstance().isCreateWidgetState(this.mContext, String.valueOf(this.mUuid), this.mAppWidgetId)) {
                companion.getInstance().createCacheInfo(this.mContext, String.valueOf(this.mUuid), String.valueOf(this.mFilePath), this.mAppWidgetId);
                widgetLogger.m5157e(WidgetService.TAG, "getViewAt# wait cache loading, WidgetId: " + this.mAppWidgetId);
                return getLoadingView();
            }
            if (!createContent(remoteViews)) {
                RemoteViews remoteViews2 = new RemoteViews(this.mContext.getPackageName(), C11391R.layout.widget_empty_view);
                remoteViews2.setOnClickFillInIntent(C11391R.id.widget_empty_cover, new Intent());
                WidgetPreferenceManager.INSTANCE.saveUpdateWidgetContentDone(this.mAppWidgetId, false);
                widgetLogger.m5157e(WidgetService.TAG, "getViewAt# end failed to create content, WidgetId: " + this.mAppWidgetId);
                return remoteViews2;
            }
            WidgetPreferenceManager.INSTANCE.saveUpdateWidgetContentDone(this.mAppWidgetId, true);
            setFillIntent(remoteViews);
            setContentDescription(remoteViews);
            if (this.isViewMore && companion.getInstance().getPageCount(String.valueOf(this.mUuid)) > 2) {
                remoteViews.addView(C11391R.id.widget_content, getViewMoreRemoteView());
            }
            WidgetLogger.m5155i(WidgetService.TAG, "getViewAt# end " + this.mAppWidgetId);
            return remoteViews;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getViewTypeCount() {
            return 2;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public boolean hasStableIds() {
            return false;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onCreate() {
            WidgetLogger.m5155i(WidgetService.TAG, "onCreate# " + this.mAppWidgetId);
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDataSetChanged() {
            WidgetLogger.m5155i(WidgetService.TAG, "onDataSetChanged# " + this.mAppWidgetId);
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDestroy() {
            WidgetLogger.m5155i(WidgetService.TAG, "onDestroy# " + this.mAppWidgetId);
        }
    }

    @Override // android.widget.RemoteViewsService
    @NotNull
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        WidgetLogger.m5155i(TAG, "onGetViewFactory");
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new MemoViewsFactory(applicationContext, intent);
    }
}
