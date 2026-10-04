package com.samsung.android.sdk.pen.recoguifeature.alignment;

import android.content.Context;
import android.graphics.RectF;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.recoguifeature.SPenRecognitionWorker;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J(\u0010\"\u001a\u00020\u000e2\u001e\u0010#\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$j\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u0001`&H\u0016J\b\u0010'\u001a\u00020\u000eH\u0016J\b\u0010(\u001a\u00020\u000eH\u0016J\b\u0010)\u001a\u00020\u000eH\u0016J\u0012\u0010*\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J \u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0016J(\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000eH\u0016J\u0018\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0010\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u000eH\u0002J\b\u00106\u001a\u00020\u0018H\u0002J\u0010\u00107\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u00108\u001a\u00020\u00182\u001a\u00109\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010%0$j\n\u0012\u0006\u0012\u0004\u0018\u00010%`&H\u0002J,\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020<2\u001a\u0010=\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010%0$j\n\u0012\u0006\u0012\u0004\u0018\u00010%`&H\u0002J\u0019\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u0000H\u0082 J\u0011\u0010A\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\bH\u0082 J\u0019\u0010B\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u000eH\u0082 J\u0011\u0010D\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\bH\u0082 J\u0011\u0010E\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\bH\u0082 J\u0011\u0010F\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\bH\u0082 J1\u0010G\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\b2\u001e\u0010#\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$j\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u0001`&H\u0082 J\u0011\u0010H\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\bH\u0082 J\u0011\u0010I\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\bH\u0082 J\u0011\u0010J\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\bH\u0082 J\u0011\u0010K\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\bH\u0082 J\u0019\u0010L\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\b2\u0006\u0010M\u001a\u00020<H\u0082 J\u0011\u0010N\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\bH\u0082 J\u0019\u0010O\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\b2\u0006\u0010P\u001a\u00020\fH\u0082 R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000f¨\u0006R"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/alignment/SPenAlignmentManager;", "Lcom/samsung/android/sdk/pen/recoguifeature/alignment/ISPenAlignmentManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "mAlignmentView", "", "mSPenAlignmentListener", "Lcom/samsung/android/sdk/pen/recoguifeature/alignment/SPenAlignmentListener;", "mBeautificationFlag", "", "isRunning", "", "()Z", "isBeautificationSupported", "letterCorrectionEnabled", "getLetterCorrectionEnabled", "lineCorrectionEnabled", "getLineCorrectionEnabled", "wordSpacingEnabled", "getWordSpacingEnabled", "setNativeHandle", "", "handle", "close", "setListener", "l", "setEnabled", "enable", "executeAlignment", "executeSelectionAlignment", "cancelAlignment", "executeCleanUp", "resultRectList", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "executeSelectionCleanUp", "cancel", "confirm", "updateLanguage", "text", "", "setBeautificationOptions", "fixShapeOfLetters", "alignLetters", "evenlySpaceWords", "straighten", "setFlag", "flag", "onProgressStartEnd", "start", "onFailed", "onRunning", "onUpdateResult", "resultViewRectList", "printRectList", "prefix", "", "rectList", "Native_init", "nativeAlignment", "alignmentManager", "Native_finalize", "Native_setEnabled", "enabled", "Native_executeAlignment", "Native_executeSelectionAlignment", "Native_executeCleanUp", "Native_executeCleanUpWithRect", "Native_executeSelectionCleanUp", "Native_cancel", "Native_confirm", "Native_isRunning", "Native_setLanguageName", "lang", "Native_isBeautificationSupported", "Native_setBeautificationFlag", "beautificationFlag", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SPenAlignmentManager implements ISPenAlignmentManager {

    @NotNull
    private static final String TAG = "AlignmentManager";
    private long mAlignmentView;
    private int mBeautificationFlag = 60;

    @Nullable
    private Context mContext;

    @Nullable
    private SPenAlignmentListener mSPenAlignmentListener;

    public SPenAlignmentManager(@Nullable Context context) {
        this.mContext = context;
    }

    private final native boolean Native_cancel(long nativeAlignment);

    private final native boolean Native_confirm(long nativeAlignment);

    private final native boolean Native_executeAlignment(long nativeAlignment);

    private final native boolean Native_executeCleanUp(long nativeAlignment);

    private final native boolean Native_executeCleanUpWithRect(long nativeAlignment, ArrayList<RectF> resultRectList);

    private final native boolean Native_executeSelectionAlignment(long nativeAlignment);

    private final native boolean Native_executeSelectionCleanUp(long nativeAlignment);

    private final native void Native_finalize(long nativeAlignment);

    private final native void Native_init(long nativeAlignment, SPenAlignmentManager alignmentManager);

    private final native boolean Native_isBeautificationSupported(long nativeAlignment);

    private final native boolean Native_isRunning(long nativeAlignment);

    private final native void Native_setBeautificationFlag(long nativeAlignment, int beautificationFlag);

    private final native void Native_setEnabled(long nativeAlignment, boolean enabled);

    private final native void Native_setLanguageName(long nativeAlignment, String lang);

    private final void onFailed() {
        Log.i(TAG, "SPenAlignmentManager::onFailed:");
        SPenAlignmentListener sPenAlignmentListener = this.mSPenAlignmentListener;
        if (sPenAlignmentListener != null) {
            sPenAlignmentListener.onAlignmentFailed();
        }
    }

    private final void onProgressStartEnd(boolean start) {
        AbstractC4539a.m3208r("SPenAlignmentManager::onProgressStartEnd : ", TAG, start);
        if (start) {
            SPenAlignmentListener sPenAlignmentListener = this.mSPenAlignmentListener;
            if (sPenAlignmentListener != null) {
                sPenAlignmentListener.onProgressStart();
                return;
            }
            return;
        }
        SPenAlignmentListener sPenAlignmentListener2 = this.mSPenAlignmentListener;
        if (sPenAlignmentListener2 != null) {
            sPenAlignmentListener2.onProgressStop();
        }
    }

    private final void onRunning(boolean isRunning) {
        AbstractC4539a.m3208r("SPenAlignmentManager::onRunning : ", TAG, isRunning);
        SPenAlignmentListener sPenAlignmentListener = this.mSPenAlignmentListener;
        if (sPenAlignmentListener != null) {
            sPenAlignmentListener.onAlignmentRunning(isRunning);
        }
    }

    private final void onUpdateResult(ArrayList<RectF> resultViewRectList) {
        printRectList("SPenAlignmentManager::onUpdateResult resultViewRectList", resultViewRectList);
        SPenAlignmentListener sPenAlignmentListener = this.mSPenAlignmentListener;
        if (sPenAlignmentListener != null) {
            sPenAlignmentListener.onUpdateResult(resultViewRectList);
        }
    }

    private final void printRectList(String prefix, ArrayList<RectF> rectList) {
        int size = rectList.size();
        for (int i = 0; i < size; i++) {
            RectF rectF = rectList.get(i);
            Intrinsics.checkNotNull(rectF);
            int i2 = (int) rectF.left;
            RectF rectF2 = rectList.get(i);
            Intrinsics.checkNotNull(rectF2);
            int i4 = (int) rectF2.top;
            RectF rectF3 = rectList.get(i);
            Intrinsics.checkNotNull(rectF3);
            int i5 = (int) rectF3.right;
            RectF rectF4 = rectList.get(i);
            Intrinsics.checkNotNull(rectF4);
            int i6 = (int) rectF4.bottom;
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            sb.append("[");
            sb.append(i);
            sb.append("] (l:");
            sb.append(i2);
            AbstractC0622a.m1180z(sb, i4, i5, ", t:", ", r:");
            sb.append(", b:");
            sb.append(i6);
            sb.append(")");
            Log.d(TAG, sb.toString());
        }
    }

    private final void setFlag(int flag, boolean enable) {
        int i;
        if (enable) {
            i = flag | this.mBeautificationFlag;
        } else {
            i = (~flag) & this.mBeautificationFlag;
        }
        this.mBeautificationFlag = i;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean cancel() {
        Log.i(TAG, "SPenAlignmentManager::cancel");
        long j = this.mAlignmentView;
        return j != 0 && Native_cancel(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean cancelAlignment() {
        Log.i(TAG, "SPenAlignmentManager::cancelAlignment");
        long j = this.mAlignmentView;
        return j != 0 && Native_cancel(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void close() {
        this.mContext = null;
        long j = this.mAlignmentView;
        if (j != 0) {
            Native_finalize(j);
        }
        this.mAlignmentView = 0L;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean confirm() {
        Log.i(TAG, "SPenAlignmentManager::confirm");
        long j = this.mAlignmentView;
        return j != 0 && Native_confirm(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean executeAlignment() {
        Log.i(TAG, "SPenAlignmentManager::executeAlignment");
        long j = this.mAlignmentView;
        return Native_executeAlignment(j) & (j != 0);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean executeCleanUp() {
        Log.i(TAG, "SPenAlignmentManager::executeCleanUp");
        long j = this.mAlignmentView;
        return j != 0 && Native_executeCleanUp(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean executeSelectionAlignment() {
        Log.d(TAG, "SPenAlignmentManager::executeSelectionAlignment");
        long j = this.mAlignmentView;
        return j != 0 && Native_executeSelectionAlignment(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean executeSelectionCleanUp() {
        Log.d(TAG, "SPenAlignmentManager::executeSelectionCleanUp");
        long j = this.mAlignmentView;
        return j != 0 && Native_executeSelectionCleanUp(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean getLetterCorrectionEnabled() {
        return (this.mBeautificationFlag & 4) > 0;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean getLineCorrectionEnabled() {
        return (this.mBeautificationFlag & 8) > 0;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean getWordSpacingEnabled() {
        return (this.mBeautificationFlag & 16) > 0;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean isBeautificationSupported() {
        long j = this.mAlignmentView;
        if (j != 0) {
            return Native_isBeautificationSupported(j);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean isRunning() {
        Log.i(TAG, "SPenAlignmentManager::hasResult");
        long j = this.mAlignmentView;
        return j != 0 && Native_isRunning(j);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void setBeautificationOptions(boolean fixShapeOfLetters, boolean alignLetters, boolean evenlySpaceWords) {
        AbstractC0000a.m27x(AbstractC2821a.m2230u("setBeautificationOptions letter: ", ", line: ", ", word: ", fixShapeOfLetters, alignLetters), evenlySpaceWords, TAG);
        if (this.mAlignmentView == 0) {
            return;
        }
        setFlag(4, fixShapeOfLetters);
        setFlag(8, alignLetters);
        setFlag(16, evenlySpaceWords);
        setFlag(32, true);
        Native_setBeautificationFlag(this.mAlignmentView, this.mBeautificationFlag);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void setEnabled(boolean enable) {
        AbstractC4539a.m3208r("setEnabled", TAG, enable);
        long j = this.mAlignmentView;
        if (j == 0) {
            return;
        }
        Native_setEnabled(j, enable);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void setListener(@Nullable SPenAlignmentListener l) {
        this.mSPenAlignmentListener = l;
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void setNativeHandle(long handle) {
        this.mAlignmentView = handle;
        if (handle != 0) {
            Native_init(handle, this);
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void updateLanguage(@Nullable CharSequence text) {
        if (text == null || text.length() <= 0) {
            Log.e(TAG, "SPenAlignmentManager::text == null || text.length() <= 0");
            return;
        }
        Log.i(TAG, "SPenAlignmentManager::updateLanguage - " + ((Object) text));
        if (SPenRecognitionWorker.setLanguage(text.toString())) {
            SPenRecognitionWorker.initializeSelf(this.mContext);
        }
        long j = this.mAlignmentView;
        if (j != 0) {
            Native_setLanguageName(j, text.toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public boolean executeCleanUp(@Nullable ArrayList<RectF> resultRectList) {
        Log.i(TAG, "SPenAlignmentManager::executeCleanUp");
        long j = this.mAlignmentView;
        return j != 0 && Native_executeCleanUpWithRect(j, resultRectList);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager
    public void setBeautificationOptions(boolean fixShapeOfLetters, boolean alignLetters, boolean evenlySpaceWords, boolean straighten) {
        StringBuilder sbM2230u = AbstractC2821a.m2230u("setBeautificationOptions letter: ", ", line: ", ", word: ", fixShapeOfLetters, alignLetters);
        sbM2230u.append(evenlySpaceWords);
        sbM2230u.append(", straighten: ");
        sbM2230u.append(straighten);
        Log.i(TAG, sbM2230u.toString());
        if (this.mAlignmentView == 0) {
            return;
        }
        setFlag(4, fixShapeOfLetters);
        setFlag(8, alignLetters);
        setFlag(16, evenlySpaceWords);
        setFlag(32, straighten);
        Native_setBeautificationFlag(this.mAlignmentView, this.mBeautificationFlag);
    }
}
