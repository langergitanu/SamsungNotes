package p251v3;

import android.view.KeyEvent;
import android.view.View;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.handwriting.PenWidthMiniLayout;

/* JADX INFO: renamed from: v3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC14502a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f10333a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ KeyEvent.Callback f10334b;

    public /* synthetic */ ViewOnClickListenerC14502a(KeyEvent.Callback callback, int i) {
        this.f10333a = i;
        this.f10334b = callback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f10333a) {
            case 0:
                PenWidthMiniLayout.initView$lambda$0((PenWidthMiniLayout) this.f10334b, view);
                break;
            default:
                SpenColorSettingPopup.mBtnClickListener$lambda$0((SpenColorSettingPopup) this.f10334b, view);
                break;
        }
    }
}
