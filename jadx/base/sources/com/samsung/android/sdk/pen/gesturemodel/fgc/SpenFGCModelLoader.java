package com.samsung.android.sdk.pen.gesturemodel.fgc;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/gesturemodel/fgc/SpenFGCModelLoader;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mAssetManager", "Landroid/content/res/AssetManager;", "mRootDir", "Ljava/io/File;", "defaultModelBuffer", "", "getDefaultModelBuffer", "()[B", "getModelBuffer", "name", "", "getResourceBuffer", "inStream", "Ljava/io/InputStream;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenFGCModelLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenFGCModelLoader.kt\ncom/samsung/android/sdk/pen/gesturemodel/fgc/SpenFGCModelLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1#2:91\n*E\n"})
public final class SpenFGCModelLoader {

    @NotNull
    private static final String LOG_TAG = "SpenFGCModelLoader";

    @NotNull
    private final AssetManager mAssetManager;

    @NotNull
    private final File mRootDir;

    @NotNull
    private static final String MODEL_NAME = "onnx_GRU_s10_d16_sl3_v1.0_240131.pt";

    @NotNull
    private static final String[] VERSION_TABLE = {MODEL_NAME};

    public SpenFGCModelLoader(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AssetManager assets = context.getApplicationContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
        this.mAssetManager = assets;
        this.mRootDir = new File("fgc_model");
    }

    private final byte[] getResourceBuffer(InputStream inStream) throws Throwable {
        byte[] bArr;
        int iAvailable;
        BufferedInputStream bufferedInputStream = null;
        byte[] bArr2 = null;
        if (inStream == null) {
            Log.e(LOG_TAG, "[JavaFGC] getResourceBuffer : input stream is null!");
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inStream);
            try {
                iAvailable = bufferedInputStream2.available();
                Log.d(LOG_TAG, "[JavaFGC] getResourceBuffer : bufferSize = " + iAvailable);
                bArr = new byte[iAvailable];
            } catch (Throwable th) {
                th = th;
                bArr = null;
            }
            try {
                byte[] bArr3 = new byte[8192];
                int i = 0;
                while (true) {
                    int i2 = bufferedInputStream2.read(bArr3);
                    if (i2 == -1) {
                        break;
                    }
                    System.arraycopy(bArr3, 0, bArr, i, i2);
                    i += i2;
                    Log.e(LOG_TAG, "[JavaFGC] getResourceBuffer : cannot get buffer : " + e.getMessage());
                    e.printStackTrace();
                    return bArr2;
                }
                if (i != iAvailable) {
                    Log.e(LOG_TAG, "[JavaFGC] getResourceBuffer : TotalByte = " + i + " and BufferSize = " + iAvailable + " is different!");
                } else {
                    bArr2 = bArr;
                }
                try {
                    bufferedInputStream2.close();
                    return bArr2;
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        bArr2 = bArr;
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bArr = null;
        }
    }

    @Nullable
    public final byte[] getDefaultModelBuffer() {
        return getModelBuffer(MODEL_NAME);
    }

    @Nullable
    public final byte[] getModelBuffer(@NotNull String name) throws Throwable {
        InputStream inputStreamOpen;
        Intrinsics.checkNotNullParameter(name, "name");
        Log.d(LOG_TAG, "[JavaFGC] Load model: " + name);
        try {
            inputStreamOpen = this.mAssetManager.open(this.mRootDir.getName() + "/" + name);
        } catch (IOException e) {
            AbstractC2322a.m1636z("[JavaFGC] ", e.getMessage(), LOG_TAG);
            inputStreamOpen = null;
        }
        byte[] resourceBuffer = getResourceBuffer(inputStreamOpen);
        if (inputStreamOpen != null) {
            try {
                inputStreamOpen.close();
            } catch (IOException e2) {
                AbstractC2322a.m1636z("[JavaFGC] ", e2.getMessage(), LOG_TAG);
            }
        }
        return resourceBuffer;
    }
}
