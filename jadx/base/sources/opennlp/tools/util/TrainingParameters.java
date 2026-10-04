package opennlp.tools.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.p217ml.maxent.GISTrainer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TrainingParameters {
    public static final String ALGORITHM_PARAM = "Algorithm";
    public static final int CUTOFF_DEFAULT_VALUE = 5;
    public static final String CUTOFF_PARAM = "Cutoff";
    public static final int ITERATIONS_DEFAULT_VALUE = 100;
    public static final String ITERATIONS_PARAM = "Iterations";
    public static final String THREADS_PARAM = "Threads";
    public static final String TRAINER_TYPE_PARAM = "TrainerType";
    private final Map<String, Object> parameters;

    public TrainingParameters() {
        this.parameters = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    }

    public static TrainingParameters defaultParams() {
        TrainingParameters trainingParameters = new TrainingParameters();
        trainingParameters.put("Algorithm", GISTrainer.MAXENT_VALUE);
        trainingParameters.put("TrainerType", "Event");
        trainingParameters.put("Iterations", 100);
        trainingParameters.put("Cutoff", 5);
        return trainingParameters;
    }

    public static String getKey(String str, String str2) {
        return str == null ? str2 : AbstractC0541b.m757C(str, Extension.DOT, str2);
    }

    private static String getStringValue(Object obj) {
        return obj instanceof Integer ? Integer.toString(((Integer) obj).intValue()) : obj instanceof Double ? Double.toString(((Double) obj).doubleValue()) : obj instanceof Boolean ? Boolean.toString(((Boolean) obj).booleanValue()) : (String) obj;
    }

    public static TrainingParameters setParams(String[] strArr) {
        TrainingParameters trainingParameters = new TrainingParameters();
        trainingParameters.put("Algorithm", GISTrainer.MAXENT_VALUE);
        trainingParameters.put("TrainerType", "Event");
        trainingParameters.put("Iterations", CmdLineUtil.getIntParameter(AbstractC0541b.m772n(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, "Iterations".toLowerCase()), strArr) != null ? CmdLineUtil.getIntParameter(AbstractC0541b.m772n(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, "Iterations".toLowerCase()), strArr).intValue() : 100);
        trainingParameters.put("Cutoff", CmdLineUtil.getIntParameter(AbstractC0541b.m772n(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, "Cutoff".toLowerCase()), strArr) != null ? CmdLineUtil.getIntParameter(AbstractC0541b.m772n(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, "Cutoff".toLowerCase()), strArr).intValue() : 5);
        return trainingParameters;
    }

    public String algorithm(String str) {
        return (String) this.parameters.get(getKey(str, "Algorithm"));
    }

    public boolean getBooleanParameter(String str, boolean z) {
        return getBooleanParameter(null, str, z);
    }

    public double getDoubleParameter(String str, double d) {
        return getDoubleParameter(null, str, d);
    }

    public int getIntParameter(String str, int i) {
        return getIntParameter(null, str, i);
    }

    public Map<String, Object> getObjectSettings(String str) {
        HashMap map = new HashMap();
        String strM756B = AbstractC0541b.m756B(str, Extension.DOT);
        for (Map.Entry<String, Object> entry : this.parameters.entrySet()) {
            String key = entry.getKey();
            if (str != null) {
                if (key.startsWith(strM756B)) {
                    map.put(key.substring(strM756B.length()), entry.getValue());
                }
            } else if (!key.contains(Extension.DOT)) {
                map.put(key, entry.getValue());
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public TrainingParameters getParameters(String str) {
        TrainingParameters trainingParameters = new TrainingParameters();
        for (Map.Entry<String, Object> entry : getObjectSettings(str).entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                trainingParameters.put(key, ((Integer) value).intValue());
            } else if (value instanceof Double) {
                trainingParameters.put(key, ((Double) value).doubleValue());
            } else if (value instanceof Boolean) {
                trainingParameters.put(key, ((Boolean) value).booleanValue());
            } else {
                trainingParameters.put(key, (String) value);
            }
        }
        return trainingParameters;
    }

    public String getStringParameter(String str, String str2) {
        return getStringParameter(null, str, str2);
    }

    public void put(String str, String str2, String str3) {
        this.parameters.put(getKey(str, str2), str3);
    }

    public void putIfAbsent(String str, String str2, String str3) {
        this.parameters.putIfAbsent(getKey(str, str2), str3);
    }

    public void serialize(OutputStream outputStream) throws IOException {
        Properties properties = new Properties();
        properties.putAll(this.parameters);
        properties.store(outputStream, (String) null);
    }

    public String algorithm() {
        return (String) this.parameters.get("Algorithm");
    }

    public boolean getBooleanParameter(String str, String str2, boolean z) {
        Object obj = this.parameters.get(getKey(str, str2));
        if (obj == null) {
            return z;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return Boolean.parseBoolean((String) obj);
        }
    }

    public double getDoubleParameter(String str, String str2, double d) {
        Object obj = this.parameters.get(getKey(str, str2));
        if (obj == null) {
            return d;
        }
        try {
            return ((Double) obj).doubleValue();
        } catch (ClassCastException unused) {
            return Double.parseDouble((String) obj);
        }
    }

    public int getIntParameter(String str, String str2, int i) {
        Object obj = this.parameters.get(getKey(str, str2));
        if (obj == null) {
            return i;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return Integer.parseInt((String) obj);
        }
    }

    public String getStringParameter(String str, String str2, String str3) {
        Object obj = this.parameters.get(getKey(str, str2));
        return obj == null ? str3 : (String) obj;
    }

    public void put(String str, String str2) {
        put((String) null, str, str2);
    }

    public void putIfAbsent(String str, String str2) {
        putIfAbsent((String) null, str, str2);
    }

    public TrainingParameters(TrainingParameters trainingParameters) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.parameters = treeMap;
        treeMap.putAll(trainingParameters.parameters);
    }

    public void put(String str, String str2, int i) {
        this.parameters.put(getKey(str, str2), Integer.valueOf(i));
    }

    public void putIfAbsent(String str, String str2, int i) {
        this.parameters.putIfAbsent(getKey(str, str2), Integer.valueOf(i));
    }

    public void put(String str, int i) {
        put((String) null, str, i);
    }

    public void putIfAbsent(String str, int i) {
        putIfAbsent((String) null, str, i);
    }

    public void put(String str, String str2, double d) {
        this.parameters.put(getKey(str, str2), Double.valueOf(d));
    }

    public void putIfAbsent(String str, String str2, double d) {
        this.parameters.putIfAbsent(getKey(str, str2), Double.valueOf(d));
    }

    public TrainingParameters(Map<String, Object> map) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.parameters = treeMap;
        treeMap.putAll(map);
    }

    public void put(String str, double d) {
        put((String) null, str, d);
    }

    public void putIfAbsent(String str, double d) {
        putIfAbsent((String) null, str, d);
    }

    public void put(String str, String str2, boolean z) {
        this.parameters.put(getKey(str, str2), Boolean.valueOf(z));
    }

    public void putIfAbsent(String str, String str2, boolean z) {
        this.parameters.putIfAbsent(getKey(str, str2), Boolean.valueOf(z));
    }

    public void put(String str, boolean z) {
        put((String) null, str, z);
    }

    public void putIfAbsent(String str, boolean z) {
        putIfAbsent((String) null, str, z);
    }

    public TrainingParameters(InputStream inputStream) throws IOException {
        this.parameters = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Properties properties = new Properties();
        properties.load(inputStream);
        for (Map.Entry entry : properties.entrySet()) {
            this.parameters.put((String) entry.getKey(), entry.getValue());
        }
    }

    public Map<String, Object> getObjectSettings() {
        return getObjectSettings(null);
    }
}
