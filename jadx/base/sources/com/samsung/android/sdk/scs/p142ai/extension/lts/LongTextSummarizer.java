package com.samsung.android.sdk.scs.p142ai.extension.lts;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.AiServices;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import com.samsung.android.sdk.scs.p142ai.language.SummarizeLevel;
import com.samsung.android.sdk.scs.p142ai.language.SummarizeSubTask;
import com.samsung.android.sdk.scs.p142ai.language.Summarizer;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p001A.AbstractC0000a;
import p066P2.RunnableC0201c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class LongTextSummarizer implements ILongTextSummarizer {
    private static final int SEPARATE_N = 4;
    private final int[] DEPTH_LEVEL;
    private final String TAG;
    private final AppInfo.Builder appinfoBuilder;
    private OnCompleteListener<LtsResult> clientCallback;
    CompressionSummary compressionSummary;
    Context context;
    private int depthLevel;
    private boolean isCanceled;
    AtomicBoolean isProcessing;
    private Iterator<String> iterator;
    LtsResult ltsResult;
    private int mMaxTokenCount;
    private final Summarizer mSummarizer;
    Boolean needToaddContent;
    AtomicBoolean run;
    List<String> separatedTextList;
    Thread thread;

    public LongTextSummarizer(@NonNull Context context, @NonNull Summarizer summarizer) {
        this.TAG = "LongTextSummarizer";
        this.isProcessing = new AtomicBoolean(false);
        this.run = new AtomicBoolean(false);
        this.DEPTH_LEVEL = new int[]{1, 2, 3};
        this.depthLevel = 1;
        this.needToaddContent = Boolean.FALSE;
        this.appinfoBuilder = new AppInfo.Builder();
        this.mMaxTokenCount = 1024;
        this.isCanceled = false;
        this.mSummarizer = summarizer;
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: callback, reason: merged with bridge method [inline-methods] */
    public void lambda$summarize$4(Task<Result> task, CompletableFuture<Integer> completableFuture) {
        int i;
        int i2;
        if (!this.isProcessing.get()) {
            Log.d("LongTextSummarizer", "processing is stopped. do not call callback method.");
            return;
        }
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception != null) {
                handleCallback(new LtsResult(getErrorMessage(exception), false), true);
                Log.e("LongTextSummarizer", "failed: " + exception.getMessage());
            } else {
                handleCallback(new LtsResult("Unknown error occurred.", false), true);
                Log.e("LongTextSummarizer", "failed: Unknown error occurred.");
            }
            completableFuture.complete(-1);
            return;
        }
        String content = task.getResult().getContent();
        int iAddSentence = this.compressionSummary.addSentence(content);
        if (!this.needToaddContent.booleanValue()) {
            int i4 = this.depthLevel;
            if (i4 == 0 || i4 == 1) {
                if (this.compressionSummary.getDividedNQueue().element().size() <= 1 && this.compressionSummary.getDividedNQueue().element().element().intValue() == 1) {
                    this.needToaddContent = Boolean.TRUE;
                }
            } else if (i4 != 2) {
                if (this.compressionSummary.getDividedNQueue().element().size() <= 4) {
                    this.needToaddContent = Boolean.TRUE;
                }
            } else if (this.compressionSummary.getDividedNQueue().element().size() <= 1) {
                this.needToaddContent = Boolean.TRUE;
            }
        }
        if (this.needToaddContent.booleanValue()) {
            this.ltsResult.setContent(content);
        }
        this.ltsResult.increaseRepeatCount();
        handleCallback(this.ltsResult, false);
        if (!this.iterator.hasNext()) {
            int i5 = this.depthLevel;
            int[] iArr = this.DEPTH_LEVEL;
            int i6 = iArr[0];
            if ((i5 == i6 && iAddSentence == i6) || ((i5 == (i = iArr[1]) && iAddSentence <= i) || (i5 == (i2 = iArr[2]) && iAddSentence <= i2))) {
                completableFuture.complete(0);
                AbstractC11014a.m12338w(new StringBuilder("summary : "), this.compressionSummary.getSummary(), "LongTextSummarizer");
                handleCallback(null, false);
                return;
            }
            this.iterator = this.compressionSummary.getChunkedSummarySentenceList().iterator();
        }
        completableFuture.complete(1);
    }

    private static String getErrorMessage(Exception exc) {
        return (exc == null || exc.getMessage() == null) ? "unknown error" : exc.getMessage();
    }

    private void handleCallback(LtsResult ltsResult, boolean z) {
        if (z) {
            if (this.isCanceled) {
                this.isCanceled = false;
                ltsResult.setContent("Client Error Cancel");
            }
            this.clientCallback.onError(ltsResult);
            this.isProcessing.set(false);
            return;
        }
        if (ltsResult != null) {
            this.clientCallback.onNext(ltsResult);
        } else {
            this.clientCallback.onComplete();
            this.isProcessing.set(false);
        }
    }

    private void initialize(@NonNull Context context, String str) {
        this.context = context;
        this.separatedTextList = new ArrayList();
        this.compressionSummary = new CompressionSummary(4);
        TextManager.getChunkSenteneList(str, this.separatedTextList);
        this.iterator = this.separatedTextList.iterator();
        this.compressionSummary.divideAndCeil(this.separatedTextList.size());
        if (this.depthLevel > this.compressionSummary.getDividedCount().size()) {
            this.depthLevel = this.compressionSummary.getDividedCount().size();
        }
        this.compressionSummary.balanceGroup();
        int iIntValue = 0;
        for (int i = 0; i < this.compressionSummary.getDividedCount().size() - this.depthLevel; i++) {
            iIntValue += this.compressionSummary.getDividedCount().get(i).intValue();
        }
        this.ltsResult = new LtsResult(iIntValue, "", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$process$2(String str, AtomicReference atomicReference) {
        long j;
        CompletableFuture completableFuture = new CompletableFuture();
        AppInfo appInfoBuild = new AppInfo.Builder().setRequestType(AppInfo.RequestType.ONDEVICE).build();
        this.mSummarizer.getTokenCount(appInfoBuild, str, SummarizeLevel.BRIEFLY, SummarizeSubTask.ARTICLE, new HashMap()).addOnCompleteListener(new C7731b(this, completableFuture, 0));
        boolean z = true;
        try {
            AtomicReference atomicReference2 = atomicReference;
            atomicReference2.set((Integer) completableFuture.get(120L, TimeUnit.SECONDS));
            if (((Integer) atomicReference2.get()).intValue() > 4096) {
                this.ltsResult.setContent("Token Max Exceeded Error");
                this.ltsResult.setTokenCount(((Integer) atomicReference2.get()).intValue());
                handleCallback(this.ltsResult, true);
                return;
            }
            if (((Integer) atomicReference2.get()).intValue() <= 0) {
                handleCallback(new LtsResult("Token Calculation Error", false), true);
                return;
            }
            if (((Integer) atomicReference2.get()).intValue() > 0) {
                int iCeil = (int) Math.ceil(((double) (((Integer) atomicReference2.get()).intValue() - 100)) / ((double) (this.mMaxTokenCount - 100)));
                int i = 3;
                boolean z2 = true;
                while (true) {
                    int i2 = i - 1;
                    if (i == 0 || !z2) {
                        break;
                    }
                    double d = iCeil;
                    int iCeil2 = (int) Math.ceil(((double) str.length()) / d);
                    int iCeil3 = (int) Math.ceil(((double) ((Integer) atomicReference2.get()).intValue()) / d);
                    StringBuilder sb = new StringBuilder("text size :");
                    sb.append(str.length());
                    sb.append(" needToSeparatedCount ");
                    sb.append(iCeil);
                    sb.append(" before maxSeparatedTextSize : ");
                    AbstractC0000a.m26w(sb, "LongTextSummarizer", iCeil2);
                    int i4 = this.mMaxTokenCount;
                    int i5 = i4 - iCeil3;
                    boolean z3 = z;
                    double d2 = ((double) i5) / ((double) i4);
                    int i6 = (int) ((((double) iCeil2) * d2) / (1.0d - d2));
                    StringBuilder sbM1173s = AbstractC0622a.m1173s(iCeil3, i5, "estimatedAverageTokenCount : ", " marginTokenCount : ", " marginTokenRate : ");
                    sbM1173s.append(d2);
                    sbM1173s.append(" marginTextLength : ");
                    sbM1173s.append(i6);
                    Log.i("LongTextSummarizer", sbM1173s.toString());
                    iCeil++;
                    this.separatedTextList = new ArrayList();
                    this.compressionSummary = new CompressionSummary(4);
                    TextManager.getChunkSenteneList(str, this.separatedTextList, iCeil2, i6);
                    for (String str2 : this.separatedTextList) {
                        CompletableFuture completableFuture2 = new CompletableFuture();
                        this.mSummarizer.getTokenCount(appInfoBuild, str2, SummarizeLevel.BRIEFLY, SummarizeSubTask.ARTICLE, new HashMap()).addOnCompleteListener(new C7731b(this, completableFuture2, 1));
                        try {
                            j = 120;
                            Integer num = (Integer) completableFuture2.get(120L, TimeUnit.SECONDS);
                            if (this.mMaxTokenCount < num.intValue() || num.intValue() <= 0) {
                                z2 = z3;
                                break;
                            }
                        } catch (Exception e) {
                            handleCallback(new LtsResult("Token Calculation Error", false), z3);
                            Log.e("LongTextSummarizer", "Summarize Exception : " + e.getMessage());
                            return;
                        }
                    }
                    j = 120;
                    z2 = false;
                    atomicReference2 = atomicReference;
                    i = i2;
                    z = true;
                }
                if (z2) {
                    return;
                }
                this.compressionSummary.divideAndCeil(this.separatedTextList.size());
                if (this.depthLevel > this.compressionSummary.getDividedCount().size()) {
                    this.depthLevel = this.compressionSummary.getDividedCount().size();
                }
                this.compressionSummary.balanceGroup();
                int iIntValue = 0;
                for (int i7 = 0; i7 < this.compressionSummary.getDividedCount().size() - this.depthLevel; i7++) {
                    iIntValue += this.compressionSummary.getDividedCount().get(i7).intValue();
                }
                LtsResult ltsResult = new LtsResult(iIntValue, "", true);
                this.ltsResult = ltsResult;
                ltsResult.setTokenCount(((Integer) atomicReference.get()).intValue());
                this.iterator = this.separatedTextList.iterator();
                process();
            }
        } catch (Exception e2) {
            handleCallback(new LtsResult("Token Calculation Error", false), true);
            Log.e("LongTextSummarizer", "Summarize Exception : " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$request$3() {
        while (this.run.get() && this.iterator.hasNext()) {
            summarize();
        }
        this.isProcessing.set(false);
        this.run.set(false);
    }

    private Boolean postProcess() {
        if (this.isProcessing.compareAndSet(false, true) && this.depthLevel != this.DEPTH_LEVEL[0]) {
            this.iterator = this.compressionSummary.getChunkedSummarySentenceList().iterator();
            this.depthLevel = this.DEPTH_LEVEL[0];
            request();
            return Boolean.TRUE;
        }
        Log.e("LongTextSummarizer", "isProcessing : " + this.isProcessing.get() + " depthLevel : " + this.depthLevel);
        return Boolean.FALSE;
    }

    private void release() {
        Log.i("LongTextSummarizer", "release");
        this.isProcessing.set(false);
        this.run.set(false);
        Thread thread = this.thread;
        if (thread == null || !thread.isAlive()) {
            return;
        }
        this.thread.interrupt();
    }

    private void request() {
        this.thread = new Thread(new RunnableC7599e(this, 4));
        this.run.set(true);
        this.thread.start();
    }

    private Boolean summarize() {
        Log.i("LongTextSummarizer", "summarize");
        AppInfo appInfoBuild = this.appinfoBuilder.setStreamingMode(true).setRequestType(AppInfo.RequestType.ONDEVICE).build();
        CompletableFuture completableFuture = new CompletableFuture();
        this.mSummarizer.summarize(appInfoBuild, this.iterator.next(), SummarizeLevel.BRIEFLY, SummarizeSubTask.ARTICLE, new HashMap()).addOnCompleteListener(new C7731b(this, completableFuture, 2));
        try {
            completableFuture.get(120L, TimeUnit.SECONDS);
        } catch (Exception e) {
            handleCallback(new LtsResult(getErrorMessage(e), false), true);
            Log.e("LongTextSummarizer", "Summarize Exception : " + e.getMessage());
            release();
        }
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: tokenCallback, reason: merged with bridge method [inline-methods] */
    public void lambda$process$0(Task<Result> task, CompletableFuture<Integer> completableFuture) {
        if (!task.isSuccessful() || task.getResult() == null) {
            completableFuture.complete(-1);
            Exception exception = task.getException();
            LtsResult ltsResult = new LtsResult(getErrorMessage(exception), false);
            ltsResult.setTask(task);
            handleCallback(ltsResult, true);
            Log.e("LongTextSummarizer", "failed: " + exception.getMessage());
            return;
        }
        String content = task.getResult().getContent();
        Log.d("LongTextSummarizer", "content: " + content);
        Map<String, String> token = TokenParser.getToken(content);
        try {
            int i = Integer.parseInt(token.get("count"));
            int i2 = Integer.parseInt(token.get("countMax"));
            if (i2 <= 0) {
                i2 = 1024;
            }
            this.mMaxTokenCount = i2;
            Log.i("LongTextSummarizer", "tokenCount : " + i + " maxCount : " + this.mMaxTokenCount);
            completableFuture.complete(Integer.valueOf(i));
        } catch (Exception unused) {
            handleCallback(new LtsResult("Token Calculation Error", false), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: tokenSeparateTextCallback, reason: merged with bridge method [inline-methods] */
    public void lambda$process$1(Task<Result> task, CompletableFuture<Integer> completableFuture) {
        if (!task.isSuccessful() || task.getResult() == null) {
            completableFuture.complete(-1);
            LtsResult ltsResult = new LtsResult(getErrorMessage(task.getException()), false);
            ltsResult.setTask(task);
            handleCallback(ltsResult, true);
            return;
        }
        String content = task.getResult().getContent();
        Log.d("LongTextSummarizer", "content: " + content);
        try {
            int i = Integer.parseInt(TokenParser.getToken(content).get("count"));
            Log.i("LongTextSummarizer", "tokenCount : " + i);
            completableFuture.complete(Integer.valueOf(i));
        } catch (Exception unused) {
            completableFuture.complete(-1);
        }
    }

    @Override // com.samsung.android.sdk.scs.p142ai.extension.lts.ILongTextSummarizer
    public void addOnCompleteListener(@NonNull OnCompleteListener<LtsResult> onCompleteListener) {
        this.clientCallback = onCompleteListener;
    }

    @Override // com.samsung.android.sdk.scs.p142ai.extension.lts.ILongTextSummarizer
    public boolean process(String str) {
        if (!this.isProcessing.compareAndSet(false, true)) {
            Log.e("LongTextSummarizer", "Do not use this object more than once. Please recreate the instance.");
            return false;
        }
        this.isCanceled = false;
        AtomicReference atomicReference = new AtomicReference(0);
        this.ltsResult = new LtsResult(0, "", false);
        this.needToaddContent = Boolean.FALSE;
        new Thread(new RunnableC0201c(this, 18, str, atomicReference)).start();
        return true;
    }

    @Override // com.samsung.android.sdk.scs.p142ai.extension.lts.ILongTextSummarizer
    public void stop() {
        if (this.isProcessing.get()) {
            this.isCanceled = true;
        }
        release();
    }

    private Boolean process() {
        if (!this.iterator.hasNext()) {
            Log.e("LongTextSummarizer", "separatedTextList size :" + this.separatedTextList.size());
            return Boolean.FALSE;
        }
        request();
        return Boolean.TRUE;
    }

    private LongTextSummarizer(@NonNull Context context, @NonNull String str) {
        this.TAG = "LongTextSummarizer";
        this.isProcessing = new AtomicBoolean(false);
        this.run = new AtomicBoolean(false);
        this.DEPTH_LEVEL = new int[]{1, 2, 3};
        this.depthLevel = 1;
        this.needToaddContent = Boolean.FALSE;
        this.appinfoBuilder = new AppInfo.Builder();
        this.mMaxTokenCount = 1024;
        this.isCanceled = false;
        this.mSummarizer = AiServices.getSummarizer(context);
        initialize(context, str);
    }

    private LongTextSummarizer(@NonNull Context context, @NonNull String str, int i) {
        this.TAG = "LongTextSummarizer";
        this.isProcessing = new AtomicBoolean(false);
        this.run = new AtomicBoolean(false);
        int[] iArr = {1, 2, 3};
        this.DEPTH_LEVEL = iArr;
        this.depthLevel = 1;
        this.needToaddContent = Boolean.FALSE;
        this.appinfoBuilder = new AppInfo.Builder();
        this.mMaxTokenCount = 1024;
        this.isCanceled = false;
        this.mSummarizer = AiServices.getSummarizer(context);
        if (i == 0 || i == 1) {
            this.depthLevel = iArr[0];
        } else if (i != 2) {
            this.depthLevel = iArr[1];
        } else {
            this.depthLevel = iArr[1];
        }
        initialize(context, str);
    }
}
