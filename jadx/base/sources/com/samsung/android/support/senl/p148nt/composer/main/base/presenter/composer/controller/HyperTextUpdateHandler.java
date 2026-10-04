package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenParsingStateParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.LinkActionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.DocPageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HyperTextUpdateHandler extends Handler implements DocPageInfo.PageIndexObserver {
    private static final boolean DEBUG_LOG = true;
    private static final int MSG_PARSING_HYPERTEXT = 1;
    private static final int MSG_UPDATE_PRIORITY = 2;
    private static final String QUICK_SAVE_TAG = "hyperText";
    private static final int RESTRICTION_MAX = 10000;
    private static final int RESTRICTION_MIN = 2;
    private static final String TAG = Logger.createTag("HyperTextUpdateHandler");
    private static final boolean USING_THREAD_FLAG = true;
    private final CalculatorParser mCalculatorParser;
    private final Comparator<SpenTextParagraphBase> mComparator;
    private ComposerModel mComposerModel;
    private Context mContext;
    private ExecutorService mExecutorService;
    private final ConcurrentLinkedQueue<SpenTextParagraphBase> mHighPriorityParagraphQueue;
    private boolean mIsStopped;
    private int mPageCount;
    private int[][] mParagraphIndex;
    private String[] mParagraphs;
    private Runnable mParsingRunnable;
    private ArrayList<SpenTextParagraphBase> mParsingStateParagraphList;
    private QuickSaveTimerController mQuickSaveTimerController;
    private SpenObjectTextBox mTextBox;
    private TextManager mTextManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CalculatorParser {
        ExecutorService mExecutor;
        private Future<ArrayList<SpenHyperTextSpan>> mExecutorFuture = null;
        private ArrayList<String> mExcludedTexts = null;

        private boolean canRegExFindHypertext(String str) {
            if (this.mExcludedTexts == null) {
                return true;
            }
            return !r0.contains(str);
        }

        private void shutdownAndAwaitTermination(ExecutorService executorService) {
            if (executorService == null) {
                return;
            }
            executorService.shutdown();
            try {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                if (executorService.awaitTermination(1L, timeUnit)) {
                    return;
                }
                executorService.shutdownNow();
                if (executorService.awaitTermination(1L, timeUnit)) {
                    return;
                }
                Logger.m10999d(HyperTextUpdateHandler.TAG, "shutdownAndAwaitTermination, pool did not terminate.");
                this.mExecutor = null;
            } catch (InterruptedException unused) {
                Logger.m10999d(HyperTextUpdateHandler.TAG, "shutdownAndAwaitTermination, cancel if current thread also interrupted");
                executorService.shutdownNow();
            }
        }

        public void handleException(String str) {
            Future<ArrayList<SpenHyperTextSpan>> future = this.mExecutorFuture;
            if (future != null) {
                future.cancel(true);
            }
            shutdownAndAwaitTermination(this.mExecutor);
            if (this.mExcludedTexts == null) {
                this.mExcludedTexts = new ArrayList<>();
            }
            this.mExcludedTexts.add(str);
        }

        public ArrayList<SpenHyperTextSpan> parse(final Context context, final String str, final int i, final ArrayList<SpenHyperTextSpan> arrayList) {
            if (!canRegExFindHypertext(str)) {
                return arrayList;
            }
            ExecutorService executorService = this.mExecutor;
            if (executorService == null || executorService.isTerminated()) {
                this.mExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(HyperTextUpdateHandler.TAG));
            }
            Future<ArrayList<SpenHyperTextSpan>> futureSubmit = this.mExecutor.submit(new Callable<ArrayList<SpenHyperTextSpan>>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.HyperTextUpdateHandler.CalculatorParser.1
                @Override // java.util.concurrent.Callable
                public ArrayList<SpenHyperTextSpan> call() {
                    try {
                        return LinkActionHelper.parseHyperTextForCalculator(context, arrayList, str, i);
                    } catch (Throwable th) {
                        Logger.m11001e(HyperTextUpdateHandler.TAG, "findHyperText Throwable, " + th, th);
                        return arrayList;
                    }
                }
            });
            this.mExecutorFuture = futureSubmit;
            return futureSubmit.get(1000L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WorkingData {
        SpenParsingStateParagraph mParsingState;
        private boolean mPrevIsChanged;
        ArrayList<SpenHyperTextSpan> mSpanList;

        public WorkingData(SpenParsingStateParagraph spenParsingStateParagraph, ArrayList<SpenHyperTextSpan> arrayList, boolean z) {
            this.mParsingState = spenParsingStateParagraph;
            this.mSpanList = arrayList;
            this.mPrevIsChanged = z;
        }
    }

    public HyperTextUpdateHandler(@NonNull Looper looper) {
        super(looper);
        this.mComparator = new Comparator<SpenTextParagraphBase>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.HyperTextUpdateHandler.1
            @Override // java.util.Comparator
            public int compare(SpenTextParagraphBase spenTextParagraphBase, SpenTextParagraphBase spenTextParagraphBase2) {
                return spenTextParagraphBase.getStart() - spenTextParagraphBase2.getStart();
            }
        };
        this.mHighPriorityParagraphQueue = new ConcurrentLinkedQueue<>();
        this.mExecutorService = null;
        this.mCalculatorParser = new CalculatorParser();
        this.mIsStopped = false;
        this.mParsingRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHighPriorityParagraphQueue(int i) {
        AbstractC0000a.m3D(i, "addHighPriorityParagraphQueue# ", TAG);
        TextManager textManager = this.mTextManager;
        SpenObjectTextBox spenObjectTextBox = this.mTextBox;
        int[] paragraphIndex = textManager.getParagraphIndex(spenObjectTextBox, new int[]{spenObjectTextBox.getTextSectionStart(i), this.mTextBox.getTextSectionLength(i)});
        Iterator<SpenTextParagraphBase> it = this.mParsingStateParagraphList.iterator();
        while (it.hasNext()) {
            SpenParsingStateParagraph spenParsingStateParagraph = (SpenParsingStateParagraph) it.next();
            if (!spenParsingStateParagraph.getIsParsed() || spenParsingStateParagraph.getStart() < paragraphIndex[0] || spenParsingStateParagraph.getStart() >= paragraphIndex[1]) {
                this.mHighPriorityParagraphQueue.add(spenParsingStateParagraph);
            }
        }
    }

    private void appendTextSpan(SpenObjectTextBox spenObjectTextBox, ArrayList<SpenHyperTextSpan> arrayList) {
        if (arrayList != null) {
            Logger.m10999d(TAG, "setHyperTextSpan# " + arrayList.size());
            Iterator<SpenHyperTextSpan> it = arrayList.iterator();
            while (it.hasNext()) {
                spenObjectTextBox.appendTextSpan(it.next());
            }
        }
    }

    private void doneParsingState(SpenParsingStateParagraph spenParsingStateParagraph) {
        spenParsingStateParagraph.setParsingState(true);
        this.mTextBox.appendTextParagraph(spenParsingStateParagraph);
    }

    private ArrayList<SpenHyperTextSpan> findHyperText(Context context, String str, int i) {
        ArrayList<SpenHyperTextSpan> hyperText = LinkActionHelper.parseHyperText(context, str, i, false);
        Logger.midTime(String.valueOf(hashCode()), TAG, "excluded calculator");
        return this.mCalculatorParser.parse(context, str, i, hyperText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<SpenHyperTextSpan> getHyperTextSpans(Context context, String str, int i) {
        try {
            try {
                Logger.startTime(String.valueOf(hashCode()));
                return findHyperText(context, str, i);
            } catch (Exception e) {
                String str2 = TAG;
                Logger.m11000e(str2, "setHyperTextSpan# " + e);
                if (!this.mIsStopped) {
                    this.mCalculatorParser.handleException(str);
                }
                Logger.endTime(String.valueOf(hashCode()), str2, "findHyperText");
                return null;
            }
        } finally {
            Logger.endTime(String.valueOf(hashCode()), TAG, "findHyperText");
        }
    }

    private void getHyperTextSpansOnThread(final SpenParsingStateParagraph spenParsingStateParagraph, final boolean z) {
        ExecutorService executorService = this.mExecutorService;
        if (executorService == null || executorService.isTerminated()) {
            this.mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        }
        this.mExecutorService.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.HyperTextUpdateHandler.3
            @Override // java.lang.Runnable
            public void run() {
                if (HyperTextUpdateHandler.this.mIsStopped) {
                    Logger.m10999d(HyperTextUpdateHandler.TAG, "getHyperTextSpansOnThread# stopped before");
                    return;
                }
                HyperTextUpdateHandler hyperTextUpdateHandler = HyperTextUpdateHandler.this;
                ArrayList hyperTextSpans = hyperTextUpdateHandler.getHyperTextSpans(hyperTextUpdateHandler.mContext, HyperTextUpdateHandler.this.mParagraphs[spenParsingStateParagraph.getStart()], HyperTextUpdateHandler.this.mParagraphIndex[spenParsingStateParagraph.getStart()][0]);
                if (HyperTextUpdateHandler.this.mIsStopped) {
                    Logger.m10999d(HyperTextUpdateHandler.TAG, "getHyperTextSpansOnThread# stopped after");
                    return;
                }
                WorkingData workingData = new WorkingData(spenParsingStateParagraph, hyperTextSpans, z);
                HyperTextUpdateHandler hyperTextUpdateHandler2 = HyperTextUpdateHandler.this;
                hyperTextUpdateHandler2.sendMessage(hyperTextUpdateHandler2.obtainMessage(1, workingData));
            }
        });
    }

    private boolean isInvalidLength(int i) {
        return i < 2 || i >= 10000;
    }

    private void lockQuickSaveTimer() {
        this.mQuickSaveTimerController.lock(QUICK_SAVE_TAG);
    }

    private void parseHyperText() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SpenParsingStateParagraph spenParsingStateParagraph = this.mHighPriorityParagraphQueue.isEmpty() ? (SpenParsingStateParagraph) this.mParsingStateParagraphList.get(0) : (SpenParsingStateParagraph) this.mHighPriorityParagraphQueue.poll();
        boolean zIsChanged = this.mTextBox.isChanged();
        String str = TAG;
        Logger.m10999d(str, "MSG_PARSING_HYPERTEXT#parseHyperText start#" + spenParsingStateParagraph.getStart());
        int start = spenParsingStateParagraph.getStart();
        String[] strArr = this.mParagraphs;
        if (start < strArr.length) {
            int length = strArr[spenParsingStateParagraph.getStart()].length();
            AbstractC0000a.m3D(length, "MSG_PARSING_HYPERTEXT# len: ", str);
            if (isInvalidLength(length)) {
                doneParsingState(spenParsingStateParagraph);
            } else if (!spenParsingStateParagraph.getIsParsed()) {
                if (length > 1000) {
                    getHyperTextSpansOnThread(spenParsingStateParagraph, zIsChanged);
                    Logger.m10999d(str, "MSG_PARSING_HYPERTEXT# run thread " + spenParsingStateParagraph.getStart());
                    return;
                }
                appendTextSpan(this.mTextBox, getHyperTextSpans(this.mContext, this.mParagraphs[spenParsingStateParagraph.getStart()], this.mParagraphIndex[spenParsingStateParagraph.getStart()][0]));
                doneParsingState(spenParsingStateParagraph);
            }
        } else {
            doneParsingState(spenParsingStateParagraph);
        }
        updateState(spenParsingStateParagraph, zIsChanged);
        Logger.m10999d(str, "MSG_PARSING_HYPERTEXT#MSG_PARSING_HYPERTEXT end#" + spenParsingStateParagraph.getStart() + " time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private void unlockQuickSaveTimer() {
        this.mQuickSaveTimerController.unLock(QUICK_SAVE_TAG);
    }

    private void updateState(SpenParsingStateParagraph spenParsingStateParagraph, boolean z) {
        if (!z) {
            this.mTextBox.clearChangedFlag();
            this.mComposerModel.getComposerSaveModel().setHyperLinkChanged(true);
        }
        this.mParsingStateParagraphList.remove(spenParsingStateParagraph);
        if (!this.mHighPriorityParagraphQueue.isEmpty()) {
            this.mHighPriorityParagraphQueue.remove(spenParsingStateParagraph);
        }
        if (!this.mParsingStateParagraphList.isEmpty()) {
            sendMessage(obtainMessage(1));
        } else {
            this.mIsStopped = true;
            unlockQuickSaveTimer();
        }
    }

    private void updateWorkingData(WorkingData workingData) {
        String str = TAG;
        Logger.m10999d(str, "MSG_PARSING_HYPERTEXT#updateWorkingData start#" + workingData.mParsingState.getStart());
        if (this.mTextBox.isChanged() != workingData.mPrevIsChanged) {
            Logger.m11000e(str, "handleMessage# isChanged flag is invalid");
            workingData.mPrevIsChanged = this.mTextBox.isChanged();
        }
        appendTextSpan(this.mTextBox, workingData.mSpanList);
        doneParsingState(workingData.mParsingState);
        updateState(workingData.mParsingState, workingData.mPrevIsChanged);
        Logger.m10999d(str, "MSG_PARSING_HYPERTEXT#updateWorkingData end#" + workingData.mParsingState.getStart());
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        if (this.mIsStopped) {
            Logger.m10999d(TAG, "handleMessage# stop");
            return;
        }
        if (this.mContext == null) {
            Logger.m10999d(TAG, "handleMessage# context is null");
            sendMessageDelayed(obtainMessage(1), 2000L);
            return;
        }
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null || !composerModel.getComposerSaveModel().isIdleWorkingState()) {
            Logger.m10999d(TAG, "handleMessage# isIdleWorkingState is false");
            sendMessageDelayed(obtainMessage(1), 500L);
            return;
        }
        int i = message.what;
        if (i == 1) {
            Object obj = message.obj;
            if (obj instanceof WorkingData) {
                updateWorkingData((WorkingData) obj);
                return;
            } else {
                parseHyperText();
                return;
            }
        }
        if (i != 2) {
            return;
        }
        Logger.m10999d(TAG, "handleMessage# MSG_UPDATE_PRIORITY");
        this.mHighPriorityParagraphQueue.clear();
        int i2 = message.arg1;
        addHighPriorityParagraphQueue(i2);
        if (i2 > 0) {
            addHighPriorityParagraphQueue(i2 - 1);
        }
        if (i2 < this.mPageCount - 2) {
            addHighPriorityParagraphQueue(i2 + 1);
        }
    }

    public void init(Context context, TextManager textManager, SpenWNote spenWNote, ComposerModel composerModel, QuickSaveTimerController quickSaveTimerController) {
        this.mContext = context;
        this.mTextManager = textManager;
        this.mTextBox = spenWNote.getBodyText();
        this.mPageCount = spenWNote.getPageCount();
        this.mComposerModel = composerModel;
        this.mQuickSaveTimerController = quickSaveTimerController;
    }

    public void onDetachView() {
        this.mContext = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.DocPageInfo.PageIndexObserver
    public void onPageIndexChanged(int i) {
        updatePriority(i);
    }

    public void parseTextBox(final int i) {
        if (this.mParsingStateParagraphList != null) {
            return;
        }
        ArrayList<SpenTextParagraphBase> unparsedParagraphs = this.mTextBox.getUnparsedParagraphs();
        this.mParsingStateParagraphList = unparsedParagraphs;
        if (unparsedParagraphs == null || unparsedParagraphs.isEmpty()) {
            Logger.m10999d(TAG, "parseTextBox# Don't need to parse");
            return;
        }
        lockQuickSaveTimer();
        String str = TAG;
        Logger.m10999d(str, "parseTextBox# unparsed count " + this.mParsingStateParagraphList.size());
        this.mParsingRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.HyperTextUpdateHandler.2
            private void finish(boolean z) {
                HyperTextUpdateHandler.this.mParsingRunnable = null;
                if (z) {
                    HyperTextUpdateHandler.this.stop();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(HyperTextUpdateHandler.TAG, "parseTextBox# start");
                Collections.sort(HyperTextUpdateHandler.this.mParsingStateParagraphList, HyperTextUpdateHandler.this.mComparator);
                String text = HyperTextUpdateHandler.this.mTextBox.getText();
                if (TextUtils.isEmpty(text)) {
                    AbstractC8014b.m7196B("parseTextBox# ", text, HyperTextUpdateHandler.TAG);
                    finish(true);
                    return;
                }
                if (HyperTextUpdateHandler.this.mIsStopped) {
                    finish(true);
                    return;
                }
                HyperTextUpdateHandler.this.mParagraphs = text.split(CharUtils.SDOCX_CRLF_REGEX);
                if (HyperTextUpdateHandler.this.mParagraphs.length == 0) {
                    finish(true);
                    return;
                }
                HyperTextUpdateHandler hyperTextUpdateHandler = HyperTextUpdateHandler.this;
                hyperTextUpdateHandler.mParagraphIndex = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, hyperTextUpdateHandler.mParagraphs.length, 2);
                HyperTextUpdateHandler.this.mParagraphIndex[0][0] = 0;
                HyperTextUpdateHandler.this.mParagraphIndex[0][1] = HyperTextUpdateHandler.this.mParagraphs[0].length();
                for (int i2 = 1; i2 < HyperTextUpdateHandler.this.mParagraphs.length; i2++) {
                    HyperTextUpdateHandler.this.mParagraphIndex[i2][0] = HyperTextUpdateHandler.this.mParagraphIndex[i2 - 1][1] + 1;
                    HyperTextUpdateHandler.this.mParagraphIndex[i2][1] = HyperTextUpdateHandler.this.mParagraphs[i2].length() + HyperTextUpdateHandler.this.mParagraphIndex[i2][0];
                }
                if (HyperTextUpdateHandler.this.mIsStopped) {
                    finish(true);
                    return;
                }
                ISpenNoteTextManager spenNoteTextManager = HyperTextUpdateHandler.this.mTextManager.getSpenNoteTextManager();
                spenNoteTextManager.lockBodyTextPage();
                spenNoteTextManager.unlockBodyTextPage();
                HyperTextUpdateHandler.this.addHighPriorityParagraphQueue(i);
                HyperTextUpdateHandler.this.sendMessage(HyperTextUpdateHandler.this.obtainMessage(1));
                finish(false);
                Logger.m10999d(HyperTextUpdateHandler.TAG, "parseTextBox# end");
            }
        };
        ExecutorService executorServiceM3201k = AbstractC4539a.m3201k(str);
        this.mExecutorService = executorServiceM3201k;
        executorServiceM3201k.execute(this.mParsingRunnable);
    }

    public void stop() {
        String str = TAG;
        Logger.m10999d(str, "stop# call");
        this.mIsStopped = true;
        unlockQuickSaveTimer();
        if (this.mParsingRunnable != null) {
            Logger.m10999d(str, "stop# thread is running");
            return;
        }
        ArrayList<SpenTextParagraphBase> arrayList = this.mParsingStateParagraphList;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.mHighPriorityParagraphQueue.clear();
    }

    public void updatePriority(int i) {
        ArrayList<SpenTextParagraphBase> arrayList;
        if (this.mIsStopped || (arrayList = this.mParsingStateParagraphList) == null || arrayList.isEmpty()) {
            return;
        }
        Logger.m10999d(TAG, "updatePriority# " + i);
        removeMessages(2);
        sendMessage(obtainMessage(2, i, 0));
    }
}
