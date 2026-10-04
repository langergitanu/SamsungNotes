package opennlp.tools.p217ml.model;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BinaryFileDataReader implements DataReader {
    private final DataInputStream input;

    public BinaryFileDataReader(File file) {
        if (file.getName().endsWith(".gz")) {
            this.input = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new BufferedInputStream(new FileInputStream(file)))));
        } else {
            this.input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        }
    }

    @Override // opennlp.tools.p217ml.model.DataReader
    public double readDouble() {
        return this.input.readDouble();
    }

    @Override // opennlp.tools.p217ml.model.DataReader
    public int readInt() {
        return this.input.readInt();
    }

    @Override // opennlp.tools.p217ml.model.DataReader
    public String readUTF() {
        return ModelParameterChunker.readUTF(this.input);
    }

    public BinaryFileDataReader(InputStream inputStream) {
        this(new DataInputStream(inputStream));
    }

    public BinaryFileDataReader(DataInputStream dataInputStream) {
        this.input = dataInputStream;
    }
}
