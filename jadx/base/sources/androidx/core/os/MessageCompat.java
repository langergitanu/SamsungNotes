package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Message;
import androidx.annotation.RequiresApi;
import com.microsoft.identity.common.java.WarningType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(22)
    public static class Api22Impl {
        private Api22Impl() {
        }

        public static boolean isAsynchronous(Message message) {
            return message.isAsynchronous();
        }

        public static void setAsynchronous(Message message, boolean z) {
            message.setAsynchronous(z);
        }
    }

    private MessageCompat() {
    }

    @SuppressLint({WarningType.NewApi})
    public static boolean isAsynchronous(Message message) {
        return Api22Impl.isAsynchronous(message);
    }

    @SuppressLint({WarningType.NewApi})
    public static void setAsynchronous(Message message, boolean z) {
        Api22Impl.setAsynchronous(message, z);
    }
}
