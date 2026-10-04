package junit.framework;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class AssertionFailedError extends AssertionError {
    private static final long serialVersionUID = 1;

    public AssertionFailedError() {
    }

    private static String defaultString(String str) {
        return str == null ? "" : str;
    }

    public AssertionFailedError(String str) {
        super(defaultString(str));
    }
}
