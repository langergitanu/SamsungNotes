package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sesdb.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6697k implements Observer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4014a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MutableLiveData f4015b;

    public /* synthetic */ C6697k(MutableLiveData mutableLiveData, int i) {
        this.f4014a = i;
        this.f4015b = mutableLiveData;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        switch (this.f4014a) {
            case 0:
                StringBuilder sb = new StringBuilder("[CS9] Coedit Doc LiveData onChanged count : ");
                ThreadPoolExecutor threadPoolExecutor = ((C6698l) this.f4015b).f4016a;
                sb.append(threadPoolExecutor.getActiveCount());
                Logger.m8697d("SesCoeditStandaloneNoteLiveData", sb.toString());
                if (threadPoolExecutor.getQueue().isEmpty()) {
                    threadPoolExecutor.execute(new RunnableC6687a(this, 6));
                }
                break;
            case 1:
                StringBuilder sb2 = new StringBuilder("[CS9] Coedit ContentProvider LiveData onChanged count : ");
                ThreadPoolExecutor threadPoolExecutor2 = ((C6698l) this.f4015b).f4016a;
                sb2.append(threadPoolExecutor2.getActiveCount());
                Logger.m8697d("SesCoeditStandaloneNoteLiveData", sb2.toString());
                threadPoolExecutor2.execute(new RunnableC6687a(this, 7));
                break;
            default:
                ((C6693g) this.f4015b).f3995e.execute(new RunnableC6687a(this, 2));
                break;
        }
    }
}
