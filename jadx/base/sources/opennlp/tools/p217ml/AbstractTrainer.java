package opennlp.tools.p217ml;

import java.util.HashMap;
import java.util.Map;
import opennlp.tools.commons.Trainer;
import opennlp.tools.p217ml.maxent.GISTrainer;
import opennlp.tools.util.TrainingParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractTrainer implements Trainer {
    public static final String ALGORITHM_PARAM = "Algorithm";
    public static final int CUTOFF_DEFAULT = 5;
    public static final String CUTOFF_PARAM = "Cutoff";
    public static final int ITERATIONS_DEFAULT = 100;
    public static final String ITERATIONS_PARAM = "Iterations";
    public static final String TRAINER_TYPE_PARAM = "TrainerType";
    protected Map<String, String> reportMap;
    protected TrainingParameters trainingParameters;

    public AbstractTrainer() {
    }

    public void addToReport(String str, String str2) {
        this.reportMap.put(str, str2);
    }

    public String getAlgorithm() {
        return this.trainingParameters.getStringParameter("Algorithm", GISTrainer.MAXENT_VALUE);
    }

    public int getCutoff() {
        return this.trainingParameters.getIntParameter("Cutoff", 5);
    }

    public int getIterations() {
        return this.trainingParameters.getIntParameter("Iterations", 100);
    }

    @Override // opennlp.tools.commons.Trainer
    public void init(TrainingParameters trainingParameters, Map<String, String> map) {
        this.trainingParameters = trainingParameters;
        if (map == null) {
            map = new HashMap<>();
        }
        this.reportMap = map;
    }

    public void validate() {
        try {
            this.trainingParameters.getIntParameter("Cutoff", 5);
            this.trainingParameters.getIntParameter("Iterations", 100);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public AbstractTrainer(TrainingParameters trainingParameters) {
        init(trainingParameters, new HashMap());
    }
}
