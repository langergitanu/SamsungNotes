package com.samsung.android.app.notes.sync.microsoft.graph;

import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import java.util.List;
import p021E0.InterfaceC0074a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.microsoft.graph.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6782d implements InterfaceC0074a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ InterfaceC0074a f4176a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C6785g f4177b;

    public C6782d(C6785g c6785g, InterfaceC0074a interfaceC0074a) {
        this.f4177b = c6785g;
        this.f4176a = interfaceC0074a;
    }

    @Override // p021E0.InterfaceC0074a
    public final void onCancel(List list) {
        StringBuilder sb = new StringBuilder("runTask, onCancel submited : ");
        sb.append(list == null ? 0 : list.size());
        MSLogger.m8632d("GraphManager", sb.toString());
        this.f4177b.f4184d = GraphManager$State.IDLE;
        InterfaceC0074a interfaceC0074a = this.f4176a;
        if (interfaceC0074a != null) {
            interfaceC0074a.onCancel(list);
        }
    }

    @Override // p021E0.InterfaceC0074a
    public final void onResult(List list) {
        StringBuilder sb = new StringBuilder("runTask onResult submited :");
        sb.append(list == null ? 0 : list.size());
        MSLogger.m8632d("GraphManager", sb.toString());
        this.f4177b.f4184d = GraphManager$State.IDLE;
        InterfaceC0074a interfaceC0074a = this.f4176a;
        if (interfaceC0074a != null) {
            interfaceC0074a.onResult(list);
        }
    }
}
