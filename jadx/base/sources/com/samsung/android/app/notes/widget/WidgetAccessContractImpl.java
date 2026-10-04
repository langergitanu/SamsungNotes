package com.samsung.android.app.notes.widget;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0016J(\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016JP\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J \u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0016J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0016J&\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001f2\u0006\u0010\u001b\u001a\u00020\tH\u0016J \u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010%\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetAccessContractImpl;", "Lcom/samsung/android/support/senl/nt/base/common/access/widgetaccess/WidgetAccessContract;", "<init>", "()V", "sendUpdateUuidWidgetBroadcast", "", "context", "Landroid/content/Context;", "uuid", "", "sendUpdateUuidListWidgetBroadcast", "uuidList", "", "sendPickWidgetBroadcast", "filePath", "widgetId", "", "sendDeleteUuidWidgetBroadcast", "sendDeleteDummyWidgetBroadcast", "transparency", "backgroundColor", "darkMode", "matchSetting", "", "backgroundShape", "backgroundOnOff", "sendUpdateWidgetSettingBroadcast", "action", "sendUpdateUuidWidgetListSettingBroadcast", "sendDocumentDeletedBroadcast", "docUuids", "", "sendConvertWidgetBroadcast", "oldUuid", "newUuid", "sendUpdateAllWidgetBroadcast", "getWidgetUuids", "sendUpdateWidgetCacheDoneBroadcast", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetAccessContractImpl implements WidgetAccessContract {
    public static final int $stable = 0;

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    @NotNull
    public List<String> getWidgetUuids(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<String> widgetUuidList = AppWidgetUtils.getWidgetUuidList(context);
        Intrinsics.checkNotNull(widgetUuidList, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        return widgetUuidList;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    public void sendConvertWidgetBroadcast(@NotNull Context context, @NotNull String oldUuid, @NotNull String newUuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(oldUuid, "oldUuid");
        Intrinsics.checkNotNullParameter(newUuid, "newUuid");
        WidgetBroadcast.sendConvertWidgetBroadcast(context, oldUuid, newUuid);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    public void sendDeleteDummyWidgetBroadcast(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WidgetBroadcast.sendDeleteDummyWidgetBroadcast(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    public void sendDeleteUuidWidgetBroadcast(@NotNull Context context, @NotNull List<String> uuidList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        WidgetBroadcast.sendDeleteUUIDWidgetBroadcast(context, uuidList);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    public void sendDocumentDeletedBroadcast(@NotNull Context context, @NotNull Collection<String> docUuids, @NotNull String action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(docUuids, "docUuids");
        Intrinsics.checkNotNullParameter(action, "action");
        WidgetBroadcast.sendDocumentDeletedBroadcast(context, docUuids, action);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    public void sendPickWidgetBroadcast(@NotNull Context context, @NotNull String uuid, @NotNull String filePath, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        WidgetBroadcast.INSTANCE.sendPickWidgetBroadcast(context, uuid, filePath, widgetId);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    public void sendUpdateAllWidgetBroadcast(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WidgetBroadcast.sendUpdateAllWidgetBroadcast(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    public void sendUpdateUuidListWidgetBroadcast(@NotNull Context context, @NotNull List<String> uuidList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        WidgetBroadcast.sendUpdateUUIDListWidgetBroadcast(context, uuidList);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    public void sendUpdateUuidWidgetBroadcast(@NotNull Context context, @Nullable String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        WidgetBroadcast.sendUpdateUUIDWidgetBroadcast(context, uuid);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    public void sendUpdateUuidWidgetListSettingBroadcast(@NotNull Context context, @NotNull String uuid, @NotNull String action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(action, "action");
        WidgetBroadcast.sendUpdateUUIDWidgetListSettingBroadcast(context, uuid, action);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    public void sendUpdateWidgetCacheDoneBroadcast(@NotNull Context context, int widgetId, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        WidgetBroadcast.INSTANCE.sendUpdateWidgetCacheDoneBroadcast(context, widgetId, uuid);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    public void sendUpdateWidgetSettingBroadcast(@NotNull Context context, @NotNull String uuid, @NotNull String action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(action, "action");
        WidgetBroadcast.sendUpdateWidgetSettingBroadcast(context, uuid, action);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract
    public void sendPickWidgetBroadcast(@NotNull Context context, @NotNull String uuid, int widgetId, int transparency, int backgroundColor, int darkMode, boolean matchSetting, int backgroundShape, boolean backgroundOnOff) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        WidgetBroadcast.sendPickWidgetBroadcast$default(context, uuid, widgetId, transparency, null, backgroundColor, darkMode, matchSetting, backgroundShape, backgroundOnOff, 16, null);
    }
}
