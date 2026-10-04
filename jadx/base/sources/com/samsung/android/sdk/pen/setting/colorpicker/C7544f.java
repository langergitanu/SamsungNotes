package com.samsung.android.sdk.pen.setting.colorpicker;

import android.text.InputFilter;
import android.text.Spanned;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.AbsSTTDialogFragment;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.colorpicker.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7544f implements InputFilter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5025a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5026b;

    public /* synthetic */ C7544f(Object obj, int i) {
        this.f5025a = i;
        this.f5026b = obj;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
        switch (this.f5025a) {
            case 0:
                return SpenRGBCodeControl.mRGBCodeTextFilter$lambda$5((SpenRGBCodeControl) this.f5026b, charSequence, i, i2, spanned, i4, i5);
            default:
                return AbsSTTDialogFragment.getNameFilter$lambda$2((AbsSTTDialogFragment) this.f5026b, charSequence, i, i2, spanned, i4, i5);
        }
    }
}
