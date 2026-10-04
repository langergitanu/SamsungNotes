package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class CursorWindowCompat {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static CursorWindow createCursorWindow(String str, long j) {
            return new CursorWindow(str, j);
        }
    }

    private CursorWindowCompat() {
    }

    public static CursorWindow create(String str, long j) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.createCursorWindow(str, j) : new CursorWindow(str);
    }
}
