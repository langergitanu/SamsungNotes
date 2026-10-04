package com.samsung.android.support.senl.p148nt.app.inapp;

import com.samsung.android.support.senl.p148nt.app.inapp.InAppCollaborationActivity;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.inapp.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8056a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6104a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ InAppCollaborationActivity f6105b;

    public /* synthetic */ RunnableC8056a(InAppCollaborationActivity inAppCollaborationActivity, int i) {
        this.f6104a = i;
        this.f6105b = inAppCollaborationActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6104a) {
            case 0:
                this.f6105b.finishActivity();
                break;
            default:
                InAppCollaborationActivity.C80531.readyToInAppCollaboration$lambda$1(this.f6105b);
                break;
        }
    }
}
