package com.samsung.android.support.senl.p148nt.base.common.startmanager;

import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/startmanager/MainListStartManager;", "", "<init>", "()V", "mFinalBlockTime", "", "closeAllNoteLists", "", "setFinalBlockTime", "finalBlockTime", "canNotUseNoteList", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MainListStartManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "MainListStartManager";

    @Nullable
    private static MainListStartManager mInstance;
    private long mFinalBlockTime;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/startmanager/MainListStartManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/base/common/startmanager/MainListStartManager;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/startmanager/MainListStartManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized MainListStartManager getInstance() {
            MainListStartManager mainListStartManager;
            try {
                if (MainListStartManager.mInstance == null) {
                    MainListStartManager.mInstance = new MainListStartManager(null);
                }
                mainListStartManager = MainListStartManager.mInstance;
                Intrinsics.checkNotNull(mainListStartManager);
            } catch (Throwable th) {
                throw th;
            }
            return mainListStartManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ MainListStartManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean canNotUseNoteList() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.mFinalBlockTime;
        if (jCurrentTimeMillis >= j) {
            return false;
        }
        Logger.m8703w(TAG, "canNotUseNoteList# true = blockTime = " + j);
        return true;
    }

    public final void closeAllNoteLists() {
        ApplicationManager.INSTANCE.getInstance().getActivityTracker().closeAllInSameClass(ActivityLifecycleTracker.NoteEditable.class);
    }

    public final void setFinalBlockTime(long finalBlockTime) {
        this.mFinalBlockTime = finalBlockTime;
        Logger.m8702i(TAG, "setFinalBlockTime# blockTime = " + finalBlockTime);
    }

    private MainListStartManager() {
    }
}
