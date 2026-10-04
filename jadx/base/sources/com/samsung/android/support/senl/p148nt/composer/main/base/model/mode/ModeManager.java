package com.samsung.android.support.senl.p148nt.composer.main.base.model.mode;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Observable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ModeManager extends Observable {
    private static final String TAG = Logger.createTag("ModeManager");
    private boolean mIsInputFormMode;
    private Mode mLastEditMode = Mode.Text;
    private Mode mMode;
    private Mode mPrevMode;
    private SubMode mSubMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ExtraMode {
        InputForm
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SIPShowType {
        NONE,
        FORCE,
        DELAY,
        NOT
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SoftInputManagerContract {
        void blockToShow(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SubMode {
        NONE,
        DELETE_ONLY,
        MOVE_ONLY
    }

    public ModeManager() {
        Mode mode = Mode.None;
        this.mPrevMode = mode;
        this.mMode = mode;
        this.mSubMode = SubMode.NONE;
    }

    public Mode getLastEditMode() {
        return this.mLastEditMode;
    }

    public Mode getMode() {
        return this.mMode;
    }

    public Mode getPrevMode() {
        return this.mPrevMode;
    }

    public void init(boolean z, boolean z2, boolean z3) {
        init(z, z2, z3, false, false);
    }

    public boolean isComposerSearchMode(Mode mode) {
        return mode == Mode.Search;
    }

    public boolean isComposerViewMode() {
        return isComposerViewMode(this.mMode);
    }

    public boolean isDeleteOnlyMode() {
        return this.mSubMode == SubMode.DELETE_ONLY;
    }

    public boolean isEditMode() {
        return isEditModeWithoutReadOnly(this.mMode);
    }

    public boolean isEditModeWithReadOnly() {
        return isEditModeWithReadOnly(this.mMode);
    }

    public boolean isEditModeWithoutReadOnly() {
        return isEditModeWithoutReadOnly(this.mMode);
    }

    public boolean isInputFormMode() {
        return this.mIsInputFormMode;
    }

    public boolean isMode(Mode mode) {
        return this.mMode.equals(mode);
    }

    public boolean isMoveOnlyMode() {
        return this.mSubMode == SubMode.MOVE_ONLY;
    }

    public boolean isPreModeComposerSearchMode() {
        return isComposerSearchMode(this.mPrevMode);
    }

    public boolean isPreModeComposerViewMode() {
        return isComposerViewMode(this.mPrevMode);
    }

    public boolean isSipMode() {
        Mode mode = this.mMode;
        return mode == Mode.Text || mode == Mode.Search;
    }

    public boolean isSubModeEnabled() {
        return this.mSubMode != SubMode.NONE;
    }

    public void restoreMode(String str, String str2, boolean z, boolean z2, SoftInputManagerContract softInputManagerContract, boolean z3, boolean z4) {
        if (z) {
            setMode(Mode.Init, "restoreMode# ", true);
        }
        Mode mode = getMode(str);
        if (mode == Mode.Text || mode == Mode.Search) {
            boolean z5 = z2 && softInputManagerContract != null;
            if (z5) {
                softInputManagerContract.blockToShow(true);
            }
            setMode(mode, "restoreMode# ", true, z5 ? SIPShowType.NOT : SIPShowType.DELAY);
            if (z5) {
                softInputManagerContract.blockToShow(false);
            }
        } else {
            setMode(mode, "restoreMode# ", true);
            if (mode == Mode.ReadOnly) {
                setPrevMode(getMode(str2));
            }
        }
        SubMode subMode = SubMode.NONE;
        if (z4) {
            subMode = SubMode.MOVE_ONLY;
        } else if (z3) {
            subMode = SubMode.DELETE_ONLY;
        }
        setSubMode(subMode, true);
    }

    public void setDeleteOnlyMode(boolean z) {
        setSubMode(z ? SubMode.DELETE_ONLY : SubMode.NONE, false);
    }

    public void setInputFormMode(boolean z) {
        if (this.mIsInputFormMode == z) {
            return;
        }
        this.mIsInputFormMode = z;
        setChanged();
        notifyObservers(ExtraMode.InputForm);
    }

    public void setMode(Mode mode, @Nullable String str, boolean z) {
        setMode(mode, str, z, null);
    }

    public void setMoveOnlyMode(boolean z) {
        setSubMode(z ? SubMode.MOVE_ONLY : SubMode.NONE, false);
    }

    public void setPrevMode(Mode mode) {
        Logger.m10999d(TAG, "setPrevMode# request " + mode + ", current: " + this.mPrevMode);
        this.mPrevMode = mode;
    }

    public void setSubMode(SubMode subMode, boolean z) {
        if (z || !this.mSubMode.equals(subMode)) {
            this.mSubMode = subMode;
            setChanged();
            notifyObservers(this.mSubMode);
        }
    }

    private boolean isComposerViewMode(Mode mode) {
        return mode == Mode.View || mode == Mode.Search;
    }

    public Mode getMode(String str) {
        return str == null ? Mode.Init : Mode.valueOf(str);
    }

    public void init(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        setMode(z4 ? Mode.ReadOnly : z3 ? Mode.Init : (z || z5) ? (z2 || z5) ? Mode.Writing : Mode.Text : Mode.View, " init#", true, SIPShowType.FORCE);
    }

    public boolean isEditModeWithReadOnly(Mode mode) {
        return isEditModeWithoutReadOnly(mode) || mode.equals(Mode.ReadOnly);
    }

    public boolean isEditModeWithoutReadOnly(Mode mode) {
        return mode.equals(Mode.Text) || mode.equals(Mode.Writing);
    }

    public void setMode(Mode mode, @Nullable String str, boolean z, Object obj) {
        Logger.m11003i(TAG, "setMode# request " + mode + ", current: " + this.mMode + " message: " + str);
        if (isMode(mode)) {
            return;
        }
        this.mPrevMode = this.mMode;
        this.mMode = mode;
        if (mode == Mode.Text || mode == Mode.Writing) {
            this.mLastEditMode = mode;
        }
        if (z) {
            setChanged();
            notifyObservers(obj);
        }
    }
}
