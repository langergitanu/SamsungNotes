package opennlp.tools.p217ml.model;

import java.io.File;
import java.io.IOException;
import opennlp.tools.p217ml.maxent.p218io.GISModelReader;
import opennlp.tools.p217ml.maxent.p218io.QNModelReader;
import opennlp.tools.p217ml.naivebayes.NaiveBayesModelReader;
import opennlp.tools.p217ml.perceptron.PerceptronModelReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class GenericModelReader extends AbstractModelReader {
    private AbstractModelReader delegateModelReader;

    public GenericModelReader(File file) {
        super(file);
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelReader
    public void checkModelType() throws IOException {
        String utf;
        utf = readUTF();
        utf.getClass();
        switch (utf) {
            case "QN":
                this.delegateModelReader = new QNModelReader(this.dataReader);
                return;
            case "GIS":
                this.delegateModelReader = new GISModelReader(this.dataReader);
                return;
            case "Perceptron":
                this.delegateModelReader = new PerceptronModelReader(this.dataReader);
                return;
            case "NaiveBayes":
                this.delegateModelReader = new NaiveBayesModelReader(this.dataReader);
                return;
            default:
                throw new IOException("Unknown model format: ".concat(utf));
        }
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelReader
    public AbstractModel constructModel() {
        return this.delegateModelReader.constructModel();
    }

    public GenericModelReader(DataReader dataReader) {
        super(dataReader);
    }
}
