package com.samsung.android.support.senl.p148nt.base.common;

import androidx.credentials.webauthn.Cbor;
import com.samsung.android.app.notes.widget.glance.list.setting.view.C6955h;
import com.samsung.android.support.senl.p148nt.base.common.util.ConvertSpenTextToSpannable;
import com.samsung.android.support.senl.p148nt.model.domain.search.SemanticSearchNoteUseCase;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.C11561g;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.STTSettingLanguageDialogFragment;
import java.util.Comparator;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.common.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8878a implements Comparator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6424a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6425b;

    public /* synthetic */ C8878a(Object obj, int i) {
        this.f6424a = i;
        this.f6425b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f6424a) {
            case 0:
                return ComposerManager.closeComposerOverCount$lambda$2((C6955h) this.f6425b, obj, obj2);
            case 1:
                return ConvertSpenTextToSpannable.convertObjectSpan$lambda$1((C6955h) this.f6425b, obj, obj2);
            case 2:
                return STTSettingLanguageDialogFragment.init$lambda$5((C11561g) this.f6425b, obj, obj2);
            case 3:
                return Cbor.encode$lambda$0((Ref.ObjectRef) this.f6425b, (byte[]) obj, (byte[]) obj2);
            default:
                return SemanticSearchNoteUseCase.execute$lambda$1((C11561g) this.f6425b, obj, obj2);
        }
    }
}
