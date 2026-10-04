package com.samsung.android.support.senl.addons.brush.viewmodel.menu;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import com.samsung.android.support.senl.p148nt.base.common.livesharing.LiveSharingManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.StickyMemoView;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTask;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;

/* JADX INFO: renamed from: com.samsung.android.support.senl.addons.brush.viewmodel.menu.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC7967b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5714a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f5715b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f5716c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f5717d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f5718e;

    public /* synthetic */ RunnableC7967b(SubMenuLayoutViewModel subMenuLayoutViewModel, View view, View view2, boolean z) {
        this.f5714a = 0;
        this.f5716c = subMenuLayoutViewModel;
        this.f5717d = view;
        this.f5718e = view2;
        this.f5715b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5714a) {
            case 0:
                SubMenuLayoutViewModel.setLayoutBottom$lambda$0((SubMenuLayoutViewModel) this.f5716c, (View) this.f5717d, (View) this.f5718e, this.f5715b);
                break;
            case 1:
                LiveSharingManager.createConfirmDialog$lambda$4((LiveSharingManager) this.f5716c, (Activity) this.f5717d, this.f5715b, (DialogInterface.OnClickListener) this.f5718e);
                break;
            case 2:
                SmTaskController.notify$lambda$1((SmTaskController) this.f5716c, (SmTask.Callback) this.f5717d, this.f5715b, (SmTask.Results) this.f5718e);
                break;
            case 3:
                StickyMemoManager.hideMemo$lambda$20$lambda$19(this.f5715b, (StickyMemoManager) this.f5716c, (StickyMemoView) this.f5717d, (SpenStickyNote) this.f5718e);
                break;
            default:
                AiResultTaskController.notify$lambda$1((AiResultTask.Callback) this.f5716c, this.f5715b, (AiResultTask.Results) this.f5717d, (AiResultTaskController) this.f5718e);
                break;
        }
    }

    public /* synthetic */ RunnableC7967b(AiResultTask.Callback callback, boolean z, AiResultTask.Results results, AiResultTaskController aiResultTaskController) {
        this.f5714a = 4;
        this.f5716c = callback;
        this.f5715b = z;
        this.f5717d = results;
        this.f5718e = aiResultTaskController;
    }

    public /* synthetic */ RunnableC7967b(Object obj, Object obj2, boolean z, Object obj3, int i) {
        this.f5714a = i;
        this.f5716c = obj;
        this.f5717d = obj2;
        this.f5715b = z;
        this.f5718e = obj3;
    }

    public /* synthetic */ RunnableC7967b(boolean z, StickyMemoManager stickyMemoManager, StickyMemoView stickyMemoView, SpenStickyNote spenStickyNote) {
        this.f5714a = 3;
        this.f5715b = z;
        this.f5716c = stickyMemoManager;
        this.f5717d = stickyMemoView;
        this.f5718e = spenStickyNote;
    }
}
