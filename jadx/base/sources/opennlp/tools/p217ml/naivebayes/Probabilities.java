package opennlp.tools.p217ml.naivebayes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class Probabilities<T> {
    protected Map<T, Double> normalised;
    protected final Map<T, Double> map = new HashMap();
    protected transient boolean isNormalised = false;
    protected double confidence = 0.0d;

    private Map<T, Double> normalize() {
        if (this.isNormalised) {
            return this.normalised;
        }
        Map<T, Double> mapCreateMapDataStructure = createMapDataStructure();
        Iterator<Map.Entry<T, Double>> it = this.map.entrySet().iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            Double value = it.next().getValue();
            if (value != null) {
                dDoubleValue = value.doubleValue() + dDoubleValue;
            }
        }
        for (Map.Entry<T, Double> entry : mapCreateMapDataStructure.entrySet()) {
            T key = entry.getKey();
            Double value2 = entry.getValue();
            if (value2 != null) {
                mapCreateMapDataStructure.put(key, Double.valueOf(value2.doubleValue() / dDoubleValue));
            }
        }
        this.normalised = mapCreateMapDataStructure;
        this.isNormalised = true;
        return mapCreateMapDataStructure;
    }

    public void addIn(T t, double d, int i) {
        this.isNormalised = false;
        Double dValueOf = this.map.get(t);
        if (dValueOf == null) {
            dValueOf = Double.valueOf(1.0d);
        }
        this.map.put(t, Double.valueOf(dValueOf.doubleValue() * StrictMath.pow(d, i)));
    }

    public Map<T, Double> createMapDataStructure() {
        return new HashMap();
    }

    public void discardCountsBelow(double d) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<T, Double> entry : this.map.entrySet()) {
            T key = entry.getKey();
            Double value = entry.getValue();
            if (value == null) {
                value = Double.valueOf(0.0d);
            }
            if (value.doubleValue() < d) {
                arrayList.add(key);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.map.remove(it.next());
        }
    }

    public Double get(T t) {
        Double d = normalize().get(t);
        return d == null ? Double.valueOf(0.0d) : d;
    }

    public Map<T, Double> getAll() {
        return normalize();
    }

    public double getConfidence() {
        return this.confidence;
    }

    public Set<T> getKeys() {
        return this.map.keySet();
    }

    public Double getLog(T t) {
        return Double.valueOf(StrictMath.log(get(t).doubleValue()));
    }

    public T getMax() {
        double dDoubleValue = 0.0d;
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

    public double getMaxValue() {
        return get(getMax()).doubleValue();
    }

    public void set(T t, double d) {
        this.isNormalised = false;
        this.map.put(t, Double.valueOf(d));
    }

    public void setConfidence(double d) {
        this.confidence = d;
    }

    public void setIfLarger(T t, double d) {
        Double d2 = this.map.get(t);
        if (d2 == null || d > d2.doubleValue()) {
            this.isNormalised = false;
            this.map.put(t, Double.valueOf(d));
        }
    }

    public void setLog(T t, double d) {
        set(t, StrictMath.exp(d));
    }

    public String toString() {
        return getAll().toString();
    }

    public void set(T t, Probability<T> probability) {
        this.isNormalised = false;
        this.map.put(t, probability.get());
    }
}
