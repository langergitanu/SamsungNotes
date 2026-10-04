package opennlp.tools.p217ml.maxent.p218io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.ModelParameterChunker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BinaryGISModelWriter extends GISModelWriter {
    private final DataOutputStream output;

    public BinaryGISModelWriter(AbstractModel abstractModel, File file) {
        super(abstractModel);
        if (file.getName().endsWith(".gz")) {
            this.output = new DataOutputStream(new GZIPOutputStream(new FileOutputStream(file)));
        } else {
            this.output = new DataOutputStream(new FileOutputStream(file));
        }
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void close() throws IOException {
        this.output.flush();
        this.output.close();
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void writeDouble(double d) throws IOException {
        this.output.writeDouble(d);
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void writeInt(int i) throws IOException {
        this.output.writeInt(i);
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void writeUTF(String str) throws IOException {
        ModelParameterChunker.writeUTF(this.output, str);
    }

    public BinaryGISModelWriter(AbstractModel abstractModel, DataOutputStream dataOutputStream) {
        super(abstractModel);
        this.output = dataOutputStream;
    }
}
