package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action;

import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.control.action.AiResultTask.Inputs;
import com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.control.action.AiResultTask.Results;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005:\u0004&'()B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001e\u001a\u00020\u001fH&J\u001d\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00028\u0000X\u0086.¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask;", "I", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Inputs;", "R", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Results;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/ITask;", "tag", "", "<init>", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "inputs", "getInputs", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Inputs;", "setInputs", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Inputs;)V", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Inputs;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Callback;", "getCallback", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Callback;", "setCallback", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Callback;)V", "executorService", "Ljava/util/concurrent/ExecutorService;", "getExecutorService", "()Ljava/util/concurrent/ExecutorService;", "setExecutorService", "(Ljava/util/concurrent/ExecutorService;)V", "run", "", "notifyCallback", "success", "", "results", "(ZLcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Results;)V", "clearService", "Inputs", "Results", "Callback", "ITask", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AiResultTask<I extends Inputs, R extends Results> implements com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.ITask {

    @Nullable
    private Callback<R> callback;

    @Nullable
    private ExecutorService executorService;
    public I inputs;

    @NotNull
    private final String tag;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0002H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0002H&¢\u0006\u0002\u0010\u0006¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Callback;", "R", "", "onSuccess", "", "result", "(Ljava/lang/Object;)V", "onFail", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Callback<R> {
        void onFail(R result);

        void onSuccess(R result);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$ITask;", "", "clear", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ITask {
        void clear();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Inputs;", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Inputs {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Results;", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Results {
    }

    public AiResultTask(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
    }

    public final void clearService() {
        ExecutorService executorService = this.executorService;
        if (executorService != null) {
            Logger.m10999d(this.tag, "clearService# wait start");
            try {
                executorService.awaitTermination(1000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Logger.m10999d(this.tag, e.getMessage());
            }
            this.executorService = null;
            Logger.m10999d(this.tag, "clearService# wait end");
        }
    }

    @Nullable
    public final Callback<R> getCallback() {
        return this.callback;
    }

    @Nullable
    public final ExecutorService getExecutorService() {
        return this.executorService;
    }

    @NotNull
    public final I getInputs() {
        I i = this.inputs;
        if (i != null) {
            return i;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inputs");
        return null;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    public void notifyCallback(boolean success, @NotNull R results) {
        Intrinsics.checkNotNullParameter(results, "results");
        Callback<R> callback = this.callback;
        if (callback != null) {
            AbstractC8014b.m7220v("notifyCallback# ", this.tag, success);
            if (success) {
                callback.onSuccess(results);
            } else {
                callback.onFail(results);
            }
        }
    }

    public abstract void run();

    public final void setCallback(@Nullable Callback<R> callback) {
        this.callback = callback;
    }

    public final void setExecutorService(@Nullable ExecutorService executorService) {
        this.executorService = executorService;
    }

    public final void setInputs(@NotNull I i) {
        Intrinsics.checkNotNullParameter(i, "<set-?>");
        this.inputs = i;
    }
}
