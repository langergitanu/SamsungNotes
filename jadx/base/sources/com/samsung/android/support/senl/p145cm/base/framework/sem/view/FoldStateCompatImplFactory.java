package com.samsung.android.support.senl.p145cm.base.framework.sem.view;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsFoldStateCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.view.SemWindowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/FoldStateCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$IFoldStateCompatImpl;", "isFoldableDevice", "", "FoldStateCompatFoldFormImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FoldStateCompatImplFactory extends AbsFoldStateCompatImplFactory {

    @NotNull
    private static final String TAG = "FoldStateCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/FoldStateCompatImplFactory$FoldStateCompatFoldFormImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$IFoldStateCompatImpl;", "<init>", "()V", "setFolderStateCallback", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FolderStateCallback;", "createProxy", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener$FoldStateProxy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener;", "FoldStateHandler", "FoldStateProxy", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class FoldStateCompatFoldFormImpl implements AbsFoldStateCompatImplFactory.IFoldStateCompatImpl {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/FoldStateCompatImplFactory$FoldStateCompatFoldFormImpl$FoldStateHandler;", "Landroid/os/Handler;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FolderStateCallback;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FolderStateCallback;)V", "mCallback", "mReceivedFoldStateChanged", "", "mReceivedTabletModeChanged", "mFinished", "mFolded", "mTabletMode", "mFoldStateListener", "Lcom/samsung/android/view/SemWindowManager$FoldStateListener;", "handleMessage", "", "msg", "Landroid/os/Message;", "finish", "updateState", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class FoldStateHandler extends Handler {
            private static final int MESSAGE_TIME_OUT = 305664569;
            private static final long TIME_OUT_MS = 300;

            @Nullable
            private AbsFoldStateCompatImplFactory.FolderStateCallback mCallback;
            private boolean mFinished;

            @NotNull
            private final SemWindowManager.FoldStateListener mFoldStateListener;
            private boolean mFolded;
            private boolean mReceivedFoldStateChanged;
            private boolean mReceivedTabletModeChanged;
            private boolean mTabletMode;

            public FoldStateHandler(@Nullable AbsFoldStateCompatImplFactory.FolderStateCallback folderStateCallback) {
                SemWindowManager.FoldStateListener foldStateListener = new SemWindowManager.FoldStateListener() { // from class: com.samsung.android.support.senl.cm.base.framework.sem.view.FoldStateCompatImplFactory.FoldStateCompatFoldFormImpl.FoldStateHandler.1
                    public void onFoldStateChanged(boolean b) {
                        FoldStateHandler.this.mFolded = b;
                        FoldStateHandler.this.mReceivedFoldStateChanged = true;
                        FoldStateHandler.this.updateState();
                    }

                    public void onTableModeChanged(boolean b) {
                        FoldStateHandler.this.mTabletMode = b;
                        FoldStateHandler.this.mReceivedTabletModeChanged = true;
                        FoldStateHandler.this.updateState();
                    }
                };
                this.mFoldStateListener = foldStateListener;
                SemWindowManager semWindowManager = SemWindowManager.getInstance();
                Intrinsics.checkNotNull(foldStateListener, "null cannot be cast to non-null type com.samsung.android.view.SemWindowManager.FoldStateListener");
                semWindowManager.registerFoldStateListener(foldStateListener, this);
                this.mCallback = folderStateCallback;
                sendEmptyMessageDelayed(MESSAGE_TIME_OUT, 300L);
            }

            private final void finish() {
                removeMessages(MESSAGE_TIME_OUT);
                this.mFinished = true;
                this.mCallback = null;
                SemWindowManager.getInstance().unregisterFoldStateListener(this.mFoldStateListener);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void updateState() {
                if (this.mFinished) {
                    LoggerBase.INSTANCE.m7138w(FoldStateCompatImplFactory.TAG, "already finished");
                    return;
                }
                if (this.mReceivedFoldStateChanged && this.mReceivedTabletModeChanged) {
                    boolean z = this.mFolded;
                    int i = z ? 1 : this.mTabletMode ? 2 : 3;
                    LoggerBase.Companion companion = LoggerBase.INSTANCE;
                    boolean z2 = this.mTabletMode;
                    StringBuilder sbM2226q = AbstractC2821a.m2226q("fold state : ", i, " / ", z, " & ");
                    sbM2226q.append(z2);
                    companion.m7137i(FoldStateCompatImplFactory.TAG, sbM2226q.toString());
                    AbsFoldStateCompatImplFactory.FolderStateCallback folderStateCallback = this.mCallback;
                    if (folderStateCallback != null) {
                        folderStateCallback.onSuccess(i);
                    }
                    finish();
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NotNull Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.what != MESSAGE_TIME_OUT || this.mFinished) {
                    return;
                }
                LoggerBase.INSTANCE.m7132d(FoldStateCompatImplFactory.TAG, "time out");
                AbsFoldStateCompatImplFactory.FolderStateCallback folderStateCallback = this.mCallback;
                if (folderStateCallback != null) {
                    folderStateCallback.onFailed();
                }
                finish();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/FoldStateCompatImplFactory$FoldStateCompatFoldFormImpl$FoldStateProxy;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener$FoldStateProxy;", "mChangeListener", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener;)V", "mHandler", "Landroid/os/Handler;", "mSemListener", "Lcom/samsung/android/view/SemWindowManager$FoldStateListener;", "register", "", "unregister", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        @SourceDebugExtension({"SMAP\nFoldStateCompatImplFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FoldStateCompatImplFactory.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/view/FoldStateCompatImplFactory$FoldStateCompatFoldFormImpl$FoldStateProxy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n1#2:140\n*E\n"})
        public static final class FoldStateProxy implements AbsFoldStateCompatImplFactory.FoldStateChangeListener.FoldStateProxy {

            @Nullable
            private final AbsFoldStateCompatImplFactory.FoldStateChangeListener mChangeListener;

            @NotNull
            private final Handler mHandler = new Handler();

            @Nullable
            private SemWindowManager.FoldStateListener mSemListener = new SemWindowManager.FoldStateListener() { // from class: com.samsung.android.support.senl.cm.base.framework.sem.view.FoldStateCompatImplFactory.FoldStateCompatFoldFormImpl.FoldStateProxy.1
                public void onFoldStateChanged(boolean b) {
                    AbsFoldStateCompatImplFactory.FoldStateChangeListener foldStateChangeListener = FoldStateProxy.this.mChangeListener;
                    if (foldStateChangeListener != null) {
                        foldStateChangeListener.onChanged(b);
                    }
                }

                public void onTableModeChanged(boolean b) {
                }
            };

            public FoldStateProxy(@Nullable AbsFoldStateCompatImplFactory.FoldStateChangeListener foldStateChangeListener) {
                this.mChangeListener = foldStateChangeListener;
            }

            @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FoldStateChangeListener.FoldStateProxy
            public void register() {
                SemWindowManager.FoldStateListener foldStateListener = this.mSemListener;
                if (foldStateListener == null || foldStateListener == null) {
                    return;
                }
                SemWindowManager.getInstance().registerFoldStateListener(foldStateListener, this.mHandler);
            }

            @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FoldStateChangeListener.FoldStateProxy
            public void unregister() {
                SemWindowManager.FoldStateListener foldStateListener = this.mSemListener;
                if (foldStateListener == null) {
                    return;
                }
                if (foldStateListener != null) {
                    SemWindowManager.getInstance().unregisterFoldStateListener(foldStateListener);
                }
                this.mSemListener = null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.IFoldStateCompatImpl
        @Nullable
        public AbsFoldStateCompatImplFactory.FoldStateChangeListener.FoldStateProxy createProxy(@Nullable AbsFoldStateCompatImplFactory.FoldStateChangeListener listener) {
            return new FoldStateProxy(listener);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.IFoldStateCompatImpl
        public void setFolderStateCallback(@Nullable AbsFoldStateCompatImplFactory.FolderStateCallback callback) {
            new FoldStateHandler(callback);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsFoldStateCompatImplFactory
    @NotNull
    public AbsFoldStateCompatImplFactory.IFoldStateCompatImpl create(boolean isFoldableDevice) {
        return (Build.VERSION.SDK_INT < 29 || !isFoldableDevice) ? super.create(isFoldableDevice) : new FoldStateCompatFoldFormImpl();
    }
}
