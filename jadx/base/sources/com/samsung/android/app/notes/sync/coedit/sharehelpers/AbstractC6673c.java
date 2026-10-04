package com.samsung.android.app.notes.sync.coedit.sharehelpers;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.app.notes.sync.coedit.deletecore.CoeditDeleteSDocTask;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import p010C.RunnableC0037b;
import p028G.InterfaceC0103b;
import p068Q.C0204a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.sharehelpers.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6673c extends AbstractC6671a implements InterfaceC0103b {

    /* JADX INFO: renamed from: h */
    public InterfaceC0103b f3955h;

    /* JADX INFO: renamed from: i */
    public CoeditDeleteSDocTask f3956i;

    /* JADX INFO: renamed from: j */
    public List f3957j;

    public AbstractC6673c(Context context, Class cls) {
        super(context, cls);
        this.f3955h = null;
        this.f3956i = null;
    }

    @Override // p028G.InterfaceC0103b
    /* JADX INFO: renamed from: a */
    public final void mo245a(String str) {
        Debugger.m8607d("MdeSdocHelper", "onEnded()");
        synchronized (this) {
            try {
                this.f3948a = 1;
                InterfaceC0103b interfaceC0103b = this.f3955h;
                if (interfaceC0103b != null) {
                    interfaceC0103b.mo245a(str);
                }
                if (this.f3951d) {
                    this.f3949b.unbindService(this.f3954g);
                    this.f3951d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p028G.InterfaceC0103b
    /* JADX INFO: renamed from: d */
    public final void mo246d(String str, ArrayList arrayList) {
        Debugger.m8607d("MdeSdocHelper", "onError()");
        synchronized (this) {
            try {
                this.f3948a = 1;
                InterfaceC0103b interfaceC0103b = this.f3955h;
                if (interfaceC0103b != null) {
                    interfaceC0103b.mo246d(str, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.coedit.sharehelpers.AbstractC6671a
    /* JADX INFO: renamed from: h */
    public final void mo4767h(C0204a c0204a) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(c0204a);
        mo246d(this.f3953f, arrayList);
    }

    /* JADX INFO: renamed from: j */
    public final void m4769j(Executor executor, String str, List list) {
        this.f3949b.bindService(new Intent(this.f3949b, (Class<?>) this.f3952e), this.f3954g, 1);
        synchronized (this) {
            try {
                this.f3950c = executor;
                int i = this.f3948a;
                if (i == 1) {
                    this.f3948a = 2;
                    this.f3953f = str;
                    this.f3957j = list;
                    new SenlThreadFactory("CoeditAbsShareHelper").newThread(new RunnableC0037b(this, 3)).start();
                } else if (i == 2) {
                    Debugger.m8615i("MdeSdocHelper", "Share(State) is checking authorization!");
                } else if (i == 3) {
                    Debugger.m8615i("MdeSdocHelper", "Share(State) is already started!");
                }
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public final void m4770k() {
        synchronized (this) {
            try {
                CoeditDeleteSDocTask coeditDeleteSDocTask = this.f3956i;
                if (coeditDeleteSDocTask != null) {
                    coeditDeleteSDocTask.stop();
                    this.f3956i = null;
                    if (this.f3955h != null) {
                        Debugger.m8615i("MdeSdocHelper", "call onEnded()");
                        this.f3955h.mo245a(this.f3953f);
                    }
                    if (this.f3951d) {
                        this.f3949b.unbindService(this.f3954g);
                        this.f3951d = false;
                    }
                }
                this.f3948a = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p028G.InterfaceC0103b
    public final void onStart() {
        Debugger.m8607d("MdeSdocHelper", "onStart()");
    }
}
