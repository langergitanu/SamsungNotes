package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.play.core.tasks.C5345i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.play.core.internal.ap */
/* JADX INFO: loaded from: classes5.dex */
public final class C5167ap<T extends IInterface> {

    /* JADX INFO: renamed from: a */
    private static final Map<String, Handler> f2943a = new HashMap();

    /* JADX INFO: renamed from: b */
    private final Context f2944b;

    /* JADX INFO: renamed from: c */
    private final C5157af f2945c;

    /* JADX INFO: renamed from: d */
    private final String f2946d;

    /* JADX INFO: renamed from: f */
    private boolean f2948f;

    /* JADX INFO: renamed from: g */
    private final Intent f2949g;

    /* JADX INFO: renamed from: h */
    private final InterfaceC5163al<T> f2950h;

    /* JADX INFO: renamed from: k */
    @Nullable
    private ServiceConnection f2953k;

    /* JADX INFO: renamed from: l */
    @Nullable
    private T f2954l;

    /* JADX INFO: renamed from: e */
    private final List<AbstractRunnableC5158ag> f2947e = new ArrayList();

    /* JADX INFO: renamed from: j */
    private final IBinder.DeathRecipient f2952j = new IBinder.DeathRecipient(this) { // from class: com.google.android.play.core.internal.ah

        /* JADX INFO: renamed from: a */
        private final C5167ap f2935a;

        {
            this.f2935a = this;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            this.f2935a.m3899c();
        }
    };

    /* JADX INFO: renamed from: i */
    private final WeakReference<InterfaceC5162ak> f2951i = new WeakReference<>(null);

    public C5167ap(Context context, C5157af c5157af, String str, Intent intent, InterfaceC5163al<T> interfaceC5163al) {
        this.f2944b = context;
        this.f2945c = c5157af;
        this.f2946d = str;
        this.f2949g = intent;
        this.f2950h = interfaceC5163al;
    }

    /* JADX INFO: renamed from: f */
    public static /* synthetic */ void m3891f(C5167ap c5167ap) {
        c5167ap.f2945c.m3878c("linkToDeath", new Object[0]);
        try {
            c5167ap.f2954l.asBinder().linkToDeath(c5167ap.f2952j, 0);
        } catch (RemoteException e) {
            c5167ap.f2945c.m3876a(e, "linkToDeath failed", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ void m3893h(C5167ap c5167ap) {
        c5167ap.f2945c.m3878c("unlinkToDeath", new Object[0]);
        c5167ap.f2954l.asBinder().unlinkToDeath(c5167ap.f2952j, 0);
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public final T m3898b() {
        return this.f2954l;
    }

    /* JADX INFO: renamed from: a */
    public final void m3896a() {
        m3886b(new C5161aj(this));
    }

    /* JADX INFO: renamed from: c */
    public final /* bridge */ /* synthetic */ void m3899c() {
        this.f2945c.m3878c("reportBinderDeath", new Object[0]);
        InterfaceC5162ak interfaceC5162ak = this.f2951i.get();
        if (interfaceC5162ak != null) {
            this.f2945c.m3878c("calling onBinderDied", new Object[0]);
            interfaceC5162ak.m3881a();
            return;
        }
        this.f2945c.m3878c("%s : Binder has died.", this.f2946d);
        List<AbstractRunnableC5158ag> list = this.f2947e;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C5345i<?> c5345iM3880b = list.get(i).m3880b();
            if (c5345iM3880b != null) {
                c5345iM3880b.m4200b((Exception) new RemoteException(String.valueOf(this.f2946d).concat(" : Binder has died.")));
            }
        }
        this.f2947e.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m3886b(AbstractRunnableC5158ag abstractRunnableC5158ag) {
        Handler handler;
        Map<String, Handler> map = f2943a;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f2946d)) {
                    HandlerThread handlerThread = new HandlerThread(this.f2946d, 10);
                    handlerThread.start();
                    map.put(this.f2946d, new Handler(handlerThread.getLooper()));
                }
                handler = map.get(this.f2946d);
            } catch (Throwable th) {
                throw th;
            }
        }
        handler.post(abstractRunnableC5158ag);
    }

    /* JADX INFO: renamed from: a */
    public final void m3897a(AbstractRunnableC5158ag abstractRunnableC5158ag) {
        m3886b(new C5160ai(this, abstractRunnableC5158ag.m3880b(), abstractRunnableC5158ag));
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m3884a(C5167ap c5167ap, AbstractRunnableC5158ag abstractRunnableC5158ag) {
        if (c5167ap.f2954l != null || c5167ap.f2948f) {
            if (!c5167ap.f2948f) {
                abstractRunnableC5158ag.run();
                return;
            } else {
                c5167ap.f2945c.m3878c("Waiting to bind to the service.", new Object[0]);
                c5167ap.f2947e.add(abstractRunnableC5158ag);
                return;
            }
        }
        c5167ap.f2945c.m3878c("Initiate binding to the service.", new Object[0]);
        c5167ap.f2947e.add(abstractRunnableC5158ag);
        ServiceConnectionC5166ao serviceConnectionC5166ao = new ServiceConnectionC5166ao(c5167ap);
        c5167ap.f2953k = serviceConnectionC5166ao;
        c5167ap.f2948f = true;
        if (c5167ap.f2944b.bindService(c5167ap.f2949g, serviceConnectionC5166ao, 1)) {
            return;
        }
        c5167ap.f2945c.m3878c("Failed to bind to the service.", new Object[0]);
        c5167ap.f2948f = false;
        List<AbstractRunnableC5158ag> list = c5167ap.f2947e;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C5345i<?> c5345iM3880b = list.get(i).m3880b();
            if (c5345iM3880b != null) {
                c5345iM3880b.m4200b((Exception) new C5168aq());
            }
        }
        c5167ap.f2947e.clear();
    }
}
