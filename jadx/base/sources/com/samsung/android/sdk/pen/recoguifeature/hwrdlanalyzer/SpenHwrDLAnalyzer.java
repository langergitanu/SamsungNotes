package com.samsung.android.sdk.pen.recoguifeature.hwrdlanalyzer;

import android.content.Context;
import android.graphics.RectF;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.recogengine.hwrdata.SpenHwrDataList;
import com.samsung.android.sdk.pen.recoguifeature.common.SpenHwrFailCode;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\tJ6\u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0013j\b\u0012\u0004\u0012\u00020\u0017`\u0015J,\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0015H\u0002J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0014H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/hwrdlanalyzer/SpenHwrDLAnalyzer;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mNativeHwrDLAnalyzer", "", "mHwrDLAnalyzerListener", "Lcom/samsung/android/sdk/pen/recoguifeature/hwrdlanalyzer/SpenHwrDLAnalyzerListener;", "setNativeHandle", "", "handle", "close", "setListener", "l", "request", "", "pageIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "requestRectList", "Landroid/graphics/RectF;", "printRectList", "prefix", "", "rectList", "onSucceed", "hwrDataList", "Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrDataList;", "onFailed", "failCode", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHwrDLAnalyzer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenHwrDLAnalyzer";

    @Nullable
    private Context mContext;

    @Nullable
    private SpenHwrDLAnalyzerListener mHwrDLAnalyzerListener;
    private long mNativeHwrDLAnalyzer;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 JA\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/hwrdlanalyzer/SpenHwrDLAnalyzer$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "nativeHwrDLAnalyzer", "", "hwrDLAnalyzer", "Lcom/samsung/android/sdk/pen/recoguifeature/hwrdlanalyzer/SpenHwrDLAnalyzer;", "Native_finalize", "Native_request", "", "pageIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "requestRectList", "Landroid/graphics/RectF;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHwrDLAnalyzer) {
            SpenHwrDLAnalyzer.Native_finalize(nativeHwrDLAnalyzer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeHwrDLAnalyzer, SpenHwrDLAnalyzer hwrDLAnalyzer) {
            SpenHwrDLAnalyzer.Native_init(nativeHwrDLAnalyzer, hwrDLAnalyzer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_request(long nativeHwrDLAnalyzer, ArrayList<Integer> pageIdList, ArrayList<RectF> requestRectList) {
            return SpenHwrDLAnalyzer.Native_request(nativeHwrDLAnalyzer, pageIdList, requestRectList);
        }

        private Companion() {
        }
    }

    public SpenHwrDLAnalyzer(@Nullable Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SpenHwrDLAnalyzer spenHwrDLAnalyzer);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_request(long j, ArrayList<Integer> arrayList, ArrayList<RectF> arrayList2);

    private final void onFailed(int failCode) {
        SpenHwrFailCode spenHwrFailCode = SpenHwrFailCode.values()[failCode];
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4765z(new Object[]{Integer.valueOf(failCode), spenHwrFailCode.name()}, 2, "SPenAlignmentManager::onFailed : [%d] %s", "format(format, *args)", TAG);
        SpenHwrDLAnalyzerListener spenHwrDLAnalyzerListener = this.mHwrDLAnalyzerListener;
        if (spenHwrDLAnalyzerListener != null) {
            spenHwrDLAnalyzerListener.onFailed(spenHwrFailCode);
        }
    }

    private final void onSucceed(SpenHwrDataList hwrDataList) {
        Log.d(TAG, "SpenHwrDLAnalyzer::OnSucceed hwrDataList.size() : " + (hwrDataList != null ? Integer.valueOf(hwrDataList.getSize()) : null));
        if (this.mHwrDLAnalyzerListener == null) {
            Log.e(TAG, "SpenHwrDLAnalyzer::OnSucceed mHwrDLAnalyzerListener == null");
            return;
        }
        if ((hwrDataList != null ? hwrDataList.getSize() : 0) >= 0) {
            if (hwrDataList != null) {
                hwrDataList.printData("SpenHwrDLAnalyzer::OnSucceed");
            }
        } else {
            Log.d(TAG, "SpenHwrDLAnalyzer::OnSucceed  hwrDataList is empty");
            SpenHwrDLAnalyzerListener spenHwrDLAnalyzerListener = this.mHwrDLAnalyzerListener;
            if (spenHwrDLAnalyzerListener != null) {
                spenHwrDLAnalyzerListener.onFailed(SpenHwrFailCode.FAILED_CODE_NO_RESULT);
            }
        }
    }

    private final void printRectList(String prefix, ArrayList<RectF> rectList) {
        if (rectList == null) {
            return;
        }
        int size = rectList.size();
        for (int i = 0; i < size; i++) {
            Log.d(TAG, prefix + "[" + i + "] (l:" + rectList.get(i).left + ", t:" + rectList.get(i).top + ", r:" + rectList.get(i).right + ", b:" + rectList.get(i).bottom + ")");
        }
    }

    public final void close() {
        this.mContext = null;
        long j = this.mNativeHwrDLAnalyzer;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
        }
        this.mNativeHwrDLAnalyzer = 0L;
    }

    public final boolean request(@NotNull ArrayList<Integer> pageIdList, @NotNull ArrayList<RectF> requestRectList) {
        Intrinsics.checkNotNullParameter(pageIdList, "pageIdList");
        Intrinsics.checkNotNullParameter(requestRectList, "requestRectList");
        int size = requestRectList.size();
        for (int i = 0; i < size; i++) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("SpenHwrDLAnalyzer::request resultViewRectList pageId[%d] requestRect(l:%.2f, t:%.2f r:%.2f, b%.2f)", Arrays.copyOf(new Object[]{Integer.valueOf(i), Float.valueOf(requestRectList.get(i).left), Float.valueOf(requestRectList.get(i).top), Float.valueOf(requestRectList.get(i).right), Float.valueOf(requestRectList.get(i).bottom)}, 5));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            Log.d(TAG, str);
        }
        long j = this.mNativeHwrDLAnalyzer;
        return j != 0 && INSTANCE.Native_request(j, pageIdList, requestRectList);
    }

    public final void setListener(@Nullable SpenHwrDLAnalyzerListener l) {
        this.mHwrDLAnalyzerListener = l;
    }

    public final void setNativeHandle(long handle) {
        this.mNativeHwrDLAnalyzer = handle;
        if (handle != 0) {
            INSTANCE.Native_init(handle, this);
        }
    }
}
