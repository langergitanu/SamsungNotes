package p241t3;

import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpicker.QTColorDetailLayout;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: t3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C14467a implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f10266a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ QTColorDetailLayout f10267b;

    public /* synthetic */ C14467a(QTColorDetailLayout qTColorDetailLayout, int i) {
        this.f10266a = i;
        this.f10267b = qTColorDetailLayout;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.f10266a;
        float fFloatValue = ((Float) obj).floatValue();
        switch (i) {
            case 0:
                return QTColorDetailLayout.setupSaturationSlider$lambda$2(this.f10267b, fFloatValue);
            default:
                return QTColorDetailLayout.setupValueSlider$lambda$0(this.f10267b, fFloatValue);
        }
    }
}
