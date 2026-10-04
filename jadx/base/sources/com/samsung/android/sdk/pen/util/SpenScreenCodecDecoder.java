package com.samsung.android.sdk.pen.util;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0086 J\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0086 ¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenScreenCodecDecoder;", "", "<init>", "()V", "getDrawable", "Landroid/graphics/drawable/Drawable;", "res", "Landroid/content/res/Resources;", "id", "", "decodeFile", "Landroid/graphics/Bitmap;", "filepath", "", "decodeStream", "stream", "Ljava/io/InputStream;", "decode_file", "decode_stream", "buffer", "", "length", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenScreenCodecDecoder {

    @NotNull
    public static final SpenScreenCodecDecoder INSTANCE = new SpenScreenCodecDecoder();

    private SpenScreenCodecDecoder() {
    }

    @JvmStatic
    @Nullable
    public static final Bitmap decodeStream(@Nullable InputStream stream) {
        if (stream == null) {
            Log.e("SpenScreenCodecDecoder", "stream is null");
            return null;
        }
        try {
            try {
                int iAvailable = stream.available();
                byte[] bArr = new byte[iAvailable];
                if (stream.read(bArr) != iAvailable) {
                    stream.close();
                    throw new IOException("Failed to read stream");
                }
                try {
                    stream.close();
                    return (bArr[4] == -86 && bArr[5] == 1) ? INSTANCE.decode_stream(bArr, iAvailable) : BitmapFactory.decodeByteArray(bArr, 0, iAvailable);
                } catch (IOException unused) {
                    return null;
                }
            } catch (IOException unused2) {
            }
        } catch (IOException unused3) {
            stream.close();
        }
        return null;
    }

    @JvmStatic
    @SuppressLint({"UseCompatLoadingForDrawables"})
    @Nullable
    public static final Drawable getDrawable(@NotNull Resources res, int id) {
        Intrinsics.checkNotNullParameter(res, "res");
        try {
            InputStream inputStreamOpenRawResource = res.openRawResource(id);
            try {
                try {
                    byte[] bArr = new byte[6];
                    if (inputStreamOpenRawResource.read(bArr) != 6) {
                        Log.e("SpenScreenCodecDecoder", "Failed to read stream 1.");
                        inputStreamOpenRawResource.close();
                        return null;
                    }
                    inputStreamOpenRawResource.close();
                    try {
                        InputStream inputStreamOpenRawResource2 = res.openRawResource(id);
                        if (bArr[4] != -86 || bArr[5] != 1) {
                            try {
                                try {
                                    Drawable drawable = res.getDrawable(id);
                                    if (drawable != null) {
                                        inputStreamOpenRawResource2.close();
                                        try {
                                            return drawable;
                                        } catch (IOException e) {
                                            return drawable;
                                        }
                                    }
                                } finally {
                                    try {
                                        inputStreamOpenRawResource2.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } catch (Resources.NotFoundException e3) {
                                e3.printStackTrace();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                            try {
                                inputStreamOpenRawResource2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                            Log.e("SpenScreenCodecDecoder", "fail to getDrawable.");
                            return null;
                        }
                        try {
                            try {
                                int iAvailable = inputStreamOpenRawResource2.available();
                                byte[] bArr2 = new byte[iAvailable];
                                if (inputStreamOpenRawResource2.read(bArr2) != iAvailable) {
                                    Log.e("SpenScreenCodecDecoder", "Failed to read stream. length = " + iAvailable);
                                    inputStreamOpenRawResource2.close();
                                    return null;
                                }
                                inputStreamOpenRawResource2.close();
                                Bitmap bitmapDecode_stream = INSTANCE.decode_stream(bArr2, iAvailable);
                                if (bitmapDecode_stream != null) {
                                    return new BitmapDrawable(res, bitmapDecode_stream);
                                }
                                Log.e("SpenScreenCodecDecoder", "Failed to create the bitmap");
                                return null;
                            } catch (IOException unused) {
                                inputStreamOpenRawResource2.close();
                                return null;
                            }
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            return null;
                        }
                    } catch (Resources.NotFoundException e8) {
                        e8.printStackTrace();
                        return null;
                    }
                } catch (IOException e9) {
                    e9.printStackTrace();
                    return null;
                }
            } catch (IOException unused2) {
                inputStreamOpenRawResource.close();
                return null;
            }
        } catch (Resources.NotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final Bitmap decodeFile(@Nullable String filepath) {
        return decode_file(filepath);
    }

    @Nullable
    public final native Bitmap decode_file(@Nullable String filepath);

    @Nullable
    public final native Bitmap decode_stream(@Nullable byte[] buffer, int length);
}
