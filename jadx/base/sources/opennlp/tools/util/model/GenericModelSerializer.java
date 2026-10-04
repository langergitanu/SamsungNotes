package opennlp.tools.util.model;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.BinaryFileDataReader;
import opennlp.tools.p217ml.model.GenericModelReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class GenericModelSerializer implements ArtifactSerializer<AbstractModel> {
    public static void register(Map<String, ArtifactSerializer<?>> map) {
        map.put("model", new GenericModelSerializer());
    }

    @Override // opennlp.tools.util.model.ArtifactSerializer
    public AbstractModel create(InputStream inputStream) {
        return new GenericModelReader(new BinaryFileDataReader(inputStream)).getModel();
    }

    @Override // opennlp.tools.util.model.ArtifactSerializer
    public void serialize(AbstractModel abstractModel, OutputStream outputStream) {
        ModelUtil.writeModel(abstractModel, outputStream);
    }
}
