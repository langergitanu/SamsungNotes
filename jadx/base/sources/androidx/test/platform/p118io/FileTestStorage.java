package androidx.test.platform.p118io;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.test.platform.app.InstrumentationRegistry;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class FileTestStorage implements PlatformTestStorage {
    private static final String TAG = "FileTestStorage";
    private final TestDirCalculator testDirCalculator = new TestDirCalculator();

    @Override // androidx.test.platform.p118io.PlatformTestStorage
    public void addOutputProperties(Map<String, Serializable> map) {
        Log.w(TAG, "Output properties is not supported.");
    }

    @Override // androidx.test.platform.p118io.PlatformTestStorage
    public String getInputArg(String str) {
        return InstrumentationRegistry.getArguments().getString(str);
    }

    @Override // androidx.test.platform.p118io.PlatformTestStorage
    public Map<String, String> getInputArgs() {
        HashMap map = new HashMap();
        Bundle arguments = InstrumentationRegistry.getArguments();
        for (String str : arguments.keySet()) {
            map.put(str, arguments.getString(str));
        }
        return map;
    }

    @Override // androidx.test.platform.p118io.PlatformTestStorage
    public Uri getInputFileUri(@NonNull String str) {
        return Uri.fromFile(new File(this.testDirCalculator.getInputDir(), str));
    }

    @Override // androidx.test.platform.p118io.PlatformTestStorage
    public Uri getOutputFileUri(@NonNull String str) {
        return Uri.fromFile(new File(this.testDirCalculator.getOutputDir(), str));
    }

    @Override // androidx.test.platform.p118io.PlatformTestStorage
    public Map<String, Serializable> getOutputProperties() {
        Log.w(TAG, "Output properties is not supported.");
        return Collections.EMPTY_MAP;
    }

    @Override // androidx.test.platform.p118io.PlatformTestStorage
    public boolean isTestStorageFilePath(@NonNull String str) {
        return str.startsWith(this.testDirCalculator.getOutputDir().getAbsolutePath());
    }

    @Override // androidx.test.platform.p118io.PlatformTestStorage
    public InputStream openInputFile(String str) {
        return new FileInputStream(new File(this.testDirCalculator.getInputDir(), str));
    }

    @Override // androidx.test.platform.p118io.PlatformTestStorage
    public InputStream openInternalInputFile(String str) {
        return openInputFile(str);
    }

    @Override // androidx.test.platform.p118io.PlatformTestStorage
    public OutputStream openInternalOutputFile(String str) {
        return openOutputFile(str);
    }

    @Override // androidx.test.platform.p118io.PlatformTestStorage
    public OutputStream openOutputFile(String str) {
        return openOutputFile(str, false);
    }

    @Override // androidx.test.platform.p118io.PlatformTestStorage
    public OutputStream openOutputFile(String str, boolean z) throws FileNotFoundException {
        File file = new File(this.testDirCalculator.getOutputDir(), str);
        Log.d("FileTestStorage", "openOutputFile from " + file.getAbsolutePath());
        if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
            return new FileOutputStream(file, z);
        }
        throw new FileNotFoundException("Failed to create output dir " + file.getParentFile().getAbsolutePath());
    }
}
