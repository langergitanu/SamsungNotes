package opennlp.tools.p217ml.naivebayes;

import java.io.BufferedReader;
import java.io.File;
import opennlp.tools.p217ml.model.PlainTextFileDataReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PlainTextNaiveBayesModelReader extends NaiveBayesModelReader {
    public PlainTextNaiveBayesModelReader(BufferedReader bufferedReader) {
        super(new PlainTextFileDataReader(bufferedReader));
    }

    public PlainTextNaiveBayesModelReader(File file) {
        super(file);
    }
}
