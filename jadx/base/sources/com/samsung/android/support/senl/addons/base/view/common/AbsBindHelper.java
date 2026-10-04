package com.samsung.android.support.senl.addons.base.view.common;

import android.view.View;
import com.samsung.android.support.senl.addons.base.binding.binder.Binder;
import com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.addons.base.viewmodel.IViewModelCloser;
import com.samsung.android.support.senl.addons.base.viewmodel.ViewModelCloser;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0004J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/common/AbsBindHelper;", "Lcom/samsung/android/support/senl/addons/base/view/common/IBindHelper;", "instanceModel", "Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;)V", "mViewModelCloser", "Lcom/samsung/android/support/senl/addons/base/viewmodel/IViewModelCloser;", "mMainBinding", "Lcom/samsung/android/support/senl/addons/base/binding/binder/Binder;", "getMMainBinding", "()Lcom/samsung/android/support/senl/addons/base/binding/binder/Binder;", "setMMainBinding", "(Lcom/samsung/android/support/senl/addons/base/binding/binder/Binder;)V", "addViewModel", "", "viewModel", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel;", "removeViewModel", "unBind", "close", "getRoot", "Landroid/view/View;", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsBindHelper implements IBindHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = Logger.createTag("AbsBindHelper");

    @Nullable
    private Binder mMainBinding;

    @Nullable
    private IViewModelCloser mViewModelCloser = new ViewModelCloser();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/common/AbsBindHelper$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return AbsBindHelper.TAG;
        }

        private Companion() {
        }
    }

    public AbsBindHelper(@Nullable IInstanceModel iInstanceModel) {
        if (iInstanceModel != null) {
            iInstanceModel.setOrientation(PlatformUtil.getScreenOrientation());
        }
    }

    public final void addViewModel(@Nullable IBaseViewModel viewModel) {
        IViewModelCloser iViewModelCloser = this.mViewModelCloser;
        if (iViewModelCloser != null) {
            iViewModelCloser.addViewModel(viewModel);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.view.common.IBindHelper
    public void close() {
        unBind();
        this.mMainBinding = null;
        IViewModelCloser iViewModelCloser = this.mViewModelCloser;
        if (iViewModelCloser != null) {
            Intrinsics.checkNotNull(iViewModelCloser);
            iViewModelCloser.close();
            this.mViewModelCloser = null;
        }
    }

    @Nullable
    public final Binder getMMainBinding() {
        return this.mMainBinding;
    }

    @Override // com.samsung.android.support.senl.addons.base.view.common.IBindHelper
    @Nullable
    public View getRoot() {
        Binder binder = this.mMainBinding;
        if (binder != null) {
            return binder.getRoot();
        }
        return null;
    }

    public final void removeViewModel(@Nullable IBaseViewModel viewModel) {
        IViewModelCloser iViewModelCloser = this.mViewModelCloser;
        if (iViewModelCloser != null) {
            iViewModelCloser.removeViewModel(viewModel);
        }
    }

    public final void setMMainBinding(@Nullable Binder binder) {
        this.mMainBinding = binder;
    }

    @Override // com.samsung.android.support.senl.addons.base.view.common.IBindHelper
    public void unBind() {
        String str = TAG;
        Object root = getRoot();
        if (root == null) {
            root = "null";
        }
        Logger.m7100d(str, "unBind - " + root);
        Binder binder = this.mMainBinding;
        if (binder != null) {
            binder.unBind();
        }
        if (getRoot() != null) {
            View root2 = getRoot();
            Intrinsics.checkNotNull(root2);
            root2.setEnabled(false);
        }
    }
}
