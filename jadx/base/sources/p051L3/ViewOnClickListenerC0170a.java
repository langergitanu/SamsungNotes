package p051L3;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.view.PopupNoteFragment;

/* JADX INFO: renamed from: L3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC0170a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f540a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ PopupNoteFragment f541b;

    public /* synthetic */ ViewOnClickListenerC0170a(PopupNoteFragment popupNoteFragment, int i) {
        this.f540a = i;
        this.f541b = popupNoteFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f540a) {
            case 0:
                PopupNoteFragment.initializeResizeButton$lambda$0(this.f541b, view);
                break;
            default:
                PopupNoteFragment.initializeCloseButton$lambda$1(this.f541b, view);
                break;
        }
    }
}
