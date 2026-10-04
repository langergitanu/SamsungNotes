package com.samsung.android.sdk.pen.engine.power;

import android.content.Context;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.os.SemDvfsManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/power/SpenDvfsManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mDvfsFling", "Lcom/samsung/android/sdk/pen/engine/power/SpenDvfsInterface;", "mDvfsExecutor", "Ljava/util/concurrent/ExecutorService;", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "setDvfsFling", "", "dvfsInterface", "acquire", "release", "close", "NextDvfsManager", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenDvfsManager {
    private static final int ACQUIRE_TIMEOUT = 10;

    @NotNull
    private static final String TAG = "SpenDvfsManager";
    private boolean isEnabled;

    @Nullable
    private ExecutorService mDvfsExecutor = Executors.newSingleThreadExecutor();

    @Nullable
    private SpenDvfsInterface mDvfsFling;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/power/SpenDvfsManager$NextDvfsManager;", "Lcom/samsung/android/sdk/pen/engine/power/SpenDvfsInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mDvfsManager", "Lcom/samsung/android/os/SemDvfsManager;", "acquire", "", "release", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class NextDvfsManager implements SpenDvfsInterface {

        @Nullable
        private SemDvfsManager mDvfsManager;

        public NextDvfsManager(@Nullable Context context) {
            try {
                Object objInvoke = Class.forName("com.samsung.android.os.SemDvfsManager").getMethod("createInstance", Context.class).invoke(null, context);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type com.samsung.android.os.SemDvfsManager");
                this.mDvfsManager = (SemDvfsManager) objInvoke;
                Log.i("NextDvfsManager", "NextDvfsManager construct");
                SemDvfsManager semDvfsManager = this.mDvfsManager;
                if (semDvfsManager != null) {
                    Log.i("NextDvfsManager", "NextDvfsManager setHint");
                    semDvfsManager.setHint(1500);
                }
            } catch (Exception e) {
                AbstractC6670b.m4756q("NextDvfsManager construct faile ", e.getLocalizedMessage(), "NextDvfsManager");
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.power.SpenDvfsInterface
        public void acquire() {
            SemDvfsManager semDvfsManager = this.mDvfsManager;
            if (semDvfsManager != null) {
                try {
                    Log.i("NextDvfsManager", "NextDvfsManager acquire");
                    semDvfsManager.acquire(10);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    AbstractC6670b.m4756q("NextDvfsManager ", e.getLocalizedMessage(), "NextDvfsManager");
                }
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.power.SpenDvfsInterface
        public void release() {
            SemDvfsManager semDvfsManager = this.mDvfsManager;
            if (semDvfsManager != null) {
                try {
                    Log.i("NextDvfsManager", "NextDvfsManager release");
                    semDvfsManager.release();
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    AbstractC6670b.m4756q("NextDvfsManager ", e.getLocalizedMessage(), "NextDvfsManager");
                }
            }
        }
    }

    public SpenDvfsManager(@Nullable Context context) {
        this.isEnabled = true;
        this.mDvfsFling = new NextDvfsManager(context);
        this.isEnabled = true;
    }

    public final void acquire() {
        SpenDvfsInterface spenDvfsInterface;
        if (this.isEnabled && (spenDvfsInterface = this.mDvfsFling) != null) {
            Log.i(TAG, "SpenDvfsManager fling acquire");
            spenDvfsInterface.acquire();
        }
    }

    public final void close() {
        Log.i(TAG, "SpenDvfsManager close");
        ExecutorService executorService = this.mDvfsExecutor;
        if (executorService != null) {
            executorService.shutdown();
            this.mDvfsExecutor = null;
        }
        SpenDvfsInterface spenDvfsInterface = this.mDvfsFling;
        if (spenDvfsInterface != null) {
            spenDvfsInterface.release();
        }
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final void release() {
        SpenDvfsInterface spenDvfsInterface;
        if (this.isEnabled && (spenDvfsInterface = this.mDvfsFling) != null) {
            Log.i(TAG, "SpenDvfsManager fling release");
            spenDvfsInterface.release();
        }
    }

    public final void setDvfsFling(@Nullable SpenDvfsInterface dvfsInterface) {
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }
}
