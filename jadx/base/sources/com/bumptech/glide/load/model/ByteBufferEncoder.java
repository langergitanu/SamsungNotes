package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class ByteBufferEncoder implements Encoder<ByteBuffer> {
    private static final String TAG = "ByteBufferEncoder";

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull Options options) throws Throwable {
        try {
            ByteBufferUtil.toFile(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable(TAG, 3)) {
                return false;
            }
            Log.d(TAG, "Failed to write data", e);
            return false;
        }
    }
}
