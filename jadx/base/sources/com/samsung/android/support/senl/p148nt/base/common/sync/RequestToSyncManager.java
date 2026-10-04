package com.samsung.android.support.senl.p148nt.base.common.sync;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToSyncManager;", "", "<init>", "()V", "requestSyncContract", "Lcom/samsung/android/support/senl/nt/base/common/sync/RequestSyncContract;", "getRequestSyncContract", "()Lcom/samsung/android/support/senl/nt/base/common/sync/RequestSyncContract;", "setRequestSyncContract", "(Lcom/samsung/android/support/senl/nt/base/common/sync/RequestSyncContract;)V", "gcsResolver", "Lcom/samsung/android/support/senl/nt/base/common/sync/GcsResolverContract;", "getGcsResolver", "()Lcom/samsung/android/support/senl/nt/base/common/sync/GcsResolverContract;", "setGcsResolver", "(Lcom/samsung/android/support/senl/nt/base/common/sync/GcsResolverContract;)V", "coeditResolver", "Lcom/samsung/android/support/senl/nt/base/common/sync/CoeditResolverContract;", "getCoeditResolver", "()Lcom/samsung/android/support/senl/nt/base/common/sync/CoeditResolverContract;", "setCoeditResolver", "(Lcom/samsung/android/support/senl/nt/base/common/sync/CoeditResolverContract;)V", "notifyOnDocumentClosed", "", "requestSyncDownForServerNoteTemporarily", "noteInfo", "Lcom/samsung/android/support/senl/nt/base/common/sync/TemporalServerNoteInfo;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RequestToSyncManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static RequestToSyncManager sInstance;

    @Nullable
    private CoeditResolverContract coeditResolver;

    @Nullable
    private GcsResolverContract gcsResolver;

    @Nullable
    private RequestSyncContract requestSyncContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fJ$\u0010\u000f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ(\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0019J(\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0019J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\fJ\u0010\u0010!\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\fJ\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\nJ\u0018\u0010$\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020&J\u001a\u0010'\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\f2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,J\u000e\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u0012J\u0010\u0010/\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u00100\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u00101\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u00102\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u00107\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u00010\u0017J\u0010\u00109\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u00010\u0017J\u0006\u0010:\u001a\u00020\nJ\u001e\u0010;\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u00103\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b5\u00104R\u0011\u00106\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b6\u00104¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToSyncManager$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToSyncManager;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToSyncManager;", "requestCoeditUpdateItemData", "", "spaceId", "", "coeditUuid", "itemId", "requestCoeditTitleUpdate", "title", "requestSyncByModification", "", "requestSyncBackground", "requestShareBackground", "requestDelete", "context", "Landroid/content/Context;", "uuidList", "", "requestDeleteCoedit", "setCategoryOrderModifiedTime", "time", "", "getAccountGuid", "requestSyncUpFirst", "docUuid", "requestSyncDownImmediately", "requestSyncWithoutCancel", "requestSyncForServerPolling", "requestSyncForConflictedNote", SyncDBSchema.SyncInfo.CONFLICT_STRATEGY, "", "requestServerNoteInfo", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/sync/IServerNoteInfoListener;", "stopSyncBySmartSwitch", "syncProgressListener", "Lcom/samsung/android/support/senl/nt/base/common/sync/SyncProgressListener;", "setSyncEnableByUserClick", "isEnable", "isDataNetworkAvailable", "isWiFiAvailable", "isWiFiSyncOnlyAndNotWiFiConnected", "isCoeditWiFiSyncOnlyAndNotWiFiConnected", "isSyncEnableMode", "()Z", "isAutoSyncPossible", "isDataCallNotLimitedForApp", "isCoeditFeatureSupported", StateHandler.KEY_APP_STATE, "isSesAvailable", "initPreferenceMDESupported", "deleteCoeditDataAllAndDownload", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void deleteCoeditDataAllAndDownload(@NotNull Context context, @NotNull String docUuid, @NotNull String spaceId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(docUuid, "docUuid");
            Intrinsics.checkNotNullParameter(spaceId, "spaceId");
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.requestDeleteCoeditNoteDataAllAndDownload(context, docUuid, spaceId);
            }
        }

        @Nullable
        public final String getAccountGuid(@Nullable Context context) {
            if (getInstance().getRequestSyncContract() == null) {
                return "";
            }
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                return requestSyncContract.getAccountGuid(context);
            }
            return null;
        }

        @NotNull
        public final synchronized RequestToSyncManager getInstance() {
            RequestToSyncManager requestToSyncManager;
            try {
                if (RequestToSyncManager.sInstance == null) {
                    RequestToSyncManager.sInstance = new RequestToSyncManager();
                }
                requestToSyncManager = RequestToSyncManager.sInstance;
                Intrinsics.checkNotNull(requestToSyncManager);
            } catch (Throwable th) {
                throw th;
            }
            return requestToSyncManager;
        }

        public final void initPreferenceMDESupported() {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.initPreferenceMDESupported();
            }
        }

        public final boolean isAutoSyncPossible() {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            return requestSyncContract != null && requestSyncContract.isAutoSyncPossible();
        }

        public final boolean isCoeditFeatureSupported(@Nullable Context appContext) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            return requestSyncContract != null && requestSyncContract.isCoeditFeatureSupported(appContext);
        }

        public final boolean isCoeditWiFiSyncOnlyAndNotWiFiConnected(@Nullable Context context) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            return requestSyncContract != null && requestSyncContract.isCoeditWiFiSyncOnlyAndNotWiFiConnected(context);
        }

        public final boolean isDataCallNotLimitedForApp() {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            return requestSyncContract != null && requestSyncContract.isDataCallNotLimitedForApp();
        }

        public final boolean isDataNetworkAvailable(@Nullable Context context) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            return requestSyncContract != null && requestSyncContract.isDataNetworkAvailable(context);
        }

        public final boolean isSesAvailable(@Nullable Context appContext) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            return requestSyncContract != null && requestSyncContract.isSesAvailable(appContext);
        }

        public final boolean isSyncEnableMode() {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            return requestSyncContract != null && requestSyncContract.isSyncEnableMode();
        }

        public final boolean isWiFiAvailable(@Nullable Context context) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            return requestSyncContract != null && requestSyncContract.isWiFiAvailable(context);
        }

        public final boolean isWiFiSyncOnlyAndNotWiFiConnected(@Nullable Context context) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            return requestSyncContract != null && requestSyncContract.isWiFiSyncOnlyAndNotWiFiConnected(context);
        }

        public final void requestCoeditTitleUpdate(@Nullable String spaceId, @Nullable String coeditUuid, @Nullable String title) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.requestCoeditTitleUpdate(spaceId, coeditUuid, title);
            }
        }

        public final void requestCoeditUpdateItemData(@Nullable String spaceId, @Nullable String coeditUuid, @Nullable String itemId) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.requestCoeditUpdateItemData(spaceId, coeditUuid, itemId);
            }
        }

        public final void requestDelete(@NotNull Context context, @Nullable String spaceId, @NotNull List<String> uuidList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uuidList, "uuidList");
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.requestShareDelete(context, spaceId, uuidList);
            }
        }

        public final void requestDeleteCoedit(@NotNull Context context, @Nullable String spaceId, @NotNull List<String> uuidList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uuidList, "uuidList");
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.requestShareDeleteCoedit(context, spaceId, uuidList);
            }
        }

        public final void requestServerNoteInfo(@Nullable String docUuid, @Nullable IServerNoteInfoListener listener) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.requestServerNoteInfo(docUuid, listener);
            }
        }

        public final boolean requestShareBackground(@Nullable String spaceId) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            return requestSyncContract != null && requestSyncContract.requestShareBackground(spaceId);
        }

        public final boolean requestSyncBackground() {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            return requestSyncContract != null && requestSyncContract.requestSyncBackground();
        }

        public final boolean requestSyncByModification() {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            return requestSyncContract != null && requestSyncContract.requestSyncByModification();
        }

        public final void requestSyncDownImmediately(@Nullable String docUuid) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.requestSyncDownImmediately(docUuid);
            }
        }

        public final void requestSyncForConflictedNote(@Nullable String docUuid, int conflictStrategy) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.requestSyncForConflictedNote(docUuid, conflictStrategy);
            }
        }

        public final void requestSyncForServerPolling() {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.requestSyncForServerPolling();
            }
        }

        public final void requestSyncUpFirst(@Nullable String docUuid) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.requestSyncUpFirst(docUuid);
            }
        }

        public final void requestSyncWithoutCancel() {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.requestSyncWithoutCancel();
            }
        }

        public final void setCategoryOrderModifiedTime(long time) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.setCategoryOrderModifiedTime(time);
            }
        }

        public final void setSyncEnableByUserClick(boolean isEnable) {
            RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
            if (requestSyncContract != null) {
                requestSyncContract.setSyncEnableByUserClick(isEnable);
            }
        }

        public final void stopSyncBySmartSwitch(@Nullable SyncProgressListener syncProgressListener) {
            if (getInstance().getRequestSyncContract() == null) {
                if (syncProgressListener != null) {
                    syncProgressListener.onEnded(1);
                }
            } else {
                RequestSyncContract requestSyncContract = getInstance().getRequestSyncContract();
                if (requestSyncContract != null) {
                    requestSyncContract.stopSyncBySmartSwitch(syncProgressListener);
                }
            }
        }

        private Companion() {
        }
    }

    @Nullable
    public final CoeditResolverContract getCoeditResolver() {
        return this.coeditResolver;
    }

    @Nullable
    public final GcsResolverContract getGcsResolver() {
        return this.gcsResolver;
    }

    @Nullable
    public final RequestSyncContract getRequestSyncContract() {
        return this.requestSyncContract;
    }

    public final void notifyOnDocumentClosed() {
        RequestSyncContract requestSyncContract = INSTANCE.getInstance().requestSyncContract;
        if (requestSyncContract != null) {
            requestSyncContract.notifyOnDocumentClosed();
        }
    }

    public final void requestSyncDownForServerNoteTemporarily(@Nullable TemporalServerNoteInfo noteInfo) {
        RequestSyncContract requestSyncContract = INSTANCE.getInstance().requestSyncContract;
        if (requestSyncContract != null) {
            requestSyncContract.requestSyncDownForServerNoteTemporarily(noteInfo);
        }
    }

    public final void setCoeditResolver(@Nullable CoeditResolverContract coeditResolverContract) {
        this.coeditResolver = coeditResolverContract;
    }

    public final void setGcsResolver(@Nullable GcsResolverContract gcsResolverContract) {
        this.gcsResolver = gcsResolverContract;
    }

    public final void setRequestSyncContract(@Nullable RequestSyncContract requestSyncContract) {
        this.requestSyncContract = requestSyncContract;
    }
}
