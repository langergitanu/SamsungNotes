package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.view.KeyEvent;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.SpeakerRenameDialog;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10505d implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7218a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7219b;

    public /* synthetic */ C10505d(Object obj, int i) {
        this.f7218a = i;
        this.f7219b = obj;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        switch (this.f7218a) {
            case 0:
                return ((TitleViewManager) this.f7219b).lambda$init$1(textView, i, keyEvent);
            default:
                return SpeakerRenameDialog.setInputViewListener$lambda$8((SpeakerRenameDialog) this.f7219b, textView, i, keyEvent);
        }
    }
}
