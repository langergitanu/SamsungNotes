package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.concurrent.ExecutorService;
import p044K.C0158a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sesdb.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6688b extends MutableLiveData {

    /* JADX INFO: renamed from: a */
    public final Context f3991a;

    /* JADX INFO: renamed from: b */
    public final Uri f3992b;

    /* JADX INFO: renamed from: c */
    public final boolean f3993c;

    /* JADX INFO: renamed from: d */
    public ContentObserver f3994d = null;

    /* JADX INFO: renamed from: e */
    public final ExecutorService f3995e = AbstractC4539a.m3201k("ContentProviderLiveData");

    public AbstractC6688b(Context context, Uri uri, boolean z) {
        this.f3991a = context;
        this.f3992b = uri;
        this.f3993c = z;
    }

    /* JADX INFO: renamed from: a */
    public abstract Object mo4781a();

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        if (this.f3994d == null) {
            this.f3994d = new ContentProviderLiveData$1(this, null);
            if (this.f3993c) {
                this.f3995e.execute(new RunnableC6687a(this, 1));
            }
        }
        try {
            if (C0158a.f491k) {
                return;
            }
            this.f3991a.getContentResolver().registerContentObserver(this.f3992b, false, this.f3994d);
        } catch (Exception e) {
            Debugger.m8610e("ContentProviderLiveData", "onActive() : " + e.toString(), e);
            C0158a.f491k = true;
            C0158a.f486f = false;
            C0158a.f489i = false;
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        try {
            if (C0158a.f491k) {
                return;
            }
            this.f3991a.getContentResolver().unregisterContentObserver(this.f3994d);
        } catch (Exception e) {
            Debugger.m8610e("ContentProviderLiveData", "onInactive() : " + e.toString(), e);
        }
    }
}
