package com.samsung.android.support.senl.addons.base.viewmodel;

import com.samsung.android.support.senl.addons.base.utils.InstanceCloseDebugger;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u0018\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/ViewModelCloser;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/IViewModelCloser;", "<init>", "()V", "mViewModelList", "", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel;", "mDebugger", "Lcom/samsung/android/support/senl/addons/base/utils/InstanceCloseDebugger;", "addViewModel", "", "viewModel", "removeViewModel", "close", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class ViewModelCloser implements IViewModelCloser {

    @NotNull
    private static final String TAG = Logger.createTag("ViewModelCloser");

    @Nullable
    private List<InstanceCloseDebugger> mDebugger;

    @Nullable
    private List<IBaseViewModel> mViewModelList = new ArrayList();

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IViewModelCloser
    public void addViewModel(@Nullable IBaseViewModel viewModel) {
        List<IBaseViewModel> list = this.mViewModelList;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (list.contains(viewModel)) {
                return;
            }
            List<IBaseViewModel> list2 = this.mViewModelList;
            Intrinsics.checkNotNull(list2);
            list2.add(viewModel);
            if (InstanceCloseDebugger.INSTANCE.canRun()) {
                if (this.mDebugger == null) {
                    this.mDebugger = new ArrayList();
                }
                List<InstanceCloseDebugger> list3 = this.mDebugger;
                Intrinsics.checkNotNull(list3);
                String str = TAG;
                String name = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                list3.add(new InstanceCloseDebugger(str, name));
            }
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IViewModelCloser
    public void close() {
        InstanceCloseDebugger instanceCloseDebugger;
        List<IBaseViewModel> list = this.mViewModelList;
        Intrinsics.checkNotNull(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            List<IBaseViewModel> list2 = this.mViewModelList;
            Intrinsics.checkNotNull(list2);
            IBaseViewModel iBaseViewModel = list2.get(i);
            if (iBaseViewModel != null) {
                iBaseViewModel.close();
            }
            List<InstanceCloseDebugger> list3 = this.mDebugger;
            if (list3 != null && (instanceCloseDebugger = list3.get(i)) != null) {
                String name = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                instanceCloseDebugger.close(name);
            }
        }
        this.mDebugger = null;
        List<IBaseViewModel> list4 = this.mViewModelList;
        Intrinsics.checkNotNull(list4);
        list4.clear();
        this.mViewModelList = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IViewModelCloser
    public void removeViewModel(@Nullable IBaseViewModel viewModel) {
        List<IBaseViewModel> list = this.mViewModelList;
        if (list != null) {
            list.remove(viewModel);
        }
    }
}
