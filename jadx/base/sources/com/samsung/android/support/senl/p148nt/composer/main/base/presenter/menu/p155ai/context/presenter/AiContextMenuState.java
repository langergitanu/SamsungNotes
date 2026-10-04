package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiBixbyParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiContextMenuState {
    private boolean mClearTextSelectionFlag;
    private boolean mIsBlockToReleaseSelection;
    private boolean mIsFirstShowForNextSelectionView;
    private boolean mIsHwContext;
    private boolean mIsInitializing;
    private boolean mIsStartTextMode;
    private boolean mIsWaitingMaxSelection;
    private boolean mIsShowing = false;
    private String mSAForAIScenario = "";
    private String mSAForAIScenarioScreenID = "802";

    public String getSAAITypeDetail(AiBixbyParam aiBixbyParam) {
        int action = aiBixbyParam.getAction();
        return action == 3 ? "a" : action == 4 ? "b" : action == 2 ? aiBixbyParam.isOnDevice() ? "f" : "c" : action == 5 ? "d" : action == 1 ? "e" : "";
    }

    public String getSAScenario() {
        return this.mSAForAIScenario;
    }

    public String getSAScreenID() {
        return this.mSAForAIScenarioScreenID;
    }

    public void initShowState() {
        this.mIsShowing = true;
        this.mIsInitializing = true;
        this.mIsFirstShowForNextSelectionView = true;
        this.mIsWaitingMaxSelection = false;
    }

    public boolean isBlockToReleaseSelection() {
        return this.mIsBlockToReleaseSelection;
    }

    public boolean isClearTextSelectionFlag() {
        return this.mClearTextSelectionFlag;
    }

    public boolean isFirstShowForNextSelectionView() {
        return this.mIsFirstShowForNextSelectionView;
    }

    public boolean isHwContext() {
        return this.mIsHwContext;
    }

    public boolean isInitializing() {
        return this.mIsInitializing;
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public boolean isStartTextMode() {
        return this.mIsStartTextMode;
    }

    public boolean isWaitingMaxSelection() {
        return this.mIsWaitingMaxSelection;
    }

    public void setBlockToReleaseSelection(boolean z) {
        this.mIsBlockToReleaseSelection = z;
    }

    public void setClearTextSelectionFlag(boolean z) {
        this.mClearTextSelectionFlag = z;
    }

    public void setFirstShowForNextSelectionView(boolean z) {
        this.mIsFirstShowForNextSelectionView = z;
    }

    public void setHwContext(boolean z) {
        this.mIsHwContext = z;
    }

    public void setInitializing(boolean z) {
        this.mIsInitializing = z;
    }

    public void setSAScenario(String str) {
        this.mSAForAIScenario = str;
    }

    public void setSAScreenID(String str) {
        this.mSAForAIScenarioScreenID = str;
    }

    public void setShowing(boolean z) {
        this.mIsShowing = z;
    }

    public void setStartTextMode(boolean z) {
        this.mIsStartTextMode = z;
    }

    public void setWaitingMaxSelection(boolean z) {
        this.mIsWaitingMaxSelection = z;
    }
}
