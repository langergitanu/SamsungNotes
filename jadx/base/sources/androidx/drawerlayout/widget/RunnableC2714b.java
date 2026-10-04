package androidx.drawerlayout.widget;

import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: renamed from: androidx.drawerlayout.widget.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2714b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1483a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1484b;

    public /* synthetic */ RunnableC2714b(Object obj, int i) {
        this.f1483a = i;
        this.f1484b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1483a) {
            case 0:
                ((DrawerLayout.ViewDragCallback) this.f1484b).peekDrawer();
                break;
            default:
                ((DrawerLayout) this.f1484b).closeDrawers();
                break;
        }
    }
}
