package androidx.appsearch.util;

import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ExceptionUtil {
    private static final String TAG = "AppSearchExceptionUtil";

    private ExceptionUtil() {
    }

    public static void handleException(Exception exc) {
        if (isItOkayToRethrowException() && (exc instanceof RuntimeException)) {
            rethrowRuntimeException((RuntimeException) exc);
        }
    }

    public static void handleRemoteException(RemoteException remoteException) {
        Log.w(TAG, "Unable to make a call to AppSearchManagerService!", remoteException);
    }

    private static boolean isItOkayToRethrowException() {
        return true;
    }

    private static void rethrowRuntimeException(RuntimeException runtimeException) {
        throw runtimeException;
    }
}
