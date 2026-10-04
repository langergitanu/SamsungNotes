package com.samsung.android.sdk.pen.recoguifeature.spentotext;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.recoguifeature.SPenRecognitionWorker;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001cH\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\rH\u0002J\b\u0010)\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/SPenSTTManager;", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/ISPenSTTManager;", "<init>", "()V", "mSTTView", "", "mListener", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/SPenSTTListener;", "mTextListener", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/SPenSTTTextListener;", "mContext", "Landroid/content/Context;", "setNativeHandle", "", "context", "handle", "close", "setListener", "l", "setTextListener", "updateRecognitionLanguage", "", "text", "", "setEnabled", "enable", "requestSPenToTextAction", "action", "", "setTextColor", "textColor", "bgColor", "setTargetMode", "mode", "performSPenToTextAction", "onActionPerformed", "onPenDrawingStarted", "x", "", "y", "onRecognitionStarted", "onResultInserted", "onRecognitionFailed", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SPenSTTManager implements ISPenSTTManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "STTManager";

    @Nullable
    private Context mContext;

    @Nullable
    private SPenSTTListener mListener;
    private long mSTTView;

    @Nullable
    private SPenSTTTextListener mTextListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0083 J!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0083 J\u0019\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0012H\u0083 J\u0019\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0005H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/SPenSTTManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "nativeHandle", "", "manager", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/SPenSTTManager;", "Native_finalize", "Native_setEnabled", "enabled", "", "Native_setTextColor", "textColor", "", "bgColor", "Native_setTargetMode", "mode", "Native_updateRecognitionLanguage", "lang", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SPenSTTManager.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeHandle, SPenSTTManager manager) {
            SPenSTTManager.Native_init(nativeHandle, manager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setEnabled(long nativeHandle, boolean enabled) {
            SPenSTTManager.Native_setEnabled(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setTargetMode(long nativeHandle, int mode) {
            SPenSTTManager.Native_setTargetMode(nativeHandle, mode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setTextColor(long nativeHandle, int textColor, int bgColor) {
            SPenSTTManager.Native_setTextColor(nativeHandle, textColor, bgColor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_updateRecognitionLanguage(long nativeHandle, String lang) {
            SPenSTTManager.Native_updateRecognitionLanguage(nativeHandle, lang);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SPenSTTManager sPenSTTManager);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setTargetMode(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setTextColor(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_updateRecognitionLanguage(long j, String str);

    private final void onActionPerformed(int action) {
        performSPenToTextAction(action);
    }

    private final void onPenDrawingStarted(float x, float y2, int mode) {
        AbstractC11014a.m12338w(AbstractC0622a.m1176v("SPenSTTManager::onPenDrawingStarted x : ", x, ", y : ", y2, ", mode : "), mode == 0 ? "SPEN_TO_TEXT_TARGET_BODY_TEXT" : "SPEN_TO_TEXT_TARGET_OBJECT_TEXT_BOX", TAG);
        SPenSTTListener sPenSTTListener = this.mListener;
        if (sPenSTTListener != null) {
            sPenSTTListener.onPenDrawingStarted(x, y2, mode);
        }
    }

    private final void onRecognitionFailed() {
        Log.i(TAG, "SPenSTTManager::onRecognitionFailed");
        SPenSTTListener sPenSTTListener = this.mListener;
        if (sPenSTTListener != null) {
            sPenSTTListener.onRecognitionFailed();
        }
        SPenSTTTextListener sPenSTTTextListener = this.mTextListener;
        if (sPenSTTTextListener != null) {
            sPenSTTTextListener.onSoftInputAffected(false);
        }
    }

    private final void onRecognitionStarted() {
        Log.i(TAG, "SPenSTTManager::onRecognitionStarted");
        SPenSTTListener sPenSTTListener = this.mListener;
        if (sPenSTTListener != null) {
            sPenSTTListener.onRecognitionStarted();
        }
        SPenSTTTextListener sPenSTTTextListener = this.mTextListener;
        if (sPenSTTTextListener != null) {
            sPenSTTTextListener.onSoftInputAffected(true);
        }
    }

    private final void onResultInserted() {
        Log.i(TAG, "SPenSTTManager::onResultInserted");
        SPenSTTListener sPenSTTListener = this.mListener;
        if (sPenSTTListener != null) {
            sPenSTTListener.onResultInserted();
        }
        SPenSTTTextListener sPenSTTTextListener = this.mTextListener;
        if (sPenSTTTextListener != null) {
            sPenSTTTextListener.onSoftInputAffected(false);
        }
    }

    private final void performSPenToTextAction(int action) {
        AbstractC2322a.m1631u(action, "SPenSTTManager::performSPenToTextAction - action :", TAG);
        int i = action != 1 ? action != 2 ? action != 3 ? 0 : 66 : 67 : 62;
        if (i != 0) {
            SPenSTTTextListener sPenSTTTextListener = this.mTextListener;
            if (sPenSTTTextListener != null) {
                sPenSTTTextListener.onKeyEvent(new KeyEvent(0, i));
            }
            SPenSTTTextListener sPenSTTTextListener2 = this.mTextListener;
            if (sPenSTTTextListener2 != null) {
                sPenSTTTextListener2.onKeyEvent(new KeyEvent(1, i));
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void close() {
        long j = this.mSTTView;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
        }
        this.mSTTView = 0L;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void requestSPenToTextAction(int action) {
        performSPenToTextAction(action);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void setEnabled(boolean enable) {
        SPenSTTTextListener sPenSTTTextListener;
        long j = this.mSTTView;
        if (j != 0) {
            INSTANCE.Native_setEnabled(j, enable);
            if (enable || (sPenSTTTextListener = this.mTextListener) == null) {
                return;
            }
            sPenSTTTextListener.onSoftInputAffected(false);
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void setListener(@Nullable SPenSTTListener l) {
        this.mListener = l;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void setNativeHandle(@Nullable Context context, long handle) {
        this.mContext = context;
        this.mSTTView = handle;
        Log.i(TAG, "SPenSTTManager::setNativeHandle mSTTView : " + handle);
        long j = this.mSTTView;
        if (j != 0) {
            INSTANCE.Native_init(j, this);
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void setTargetMode(int mode) {
        long j = this.mSTTView;
        if (j != 0) {
            INSTANCE.Native_setTargetMode(j, mode);
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void setTextColor(int textColor, int bgColor) {
        long j = this.mSTTView;
        if (j != 0) {
            INSTANCE.Native_setTextColor(j, textColor, bgColor);
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void setTextListener(@Nullable SPenSTTTextListener l) {
        this.mTextListener = l;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public boolean updateRecognitionLanguage(@Nullable CharSequence text) {
        if (text == null || text.length() <= 0 || this.mContext == null) {
            Log.e(TAG, "SPenSTTManager::updateRecognitionLanguage text == null || text.length() <= 0");
            return false;
        }
        Log.i(TAG, "SPenSTTManager::updateRecognitionLanguage - " + ((Object) text));
        if (!SPenRecognitionWorker.setLanguage(text.toString())) {
            return true;
        }
        SPenRecognitionWorker.initializeSelf(this.mContext);
        long j = this.mSTTView;
        if (j == 0) {
            return true;
        }
        INSTANCE.Native_updateRecognitionLanguage(j, text.toString());
        return true;
    }
}
