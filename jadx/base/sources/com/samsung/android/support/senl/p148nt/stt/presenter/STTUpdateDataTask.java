package com.samsung.android.support.senl.p148nt.stt.presenter;

import android.content.Context;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SttContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.stt.base.audio.ConvertUtils;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AIParagraphAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AISpeakerAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AISummarySectionAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AudioFormat;
import com.samsung.android.support.senl.p148nt.stt.base.model.STTDataHelper;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReader;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReaderCache;
import com.samsung.android.support.senl.p148nt.stt.base.model.TextData;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.util.STTDataUtils;
import com.samsung.android.support.senl.p148nt.stt.controller.STTVoiceDataController;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTUpdateDataTask;
import com.sec.android.app.voicenote.common.util.DataConverter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.AbstractC12991c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 A2\u00020\u0001:\u0002@AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J]\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000f0\u001a2\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJb\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000f0\u001a2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001dJ\u001e\u0010)\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u001dJg\u0010*\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u001b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\u0006\u0010-\u001a\u00020&2\u001c\u0010.\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0!j\b\u0012\u0004\u0012\u00020\u000f`#0\u00132\u0006\u0010/\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001d¢\u0006\u0002\u00100J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u000fH\u0002J\\\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010<\u001a\u00020=2\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020?0!j\b\u0012\u0004\u0012\u00020?`#2\u0006\u0010(\u001a\u00020\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/presenter/STTUpdateDataTask;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob", "()Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "saveDataToSpenVoice", "Lkotlinx/coroutines/Job;", "documentPath", "", "updateItem", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "voiceText", "", "timingInfo", "", "speechInfoList", "", "Lcom/samsung/android/sivs/ai/sdkcommon/asr/SpeechInfo;", "speakerNameMap", "", "", "callBack", "Lcom/samsung/android/support/senl/nt/stt/presenter/STTUpdateDataTask$Callback;", "(Ljava/lang/String;Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;[Ljava/lang/String;[ILjava/util/List;Ljava/util/Map;Lcom/samsung/android/support/senl/nt/stt/presenter/STTUpdateDataTask$Callback;)Lkotlinx/coroutines/Job;", "editSTTVoiceData", "textDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "Lkotlin/collections/ArrayList;", "speakerIDs", "startTimes", "", "endTimes", Profile.PhoneNumberData.TYPE_CALLBACK, "removeSTTVoiceData", "writeSummaryResult", "size", "sectionTitle", "timeStamp", "summaryList", "summaryStyle", "(Ljava/lang/String;Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;I[Ljava/lang/String;[J[Ljava/util/ArrayList;ILcom/samsung/android/support/senl/nt/stt/presenter/STTUpdateDataTask$Callback;)Lkotlinx/coroutines/Job;", "getTempFile", "Ljava/io/File;", "path", "updateSTTData", "docPath", "uuid", "dataController", "Lcom/samsung/android/support/senl/nt/stt/controller/STTVoiceDataController;", "readerCache", "Lcom/samsung/android/support/senl/nt/stt/base/model/SpenVoiceTextDataReaderCache;", "voiceDataList", "context", "Landroid/content/Context;", "sttContentList", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/SttContentEntity;", "Callback", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTUpdateDataTask implements CoroutineScope {

    @NotNull
    private static final String TAG = "STTLoadDataTask";

    @NotNull
    private final CompletableJob job = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/presenter/STTUpdateDataTask$Callback;", "", "onFinished", "", "isSuccess", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Callback {
        void onFinished(boolean isSuccess);
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$editSTTVoiceData$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$editSTTVoiceData$1", m14021f = "STTUpdateDataTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C115171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Callback $callback;
        final /* synthetic */ String $documentPath;
        final /* synthetic */ long[] $endTimes;
        final /* synthetic */ int[] $speakerIDs;
        final /* synthetic */ Map<Integer, String> $speakerNameMap;
        final /* synthetic */ long[] $startTimes;
        final /* synthetic */ ArrayList<TextData> $textDataList;
        final /* synthetic */ SpenVoiceData $updateItem;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ STTUpdateDataTask this$0;

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$editSTTVoiceData$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$editSTTVoiceData$1$2", m14021f = "STTUpdateDataTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Callback $callback;
            final /* synthetic */ Ref.BooleanRef $isAllSuccess;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Callback callback, Ref.BooleanRef booleanRef, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$callback = callback;
                this.$isAllSuccess = booleanRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$callback, this.$isAllSuccess, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$callback.onFinished(this.$isAllSuccess.element);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C115171(String str, SpenVoiceData spenVoiceData, ArrayList<TextData> arrayList, STTUpdateDataTask sTTUpdateDataTask, Map<Integer, String> map, int[] iArr, long[] jArr, long[] jArr2, Callback callback, Continuation<? super C115171> continuation) {
            super(2, continuation);
            this.$documentPath = str;
            this.$updateItem = spenVoiceData;
            this.$textDataList = arrayList;
            this.this$0 = sTTUpdateDataTask;
            this.$speakerNameMap = map;
            this.$speakerIDs = iArr;
            this.$startTimes = jArr;
            this.$endTimes = jArr2;
            this.$callback = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Boolean invokeSuspend$lambda$0(SpenVoiceData spenVoiceData, ArrayList arrayList, STTUpdateDataTask sTTUpdateDataTask, Map map, int[] iArr, long[] jArr, long[] jArr2) {
            Logger.m12713i(STTUpdateDataTask.TAG, "editSTTVoiceData saving stt data to " + spenVoiceData.getAttachedFile());
            File voiceSavedDataTempFile = ConvertUtils.getVoiceSavedDataTempFile(spenVoiceData.getAttachedFile());
            if (voiceSavedDataTempFile == null) {
                return Boolean.FALSE;
            }
            String attachedFile = spenVoiceData.getAttachedFile();
            String absolutePath = voiceSavedDataTempFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            boolean zWriteSTTDataToFile = STTDataHelper.writeSTTDataToFile(attachedFile, absolutePath, arrayList);
            String absolutePath2 = voiceSavedDataTempFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
            File tempFile = sTTUpdateDataTask.getTempFile(absolutePath2);
            boolean zOverwriteMakeFile = new AISpeakerAtomHelper(voiceSavedDataTempFile.getAbsolutePath()).overwriteMakeFile(DataConverter.convertSpeakerToVRData(map), tempFile.getAbsolutePath());
            String absolutePath3 = tempFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath3, "getAbsolutePath(...)");
            File tempFile2 = sTTUpdateDataTask.getTempFile(absolutePath3);
            boolean zOverwriteMakeFile2 = new AISummarySectionAtomHelper(tempFile.getAbsolutePath()).overwriteMakeFile(DataConverter.convertSummaryToVRData(0, null, null, null, STTVoiceDataController.SummaryOption.SHOW_AS_TIMELINE.ordinal()), tempFile2.getAbsolutePath());
            String absolutePath4 = tempFile2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath4, "getAbsolutePath(...)");
            File tempFile3 = sTTUpdateDataTask.getTempFile(absolutePath4);
            boolean zOverwriteMakeFile3 = new AIParagraphAtomHelper(tempFile2.getAbsolutePath()).overwriteMakeFile(DataConverter.convertParagraphToVRData(iArr, jArr, jArr2), tempFile3.getAbsolutePath());
            if (!zWriteSTTDataToFile || !zOverwriteMakeFile || !zOverwriteMakeFile2 || !zOverwriteMakeFile3) {
                Logger.m12713i(STTUpdateDataTask.TAG, "editSTTVoiceData save stt data error: " + voiceSavedDataTempFile.getAbsolutePath());
                return Boolean.FALSE;
            }
            spenVoiceData.attachFile(tempFile3.getAbsolutePath());
            if (!tempFile.delete() || !voiceSavedDataTempFile.delete() || !tempFile2.delete() || !tempFile3.delete()) {
                String absolutePath5 = tempFile.getAbsolutePath();
                String absolutePath6 = voiceSavedDataTempFile.getAbsolutePath();
                String absolutePath7 = tempFile2.getAbsolutePath();
                String absolutePath8 = tempFile3.getAbsolutePath();
                StringBuilder sbM16m = AbstractC0000a.m16m("editSTTVoiceData can not delete temp file ", absolutePath5, SQLKeyword.COMMA, absolutePath6, SQLKeyword.COMMA);
                sbM16m.append(absolutePath7);
                sbM16m.append(SQLKeyword.COMMA);
                sbM16m.append(absolutePath8);
                Logger.m12711e(STTUpdateDataTask.TAG, sbM16m.toString());
            }
            SpenVoiceTextDataReaderCache.INSTANCE.getInstance().put(spenVoiceData);
            Logger.m12713i(STTUpdateDataTask.TAG, "editSTTVoiceData save stt data success: " + spenVoiceData.getAttachedFile());
            return Boolean.TRUE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C115171 c115171 = new C115171(this.$documentPath, this.$updateItem, this.$textDataList, this.this$0, this.$speakerNameMap, this.$speakerIDs, this.$startTimes, this.$endTimes, this.$callback, continuation);
            c115171.L$0 = obj;
            return c115171;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ref.BooleanRef booleanRef;
            MainCoroutineDispatcher main;
            AnonymousClass2 anonymousClass2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ConvertUtils convertUtils = ConvertUtils.INSTANCE;
            convertUtils.lockCacheFolder();
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            try {
                DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
                String str = this.$documentPath;
                final SpenVoiceData spenVoiceData = this.$updateItem;
                final ArrayList<TextData> arrayList = this.$textDataList;
                final STTUpdateDataTask sTTUpdateDataTask = this.this$0;
                final Map<Integer, String> map = this.$speakerNameMap;
                final int[] iArr = this.$speakerIDs;
                final long[] jArr = this.$startTimes;
                final long[] jArr2 = this.$endTimes;
                Object objExecuteAction = documentFileManager.executeAction(str, new DocumentFileManager.IOAction() { // from class: com.samsung.android.support.senl.nt.stt.presenter.k
                    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
                    public final Object operate() {
                        return STTUpdateDataTask.C115171.invokeSuspend$lambda$0(spenVoiceData, arrayList, sTTUpdateDataTask, map, iArr, jArr, jArr2);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(objExecuteAction, "executeAction(...)");
                booleanRef2.element = ((Boolean) objExecuteAction).booleanValue();
                convertUtils.unlockCacheFolder();
                main = Dispatchers.getMain();
                anonymousClass2 = new AnonymousClass2(this.$callback, booleanRef2, null);
            } catch (Exception e) {
                booleanRef = booleanRef2;
                try {
                    Logger.m12711e(STTUpdateDataTask.TAG, "saveDataToSpenVoice exception = " + e.getMessage());
                    ConvertUtils.INSTANCE.unlockCacheFolder();
                    main = Dispatchers.getMain();
                    anonymousClass2 = new AnonymousClass2(this.$callback, booleanRef, null);
                } catch (Throwable th) {
                    th = th;
                    ConvertUtils.INSTANCE.unlockCacheFolder();
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass2(this.$callback, booleanRef, null), 2, null);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                booleanRef = booleanRef2;
                ConvertUtils.INSTANCE.unlockCacheFolder();
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass2(this.$callback, booleanRef, null), 2, null);
                throw th;
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, main, null, anonymousClass2, 2, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C115171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$removeSTTVoiceData$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$removeSTTVoiceData$1", m14021f = "STTUpdateDataTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C115181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Callback $callback;
        final /* synthetic */ String $documentPath;
        final /* synthetic */ SpenVoiceData $updateItem;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ STTUpdateDataTask this$0;

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$removeSTTVoiceData$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$removeSTTVoiceData$1$2", m14021f = "STTUpdateDataTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Callback $callback;
            final /* synthetic */ Ref.BooleanRef $isAllSuccess;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Callback callback, Ref.BooleanRef booleanRef, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$callback = callback;
                this.$isAllSuccess = booleanRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$callback, this.$isAllSuccess, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$callback.onFinished(this.$isAllSuccess.element);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C115181(String str, SpenVoiceData spenVoiceData, STTUpdateDataTask sTTUpdateDataTask, Callback callback, Continuation<? super C115181> continuation) {
            super(2, continuation);
            this.$documentPath = str;
            this.$updateItem = spenVoiceData;
            this.this$0 = sTTUpdateDataTask;
            this.$callback = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Boolean invokeSuspend$lambda$0(SpenVoiceData spenVoiceData, STTUpdateDataTask sTTUpdateDataTask) {
            Logger.m12713i(STTUpdateDataTask.TAG, "removeSTTVoiceData remove stt data to " + spenVoiceData.getAttachedFile());
            File voiceSavedDataTempFile = ConvertUtils.getVoiceSavedDataTempFile(spenVoiceData.getAttachedFile());
            if (voiceSavedDataTempFile == null) {
                return Boolean.FALSE;
            }
            String attachedFile = spenVoiceData.getAttachedFile();
            String absolutePath = voiceSavedDataTempFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            boolean zRemoveSTTData = STTDataHelper.removeSTTData(attachedFile, absolutePath);
            String absolutePath2 = voiceSavedDataTempFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
            File tempFile = sTTUpdateDataTask.getTempFile(absolutePath2);
            boolean zOverwriteMakeFile = new AISpeakerAtomHelper(voiceSavedDataTempFile.getAbsolutePath()).overwriteMakeFile(DataConverter.convertSpeakerToVRData(new HashMap()), tempFile.getAbsolutePath());
            String absolutePath3 = tempFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath3, "getAbsolutePath(...)");
            File tempFile2 = sTTUpdateDataTask.getTempFile(absolutePath3);
            boolean zOverwriteMakeFile2 = new AISummarySectionAtomHelper(tempFile.getAbsolutePath()).overwriteMakeFile(DataConverter.convertSummaryToVRData(0, null, null, null, STTVoiceDataController.SummaryOption.SHOW_AS_TIMELINE.ordinal()), tempFile2.getAbsolutePath());
            String absolutePath4 = tempFile2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath4, "getAbsolutePath(...)");
            File tempFile3 = sTTUpdateDataTask.getTempFile(absolutePath4);
            boolean zOverwriteMakeFile3 = new AIParagraphAtomHelper(tempFile2.getAbsolutePath()).overwriteMakeFile(null, tempFile3.getAbsolutePath());
            if (!zRemoveSTTData || !zOverwriteMakeFile || !zOverwriteMakeFile2 || !zOverwriteMakeFile3) {
                Logger.m12713i(STTUpdateDataTask.TAG, "saveDataToSpenVoice save stt data error: " + voiceSavedDataTempFile.getAbsolutePath());
                return Boolean.FALSE;
            }
            spenVoiceData.attachFile(tempFile3.getAbsolutePath());
            if (!tempFile.delete() || !voiceSavedDataTempFile.delete() || !tempFile2.delete() || !tempFile3.delete()) {
                String absolutePath5 = tempFile.getAbsolutePath();
                String absolutePath6 = voiceSavedDataTempFile.getAbsolutePath();
                String absolutePath7 = tempFile2.getAbsolutePath();
                String absolutePath8 = tempFile3.getAbsolutePath();
                StringBuilder sbM16m = AbstractC0000a.m16m("saveDataToSpenVoice can not delete temp file ", absolutePath5, SQLKeyword.COMMA, absolutePath6, SQLKeyword.COMMA);
                sbM16m.append(absolutePath7);
                sbM16m.append(SQLKeyword.COMMA);
                sbM16m.append(absolutePath8);
                Logger.m12711e(STTUpdateDataTask.TAG, sbM16m.toString());
            }
            SpenVoiceTextDataReaderCache.INSTANCE.getInstance().put(spenVoiceData);
            Logger.m12713i(STTUpdateDataTask.TAG, "saveDataToSpenVoice save stt data success: " + spenVoiceData.getAttachedFile());
            return Boolean.TRUE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C115181 c115181 = new C115181(this.$documentPath, this.$updateItem, this.this$0, this.$callback, continuation);
            c115181.L$0 = obj;
            return c115181;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ref.BooleanRef booleanRef;
            MainCoroutineDispatcher main;
            AnonymousClass2 anonymousClass2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ConvertUtils convertUtils = ConvertUtils.INSTANCE;
            convertUtils.lockCacheFolder();
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            try {
                DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
                String str = this.$documentPath;
                final SpenVoiceData spenVoiceData = this.$updateItem;
                final STTUpdateDataTask sTTUpdateDataTask = this.this$0;
                Object objExecuteAction = documentFileManager.executeAction(str, new DocumentFileManager.IOAction() { // from class: com.samsung.android.support.senl.nt.stt.presenter.l
                    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
                    public final Object operate() {
                        return STTUpdateDataTask.C115181.invokeSuspend$lambda$0(spenVoiceData, sTTUpdateDataTask);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(objExecuteAction, "executeAction(...)");
                booleanRef2.element = ((Boolean) objExecuteAction).booleanValue();
                convertUtils.unlockCacheFolder();
                main = Dispatchers.getMain();
                anonymousClass2 = new AnonymousClass2(this.$callback, booleanRef2, null);
            } catch (Exception e) {
                booleanRef = booleanRef2;
                try {
                    Logger.m12711e(STTUpdateDataTask.TAG, "saveDataToSpenVoice exception = " + e.getMessage());
                    ConvertUtils.INSTANCE.unlockCacheFolder();
                    main = Dispatchers.getMain();
                    anonymousClass2 = new AnonymousClass2(this.$callback, booleanRef, null);
                } catch (Throwable th) {
                    th = th;
                    ConvertUtils.INSTANCE.unlockCacheFolder();
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass2(this.$callback, booleanRef, null), 2, null);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                booleanRef = booleanRef2;
                ConvertUtils.INSTANCE.unlockCacheFolder();
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass2(this.$callback, booleanRef, null), 2, null);
                throw th;
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, main, null, anonymousClass2, 2, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C115181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$saveDataToSpenVoice$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$saveDataToSpenVoice$1", m14021f = "STTUpdateDataTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C115191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Callback $callBack;
        final /* synthetic */ String $documentPath;
        final /* synthetic */ Map<Integer, String> $speakerNameMap;
        final /* synthetic */ List<SpeechInfo> $speechInfoList;
        final /* synthetic */ int[] $timingInfo;
        final /* synthetic */ SpenVoiceData $updateItem;
        final /* synthetic */ String[] $voiceText;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ STTUpdateDataTask this$0;

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$saveDataToSpenVoice$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$saveDataToSpenVoice$1$2", m14021f = "STTUpdateDataTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Callback $callBack;
            final /* synthetic */ Ref.BooleanRef $isAllSuccess;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Callback callback, Ref.BooleanRef booleanRef, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$callBack = callback;
                this.$isAllSuccess = booleanRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$callBack, this.$isAllSuccess, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$callBack.onFinished(this.$isAllSuccess.element);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C115191(String str, SpenVoiceData spenVoiceData, String[] strArr, int[] iArr, List<? extends SpeechInfo> list, STTUpdateDataTask sTTUpdateDataTask, Map<Integer, String> map, Callback callback, Continuation<? super C115191> continuation) {
            super(2, continuation);
            this.$documentPath = str;
            this.$updateItem = spenVoiceData;
            this.$voiceText = strArr;
            this.$timingInfo = iArr;
            this.$speechInfoList = list;
            this.this$0 = sTTUpdateDataTask;
            this.$speakerNameMap = map;
            this.$callBack = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Boolean invokeSuspend$lambda$0(SpenVoiceData spenVoiceData, String[] strArr, int[] iArr, List list, STTUpdateDataTask sTTUpdateDataTask, Map map) throws Throwable {
            Logger.m12713i(STTUpdateDataTask.TAG, "saveDataToSpenVoice saving stt data to " + spenVoiceData.getAttachedFile());
            File voiceSavedDataTempFile = ConvertUtils.getVoiceSavedDataTempFile(spenVoiceData.getAttachedFile());
            if (voiceSavedDataTempFile == null) {
                return Boolean.FALSE;
            }
            String attachedFile = spenVoiceData.getAttachedFile();
            String absolutePath = voiceSavedDataTempFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            boolean zWriteSTTDataToShareFile = STTDataHelper.writeSTTDataToShareFile(attachedFile, absolutePath, strArr, iArr, list);
            String absolutePath2 = voiceSavedDataTempFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
            File tempFile = sTTUpdateDataTask.getTempFile(absolutePath2);
            boolean zOverwriteMakeFile = new AISpeakerAtomHelper(voiceSavedDataTempFile.getAbsolutePath()).overwriteMakeFile(DataConverter.convertSpeakerToVRData(map), tempFile.getAbsolutePath());
            String absolutePath3 = tempFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath3, "getAbsolutePath(...)");
            File tempFile2 = sTTUpdateDataTask.getTempFile(absolutePath3);
            boolean zOverwriteMakeFile2 = new AISummarySectionAtomHelper(tempFile.getAbsolutePath()).overwriteMakeFile(DataConverter.convertSummaryToVRData(0, null, null, null, STTVoiceDataController.SummaryOption.SHOW_AS_TIMELINE.ordinal()), tempFile2.getAbsolutePath());
            String absolutePath4 = tempFile2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath4, "getAbsolutePath(...)");
            File tempFile3 = sTTUpdateDataTask.getTempFile(absolutePath4);
            boolean zOverwriteMakeFile3 = new AIParagraphAtomHelper(tempFile2.getAbsolutePath()).overwriteMakeFile(null, tempFile3.getAbsolutePath());
            if (!zWriteSTTDataToShareFile || !zOverwriteMakeFile || !zOverwriteMakeFile2 || !zOverwriteMakeFile3) {
                Logger.m12713i(STTUpdateDataTask.TAG, "saveDataToSpenVoice save stt data error: " + voiceSavedDataTempFile.getAbsolutePath());
                return Boolean.FALSE;
            }
            spenVoiceData.attachFile(tempFile3.getAbsolutePath());
            if (!tempFile.delete() || !voiceSavedDataTempFile.delete() || !tempFile2.delete() || !tempFile3.delete()) {
                String absolutePath5 = tempFile.getAbsolutePath();
                String absolutePath6 = voiceSavedDataTempFile.getAbsolutePath();
                String absolutePath7 = tempFile2.getAbsolutePath();
                String absolutePath8 = tempFile3.getAbsolutePath();
                StringBuilder sbM16m = AbstractC0000a.m16m("saveDataToSpenVoice can not delete temp file ", absolutePath5, SQLKeyword.COMMA, absolutePath6, SQLKeyword.COMMA);
                sbM16m.append(absolutePath7);
                sbM16m.append(SQLKeyword.COMMA);
                sbM16m.append(absolutePath8);
                Logger.m12711e(STTUpdateDataTask.TAG, sbM16m.toString());
            }
            SpenVoiceTextDataReaderCache.INSTANCE.getInstance().put(spenVoiceData);
            Logger.m12713i(STTUpdateDataTask.TAG, "saveDataToSpenVoice save stt data success: " + spenVoiceData.getAttachedFile());
            return Boolean.TRUE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C115191 c115191 = new C115191(this.$documentPath, this.$updateItem, this.$voiceText, this.$timingInfo, this.$speechInfoList, this.this$0, this.$speakerNameMap, this.$callBack, continuation);
            c115191.L$0 = obj;
            return c115191;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ref.BooleanRef booleanRef;
            MainCoroutineDispatcher main;
            AnonymousClass2 anonymousClass2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ConvertUtils convertUtils = ConvertUtils.INSTANCE;
            convertUtils.lockCacheFolder();
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            try {
                Object objExecuteAction = DocumentFileManager.getInstance().executeAction(this.$documentPath, new C11534m(this.$updateItem, this.$voiceText, this.$timingInfo, this.$speechInfoList, this.this$0, this.$speakerNameMap));
                Intrinsics.checkNotNullExpressionValue(objExecuteAction, "executeAction(...)");
                booleanRef2.element = ((Boolean) objExecuteAction).booleanValue();
                convertUtils.unlockCacheFolder();
                main = Dispatchers.getMain();
                anonymousClass2 = new AnonymousClass2(this.$callBack, booleanRef2, null);
            } catch (Exception e) {
                booleanRef = booleanRef2;
                try {
                    Logger.m12711e(STTUpdateDataTask.TAG, "saveDataToSpenVoice exception = " + e.getMessage());
                    ConvertUtils.INSTANCE.unlockCacheFolder();
                    main = Dispatchers.getMain();
                    anonymousClass2 = new AnonymousClass2(this.$callBack, booleanRef, null);
                } catch (Throwable th) {
                    th = th;
                    ConvertUtils.INSTANCE.unlockCacheFolder();
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass2(this.$callBack, booleanRef, null), 2, null);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                booleanRef = booleanRef2;
                ConvertUtils.INSTANCE.unlockCacheFolder();
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass2(this.$callBack, booleanRef, null), 2, null);
                throw th;
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, main, null, anonymousClass2, 2, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C115191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$updateSTTData$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$updateSTTData$1", m14021f = "STTUpdateDataTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C115201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Callback $callback;
        final /* synthetic */ Context $context;
        final /* synthetic */ STTVoiceDataController $dataController;
        final /* synthetic */ String $docPath;
        final /* synthetic */ SpenVoiceTextDataReaderCache $readerCache;
        final /* synthetic */ ArrayList<SttContentEntity> $sttContentList;
        final /* synthetic */ String $uuid;
        final /* synthetic */ List<SpenVoiceData> $voiceDataList;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$updateSTTData$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$updateSTTData$1$2", m14021f = "STTUpdateDataTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Callback $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Callback callback, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$callback = callback;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$callback, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$callback.onFinished(true);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C115201(String str, List<SpenVoiceData> list, SpenVoiceTextDataReaderCache spenVoiceTextDataReaderCache, STTVoiceDataController sTTVoiceDataController, Context context, String str2, ArrayList<SttContentEntity> arrayList, Callback callback, Continuation<? super C115201> continuation) {
            super(2, continuation);
            this.$docPath = str;
            this.$voiceDataList = list;
            this.$readerCache = spenVoiceTextDataReaderCache;
            this.$dataController = sTTVoiceDataController;
            this.$context = context;
            this.$uuid = str2;
            this.$sttContentList = arrayList;
            this.$callback = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(List list, SpenVoiceTextDataReaderCache spenVoiceTextDataReaderCache, STTVoiceDataController sTTVoiceDataController, Context context, String str, ArrayList arrayList) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SpenVoiceData spenVoiceData = (SpenVoiceData) it.next();
                String attachedFile = spenVoiceData.getAttachedFile();
                if (attachedFile != null) {
                    Logger.m12710d(STTUpdateDataTask.TAG, "updateSTTData# load data from db to cache");
                    SpenVoiceTextDataReader withoutFileData = spenVoiceTextDataReaderCache.getWithoutFileData(spenVoiceData);
                    String strExtractFile = FileUtils.extractFile(attachedFile);
                    sTTVoiceDataController.loadDataFromDataBase(withoutFileData, context, str, strExtractFile);
                    String[] voiceTexts = withoutFileData.getVoiceTexts();
                    if (voiceTexts == null || voiceTexts.length == 0) {
                        Logger.m12710d(STTUpdateDataTask.TAG, "updateSTTData# db not have data");
                        Logger.m12710d(STTUpdateDataTask.TAG, "updateSTTData# load data from file to db");
                        File file = new File(attachedFile);
                        if (file.exists()) {
                            long jLastModified = file.lastModified();
                            withoutFileData.loadDataFromFile(spenVoiceData);
                            String str2 = str;
                            arrayList.addAll(STTDataUtils.setSTTDataContentToDB(withoutFileData, str2, strExtractFile, 0, jLastModified));
                            arrayList.addAll(STTDataUtils.setSTTDataContentToDB(withoutFileData, str2, strExtractFile, 1, jLastModified));
                            arrayList.addAll(STTDataUtils.setSTTDataContentToDB(withoutFileData, str2, strExtractFile, 2, jLastModified));
                            arrayList.addAll(STTDataUtils.setSTTDataContentToDB(withoutFileData, str2, strExtractFile, 3, jLastModified));
                            str = str2;
                        } else {
                            Logger.m12714w(STTUpdateDataTask.TAG, "updateSTTData# file not exist: ".concat(attachedFile));
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C115201 c115201 = new C115201(this.$docPath, this.$voiceDataList, this.$readerCache, this.$dataController, this.$context, this.$uuid, this.$sttContentList, this.$callback, continuation);
            c115201.L$0 = obj;
            return c115201;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            DocumentFileManager.getInstance().executeAction(this.$docPath, new C11534m(this.$voiceDataList, this.$readerCache, this.$dataController, this.$context, this.$uuid, this.$sttContentList));
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass2(this.$callback, null), 2, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C115201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$writeSummaryResult$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$writeSummaryResult$1", m14021f = "STTUpdateDataTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C115211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Callback $callback;
        final /* synthetic */ String $documentPath;
        final /* synthetic */ String[] $sectionTitle;
        final /* synthetic */ int $size;
        final /* synthetic */ ArrayList<String>[] $summaryList;
        final /* synthetic */ int $summaryStyle;
        final /* synthetic */ long[] $timeStamp;
        final /* synthetic */ SpenVoiceData $updateItem;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$writeSummaryResult$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask$writeSummaryResult$1$2", m14021f = "STTUpdateDataTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Callback $callback;
            final /* synthetic */ Ref.BooleanRef $isSuccess;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Callback callback, Ref.BooleanRef booleanRef, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$callback = callback;
                this.$isSuccess = booleanRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$callback, this.$isSuccess, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$callback.onFinished(this.$isSuccess.element);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C115211(String str, SpenVoiceData spenVoiceData, int i, String[] strArr, long[] jArr, ArrayList<String>[] arrayListArr, int i2, Callback callback, Continuation<? super C115211> continuation) {
            super(2, continuation);
            this.$documentPath = str;
            this.$updateItem = spenVoiceData;
            this.$size = i;
            this.$sectionTitle = strArr;
            this.$timeStamp = jArr;
            this.$summaryList = arrayListArr;
            this.$summaryStyle = i2;
            this.$callback = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Boolean invokeSuspend$lambda$0(SpenVoiceData spenVoiceData, int i, String[] strArr, long[] jArr, ArrayList[] arrayListArr, int i2) {
            Logger.m12713i(STTUpdateDataTask.TAG, "writeSummaryResult writeSummaryResult summary data to " + spenVoiceData.getAttachedFile());
            String attachedFile = spenVoiceData.getAttachedFile();
            if (!AbstractC2322a.m1607A(attachedFile)) {
                Logger.m12711e(STTUpdateDataTask.TAG, "writeSummaryResult: srcFile not exist");
                return Boolean.FALSE;
            }
            File voiceSavedDataTempFile = ConvertUtils.getVoiceSavedDataTempFile(attachedFile);
            if (voiceSavedDataTempFile == null) {
                Logger.m12711e(STTUpdateDataTask.TAG, "writeSummaryResult: desFile is null");
                return Boolean.FALSE;
            }
            String absolutePath = voiceSavedDataTempFile.getAbsolutePath();
            if (voiceSavedDataTempFile.exists()) {
                if (!voiceSavedDataTempFile.delete()) {
                    Logger.m12711e(STTUpdateDataTask.TAG, "writeSummaryResult: Fail to delete desFile");
                    return Boolean.FALSE;
                }
                if (!voiceSavedDataTempFile.createNewFile()) {
                    Logger.m12711e(STTUpdateDataTask.TAG, "writeSummaryResult: Fail to createNewFile");
                    return Boolean.FALSE;
                }
                Logger.m12710d(STTUpdateDataTask.TAG, "writeSummaryResult: desFile clear");
            }
            if (!new AISummarySectionAtomHelper(attachedFile).overwriteMakeFile(DataConverter.convertSummaryToVRData(i, strArr, jArr, arrayListArr, i2), absolutePath)) {
                Logger.m12711e(STTUpdateDataTask.TAG, "writeSummaryResult: failed ");
                return Boolean.FALSE;
            }
            spenVoiceData.attachFile(absolutePath);
            if (!voiceSavedDataTempFile.delete()) {
                AbstractC12991c.m14005z("writeSummaryResult can not delete temp file ", voiceSavedDataTempFile.getAbsolutePath(), STTUpdateDataTask.TAG);
            }
            SpenVoiceTextDataReaderCache.INSTANCE.getInstance().put(spenVoiceData);
            Logger.m12710d(STTUpdateDataTask.TAG, "writeSummaryResult: success " + absolutePath + " textDataSize: " + i);
            return Boolean.TRUE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C115211 c115211 = new C115211(this.$documentPath, this.$updateItem, this.$size, this.$sectionTitle, this.$timeStamp, this.$summaryList, this.$summaryStyle, this.$callback, continuation);
            c115211.L$0 = obj;
            return c115211;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ref.BooleanRef booleanRef;
            MainCoroutineDispatcher main;
            AnonymousClass2 anonymousClass2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ConvertUtils convertUtils = ConvertUtils.INSTANCE;
            convertUtils.lockCacheFolder();
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            try {
                DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
                String str = this.$documentPath;
                final SpenVoiceData spenVoiceData = this.$updateItem;
                final int i = this.$size;
                final String[] strArr = this.$sectionTitle;
                final long[] jArr = this.$timeStamp;
                final ArrayList<String>[] arrayListArr = this.$summaryList;
                final int i2 = this.$summaryStyle;
                Object objExecuteAction = documentFileManager.executeAction(str, new DocumentFileManager.IOAction() { // from class: com.samsung.android.support.senl.nt.stt.presenter.n
                    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
                    public final Object operate() {
                        return STTUpdateDataTask.C115211.invokeSuspend$lambda$0(spenVoiceData, i, strArr, jArr, arrayListArr, i2);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(objExecuteAction, "executeAction(...)");
                booleanRef2.element = ((Boolean) objExecuteAction).booleanValue();
                convertUtils.unlockCacheFolder();
                main = Dispatchers.getMain();
                anonymousClass2 = new AnonymousClass2(this.$callback, booleanRef2, null);
            } catch (Exception e) {
                booleanRef = booleanRef2;
                try {
                    Logger.m12711e(STTUpdateDataTask.TAG, "saveDataToSpenVoice exception = " + e.getMessage());
                    ConvertUtils.INSTANCE.unlockCacheFolder();
                    main = Dispatchers.getMain();
                    anonymousClass2 = new AnonymousClass2(this.$callback, booleanRef, null);
                } catch (Throwable th) {
                    th = th;
                    ConvertUtils.INSTANCE.unlockCacheFolder();
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass2(this.$callback, booleanRef, null), 2, null);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                booleanRef = booleanRef2;
                ConvertUtils.INSTANCE.unlockCacheFolder();
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass2(this.$callback, booleanRef, null), 2, null);
                throw th;
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, main, null, anonymousClass2, 2, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C115211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getTempFile(String path) {
        long j;
        File file;
        int iM14130D = StringsKt.m14130D(path, '.');
        try {
            String strSubstring = path.substring(iM14130D - 1, iM14130D);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            j = Long.parseLong(strSubstring) + 1;
            iM14130D--;
        } catch (Exception e) {
            AbstractC12991c.m14005z("getTempFile last index is not number: ", e.getMessage(), TAG);
            j = 0;
        }
        do {
            String strSubstring2 = path.substring(0, iM14130D);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            file = new File(strSubstring2 + j + AudioFormat.ExtType.EXT_M4A);
            j++;
        } while (file.exists());
        return file;
    }

    @NotNull
    public final Job editSTTVoiceData(@NotNull String documentPath, @NotNull SpenVoiceData updateItem, @NotNull ArrayList<TextData> textDataList, @NotNull Map<Integer, String> speakerNameMap, @NotNull int[] speakerIDs, @NotNull long[] startTimes, @NotNull long[] endTimes, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(documentPath, "documentPath");
        Intrinsics.checkNotNullParameter(updateItem, "updateItem");
        Intrinsics.checkNotNullParameter(textDataList, "textDataList");
        Intrinsics.checkNotNullParameter(speakerNameMap, "speakerNameMap");
        Intrinsics.checkNotNullParameter(speakerIDs, "speakerIDs");
        Intrinsics.checkNotNullParameter(startTimes, "startTimes");
        Intrinsics.checkNotNullParameter(endTimes, "endTimes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), null, new C115171(documentPath, updateItem, textDataList, this, speakerNameMap, speakerIDs, startTimes, endTimes, callback, null), 2, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.job.plus(Dispatchers.getIO());
    }

    @NotNull
    public final CompletableJob getJob() {
        return this.job;
    }

    @NotNull
    public final Job removeSTTVoiceData(@NotNull String documentPath, @NotNull SpenVoiceData updateItem, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(documentPath, "documentPath");
        Intrinsics.checkNotNullParameter(updateItem, "updateItem");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), null, new C115181(documentPath, updateItem, this, callback, null), 2, null);
    }

    @NotNull
    public final Job saveDataToSpenVoice(@NotNull String documentPath, @NotNull SpenVoiceData updateItem, @NotNull String[] voiceText, @NotNull int[] timingInfo, @Nullable List<? extends SpeechInfo> speechInfoList, @NotNull Map<Integer, String> speakerNameMap, @NotNull Callback callBack) {
        Intrinsics.checkNotNullParameter(documentPath, "documentPath");
        Intrinsics.checkNotNullParameter(updateItem, "updateItem");
        Intrinsics.checkNotNullParameter(voiceText, "voiceText");
        Intrinsics.checkNotNullParameter(timingInfo, "timingInfo");
        Intrinsics.checkNotNullParameter(speakerNameMap, "speakerNameMap");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), null, new C115191(documentPath, updateItem, voiceText, timingInfo, speechInfoList, this, speakerNameMap, callBack, null), 2, null);
    }

    @NotNull
    public final Job updateSTTData(@NotNull String docPath, @NotNull String uuid, @NotNull STTVoiceDataController dataController, @NotNull SpenVoiceTextDataReaderCache readerCache, @NotNull List<SpenVoiceData> voiceDataList, @NotNull Context context, @NotNull ArrayList<SttContentEntity> sttContentList, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(docPath, "docPath");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(dataController, "dataController");
        Intrinsics.checkNotNullParameter(readerCache, "readerCache");
        Intrinsics.checkNotNullParameter(voiceDataList, "voiceDataList");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sttContentList, "sttContentList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), null, new C115201(docPath, voiceDataList, readerCache, dataController, context, uuid, sttContentList, callback, null), 2, null);
    }

    @NotNull
    public final Job writeSummaryResult(@NotNull String documentPath, @NotNull SpenVoiceData updateItem, int size, @NotNull String[] sectionTitle, @NotNull long[] timeStamp, @NotNull ArrayList<String>[] summaryList, int summaryStyle, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(documentPath, "documentPath");
        Intrinsics.checkNotNullParameter(updateItem, "updateItem");
        Intrinsics.checkNotNullParameter(sectionTitle, "sectionTitle");
        Intrinsics.checkNotNullParameter(timeStamp, "timeStamp");
        Intrinsics.checkNotNullParameter(summaryList, "summaryList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), null, new C115211(documentPath, updateItem, size, sectionTitle, timeStamp, summaryList, summaryStyle, callback, null), 2, null);
    }
}
