package opennlp.tools.util.wordvector;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class DoubleArrayVector implements WordVector {
    private final double[] vector;

    public DoubleArrayVector(double[] dArr) {
        this.vector = dArr;
    }

    @Override // opennlp.tools.util.wordvector.WordVector
    public int dimension() {
        return this.vector.length;
    }

    @Override // opennlp.tools.util.wordvector.WordVector
    public double getAsDouble(int i) {
        return this.vector[i];
    }

    @Override // opennlp.tools.util.wordvector.WordVector
    public float getAsFloat(int i) {
        return (float) getAsDouble(i);
    }

    @Override // opennlp.tools.util.wordvector.WordVector
    public WordVectorType getDataType() {
        return WordVectorType.DOUBLE;
    }

    @Override // opennlp.tools.util.wordvector.WordVector
    public DoubleBuffer toDoubleBuffer() {
        return DoubleBuffer.wrap(this.vector).asReadOnlyBuffer();
    }

    @Override // opennlp.tools.util.wordvector.WordVector
    public FloatBuffer toFloatBuffer() {
        int length = this.vector.length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            fArr[i] = (float) this.vector[i];
        }
        return FloatBuffer.wrap(fArr).asReadOnlyBuffer();
    }
}
