package com.samsung.android.app.notes.sync.p135db;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6738g implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Context f4101a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ArrayList f4102b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ ArrayList f4103c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ ArrayList f4104d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f4105e;

    public RunnableC6738g(Context context, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i) {
        this.f4101a = context;
        this.f4102b = arrayList;
        this.f4103c = arrayList2;
        this.f4104d = arrayList3;
        this.f4105e = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC6739h.m4837d(this.f4101a, this.f4102b, this.f4103c, (String) this.f4104d.get(this.f4105e), true);
    }
}
