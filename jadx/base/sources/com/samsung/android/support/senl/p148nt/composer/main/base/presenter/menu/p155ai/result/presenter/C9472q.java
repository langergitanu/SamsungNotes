package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9472q implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6895a;

    public /* synthetic */ C9472q(int i) {
        this.f6895a = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6895a) {
            case 0:
                ((Consumer) obj).accept(null);
                break;
            case 1:
                ((Consumer) obj).accept(null);
                break;
            case 2:
                ((StreamingCharManager) obj).cancel();
                break;
            case 3:
                ((SpenObjectTextBox) obj).removeAllText();
                break;
            case 4:
                ((Consumer) obj).accept(null);
                break;
            default:
                ((Consumer) obj).accept(null);
                break;
        }
    }
}
