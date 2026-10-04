package com.samsung.android.support.senl.p148nt.app.main.common.coedit;

import com.samsung.android.sdk.mobileservice.social.group.InvitationLink;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CoeditPickerInfo {
    private ActivityFinishedListener mActivityFinishedListener;
    protected InvitationLink mInvitationLink;
    protected boolean mIsStandalone;
    private CoeditSessionConnector.CoeditCreateResult mResultCallback;
    protected String mSpaceName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ActivityFinishedListener {
        void onActivityFinished(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CreateSpace extends CoeditPickerInfo {
        public CreateSpace(String str) {
            this.mSpaceName = str;
            this.mIsStandalone = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CreateStandalone extends CoeditPickerInfo {
        public CreateStandalone(String str) {
            this.mSpaceName = str;
            this.mIsStandalone = true;
        }
    }

    public InvitationLink getInvitationLink() {
        return this.mInvitationLink;
    }

    public String getSpaceName() {
        return this.mSpaceName;
    }

    public boolean isStandalone() {
        return this.mIsStandalone;
    }

    public boolean onFail() {
        CoeditSessionConnector.CoeditCreateResult coeditCreateResult = this.mResultCallback;
        if (coeditCreateResult == null) {
            return false;
        }
        coeditCreateResult.onFail();
        return true;
    }

    public void onSocialActivityFinished(boolean z) {
        ActivityFinishedListener activityFinishedListener = this.mActivityFinishedListener;
        if (activityFinishedListener != null) {
            activityFinishedListener.onActivityFinished(z);
        }
    }

    public boolean onSuccess(String str, String str2) {
        CoeditSessionConnector.CoeditCreateResult coeditCreateResult = this.mResultCallback;
        if (coeditCreateResult == null) {
            return false;
        }
        coeditCreateResult.onSuccess(str, str2, this.mIsStandalone);
        return true;
    }

    public CoeditPickerInfo setActivityFinishedListener(ActivityFinishedListener activityFinishedListener) {
        this.mActivityFinishedListener = activityFinishedListener;
        return this;
    }

    public void setInvitationLink(InvitationLink invitationLink) {
        this.mInvitationLink = invitationLink;
    }

    public CoeditPickerInfo setResultCallback(CoeditSessionConnector.CoeditCreateResult coeditCreateResult) {
        this.mResultCallback = coeditCreateResult;
        return this;
    }
}
