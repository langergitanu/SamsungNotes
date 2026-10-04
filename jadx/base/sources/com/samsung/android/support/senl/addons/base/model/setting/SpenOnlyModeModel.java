package com.samsung.android.support.senl.addons.base.model.setting;

import android.os.Bundle;
import com.samsung.android.support.senl.addons.base.model.common.AbsBaseModel;
import com.samsung.android.support.senl.addons.base.model.common.ISavableModel;
import com.samsung.android.support.senl.addons.base.model.mode.ISpenOnlyMode;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p145cm.base.common.util.SpenUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001 B\u0013\b\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\nJ\b\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/setting/SpenOnlyModeModel;", "Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;", "Lcom/samsung/android/support/senl/addons/base/model/mode/ISpenOnlyMode;", "Lcom/samsung/android/support/senl/addons/base/model/common/ISavableModel;", "handler", "Lcom/samsung/android/support/senl/addons/base/model/setting/ISPenOnlyModeHandler;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/setting/ISPenOnlyModeHandler;)V", "mSpenOnlyModeHandler", "mIsSpenOnlyMode", "", "mIsSpenActivated", "mFoldStateListener", "Lcom/samsung/android/support/senl/cm/base/framework/view/FoldStateCompat$FoldStateChangeListener;", "setSpenOnlyModeHandler", "", "getSpenOnlyMode", "setSpenOnlyMode", "enable", "close", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "onLoadFromInstanceState", "inState", "setSpenActivated", "isActivated", "initFoldedDevice", "releaseFoldDevice", "logSpenInformations", NotesConstants.KEY_CALLER, "", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class SpenOnlyModeModel extends AbsBaseModel implements ISpenOnlyMode, ISavableModel {

    @NotNull
    private static final String TAG = Logger.createTag("SpenOnlyModeModel");

    @Nullable
    private FoldStateCompat.FoldStateChangeListener mFoldStateListener;
    private boolean mIsSpenActivated;
    private boolean mIsSpenOnlyMode;

    @Nullable
    private ISPenOnlyModeHandler mSpenOnlyModeHandler;

    public SpenOnlyModeModel(@Nullable ISPenOnlyModeHandler iSPenOnlyModeHandler) {
        setSpenOnlyModeHandler(iSPenOnlyModeHandler);
    }

    private final void initFoldedDevice() {
        if (this.mFoldStateListener == null) {
            this.mFoldStateListener = new FoldStateCompat.FoldStateChangeListener() { // from class: com.samsung.android.support.senl.addons.base.model.setting.SpenOnlyModeModel.initFoldedDevice.1
                @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FoldStateChangeListener
                public void onChanged(boolean isFolded) {
                    Logger.m7104i(SpenOnlyModeModel.TAG, "folded = " + isFolded);
                    SpenOnlyModeModel.this.setSpenActivated(!isFolded && SpenUtils.isSpenActivated());
                }
            };
        }
        FoldStateCompat.INSTANCE.getInstance().registerFoldStateListener(this.mFoldStateListener);
    }

    private final void logSpenInformations(String caller) {
        Logger.m7104i(TAG, caller + " : Spen Activated / OnlyMode = " + this.mIsSpenActivated + "/" + this.mIsSpenOnlyMode);
    }

    private final void releaseFoldDevice() {
        if (this.mFoldStateListener != null) {
            FoldStateCompat.INSTANCE.getInstance().unregisterFoldStateListener(this.mFoldStateListener);
            this.mFoldStateListener = null;
        }
    }

    public void close() {
        releaseFoldDevice();
        this.mSpenOnlyModeHandler = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.mode.ISpenOnlyMode
    public boolean getSpenOnlyMode() {
        ISPenOnlyModeHandler iSPenOnlyModeHandler = this.mSpenOnlyModeHandler;
        if (iSPenOnlyModeHandler != null) {
            Intrinsics.checkNotNull(iSPenOnlyModeHandler);
            boolean zIsSPenOnlyMode = iSPenOnlyModeHandler.isSPenOnlyMode();
            if (zIsSPenOnlyMode != this.mIsSpenOnlyMode) {
                this.mIsSpenOnlyMode = zIsSPenOnlyMode;
                notifyChanged(401);
                logSpenInformations("getSpenOnlyMode");
            }
        }
        return this.mIsSpenActivated && this.mIsSpenOnlyMode;
    }

    public void onLoadFromInstanceState(@NotNull Bundle inState) {
        Intrinsics.checkNotNullParameter(inState, "inState");
    }

    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    public final void setSpenActivated(boolean isActivated) {
        if (this.mIsSpenActivated != isActivated) {
            this.mIsSpenActivated = isActivated;
            notifyChanged(401);
            logSpenInformations("setSpenActivated");
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.mode.ISpenOnlyMode
    public void setSpenOnlyMode(boolean enable) {
        ISPenOnlyModeHandler iSPenOnlyModeHandler = this.mSpenOnlyModeHandler;
        Intrinsics.checkNotNull(iSPenOnlyModeHandler);
        if (iSPenOnlyModeHandler.isSPenOnlyMode() != enable) {
            ISPenOnlyModeHandler iSPenOnlyModeHandler2 = this.mSpenOnlyModeHandler;
            Intrinsics.checkNotNull(iSPenOnlyModeHandler2);
            iSPenOnlyModeHandler2.setSPenOnlyMode(enable);
            this.mIsSpenOnlyMode = enable;
            logSpenInformations("setSpenOnlyMode");
            notifyChanged(401);
        }
    }

    public final void setSpenOnlyModeHandler(@Nullable ISPenOnlyModeHandler handler) {
        this.mSpenOnlyModeHandler = handler;
        this.mIsSpenActivated = SpenUtils.isSpenActivated();
        initFoldedDevice();
        logSpenInformations("setSpenOnlyModeHandler");
    }
}
