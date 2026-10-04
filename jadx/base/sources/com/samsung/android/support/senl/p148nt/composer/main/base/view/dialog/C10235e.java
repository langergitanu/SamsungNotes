package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import androidx.fragment.app.DialogFragment;
import java.util.Comparator;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10235e implements Comparator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7120a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DialogFragment f7121b;

    public /* synthetic */ C10235e(DialogFragment dialogFragment, int i) {
        this.f7120a = i;
        this.f7121b = dialogFragment;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f7120a) {
            case 0:
                return ((ConvertSettingDialogFragment) this.f7121b).lambda$loadLanguageList$4((String) obj, (String) obj2);
            case 1:
                return ((DirectWriteSettingDialogFragment) this.f7121b).lambda$updateLanguageList$5((String) obj, (String) obj2);
            default:
                return ((HwBeautifierLanguageDialogFragment) this.f7121b).lambda$updateLanguageList$3((String) obj, (String) obj2);
        }
    }
}
