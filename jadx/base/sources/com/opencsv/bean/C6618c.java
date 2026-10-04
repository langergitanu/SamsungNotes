package com.opencsv.bean;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import com.opencsv.bean.AbstractMappingStrategy;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.widget.WidgetListProvider;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationResult;
import com.samsung.android.sdk.scs.p142ai.visual.MultiModalParam;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskQuickNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskSaveToGallery;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.MediaObjectSuggestionInfo;
import com.samsung.scpm.pam.kps.ScpmKpsResult;
import com.vladsch.flexmark.ast.util.ReferenceRepository;
import com.vladsch.flexmark.util.ast.Node;
import java.lang.reflect.Method;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.properties.OrderedProperties;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.reflect.MethodUtils;
import p211o0.C13569c;

/* JADX INFO: renamed from: com.opencsv.bean.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6618c implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3673a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3674b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f3675c;

    public /* synthetic */ C6618c(Object obj, Object obj2, int i) {
        this.f3673a = i;
        this.f3674b = obj;
        this.f3675c = obj2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f3673a) {
            case 0:
                ((AbstractMappingStrategy) this.f3674b).lambda$ignoreFields$0((MapIterator) this.f3675c, (Class) obj);
                break;
            case 1:
                ((AbstractMappingStrategy) this.f3674b).lambda$assembleCompleteFieldList$1((ListValuedMap) this.f3675c, (AbstractMappingStrategy.RecursiveType) obj);
                break;
            case 2:
                AbstractMappingStrategy.lambda$partitionFields$4((Set) this.f3674b, (TreeMap) this.f3675c, (Map.Entry) obj);
                break;
            case 3:
                WidgetListProvider.onNotePickerClickedActionAdd$lambda$3((Context) this.f3674b, (Intent) this.f3675c, (Display) obj);
                break;
            case 4:
                TextTranslator.translateText$lambda$7((StringBuilder) this.f3674b, (CountDownLatch) this.f3675c, (NeuralTranslationResult) obj);
                break;
            case 5:
                MultiModalParam.PromptParamBuilder.lambda$param$0((Bundle) this.f3674b, (Map) this.f3675c, (String) obj);
                break;
            case 6:
                ((TaskQuickNote.GalleryContent) this.f3674b).lambda$makeImage$0((MediaObjectSuggestionInfo) this.f3675c, (String) obj);
                break;
            case 7:
                TaskSaveToGallery.lambda$handleHWContent$2((String) this.f3674b, (SpenObjectImage) this.f3675c, (String) obj);
                break;
            case 8:
                ((ReferenceRepository) this.f3674b).lambda$getReferencedElements$0((HashSet) this.f3675c, (Node) obj);
                break;
            case 9:
                ((io.opentelemetry.context.Context) this.f3674b).lambda$wrapConsumer$6((Consumer) this.f3675c, obj);
                break;
            case 10:
                ((OrderedProperties) this.f3674b).lambda$forEach$1((BiConsumer) this.f3675c, obj);
                break;
            case 11:
                EnumUtils.lambda$processBitVectors$3((long[]) this.f3674b, (EnumSet) this.f3675c, (Enum) obj);
                break;
            case 12:
                ((DiffBuilder) this.f3674b).lambda$append$0((String) this.f3675c, (Diff) obj);
                break;
            case 13:
                DiffResult.lambda$toString$0((ToStringBuilder) this.f3674b, (ToStringBuilder) this.f3675c, (Diff) obj);
                break;
            case 14:
                MethodUtils.lambda$getMatchingMethod$5((Class[]) this.f3674b, (TreeMap) this.f3675c, (Method) obj);
                break;
            default:
                C6906i c6906i = (C6906i) this.f3674b;
                CompletableFuture completableFuture = (CompletableFuture) this.f3675c;
                ScpmKpsResult scpmKpsResult = (ScpmKpsResult) obj;
                c6906i.getClass();
                if (scpmKpsResult.result != 1) {
                    Debugger.m8609e("SCloudEdpHelper", "[EDP] requestKeySync() : code = " + scpmKpsResult.rcode + ", msg = " + scpmKpsResult.rmsg);
                    completableFuture.complete(Boolean.FALSE);
                } else if (!TextUtils.isEmpty(C13569c.m14376d((Context) c6906i.f4483b).m14380f())) {
                    Debugger.m8615i("SCloudEdpHelper", "[EDP] requestKeySync() : Succeed!");
                    completableFuture.complete(Boolean.TRUE);
                } else {
                    Debugger.m8609e("SCloudEdpHelper", "[EDP] requestKeySync() : Empty service key id!");
                    completableFuture.complete(Boolean.FALSE);
                }
                break;
        }
    }
}
