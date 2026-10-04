package p122b2;

import android.view.View;
import com.opencsv.exceptions.CsvFieldAssignmentException;
import com.samsung.android.mcf.continuity.impl.ContinuitySession;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.scs.p142ai.asr.tasks.SttRecognitionTask;
import com.samsung.android.sdk.scs.p142ai.language.Corrector;
import com.samsung.android.sdk.scs.p142ai.language.EmojiAugmentor;
import com.samsung.android.sdk.scs.p142ai.language.Extractor;
import com.samsung.android.sdk.scs.p142ai.language.SmartCoverer;
import com.samsung.android.sdk.scs.p142ai.language.SmartReplyer;
import com.samsung.android.sdk.scs.p142ai.language.Suggester;
import com.samsung.android.sdk.scs.p142ai.language.SuggesterForExternal;
import com.samsung.android.sdk.scs.p142ai.language.Summarizer;
import com.samsung.android.sdk.scs.p142ai.language.ToneConverter;
import com.samsung.android.sdk.scs.p142ai.language.WritingComposer;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightControl;
import com.samsung.android.support.senl.p148nt.app.main.appfunction.FolderFunctions;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SearchWord;
import com.samsung.android.support.senl.p148nt.model.document.save.ThumbnailDataCreator;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchNoteUseCase;
import com.samsung.scsp.common.PushConsumer;
import com.samsung.scsp.common.PushVo;
import java.net.Socket;
import java.util.Collection;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.lang3.ArchUtils;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.arch.Processor;
import org.apache.commons.lang3.concurrent.BackgroundInitializer;
import org.apache.commons.lang3.concurrent.MultiBackgroundInitializer;
import p123b3.C4201a;
import p123b3.C4202b;
import p205m4.C13532a;

/* JADX INFO: renamed from: b2.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C4191n implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1802a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1803b;

    public /* synthetic */ C4191n(Object obj, int i) {
        this.f1802a = i;
        this.f1803b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f1802a) {
            case 0:
                ((ContinuitySession) this.f1803b).onAccepted((Socket) obj);
                break;
            case 1:
                ((CsvFieldAssignmentException) obj).setLine((String[]) this.f1803b);
                break;
            case 2:
                ((C4201a) this.f1803b).invoke(obj);
                break;
            case 3:
                ((SttRecognitionTask) this.f1803b).taskCompleted((String) obj);
                break;
            case 4:
                ((com.samsung.android.sdk.scs.p142ai.asr_6_0.tasks.SttRecognitionTask) this.f1803b).taskCompleted((String) obj);
                break;
            case 5:
                ((Corrector) this.f1803b).lambda$release$1((LlmServiceObserver2) obj);
                break;
            case 6:
                ((EmojiAugmentor) this.f1803b).lambda$release$1((LlmServiceObserver2) obj);
                break;
            case 7:
                ((Extractor) this.f1803b).lambda$release$3((LlmServiceObserver2) obj);
                break;
            case 8:
                ((SmartCoverer) this.f1803b).lambda$release$1((LlmServiceObserver2) obj);
                break;
            case 9:
                ((SmartReplyer) this.f1803b).lambda$release$3((LlmServiceObserver2) obj);
                break;
            case 10:
                ((Suggester) this.f1803b).lambda$release$4((LlmServiceObserver2) obj);
                break;
            case 11:
                ((SuggesterForExternal) this.f1803b).lambda$release$0((LlmServiceObserver2) obj);
                break;
            case 12:
                ((Summarizer) this.f1803b).lambda$release$3((LlmServiceObserver2) obj);
                break;
            case 13:
                ((ToneConverter) this.f1803b).lambda$release$2((LlmServiceObserver2) obj);
                break;
            case 14:
                ((WritingComposer) this.f1803b).lambda$release$2((LlmServiceObserver2) obj);
                break;
            case 15:
                ProcessingLightControl.buildAnimation$lambda$6((ProcessingLightControl) this.f1803b, (View) obj);
                break;
            case 16:
                ((C4202b) this.f1803b).invoke(obj);
                break;
            case 17:
                FolderFunctions.updateFolder$lambda$1((String) this.f1803b, (NotesCategoryTreeEntity) obj);
                break;
            case 18:
                ThumbnailDataCreator.lambda$checkBodyImageObject$1((AtomicReference) this.f1803b, (SpenObjectSpan) obj);
                break;
            case 19:
                ((C4201a) this.f1803b).invoke(obj);
                break;
            case 20:
                ((PushConsumer) this.f1803b).lambda$new$1((PushVo) obj);
                break;
            case 21:
                ((SearchNoteUseCase.Result) this.f1803b).lambda$new$0((SearchWord) obj);
                break;
            case 22:
                ((C13532a) this.f1803b).invoke(obj);
                break;
            case 23:
                ((AbstractMapBag) this.f1803b).add(obj);
                break;
            case 24:
                ((Collection) this.f1803b).add(obj);
                break;
            case 25:
                ArchUtils.addProcessor((String) obj, (Processor) this.f1803b);
                break;
            case 26:
                ((CharSet) this.f1803b).add((String) obj);
                break;
            case 27:
                EnumUtils.lambda$generateBitVectors$0((EnumSet) this.f1803b, (Enum) obj);
                break;
            case 28:
                Functions.accept((Functions.FailableConsumer) this.f1803b, obj);
                break;
            default:
                MultiBackgroundInitializer.lambda$initialize$0((ExecutorService) this.f1803b, (BackgroundInitializer) obj);
                break;
        }
    }
}
