package com.samsung.android.support.senl.p148nt.base.common.startmanager;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/startmanager/ComposerStartManager;", "", "<init>", "()V", "mFinalBlockTime", "", "mUuids", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "closeAllComposer", "", "closedListener", "Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$IClosedListener;", "setFinalBlockTimeToStartComposer", "", "finalBlockTime", "setUuidWithBlockTimeToStartComposer", "uuid", "removeUuidToStartComposer", "clearUuidsToStartComposer", "canStartComposer", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ComposerStartManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "ComposerStartManager";

    @Nullable
    private static ComposerStartManager sInstance;
    private long mFinalBlockTime;

    @NotNull
    private final HashMap<String, Long> mUuids;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/startmanager/ComposerStartManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/startmanager/ComposerStartManager;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/startmanager/ComposerStartManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized ComposerStartManager getInstance() {
            ComposerStartManager composerStartManager;
            try {
                if (ComposerStartManager.sInstance == null) {
                    ComposerStartManager.sInstance = new ComposerStartManager(null);
                }
                composerStartManager = ComposerStartManager.sInstance;
                Intrinsics.checkNotNull(composerStartManager);
            } catch (Throwable th) {
                throw th;
            }
            return composerStartManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ComposerStartManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean canStartComposer(@Nullable String uuid) {
        Long l;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.mFinalBlockTime;
        if (jCurrentTimeMillis < j) {
            Logger.m8703w(TAG, "canStartComposer# false / time = " + j);
            return false;
        }
        if (TextUtils.isEmpty(uuid) || (l = this.mUuids.get(uuid)) == null || jCurrentTimeMillis >= l.longValue()) {
            return true;
        }
        Logger.m8703w(TAG, "canStartComposer# false / uuid = " + uuid + " / time = " + l);
        return false;
    }

    public final void clearUuidsToStartComposer() {
        this.mUuids.clear();
    }

    public final boolean closeAllComposer(@NotNull ComposerManager.IClosedListener closedListener) {
        Intrinsics.checkNotNullParameter(closedListener, "closedListener");
        Logger.m8702i(TAG, "closeAllComposer# ");
        return ComposerManager.INSTANCE.getInstance().closeAllComposer(closedListener);
    }

    public final void removeUuidToStartComposer(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.mUuids.remove(uuid);
    }

    public final void setFinalBlockTimeToStartComposer(long finalBlockTime) {
        this.mFinalBlockTime = finalBlockTime;
        Logger.m8702i(TAG, "setFinalBlockTimeToStartComposer# time = " + finalBlockTime);
    }

    public final void setUuidWithBlockTimeToStartComposer(@NotNull String uuid, long finalBlockTime) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.mUuids.put(uuid, Long.valueOf(finalBlockTime));
    }

    private ComposerStartManager() {
        this.mUuids = new HashMap<>();
    }
}
