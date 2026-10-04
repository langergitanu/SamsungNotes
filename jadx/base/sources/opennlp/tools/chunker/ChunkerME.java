package opennlp.tools.chunker;

import java.util.HashMap;
import opennlp.tools.p217ml.BeamSearch;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.p217ml.model.SequenceClassificationModel;
import opennlp.tools.util.DownloadUtil;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Sequence;
import opennlp.tools.util.SequenceValidator;
import opennlp.tools.util.Span;
import opennlp.tools.util.TokenTag;
import opennlp.tools.util.TrainingParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkerME implements Chunker {
    public static final int DEFAULT_BEAM_SIZE = 10;
    private Sequence bestSequence;
    private final ChunkerContextGenerator contextGenerator;
    private final SequenceClassificationModel model;
    private final SequenceValidator<TokenTag> sequenceValidator;

    public ChunkerME(String str) {
        this((ChunkerModel) DownloadUtil.downloadModel(str, DownloadUtil.ModelType.CHUNKER, ChunkerModel.class));
    }

    public static ChunkerModel train(String str, ObjectStream<ChunkSample> objectStream, TrainingParameters trainingParameters, ChunkerFactory chunkerFactory) {
        MaxentModel maxentModelTrain;
        int intParameter = trainingParameters.getIntParameter(BeamSearch.BEAM_SIZE_PARAMETER, 10);
        HashMap map = new HashMap();
        TrainerFactory.TrainerType trainerType = TrainerFactory.getTrainerType(trainingParameters);
        SequenceClassificationModel sequenceClassificationModelTrain = null;
        if (TrainerFactory.TrainerType.EVENT_MODEL_TRAINER.equals(trainerType)) {
            maxentModelTrain = TrainerFactory.getEventTrainer(trainingParameters, map).train(new ChunkerEventStream(objectStream, chunkerFactory.getContextGenerator()));
        } else {
            if (!TrainerFactory.TrainerType.SEQUENCE_TRAINER.equals(trainerType)) {
                throw new IllegalArgumentException("Trainer type is not supported: " + trainerType);
            }
            maxentModelTrain = null;
            sequenceClassificationModelTrain = TrainerFactory.getSequenceModelTrainer(trainingParameters, map).train(new ChunkSampleSequenceStream(objectStream, chunkerFactory.getContextGenerator()));
        }
        return maxentModelTrain != null ? new ChunkerModel(str, maxentModelTrain, intParameter, map, chunkerFactory) : new ChunkerModel(str, sequenceClassificationModelTrain, map, chunkerFactory);
    }

    @Override // opennlp.tools.chunker.Chunker
    public String[] chunk(String[] strArr, String[] strArr2) {
        Sequence sequenceBestSequence = this.model.bestSequence(TokenTag.create(strArr, strArr2), new Object[0], this.contextGenerator, this.sequenceValidator);
        this.bestSequence = sequenceBestSequence;
        return (String[]) sequenceBestSequence.getOutcomes().toArray(new String[0]);
    }

    @Override // opennlp.tools.chunker.Chunker
    public Span[] chunkAsSpans(String[] strArr, String[] strArr2) {
        return ChunkSample.phrasesAsSpanList(strArr, strArr2, chunk(strArr, strArr2));
    }

    public void probs(double[] dArr) {
        this.bestSequence.getProbs(dArr);
    }

    @Override // opennlp.tools.chunker.Chunker
    public Sequence[] topKSequences(String[] strArr, String[] strArr2) {
        return this.model.bestSequences(10, TokenTag.create(strArr, strArr2), new Object[0], this.contextGenerator, this.sequenceValidator);
    }

    public ChunkerME(ChunkerModel chunkerModel) {
        this.contextGenerator = chunkerModel.getFactory().getContextGenerator();
        this.sequenceValidator = chunkerModel.getFactory().getSequenceValidator();
        if (chunkerModel.getChunkerSequenceModel() != null) {
            this.model = chunkerModel.getChunkerSequenceModel();
        } else {
            this.model = new BeamSearch(10, (MaxentModel) chunkerModel.getArtifact("chunker.model"), 0);
        }
    }

    public double[] probs() {
        return this.bestSequence.getProbs();
    }

    @Override // opennlp.tools.chunker.Chunker
    public Sequence[] topKSequences(String[] strArr, String[] strArr2, double d) {
        return this.model.bestSequences(10, TokenTag.create(strArr, strArr2), new Object[0], d, this.contextGenerator, this.sequenceValidator);
    }
}
