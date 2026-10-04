package com.samsung.android.support.senl.p148nt.base.common.sync;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J*\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0010H&J*\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0010H&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bH&J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u0016\u001a\u00020\tH&J\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u001a\u001a\u00020\tH&J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\u001a\u0010\u001e\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020 H&J\u001c\u0010!\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010#H&J\u0012\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&H&J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0003H&J\u0012\u0010)\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010*\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010+\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010,\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J&\u00101\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u00102\u001a\u0004\u0018\u00010\u00072\b\u00103\u001a\u0004\u0018\u00010\u0007H&J&\u00104\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u00105\u001a\u0004\u0018\u00010\u00072\b\u00106\u001a\u0004\u0018\u00010\u0007H&J\u0012\u00107\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u00010\u000eH&J\u0012\u00109\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u00010\u000eH&J\b\u0010:\u001a\u00020\tH&J \u0010;\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010<\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&H&J\b\u0010=\u001a\u00020\tH&R\u0012\u0010-\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0012\u0010/\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010.R\u0012\u00100\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010.¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/RequestSyncContract;", "", "requestSyncByModification", "", "requestSyncBackground", "requestShareBackground", "spaceId", "", "setRootServerTimestamp", "", "currentTime", "", "requestShareDelete", "context", "Landroid/content/Context;", "uuidList", "", "requestShareDeleteCoedit", "setCategoryOrderModifiedTime", "time", "getAccountGuid", "isAccountLogined", "notifyOnDocumentClosed", "requestSyncUpFirst", "docUuid", "requestSyncDownImmediately", "requestSyncForServerPolling", "requestSyncDownForServerNoteTemporarily", "noteInfo", "Lcom/samsung/android/support/senl/nt/base/common/sync/TemporalServerNoteInfo;", "requestSyncForConflictedNote", SyncDBSchema.SyncInfo.CONFLICT_STRATEGY, "", "requestServerNoteInfo", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/sync/IServerNoteInfoListener;", "stopSyncBySmartSwitch", "syncProgressListener", "Lcom/samsung/android/support/senl/nt/base/common/sync/SyncProgressListener;", "setSyncEnableByUserClick", "isEnable", "isDataNetworkAvailable", "isWiFiAvailable", "isWiFiSyncOnlyAndNotWiFiConnected", "isCoeditWiFiSyncOnlyAndNotWiFiConnected", "isSyncEnableMode", "()Z", "isAutoSyncPossible", "isDataCallNotLimitedForApp", "requestCoeditUpdateItemData", "uuid", "itemId", "requestCoeditTitleUpdate", "coeditUuid", "title", "isCoeditFeatureSupported", StateHandler.KEY_APP_STATE, "isSesAvailable", "initPreferenceMDESupported", "requestDeleteCoeditNoteDataAllAndDownload", "stopCoeditDownloadBySmartSwitch", "requestSyncWithoutCancel", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface RequestSyncContract {
    @Nullable
    String getAccountGuid(@Nullable Context context);

    void initPreferenceMDESupported();

    boolean isAccountLogined(@Nullable Context context);

    boolean isAutoSyncPossible();

    boolean isCoeditFeatureSupported(@Nullable Context appContext);

    boolean isCoeditWiFiSyncOnlyAndNotWiFiConnected(@Nullable Context context);

    boolean isDataCallNotLimitedForApp();

    boolean isDataNetworkAvailable(@Nullable Context context);

    boolean isSesAvailable(@Nullable Context appContext);

    boolean isSyncEnableMode();

    boolean isWiFiAvailable(@Nullable Context context);

    boolean isWiFiSyncOnlyAndNotWiFiConnected(@Nullable Context context);

    void notifyOnDocumentClosed();

    void requestCoeditTitleUpdate(@Nullable String spaceId, @Nullable String coeditUuid, @Nullable String title);

    void requestCoeditUpdateItemData(@Nullable String spaceId, @Nullable String uuid, @Nullable String itemId);

    void requestDeleteCoeditNoteDataAllAndDownload(@NotNull Context context, @NotNull String docUuid, @NotNull String spaceId);

    void requestServerNoteInfo(@Nullable String docUuid, @Nullable IServerNoteInfoListener listener);

    boolean requestShareBackground(@Nullable String spaceId);

    void requestShareDelete(@NotNull Context context, @Nullable String spaceId, @NotNull List<String> uuidList);

    void requestShareDeleteCoedit(@NotNull Context context, @Nullable String spaceId, @NotNull List<String> uuidList);

    boolean requestSyncBackground();

    boolean requestSyncByModification();

    void requestSyncDownForServerNoteTemporarily(@Nullable TemporalServerNoteInfo noteInfo);

    void requestSyncDownImmediately(@Nullable String docUuid);

    void requestSyncForConflictedNote(@Nullable String docUuid, int conflictStrategy);

    void requestSyncForServerPolling();

    void requestSyncUpFirst(@Nullable String docUuid);

    void requestSyncWithoutCancel();

    void setCategoryOrderModifiedTime(long time);

    void setRootServerTimestamp(long currentTime);

    void setSyncEnableByUserClick(boolean isEnable);

    void stopCoeditDownloadBySmartSwitch(@Nullable SyncProgressListener syncProgressListener);

    void stopSyncBySmartSwitch(@Nullable SyncProgressListener syncProgressListener);
}
