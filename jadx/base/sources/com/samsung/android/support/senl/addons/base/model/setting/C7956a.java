package com.samsung.android.support.senl.addons.base.model.setting;

import android.net.Uri;
import com.samsung.android.support.senl.p145cm.base.framework.observer.SettingsContentObserver;
import com.samsung.android.support.senl.p148nt.base.common.util.PinnedEdge;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;

/* JADX INFO: renamed from: com.samsung.android.support.senl.addons.base.model.setting.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7956a implements SettingsContentObserver.SettingsContentChangedCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5707a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5708b;

    public /* synthetic */ C7956a(Object obj, int i) {
        this.f5707a = i;
        this.f5708b = obj;
    }

    @Override // com.samsung.android.support.senl.cm.base.framework.observer.SettingsContentObserver.SettingsContentChangedCallback
    public final void onChanged(boolean z, Uri uri) {
        switch (this.f5707a) {
            case 0:
                SettingsModel.registerSpenActivationObserver$lambda$0((SettingsModel) this.f5708b, z, uri);
                break;
            case 1:
                PinnedEdge.mPanelModeSettingsCallback$lambda$0((PinnedEdge) this.f5708b, z, uri);
                break;
            default:
                VoiceModel._init_$lambda$1((VoiceModel) this.f5708b, z, uri);
                break;
        }
    }
}
