package androidx.work;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.AbstractC2322a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class Logger {
    private static final int MAX_PREFIXED_TAG_LENGTH = 20;
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG_PREFIX = "WM-";
    private static final Object sLock = new Object();
    private static volatile Logger sLogger;

    public Logger(int i) {
    }

    @NonNull
    public static Logger get() {
        Logger logger;
        synchronized (sLock) {
            try {
                if (sLogger == null) {
                    sLogger = new LogcatLogger(3);
                }
                logger = sLogger;
            } catch (Throwable th) {
                throw th;
            }
        }
        return logger;
    }

    public static void setLogger(@NonNull Logger logger) {
        synchronized (sLock) {
            sLogger = logger;
        }
    }

    @NonNull
    public static String tagWithPrefix(@NonNull String str) {
        int length = str.length();
        StringBuilder sbM1627q = AbstractC2322a.m1627q(23, TAG_PREFIX);
        int i = MAX_PREFIXED_TAG_LENGTH;
        if (length >= i) {
            sbM1627q.append(str.substring(0, i));
        } else {
            sbM1627q.append(str);
        }
        return sbM1627q.toString();
    }

    public abstract void debug(@NonNull String str, @NonNull String str2);

    public abstract void debug(@NonNull String str, @NonNull String str2, @NonNull Throwable th);

    public abstract void error(@NonNull String str, @NonNull String str2);

    public abstract void error(@NonNull String str, @NonNull String str2, @NonNull Throwable th);

    public abstract void info(@NonNull String str, @NonNull String str2);

    public abstract void info(@NonNull String str, @NonNull String str2, @NonNull Throwable th);

    public abstract void verbose(@NonNull String str, @NonNull String str2);

    public abstract void verbose(@NonNull String str, @NonNull String str2, @NonNull Throwable th);

    public abstract void warning(@NonNull String str, @NonNull String str2);

    public abstract void warning(@NonNull String str, @NonNull String str2, @NonNull Throwable th);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LogcatLogger extends Logger {
        private final int mLoggingLevel;

        public LogcatLogger(int i) {
            super(i);
            this.mLoggingLevel = i;
        }

        @Override // androidx.work.Logger
        public void debug(@NonNull String str, @NonNull String str2) {
            if (this.mLoggingLevel <= 3) {
                Log.d(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public void error(@NonNull String str, @NonNull String str2) {
            if (this.mLoggingLevel <= 6) {
                Log.e(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public void info(@NonNull String str, @NonNull String str2) {
            if (this.mLoggingLevel <= 4) {
                Log.i(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public void verbose(@NonNull String str, @NonNull String str2) {
            if (this.mLoggingLevel <= 2) {
                Log.v(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public void warning(@NonNull String str, @NonNull String str2) {
            if (this.mLoggingLevel <= 5) {
                Log.w(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public void debug(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
            if (this.mLoggingLevel <= 3) {
                Log.d(str, str2, th);
            }
        }

        @Override // androidx.work.Logger
        public void error(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
            if (this.mLoggingLevel <= 6) {
                Log.e(str, str2, th);
            }
        }

        @Override // androidx.work.Logger
        public void info(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
            if (this.mLoggingLevel <= 4) {
                Log.i(str, str2, th);
            }
        }

        @Override // androidx.work.Logger
        public void verbose(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
            if (this.mLoggingLevel <= 2) {
                Log.v(str, str2, th);
            }
        }

        @Override // androidx.work.Logger
        public void warning(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
            if (this.mLoggingLevel <= 5) {
                Log.w(str, str2, th);
            }
        }
    }
}
