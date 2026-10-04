package com.samsung.android.sdk.scs.p142ai.text.bnlp;

import com.samsung.android.sdk.scs.p142ai.text.event.EventCategoryClassifier;
import com.samsung.android.sdk.scs.p142ai.text.event.EventExtractor;
import com.samsung.android.sdk.scs.p142ai.text.language.LanguageDetector;
import com.samsung.android.sdk.scs.p142ai.text.reminder.ReminderEntityExtractor;
import com.samsung.android.sdk.scs.p142ai.text.unit.UnitConverter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.PasteRawContent;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.category.CategoryToFolderConverter;
import com.samsung.android.support.senl.p148nt.model.domain.template.UpdatePageTemplateUseCase;
import io.opentelemetry.context.Context;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.function.Function;
import org.apache.commons.lang3.concurrent.Computable;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.text.bnlp.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class CallableC7766b implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5217a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5218b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f5219c;

    public /* synthetic */ CallableC7766b(Object obj, Object obj2, int i) {
        this.f5217a = i;
        this.f5218b = obj;
        this.f5219c = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f5217a) {
            case 0:
                return ((BasicNlpAnalyzer) this.f5218b).lambda$isSupportedLanguage$0((String) this.f5219c);
            case 1:
                return ((EventCategoryClassifier) this.f5218b).lambda$classify$0((ArrayList) this.f5219c);
            case 2:
                return ((EventExtractor) this.f5218b).lambda$isSupported$0((String) this.f5219c);
            case 3:
                return ((ReminderEntityExtractor) this.f5218b).lambda$isSupported$0((String) this.f5219c);
            case 4:
                return ((PasteRawContent) this.f5218b).lambda$getDownloadCallable$0((Content.MathContent) this.f5219c);
            case 5:
                return ((CategoryToFolderConverter) this.f5218b).lambda$convert$0((String) this.f5219c);
            case 6:
                return UpdatePageTemplateUseCase.execute$lambda$0((UpdatePageTemplateUseCase) this.f5218b, (UpdatePageTemplateUseCase.Param) this.f5219c);
            case 7:
                return ((Context) this.f5218b).lambda$wrap$2((Callable) this.f5219c);
            case 8:
                return ((LanguageDetector) this.f5218b).lambda$detect$0((String) this.f5219c);
            case 9:
                return ((UnitConverter) this.f5218b).lambda$getBundleFromInput$0((String) this.f5219c);
            case 10:
                return ((Computable) this.f5218b).compute(this.f5219c);
            default:
                return ((Function) this.f5218b).apply(this.f5219c);
        }
    }
}
