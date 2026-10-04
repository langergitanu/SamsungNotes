package com.samsung.android.support.senl.p148nt.composer.main.base.appwidget;

import android.content.Context;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J6\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/appwidget/IAppWidgetResolver;", "", "pinToHme", "", "context", "Landroid/content/Context;", "uuid", "", "path", "isSupportedPinToHome", "", "hasWidget", "isAvailableToReferWidget", "isAvailableToAddWidget", "showWidgetMaximumToast", "showWidgetAlreadyPinToast", "updateWidgetDocPath", "newPath", "createCacheInfo", "Lcom/samsung/android/support/senl/nt/composer/main/base/appwidget/IAppWidgetCacheInfo;", "filePath", "removeCacheInfo", "createThumbnail", "data", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IAppWidgetResolver {
    @Nullable
    IAppWidgetCacheInfo createCacheInfo(@NotNull Context context, @NotNull String uuid, @NotNull String filePath);

    void createThumbnail(@NotNull Context context, @NotNull String uuid, @Nullable String filePath, @Nullable IAppWidgetCacheInfo data, @Nullable SpenWNote note);

    boolean hasWidget(@NotNull Context context, @Nullable String uuid);

    boolean isAvailableToAddWidget(@NotNull Context context, @NotNull String uuid);

    boolean isAvailableToReferWidget(@NotNull Context context);

    boolean isSupportedPinToHome(@NotNull Context context);

    void pinToHme(@NotNull Context context, @Nullable String uuid, @Nullable String path);

    void removeCacheInfo(@NotNull Context context, @NotNull String uuid);

    void showWidgetAlreadyPinToast(@NotNull Context context);

    void showWidgetMaximumToast(@NotNull Context context);

    void updateWidgetDocPath(@NotNull Context context, @NotNull String uuid, @Nullable String newPath);
}
