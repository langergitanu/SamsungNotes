package opennlp.tools.p217ml.naivebayes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LogProbabilities<T> extends Probabilities<T> {
    private double log(double d) {
        return StrictMath.log(d);
    }

    private Map<T, Double> normalize() {
        if (this.isNormalised) {
            return this.normalised;
        }
        Map<T, Double> mapCreateMapDataStructure = createMapDataStructure();
        Iterator<Map.Entry<T, Double>> it = this.map.entrySet().iterator();
        double dDoubleValue = Double.NEGATIVE_INFINITY;
        while (it.hasNext()) {
            Double value = it.next().getValue();
            if (value != null && value.doubleValue() > dDoubleValue) {
                dDoubleValue = value.doubleValue();
            }
        }
        double d = 0.0d;
        for (Map.Entry<T, Double> entry : this.map.entrySet()) {
            T key = entry.getKey();
            Double value2 = entry.getValue();
            if (value2 != null) {
                double dExp = StrictMath.exp(value2.doubleValue() - dDoubleValue);
                if (!Double.isNaN(dExp)) {
                    d += dExp;
                    mapCreateMapDataStructure.put(key, Double.valueOf(dExp));
                }
            }
        }
        for (Map.Entry<T, Double> entry2 : mapCreateMapDataStructure.entrySet()) {
            T key2 = entry2.getKey();
            Double value3 = entry2.getValue();
            if (value3 != null && d > Double.MIN_VALUE) {
                mapCreateMapDataStructure.put(key2, Double.valueOf(value3.doubleValue() / d));
            }
        }
        this.normalised = mapCreateMapDataStructure;
        this.isNormalised = true;
        return mapCreateMapDataStructure;
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probabilities
    public void addIn(T t, double d, int i) {
        this.isNormalised = false;
        Double dValueOf = this.map.get(t);
        if (dValueOf == null) {
            dValueOf = Double.valueOf(0.0d);
        }
        this.map.put(t, Double.valueOf(dValueOf.doubleValue() + (log(d) * ((double) i))));
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probabilities
    public void discardCountsBelow(double d) {
        double dLog = StrictMath.log(d);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<T, Double> entry : this.map.entrySet()) {
            T key = entry.getKey();
            Double value = entry.getValue();
            if (value == null) {
                value = Double.valueOf(Double.NEGATIVE_INFINITY);
            }
            if (value.doubleValue() < dLog) {
                arrayList.add(key);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.map.remove(it.next());
        }
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probabilities
    public Double get(T t) {
        Double d = normalize().get(t);
        return d == null ? Double.valueOf(0.0d) : d;
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probabilities
    public Map<T, Double> getAll() {
        return normalize();
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probabilities
    public Double getLog(T t) {
        Double d = this.map.get(t);
        return d == null ? Double.valueOf(Double.NEGATIVE_INFINITY) : d;
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probabilities
    public T getMax() {
        double dDoubleValue = Double.NEGATIVE_INFINITY;
        T t = null;
        for (Map.Entry<T, Double> entry : this.map.entrySet()) {
            T key = entry.getKey();
            Double value = entry.getValue();
            if (value.doubleValue() >= dDoubleValue) {
                dDoubleValue = value.doubleValue();
                t = key;
            }
        }
        return t;
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probabilities
    public void set(T t, double d) {
        this.isNormalised = false;
        this.map.put(t, Double.valueOf(log(d)));
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probabilities
    public void setIfLarger(T t, double d) {
        double dLog = log(d);
        Double d2 = this.map.get(t);
        if (d2 == null || dLog > d2.doubleValue()) {
            this.isNormalised = false;
            this.map.put(t, Double.valueOf(dLog));
        }
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probabilities
    public void setLog(T t, double d) {
        this.isNormalised = false;
        this.map.put(t, Double.valueOf(d));
    }

    @Override // opennlp.tools.p217ml.naivebayes.Probabilities
    public void set(T t, Probability<T> probability) {
        this.isNormalised = false;
        this.map.put(t, probability.getLog());
    }
}
