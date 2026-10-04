package com.samsung.android.support.senl.addons.brush.model.canvas;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveExecutor;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 52\u00020\u0001:\u0003567B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\bJ\u001a\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\bH\u0017J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\u001dH\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0015J\u0006\u0010+\u001a\u00020\bJ\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\bJ\b\u0010.\u001a\u00020\bH\u0002J\b\u0010/\u001a\u00020\bH\u0002J\b\u00100\u001a\u00020\bH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u0002028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00068"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveExecutor;", "Lkotlinx/coroutines/CoroutineScope;", "facade", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;)V", "mBrushFacade", "mIsOnSavingProcess", "", "getMIsOnSavingProcess", "()Z", "setMIsOnSavingProcess", "(Z)V", "mDocPath", "", "getMDocPath", "()Ljava/lang/String;", "setMDocPath", "(Ljava/lang/String;)V", "mThumbPath", "mOnSaveFileCallback", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveExecutor$OnSaveFileCallback;", "mSyncThread", "Ljava/lang/Thread;", "mSynchronize", "", "mJob", "Lkotlinx/coroutines/CompletableJob;", "quitSave", "", "joinSave", "setFilePath", "docPath", "thumbPath", "saveTaskExecutor", "isAsync", "withThread", "isOnSaving", "setPaintDocForegroundImage", "getDrawnRect", "Landroid/graphics/Rect;", "setSaveFileCallback", "saveFileCallback", "doInBackground", "onPostExecute", "result", "updateSavePath", "makeThumbnail", "save", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "OnSaveFileCallback", "SyncSaveThread", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushSaveExecutor implements CoroutineScope {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushSaveExecutor");

    @Nullable
    private BrushFacade mBrushFacade;

    @Nullable
    private String mDocPath;
    private boolean mIsOnSavingProcess;

    @Nullable
    private OnSaveFileCallback mOnSaveFileCallback;

    @Nullable
    private Thread mSyncThread;

    @Nullable
    private String mThumbPath;

    @NotNull
    private Object mSynchronize = new Object();

    @NotNull
    private CompletableJob mJob = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveExecutor$OnSaveFileCallback;", "", "getNewThumbnailPath", "", "getNewDocPath", "onSaveFinished", "", "isSuccess", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnSaveFileCallback {
        @Nullable
        String getNewDocPath();

        @Nullable
        String getNewThumbnailPath();

        void onSaveFinished(boolean isSuccess);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveExecutor$SyncSaveThread;", "Ljava/lang/Thread;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveExecutor;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nBrushSaveExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BrushSaveExecutor.kt\ncom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveExecutor$SyncSaveThread\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,203:1\n1#2:204\n*E\n"})
    public final class SyncSaveThread extends Thread {
        public SyncSaveThread() {
            super(new Runnable() { // from class: com.samsung.android.support.senl.addons.brush.model.canvas.a
                @Override // java.lang.Runnable
                public final void run() {
                    BrushSaveExecutor.SyncSaveThread._init_$lambda$1(brushSaveExecutor);
                }
            });
            setName("BrushSyncSaveThread");
            setPriority(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$1(BrushSaveExecutor brushSaveExecutor) {
            brushSaveExecutor.doInBackground();
            synchronized (brushSaveExecutor.mSynchronize) {
                brushSaveExecutor.mSyncThread = null;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveExecutor$saveTaskExecutor$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveExecutor$saveTaskExecutor$1", m14021f = "BrushSaveExecutor.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C79611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C79611(Continuation<? super C79611> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BrushSaveExecutor.this.new C79611(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BrushSaveExecutor.this.onPostExecute(BrushSaveExecutor.this.doInBackground());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C79611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public BrushSaveExecutor(@Nullable BrushFacade brushFacade) {
        this.mBrushFacade = brushFacade;
    }

    private final Rect getDrawnRect() {
        BrushFacade brushFacade = this.mBrushFacade;
        if (brushFacade != null) {
            return brushFacade.getDrawnRect();
        }
        return null;
    }

    private final boolean makeThumbnail() {
        if (!this.mIsOnSavingProcess) {
            return false;
        }
        BrushFacade brushFacade = this.mBrushFacade;
        boolean zMakeJpg = PlatformUtil.makeJpg(brushFacade != null ? brushFacade.captureRect(getDrawnRect()) : null, String.valueOf(this.mThumbPath), true);
        Logger.m7100d(TAG, "saveTaskExecutor saveThumbnail. " + zMakeJpg + " , " + Logger.getEncode(this.mThumbPath));
        return true;
    }

    private final boolean save() throws IOException {
        SpenPaintingDoc paintingDoc;
        if (!this.mIsOnSavingProcess) {
            return false;
        }
        BrushFacade brushFacade = this.mBrushFacade;
        if (brushFacade == null) {
            return true;
        }
        if ((brushFacade != null ? brushFacade.getPaintingDoc() : null) == null) {
            return true;
        }
        BrushFacade brushFacade2 = this.mBrushFacade;
        if (brushFacade2 != null && (paintingDoc = brushFacade2.getPaintingDoc()) != null) {
            paintingDoc.save(this.mDocPath);
        }
        AbstractC6670b.m4763x("saveTaskExecutor savePaintingDoc. ", Logger.getEncode(this.mDocPath), TAG);
        return true;
    }

    public static /* synthetic */ void saveTaskExecutor$default(BrushSaveExecutor brushSaveExecutor, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveTaskExecutor");
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        brushSaveExecutor.saveTaskExecutor(z, z2);
    }

    private final boolean updateSavePath() {
        if (!this.mIsOnSavingProcess) {
            return false;
        }
        OnSaveFileCallback onSaveFileCallback = this.mOnSaveFileCallback;
        this.mThumbPath = String.valueOf(onSaveFileCallback != null ? onSaveFileCallback.getNewThumbnailPath() : null);
        OnSaveFileCallback onSaveFileCallback2 = this.mOnSaveFileCallback;
        this.mDocPath = String.valueOf(onSaveFileCallback2 != null ? onSaveFileCallback2.getNewDocPath() : null);
        return true;
    }

    public final boolean doInBackground() {
        if (!this.mIsOnSavingProcess) {
            return false;
        }
        try {
            try {
                String str = TAG;
                Logger.m7104i(str, "saveTaskExecutor start.");
                setPaintDocForegroundImage();
                if (!updateSavePath()) {
                    this.mIsOnSavingProcess = false;
                    Logger.m7104i(str, "saveTaskExecutor end.");
                    return false;
                }
                if (!makeThumbnail()) {
                    this.mIsOnSavingProcess = false;
                    Logger.m7104i(str, "saveTaskExecutor end.");
                    return false;
                }
                if (save()) {
                    this.mIsOnSavingProcess = false;
                    Logger.m7104i(str, "saveTaskExecutor end.");
                    return true;
                }
                this.mIsOnSavingProcess = false;
                Logger.m7104i(str, "saveTaskExecutor end.");
                return false;
            } catch (Exception e) {
                String str2 = TAG;
                Logger.m7101e(str2, "save exception. " + e.getMessage());
                this.mIsOnSavingProcess = false;
                Logger.m7104i(str2, "saveTaskExecutor end.");
                return false;
            }
        } catch (Throwable th) {
            this.mIsOnSavingProcess = false;
            Logger.m7104i(TAG, "saveTaskExecutor end.");
            throw th;
        }
        this.mIsOnSavingProcess = false;
        Logger.m7104i(TAG, "saveTaskExecutor end.");
        throw th;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getMain().plus(this.mJob);
    }

    @Nullable
    public final String getMDocPath() {
        return this.mDocPath;
    }

    public final boolean getMIsOnSavingProcess() {
        return this.mIsOnSavingProcess;
    }

    public boolean isOnSaving() {
        return this.mIsOnSavingProcess;
    }

    public final boolean joinSave() {
        if (!this.mIsOnSavingProcess) {
            Logger.m7100d(TAG, "join save: not saving");
            return true;
        }
        Thread thread = this.mSyncThread;
        if (thread == null) {
            Logger.m7100d(TAG, "join save: not sync saving");
            return false;
        }
        if (thread != null && !thread.isAlive()) {
            Logger.m7100d(TAG, "join save: not alive sync saving");
            return true;
        }
        try {
            Logger.m7100d(TAG, "joining save");
            Thread thread2 = this.mSyncThread;
            if (thread2 != null) {
                thread2.join();
            }
        } catch (InterruptedException e) {
            Logger.m7101e(TAG, "join : " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        return true;
    }

    public final void onPostExecute(boolean result) {
        OnSaveFileCallback onSaveFileCallback = this.mOnSaveFileCallback;
        if (onSaveFileCallback != null) {
            onSaveFileCallback.onSaveFinished(result);
        }
    }

    public synchronized void quitSave() {
        this.mIsOnSavingProcess = false;
        Job.DefaultImpls.cancel$default((Job) this.mJob, (CancellationException) null, 1, (Object) null);
        synchronized (this.mSynchronize) {
            try {
                Thread thread = this.mSyncThread;
                if (thread != null) {
                    if (thread != null) {
                        thread.interrupt();
                    }
                    this.mSyncThread = null;
                    Logger.m7100d(TAG, "quit sync save : " + this.mIsOnSavingProcess);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmOverloads
    public final void saveTaskExecutor(boolean z) {
        saveTaskExecutor$default(this, z, false, 2, null);
    }

    public final void setFilePath(@Nullable String docPath, @Nullable String thumbPath) {
        if (docPath != null) {
            AbstractC6670b.m4763x("setFilePath : ", Logger.getEncode(docPath), TAG);
            this.mDocPath = docPath;
        }
        if (thumbPath != null) {
            this.mThumbPath = thumbPath;
        }
    }

    public final void setMDocPath(@Nullable String str) {
        this.mDocPath = str;
    }

    public final void setMIsOnSavingProcess(boolean z) {
        this.mIsOnSavingProcess = z;
    }

    public void setPaintDocForegroundImage() {
        SpenPaintingDoc paintingDoc;
        BrushFacade brushFacade = this.mBrushFacade;
        if (brushFacade != null) {
            if ((brushFacade != null ? brushFacade.getPaintingDoc() : null) != null) {
                BrushFacade brushFacade2 = this.mBrushFacade;
                Bitmap bitmapCaptureForegroundPage = brushFacade2 != null ? brushFacade2.captureForegroundPage() : null;
                if (bitmapCaptureForegroundPage == null) {
                    Logger.m7105w(TAG, "set foreground image : failed - null bitmap");
                    return;
                }
                try {
                    BrushFacade brushFacade3 = this.mBrushFacade;
                    if (brushFacade3 == null || (paintingDoc = brushFacade3.getPaintingDoc()) == null) {
                        return;
                    }
                    paintingDoc.setForegroundImage(bitmapCaptureForegroundPage);
                } catch (Exception e) {
                    Logger.m7101e(TAG, "set foreground image : failed - exception : " + e.getMessage());
                }
            }
        }
    }

    public final void setSaveFileCallback(@NotNull OnSaveFileCallback saveFileCallback) {
        Intrinsics.checkNotNullParameter(saveFileCallback, "saveFileCallback");
        this.mOnSaveFileCallback = saveFileCallback;
    }

    @JvmOverloads
    public void saveTaskExecutor(boolean isAsync, boolean withThread) {
        String str = TAG;
        int iHashCode = hashCode();
        StringBuilder sbM2230u = AbstractC2821a.m2230u("saveTaskExecutor, isAsync: ", " : withThread: ", " ", isAsync, withThread);
        sbM2230u.append(iHashCode);
        Logger.m7100d(str, sbM2230u.toString());
        this.mIsOnSavingProcess = true;
        if (isAsync) {
            BuildersKt__Builders_commonKt.launch$default(this, this.mJob, null, new C79611(null), 2, null);
            return;
        }
        Thread thread = this.mSyncThread;
        if (thread == null || thread == null || !thread.isAlive()) {
            SyncSaveThread syncSaveThread = new SyncSaveThread();
            this.mSyncThread = syncSaveThread;
            if (withThread) {
                Intrinsics.checkNotNull(syncSaveThread, "null cannot be cast to non-null type com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveExecutor.SyncSaveThread");
                syncSaveThread.start();
            } else {
                Intrinsics.checkNotNull(syncSaveThread, "null cannot be cast to non-null type com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveExecutor.SyncSaveThread");
                syncSaveThread.run();
            }
        }
    }
}
