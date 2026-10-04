package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.inject.Provider;
import java.util.Map;

/* JADX INFO: renamed from: com.google.firebase.components.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC5947e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3466a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3467b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f3468c;

    public /* synthetic */ RunnableC5947e(Object obj, Object obj2, int i) {
        this.f3466a = i;
        this.f3468c = obj;
        this.f3467b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3466a) {
            case 0:
                ((OptionalProvider) this.f3468c).set((Provider) this.f3467b);
                break;
            case 1:
                ((LazySet) this.f3468c).add((Provider) this.f3467b);
                break;
            default:
                EventBus.lambda$publish$0((Map.Entry) this.f3468c, (Event) this.f3467b);
                break;
        }
    }
}
