package opennlp.tools.p217ml.model;

import java.io.ObjectInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ObjectDataReader implements DataReader {
    protected final ObjectInputStream ois;

    public ObjectDataReader(ObjectInputStream objectInputStream) {
        this.ois = objectInputStream;
    }

    @Override // opennlp.tools.p217ml.model.DataReader
    public double readDouble() {
        return this.ois.readDouble();
    }

    @Override // opennlp.tools.p217ml.model.DataReader
    public int readInt() {
        return this.ois.readInt();
    }

    @Override // opennlp.tools.p217ml.model.DataReader
    public String readUTF() {
        return this.ois.readUTF();
    }
}
