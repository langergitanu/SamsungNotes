package opennlp.tools.p217ml.model;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractModelReader {
    protected int NUM_PREDS;
    protected DataReader dataReader;

    public AbstractModelReader(File file) {
        InputStream fileInputStream;
        String name = file.getName();
        if (name.endsWith(".gz")) {
            fileInputStream = new GZIPInputStream(new FileInputStream(file));
            name = AbstractC2322a.m1614d(3, 0, name);
        } else {
            fileInputStream = new FileInputStream(file);
        }
        if (name.endsWith(".bin")) {
            this.dataReader = new BinaryFileDataReader(fileInputStream);
        } else {
            this.dataReader = new PlainTextFileDataReader(fileInputStream);
        }
    }

    public abstract void checkModelType();

    public abstract AbstractModel constructModel();

    public AbstractModel getModel() {
        checkModelType();
        return constructModel();
    }

    public int[][] getOutcomePatterns() {
        int i = readInt();
        int[][] iArr = new int[i][];
        for (int i2 = 0; i2 < i; i2++) {
            StringTokenizer stringTokenizer = new StringTokenizer(readUTF(), " ");
            int[] iArr2 = new int[stringTokenizer.countTokens()];
            int i4 = 0;
            while (stringTokenizer.hasMoreTokens()) {
                iArr2[i4] = Integer.parseInt(stringTokenizer.nextToken());
                i4++;
            }
            iArr[i2] = iArr2;
        }
        return iArr;
    }

    public String[] getOutcomes() {
        int i = readInt();
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = readUTF();
        }
        return strArr;
    }

    public Context[] getParameters(int[][] iArr) {
        Context[] contextArr = new Context[this.NUM_PREDS];
        int i = 0;
        for (int[] iArr2 : iArr) {
            int[] iArr3 = new int[iArr2.length - 1];
            System.arraycopy(iArr2, 1, iArr3, 0, iArr2.length - 1);
            for (int i2 = 0; i2 < iArr2[0]; i2++) {
                double[] dArr = new double[iArr2.length - 1];
                for (int i4 = 1; i4 < iArr2.length; i4++) {
                    dArr[i4 - 1] = readDouble();
                }
                contextArr[i] = new Context(iArr3, dArr);
                i++;
            }
        }
        return contextArr;
    }

    public String[] getPredicates() {
        int i = readInt();
        this.NUM_PREDS = i;
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < this.NUM_PREDS; i2++) {
            strArr[i2] = readUTF();
        }
        return strArr;
    }

    public double readDouble() {
        return this.dataReader.readDouble();
    }

    public int readInt() {
        return this.dataReader.readInt();
    }

    public String readUTF() {
        return this.dataReader.readUTF();
    }

    public AbstractModelReader(DataReader dataReader) {
        this.dataReader = dataReader;
    }
}
