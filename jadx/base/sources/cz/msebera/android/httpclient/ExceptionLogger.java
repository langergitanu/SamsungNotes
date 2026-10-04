package cz.msebera.android.httpclient;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ExceptionLogger {
    public static final ExceptionLogger NO_OP = new ExceptionLogger() { // from class: cz.msebera.android.httpclient.ExceptionLogger.1
        @Override // cz.msebera.android.httpclient.ExceptionLogger
        public void log(Exception exc) {
        }
    };
    public static final ExceptionLogger STD_ERR = new ExceptionLogger() { // from class: cz.msebera.android.httpclient.ExceptionLogger.2
        @Override // cz.msebera.android.httpclient.ExceptionLogger
        public void log(Exception exc) {
            exc.printStackTrace();
        }
    };

    void log(Exception exc);
}
