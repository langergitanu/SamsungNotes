package com.samsung.android.support.senl.p148nt.model.restore.folder;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.restore.folder.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class CallableC11473c implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7754a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7755b;

    public /* synthetic */ CallableC11473c(Object obj, int i) {
        this.f7754a = i;
        this.f7755b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f7754a) {
            case 0:
                return ((OldFolderSDocXDetector) this.f7755b).lambda$execute$0();
            default:
                return ((RestoreFolderCreator) this.f7755b).lambda$createFolderByVersion$1();
        }
    }
}
