package opennlp.tools.util.eval;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Mean {
    private long count;
    private double sum;

    public void add(double d) {
        add(d, 1L);
    }

    public long count() {
        return this.count;
    }

    public double mean() {
        long j = this.count;
        if (j > 0) {
            return this.sum / j;
        }
        return 0.0d;
    }

    public String toString() {
        return Double.toString(mean());
    }

    public void add(double d, long j) {
        this.sum = (d * j) + this.sum;
        this.count += j;
    }
}
