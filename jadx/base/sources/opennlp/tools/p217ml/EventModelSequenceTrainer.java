package opennlp.tools.p217ml;

import opennlp.tools.commons.Trainer;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.p217ml.model.SequenceStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface EventModelSequenceTrainer<T> extends Trainer {
    public static final String SEQUENCE_VALUE = "EventModelSequence";

    MaxentModel train(SequenceStream<T> sequenceStream);
}
