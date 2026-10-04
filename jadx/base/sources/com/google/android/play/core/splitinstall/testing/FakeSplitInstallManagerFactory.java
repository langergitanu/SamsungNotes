package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.C5309k;
import com.google.android.play.core.splitinstall.C5315p;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class FakeSplitInstallManagerFactory {

    /* JADX INFO: renamed from: a */
    @Nullable
    private static FakeSplitInstallManager f3168a;

    public static FakeSplitInstallManager create(Context context) {
        try {
            File fileMo4130b = C5309k.m4139a(context).mo4130b();
            if (fileMo4130b == null) {
                throw new LocalTestingException("Failed to retrieve local testing directory path");
            }
            if (fileMo4130b.exists()) {
                return create(context, fileMo4130b);
            }
            throw new LocalTestingException(String.format("Local testing directory not found: %s", fileMo4130b));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static FakeSplitInstallManager createNewInstance(Context context, File file) {
        SplitCompat.install(context);
        return new FakeSplitInstallManager(context, file, new C5315p(context, context.getPackageName()));
    }

    public static synchronized FakeSplitInstallManager create(Context context, File file) {
        try {
            FakeSplitInstallManager fakeSplitInstallManager = f3168a;
            if (fakeSplitInstallManager == null) {
                f3168a = createNewInstance(context, file);
            } else if (!fakeSplitInstallManager.m4171a().getAbsolutePath().equals(file.getAbsolutePath())) {
                throw new RuntimeException("Different module directories used to initialize FakeSplitInstallManager: '" + f3168a.m4171a().getAbsolutePath() + "' and '" + file.getAbsolutePath() + "'");
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3168a;
    }
}
