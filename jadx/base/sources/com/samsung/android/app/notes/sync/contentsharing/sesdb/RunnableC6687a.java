package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sesdb.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6687a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3989a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3990b;

    public /* synthetic */ RunnableC6687a(Object obj, int i) {
        this.f3989a = i;
        this.f3990b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3989a) {
            case 0:
                AbstractC6688b abstractC6688b = ((ContentProviderLiveData$1) this.f3990b).this$0;
                abstractC6688b.postValue(abstractC6688b.mo4781a());
                break;
            case 1:
                AbstractC6688b abstractC6688b2 = (AbstractC6688b) this.f3990b;
                abstractC6688b2.postValue(abstractC6688b2.mo4781a());
                break;
            case 2:
                C6693g c6693g = (C6693g) ((C6697k) this.f3990b).f4015b;
                c6693g.postValue(c6693g.mo4781a());
                break;
            case 3:
                Logger.m8697d("SesCoeditStandaloneNoteLiveData", "dummy Note added");
                C6693g c6693g2 = ((C6692f) this.f3990b).f3998a;
                c6693g2.postValue(c6693g2.mo4781a());
                break;
            case 4:
                C6696j c6696j = ((C6694h) this.f3990b).f4007b;
                c6696j.postValue(c6696j.m4783a());
                break;
            case 5:
                int spaceCount = SesCoeditShareReadResolver.getInstance().getSpaceCount();
                AbstractC4539a.m3203m(spaceCount, "[CS9] Coedit ContentProvider LiveData onChanged space count : ", "SesCoeditSpaceAndStandaloneNoteCountLiveData");
                C6696j c6696j2 = ((C6694h) this.f3990b).f4007b;
                if (c6696j2.f4012d != spaceCount) {
                    c6696j2.f4012d = spaceCount;
                    c6696j2.postValue(c6696j2.m4783a());
                    break;
                }
                break;
            case 6:
                C6698l c6698l = (C6698l) ((C6697k) this.f3990b).f4015b;
                c6698l.postValue(c6698l.m4784a());
                break;
            default:
                Logger.m8697d("SesCoeditStandaloneNoteLiveData", "provider change");
                C6698l c6698l2 = (C6698l) ((C6697k) this.f3990b).f4015b;
                c6698l2.postValue(c6698l2.m4784a());
                break;
        }
    }
}
