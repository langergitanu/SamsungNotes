package com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.CoverEditorDialogFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsDefaultNoteStyleFragment;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsViewPager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.progress.AiResultProgress;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ViewOnLayoutChangeListenerC7473a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4994a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4995b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4996c;

    public /* synthetic */ ViewOnLayoutChangeListenerC7473a(Object obj, Object obj2, int i) {
        this.f4994a = i;
        this.f4995b = obj;
        this.f4996c = obj2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        switch (this.f4994a) {
            case 0:
                SpenCrowdHwrView.initialize$lambda$2((SpenCrowdHwrView) this.f4995b, (ConstraintLayout) this.f4996c, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 1:
                ((CoverEditorDialogFragment) this.f4995b).lambda$onCreateDialog$0((AlertDialog) this.f4996c, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 2:
                SettingsDefaultNoteStyleFragment.initViewPager$lambda$1$lambda$0((AbsViewPager) this.f4995b, (SettingsDefaultNoteStyleFragment) this.f4996c, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            default:
                ((AiResultProgress) this.f4995b).lambda$initProgress$0((View) this.f4996c, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
        }
    }
}
