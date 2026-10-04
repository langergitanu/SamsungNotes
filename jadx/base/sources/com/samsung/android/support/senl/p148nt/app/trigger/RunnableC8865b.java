package com.samsung.android.support.senl.p148nt.app.trigger;

import android.net.Uri;
import com.samsung.android.support.senl.p148nt.app.trigger.DocOpenTriggerActivity;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskFactory;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.trigger.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8865b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6336a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6337b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6338c;

    public /* synthetic */ RunnableC8865b(Object obj, Object obj2, int i) {
        this.f6336a = i;
        this.f6337b = obj;
        this.f6338c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6336a) {
            case 0:
                ((DocOpenTriggerActivity.C88618) this.f6337b).lambda$onPreFailed$0((ConvertTaskFactory.IConvertTaskFactoryCallback.ErrorMsg) this.f6338c);
                break;
            case 1:
                ((DocOpenTriggerActivity.C88618) this.f6337b).lambda$onPreFailed$1((ConvertTaskFactory.IConvertTaskFactoryCallback.ErrorMsg) this.f6338c);
                break;
            default:
                ((DocOpenTriggerActivity.C88596) this.f6337b).lambda$onFailedUnsupportedDocType$0((Uri) this.f6338c);
                break;
        }
    }
}
