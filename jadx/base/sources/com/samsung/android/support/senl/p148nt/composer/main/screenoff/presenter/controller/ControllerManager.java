package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.controller;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.save.SaveModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/controller/ControllerManager;", "", "<init>", "()V", "pinController", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/controller/PinController;", "getPinController", "()Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/controller/PinController;", "init", "", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "saveModel", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/save/SaveModel;", "onActivityCreated", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "onAttachView", "onDetachView", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ControllerManager {

    @NotNull
    private static final String TAG = SOLogger.createTag("ControllerManager");

    @NotNull
    private final PinController pinController = new PinController();

    @NotNull
    public final PinController getPinController() {
        return this.pinController;
    }

    public final void init(@Nullable ComposerModel composerModel, @Nullable SaveModel saveModel) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "init#");
        this.pinController.init(composerModel, saveModel);
    }

    public final void onActivityCreated(@Nullable Activity activity) {
        this.pinController.onAttachView(activity);
    }

    public final void onAttachView() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onAttachView#");
    }

    public final void onDetachView() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDetachView#");
    }
}
