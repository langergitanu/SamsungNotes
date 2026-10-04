package opennlp.tools.parser;

import opennlp.tools.chunker.ChunkerContextGenerator;
import opennlp.tools.chunker.ChunkerFactory;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.util.SequenceValidator;
import opennlp.tools.util.TokenTag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParserChunkerFactory extends ChunkerFactory {
    @Override // opennlp.tools.chunker.ChunkerFactory
    public ChunkerContextGenerator getContextGenerator() {
        return new ChunkContextGenerator(10);
    }

    @Override // opennlp.tools.chunker.ChunkerFactory
    public SequenceValidator<TokenTag> getSequenceValidator() {
        MaxentModel maxentModel = (MaxentModel) this.artifactProvider.getArtifact("chunker.model");
        int numOutcomes = maxentModel.getNumOutcomes();
        String[] strArr = new String[numOutcomes];
        for (int i = 0; i < numOutcomes; i++) {
            strArr[i] = maxentModel.getOutcome(i);
        }
        return new ParserChunkerSequenceValidator(strArr);
    }
}
