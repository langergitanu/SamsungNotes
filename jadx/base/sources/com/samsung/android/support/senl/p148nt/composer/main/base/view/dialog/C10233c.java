package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10233c implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7116a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ List f7117b;

    public /* synthetic */ C10233c(List list, int i) {
        this.f7116a = i;
        this.f7117b = list;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f7116a) {
            case 0:
                return ConvertSettingDialogFragment.lambda$updateLanguageList$3(this.f7117b, (String) obj);
            default:
                return HwBeautifierLanguageDialogFragment.lambda$updateLanguageList$2(this.f7117b, (String) obj);
        }
    }
}
