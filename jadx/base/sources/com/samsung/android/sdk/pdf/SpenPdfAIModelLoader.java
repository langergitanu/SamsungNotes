package com.samsung.android.sdk.pdf;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import p009B3.C0035a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u001c\u0010\u0013\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfAIModelLoader;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "nativeHandle", "", "modelPath", "", "localDirPath", "setNativeHandle", "", "handle", "getModelPath", "close", "deleteOldModelFiles", "copyModelFilesFromAssets", "resContext", "copyFile", "assetManager", "Landroid/content/res/AssetManager;", "where", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPdfAIModelLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPdfAIModelLoader.kt\ncom/samsung/android/sdk/pdf/SpenPdfAIModelLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
public final class SpenPdfAIModelLoader {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String PDF_AI_MODEL_ASSET_DIRECTORY = "pdfda";

    @NotNull
    private static final String PDF_AI_MODEL_DEVICE_DIRECTORY = "pdfda";

    @NotNull
    private static final String PDF_AI_MODEL_NAME = "rtdetr_doclaynet_toc_v1.13.7_quant.ort.onnx";

    @NotNull
    private static final String PDF_AI_MODEL_SOURCE_PATH = "pdfda/rtdetr_doclaynet_toc_v1.13.7_quant.ort.onnx";

    @NotNull
    private static final String TAG = "PdfAIModelLoader";

    @NotNull
    private Context context;

    @NotNull
    private final String localDirPath;

    @NotNull
    private String modelPath;
    private long nativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0011\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfAIModelLoader$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PDF_AI_MODEL_ASSET_DIRECTORY", "PDF_AI_MODEL_DEVICE_DIRECTORY", "PDF_AI_MODEL_NAME", "PDF_AI_MODEL_SOURCE_PATH", "Native_init", "", "nativeHandle", "", "loader", "Lcom/samsung/android/sdk/pdf/SpenPdfAIModelLoader;", "modelPath", "Native_finalize", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenPdfAIModelLoader.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeHandle, SpenPdfAIModelLoader loader, String modelPath) {
            SpenPdfAIModelLoader.Native_init(nativeHandle, loader, modelPath);
        }

        private Companion() {
        }
    }

    public SpenPdfAIModelLoader(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.modelPath = "";
        this.localDirPath = AbstractC11014a.m12320e(context.getFilesDir(), "/pdfda");
        String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
        if (strArr != null) {
            if (!(strArr.length == 0)) {
                deleteOldModelFiles();
                String strCopyModelFilesFromAssets = this.modelPath;
                strCopyModelFilesFromAssets = strCopyModelFilesFromAssets.length() == 0 ? copyModelFilesFromAssets(this.context) : strCopyModelFilesFromAssets;
                this.modelPath = strCopyModelFilesFromAssets;
                AbstractC2322a.m1609C("modelPath : ", strCopyModelFilesFromAssets, TAG);
                return;
            }
        }
        Log.i(TAG, "skip PDFAIModelLoader logic for unsupported devices.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SpenPdfAIModelLoader spenPdfAIModelLoader, String str);

    /* JADX WARN: Removed duplicated region for block: B:38:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void copyFile(AssetManager assetManager, String where) throws Throwable {
        FileOutputStream fileOutputStream;
        Throwable th;
        InputStream inputStreamOpen;
        IOException e;
        try {
            inputStreamOpen = assetManager.open(PDF_AI_MODEL_SOURCE_PATH);
            try {
                fileOutputStream = new FileOutputStream(new File(where));
                try {
                    try {
                        copyFile(inputStreamOpen, fileOutputStream);
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        Log.e(TAG, "copyFile() Failed to copy asset file: pdfda/rtdetr_doclaynet_toc_v1.13.7_quant.ort.onnx", e);
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (fileOutputStream == null) {
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        throw th;
                    }
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (inputStreamOpen != null) {
                }
                if (fileOutputStream != null) {
                }
            }
        } catch (IOException e5) {
            fileOutputStream = null;
            e = e5;
            inputStreamOpen = null;
        } catch (Throwable th4) {
            fileOutputStream = null;
            th = th4;
            inputStreamOpen = null;
        }
        try {
            fileOutputStream.close();
        } catch (IOException unused5) {
        }
    }

    private final String copyModelFilesFromAssets(Context resContext) throws Throwable {
        String[] list;
        boolean z;
        AssetManager assets = resContext.getAssets();
        try {
            list = assets.list("pdfda");
        } catch (IOException e) {
            Log.e(TAG, "copyModelFilesFromAssets() Failed to get asset file list.", e);
            list = null;
        }
        String strM756B = "";
        if (list == null || list.length == 0) {
            Log.w(TAG, "copyModelFilesFromAssets() asset list is NullOrEmpty");
            return "";
        }
        File file = new File(this.localDirPath);
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (Exception e2) {
                Log.e(TAG, "copyModelFilesFromAssets() mkdir failed.", e2);
            }
        }
        Iterator it = ArrayIteratorKt.iterator(list);
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (Intrinsics.areEqual((String) it.next(), PDF_AI_MODEL_NAME)) {
                strM756B = AbstractC0541b.m756B(this.localDirPath, "/rtdetr_doclaynet_toc_v1.13.7_quant.ort.onnx");
                if (!AbstractC2322a.m1607A(strM756B)) {
                    Intrinsics.checkNotNull(assets);
                    copyFile(assets, strM756B);
                    Log.i(TAG, "copy file in device");
                }
                z = true;
            }
        }
        if (!z) {
            Log.e(TAG, "copyModelFilesFromAssets() model file not exist");
        }
        return strM756B;
    }

    private final void deleteOldModelFiles() {
        File[] fileArrListFiles = new File(this.localDirPath).listFiles(new C0035a(17));
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            Log.i(TAG, "No old files found.");
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
        while (it.hasNext()) {
            File file = (File) it.next();
            file.delete();
            AbstractC6670b.m4756q("Deleted file: ", file.getName(), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteOldModelFiles$lambda$1(File file, String str) {
        Intrinsics.checkNotNull(str);
        return StringsKt.m14167w(str, ".onnx") && !str.equals(PDF_AI_MODEL_NAME);
    }

    public final void close() {
        Log.d(TAG, "close SpenPdfAIModelLoader");
        INSTANCE.Native_finalize(this.nativeHandle);
        this.nativeHandle = 0L;
    }

    @NotNull
    public final String getModelPath() {
        return this.modelPath;
    }

    public final void setNativeHandle(long handle) {
        this.nativeHandle = handle;
        if (handle != 0) {
            INSTANCE.Native_init(handle, this, this.modelPath);
        }
    }

    private final void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream != null && outputStream != null) {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return;
                } else {
                    outputStream.write(bArr, 0, i);
                }
            }
        } else {
            Log.w(TAG, "Stream is null. Skip copying.");
        }
    }
}
