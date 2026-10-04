package com.samsung.android.app.notes.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.pintohome.PinToHomeCompat;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetCacheInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J6\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\"\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetResolver;", "Lcom/samsung/android/support/senl/nt/composer/main/base/appwidget/IAppWidgetResolver;", "<init>", "()V", "pinToHme", "", "context", "Landroid/content/Context;", "uuid", "", "path", "isSupportedPinToHome", "", "hasWidget", "isAvailableToReferWidget", "isAvailableToAddWidget", "showWidgetMaximumToast", "showWidgetAlreadyPinToast", "createCacheInfo", "Lcom/samsung/android/support/senl/nt/composer/main/base/appwidget/IAppWidgetCacheInfo;", "filePath", "removeCacheInfo", "createThumbnail", "data", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "updateWidgetDocPath", "newPath", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetResolver implements IAppWidgetResolver {
    public static final int $stable = 0;

    @NotNull
    private static final String TAG = "WidgetResolver";

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver
    @Nullable
    public IAppWidgetCacheInfo createCacheInfo(@NotNull Context context, @NotNull String uuid, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        CacheFileManager companion = CacheFileManager.INSTANCE.getInstance();
        if (companion != null) {
            return companion.createCacheInfo(context, uuid, filePath);
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver
    public void createThumbnail(@NotNull Context context, @NotNull String uuid, @Nullable String filePath, @Nullable IAppWidgetCacheInfo data, @Nullable SpenWNote note) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        ArrayList<Integer> widgetIdList = AppWidgetUtils.INSTANCE.getWidgetIdList(context, uuid.toString());
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.capture.CacheFileManager.CacheDataInfo");
        CacheFileManager.CacheDataInfo cacheDataInfo = (CacheFileManager.CacheDataInfo) data;
        cacheDataInfo.setWidgetIdList(CollectionsKt.toMutableSet(widgetIdList));
        CacheFileManager companion = CacheFileManager.INSTANCE.getInstance();
        if (companion != null) {
            companion.createThumbnail(context, uuid, filePath, cacheDataInfo, false, note, widgetIdList);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver
    public boolean hasWidget(@NotNull Context context, @Nullable String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<String> widgetUuidList = AppWidgetUtils.getWidgetUuidList(context);
        int size = widgetUuidList.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(uuid, widgetUuidList.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver
    public boolean isAvailableToAddWidget(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return AppWidgetUtils.INSTANCE.isAvailableToAddWidget(context, uuid);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver
    public boolean isAvailableToReferWidget(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ProviderUtils.INSTANCE.isAvailableToReferWidget(context, WidgetProvider.class);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver
    public boolean isSupportedPinToHome(@NotNull Context context) {
        ActivityInfo activityInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = Build.MANUFACTURER;
        DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
        if ((companion.getInstance().isDexMode(context) && !companion.getInstance().isDexNewDexMode(context)) || !Intrinsics.areEqual("samsung", str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        try {
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            String str2 = (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) ? null : activityInfo.packageName;
            PinToHomeCompat pinToHomeCompat = PinToHomeCompat.INSTANCE;
            if (pinToHomeCompat.isPinToHomeSupportedDevice(context) && str2 != null && StringsKt.m14162r(str2, ".sec.")) {
                return pinToHomeCompat.isSatisfySecModeConditions(context);
            }
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver
    public void pinToHme(@NotNull Context context, @Nullable String uuid, @Nullable String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.m8697d(TAG, "pinToHme, try to add a widget on Homescreen :" + uuid);
        PinToHomeCompat.INSTANCE.requestPinToHome(context, uuid, path, WidgetProvider.class);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver
    public void removeCacheInfo(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        CacheFileManager companion = CacheFileManager.INSTANCE.getInstance();
        if (companion != null) {
            companion.removeCacheInfo(context, uuid);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver
    public void showWidgetAlreadyPinToast(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WidgetUtils.INSTANCE.showWidgetAlreadyPinToast(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver
    public void showWidgetMaximumToast(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WidgetUtils.Companion.showWidgetMaximumToast$default(WidgetUtils.INSTANCE, context, 0, 2, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver
    public void updateWidgetDocPath(@NotNull Context context, @NotNull String uuid, @Nullable String newPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (AppWidgetUtils.INSTANCE.updateWidgetFilePath(context, uuid, newPath)) {
            WidgetBroadcast.sendUpdateUUIDWidgetBroadcast(context, uuid);
        }
    }
}
