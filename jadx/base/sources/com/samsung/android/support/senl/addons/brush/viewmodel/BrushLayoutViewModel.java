package com.samsung.android.support.senl.addons.brush.viewmodel;

import android.view.View;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.addons.base.model.event.LayoutChangeEvent;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.brush.model.color.ColorModelsManager;
import com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.MenuLayoutViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModelList;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0016\u0018\u0000 32\u00020\u0001:\u00013B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016JP\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020%J\b\u00100\u001a\u00020\u001eH\u0014J\b\u00101\u001a\u00020\u001eH\u0014J\b\u00102\u001a\u00020\u001eH\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010-\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushLayoutViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "injector", "Lcom/samsung/android/support/senl/addons/brush/model/menu/IMenuSizeInjector;", "screenModel", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "penViewModelList", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModelList;", "manager", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/menu/IMenuSizeInjector;Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModelList;Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;)V", "getScreenModel", "()Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "setScreenModel", "(Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;)V", "getPenViewModelList", "()Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModelList;", "setPenViewModelList", "(Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModelList;)V", "value", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/MenuLayoutViewModel;", "menuViewModel", "getMenuViewModel", "()Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/MenuLayoutViewModel;", "getData", "", "id", "", "perform", "", "action", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", BrushLayoutViewModel.BINDING_ID_ON_LAYOUT_CHANGE, VPathDataCmd.RCurveTo, "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "orientation", "getOrientation", "()I", "closeSubViewModels", "clearModels", "closeCallbacks", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushLayoutViewModel extends AbsBaseViewModel {

    @NotNull
    private static final String BINDING_ID_LAYOUT_VIEW_MODEL = "layoutViewModel";

    @NotNull
    private static final String BINDING_ID_ON_LAYOUT_CHANGE = "onLayoutChange";

    @NotNull
    private static final String BINDING_ID_ORIENTATION = "orientation";

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushLayoutViewModel");

    @Nullable
    private MenuLayoutViewModel menuViewModel;

    @Nullable
    private PenViewModelList penViewModelList;

    @Nullable
    private IScreenModel screenModel;

    public BrushLayoutViewModel(@Nullable IMenuSizeInjector iMenuSizeInjector, @Nullable IScreenModel iScreenModel, @Nullable PenViewModelList penViewModelList, @Nullable ColorModelsManager colorModelsManager) {
        this.screenModel = iScreenModel;
        this.penViewModelList = penViewModelList;
        this.menuViewModel = new MenuLayoutViewModel(this.screenModel, iMenuSizeInjector, colorModelsManager);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        this.screenModel = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
        PenViewModelList penViewModelList = this.penViewModelList;
        if (penViewModelList != null) {
            Intrinsics.checkNotNull(penViewModelList);
            penViewModelList.close();
            this.penViewModelList = null;
        }
        MenuLayoutViewModel menuLayoutViewModel = this.menuViewModel;
        if (menuLayoutViewModel != null) {
            Intrinsics.checkNotNull(menuLayoutViewModel);
            menuLayoutViewModel.close();
            this.menuViewModel = null;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        return Intrinsics.areEqual("orientation", id) ? Integer.valueOf(getOrientation()) : Intrinsics.areEqual(BINDING_ID_LAYOUT_VIEW_MODEL, id) ? this : super.getData(id);
    }

    @Nullable
    public final MenuLayoutViewModel getMenuViewModel() {
        return this.menuViewModel;
    }

    public final int getOrientation() {
        IScreenModel iScreenModel = this.screenModel;
        Intrinsics.checkNotNull(iScreenModel);
        return iScreenModel.getMOrientation();
    }

    @Nullable
    public final PenViewModelList getPenViewModelList() {
        return this.penViewModelList;
    }

    @Nullable
    public final IScreenModel getScreenModel() {
        return this.screenModel;
    }

    public final void onLayoutChange(@Nullable View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        int i = oldBottom - oldTop;
        int i2 = right - left;
        int i4 = bottom - top;
        if (i2 == oldRight - oldLeft && i4 == i) {
            return;
        }
        int i5 = i2 < i4 ? 1 : 2;
        IScreenModel iScreenModel = this.screenModel;
        if (iScreenModel != null) {
            Intrinsics.checkNotNull(iScreenModel);
            iScreenModel.setOrientation(i5);
        }
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, i4, "onLayoutChange : menu = ", " x ", ", orientation=");
        sbM1173s.append(i5);
        Logger.m7100d(str, sbM1173s.toString());
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void perform(@Nullable IBaseViewModel.Action action) {
        if (action != null && Intrinsics.areEqual(BINDING_ID_ON_LAYOUT_CHANGE, action.getMBindId())) {
            LayoutChangeEvent layoutChangeEvent = (LayoutChangeEvent) action.getData();
            Intrinsics.checkNotNull(layoutChangeEvent);
            onLayoutChange(layoutChangeEvent.mView, layoutChangeEvent.mLeft, layoutChangeEvent.mTop, layoutChangeEvent.mRight, layoutChangeEvent.mBottom, layoutChangeEvent.mOldLeft, layoutChangeEvent.mOldTop, layoutChangeEvent.mOldRight, layoutChangeEvent.mOldBottom);
        }
        super.perform(action);
    }

    public final void setPenViewModelList(@Nullable PenViewModelList penViewModelList) {
        this.penViewModelList = penViewModelList;
    }

    public final void setScreenModel(@Nullable IScreenModel iScreenModel) {
        this.screenModel = iScreenModel;
    }
}
