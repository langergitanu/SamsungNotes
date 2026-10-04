package opennlp.tools.util.model;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import opennlp.tools.commons.Internal;
import opennlp.tools.p217ml.maxent.GISTrainer;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.GenericModelWriter;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.util.TrainingParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ModelUtil {
    private ModelUtil() {
    }

    public static void addCutoffAndIterations(Map<String, String> map, int i, int i2) {
        map.put(BaseModel.TRAINING_CUTOFF_PROPERTY, Integer.toString(i));
        map.put(BaseModel.TRAINING_ITERATIONS_PROPERTY, Integer.toString(i2));
    }

    @Internal
    public static TrainingParameters createDefaultTrainingParameters() {
        TrainingParameters trainingParameters = new TrainingParameters();
        trainingParameters.put("Algorithm", GISTrainer.MAXENT_VALUE);
        trainingParameters.put("Iterations", 100);
        trainingParameters.put("Cutoff", 5);
        return trainingParameters;
    }

    public static byte[] read(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static boolean validateOutcomes(MaxentModel maxentModel, String... strArr) {
        if (strArr.length != maxentModel.getNumOutcomes()) {
            return false;
        }
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        for (int i = 0; i < maxentModel.getNumOutcomes(); i++) {
            if (!hashSet.contains(maxentModel.getOutcome(i))) {
                return false;
            }
        }
        return true;
    }

    public static void writeModel(MaxentModel maxentModel, final OutputStream outputStream) {
        Objects.requireNonNull(maxentModel, "model parameter must not be null");
        Objects.requireNonNull(outputStream, "out parameter must not be null");
        new GenericModelWriter((AbstractModel) maxentModel, new DataOutputStream(new OutputStream() { // from class: opennlp.tools.util.model.ModelUtil.1
            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                outputStream.write(i);
            }
        })).persist();
    }
}
