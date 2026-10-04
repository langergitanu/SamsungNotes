package opennlp.tools.util.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ByteArraySerializer implements ArtifactSerializer<byte[]> {
    @Override // opennlp.tools.util.model.ArtifactSerializer
    public byte[] create(InputStream inputStream) {
        return ModelUtil.read(inputStream);
    }

    @Override // opennlp.tools.util.model.ArtifactSerializer
    public void serialize(byte[] bArr, OutputStream outputStream) throws IOException {
        outputStream.write(bArr);
    }
}
