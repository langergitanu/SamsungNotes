package androidx.test.platform.p118io;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public interface PlatformTestStorage {
    void addOutputProperties(Map<String, Serializable> map);

    String getInputArg(String str);

    Map<String, String> getInputArgs();

    Uri getInputFileUri(@NonNull String str);

    Uri getOutputFileUri(@NonNull String str);

    Map<String, Serializable> getOutputProperties();

    boolean isTestStorageFilePath(@NonNull String str);

    InputStream openInputFile(String str);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    default InputStream openInternalInputFile(String str) {
        return openInputFile(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    default OutputStream openInternalOutputFile(String str) {
        return openOutputFile(str);
    }

    OutputStream openOutputFile(String str);

    OutputStream openOutputFile(String str, boolean z);
}
