package com.samsung.android.support.senl.addons.base.viewmodel.animation;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IPreTouchListener;
import com.samsung.android.support.senl.addons.base.model.event.LayoutChangeEvent;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0016\u0018\u0000 82\u00020\u0001:\u00018B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0014H\u0014J\b\u0010\u001f\u001a\u00020\u0014H\u0014J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\bH\u0004J\u0010\u0010'\u001a\u00020\"2\u0006\u0010&\u001a\u00020\bH\u0002JP\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020,H\u0016J\u0010\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007J\b\u00105\u001a\u00020\u0014H\u0014J\b\u00106\u001a\u00020\u0014H\u0014J\b\u00107\u001a\u00020\u0014H\u0014R$\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0005R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/animation/MenuHideViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "facade", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;)V", "mHideAnimationArray", "Landroid/util/SparseArray;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/animation/HideAnimationData;", "getMHideAnimationArray", "()Landroid/util/SparseArray;", "setMHideAnimationArray", "(Landroid/util/SparseArray;)V", "mFacade", "getMFacade", "()Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", "setMFacade", "mPreTouchListener", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPreTouchListener;", "perform", "", "action", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", "getData", "", "id", "", "onActionCanceled", "motionEvent", "Landroid/view/MotionEvent;", "onActionDown", "onActionUp", "onActionMove", "hasTouchPosition", "", "rect", "Landroid/graphics/Rect;", "isAvailableRunAnimation", "hideAnimationData", "isAvailableStopAnimation", "onLayoutChange", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "getMenuHideAnimation", "closeSubViewModels", "clearModels", "closeCallbacks", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class MenuHideViewModel extends AbsBaseViewModel {

    @NotNull
    private static final String BINDING_ID_HIDE_MENU = "menuHideAnimation";

    @NotNull
    private static final String TAG = Logger.createTag("MenuHideViewModel");

    @Nullable
    private IFacade mFacade;

    @Nullable
    private SparseArray<HideAnimationData> mHideAnimationArray = new SparseArray<>();

    @Nullable
    private IPreTouchListener mPreTouchListener = new IPreTouchListener() { // from class: com.samsung.android.support.senl.addons.base.viewmodel.animation.MenuHideViewModel$mPreTouchListener$1
        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IPreTouchListener
        public boolean onPreTouch(MotionEvent motionEvent) {
            Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getActionMasked()) : null;
            if ((numValueOf != null && numValueOf.intValue() == 0) || (numValueOf != null && numValueOf.intValue() == 211)) {
                this.this$0.onActionDown();
                return false;
            }
            if ((numValueOf != null && numValueOf.intValue() == 2) || (numValueOf != null && numValueOf.intValue() == 213)) {
                this.this$0.onActionMove(motionEvent);
                return false;
            }
            if ((numValueOf != null && numValueOf.intValue() == 1) || (numValueOf != null && numValueOf.intValue() == 212)) {
                this.this$0.onActionUp();
                return false;
            }
            if (numValueOf == null || numValueOf.intValue() != 3) {
                return false;
            }
            this.this$0.onActionCanceled(motionEvent);
            return false;
        }
    };

    public MenuHideViewModel(@Nullable IFacade iFacade) {
        this.mFacade = iFacade;
        IFacade iFacade2 = this.mFacade;
        Intrinsics.checkNotNull(iFacade2);
        iFacade2.setPreTouchListener(this.mPreTouchListener);
    }

    private final boolean hasTouchPosition(Rect rect, MotionEvent motionEvent) {
        if (rect != null) {
            return rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return false;
    }

    private final boolean isAvailableStopAnimation(HideAnimationData hideAnimationData) {
        return hideAnimationData.getMLayoutRect() != null && hideAnimationData.getMHideAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void perform$lambda$0(MenuHideViewModel menuHideViewModel, LayoutChangeEvent layoutChangeEvent) {
        View view = layoutChangeEvent.mView;
        Intrinsics.checkNotNull(view);
        menuHideViewModel.onLayoutChange(view, layoutChangeEvent.mLeft, layoutChangeEvent.mTop, layoutChangeEvent.mRight, layoutChangeEvent.mBottom, layoutChangeEvent.mOldLeft, layoutChangeEvent.mOldTop, layoutChangeEvent.mOldRight, layoutChangeEvent.mOldBottom);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        IFacade iFacade = this.mFacade;
        if (iFacade != null) {
            Intrinsics.checkNotNull(iFacade);
            iFacade.setPreTouchListener(null);
            this.mPreTouchListener = null;
            this.mFacade = null;
        }
        SparseArray<HideAnimationData> sparseArray = this.mHideAnimationArray;
        if (sparseArray != null) {
            Intrinsics.checkNotNull(sparseArray);
            sparseArray.clear();
            this.mHideAnimationArray = null;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        return Intrinsics.areEqual(BINDING_ID_HIDE_MENU, id) ? getMenuHideAnimation() : super.getData(id);
    }

    @Nullable
    public final IFacade getMFacade() {
        return this.mFacade;
    }

    @Nullable
    public final SparseArray<HideAnimationData> getMHideAnimationArray() {
        return this.mHideAnimationArray;
    }

    @Nullable
    public final SparseArray<HideAnimationData> getMenuHideAnimation() {
        return this.mHideAnimationArray;
    }

    public final boolean isAvailableRunAnimation(@NotNull HideAnimationData hideAnimationData) {
        Intrinsics.checkNotNullParameter(hideAnimationData, "hideAnimationData");
        if (hideAnimationData.getMLayoutRect() == null) {
            return false;
        }
        Rect mLayoutRect = hideAnimationData.getMLayoutRect();
        Intrinsics.checkNotNull(mLayoutRect);
        return (mLayoutRect.isEmpty() || hideAnimationData.getMHideAnimation()) ? false : true;
    }

    public void onActionCanceled(@Nullable MotionEvent motionEvent) {
    }

    public void onActionDown() {
    }

    public void onActionMove(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        SparseArray<HideAnimationData> sparseArray = this.mHideAnimationArray;
        if (sparseArray == null) {
            return;
        }
        Intrinsics.checkNotNull(sparseArray);
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            SparseArray<HideAnimationData> sparseArray2 = this.mHideAnimationArray;
            Intrinsics.checkNotNull(sparseArray2);
            int iKeyAt = sparseArray2.keyAt(i);
            SparseArray<HideAnimationData> sparseArray3 = this.mHideAnimationArray;
            Intrinsics.checkNotNull(sparseArray3);
            HideAnimationData hideAnimationData = sparseArray3.get(iKeyAt);
            if (hideAnimationData != null && isAvailableRunAnimation(hideAnimationData) && hasTouchPosition(hideAnimationData.getMLayoutRect(), motionEvent)) {
                hideAnimationData.setRunAnimation(true);
                notifyChanged(BINDING_ID_HIDE_MENU);
            }
        }
    }

    public void onActionUp() {
        SparseArray<HideAnimationData> sparseArray = this.mHideAnimationArray;
        if (sparseArray == null) {
            return;
        }
        Intrinsics.checkNotNull(sparseArray);
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            SparseArray<HideAnimationData> sparseArray2 = this.mHideAnimationArray;
            Intrinsics.checkNotNull(sparseArray2);
            int iKeyAt = sparseArray2.keyAt(i);
            SparseArray<HideAnimationData> sparseArray3 = this.mHideAnimationArray;
            Intrinsics.checkNotNull(sparseArray3);
            HideAnimationData hideAnimationData = sparseArray3.get(iKeyAt);
            if (hideAnimationData != null && isAvailableStopAnimation(hideAnimationData)) {
                hideAnimationData.setRunAnimation(false);
                notifyChanged(BINDING_ID_HIDE_MENU);
            }
        }
    }

    public void onLayoutChange(@NotNull View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.mFacade == null && this.mHideAnimationArray == null) {
            return;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        IFacade iFacade = this.mFacade;
        int[] viewPositionInWindow = iFacade != null ? iFacade.getViewPositionInWindow() : null;
        view.getLocationInWindow(iArr);
        view.getLocalVisibleRect(rect);
        int i = iArr[0] - rect.left;
        Intrinsics.checkNotNull(viewPositionInWindow);
        rect.offset(i - viewPositionInWindow[0], (iArr[1] - rect.top) - viewPositionInWindow[1]);
        int id = view.getId();
        SparseArray<HideAnimationData> sparseArray = this.mHideAnimationArray;
        Intrinsics.checkNotNull(sparseArray);
        HideAnimationData hideAnimationData = sparseArray.get(id);
        if (hideAnimationData != null) {
            hideAnimationData.setLayoutRect(rect);
            Logger.m7100d(TAG, "onLayoutChange : update - " + hideAnimationData.hashCode() + " : " + rect);
            return;
        }
        HideAnimationData hideAnimationData2 = new HideAnimationData(rect, false);
        SparseArray<HideAnimationData> sparseArray2 = this.mHideAnimationArray;
        Intrinsics.checkNotNull(sparseArray2);
        sparseArray2.put(view.getId(), hideAnimationData2);
        Logger.m7100d(TAG, "onLayoutChange : create - " + hideAnimationData2.hashCode() + " : " + rect);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void perform(@Nullable IBaseViewModel.Action action) {
        LayoutChangeEvent layoutChangeEvent;
        View view;
        if (!Intrinsics.areEqual("action_layoutChange", action != null ? action.getMTypeId() : null) || (layoutChangeEvent = (LayoutChangeEvent) action.getData()) == null || (view = layoutChangeEvent.mView) == null) {
            return;
        }
        view.post(new RunnableC4199v(this, layoutChangeEvent, 13));
    }

    public final void setMFacade(@Nullable IFacade iFacade) {
        this.mFacade = iFacade;
    }

    public final void setMHideAnimationArray(@Nullable SparseArray<HideAnimationData> sparseArray) {
        this.mHideAnimationArray = sparseArray;
    }
}
