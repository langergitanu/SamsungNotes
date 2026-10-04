package opennlp.tools.p217ml;

import opennlp.tools.p217ml.model.Event;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.p217ml.model.SequenceStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractEventModelSequenceTrainer extends AbstractTrainer implements EventModelSequenceTrainer<Event> {
    public abstract MaxentModel doTrain(SequenceStream<Event> sequenceStream);

    @Override // opennlp.tools.p217ml.EventModelSequenceTrainer
    public final MaxentModel train(SequenceStream<Event> sequenceStream) {
        validate();
        MaxentModel maxentModelDoTrain = doTrain(sequenceStream);
        addToReport("TrainerType", EventModelSequenceTrainer.SEQUENCE_VALUE);
        return maxentModelDoTrain;
    }
}
