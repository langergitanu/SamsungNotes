package opennlp.tools.util.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.parser.ParserChunkerFactory;
import opennlp.tools.util.Version;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkerModelSerializer implements ArtifactSerializer<ChunkerModel> {
    @Override // opennlp.tools.util.model.ArtifactSerializer
    public ChunkerModel create(InputStream inputStream) {
        ChunkerModel chunkerModel = new ChunkerModel(new UncloseableInputStream(inputStream));
        Version version = chunkerModel.getVersion();
        return (version.getMajor() == 1 && version.getMinor() == 5) ? new ChunkerModel(chunkerModel.getLanguage(), (MaxentModel) chunkerModel.getArtifact("chunker.model"), new ParserChunkerFactory()) : chunkerModel;
    }

    @Override // opennlp.tools.util.model.ArtifactSerializer
    public void serialize(ChunkerModel chunkerModel, OutputStream outputStream) throws IOException {
        chunkerModel.serialize(outputStream);
    }
}
