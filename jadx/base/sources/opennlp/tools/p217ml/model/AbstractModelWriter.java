package opennlp.tools.p217ml.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractModelWriter {
    public abstract void close();

    public abstract void persist();

    public abstract void writeDouble(double d);

    public abstract void writeInt(int i);

    public abstract void writeUTF(String str);
}
