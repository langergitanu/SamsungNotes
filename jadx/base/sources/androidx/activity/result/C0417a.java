package androidx.activity.result;

import androidx.compose.p109ui.graphics.colorspace.DoubleFunction;
import androidx.compose.p109ui.graphics.colorspace.Rgb;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.activity.result.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0417a implements ActivityResultCallback, DoubleFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f902a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function1 f903b;

    public /* synthetic */ C0417a(Function1 function1, int i) {
        this.f902a = i;
        this.f903b = function1;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.DoubleFunction
    public double invoke(double d) {
        switch (this.f902a) {
            case 2:
                return Rgb._init_$lambda$2(this.f903b, d);
            case 3:
                return Rgb._init_$lambda$3(this.f903b, d);
            case 4:
                return Rgb._init_$lambda$4(this.f903b, d);
            default:
                return Rgb._init_$lambda$5(this.f903b, d);
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.f902a) {
            case 0:
                this.f903b.invoke(obj);
                break;
            default:
                this.f903b.invoke(obj);
                break;
        }
    }
}
