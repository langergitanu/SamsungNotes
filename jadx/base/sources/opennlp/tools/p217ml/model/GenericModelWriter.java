package opennlp.tools.p217ml.model;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import opennlp.tools.p217ml.maxent.p218io.BinaryGISModelWriter;
import opennlp.tools.p217ml.maxent.p218io.BinaryQNModelWriter;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.naivebayes.BinaryNaiveBayesModelWriter;
import opennlp.tools.p217ml.perceptron.BinaryPerceptronModelWriter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class GenericModelWriter extends AbstractModelWriter {
    private AbstractModelWriter delegateWriter;

    public GenericModelWriter(AbstractModel abstractModel, File file) {
        OutputStream fileOutputStream;
        String name = file.getName();
        if (name.endsWith(".gz")) {
            fileOutputStream = new GZIPOutputStream(new FileOutputStream(file));
            name.substring(0, name.length() - 3);
        } else {
            fileOutputStream = new FileOutputStream(file);
        }
        init(abstractModel, new DataOutputStream(fileOutputStream));
    }

    private void init(AbstractModel abstractModel, DataOutputStream dataOutputStream) {
        if (abstractModel.getModelType() == AbstractModel.ModelType.Perceptron) {
            this.delegateWriter = new BinaryPerceptronModelWriter(abstractModel, dataOutputStream);
        } else if (abstractModel.getModelType() == AbstractModel.ModelType.Maxent) {
            this.delegateWriter = new BinaryGISModelWriter(abstractModel, dataOutputStream);
        } else if (abstractModel.getModelType() == AbstractModel.ModelType.MaxentQn) {
            this.delegateWriter = new BinaryQNModelWriter(abstractModel, dataOutputStream);
        }
        if (abstractModel.getModelType() == AbstractModel.ModelType.NaiveBayes) {
            this.delegateWriter = new BinaryNaiveBayesModelWriter(abstractModel, dataOutputStream);
        }
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void close() {
        this.delegateWriter.close();
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void persist() {
        this.delegateWriter.persist();
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void writeDouble(double d) {
        this.delegateWriter.writeDouble(d);
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void writeInt(int i) {
        this.delegateWriter.writeInt(i);
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void writeUTF(String str) {
        this.delegateWriter.writeUTF(str);
    }

    public GenericModelWriter(AbstractModel abstractModel, DataOutputStream dataOutputStream) {
        init(abstractModel, dataOutputStream);
    }
}
