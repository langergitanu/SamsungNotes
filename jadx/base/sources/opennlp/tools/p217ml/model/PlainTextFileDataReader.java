package opennlp.tools.p217ml.model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PlainTextFileDataReader implements DataReader {
    private final BufferedReader input;

    public PlainTextFileDataReader(File file) {
        if (file.getName().endsWith(".gz")) {
            this.input = new BufferedReader(new InputStreamReader(new BufferedInputStream(new GZIPInputStream(new BufferedInputStream(new FileInputStream(file))))));
        } else {
            this.input = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(file))));
        }
    }

    @Override // opennlp.tools.p217ml.model.DataReader
    public double readDouble() {
        return Double.parseDouble(this.input.readLine());
    }

    @Override // opennlp.tools.p217ml.model.DataReader
    public int readInt() {
        return Integer.parseInt(this.input.readLine());
    }

    @Override // opennlp.tools.p217ml.model.DataReader
    public String readUTF() {
        return this.input.readLine();
    }

    public PlainTextFileDataReader(InputStream inputStream) {
        this.input = new BufferedReader(new InputStreamReader(inputStream));
    }

    public PlainTextFileDataReader(BufferedReader bufferedReader) {
        this.input = bufferedReader;
    }
}
