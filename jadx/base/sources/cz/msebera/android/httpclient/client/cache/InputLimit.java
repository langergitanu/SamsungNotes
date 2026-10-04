package cz.msebera.android.httpclient.client.cache;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class InputLimit {
    private boolean reached = false;
    private final long value;

    public InputLimit(long j) {
        this.value = j;
    }

    public long getValue() {
        return this.value;
    }

    public boolean isReached() {
        return this.reached;
    }

    public void reached() {
        this.reached = true;
    }
}
