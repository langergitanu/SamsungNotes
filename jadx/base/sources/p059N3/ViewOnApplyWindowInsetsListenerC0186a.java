package p059N3;

import android.view.View;
import android.view.WindowInsets;
import android.widget.LinearLayout;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslateLanguageHelperImpl;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.util.CaptionBarHelper;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.rotation.RotationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.covered.Covered;

/* JADX INFO: renamed from: N3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnApplyWindowInsetsListenerC0186a implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f585a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f586b;

    public /* synthetic */ ViewOnApplyWindowInsetsListenerC0186a(Object obj, int i) {
        this.f585a = i;
        this.f586b = obj;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        switch (this.f585a) {
            case 0:
                return RotationModel.init$lambda$0((RotationModel) this.f586b, view, windowInsets);
            case 1:
                return Covered.init$lambda$0((Covered) this.f586b, view, windowInsets);
            case 2:
                return TranslateLanguageHelperImpl.initLangCodeButton$lambda$3$lambda$2((LinearLayout) this.f586b, view, windowInsets);
            default:
                return CaptionBarHelper.init$lambda$0((View) this.f586b, view, windowInsets);
        }
    }
}
