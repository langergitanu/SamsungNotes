package com.samsung.android.support.senl.addons.base.viewmodel;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.model.event.ITouchEvent;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0004¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0014J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u0012H\u0016J\b\u0010'\u001a\u00020\u000eH\u0016J\b\u0010(\u001a\u00020\u000eH\u0016J\b\u0010)\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020\u000eH\u0016J\b\u0010+\u001a\u00020\u000eH\u0016J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\"H\u0002J\u0010\u00100\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\"H\u0002J\u0010\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u000eH\u0016J\b\u00103\u001a\u00020\u000eH\u0016J\u0010\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u000eH\u0016J\b\u00106\u001a\u00020\u000eH\u0016J\u0010\u00107\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u000eH\u0016J\b\u00108\u001a\u00020\u000eH\u0016J\b\u00109\u001a\u00020\u0012H\u0002J\b\u0010:\u001a\u00020\u0012H\u0002J\b\u0010;\u001a\u00020\u0012H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsUndoRedoViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsModelControlViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/IUndoRedoViewModel;", "facade", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;)V", "mSettingsModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "getMSettingsModel", "()Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "setMSettingsModel", "(Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;)V", "mOnDoingRedoUndo", "", "mIsRedoLongPressed", "mIsUndoLongPressed", "perform", "", "action", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", "performActionTouch", "performActionLongClick", "isDrawing", "()Ljava/lang/Boolean;", "performActionClick", "getData", "", "id", "", "setSettingsModel", "model", "isObjectChanged", "propertyId", "", "onObjectChanged", AbsUndoRedoViewModel.BINDING_ID_UNDO_CLICKED, AbsUndoRedoViewModel.BINDING_ID_UNDO_LONG_CLICKED, AbsUndoRedoViewModel.BINDING_ID_REDO_CLICKED, AbsUndoRedoViewModel.BINDING_ID_REDO_LONG_CLICKED, "getUndoSelected", "getUndoEnabled", "getRedoSelected", "getRedoEnabled", "touchUndoRedo", "touchEvent", "Lcom/samsung/android/support/senl/addons/base/model/event/ITouchEvent;", "isReleaseAction", "isTouchAction", "setOnDoingRedoUndo", "onDoingRedoUndo", "getOnDoingRedoUndo", "setUndoLongPressed", "isLongPressed", "getUndoLongPressed", "setRedoLongPressed", "getRedoLongPressed", "onTouchReleased", "hidePopups", "clearModels", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsUndoRedoViewModel extends AbsModelControlViewModel implements IUndoRedoViewModel {

    @NotNull
    private static final String BINDING_ID_REDO_CLICKED = "onRedoClicked";

    @NotNull
    private static final String BINDING_ID_REDO_ENABLED = "redoEnabled";

    @NotNull
    private static final String BINDING_ID_REDO_LONG_CLICKED = "onRedoLongClicked";

    @NotNull
    private static final String BINDING_ID_REDO_SELECTED = "redoSelected";

    @NotNull
    private static final String BINDING_ID_UNDO_CLICKED = "onUndoClicked";

    @NotNull
    private static final String BINDING_ID_UNDO_ENABLED = "undoEnabled";

    @NotNull
    private static final String BINDING_ID_UNDO_LONG_CLICKED = "onUndoLongClicked";

    @NotNull
    private static final String BINDING_ID_UNDO_REDO_TOUCH = "undoRedoTouch";

    @NotNull
    private static final String BINDING_ID_UNDO_SELECTED = "undoSelected";

    @NotNull
    private static final String TAG = Logger.createTag("AbsUndoRedoViewModel");
    private boolean mIsRedoLongPressed;
    private boolean mIsUndoLongPressed;
    private boolean mOnDoingRedoUndo;

    @Nullable
    private SettingsModel mSettingsModel;

    public AbsUndoRedoViewModel(@Nullable IFacade iFacade) {
        super(iFacade);
    }

    private final void hidePopups() {
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            settingsModel.hideShowingPopup();
        }
    }

    private final boolean isReleaseAction(int action) {
        return action == 1 || action == 3;
    }

    private final boolean isTouchAction(int action) {
        return action == 0 || action == 2;
    }

    private final void onTouchReleased() {
        setUndoLongPressed(false);
        setRedoLongPressed(false);
    }

    private final void performActionClick(IBaseViewModel.Action action) {
        String mBindId = action.getMBindId();
        if (Intrinsics.areEqual(BINDING_ID_UNDO_CLICKED, mBindId)) {
            onUndoClicked();
        } else if (Intrinsics.areEqual(BINDING_ID_REDO_CLICKED, mBindId)) {
            onRedoClicked();
        }
    }

    private final void performActionLongClick(IBaseViewModel.Action action) {
        String mBindId = action.getMBindId();
        if (Intrinsics.areEqual(BINDING_ID_UNDO_LONG_CLICKED, mBindId)) {
            onUndoLongClicked();
        } else if (Intrinsics.areEqual(BINDING_ID_REDO_LONG_CLICKED, mBindId)) {
            onRedoLongClicked();
        }
    }

    private final void performActionTouch(IBaseViewModel.Action action) {
        if (Intrinsics.areEqual(BINDING_ID_UNDO_REDO_TOUCH, action.getMBindId())) {
            Object data = action.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.samsung.android.support.senl.addons.base.model.event.ITouchEvent");
            action.setResult(Boolean.valueOf(touchUndoRedo((ITouchEvent) data)));
        }
    }

    private final boolean touchUndoRedo(ITouchEvent touchEvent) {
        View mView = touchEvent.getMView();
        MotionEvent mMotionEvent = touchEvent.getMMotionEvent();
        Intrinsics.checkNotNull(mMotionEvent);
        int action = mMotionEvent.getAction();
        if (isTouchAction(action)) {
            Intrinsics.checkNotNull(mView);
            mView.setSelected(true);
        } else if (isReleaseAction(action)) {
            Intrinsics.checkNotNull(mView);
            mView.setSelected(false);
            onTouchReleased();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsModelControlViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        this.mSettingsModel = null;
        super.clearModels();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        return Intrinsics.areEqual(BINDING_ID_UNDO_SELECTED, id) ? Boolean.valueOf(getUndoSelected()) : Intrinsics.areEqual(BINDING_ID_UNDO_ENABLED, id) ? Boolean.valueOf(getUndoEnabled()) : Intrinsics.areEqual(BINDING_ID_REDO_SELECTED, id) ? Boolean.valueOf(getRedoSelected()) : Intrinsics.areEqual(BINDING_ID_REDO_ENABLED, id) ? Boolean.valueOf(getRedoEnabled()) : super.getData(id);
    }

    @Nullable
    public final SettingsModel getMSettingsModel() {
        return this.mSettingsModel;
    }

    /* JADX INFO: renamed from: getOnDoingRedoUndo, reason: from getter */
    public boolean getMOnDoingRedoUndo() {
        return this.mOnDoingRedoUndo;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IUndoRedoViewModel
    public boolean getRedoEnabled() {
        IFacade mFacade = getMFacade();
        Intrinsics.checkNotNull(mFacade);
        boolean zIsRedoable = mFacade.isRedoable();
        Logger.m7100d(TAG, "getRedoEnabled isRedoable/isRedoLongPressed : " + zIsRedoable + "/" + this.mIsRedoLongPressed);
        return zIsRedoable;
    }

    /* JADX INFO: renamed from: getRedoLongPressed, reason: from getter */
    public boolean getMIsRedoLongPressed() {
        return this.mIsRedoLongPressed;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IUndoRedoViewModel
    public boolean getRedoSelected() {
        IFacade mFacade = getMFacade();
        Intrinsics.checkNotNull(mFacade);
        boolean zIsRedoable = mFacade.isRedoable();
        Logger.m7100d(TAG, "getRedoSelected isRedoable/isRedoLongPressed : " + zIsRedoable + "/" + this.mIsRedoLongPressed);
        return zIsRedoable && this.mIsRedoLongPressed;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IUndoRedoViewModel
    public boolean getUndoEnabled() {
        IFacade mFacade = getMFacade();
        Intrinsics.checkNotNull(mFacade);
        boolean zIsUndoable = mFacade.isUndoable();
        Logger.m7100d(TAG, "getUndoEnabled isUndoable/isUndoLongPressed : " + zIsUndoable + "/" + this.mIsUndoLongPressed);
        return zIsUndoable;
    }

    /* JADX INFO: renamed from: getUndoLongPressed, reason: from getter */
    public boolean getMIsUndoLongPressed() {
        return this.mIsUndoLongPressed;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IUndoRedoViewModel
    public boolean getUndoSelected() {
        IFacade mFacade = getMFacade();
        Intrinsics.checkNotNull(mFacade);
        boolean zIsUndoable = mFacade.isUndoable();
        Logger.m7100d(TAG, "getUndoSelected isUndoable/isUndoLongPressed : " + zIsUndoable + "/" + this.mIsUndoLongPressed);
        return zIsUndoable && this.mIsUndoLongPressed;
    }

    @Nullable
    public final Boolean isDrawing() {
        IFacade mFacade = getMFacade();
        if (mFacade != null) {
            return Boolean.valueOf(mFacade.isDrawing());
        }
        return null;
    }

    public boolean isObjectChanged(int propertyId) {
        return propertyId >= 11001 && propertyId <= 11007;
    }

    public void onObjectChanged(int propertyId) {
        AbstractC6670b.m4761v(propertyId, "onObjectChanged propertyId ", TAG);
        if (propertyId == 11004) {
            notifyChanged(BINDING_ID_UNDO_SELECTED);
            notifyChanged(BINDING_ID_UNDO_ENABLED);
        } else if (propertyId != 11005) {
            notifyChanged(BINDING_ID_UNDO_ENABLED);
            notifyChanged(BINDING_ID_REDO_ENABLED);
        } else {
            notifyChanged(BINDING_ID_REDO_SELECTED);
            notifyChanged(BINDING_ID_REDO_ENABLED);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IUndoRedoViewModel
    public void onRedoClicked() {
        hidePopups();
        IFacade mFacade = getMFacade();
        Intrinsics.checkNotNull(mFacade);
        mFacade.redo();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IUndoRedoViewModel
    public boolean onRedoLongClicked() {
        hidePopups();
        IFacade mFacade = getMFacade();
        Intrinsics.checkNotNull(mFacade);
        mFacade.redoAll();
        return true;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IUndoRedoViewModel
    public void onUndoClicked() {
        hidePopups();
        IFacade mFacade = getMFacade();
        Intrinsics.checkNotNull(mFacade);
        mFacade.undo();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IUndoRedoViewModel
    public boolean onUndoLongClicked() {
        hidePopups();
        IFacade mFacade = getMFacade();
        Intrinsics.checkNotNull(mFacade);
        mFacade.undoAll();
        return true;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void perform(@Nullable IBaseViewModel.Action action) {
        String mTypeId = action != null ? action.getMTypeId() : null;
        if (Intrinsics.areEqual("action_click", mTypeId)) {
            performActionClick(action);
        } else if (Intrinsics.areEqual("action_long_click", mTypeId)) {
            performActionLongClick(action);
        } else if (Intrinsics.areEqual("action_touch", mTypeId)) {
            performActionTouch(action);
        }
    }

    public final void setMSettingsModel(@Nullable SettingsModel settingsModel) {
        this.mSettingsModel = settingsModel;
    }

    public void setOnDoingRedoUndo(boolean onDoingRedoUndo) {
        AbstractC6670b.m4764y("setOnDoingRedoUndo(), onDoingRedoUndo = ", TAG, onDoingRedoUndo);
        this.mOnDoingRedoUndo = onDoingRedoUndo;
    }

    public void setRedoLongPressed(boolean isLongPressed) {
        AbstractC6670b.m4764y("setRedoLongPressed(), isLongPressed = ", TAG, isLongPressed);
        this.mIsRedoLongPressed = isLongPressed;
    }

    public void setSettingsModel(@NotNull SettingsModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.mSettingsModel = model;
    }

    public void setUndoLongPressed(boolean isLongPressed) {
        AbstractC6670b.m4764y("setUndoLongPressed(), isLongPressed = ", TAG, isLongPressed);
        this.mIsUndoLongPressed = isLongPressed;
    }
}
