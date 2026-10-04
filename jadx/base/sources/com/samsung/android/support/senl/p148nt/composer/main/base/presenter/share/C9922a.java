package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.share.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9922a implements DocumentFileManager.IOAction, DocumentFileManager.OpenAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7062a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f7063b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f7064c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ String f7065d;

    public /* synthetic */ C9922a(Context context, String str, String str2) {
        this.f7063b = context;
        this.f7064c = str;
        this.f7065d = str2;
    }

    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
    public final Object operate() {
        switch (this.f7062a) {
            case 0:
                return HandleVoice.lambda$handleVoiceData$1(this.f7064c, this.f7063b, this.f7065d);
            default:
                return DocumentConstructor.makeSpenWNote(this.f7063b, this.f7064c, this.f7065d);
        }
    }

    public /* synthetic */ C9922a(String str, Context context, String str2) {
        this.f7064c = str;
        this.f7063b = context;
        this.f7065d = str2;
    }
}
