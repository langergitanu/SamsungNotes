package com.samsung.android.support.senl.addons.base.viewmodel;

import com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade;
import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IScrollableView;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsScrollableViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsModelControlViewModel;", "facade", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/AbsFacade;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/canvas/control/AbsFacade;)V", "onPropertyChanged", "", "propertyId", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAbsScrollableViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsScrollableViewModel.kt\ncom/samsung/android/support/senl/addons/base/viewmodel/AbsScrollableViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,15:1\n1#2:16\n*E\n"})
public abstract class AbsScrollableViewModel extends AbsModelControlViewModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsScrollableViewModel(@NotNull AbsFacade facade) {
        super(facade);
        Intrinsics.checkNotNullParameter(facade, "facade");
    }

    public void onPropertyChanged(int propertyId) {
        if (propertyId == 11200) {
            IFacade mFacade = getMFacade();
            Intrinsics.checkNotNull(mFacade);
            IView<?> view = mFacade.getView();
            if (view instanceof IScrollableView) {
                return;
            }
            throw new IllegalArgumentException(("View is not IScrollableView " + view).toString());
        }
    }
}
