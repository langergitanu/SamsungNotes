package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize;

import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.stt.base.model.TextData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ParagraphSttTask implements Callable<Void> {
    public static final int LIMITED_PARAGRAPH_MAXIMUM_LENGTH = 1000;
    public static final int LIMITED_SENTENCE_COUNT = 3;
    public static final long LIMITED_SPEECH_BLANK_INTERVAL = 10000;
    public static final int LIMITED_STRING_LENGTH = 500;
    public static final String[] SENTENCE_SEPARATORS = {". ", "! ", "? ", "。", "！", "？", "\n"};
    private static final String TAG = "AI#ParagraphSttTask";
    private final Callback mCallback;
    private final List<TextData> mSttData;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onResult(ArrayList<TextData> arrayList);

        void onUpdate(ArrayList<TextData> arrayList);
    }

    public ParagraphSttTask(List<TextData> list, Callback callback) {
        this.mSttData = list;
        this.mCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$call$0(TextData textData, int i) {
        return i == Integer.MIN_VALUE ? textData.getSpeakerId() : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$call$1(AtomicLong atomicLong, AtomicInteger atomicInteger, AtomicLong atomicLong2, AtomicBoolean atomicBoolean, AtomicInteger atomicInteger2, List list, TextData textData) {
        AtomicInteger atomicInteger3;
        String text = textData.getText();
        long startTime = textData.getStartTime();
        atomicLong.compareAndSet(Long.MIN_VALUE, startTime);
        boolean z = atomicInteger.updateAndGet(new C9477b(textData, 0)) != textData.getSpeakerId();
        long jAddAndGet = atomicLong2.addAndGet(text.length());
        long j = startTime - atomicLong.get();
        if ((z || ((500 < jAddAndGet && atomicBoolean.get()) || 1000 <= jAddAndGet || 3 <= atomicInteger2.get() || 10000 < j)) && !list.isEmpty()) {
            this.mCallback.onUpdate(new ArrayList<>(list));
            list.clear();
            atomicLong2.set(0L);
            atomicInteger3 = atomicInteger2;
            atomicInteger3.set(0);
        } else {
            atomicInteger3 = atomicInteger2;
        }
        atomicInteger.set(textData.getSpeakerId());
        atomicLong.set(textData.getEndTime());
        atomicBoolean.set(Arrays.stream(SENTENCE_SEPARATORS).anyMatch(new C9478c(text, 0)));
        if (atomicBoolean.get()) {
            atomicInteger3.incrementAndGet();
        }
        list.add(textData);
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        List<TextData> list = this.mSttData;
        if (list == null || list.isEmpty()) {
            Logger.m11000e(TAG, "mSttData == null || mSttData.size() == 0");
            return null;
        }
        Logger.m11003i(TAG, "sttDataList size : " + this.mSttData.size());
        final ArrayList arrayList = new ArrayList();
        final AtomicInteger atomicInteger = new AtomicInteger(Integer.MIN_VALUE);
        final AtomicLong atomicLong = new AtomicLong(Long.MIN_VALUE);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        final AtomicInteger atomicInteger2 = new AtomicInteger(0);
        final AtomicLong atomicLong2 = new AtomicLong(0L);
        this.mSttData.forEach(new Consumer() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.stt.summarize.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f6898a.lambda$call$1(atomicLong, atomicInteger, atomicLong2, atomicBoolean, atomicInteger2, arrayList, (TextData) obj);
            }
        });
        Logger.m10999d(TAG, "Final paragraph size : " + arrayList.size());
        this.mCallback.onResult(new ArrayList<>(arrayList));
        return null;
    }
}
