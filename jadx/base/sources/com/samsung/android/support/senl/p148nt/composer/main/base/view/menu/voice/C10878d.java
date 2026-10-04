package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import kotlin.jvm.functions.Function0;
import kotlin.time.AbstractLongTimeSource;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10878d implements Function0 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7294a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7295b;

    public /* synthetic */ C10878d(Object obj, int i) {
        this.f7294a = i;
        this.f7295b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f7294a) {
            case 0:
                return VoiceRecordExpandMenu.expendMenuAnimation$lambda$11((VoiceRecordExpandMenu) this.f7295b);
            case 1:
                return VoiceRecordExpandMenu.collapseMenuAnimation$lambda$10((VoiceRecordExpandMenu) this.f7295b);
            default:
                return Long.valueOf(((AbstractLongTimeSource) this.f7295b).read());
        }
    }
}
