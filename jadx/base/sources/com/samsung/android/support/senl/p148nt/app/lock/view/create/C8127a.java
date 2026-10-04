package com.samsung.android.support.senl.p148nt.app.lock.view.create;

import android.widget.CompoundButton;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget.PageBackgroundColorStyleView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.view.create.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8127a implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6125a;

    public /* synthetic */ C8127a(int i) {
        this.f6125a = i;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (this.f6125a) {
            case 0:
                CreatePasswordView.lambda$initBiometricCheckBox$0(compoundButton, z);
                break;
            default:
                PageBackgroundColorStyleView.initInvertSwitch$lambda$3$lambda$2(compoundButton, z);
                break;
        }
    }
}
