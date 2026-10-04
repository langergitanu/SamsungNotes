package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize;

import com.opencsv.validators.LineValidator;
import com.opencsv.validators.LineValidatorAggregator;
import com.samsung.scsp.pam.kps.lite.KpsPolicies;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.function.Predicate;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.RuntimeEnvironment;
import org.apache.commons.lang3.exception.DefaultExceptionContext;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.tuple.Pair;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.stt.summarize.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9478c implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6907a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f6908b;

    public /* synthetic */ C9478c(String str, int i) {
        this.f6907a = i;
        this.f6908b = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f6907a) {
            case 0:
                return this.f6908b.contains((String) obj);
            case 1:
                return KpsPolicies.lambda$getPolicy$0(this.f6908b, (KpsPolicies.Policy) obj);
            case 2:
                return LocaleUtils.lambda$languagesByCountry$2(this.f6908b, (Locale) obj);
            case 3:
                return LocaleUtils.lambda$countriesByLanguage$0(this.f6908b, (Locale) obj);
            case 4:
                return RuntimeEnvironment.lambda$readFile$0(this.f6908b, (String) obj);
            case 5:
                return DefaultExceptionContext.lambda$getContextValues$0(this.f6908b, (Pair) obj);
            case 6:
                return DefaultExceptionContext.lambda$setContextValue$2(this.f6908b, (Pair) obj);
            case 7:
                return DefaultExceptionContext.lambda$getFirstContextValue$1(this.f6908b, (Pair) obj);
            case 8:
                return MethodUtils.lambda$getMatchingMethod$1(this.f6908b, (Method) obj);
            case 9:
                return MethodUtils.lambda$getMatchingMethod$2(this.f6908b, (Method) obj);
            default:
                return LineValidatorAggregator.lambda$isValid$0(this.f6908b, (LineValidator) obj);
        }
    }
}
