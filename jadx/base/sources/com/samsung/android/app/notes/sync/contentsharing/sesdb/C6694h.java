package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import androidx.lifecycle.Observer;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p012C1.RunnableC0045a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sesdb.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6694h implements Observer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4006a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C6696j f4007b;

    public /* synthetic */ C6694h(C6696j c6696j, int i) {
        this.f4006a = i;
        this.f4007b = c6696j;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        List arrayList;
        switch (this.f4006a) {
            case 0:
                List list = (List) obj;
                C6696j c6696j = this.f4007b;
                if (list != null) {
                    int size = list.size();
                    AbstractC4539a.m3203m(size, "[CS9] Coedit Doc LiveData onChanged doc count : ", "SesCoeditSpaceAndStandaloneNoteCountLiveData");
                    if (size != c6696j.f4011c) {
                        c6696j.f4011c = list.size();
                    }
                }
                CompletableFuture completableFuture = new CompletableFuture();
                new SenlThreadFactory("getProviderValueWithTimeoutLimit").newThread(new RunnableC0045a(c6696j, completableFuture, 4)).start();
                try {
                    arrayList = (List) completableFuture.get(2000L, TimeUnit.MILLISECONDS);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                    Logger.m8697d("SesCoeditSpaceAndStandaloneNoteCountLiveData", "provider access failed");
                    arrayList = new ArrayList();
                }
                c6696j.postValue(arrayList);
                break;
            case 1:
                this.f4007b.f4009a.execute(new RunnableC6687a(this, 4));
                break;
            default:
                this.f4007b.f4009a.execute(new RunnableC6687a(this, 5));
                break;
        }
    }
}
