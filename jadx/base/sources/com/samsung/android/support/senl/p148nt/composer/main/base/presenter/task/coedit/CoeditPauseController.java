package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.coedit;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.CoeditAdapter;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditPauseController {
    private final CoeditAdapter mCoeditAdapter;
    private SynchronizedCancelAction mSynchronizedCancelAction;
    private Contract mTarget;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        SynchronizedCancelAction getSynchronizedCancelAction();

        String getTag();

        boolean isCoeditNoTimeoutPause();
    }

    public CoeditPauseController(CoeditAdapter coeditAdapter) {
        this.mCoeditAdapter = coeditAdapter;
    }

    public void pauseCoedit() {
        int iPauseCoedit;
        CoeditAdapter coeditAdapter = this.mCoeditAdapter;
        if (coeditAdapter == null || !coeditAdapter.isCoeditNote()) {
            return;
        }
        if (this.mTarget.isCoeditNoTimeoutPause()) {
            iPauseCoedit = this.mCoeditAdapter.pauseCoeditNoTimeout(this.mTarget.getTag());
        } else {
            SynchronizedCancelAction synchronizedCancelAction = this.mTarget.getSynchronizedCancelAction();
            this.mSynchronizedCancelAction = synchronizedCancelAction;
            if (synchronizedCancelAction == null) {
                return;
            } else {
                iPauseCoedit = this.mCoeditAdapter.pauseCoedit(this.mTarget.getTag(), this.mSynchronizedCancelAction);
            }
        }
        AbstractC0000a.m3D(iPauseCoedit, "pauseCoedit# ", this.mTarget.getTag());
    }

    public void resumeCoedit() {
        CoeditAdapter coeditAdapter = this.mCoeditAdapter;
        if (coeditAdapter == null || !coeditAdapter.isCoeditNote()) {
            return;
        }
        AbstractC0000a.m3D(this.mTarget.isCoeditNoTimeoutPause() ? this.mCoeditAdapter.resumeCoeditNoTimeout(this.mTarget.getTag()) : this.mCoeditAdapter.resumeCoedit(this.mTarget.getTag()), "resumeCoedit# ", this.mTarget.getTag());
        this.mSynchronizedCancelAction = null;
    }

    public void setContract(Contract contract) {
        this.mTarget = contract;
    }
}
