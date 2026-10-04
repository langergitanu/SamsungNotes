package com.google.android.material.textfield;

import android.view.View;

/* JADX INFO: renamed from: com.google.android.material.textfield.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ViewOnClickListenerC4913a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2397a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ EndIconDelegate f2398b;

    public /* synthetic */ ViewOnClickListenerC4913a(EndIconDelegate endIconDelegate, int i) {
        this.f2397a = i;
        this.f2398b = endIconDelegate;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2397a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f2398b).lambda$new$0(view);
                break;
            case 1:
                ((DropdownMenuEndIconDelegate) this.f2398b).lambda$new$0(view);
                break;
            default:
                ((PasswordToggleEndIconDelegate) this.f2398b).lambda$new$0(view);
                break;
        }
    }
}
