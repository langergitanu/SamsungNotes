package com.samsung.android.support.senl.p148nt.model.assist.lvm;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSImageResultListener;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLVMRequesterImpl;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.lvm.Operator;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Operator {
    private static final String TAG = "Ai$LVM$Operator";
    private Callback mCallback;
    SCSLVMRequesterImpl mImpl;
    private SCSImageResultListener.Callback mResponse;
    private final ExecutorService mLVMExecutor = AbstractC4539a.m3201k(TAG);
    boolean mIsPreProcessRequested = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback extends SCSImageResultListener.Callback {
        void onRetry(Runnable runnable);
    }

    public Operator() {
        Logger.m8697d(TAG, "Constructed : " + hashCode());
        this.mResponse = new C114131();
        initImpl();
    }

    private void initImpl() {
        SCSLVMRequesterImpl sCSLVMRequesterImpl = new SCSLVMRequesterImpl();
        this.mImpl = sCSLVMRequesterImpl;
        sCSLVMRequesterImpl.setCallback(this.mResponse);
    }

    public void cancel() {
        SCSLVMRequesterImpl sCSLVMRequesterImpl = this.mImpl;
        if (sCSLVMRequesterImpl == null) {
            return;
        }
        sCSLVMRequesterImpl.cancel(getRequestType());
    }

    public void execute() {
        if (isReleased()) {
            return;
        }
        requestPreProcess();
        onExecute();
    }

    public abstract SCSRequesterType getRequestType();

    public boolean isReleased() {
        return this.mResponse == null || this.mImpl == null || this.mCallback == null;
    }

    public void onExecute() {
        if (isReleased()) {
            Logger.m8703w(TAG, "onExecute, ignore, already released");
        } else {
            Logger.m8697d(TAG, "onExecute");
            this.mLVMExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.assist.lvm.Operator.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Operator.this.operate();
                    } catch (Exception e) {
                        Logger.m8703w(Operator.TAG, "operate - " + e.getMessage());
                        Operator.this.mResponse.onFailed(e.getMessage());
                    }
                }
            });
        }
    }

    public abstract void operate();

    public void registerCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void release() {
        this.mLVMExecutor.shutdown();
        this.mCallback = null;
        this.mResponse = null;
        SCSLVMRequesterImpl sCSLVMRequesterImpl = this.mImpl;
        if (sCSLVMRequesterImpl != null) {
            sCSLVMRequesterImpl.release(getRequestType());
            this.mImpl.close();
            this.mImpl = null;
        }
        Logger.m8697d(TAG, "release - " + getClass().getSimpleName() + " : " + hashCode());
    }

    public void requestPreProcess() {
        if (isReleased()) {
            Logger.m8703w(TAG, "requestPreProcess, ignore, already released");
        } else {
            if (this.mIsPreProcessRequested) {
                return;
            }
            this.mIsPreProcessRequested = true;
            this.mLVMExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.assist.lvm.Operator.3
                @Override // java.lang.Runnable
                public void run() {
                    Operator.this.preProcessing();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.assist.lvm.Operator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C114131 implements SCSImageResultListener.Callback {
        public C114131() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$0() {
            Operator.this.mCallback.onRetry(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.assist.lvm.Operator.1.2
                @Override // java.lang.Runnable
                public void run() {
                    Operator.this.onExecute();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$1() {
            Operator.this.onExecute();
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSImageResultListener.Callback
        public boolean onFailed(@NonNull String str) {
            if (Operator.this.isReleased()) {
                Logger.m8703w(Operator.TAG, "onFailed, ignore, already released");
                return false;
            }
            if (Operator.this.mImpl.couldTokenRetry(str)) {
                final int i = 0;
                new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.model.assist.lvm.a

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ Operator.C114131 f7692b;

                    {
                        this.f7692b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i) {
                            case 0:
                                this.f7692b.lambda$onFailed$0();
                                break;
                            default:
                                this.f7692b.lambda$onFailed$1();
                                break;
                        }
                    }
                });
                Logger.m8697d(Operator.TAG, "onFailed#couldTokenRetry : retry - " + str + ":1");
                return false;
            }
            if (!Operator.this.mImpl.couldRetry(str)) {
                if (Operator.this.mCallback == null) {
                    return false;
                }
                return Operator.this.mCallback.onFailed(str);
            }
            final int i2 = 1;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.model.assist.lvm.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ Operator.C114131 f7692b;

                {
                    this.f7692b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            this.f7692b.lambda$onFailed$0();
                            break;
                        default:
                            this.f7692b.lambda$onFailed$1();
                            break;
                    }
                }
            }, 100L);
            Logger.m8697d(Operator.TAG, "onFailed#couldRetry : retry - " + str + ":1");
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSImageResultListener.Callback
        public void onSuccess(@NonNull final List<Bitmap> list, final boolean z) {
            if (Operator.this.isReleased()) {
                Logger.m8703w(Operator.TAG, "onSuccess, ignore, already released");
            } else {
                Operator.this.mLVMExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.assist.lvm.Operator.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Operator.this.isReleased()) {
                            Logger.m8703w(Operator.TAG, "onSuccess, run, ignore, already released");
                            return;
                        }
                        for (int i = 0; i < list.size(); i++) {
                            List list2 = list;
                            list2.set(i, Operator.this.postProcessing((Bitmap) list2.get(i), i));
                        }
                        Operator.this.mCallback.onSuccess(list, z);
                    }
                });
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSImageResultListener.Callback
        public boolean onFailed(@NonNull Bundle bundle) {
            if (Operator.this.mCallback == null) {
                return false;
            }
            return Operator.this.mCallback.onFailed(bundle);
        }
    }

    public void preProcessing() {
    }

    @Nullable
    public Bitmap postProcessing(@Nullable Bitmap bitmap, int i) {
        return bitmap;
    }
}
