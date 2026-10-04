package com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess;

import android.content.Context;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH&J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JP\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0015H&J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H&J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H&J&\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d2\u0006\u0010\u0019\u001a\u00020\u0007H&J \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/widgetaccess/WidgetAccessContract;", "", "sendUpdateUuidWidgetBroadcast", "", "context", "Landroid/content/Context;", "uuid", "", "sendUpdateUuidListWidgetBroadcast", "uuidList", "", "sendPickWidgetBroadcast", "filePath", "widgetId", "", "sendDeleteUuidWidgetBroadcast", "sendDeleteDummyWidgetBroadcast", "transparency", "backgroundColor", "darkMode", "matchSetting", "", "backgroundShape", "backgroundOnOff", "sendUpdateWidgetSettingBroadcast", "action", "sendUpdateUuidWidgetListSettingBroadcast", "sendDocumentDeletedBroadcast", "docUuids", "", "sendConvertWidgetBroadcast", "oldUuid", "newUuid", "sendUpdateAllWidgetBroadcast", "getWidgetUuids", "sendUpdateWidgetCacheDoneBroadcast", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface WidgetAccessContract {
    @NotNull
    List<String> getWidgetUuids(@NotNull Context context);

    void sendConvertWidgetBroadcast(@NotNull Context context, @NotNull String oldUuid, @NotNull String newUuid);

    void sendDeleteDummyWidgetBroadcast(@NotNull Context context);

    void sendDeleteUuidWidgetBroadcast(@NotNull Context context, @NotNull List<String> uuidList);

    void sendDocumentDeletedBroadcast(@NotNull Context context, @NotNull Collection<String> docUuids, @NotNull String action);

    void sendPickWidgetBroadcast(@NotNull Context context, @NotNull String uuid, int widgetId, int transparency, int backgroundColor, int darkMode, boolean matchSetting, int backgroundShape, boolean backgroundOnOff);

    void sendPickWidgetBroadcast(@NotNull Context context, @NotNull String uuid, @NotNull String filePath, int widgetId);

    void sendUpdateAllWidgetBroadcast(@NotNull Context context);

    void sendUpdateUuidListWidgetBroadcast(@NotNull Context context, @NotNull List<String> uuidList);

    void sendUpdateUuidWidgetBroadcast(@NotNull Context context, @Nullable String uuid);

    void sendUpdateUuidWidgetListSettingBroadcast(@NotNull Context context, @NotNull String uuid, @NotNull String action);

    void sendUpdateWidgetCacheDoneBroadcast(@NotNull Context context, int widgetId, @NotNull String uuid);

    void sendUpdateWidgetSettingBroadcast(@NotNull Context context, @NotNull String uuid, @NotNull String action);
}
