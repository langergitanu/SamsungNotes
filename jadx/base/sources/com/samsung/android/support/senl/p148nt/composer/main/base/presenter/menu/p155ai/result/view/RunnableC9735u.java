package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSTT;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.u */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9735u implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6976a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6977b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6978c;

    public /* synthetic */ RunnableC9735u(Object obj, Object obj2, int i) {
        this.f6976a = i;
        this.f6977b = obj;
        this.f6978c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6976a) {
            case 0:
                ((AiMenuResultViewRecognizedHw) this.f6977b).lambda$setEditModeState$5((AbsAiActionResultView.RestoreTextViewScroll) this.f6978c);
                break;
            case 1:
                ((AiMenuResultViewSTT.C96133) this.f6977b).lambda$onLongPress$0((EditText) this.f6978c);
                break;
            case 2:
                ((AiMenuResultViewRecognizedHw) this.f6977b).lambda$executeAutoFormat$12((AutoFormat.FormatType) this.f6978c);
                break;
            case 3:
                AiMenuResultViewSTT.lambda$showAutoDetectHelpView$35((TextView) this.f6977b, (TextView) this.f6978c);
                break;
            default:
                ((AiMenuResultViewSTT) this.f6977b).lambda$initTopMenu$10((View) this.f6978c);
                break;
        }
    }
}
