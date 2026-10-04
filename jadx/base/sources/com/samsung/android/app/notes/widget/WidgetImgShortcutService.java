package com.samsung.android.app.notes.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.content.ContextCompat;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.theme.ThemeInfo;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetImgShortcutService;", "Landroid/widget/RemoteViewsService;", "<init>", "()V", "onGetViewFactory", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ShortcutViewFactory", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetImgShortcutService extends RemoteViewsService {
    private static final float SHORTCUT_WIDTH_RATIO = 1.5f;

    @NotNull
    private static final String TAG = "WidgetImgShortcutService";
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001a\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u001a\u0010!\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010#\u001a\u00020\u0014H\u0016J\b\u0010$\u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetImgShortcutService$ShortcutViewFactory;", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", "mContext", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "<init>", "(Landroid/content/Context;Landroid/content/Intent;)V", "mAppWidgetId", "", "mUuid", "", "mFilePath", "mTitle", "onCreate", "", "onDataSetChanged", "onDestroy", "getCount", "getViewAt", "Landroid/widget/RemoteViews;", "position", "setFillIntent", "remoteViews", "createThumbnail", "isDarkMode", "", "getBitmapList", "", "Landroid/graphics/Bitmap;", "addBitmap", "thumbnailPath", "addEmptyBitmap", "addWidgetContent", "thumbnail", "getLoadingView", "getViewTypeCount", "getItemId", "", "hasStableIds", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nWidgetImgShortcutService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetImgShortcutService.kt\ncom/samsung/android/app/notes/widget/WidgetImgShortcutService$ShortcutViewFactory\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,214:1\n1#2:215\n*E\n"})
    public static final class ShortcutViewFactory implements RemoteViewsService.RemoteViewsFactory {
        public static final int $stable = 8;
        private final int mAppWidgetId;

        @NotNull
        private final Context mContext;

        @Nullable
        private final String mFilePath;

        @Nullable
        private final String mTitle;

        @Nullable
        private final String mUuid;

        public ShortcutViewFactory(@NotNull Context mContext, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.mContext = mContext;
            int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, 0);
            this.mAppWidgetId = intExtra;
            String stringExtra = intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID);
            this.mUuid = stringExtra;
            this.mFilePath = intent.getStringExtra(WidgetConstant.EXTRA_KEY_FILE_PATH);
            this.mTitle = intent.getStringExtra(WidgetConstant.EXTRA_KEY_TITLE);
            WidgetLogger.m5154d(WidgetImgShortcutService.TAG, "ShortcutViewFactory# widget id " + intExtra + " , uuid : " + WidgetLogger.INSTANCE.getEncode(String.valueOf(stringExtra)));
        }

        private final void addBitmap(RemoteViews remoteViews, String thumbnailPath) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = 4;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(thumbnailPath, options);
            addWidgetContent(remoteViews, bitmapDecodeFile);
            if (bitmapDecodeFile == null || bitmapDecodeFile.isRecycled()) {
                return;
            }
            bitmapDecodeFile.recycle();
        }

        private final void addEmptyBitmap(RemoteViews remoteViews) {
            CacheFileManager companion = CacheFileManager.INSTANCE.getInstance();
            if (companion == null || companion.isDoneState(String.valueOf(this.mUuid))) {
                addWidgetContent(remoteViews, null);
                WidgetLogger.m5154d(WidgetImgShortcutService.TAG, "addEmptyBitmap#");
            }
        }

        private final void addWidgetContent(RemoteViews remoteViews, Bitmap thumbnail) {
            Bitmap bitmapCreateBitmap;
            if (thumbnail == null || thumbnail.getWidth() <= 0 || thumbnail.getHeight() <= 0) {
                bitmapCreateBitmap = null;
            } else {
                WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
                Context context = this.mContext;
                int iDipToPixels = (int) (companion.dipToPixels(context, companion.getWidgetWidth(context, this.mAppWidgetId)) * 1.5f);
                int height = (thumbnail.getHeight() * iDipToPixels) / thumbnail.getWidth();
                if (height <= 0 || iDipToPixels <= 0) {
                    WidgetLogger.INSTANCE.m5157e(WidgetImgShortcutService.TAG, "addWidgetContent# createBitmap, the width or height of adjustedBitmap are <= 0");
                    return;
                }
                bitmapCreateBitmap = Bitmap.createBitmap(iDipToPixels, height, Bitmap.Config.ARGB_8888);
                new Canvas(bitmapCreateBitmap).drawBitmap(thumbnail, new Rect(0, 0, thumbnail.getWidth(), thumbnail.getHeight()), new Rect(0, 0, iDipToPixels, height), new Paint());
                WidgetLogger.m5154d(WidgetImgShortcutService.TAG, "addWidgetContent# size: " + iDipToPixels + " x " + height);
            }
            RemoteViews remoteViews2 = new RemoteViews(this.mContext.getPackageName(), C11391R.layout.widget_shortcut_content);
            remoteViews2.setImageViewBitmap(C11391R.id.widget_img_shortcut_img, bitmapCreateBitmap);
            remoteViews.addView(C11391R.id.widget_content_layout, remoteViews2);
        }

        private final void createThumbnail(RemoteViews remoteViews, boolean isDarkMode) {
            List<Bitmap> bitmapList = getBitmapList(isDarkMode);
            if (bitmapList != null && !bitmapList.isEmpty()) {
                Bitmap bitmap = bitmapList.get(0);
                if (bitmap != null) {
                    addWidgetContent(remoteViews, bitmap);
                    return;
                } else {
                    addEmptyBitmap(remoteViews);
                    return;
                }
            }
            CacheFileManager companion = CacheFileManager.INSTANCE.getInstance();
            String thumbnailPath = companion != null ? companion.getThumbnailPath(String.valueOf(this.mUuid), 0, isDarkMode) : null;
            if (TextUtils.isEmpty(thumbnailPath) || !AbstractC2322a.m1607A(thumbnailPath)) {
                addEmptyBitmap(remoteViews);
            } else {
                addBitmap(remoteViews, thumbnailPath);
            }
        }

        private final List<Bitmap> getBitmapList(boolean isDarkMode) {
            String str = this.mUuid;
            if (str != null) {
                CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
                CacheFileManager companion2 = companion.getInstance();
                Intrinsics.checkNotNull(companion2);
                if (companion2.isTextOnlyNote(str)) {
                    CacheFileManager companion3 = companion.getInstance();
                    Intrinsics.checkNotNull(companion3);
                    Context context = this.mContext;
                    String str2 = this.mUuid;
                    int i = this.mAppWidgetId;
                    WidgetUtils.Companion companion4 = WidgetUtils.INSTANCE;
                    return companion3.captureTextOnlyBitmap(context, str2, i, ((int) companion4.dipToPixels(context, companion4.getWidgetWidth(context, i))) * 2, isDarkMode, true, (64 & 64) != 0 ? BaseWidgetConstant.WIDGET_SINGLE_PROVIDER_NAME : null);
                }
            }
            CacheFileManager companion5 = CacheFileManager.INSTANCE.getInstance();
            Intrinsics.checkNotNull(companion5);
            return companion5.getBitmapList(String.valueOf(this.mUuid), isDarkMode);
        }

        private final void setFillIntent(RemoteViews remoteViews) {
            Intent intent = new Intent();
            intent.putExtra("type", 1);
            remoteViews.setOnClickFillInIntent(C11391R.id.widget_content, intent);
            remoteViews.setOnClickFillInIntent(C11391R.id.widget_content_layout, intent);
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
            WidgetLogger.m5155i(WidgetImgShortcutService.TAG, "getLoadingView# " + this.mAppWidgetId);
            ThemeInfo themeInfo = new ThemeInfo(this.mContext, this.mAppWidgetId);
            CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
            CacheFileManager companion2 = companion.getInstance();
            Boolean boolValueOf = companion2 != null ? Boolean.valueOf(companion2.hasBackgroundImage(String.valueOf(this.mUuid))) : null;
            Intrinsics.checkNotNull(boolValueOf);
            boolean zBooleanValue = boolValueOf.booleanValue();
            WidgetUtils.Companion companion3 = WidgetUtils.INSTANCE;
            Context context = this.mContext;
            CacheFileManager companion4 = companion.getInstance();
            Integer numValueOf = companion4 != null ? Integer.valueOf(companion4.getPageColor(String.valueOf(this.mUuid))) : null;
            Intrinsics.checkNotNull(numValueOf);
            boolean zIsWidgetTitleDarkThemeColor = companion3.isWidgetTitleDarkThemeColor(context, numValueOf.intValue(), zBooleanValue, themeInfo.isDarkMode());
            RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), C11391R.layout.widget_shortcut_item_loading);
            if (!TextUtils.isEmpty(this.mTitle) && Build.VERSION.SDK_INT >= 31) {
                remoteViews.setViewLayoutMargin(C11391R.id.widget_shortcut_item_text_loading, 1, this.mContext.getResources().getDimension(C11391R.dimen.widget_is_title_shortcut_loading_top_margin) / this.mContext.getResources().getDisplayMetrics().density, 1);
                remoteViews.setViewLayoutMargin(C11391R.id.widget_shortcut_item_text_loading, 3, this.mContext.getResources().getDimension(C11391R.dimen.widget_is_title_shortcut_loading_bottom_margin) / this.mContext.getResources().getDisplayMetrics().density, 1);
            }
            if (zIsWidgetTitleDarkThemeColor) {
                remoteViews.setTextColor(C11391R.id.widget_shortcut_item_text_loading, ContextCompat.getColor(this.mContext, C11391R.color.widget_text_loading_color_white));
                return remoteViews;
            }
            remoteViews.setTextColor(C11391R.id.widget_shortcut_item_text_loading, ContextCompat.getColor(this.mContext, C11391R.color.widget_text_loading_color_black));
            return remoteViews;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        @NotNull
        public RemoteViews getViewAt(int position) {
            CacheFileManager companion;
            CacheFileManager companion2;
            CacheFileManager companion3;
            int i = this.mAppWidgetId;
            WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
            WidgetLogger.m5155i(WidgetImgShortcutService.TAG, "getViewAt# start " + i + ", uuid: " + widgetLogger.getEncode(String.valueOf(this.mUuid)));
            RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), C11391R.layout.widget_shortcut_item);
            if (!SpenSdkInitializer.initialize(this.mContext)) {
                widgetLogger.m5157e(WidgetImgShortcutService.TAG, "getViewAt# fail to init Spen");
                return remoteViews;
            }
            CacheFileManager.Companion companion4 = CacheFileManager.INSTANCE;
            CacheFileManager companion5 = companion4.getInstance();
            if (companion5 != null && !companion5.isInitialized() && (companion3 = companion4.getInstance()) != null) {
                companion3.init(this.mContext);
            }
            CacheFileManager companion6 = companion4.getInstance();
            if (((companion6 != null && !companion6.isValidFiles(String.valueOf(this.mUuid))) || ((companion = companion4.getInstance()) != null && !companion.isCreateWidgetState(this.mContext, String.valueOf(this.mUuid), this.mAppWidgetId))) && (companion2 = companion4.getInstance()) != null && companion2.isCacheFilesCleared(this.mContext, String.valueOf(this.mUuid))) {
                CacheFileManager companion7 = companion4.getInstance();
                if (companion7 != null) {
                    companion7.createCacheInfo(this.mContext, String.valueOf(this.mUuid), String.valueOf(this.mFilePath), this.mAppWidgetId);
                }
                widgetLogger.m5157e(WidgetImgShortcutService.TAG, "getViewAt# wait cache loading " + this.mAppWidgetId);
                return getLoadingView();
            }
            remoteViews.removeAllViews(C11391R.id.widget_content_layout);
            ThemeInfo themeInfo = new ThemeInfo(this.mContext, this.mAppWidgetId);
            CacheFileManager companion8 = companion4.getInstance();
            Boolean boolValueOf = companion8 != null ? Boolean.valueOf(companion8.hasBackgroundImage(String.valueOf(this.mUuid))) : null;
            Intrinsics.checkNotNull(boolValueOf);
            boolean zBooleanValue = boolValueOf.booleanValue();
            WidgetUtils.Companion companion9 = WidgetUtils.INSTANCE;
            Context context = this.mContext;
            CacheFileManager companion10 = companion4.getInstance();
            Integer numValueOf = companion10 != null ? Integer.valueOf(companion10.getPageColor(String.valueOf(this.mUuid))) : null;
            Intrinsics.checkNotNull(numValueOf);
            createThumbnail(remoteViews, companion9.isWidgetBgDarkThemeColor(context, numValueOf.intValue(), zBooleanValue, themeInfo.isDarkMode()));
            setFillIntent(remoteViews);
            WidgetLogger.m5155i(WidgetImgShortcutService.TAG, "getViewAt# end " + this.mAppWidgetId);
            return remoteViews;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public boolean hasStableIds() {
            return false;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onCreate() {
            WidgetLogger.m5155i(WidgetImgShortcutService.TAG, "onCreate# " + this.mAppWidgetId);
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDataSetChanged() {
            WidgetLogger.m5155i(WidgetImgShortcutService.TAG, "onDataSetChanged# " + this.mAppWidgetId);
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDestroy() {
            WidgetLogger.m5155i(WidgetImgShortcutService.TAG, "onDestroy# " + this.mAppWidgetId);
        }
    }

    @Override // android.widget.RemoteViewsService
    @NotNull
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        WidgetLogger.m5155i(TAG, "onGetViewFactory");
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new ShortcutViewFactory(applicationContext, intent);
    }
}
