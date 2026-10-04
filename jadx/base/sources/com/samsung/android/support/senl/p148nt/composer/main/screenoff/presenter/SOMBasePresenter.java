package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter;

import android.app.Activity;
import android.os.Bundle;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\b\u0010\u000f\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J \u0010\u001c\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/SOMBasePresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/BaseComposerPresenter;", "componentFactory", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/BaseComposerPresenter$ComponentFactory;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/BaseComposerPresenter$ComponentFactory;)V", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/SOMBasePresenter$Contract;", "setContract", "", "contract", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "onInitFinished", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "save", "", "requestReadyForSave", "onResume", "onPause", "onWindowFocusChanged", "hasFocus", "onBackPressed", "withAnimation", "onDestroy", "closeDoc", "onDetachView", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "getComposerModel", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "compViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "getCompViewPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "Contract", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SOMBasePresenter extends BaseComposerPresenter {

    @Nullable
    private Contract mContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/SOMBasePresenter$Contract;", "", "onInitFinished", "", "onResume", "onPause", "onWindowFocusChanged", "hasFocus", "", "onBackPressed", "onDetachView", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onBackPressed();

        void onDetachView();

        void onInitFinished();

        void onPause();

        void onResume();

        void onWindowFocusChanged(boolean hasFocus);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SOMBasePresenter(@NotNull BaseComposerPresenter.ComponentFactory componentFactory) {
        super(componentFactory);
        Intrinsics.checkNotNullParameter(componentFactory, "componentFactory");
        this.mUuidPostfix = "_screenoff";
    }

    @Nullable
    public final Activity getActivity() {
        return this.mSubManager.getComposerLifeState().getActivity();
    }

    @NotNull
    public final ComposerViewPresenter getCompViewPresenter() {
        ComposerViewPresenter compViewPresenter = this.mSubManager.getCompViewPresenter();
        Intrinsics.checkNotNullExpressionValue(compViewPresenter, "getCompViewPresenter(...)");
        return compViewPresenter;
    }

    @NotNull
    public final ComposerModel getComposerModel() {
        ComposerModel composerModel = this.mSubManager.getComposerModel();
        Intrinsics.checkNotNullExpressionValue(composerModel, "getComposerModel(...)");
        return composerModel;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public boolean onBackPressed(boolean withAnimation) {
        Contract contract = this.mContract;
        Intrinsics.checkNotNull(contract);
        contract.onBackPressed();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void onDestroy(@NotNull Activity activity, boolean save, boolean closeDoc) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onDestroy(activity, false, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void onDetachView(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Contract contract = this.mContract;
        Intrinsics.checkNotNull(contract);
        contract.onDetachView();
        super.onDetachView(activity);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewPresenter.OnInitFinishedListener
    public void onInitFinished() {
        Contract contract = this.mContract;
        Intrinsics.checkNotNull(contract);
        contract.onInitFinished();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void onPause() {
        Contract contract = this.mContract;
        Intrinsics.checkNotNull(contract);
        contract.onPause();
        super.onPause();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void onResume() {
        Contract contract = this.mContract;
        Intrinsics.checkNotNull(contract);
        contract.onResume();
        super.onResume();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void onSaveInstanceState(@NotNull Bundle outState, boolean save, boolean requestReadyForSave) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState, false, requestReadyForSave);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void onWindowFocusChanged(boolean hasFocus) {
        Contract contract = this.mContract;
        Intrinsics.checkNotNull(contract);
        contract.onWindowFocusChanged(hasFocus);
        super.onWindowFocusChanged(hasFocus);
        PostLaunchManager.INSTANCE.getInstance().executeBaseLogics();
    }

    public final void setContract(@Nullable Contract contract) {
        this.mContract = contract;
    }
}
