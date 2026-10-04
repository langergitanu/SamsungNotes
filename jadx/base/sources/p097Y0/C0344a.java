package p097Y0;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.PresetEffectColor;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.StickyMemoView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTCurvedSwitchLayout;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: Y0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0344a implements Function0 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f864a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f865b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f866c;

    public /* synthetic */ C0344a(Object obj, Object obj2, int i) {
        this.f864a = i;
        this.f865b = obj;
        this.f866c = obj2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f864a) {
            case 0:
                return DataStoreFile.dataStoreFile((Context) this.f865b, (String) this.f866c);
            case 1:
                return PresetEffectColor.startAnimationByState$lambda$10$lambda$8((PresetEffectColor) this.f865b, (PresetEffectColor.State) this.f866c);
            case 2:
                return StickyMemoManager.C98691.onDeleteClicked$lambda$1$lambda$0((StickyMemoManager) this.f865b, (StickyMemoView) this.f866c);
            default:
                return QuickToolContainer.closeCurvedSwitchLayout$lambda$9((QTCurvedSwitchLayout) this.f865b, (QuickToolContainer) this.f866c);
        }
    }
}
