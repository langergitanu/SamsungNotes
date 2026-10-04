package p100Y3;

import com.samsung.android.sdk.pen.recogengine.preload.SpenRecognizerPlugin;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.Action;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paAssertion;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paManifest;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paManifestList;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.ValidationStatus;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerInfo;
import com.samsung.android.support.senl.p148nt.base.common.StorageLogger;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLVMRequesterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.utils.MarkdownTableParser;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.model.assist.common.ChnWatermarkUtil;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.component.MarkdownComponent;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.processing.MarkdownGenerator;
import com.samsung.android.support.senl.p148nt.stt.base.audio.ScsRecognizer;
import com.samsung.android.support.senl.p148nt.stt.view.language.STTLanguageManager;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.time.InstantKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

/* JADX INFO: renamed from: Y3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0348a implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f872a;

    public /* synthetic */ C0348a(int i) {
        this.f872a = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f872a) {
            case 0:
                return new DocumentCategoryTree((List) obj);
            case 1:
                return C2paManifest.Builder.build$lambda$2((C2paAssertion) obj);
            case 2:
                return C2paManifest.Builder.build$lambda$3((Action) obj);
            case 3:
                return C2paManifestList.checkInvalid$lambda$22((ValidationStatus) obj);
            case 4:
                return Boolean.valueOf(VibeRenderEffectBase.hasVisibleView$lambda$2((WeakReference) obj));
            case 5:
                return StorageLogger.print$lambda$2$lambda$1((String) obj);
            case 6:
                return SCSLVMRequesterImpl.cancel$lambda$17((Task) obj);
            case 7:
                return SCSLVMRequesterImpl.release$lambda$7((Task) obj);
            case 8:
                return SCSLVMRequesterImpl.release$lambda$9((Task) obj);
            case 9:
                return SCSLVMRequesterImpl.cancel$lambda$11((Task) obj);
            case 10:
                return SCSLVMRequesterImpl.cancel$lambda$13((Task) obj);
            case 11:
                return SCSLVMRequesterImpl.cancel$lambda$15((Task) obj);
            case 12:
                return ChnWatermarkUtil.toHexString$lambda$13(((Byte) obj).byteValue());
            case 13:
                return ScsRecognizer.startRecognizer$lambda$1((String) obj);
            case 14:
                return MarkdownGenerator.Companion.generate$lambda$0((MarkdownComponent) obj);
            case 15:
                return Integer.valueOf(SpenRecognizerPlugin.addHwrDataWith$lambda$3(((Integer) obj).intValue()));
            case 16:
                return Boolean.valueOf(InstantKt.parseIso$lambda$1(((Character) obj).charValue()));
            case 17:
                return Boolean.valueOf(InstantKt.parseIso$lambda$2(((Character) obj).charValue()));
            case 18:
                return Boolean.valueOf(InstantKt.parseIso$lambda$3(((Character) obj).charValue()));
            case 19:
                return Boolean.valueOf(InstantKt.parseIso$lambda$4(((Character) obj).charValue()));
            case 20:
                return Boolean.valueOf(InstantKt.parseIso$lambda$5(((Character) obj).charValue()));
            case 21:
                return Boolean.valueOf(InstantKt.parseIso$lambda$6(((Character) obj).charValue()));
            case 22:
                return CoroutineDispatcher.Companion._init_$lambda$0((CoroutineContext.Element) obj);
            case 23:
                return ExecutorCoroutineDispatcher.Companion._init_$lambda$0((CoroutineContext.Element) obj);
            case 24:
                return Boolean.valueOf(DebugProbesImpl.dumpCoroutinesSynchronized$lambda$14((DebugProbesImpl.CoroutineOwner) obj));
            case 25:
                return Integer.valueOf(MarkdownTableParser.extractTables$lambda$2((List) obj));
            default:
                return Boolean.valueOf(STTLanguageManager._get_langPackInfo_$lambda$0((ServerInfo) obj));
        }
    }
}
