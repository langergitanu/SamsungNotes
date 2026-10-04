package opennlp.tools.p217ml.naivebayes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPOutputStream;
import opennlp.tools.p217ml.model.AbstractModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PlainTextNaiveBayesModelWriter extends NaiveBayesModelWriter {
    private final BufferedWriter output;

    public PlainTextNaiveBayesModelWriter(AbstractModel abstractModel, File file) {
        super(abstractModel);
        if (file.getName().endsWith(".gz")) {
            this.output = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(file))));
        } else {
            this.output = new BufferedWriter(new FileWriter(file));
        }
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void close() throws IOException {
        this.output.flush();
        this.output.close();
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void writeDouble(double d) throws IOException {
        this.output.write(Double.toString(d));
        this.output.newLine();
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void writeInt(int i) throws IOException {
        this.output.write(Integer.toString(i));
        this.output.newLine();
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void writeUTF(String str) throws IOException {
        this.output.write(str);
        this.output.newLine();
    }

    public PlainTextNaiveBayesModelWriter(AbstractModel abstractModel, BufferedWriter bufferedWriter) {
        super(abstractModel);
        this.output = bufferedWriter;
    }
}
