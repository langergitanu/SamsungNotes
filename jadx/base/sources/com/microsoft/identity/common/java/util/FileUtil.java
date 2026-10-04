package com.microsoft.identity.common.java.util;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class FileUtil {
    private static final String TAG = "FileUtil";

    private FileUtil() {
    }

    public static void deleteFile(@NonNull File file) {
        if (file == null) {
            throw new NullPointerException("file is marked non-null but is null");
        }
        if (file.exists()) {
            StringBuilder sb = new StringBuilder();
            String str = TAG;
            sb.append(str);
            sb.append(":deleteKeyFile");
            Logger.verbose(sb.toString(), "Delete File");
            if (file.delete()) {
                return;
            }
            Logger.verbose(str + ":deleteKeyFile", "Failed to delete file.");
        }
    }

    @Nullable
    public static byte[] readFromFile(@NonNull File file, int i) throws ClientException {
        if (file == null) {
            throw new NullPointerException("file is marked non-null but is null");
        }
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[i];
                while (true) {
                    int i2 = fileInputStream.read(bArr);
                    if (i2 == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        fileInputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        } catch (IOException e) {
            ClientException clientException = new ClientException("io_error", e.getMessage(), e);
            Logger.error(AbstractC0622a.m1170p(TAG, ":readKeyData", new StringBuilder()), clientException.getErrorCode(), e);
            throw clientException;
        }
    }

    public static void writeDataToFile(@NonNull byte[] bArr, @NonNull File file) throws ClientException {
        if (bArr == null) {
            throw new NullPointerException("data is marked non-null but is null");
        }
        if (file == null) {
            throw new NullPointerException("file is marked non-null but is null");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
            } finally {
                fileOutputStream.close();
            }
        } catch (IOException e) {
            ClientException clientException = new ClientException("io_error", e.getMessage(), e);
            Logger.error(AbstractC0622a.m1170p(TAG, ":writeKeyData", new StringBuilder()), clientException.getErrorCode(), e);
            throw clientException;
        }
    }
}
