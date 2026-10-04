package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import androidx.sqlite.p113db.SupportSQLiteOpenHelper;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J%\u00106\u001a\u0002H7\"\u0004\b\u0000\u001072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H709¢\u0006\u0002\u0010:J\u0006\u0010;\u001a\u00020\rJ\u000e\u0010<\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020\u000bR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020,8\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u00020,8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010.¨\u0006@"}, m13886d2 = {"Landroidx/room/AutoCloser;", "", "autoCloseTimeoutAmount", "", "autoCloseTimeUnit", "Ljava/util/concurrent/TimeUnit;", "autoCloseExecutor", "Ljava/util/concurrent/Executor;", "(JLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/Executor;)V", "autoCloseTimeoutInMs", "autoCloser", "Ljava/lang/Runnable;", "delegateDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getDelegateDatabase$room_runtime_release", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "setDelegateDatabase$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "delegateOpenHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "getDelegateOpenHelper", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "setDelegateOpenHelper", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "executeAutoCloser", "executor", "handler", "Landroid/os/Handler;", "isActive", "", "()Z", "lastDecrementRefCountTimeStamp", "getLastDecrementRefCountTimeStamp$room_runtime_release", "()J", "setLastDecrementRefCountTimeStamp$room_runtime_release", "(J)V", "lock", "manuallyClosed", "onAutoCloseCallback", "getOnAutoCloseCallback$room_runtime_release", "()Ljava/lang/Runnable;", "setOnAutoCloseCallback$room_runtime_release", "(Ljava/lang/Runnable;)V", CoeditServiceConstants.Attribute.KEY_REF_COUNT, "", "getRefCount$room_runtime_release", "()I", "setRefCount$room_runtime_release", "(I)V", "refCountForTest", "getRefCountForTest$room_runtime_release", "closeDatabaseIfOpen", "", "decrementCountAndScheduleClose", "executeRefCountingFunction", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "incrementCountAndEnsureDbIsOpen", "init", "setAutoCloseCallback", "onAutoClose", "Companion", "room-runtime_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AutoCloser {

    @NotNull
    public static final String autoCloseBug = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";
    private long autoCloseTimeoutInMs;

    @NotNull
    private final Runnable autoCloser;

    @GuardedBy("lock")
    @Nullable
    private SupportSQLiteDatabase delegateDatabase;
    public SupportSQLiteOpenHelper delegateOpenHelper;

    @NotNull
    private final Runnable executeAutoCloser;

    @NotNull
    private final Executor executor;

    @NotNull
    private final Handler handler;

    @GuardedBy("lock")
    private long lastDecrementRefCountTimeStamp;

    @NotNull
    private final Object lock;
    private boolean manuallyClosed;

    @Nullable
    private Runnable onAutoCloseCallback;

    @GuardedBy("lock")
    private int refCount;

    public AutoCloser(long j, @NotNull TimeUnit autoCloseTimeUnit, @NotNull Executor autoCloseExecutor) {
        Intrinsics.checkNotNullParameter(autoCloseTimeUnit, "autoCloseTimeUnit");
        Intrinsics.checkNotNullParameter(autoCloseExecutor, "autoCloseExecutor");
        this.handler = new Handler(Looper.getMainLooper());
        this.lock = new Object();
        this.autoCloseTimeoutInMs = autoCloseTimeUnit.toMillis(j);
        this.executor = autoCloseExecutor;
        this.lastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
        final int i = 0;
        this.executeAutoCloser = new Runnable(this) { // from class: androidx.room.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AutoCloser f1662b;

            {
                this.f1662b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        AutoCloser.executeAutoCloser$lambda$0(this.f1662b);
                        break;
                    default:
                        AutoCloser.autoCloser$lambda$3(this.f1662b);
                        break;
                }
            }
        };
        final int i2 = 1;
        this.autoCloser = new Runnable(this) { // from class: androidx.room.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AutoCloser f1662b;

            {
                this.f1662b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        AutoCloser.executeAutoCloser$lambda$0(this.f1662b);
                        break;
                    default:
                        AutoCloser.autoCloser$lambda$3(this.f1662b);
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void autoCloser$lambda$3(AutoCloser this$0) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.lock) {
            try {
                if (SystemClock.uptimeMillis() - this$0.lastDecrementRefCountTimeStamp < this$0.autoCloseTimeoutInMs) {
                    return;
                }
                if (this$0.refCount != 0) {
                    return;
                }
                Runnable runnable = this$0.onAutoCloseCallback;
                if (runnable != null) {
                    runnable.run();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                SupportSQLiteDatabase supportSQLiteDatabase = this$0.delegateDatabase;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    supportSQLiteDatabase.close();
                }
                this$0.delegateDatabase = null;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeAutoCloser$lambda$0(AutoCloser this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.executor.execute(this$0.autoCloser);
    }

    public final void closeDatabaseIfOpen() {
        synchronized (this.lock) {
            try {
                this.manuallyClosed = true;
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null) {
                    supportSQLiteDatabase.close();
                }
                this.delegateDatabase = null;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void decrementCountAndScheduleClose() {
        synchronized (this.lock) {
            try {
                int i = this.refCount;
                if (i <= 0) {
                    throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
                }
                int i2 = i - 1;
                this.refCount = i2;
                if (i2 == 0) {
                    if (this.delegateDatabase == null) {
                        return;
                    } else {
                        this.handler.postDelayed(this.executeAutoCloser, this.autoCloseTimeoutInMs);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <V> V executeRefCountingFunction(@NotNull Function1<? super SupportSQLiteDatabase, ? extends V> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: getDelegateDatabase$room_runtime_release, reason: from getter */
    public final SupportSQLiteDatabase getDelegateDatabase() {
        return this.delegateDatabase;
    }

    @NotNull
    public final SupportSQLiteOpenHelper getDelegateOpenHelper() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.delegateOpenHelper;
        if (supportSQLiteOpenHelper != null) {
            return supportSQLiteOpenHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("delegateOpenHelper");
        return null;
    }

    /* JADX INFO: renamed from: getLastDecrementRefCountTimeStamp$room_runtime_release, reason: from getter */
    public final long getLastDecrementRefCountTimeStamp() {
        return this.lastDecrementRefCountTimeStamp;
    }

    @Nullable
    /* JADX INFO: renamed from: getOnAutoCloseCallback$room_runtime_release, reason: from getter */
    public final Runnable getOnAutoCloseCallback() {
        return this.onAutoCloseCallback;
    }

    /* JADX INFO: renamed from: getRefCount$room_runtime_release, reason: from getter */
    public final int getRefCount() {
        return this.refCount;
    }

    @VisibleForTesting
    public final int getRefCountForTest$room_runtime_release() {
        int i;
        synchronized (this.lock) {
            i = this.refCount;
        }
        return i;
    }

    @NotNull
    public final SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        synchronized (this.lock) {
            this.handler.removeCallbacks(this.executeAutoCloser);
            this.refCount++;
            if (this.manuallyClosed) {
                throw new IllegalStateException("Attempting to open already closed database.");
            }
            SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                return supportSQLiteDatabase;
            }
            SupportSQLiteDatabase writableDatabase = getDelegateOpenHelper().getWritableDatabase();
            this.delegateDatabase = writableDatabase;
            return writableDatabase;
        }
    }

    public final void init(@NotNull SupportSQLiteOpenHelper delegateOpenHelper) {
        Intrinsics.checkNotNullParameter(delegateOpenHelper, "delegateOpenHelper");
        setDelegateOpenHelper(delegateOpenHelper);
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final void setAutoCloseCallback(@NotNull Runnable onAutoClose) {
        Intrinsics.checkNotNullParameter(onAutoClose, "onAutoClose");
        this.onAutoCloseCallback = onAutoClose;
    }

    public final void setDelegateDatabase$room_runtime_release(@Nullable SupportSQLiteDatabase supportSQLiteDatabase) {
        this.delegateDatabase = supportSQLiteDatabase;
    }

    public final void setDelegateOpenHelper(@NotNull SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        Intrinsics.checkNotNullParameter(supportSQLiteOpenHelper, "<set-?>");
        this.delegateOpenHelper = supportSQLiteOpenHelper;
    }

    public final void setLastDecrementRefCountTimeStamp$room_runtime_release(long j) {
        this.lastDecrementRefCountTimeStamp = j;
    }

    public final void setOnAutoCloseCallback$room_runtime_release(@Nullable Runnable runnable) {
        this.onAutoCloseCallback = runnable;
    }

    public final void setRefCount$room_runtime_release(int i) {
        this.refCount = i;
    }
}
