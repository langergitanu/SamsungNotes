package com.samsung.android.support.senl.p148nt.app.common.widget;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.common.widget.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8044b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6097a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FolderPathLayout f6098b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ View f6099c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ View f6100d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ ImageView f6101e;

    public /* synthetic */ RunnableC8044b(FolderPathLayout folderPathLayout, View view, View view2, ImageView imageView, int i) {
        this.f6097a = i;
        this.f6098b = folderPathLayout;
        this.f6099c = view;
        this.f6100d = view2;
        this.f6101e = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6097a) {
            case 0:
                this.f6098b.lambda$depthInAnimation$2(this.f6099c, this.f6100d, this.f6101e);
                break;
            default:
                this.f6098b.lambda$depthInAnimation$3(this.f6099c, this.f6100d, this.f6101e);
                break;
        }
    }
}
