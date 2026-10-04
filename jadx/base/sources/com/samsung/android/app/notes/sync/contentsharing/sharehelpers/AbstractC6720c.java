package com.samsung.android.app.notes.sync.contentsharing.sharehelpers;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.app.notes.sync.contentsharing.basecore.MdeSDocTask;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import p010C.RunnableC0037b;
import p063P.InterfaceC0193b;
import p068Q.C0204a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sharehelpers.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6720c extends AbstractC6718a implements InterfaceC0193b {

    /* JADX INFO: renamed from: h */
    public InterfaceC0193b f4060h;

    /* JADX INFO: renamed from: i */
    public MdeSDocTask f4061i;

    /* JADX INFO: renamed from: j */
    public List f4062j;

    public AbstractC6720c(Context context, Class cls) {
        super(context, cls);
        this.f4060h = null;
        this.f4061i = null;
    }

    @Override // p063P.InterfaceC0193b
    /* JADX INFO: renamed from: a */
    public final void mo452a(String str) {
        Debugger.m8607d("MdeSdocHelper", "onEnded()");
        synchronized (this) {
            try {
                this.f4053a = 1;
                InterfaceC0193b interfaceC0193b = this.f4060h;
                if (interfaceC0193b != null) {
                    interfaceC0193b.mo452a(str);
                }
                if (this.f4056d) {
                    this.f4054b.unbindService(this.f4059g);
                    this.f4056d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p063P.InterfaceC0193b
    /* JADX INFO: renamed from: d */
    public final void mo453d(String str, ArrayList arrayList) {
        Debugger.m8607d("MdeSdocHelper", "onError()");
        synchronized (this) {
            try {
                this.f4053a = 1;
                InterfaceC0193b interfaceC0193b = this.f4060h;
                if (interfaceC0193b != null) {
                    interfaceC0193b.mo453d(str, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharehelpers.AbstractC6718a
    /* JADX INFO: renamed from: h */
    public final void mo4811h(C0204a c0204a) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(c0204a);
        mo453d(this.f4058f, arrayList);
    }

    /* JADX INFO: renamed from: j */
    public final void m4813j(Executor executor, String str, List list) {
        this.f4054b.bindService(new Intent(this.f4054b, (Class<?>) this.f4057e), this.f4059g, 1);
        synchronized (this) {
            try {
                this.f4055c = executor;
                int i = this.f4053a;
                if (i == 1) {
                    this.f4053a = 2;
                    this.f4058f = str;
                    this.f4062j = list;
                    new SenlThreadFactory("AbsShareHelper").newThread(new RunnableC0037b(this, 4)).start();
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
    public final void m4814k() {
        synchronized (this) {
            try {
                MdeSDocTask mdeSDocTask = this.f4061i;
                if (mdeSDocTask != null) {
                    mdeSDocTask.stop();
                    this.f4061i = null;
                    if (this.f4060h != null) {
                        Debugger.m8615i("MdeSdocHelper", "call onEnded()");
                        this.f4060h.mo452a(this.f4058f);
                    }
                    if (this.f4056d) {
                        this.f4054b.unbindService(this.f4059g);
                        this.f4056d = false;
                    }
                }
                this.f4053a = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p063P.InterfaceC0193b
    public final void onStart() {
        Debugger.m8607d("MdeSdocHelper", "onStart()");
    }
}
