package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.model.domain.search.SemanticSearchNoteUseCase;
import java.util.LinkedHashMap;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.flow.internal.SafeCollector_commonKt;
import kotlinx.coroutines.future.FutureKt;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.view.dialog.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class C11561g implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7937a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7938b;

    public /* synthetic */ C11561g(Object obj, int i) {
        this.f7937a = i;
        this.f7938b = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f7937a) {
            case 0:
                return Integer.valueOf(STTSettingLanguageDialogFragment.init$lambda$4((STTSettingLanguageDialogFragment) this.f7938b, (String) obj, (String) obj2));
            case 1:
                return Integer.valueOf(SemanticSearchNoteUseCase.execute$lambda$0((LinkedHashMap) this.f7938b, (MainListDocumentData) obj, (MainListDocumentData) obj2));
            case 2:
                return Integer.valueOf(SafeCollector_commonKt.checkContext$lambda$0((SafeCollector) this.f7938b, ((Integer) obj).intValue(), (CoroutineContext.Element) obj2));
            default:
                return FutureKt.asDeferred$lambda$5((CompletableDeferred) this.f7938b, obj, (Throwable) obj2);
        }
    }
}
