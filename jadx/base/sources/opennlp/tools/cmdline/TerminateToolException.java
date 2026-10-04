package opennlp.tools.cmdline;

import opennlp.tools.commons.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class TerminateToolException extends RuntimeException {
    private static final long serialVersionUID = -8501408388025885818L;
    private final int code;
    private final String message;

    public TerminateToolException(int i, String str, Throwable th) {
        super(th);
        this.code = i;
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public TerminateToolException(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public TerminateToolException(int i) {
        this(i, null);
    }
}
