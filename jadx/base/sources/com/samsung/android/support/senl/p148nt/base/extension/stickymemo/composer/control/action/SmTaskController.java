package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.RunnableC7967b;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmProgressControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTask;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JI\u0010\u0012\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u0015\"\b\b\u0001\u0010\u0016*\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00160\u00192\u0006\u0010\u001a\u001a\u0002H\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00160\u001c¢\u0006\u0002\u0010\u001dJ5\u0010\u001e\u001a\u00020\u0013\"\b\b\u0000\u0010\u0016*\u00020\u00172\u0006\u0010\u001f\u001a\u0002H\u00162\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u0002H\u0016\u0018\u00010\u001c2\u0006\u0010 \u001a\u00020!¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0013J\u0006\u0010$\u001a\u00020!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTaskController;", "", "smProgressControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmProgressControl;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmProgressControl;)V", "lastTask", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/ITask;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "notification", "Ljava/lang/Runnable;", "getNotification", "()Ljava/lang/Runnable;", "setNotification", "(Ljava/lang/Runnable;)V", "execute", "", "I", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Inputs;", "R", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Results;", "task", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask;", "inputs", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Callback;", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Inputs;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Callback;)V", "notify", "result", "isSuccess", "", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Results;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Callback;Z)V", "release", "isWorking", "UiCallbackWrapper", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmTaskController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmActionManager");

    @NotNull
    private final Handler handler;

    @Nullable
    private ITask lastTask;

    @Nullable
    private Runnable notification;

    @NotNull
    private final SmProgressControl smProgressControl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTaskController$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmTaskController.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTaskController$UiCallbackWrapper;", "R", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Results;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Callback;", Profile.PhoneNumberData.TYPE_CALLBACK, "actionController", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTaskController;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Callback;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTaskController;)V", "getCallback", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Callback;", "onSuccess", "", "result", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Results;)V", "onFail", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class UiCallbackWrapper<R extends SmTask.Results> implements SmTask.Callback<R> {

        @NotNull
        private final SmTaskController actionController;

        @Nullable
        private final SmTask.Callback<R> callback;

        public UiCallbackWrapper(@Nullable SmTask.Callback<R> callback, @NotNull SmTaskController actionController) {
            Intrinsics.checkNotNullParameter(actionController, "actionController");
            this.callback = callback;
            this.actionController = actionController;
        }

        @Nullable
        public final SmTask.Callback<R> getCallback() {
            return this.callback;
        }

        @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.SmTask.Callback
        public void onFail(@NotNull R result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.actionController.notify(result, this.callback, false);
        }

        @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.SmTask.Callback
        public void onSuccess(@NotNull R result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.actionController.notify(result, this.callback, true);
        }
    }

    public SmTaskController(@NotNull SmProgressControl smProgressControl) {
        Intrinsics.checkNotNullParameter(smProgressControl, "smProgressControl");
        this.smProgressControl = smProgressControl;
        this.handler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notify$lambda$1(SmTaskController smTaskController, SmTask.Callback callback, boolean z, SmTask.Results results) {
        smTaskController.smProgressControl.hideProgress();
        if (callback != null) {
            if (z) {
                callback.onSuccess(results);
            } else {
                callback.onFail(results);
            }
            smTaskController.notification = null;
        }
    }

    public final <I extends SmTask.Inputs, R extends SmTask.Results> void execute(@NotNull SmTask<I, R> task, @NotNull I inputs, @NotNull SmTask.Callback<R> callback) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(inputs, "inputs");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SmLogger.m8661d(TAG, "execute# " + task);
        SmProgressControl.showProgress$default(this.smProgressControl, 0L, 1, null);
        this.lastTask = task;
        task.setInputs(inputs);
        task.setCallback(new UiCallbackWrapper(callback, this));
        task.run();
    }

    @NotNull
    public final Handler getHandler() {
        return this.handler;
    }

    @Nullable
    public final Runnable getNotification() {
        return this.notification;
    }

    public final boolean isWorking() {
        return this.lastTask != null;
    }

    public final <R extends SmTask.Results> void notify(@NotNull R result, @Nullable SmTask.Callback<R> callback, boolean isSuccess) {
        Intrinsics.checkNotNullParameter(result, "result");
        SmLogger.m8661d(TAG, "notify# ");
        this.lastTask = null;
        RunnableC7967b runnableC7967b = new RunnableC7967b(this, callback, isSuccess, result, 2);
        this.handler.post(runnableC7967b);
        this.notification = runnableC7967b;
    }

    public final void release() {
        ITask iTask = this.lastTask;
        if (iTask != null) {
            iTask.clear();
        }
        this.lastTask = null;
    }

    public final void setNotification(@Nullable Runnable runnable) {
        this.notification = runnable;
    }
}
