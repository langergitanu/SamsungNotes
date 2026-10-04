package junit.runner;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface TestRunListener {
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_FAILURE = 2;

    void testEnded(String str);

    void testFailed(int i, String str, String str2);

    void testRunEnded(long j);

    void testRunStarted(String str, int i);

    void testRunStopped(long j);

    void testStarted(String str);
}
