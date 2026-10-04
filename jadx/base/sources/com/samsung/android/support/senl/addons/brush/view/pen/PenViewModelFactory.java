package com.samsung.android.support.senl.addons.brush.view.pen;

import com.samsung.android.support.senl.addons.base.model.pen.IPenModel;
import com.samsung.android.support.senl.addons.brush.model.pen.IPenModelList;
import com.samsung.android.support.senl.addons.brush.model.pen.PenModelList;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModelFactory;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/pen/PenViewModelFactory;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModelFactory;", "Lcom/samsung/android/support/senl/addons/brush/model/pen/PenModelList;", "mModelList", "Lcom/samsung/android/support/senl/addons/brush/model/pen/IPenModelList;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/pen/IPenModelList;)V", "createViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModel;", "name", "", "createEraserViewModel", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PenViewModelFactory implements IPenViewModelFactory<PenModelList> {

    @NotNull
    private final IPenModelList mModelList;

    public PenViewModelFactory(@NotNull IPenModelList mModelList) {
        Intrinsics.checkNotNullParameter(mModelList, "mModelList");
        this.mModelList = mModelList;
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModelFactory
    @NotNull
    public PenViewModel createEraserViewModel() {
        PenViewModel penViewModel = new PenViewModel();
        IPenModel mEraserPenModel = this.mModelList.getMEraserPenModel();
        Intrinsics.checkNotNull(mEraserPenModel);
        penViewModel.setPenModel(mEraserPenModel);
        return penViewModel;
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModelFactory
    @NotNull
    public PenViewModel createViewModel(@Nullable String name) {
        PenViewModel penViewModel = new PenViewModel();
        IPenModel penModel = this.mModelList.getPenModel(name);
        Intrinsics.checkNotNull(penModel);
        penViewModel.setPenModel(penModel);
        return penViewModel;
    }
}
