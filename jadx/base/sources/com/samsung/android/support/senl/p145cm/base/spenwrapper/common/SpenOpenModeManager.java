package com.samsung.android.support.senl.p145cm.base.spenwrapper.common;

import androidx.annotation.VisibleForTesting;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constants.SpenOpenMode;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\b\u0010\r\u001a\u00020\fH\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/common/SpenOpenModeManager;", "", "<init>", "()V", "mUsedMap", "", "", "", "use", "baseMode", "path", "disuse", "", "clear", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenOpenModeManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenOpenModeManager";

    @Nullable
    private static volatile SpenOpenModeManager sSpenOpenModeManager;

    @NotNull
    private final Map<String, Integer> mUsedMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/common/SpenOpenModeManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sSpenOpenModeManager", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/common/SpenOpenModeManager;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/common/SpenOpenModeManager;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized SpenOpenModeManager getInstance() {
            SpenOpenModeManager spenOpenModeManager;
            try {
                if (SpenOpenModeManager.sSpenOpenModeManager == null) {
                    SpenOpenModeManager.sSpenOpenModeManager = new SpenOpenModeManager(null);
                }
                spenOpenModeManager = SpenOpenModeManager.sSpenOpenModeManager;
                Intrinsics.checkNotNull(spenOpenModeManager);
            } catch (Throwable th) {
                throw th;
            }
            return spenOpenModeManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SpenOpenModeManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @VisibleForTesting
    public final void clear() {
        synchronized (this.mUsedMap) {
            this.mUsedMap.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void disuse(@Nullable String path) {
        if (path == null || Intrinsics.areEqual(path, "")) {
            return;
        }
        synchronized (this.mUsedMap) {
            try {
                Integer num = this.mUsedMap.get(path);
                if (num != null) {
                    Map<String, Integer> map = this.mUsedMap;
                    int iIntValue = num.intValue() - 1;
                    map.put(path, Integer.valueOf(iIntValue));
                    if (iIntValue <= 0) {
                        this.mUsedMap.remove(path);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int use(@SpenOpenMode int baseMode, @Nullable String path) {
        int iIntValue;
        if (path == null || Intrinsics.areEqual(path, "")) {
            return baseMode;
        }
        synchronized (this.mUsedMap) {
            try {
                Integer num = this.mUsedMap.get(path);
                iIntValue = (num != null ? num.intValue() : 0) + 1;
                this.mUsedMap.put(path, Integer.valueOf(iIntValue));
            } catch (Throwable th) {
                throw th;
            }
        }
        return baseMode + iIntValue;
    }

    private SpenOpenModeManager() {
        this.mUsedMap = new ConcurrentHashMap();
    }
}
