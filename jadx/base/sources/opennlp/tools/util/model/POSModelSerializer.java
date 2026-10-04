package opennlp.tools.util.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import opennlp.tools.p217ml.BeamSearch;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.util.Version;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSModelSerializer implements ArtifactSerializer<POSModel> {
    @Override // opennlp.tools.util.model.ArtifactSerializer
    public POSModel create(InputStream inputStream) {
        POSModel pOSModel = new POSModel(new UncloseableInputStream(inputStream));
        Version version = pOSModel.getVersion();
        if (version.getMajor() != 1 || version.getMinor() != 5 || pOSModel.getManifestProperty(BeamSearch.BEAM_SIZE_PARAMETER) != null) {
            return pOSModel;
        }
        HashMap map = new HashMap();
        map.put("OpenNLP-Version", "1.5.0");
        return new POSModel(pOSModel.getLanguage(), (MaxentModel) pOSModel.getArtifact("pos.model"), 10, map, pOSModel.getFactory());
    }

    @Override // opennlp.tools.util.model.ArtifactSerializer
    public void serialize(POSModel pOSModel, OutputStream outputStream) throws IOException {
        pOSModel.serialize(outputStream);
    }
}
