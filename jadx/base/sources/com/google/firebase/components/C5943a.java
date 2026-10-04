package com.google.firebase.components;

import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;

/* JADX INFO: renamed from: com.google.firebase.components.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5943a implements ComponentFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3458a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3459b;

    public /* synthetic */ C5943a(Object obj, int i) {
        this.f3458a = i;
        this.f3459b = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f3458a) {
            case 0:
                return Component.lambda$of$2(this.f3459b, componentContainer);
            case 1:
                return Component.lambda$intoSet$4(this.f3459b, componentContainer);
            case 2:
                return Component.lambda$intoSet$3(this.f3459b, componentContainer);
            case 3:
                return Component.lambda$of$0(this.f3459b, componentContainer);
            case 4:
                return Component.lambda$of$1(this.f3459b, componentContainer);
            default:
                return DefaultHeartBeatController.lambda$component$3((Qualified) this.f3459b, componentContainer);
        }
    }
}
