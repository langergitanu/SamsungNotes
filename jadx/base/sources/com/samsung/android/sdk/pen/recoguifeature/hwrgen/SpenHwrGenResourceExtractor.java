package com.samsung.android.sdk.pen.recoguifeature.hwrgen;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000bJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/hwrgen/SpenHwrGenResourceExtractor;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "HWR_GENERATION_ROOT_DIR", "HWR_GENERATION_SDT_REFS_DIR", "getStorageDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "copyModelFilesFromAssets", "resContext", "copyFile", "", "assetManager", "Landroid/content/res/AssetManager;", Constants.MessagePayloadKeys.FROM, "where", "input", "Ljava/io/InputStream;", "out", "Ljava/io/OutputStream;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenHwrGenResourceExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenHwrGenResourceExtractor.kt\ncom/samsung/android/sdk/pen/recoguifeature/hwrgen/SpenHwrGenResourceExtractor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
public final class SpenHwrGenResourceExtractor {

    @NotNull
    private static final String HWR_GENERATION_ROOT_DIR = "hwrgen_template";

    @NotNull
    private static final String HWR_GENERATION_SDT_REFS_DIR = "sdt_references";

    @NotNull
    public static final SpenHwrGenResourceExtractor INSTANCE = new SpenHwrGenResourceExtractor();

    @NotNull
    private static final String TAG = "HwrGenResourceExtractor";

    private SpenHwrGenResourceExtractor() {
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void copyFile(AssetManager assetManager, String from, String where) throws Throwable {
        FileOutputStream fileOutputStream;
        IOException e;
        InputStream inputStreamOpen;
        InputStream inputStream = null;
        try {
            inputStreamOpen = assetManager.open(from);
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
                        Log.e(TAG, "SPenHwrGenResourceExtractor::copyFile() Failed to copy asset file: " + from, e);
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
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpen;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (fileOutputStream == null) {
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
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                inputStream = inputStreamOpen;
                if (inputStream != null) {
                }
                if (fileOutputStream == null) {
                }
            }
        } catch (IOException e5) {
            fileOutputStream = null;
            e = e5;
            inputStreamOpen = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (inputStream != null) {
            }
            if (fileOutputStream == null) {
            }
        }
        try {
            fileOutputStream.close();
        } catch (IOException unused5) {
        }
    }

    private final File getStorageDir(Context context) {
        if (context != null) {
            return context.getFilesDir();
        }
        return null;
    }

    @Nullable
    public final String copyModelFilesFromAssets(@NotNull Context resContext) throws Throwable {
        String[] list;
        Intrinsics.checkNotNullParameter(resContext, "resContext");
        AssetManager assets = resContext.getAssets();
        String[] list2 = null;
        try {
            list = assets.list(HWR_GENERATION_ROOT_DIR);
        } catch (IOException e) {
            Log.e(TAG, "SPenHwrGenResourceExtractor::copyModelFilesFromAssets() Failed to get asset file list.", e);
            list = null;
        }
        if (list == null) {
            Log.e(TAG, "SPenHwrGenResourceExtractor::copyModelFilesFromAssets() files == null");
            return null;
        }
        File file = new File(getStorageDir(resContext), HWR_GENERATION_ROOT_DIR);
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (Exception e2) {
                Log.e(TAG, "SPenHwrGenResourceExtractor::copyModelFilesFromAssets() mkdir failed.", e2);
            }
        }
        String strM12320e = AbstractC11014a.m12320e(getStorageDir(resContext), "/hwrgen_template");
        Iterator it = ArrayIteratorKt.iterator(list);
        while (it.hasNext()) {
            String str = (String) it.next();
            if (StringsKt.m14167w(str, ".plt") || StringsKt.m14167w(str, ".dat") || StringsKt.m14167w(str, ".onnx")) {
                Intrinsics.checkNotNull(assets);
                copyFile(assets, "hwrgen_template/" + str, AbstractC0541b.m757C(strM12320e, "/", str));
            }
        }
        try {
            list2 = assets.list("hwrgen_template/sdt_references");
        } catch (IOException e3) {
            Log.e(TAG, "SPenHwrGenResourceExtractor::copyModelFilesFromAssets() Failed to get asset sdt refs file list.", e3);
        }
        if (list2 == null) {
            Log.e(TAG, "SPenHwrGenResourceExtractor::copyModelFilesFromAssets() refsFiles == null");
            return strM12320e;
        }
        File file2 = new File(getStorageDir(resContext), "hwrgen_template/sdt_references");
        if (!file2.exists()) {
            try {
                file2.mkdir();
            } catch (Exception e5) {
                Log.e(TAG, "SPenHwrGenResourceExtractor::copyModelFilesFromAssets() mkdir failed.", e5);
            }
        }
        String strM12320e2 = AbstractC11014a.m12320e(getStorageDir(resContext), "/hwrgen_template/sdt_references");
        Iterator it2 = ArrayIteratorKt.iterator(list2);
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (StringsKt.m14167w(str2, ".bin")) {
                Intrinsics.checkNotNull(assets);
                copyFile(assets, "hwrgen_template/sdt_references/" + str2, AbstractC0541b.m757C(strM12320e2, "/", str2));
            }
        }
        return strM12320e;
    }

    private final void copyFile(InputStream input, OutputStream out) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = input.read(bArr);
            if (i == -1) {
                return;
            } else {
                out.write(bArr, 0, i);
            }
        }
    }
}
