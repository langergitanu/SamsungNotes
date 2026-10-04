package com.samsung.android.sdk.pen.setting.common;

import android.view.KeyEvent;
import android.view.View;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.NotesSearchView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.OnKeyListenerImpl;
import com.samsung.android.support.senl.p148nt.stt.picker.view.AudioPickerSearchView;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.SpeakerRenameDialog;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.common.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ViewOnKeyListenerC7560e implements View.OnKeyListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5036a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5037b;

    public /* synthetic */ ViewOnKeyListenerC7560e(Object obj, int i) {
        this.f5036a = i;
        this.f5037b = obj;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (this.f5036a) {
            case 0:
                return SpenSeekBarButtonControl.mButtonOnKeyListener$lambda$0((SpenSeekBarButtonControl) this.f5037b, view, i, keyEvent);
            case 1:
                return ((NotesSearchView) this.f5037b).lambda$init$2(view, i, keyEvent);
            case 2:
                return ((OnKeyListenerImpl) this.f5037b).lambda$new$0(view, i, keyEvent);
            case 3:
                return AudioPickerSearchView.init$lambda$1((AudioPickerSearchView) this.f5037b, view, i, keyEvent);
            default:
                return SpeakerRenameDialog.setInputViewListener$lambda$7((SpeakerRenameDialog) this.f5037b, view, i, keyEvent);
        }
    }
}
