package opennlp.tools.p217ml;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import opennlp.tools.commons.Trainer;
import opennlp.tools.p217ml.maxent.GISTrainer;
import opennlp.tools.p217ml.maxent.quasinewton.QNTrainer;
import opennlp.tools.p217ml.naivebayes.NaiveBayesTrainer;
import opennlp.tools.p217ml.perceptron.PerceptronTrainer;
import opennlp.tools.p217ml.perceptron.SimplePerceptronSequenceTrainer;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.ext.ExtensionLoader;
import opennlp.tools.util.ext.ExtensionNotLoadedException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TrainerFactory {
    private static final Map<String, Class<? extends Trainer>> BUILTIN_TRAINERS;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TrainerType {
        EVENT_MODEL_TRAINER,
        EVENT_MODEL_SEQUENCE_TRAINER,
        SEQUENCE_TRAINER
    }

    static {
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry(GISTrainer.MAXENT_VALUE, GISTrainer.class), new AbstractMap.SimpleEntry(QNTrainer.MAXENT_QN_VALUE, QNTrainer.class), new AbstractMap.SimpleEntry(PerceptronTrainer.PERCEPTRON_VALUE, PerceptronTrainer.class), new AbstractMap.SimpleEntry(SimplePerceptronSequenceTrainer.PERCEPTRON_SEQUENCE_VALUE, SimplePerceptronSequenceTrainer.class), new AbstractMap.SimpleEntry(NaiveBayesTrainer.NAIVE_BAYES_VALUE, NaiveBayesTrainer.class)};
        HashMap map = new HashMap(5);
        for (int i = 0; i < 5; i++) {
            Map.Entry entry = entryArr[i];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (map.put(key, value) != null) {
                throw new IllegalArgumentException(AbstractC0541b.m769k(key, "duplicate key: "));
            }
        }
        BUILTIN_TRAINERS = Collections.unmodifiableMap(map);
    }

    private static <T extends Trainer> T createBuiltinTrainer(Class<? extends Trainer> cls) {
        if (cls == null) {
            return null;
        }
        try {
            return (T) cls.getConstructor(null).newInstance(null);
        } catch (Exception e) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("Could not instantiate the ", cls.getCanonicalName(), ". The initialization threw an exception."), e);
        }
    }

    public static <T> EventModelSequenceTrainer<T> getEventModelSequenceTrainer(TrainingParameters trainingParameters, Map<String, String> map) {
        String stringParameter = trainingParameters.getStringParameter("Algorithm", null);
        if (stringParameter == null) {
            throw new IllegalArgumentException("Trainer type couldn't be determined!");
        }
        Map<String, Class<? extends Trainer>> map2 = BUILTIN_TRAINERS;
        EventModelSequenceTrainer<T> eventModelSequenceTrainer = map2.containsKey(stringParameter) ? (EventModelSequenceTrainer) createBuiltinTrainer(map2.get(stringParameter)) : (EventModelSequenceTrainer) ExtensionLoader.instantiateExtension(EventModelSequenceTrainer.class, stringParameter);
        eventModelSequenceTrainer.init(trainingParameters, map);
        return eventModelSequenceTrainer;
    }

    public static EventTrainer getEventTrainer(TrainingParameters trainingParameters, Map<String, String> map) {
        String stringParameter = trainingParameters.getStringParameter("Algorithm", GISTrainer.MAXENT_VALUE);
        Map<String, Class<? extends Trainer>> map2 = BUILTIN_TRAINERS;
        EventTrainer eventTrainer = map2.containsKey(stringParameter) ? (EventTrainer) createBuiltinTrainer(map2.get(stringParameter)) : (EventTrainer) ExtensionLoader.instantiateExtension(EventTrainer.class, stringParameter);
        eventTrainer.init(trainingParameters, map);
        return eventTrainer;
    }

    public static SequenceTrainer getSequenceModelTrainer(TrainingParameters trainingParameters, Map<String, String> map) {
        String stringParameter = trainingParameters.getStringParameter("Algorithm", null);
        if (stringParameter == null) {
            throw new IllegalArgumentException("Trainer type couldn't be determined!");
        }
        Map<String, Class<? extends Trainer>> map2 = BUILTIN_TRAINERS;
        SequenceTrainer sequenceTrainer = map2.containsKey(stringParameter) ? (SequenceTrainer) createBuiltinTrainer(map2.get(stringParameter)) : (SequenceTrainer) ExtensionLoader.instantiateExtension(SequenceTrainer.class, stringParameter);
        sequenceTrainer.init(trainingParameters, map);
        return sequenceTrainer;
    }

    public static TrainerType getTrainerType(TrainingParameters trainingParameters) {
        String stringParameter = trainingParameters.getStringParameter("Algorithm", null);
        if (stringParameter == null) {
            return TrainerType.EVENT_MODEL_TRAINER;
        }
        Class<? extends Trainer> cls = BUILTIN_TRAINERS.get(stringParameter);
        if (cls != null) {
            if (EventTrainer.class.isAssignableFrom(cls)) {
                return TrainerType.EVENT_MODEL_TRAINER;
            }
            if (EventModelSequenceTrainer.class.isAssignableFrom(cls)) {
                return TrainerType.EVENT_MODEL_SEQUENCE_TRAINER;
            }
            if (SequenceTrainer.class.isAssignableFrom(cls)) {
                return TrainerType.SEQUENCE_TRAINER;
            }
        }
        try {
            try {
                try {
                    ExtensionLoader.instantiateExtension(EventTrainer.class, stringParameter);
                    return TrainerType.EVENT_MODEL_TRAINER;
                } catch (ExtensionNotLoadedException unused) {
                    ExtensionLoader.instantiateExtension(SequenceTrainer.class, stringParameter);
                    return TrainerType.SEQUENCE_TRAINER;
                }
            } catch (ExtensionNotLoadedException unused2) {
                ExtensionLoader.instantiateExtension(EventModelSequenceTrainer.class, stringParameter);
                return TrainerType.EVENT_MODEL_SEQUENCE_TRAINER;
            }
        } catch (ExtensionNotLoadedException unused3) {
            return null;
        }
    }

    public static boolean isValid(TrainingParameters trainingParameters) {
        String stringParameter = trainingParameters.getStringParameter("Algorithm", null);
        if (stringParameter != null && !BUILTIN_TRAINERS.containsKey(stringParameter) && getTrainerType(trainingParameters) == null) {
            return false;
        }
        try {
            trainingParameters.getIntParameter("Cutoff", 0);
            trainingParameters.getIntParameter("Iterations", 0);
            trainingParameters.getStringParameter(AbstractEventTrainer.DATA_INDEXER_PARAM, null);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
