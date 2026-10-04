package com.samsung.android.scs.p140ai.sdkcommon.asr;

import com.opencsv.validators.RowValidator;
import com.opencsv.validators.RowValidatorAggregator;
import com.samsung.android.scs.p140ai.sdkcommon.tts.TtsPackageInfo;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.BTCLocaleInfo;
import com.samsung.android.support.senl.p148nt.app.updater.restore.DummyDocumentDetector;
import com.samsung.android.support.senl.p148nt.data.database.temp.domain.model.DeletedNote;
import com.samsung.android.support.senl.p148nt.model.repository.data.sticky.DocumentStickyRepository;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextDataTask;
import com.samsung.android.support.senl.p148nt.stt.view.language.STTLanguageManager;
import com.samsung.scsp.error.ErrorSupplier;
import com.vladsch.flexmark.util.builder.BuilderBase;
import com.vladsch.flexmark.util.misc.Extension;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.apache.commons.collections4.bag.CollectionBag;
import org.apache.commons.collections4.bag.CollectionSortedBag;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.ThreadUtils;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailablePredicate;
import org.apache.commons.lang3.reflect.MethodUtils;
import p100Y3.C0348a;
import p193j4.C12937a;

/* JADX INFO: renamed from: com.samsung.android.scs.ai.sdkcommon.asr.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7233a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4862a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4863b;

    public /* synthetic */ C7233a(Object obj, int i) {
        this.f4862a = i;
        this.f4863b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f4862a) {
            case 0:
                return ((BTCLocaleInfo) this.f4863b).lambda$getDefaultPackages$0((TtsPackageInfo) obj);
            case 1:
                return VibeRenderEffectBase.hasVisibleView$lambda$3((C0348a) this.f4863b, obj);
            case 2:
                return ((BTCLocaleInfo) this.f4863b).lambda$getDefaultPackages$0((com.samsung.android.sivs.p144ai.sdkcommon.tts.TtsPackageInfo) obj);
            case 3:
                return DummyDocumentDetector.lambda$deleteDummyFile$3((List) this.f4863b, (DeletedNote) obj);
            case 4:
                return ErrorSupplier.lambda$get$1((Throwable) this.f4863b, (Map.Entry) obj);
            case 5:
                return DocumentStickyRepository.deleteByPageId$lambda$2((C12937a) this.f4863b, obj);
            case 6:
                return AiTextDataTask.start$lambda$3$lambda$2((C12937a) this.f4863b, obj);
            case 7:
                return STTLanguageManager._get_langPackInfo_$lambda$1((C0348a) this.f4863b, obj);
            case 8:
                return ((CollectionBag) this.f4863b).contains(obj);
            case 9:
                return ((CollectionSortedBag) this.f4863b).contains(obj);
            case 10:
                return ((ListOrderedSet) this.f4863b).lambda$retainAll$0(obj);
            case 11:
                return ArrayUtils.contains((Object[]) this.f4863b, obj);
            case 12:
                return Functions.test((Functions.FailablePredicate) this.f4863b, obj);
            case 13:
                return ((ThreadUtils.ThreadGroupPredicate) this.f4863b).test((ThreadGroup) obj);
            case 14:
                return ((ThreadUtils.ThreadPredicate) this.f4863b).test((Thread) obj);
            case 15:
                return Failable.test((FailablePredicate) this.f4863b, obj);
            case 16:
                return MethodUtils.lambda$getMatchingMethod$3((Class[]) this.f4863b, (Method) obj);
            case 17:
                return BuilderBase.lambda$removeExtensions$1((Collection) this.f4863b, (Extension) obj);
            default:
                return RowValidatorAggregator.lambda$isValid$0((String[]) this.f4863b, (RowValidator) obj);
        }
    }
}
