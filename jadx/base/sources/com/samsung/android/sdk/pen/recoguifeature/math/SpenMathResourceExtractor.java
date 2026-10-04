package com.samsung.android.sdk.pen.recoguifeature.math;

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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathResourceExtractor;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ASSETS_MODEL_STANDARD_DIRECTORY", "ASSETS_FONTS_PATH", "FILES_FONTS_DIRECTORY", "FILES_FONT_CACHE_DIRECTORY", "FILES_MODEL_STANDARD_DIRECTORY", "FILES_MODEL_DLA_DIRECTORY", "FILES_MODEL_DLA_LOCAL_DIRECTORY", "MATH_DOC_MODEL_NAME", "MATH_DOC_LS_MODEL_NAME", "getStorageDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "copyModelFilesFromAssets", "resContext", "copyDocModelFilesFromAssets", "copyDocLsModelFilesFromAssets", "copyOtfFontsFromAssets", "copyFile", "", "assetManager", "Landroid/content/res/AssetManager;", Constants.MessagePayloadKeys.FROM, "where", "inputStream", "Ljava/io/InputStream;", "out", "Ljava/io/OutputStream;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenMathResourceExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenMathResourceExtractor.kt\ncom/samsung/android/sdk/pen/recoguifeature/math/SpenMathResourceExtractor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,224:1\n1#2:225\n*E\n"})
public final class SpenMathResourceExtractor {

    @NotNull
    private static final String ASSETS_FONTS_PATH = "hme/fonts";

    @NotNull
    private static final String ASSETS_MODEL_STANDARD_DIRECTORY = "hme";

    @NotNull
    private static final String FILES_FONTS_DIRECTORY = "hme/fonts";

    @NotNull
    private static final String FILES_FONT_CACHE_DIRECTORY = "hme/fonts/fccache";

    @NotNull
    public static final String FILES_MODEL_DLA_DIRECTORY = "hme/document";

    @NotNull
    public static final String FILES_MODEL_DLA_LOCAL_DIRECTORY = "hme/document";

    @NotNull
    public static final String FILES_MODEL_STANDARD_DIRECTORY = "hme";

    @NotNull
    public static final SpenMathResourceExtractor INSTANCE = new SpenMathResourceExtractor();

    @NotNull
    public static final String MATH_DOC_LS_MODEL_NAME = "math_ls_model.bin";

    @NotNull
    public static final String MATH_DOC_MODEL_NAME = "math_model.bin";

    @NotNull
    private static final String TAG = "MathResourceExtractor";

    private SpenMathResourceExtractor() {
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
                        Log.e(TAG, "SPenMathResourceExtractor::copyFile() Failed to copy asset file: " + from, e);
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

    @JvmStatic
    @Nullable
    public static final String copyOtfFontsFromAssets(@Nullable Context resContext) {
        String[] list;
        AssetManager assets = resContext != null ? resContext.getAssets() : null;
        if (assets != null) {
            try {
                list = assets.list("hme/fonts");
            } catch (IOException e) {
                Log.e(TAG, "SPenMathResourceExtractor::copyOtfFontsFromAssets() Failed to get asset file list.", e);
                list = null;
            }
        } else {
            list = null;
        }
        if (list == null) {
            Log.e(TAG, "SPenMathResourceExtractor::copyOtfFontsFromAssets() files == null");
            return null;
        }
        File file = new File(INSTANCE.getStorageDir(resContext), "hme/fonts");
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (Exception e2) {
                Log.e(TAG, "SPenMathResourceExtractor::copyOtfFontsFromAssets() mkdir failed.", e2);
            }
        }
        File file2 = new File(INSTANCE.getStorageDir(resContext), FILES_FONT_CACHE_DIRECTORY);
        if (!file2.exists()) {
            try {
                file2.mkdir();
            } catch (Exception e3) {
                Log.e(TAG, "SPenMathResourceExtractor::copyOtfFontsFromAssets() mkdir failed.", e3);
            }
        }
        String strM12320e = AbstractC11014a.m12320e(INSTANCE.getStorageDir(resContext), "/hme/fonts");
        Iterator it = ArrayIteratorKt.iterator(list);
        while (it.hasNext()) {
            String str = (String) it.next();
            if (StringsKt.m14167w(str, ".otf") && assets != null) {
                INSTANCE.copyFile(assets, AbstractC0541b.m772n("hme/fonts/", str), AbstractC0541b.m757C(strM12320e, "/", str));
            }
        }
        return strM12320e;
    }

    private final File getStorageDir(Context context) {
        File filesDir;
        return (context == null || (filesDir = context.getFilesDir()) == null) ? new File("") : filesDir;
    }

    @Nullable
    public final String copyDocLsModelFilesFromAssets(@Nullable Context resContext) throws Throwable {
        String[] list;
        String strM756B = null;
        AssetManager assets = resContext != null ? resContext.getAssets() : null;
        if (assets != null) {
            try {
                list = assets.list("hme/document");
            } catch (IOException e) {
                Log.e(TAG, "SPenMathResourceExtractor::copyDocLsModelFilesFromAssets() Failed to get asset file list.", e);
                list = null;
            }
        } else {
            list = null;
        }
        if (list == null) {
            Log.e(TAG, "SPenMathResourceExtractor::copyDocLsModelFilesFromAssets() files == null");
            return null;
        }
        File file = new File(getStorageDir(resContext), "hme/document");
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (Exception e2) {
                Log.e(TAG, "SPenMathResourceExtractor::copyDocLsModelFilesFromAssets() mkdir failed.", e2);
            }
        }
        String strM12320e = AbstractC11014a.m12320e(getStorageDir(resContext), "/hme/document");
        Iterator it = ArrayIteratorKt.iterator(list);
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (Intrinsics.areEqual((String) it.next(), MATH_DOC_LS_MODEL_NAME)) {
                strM756B = AbstractC0541b.m756B(strM12320e, "/math_ls_model.bin");
                if (assets != null) {
                    INSTANCE.copyFile(assets, "hme/document/math_ls_model.bin", strM756B);
                }
                Log.d(TAG, "SPenMathResourceExtractor::copyDocLsModelFilesFromAssets() " + ((Object) strM756B));
            }
        }
        return strM756B;
    }

    @Nullable
    public final String copyDocModelFilesFromAssets(@Nullable Context resContext) throws Throwable {
        String[] list;
        String strM756B = null;
        AssetManager assets = resContext != null ? resContext.getAssets() : null;
        if (assets != null) {
            try {
                list = assets.list("hme/document");
            } catch (IOException e) {
                Log.e(TAG, "SPenMathResourceExtractor::copyDocModelFilesFromAssets() Failed to get asset file list.", e);
                list = null;
            }
        } else {
            list = null;
        }
        if (list == null) {
            Log.e(TAG, "SPenMathResourceExtractor::copyDocModelFilesFromAssets() files == null");
            return null;
        }
        File file = new File(getStorageDir(resContext), "hme/document");
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (Exception e2) {
                Log.e(TAG, "SPenMathResourceExtractor::copyDocModelFilesFromAssets() mkdir failed.", e2);
            }
        }
        String strM12320e = AbstractC11014a.m12320e(getStorageDir(resContext), "/hme/document");
        Iterator it = ArrayIteratorKt.iterator(list);
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (Intrinsics.areEqual((String) it.next(), MATH_DOC_MODEL_NAME)) {
                strM756B = AbstractC0541b.m756B(strM12320e, "/math_model.bin");
                if (assets != null) {
                    INSTANCE.copyFile(assets, "hme/document/math_model.bin", strM756B);
                }
                Log.d(TAG, "SPenMathResourceExtractor::copyDocModelFilesFromAssets() " + ((Object) strM756B));
            }
        }
        return strM756B;
    }

    @Nullable
    public final String copyModelFilesFromAssets(@Nullable Context resContext) throws Throwable {
        String[] list;
        String str = null;
        AssetManager assets = resContext != null ? resContext.getAssets() : null;
        if (assets != null) {
            try {
                list = assets.list("hme");
            } catch (IOException e) {
                Log.e(TAG, "SPenMathResourceExtractor::copyModelFilesFromAssets() Failed to get asset file list.", e);
                list = null;
            }
        } else {
            list = null;
        }
        if (list == null) {
            Log.e(TAG, "SPenMathResourceExtractor::copyModelFilesFromAssets() files == null");
            return null;
        }
        File file = new File(getStorageDir(resContext), "hme");
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (Exception e2) {
                Log.e(TAG, "SPenMathResourceExtractor::copyModelFilesFromAssets() mkdir failed.", e2);
            }
        }
        String strM12320e = AbstractC11014a.m12320e(getStorageDir(resContext), "/hme");
        Iterator it = ArrayIteratorKt.iterator(list);
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (StringsKt.m14167w(str2, ".dat")) {
                if (assets != null) {
                    INSTANCE.copyFile(assets, AbstractC0541b.m772n("hme/", str2), AbstractC0541b.m757C(strM12320e, "/", str2));
                }
            } else if (StringsKt.m14167w(str2, ".7z")) {
                if (assets != null) {
                    INSTANCE.copyFile(assets, AbstractC0541b.m772n("hme/", str2), AbstractC0541b.m757C(strM12320e, "/", str2));
                }
                str = str2;
            }
        }
        return str == null ? strM12320e : AbstractC0541b.m757C(strM12320e, "/", str);
    }

    private final void copyFile(InputStream inputStream, OutputStream out) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                out.write(bArr, 0, i);
            }
        }
    }
}
