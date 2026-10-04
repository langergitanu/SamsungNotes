package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.tracing.ComponentMonitor;

/* JADX INFO: renamed from: com.google.firebase.platforminfo.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5999a implements ComponentFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3544a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f3545b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f3546c;

    public /* synthetic */ C5999a(int i, Object obj, String str) {
        this.f3544a = i;
        this.f3545b = str;
        this.f3546c = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f3544a) {
            case 0:
                return LibraryVersionComponent.lambda$fromContext$0(this.f3545b, (LibraryVersionComponent.VersionExtractor) this.f3546c, componentContainer);
            default:
                return ComponentMonitor.lambda$processRegistrar$0(this.f3545b, (Component) this.f3546c, componentContainer);
        }
    }
}
