package com.samsung.android.support.senl.addons.brush.viewmodel;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.model.event.LayoutChangeEvent;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.animation.HideAnimationData;
import com.samsung.android.support.senl.addons.base.viewmodel.animation.MenuHideViewModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushMenuHideViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/animation/MenuHideViewModel;", "facade", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;)V", "perform", "", "action", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", "setLayoutRect", "id", "", "rect", "Landroid/graphics/Rect;", "statusBar", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushMenuHideViewModel extends MenuHideViewModel {

    @NotNull
    private static final String BINDING_ID_ON_LAYOUT_CHANGE = "onLayoutChange";

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushMenuHideViewModel");

    public BrushMenuHideViewModel(@Nullable IFacade iFacade) {
        super(iFacade);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.animation.MenuHideViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void perform(@Nullable IBaseViewModel.Action action) {
        if (Intrinsics.areEqual(BINDING_ID_ON_LAYOUT_CHANGE, action != null ? action.getMBindId() : null)) {
            LayoutChangeEvent layoutChangeEvent = (LayoutChangeEvent) action.getData();
            Intrinsics.checkNotNull(layoutChangeEvent);
            View view = layoutChangeEvent.mView;
            Intrinsics.checkNotNull(view);
            onLayoutChange(view, layoutChangeEvent.mLeft, layoutChangeEvent.mTop, layoutChangeEvent.mRight, layoutChangeEvent.mBottom, layoutChangeEvent.mOldLeft, layoutChangeEvent.mOldTop, layoutChangeEvent.mOldRight, layoutChangeEvent.mOldBottom);
        }
        super.perform(action);
    }

    public final void setLayoutRect(int id, @NotNull Rect rect, int statusBar) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (getMFacade() == null) {
            return;
        }
        IFacade mFacade = getMFacade();
        Intrinsics.checkNotNull(mFacade);
        int[] viewPositionInWindow = mFacade.getViewPositionInWindow();
        Rect rect2 = new Rect();
        int[] iArr = {rect.left, rect.top};
        rect2.set(0, 0, rect.width(), rect.height());
        int i = iArr[0] - rect2.left;
        Intrinsics.checkNotNull(viewPositionInWindow);
        rect2.offset(i - viewPositionInWindow[0], ((iArr[1] - rect2.top) - viewPositionInWindow[1]) + statusBar);
        SparseArray<HideAnimationData> mHideAnimationArray = getMHideAnimationArray();
        Intrinsics.checkNotNull(mHideAnimationArray);
        HideAnimationData hideAnimationData = mHideAnimationArray.get(id);
        if (hideAnimationData != null) {
            hideAnimationData.setLayoutRect(rect2);
            Logger.m7100d(TAG, "setLayoutRect : update - " + hideAnimationData.hashCode() + " : " + rect2);
            return;
        }
        HideAnimationData hideAnimationData2 = new HideAnimationData(rect2, false);
        SparseArray<HideAnimationData> mHideAnimationArray2 = getMHideAnimationArray();
        Intrinsics.checkNotNull(mHideAnimationArray2);
        mHideAnimationArray2.put(id, hideAnimationData2);
        Logger.m7100d(TAG, "setLayoutRect : create - " + hideAnimationData2.hashCode() + " : " + rect2);
    }
}
