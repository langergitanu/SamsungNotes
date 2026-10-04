package com.samsung.android.support.senl.addons.brush.viewmodel.menu;

import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0007J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/AbsSelectionViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "model", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;)V", "mIsSelected", "", "mScreenModel", "getMScreenModel", "()Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "setMScreenModel", "getData", "", "id", "", "getSelected", "getOrientation", "", Bixby2Constants.BIXBY_PARAM_SELECT, "", "clearModels", "closeCallbacks", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsSelectionViewModel extends AbsBaseViewModel {

    @NotNull
    private static final String BINDING_ID_ORIENTATION = "orientation";

    @NotNull
    private static final String BINDING_ID_SELECTED = "selected";
    private boolean mIsSelected;

    @Nullable
    private IScreenModel mScreenModel;

    public AbsSelectionViewModel(@NotNull IScreenModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.mScreenModel = model;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        if (this.mScreenModel != null) {
            this.mScreenModel = null;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        return Intrinsics.areEqual(BINDING_ID_SELECTED, id) ? Boolean.valueOf(getMIsSelected()) : Intrinsics.areEqual("orientation", id) ? Integer.valueOf(getOrientation()) : super.getData(id);
    }

    @Nullable
    public final IScreenModel getMScreenModel() {
        return this.mScreenModel;
    }

    public final int getOrientation() {
        IScreenModel iScreenModel = this.mScreenModel;
        if (iScreenModel != null) {
            return iScreenModel.getMOrientation();
        }
        return 0;
    }

    /* JADX INFO: renamed from: getSelected, reason: from getter */
    public final boolean getMIsSelected() {
        return this.mIsSelected;
    }

    public final void select(boolean select) {
        if (select != this.mIsSelected) {
            this.mIsSelected = select;
            notifyChanged(BINDING_ID_SELECTED);
        }
    }

    public final void setMScreenModel(@Nullable IScreenModel iScreenModel) {
        this.mScreenModel = iScreenModel;
    }
}
