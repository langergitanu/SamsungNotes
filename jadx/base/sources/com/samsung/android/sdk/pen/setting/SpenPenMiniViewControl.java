package com.samsung.android.sdk.pen.setting;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenMiniViewControl;", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniViewModeInterface;", "<init>", "()V", "mViewOrientation", "", "mHasRestoreState", "", "orientation", "viewOrientation", "getViewOrientation", "()I", "setViewOrientation", "(I)V", "setRestoreState", "", "hasRestoreState", "saveViewState", "restoreViewState", "clearView", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenPenMiniViewControl implements SpenPenMiniViewModeInterface {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private boolean mHasRestoreState;
    private int mViewOrientation = 1;

    public abstract void clearView();

    /* JADX INFO: renamed from: getViewOrientation, reason: from getter */
    public final int getMViewOrientation() {
        return this.mViewOrientation;
    }

    /* JADX INFO: renamed from: hasRestoreState, reason: from getter */
    public final boolean getMHasRestoreState() {
        return this.mHasRestoreState;
    }

    public final void setRestoreState(boolean hasRestoreState) {
        this.mHasRestoreState = hasRestoreState;
    }

    public final void setViewOrientation(int i) {
        if (getMViewOrientation() == i) {
            return;
        }
        this.mViewOrientation = i;
    }

    public void restoreViewState() {
    }

    public void saveViewState() {
    }
}
