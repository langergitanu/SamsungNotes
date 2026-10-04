package opennlp.tools.p217ml.naivebayes;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LogProbability<T> extends Probability<T> {
    public LogProbability(T t) {
        super(t);
        set(1.0d);
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probability
    public void addIn(double d) {
        setLog(StrictMath.log(d) + this.probability);
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probability
    public Double get() {
        return Double.valueOf(StrictMath.exp(this.probability));
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probability
    public T getLabel() {
        return this.label;
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probability
    public Double getLog() {
        return Double.valueOf(this.probability);
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probability
    public boolean isLarger(Probability<T> probability) {
        return this.probability < probability.getLog().doubleValue();
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probability
    public void set(double d) {
        this.probability = StrictMath.log(d);
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probability
    public void setIfLarger(double d) {
        double dLog = StrictMath.log(d);
        if (this.probability < dLog) {
            this.probability = dLog;
        }
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probability
    public void setLog(double d) {
        this.probability = d;
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probability
    public String toString() {
        return this.label + ":" + this.probability;
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probability
    public void set(Probability<T> probability) {
        this.probability = probability.getLog().doubleValue();
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probability
    public void setIfLarger(Probability<T> probability) {
        if (this.probability < probability.getLog().doubleValue()) {
            this.probability = probability.getLog().doubleValue();
        }
    }
}
