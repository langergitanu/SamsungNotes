package com.samsung.android.support.notes.bixby.bixby2.action;

import android.app.Application;
import com.samsung.android.sdk.bixby2.Sbixby;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyExecutor;", "", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "mSbixby", "Lcom/samsung/android/sdk/bixby2/Sbixby;", "addActionHandler", "", "updateStateChange", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/sdk/bixby2/state/StateHandler$Callback;", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BixbyExecutor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "BixbyExecutor";

    @Nullable
    private static BixbyExecutor mInstance;

    @NotNull
    private final Sbixby mSbixby;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyExecutor$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyExecutor;", "getMInstance$annotations", "getInstance", "application", "Landroid/app/Application;", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private static /* synthetic */ void getMInstance$annotations() {
        }

        @JvmStatic
        @Nullable
        public final synchronized BixbyExecutor getInstance(@Nullable Application application) {
            try {
                if (BixbyExecutor.mInstance == null) {
                    BixbyExecutor.mInstance = new BixbyExecutor(application);
                }
            } catch (Throwable th) {
                throw th;
            }
            return BixbyExecutor.mInstance;
        }

        private Companion() {
        }
    }

    public BixbyExecutor(@Nullable Application application) {
        Logger.m8697d(TAG, TAG);
        Sbixby.initialize(application != null ? application.getApplicationContext() : null);
        Sbixby sbixby = Sbixby.getInstance();
        Intrinsics.checkNotNullExpressionValue(sbixby, "getInstance(...)");
        this.mSbixby = sbixby;
    }

    @JvmStatic
    @Nullable
    public static final synchronized BixbyExecutor getInstance(@Nullable Application application) {
        return INSTANCE.getInstance(application);
    }

    public final void addActionHandler() {
        Logger.m8697d(TAG, "addActionHandler");
        this.mSbixby.addActionHandler(Bixby2Constants.BixbyActions.ACTION_SEARCH, new BixbyActionHandler());
        this.mSbixby.addActionHandler(Bixby2Constants.BixbyActions.ACTION_DELETE, new BixbyActionHandler());
        this.mSbixby.addActionHandler(Bixby2Constants.BixbyActions.ACTION_SAVE, new BixbyActionHandler());
        this.mSbixby.addActionHandler(Bixby2Constants.BixbyActions.ACTION_UPDATE, new BixbyActionHandler());
        this.mSbixby.addActionHandler(Bixby2Constants.BixbyActions.ACTION_SEARCH_FOLDER, new BixbyActionHandler());
        this.mSbixby.addActionHandler(Bixby2Constants.BixbyActions.ACTION_DELETE_FOLDER, new BixbyActionHandler());
        this.mSbixby.addActionHandler(Bixby2Constants.BixbyActions.ACTION_CREATE_FOLDER, new BixbyActionHandler());
        this.mSbixby.addActionHandler(Bixby2Constants.BixbyActions.ACTION_UPDATE_FOLDER, new BixbyActionHandler());
        this.mSbixby.addActionHandler(Bixby2Constants.BixbyActions.ACTION_GET_APP_STATE, new BixbyActionHandler());
        this.mSbixby.addActionHandler(Bixby2Constants.BixbyActions.ACTION_IS_NOTES_EMPTY, new BixbyActionHandler());
        this.mSbixby.addActionHandler(Bixby2Constants.BixbyActions.ACTION_SHOW_RECENT_NOTESS, new BixbyActionHandler());
        this.mSbixby.addActionHandler(Bixby2Constants.BixbyActions.ACTION_DIAGNOSE_TROUBLE_SHOOTING, new BixbyActionHandler());
    }

    public final void updateStateChange(@Nullable StateHandler.Callback callback) {
        Logger.m8697d(TAG, "updateStateChange");
        Sbixby.getStateHandler().updateStateChange(callback);
    }
}
