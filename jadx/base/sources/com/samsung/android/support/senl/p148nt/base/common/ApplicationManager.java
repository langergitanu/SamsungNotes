package com.samsung.android.support.senl.p148nt.base.common;

import android.content.Context;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.support.senl.p148nt.base.common.task.AsyncTaskManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ApplicationManager;", "", "<init>", "()V", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", StateHandler.ACTION_GET_APP_STATE, "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "mAppPackageName", "", "activityTracker", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker;", "getActivityTracker", "()Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker;", "asyncTaskManager", "Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager;", "getAsyncTaskManager", "()Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager;", "applicationID", "getApplicationID", "()Ljava/lang/String;", "context", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ApplicationManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int LAZY_INITIALIZATION_TIME = 1000;

    @NotNull
    private static final String TAG = "ApplicationManager";

    @Nullable
    private static ApplicationManager mInstance;

    @Nullable
    private Context appContext;

    @Nullable
    private String mAppPackageName;

    @NotNull
    private final ActivityLifecycleTracker activityTracker = new ActivityLifecycleTracker();

    @NotNull
    private final AsyncTaskManager asyncTaskManager = new AsyncTaskManager();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ApplicationManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LAZY_INITIALIZATION_TIME", "", "mInstance", "Lcom/samsung/android/support/senl/nt/base/common/ApplicationManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/ApplicationManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final synchronized ApplicationManager getInstance() {
            ApplicationManager applicationManager;
            try {
                if (ApplicationManager.mInstance == null) {
                    ApplicationManager.mInstance = new ApplicationManager();
                }
                applicationManager = ApplicationManager.mInstance;
                Intrinsics.checkNotNull(applicationManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.ApplicationManager");
            } catch (Throwable th) {
                throw th;
            }
            return applicationManager;
        }

        private Companion() {
        }
    }

    @NotNull
    public static final synchronized ApplicationManager getInstance() {
        return INSTANCE.getInstance();
    }

    @NotNull
    public final ActivityLifecycleTracker getActivityTracker() {
        return this.activityTracker;
    }

    @Nullable
    public final Context getAppContext() {
        return this.appContext;
    }

    @Nullable
    public final String getApplicationID() {
        Context context = this.appContext;
        if (context == null) {
            return "";
        }
        if (this.mAppPackageName == null) {
            this.mAppPackageName = context != null ? context.getPackageName() : null;
        }
        return this.mAppPackageName;
    }

    @NotNull
    public final AsyncTaskManager getAsyncTaskManager() {
        return this.asyncTaskManager;
    }

    public final void setAppContext(@Nullable Context context) {
        this.appContext = context;
    }

    @Nullable
    public final String getApplicationID(@Nullable Context context) {
        if (context == null) {
            return "";
        }
        if (this.mAppPackageName == null) {
            this.mAppPackageName = context.getPackageName();
        }
        return this.mAppPackageName;
    }
}
