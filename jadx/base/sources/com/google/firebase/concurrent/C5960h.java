package com.google.firebase.concurrent;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.datatransport.TransportRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;

/* JADX INFO: renamed from: com.google.firebase.concurrent.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5960h implements ComponentFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3497a;

    public /* synthetic */ C5960h(int i) {
        this.f3497a = i;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f3497a) {
            case 0:
                return ExecutorsRegistrar.lambda$getComponents$4(componentContainer);
            case 1:
                return ExecutorsRegistrar.lambda$getComponents$5(componentContainer);
            case 2:
                return ExecutorsRegistrar.lambda$getComponents$6(componentContainer);
            case 3:
                return ExecutorsRegistrar.lambda$getComponents$7(componentContainer);
            case 4:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(componentContainer);
            case 5:
                return FirebaseMessagingRegistrar.lambda$getComponents$0(componentContainer);
            case 6:
                return DefaultUserAgentPublisher.lambda$component$0(componentContainer);
            default:
                return TransportRegistrar.lambda$getComponents$0(componentContainer);
        }
    }
}
