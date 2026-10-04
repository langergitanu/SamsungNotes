package com.samsung.android.support.senl.p148nt.stt.base.model;

import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.C9477b;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextDataTask;
import com.samsung.android.support.senl.p148nt.stt.base.model.TextData;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.C4191n;
import p193j4.C12937a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextDataTask;", "", "mSttData", "", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "mCallback", "Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextDataTask$Callback;", "<init>", "(Ljava/util/List;Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextDataTask$Callback;)V", "start", "", "Callback", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiTextDataTask {
    public static final int LIMITED_MAXIMUM_EDIT_PARAGRAPH_LENGTH = 1010;
    public static final int LIMITED_PARAGRAPH_MAXIMUM_LENGTH = 1000;
    public static final int LIMITED_SENTENCE_COUNT = 3;
    public static final long LIMITED_SPEECH_BLANK_INTERVAL = 10000;
    public static final int LIMITED_STRING_LENGTH = 500;

    @NotNull
    private static final String TAG = "AiTextDataTask";

    @NotNull
    private final Callback mCallback;

    @Nullable
    private final List<TextData> mSttData;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String[] SENTENCE_SEPARATORS = {". ", "! ", "? ", "。", "！", "？", "\n"};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007H&J$\u0010\b\u001a\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextDataTask$Callback;", "", "onUpdate", "", "result", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "Lkotlin/collections/ArrayList;", "onResult", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Callback {
        void onResult(@Nullable ArrayList<TextData> result);

        void onUpdate(@Nullable ArrayList<TextData> result);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextDataTask$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SENTENCE_SEPARATORS", "", "getSENTENCE_SEPARATORS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "LIMITED_STRING_LENGTH", "", "LIMITED_PARAGRAPH_MAXIMUM_LENGTH", "LIMITED_SENTENCE_COUNT", "LIMITED_SPEECH_BLANK_INTERVAL", "", "LIMITED_MAXIMUM_EDIT_PARAGRAPH_LENGTH", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String[] getSENTENCE_SEPARATORS() {
            return AiTextDataTask.SENTENCE_SEPARATORS;
        }

        private Companion() {
        }
    }

    public AiTextDataTask(@Nullable List<TextData> list, @NotNull Callback mCallback) {
        Intrinsics.checkNotNullParameter(mCallback, "mCallback");
        this.mSttData = list;
        this.mCallback = mCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$3(AtomicLong atomicLong, AtomicInteger atomicInteger, AtomicLong atomicLong2, AtomicBoolean atomicBoolean, AtomicInteger atomicInteger2, List list, AiTextDataTask aiTextDataTask, TextData textToken) {
        AtomicInteger atomicInteger3;
        Intrinsics.checkNotNullParameter(textToken, "textToken");
        String text = textToken.getText();
        long startTime = textToken.getStartTime();
        atomicLong.compareAndSet(Long.MIN_VALUE, startTime);
        boolean z = atomicInteger.updateAndGet(new C9477b(textToken, 1)) != textToken.getSpeakerId();
        long jAddAndGet = atomicLong2.addAndGet(text.length());
        long j = startTime - atomicLong.get();
        if ((z || ((500 < jAddAndGet && atomicBoolean.get()) || 1000 <= jAddAndGet || 3 <= atomicInteger2.get() || 10000 < j)) && !list.isEmpty()) {
            aiTextDataTask.mCallback.onUpdate(new ArrayList<>(list));
            list.clear();
            atomicLong2.set(0L);
            atomicInteger3 = atomicInteger2;
            atomicInteger3.set(0);
        } else {
            atomicInteger3 = atomicInteger2;
        }
        atomicInteger.set(textToken.getSpeakerId());
        atomicLong.set(textToken.getEndTime());
        atomicBoolean.set(Arrays.stream(SENTENCE_SEPARATORS).anyMatch(new C7233a(new C12937a(text, 1), 6)));
        if (atomicBoolean.get()) {
            atomicInteger3.incrementAndGet();
        }
        list.add(textToken);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int start$lambda$3$lambda$0(TextData textData, int i) {
        return i == Integer.MIN_VALUE ? textData.getSpeakerId() : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean start$lambda$3$lambda$1(String str, String str2) {
        Intrinsics.checkNotNull(str2);
        return StringsKt.m14162r(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean start$lambda$3$lambda$2(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    public final void start() {
        List<TextData> list = this.mSttData;
        if (list == null || list.isEmpty()) {
            Logger.m12711e(TAG, "mSttData == null || mSttData.size() == 0");
            return;
        }
        Logger.m12713i(TAG, "sttDataList size : " + this.mSttData.size());
        final ArrayList arrayList = new ArrayList();
        final AtomicInteger atomicInteger = new AtomicInteger(Integer.MIN_VALUE);
        final AtomicLong atomicLong = new AtomicLong(Long.MIN_VALUE);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        final AtomicInteger atomicInteger2 = new AtomicInteger(0);
        final AtomicLong atomicLong2 = new AtomicLong(0L);
        this.mSttData.stream().forEachOrdered(new C4191n(new Function1() { // from class: m4.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AiTextDataTask.start$lambda$3(atomicLong, atomicInteger, atomicLong2, atomicBoolean, atomicInteger2, arrayList, this, (TextData) obj);
            }
        }, 22));
        Logger.m12710d(TAG, "Final paragraph size : " + arrayList.size());
        this.mCallback.onResult(new ArrayList<>(arrayList));
    }
}
