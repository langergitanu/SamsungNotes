package androidx.test.platform.device;

import androidx.test.platform.TestFrameworkException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class UnsupportedDeviceOperationException extends RuntimeException implements TestFrameworkException {
    public UnsupportedDeviceOperationException(String str) {
        super(str);
    }

    public UnsupportedDeviceOperationException(String str, Throwable th) {
        super(str, th);
    }
}
