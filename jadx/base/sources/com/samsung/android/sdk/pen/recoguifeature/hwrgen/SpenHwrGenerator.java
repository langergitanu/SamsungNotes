package com.samsung.android.sdk.pen.recoguifeature.hwrgen;

import android.content.Context;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0005J\u0018\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/hwrgen/SpenHwrGenerator;", "", "<init>", "()V", "mNativeHwrGenerator", "", "mContext", "Landroid/content/Context;", "modelPath", "", "setNativeHandle", "", "context", "handle", "setNativeHandleForSmartScript", "close", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenHwrGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenHwrGenerator.kt\ncom/samsung/android/sdk/pen/recoguifeature/hwrgen/SpenHwrGenerator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
public final class SpenHwrGenerator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenHwrGenerator";

    @Nullable
    private Context mContext;
    private long mNativeHwrGenerator;

    @Nullable
    private String modelPath;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0083 J#\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/hwrgen/SpenHwrGenerator$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "nativeHwrGenerator", "", "HwrGenerator", "Lcom/samsung/android/sdk/pen/recoguifeature/hwrgen/SpenHwrGenerator;", "modelPath", "Native_initForSmartScript", "Native_finalize", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHwrGenerator) {
            SpenHwrGenerator.Native_finalize(nativeHwrGenerator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeHwrGenerator, SpenHwrGenerator HwrGenerator, String modelPath) {
            SpenHwrGenerator.Native_init(nativeHwrGenerator, HwrGenerator, modelPath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_initForSmartScript(long nativeHwrGenerator, SpenHwrGenerator HwrGenerator, String modelPath) {
            SpenHwrGenerator.Native_initForSmartScript(nativeHwrGenerator, HwrGenerator, modelPath);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SpenHwrGenerator spenHwrGenerator, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_initForSmartScript(long j, SpenHwrGenerator spenHwrGenerator, String str);

    public final void close() {
        this.mContext = null;
        long j = this.mNativeHwrGenerator;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
            this.mNativeHwrGenerator = 0L;
        }
    }

    public final void setNativeHandle(@Nullable Context context, long handle) {
        this.mNativeHwrGenerator = handle;
        this.mContext = context;
        Log.i(TAG, "SPenHwrGenerator:: setNativeHandle()");
        if (this.mNativeHwrGenerator != 0) {
            String strCopyModelFilesFromAssets = this.modelPath;
            if (strCopyModelFilesFromAssets == null) {
                strCopyModelFilesFromAssets = context != null ? SpenHwrGenResourceExtractor.INSTANCE.copyModelFilesFromAssets(context) : null;
            }
            this.modelPath = strCopyModelFilesFromAssets;
            AbstractC6670b.m4756q("SPenHwrGenerator:: setNativeHandle() modelPath : ", strCopyModelFilesFromAssets, TAG);
            INSTANCE.Native_init(this.mNativeHwrGenerator, this, this.modelPath);
        }
    }

    public final void setNativeHandleForSmartScript(@Nullable Context context, long handle) {
        this.mNativeHwrGenerator = handle;
        this.mContext = context;
        Log.i(TAG, "SPenHwrGenerator:: setNativeHandleForSmartScript()");
        if (this.mNativeHwrGenerator != 0) {
            String strCopyModelFilesFromAssets = this.modelPath;
            if (strCopyModelFilesFromAssets == null) {
                strCopyModelFilesFromAssets = context != null ? SpenHwrGenResourceExtractor.INSTANCE.copyModelFilesFromAssets(context) : null;
            }
            this.modelPath = strCopyModelFilesFromAssets;
            AbstractC6670b.m4756q("SPenHwrGenerator:: setNativeHandleForSmartScript() modelPath : ", strCopyModelFilesFromAssets, TAG);
            INSTANCE.Native_initForSmartScript(this.mNativeHwrGenerator, this, this.modelPath);
        }
    }
}
