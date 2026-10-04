package opennlp.tools.p217ml.perceptron;

import java.io.DataInputStream;
import java.io.File;
import opennlp.tools.p217ml.model.BinaryFileDataReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BinaryPerceptronModelReader extends PerceptronModelReader {
    public BinaryPerceptronModelReader(DataInputStream dataInputStream) {
        super(new BinaryFileDataReader(dataInputStream));
    }

    public BinaryPerceptronModelReader(File file) {
        super(file);
    }
}
