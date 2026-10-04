package opennlp.tools.p217ml;

import opennlp.tools.p217ml.model.AbstractDataIndexer;
import opennlp.tools.p217ml.model.ChecksumEventStream;
import opennlp.tools.p217ml.model.DataIndexer;
import opennlp.tools.p217ml.model.DataIndexerFactory;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.util.InsufficientTrainingDataException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.BaseModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractEventTrainer extends AbstractTrainer implements EventTrainer {
    public static final String DATA_INDEXER_ONE_PASS_REAL_VALUE = "OnePassRealValue";
    public static final String DATA_INDEXER_ONE_PASS_VALUE = "OnePass";
    public static final String DATA_INDEXER_PARAM = "DataIndexer";
    public static final String DATA_INDEXER_TWO_PASS_VALUE = "TwoPass";

    public AbstractEventTrainer() {
    }

    public abstract MaxentModel doTrain(DataIndexer dataIndexer);

    public DataIndexer getDataIndexer(ObjectStream<Event> objectStream) {
        this.trainingParameters.put(AbstractDataIndexer.SORT_PARAM, isSortAndMerge());
        if (this.trainingParameters.getIntParameter("Cutoff", -1) == -1) {
            this.trainingParameters.put("Cutoff", 5);
        }
        DataIndexer dataIndexer = DataIndexerFactory.getDataIndexer(this.trainingParameters, this.reportMap);
        dataIndexer.index(objectStream);
        return dataIndexer;
    }

    public abstract boolean isSortAndMerge();

    @Override // opennlp.tools.p217ml.EventTrainer
    public final MaxentModel train(DataIndexer dataIndexer) throws InsufficientTrainingDataException {
        validate();
        if (dataIndexer.getOutcomeLabels().length <= 1) {
            throw new InsufficientTrainingDataException("Training data must contain more than one outcome");
        }
        MaxentModel maxentModelDoTrain = doTrain(dataIndexer);
        addToReport("TrainerType", "Event");
        return maxentModelDoTrain;
    }

    @Override // opennlp.tools.p217ml.AbstractTrainer
    public void validate() {
        super.validate();
    }

    public AbstractEventTrainer(TrainingParameters trainingParameters) {
        super(trainingParameters);
    }

    @Override // opennlp.tools.p217ml.EventTrainer
    public final MaxentModel train(ObjectStream<Event> objectStream) {
        validate();
        ChecksumEventStream checksumEventStream = new ChecksumEventStream(objectStream);
        DataIndexer dataIndexer = getDataIndexer(checksumEventStream);
        addToReport(BaseModel.TRAINING_EVENTHASH_PROPERTY, String.valueOf(checksumEventStream.calculateChecksum()));
        return train(dataIndexer);
    }
}
