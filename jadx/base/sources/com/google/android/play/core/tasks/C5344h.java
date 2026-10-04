package com.google.android.play.core.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: renamed from: com.google.android.play.core.tasks.h */
/* JADX INFO: loaded from: classes5.dex */
final class C5344h<ResultT> {

    /* JADX INFO: renamed from: a */
    private final Object f3235a = new Object();

    /* JADX INFO: renamed from: b */
    private Queue<InterfaceC5343g<ResultT>> f3236b;

    /* JADX INFO: renamed from: c */
    private boolean f3237c;

    /* JADX INFO: renamed from: a */
    public final void m4195a(Task<ResultT> task) {
        InterfaceC5343g<ResultT> interfaceC5343gPoll;
        synchronized (this.f3235a) {
            if (this.f3236b != null && !this.f3237c) {
                this.f3237c = true;
                while (true) {
                    synchronized (this.f3235a) {
                        try {
                            interfaceC5343gPoll = this.f3236b.poll();
                            if (interfaceC5343gPoll == null) {
                                this.f3237c = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    interfaceC5343gPoll.mo4190a(task);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m4196a(InterfaceC5343g<ResultT> interfaceC5343g) {
        synchronized (this.f3235a) {
            try {
                if (this.f3236b == null) {
                    this.f3236b = new ArrayDeque();
                }
                this.f3236b.add(interfaceC5343g);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
