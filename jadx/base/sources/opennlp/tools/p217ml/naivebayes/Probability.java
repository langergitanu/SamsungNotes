package opennlp.tools.p217ml.naivebayes;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Probability<T> {
    protected final T label;
    protected double probability = 1.0d;

    public Probability(T t) {
        this.label = t;
    }

    public void addIn(double d) {
        set(this.probability * d);
    }

    public Double get() {
        return Double.valueOf(this.probability);
    }

    public T getLabel() {
        return this.label;
    }

    public Double getLog() {
        return Double.valueOf(StrictMath.log(get().doubleValue()));
    }

    public boolean isLarger(Probability<T> probability) {
        return this.probability < probability.get().doubleValue();
    }

    public void set(double d) {
        this.probability = d;
    }

    public void setIfLarger(double d) {
        if (this.probability < d) {
            this.probability = d;
        }
    }

    public void setLog(double d) {
        set(StrictMath.exp(d));
    }

    public String toString() {
        T t = this.label;
        if (t == null) {
            double d = this.probability;
            StringBuilder sb = new StringBuilder();
            sb.append(d);
            return sb.toString();
        }
        return t + ":" + this.probability;
    }

    public void set(Probability<T> probability) {
        this.probability = probability.get().doubleValue();
    }

    public void setIfLarger(Probability<T> probability) {
        if (this.probability < probability.get().doubleValue()) {
            this.probability = probability.get().doubleValue();
        }
    }
}
