package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.RunnableC7967b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u0010\u001a\u00020\u0011\"\b\b\u0000\u0010\u0012*\u00020\u0013\"\b\b\u0001\u0010\u0014*\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00140\u00172\u0006\u0010\u0018\u001a\u0002H\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00140\u001a¢\u0006\u0002\u0010\u001bJ5\u0010\u001c\u001a\u00020\u0011\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u001d\u001a\u0002H\u00142\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0011J\u0006\u0010\"\u001a\u00020\u001fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTaskController;", "", "<init>", "()V", "lastTask", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/ITask;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "notification", "Ljava/lang/Runnable;", "getNotification", "()Ljava/lang/Runnable;", "setNotification", "(Ljava/lang/Runnable;)V", "execute", "", "I", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Inputs;", "R", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Results;", "task", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask;", "inputs", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Callback;", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Inputs;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Callback;)V", "notify", "result", "isSuccess", "", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Results;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Callback;Z)V", "release", "isWorking", "UiCallbackWrapper", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiResultTaskController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Logger.createTag("SmActionManager");

    @NotNull
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Nullable
    private ITask lastTask;

    @Nullable
    private Runnable notification;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTaskController$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return AiResultTaskController.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTaskController$UiCallbackWrapper;", "R", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Results;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Callback;", Profile.PhoneNumberData.TYPE_CALLBACK, "actionController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTaskController;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Callback;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTaskController;)V", "getCallback", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Callback;", "onSuccess", "", "result", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Results;)V", "onFail", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class UiCallbackWrapper<R extends AiResultTask.Results> implements AiResultTask.Callback<R> {

        @NotNull
        private final AiResultTaskController actionController;

        @Nullable
        private final AiResultTask.Callback<R> callback;

        public UiCallbackWrapper(@Nullable AiResultTask.Callback<R> callback, @NotNull AiResultTaskController actionController) {
            Intrinsics.checkNotNullParameter(actionController, "actionController");
            this.callback = callback;
            this.actionController = actionController;
        }

        @Nullable
        public final AiResultTask.Callback<R> getCallback() {
            return this.callback;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.control.action.AiResultTask.Callback
        public void onFail(@NotNull R result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.actionController.notify(result, this.callback, false);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.control.action.AiResultTask.Callback
        public void onSuccess(@NotNull R result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.actionController.notify(result, this.callback, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notify$lambda$1(AiResultTask.Callback callback, boolean z, AiResultTask.Results results, AiResultTaskController aiResultTaskController) {
        if (callback != null) {
            if (z) {
                callback.onSuccess(results);
            } else {
                callback.onFail(results);
            }
            aiResultTaskController.notification = null;
        }
    }

    public final <I extends AiResultTask.Inputs, R extends AiResultTask.Results> void execute(@NotNull AiResultTask<I, R> task, @NotNull I inputs, @NotNull AiResultTask.Callback<R> callback) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(inputs, "inputs");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger.m10999d(TAG, "execute# " + task);
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

    public final <R extends AiResultTask.Results> void notify(@NotNull R result, @Nullable AiResultTask.Callback<R> callback, boolean isSuccess) {
        Intrinsics.checkNotNullParameter(result, "result");
        Logger.m10999d(TAG, "notify# ");
        this.lastTask = null;
        RunnableC7967b runnableC7967b = new RunnableC7967b(callback, isSuccess, result, this);
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
