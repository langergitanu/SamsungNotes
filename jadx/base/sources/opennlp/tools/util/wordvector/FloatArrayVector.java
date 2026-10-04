package opennlp.tools.util.wordvector;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class FloatArrayVector implements WordVector {
    private final float[] vector;

    public FloatArrayVector(float[] fArr) {
        this.vector = fArr;
    }

    @Override // opennlp.tools.util.wordvector.WordVector
    public int dimension() {
        return this.vector.length;
    }

    @Override // opennlp.tools.util.wordvector.WordVector
    public double getAsDouble(int i) {
        return getAsFloat(i);
    }

    @Override // opennlp.tools.util.wordvector.WordVector
    public float getAsFloat(int i) {
        return this.vector[i];
    }

    @Override // opennlp.tools.util.wordvector.WordVector
    public WordVectorType getDataType() {
        return WordVectorType.FLOAT;
    }

    @Override // opennlp.tools.util.wordvector.WordVector
    public DoubleBuffer toDoubleBuffer() {
        int length = this.vector.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = this.vector[i];
        }
        return DoubleBuffer.wrap(dArr).asReadOnlyBuffer();
    }

    @Override // opennlp.tools.util.wordvector.WordVector
    public FloatBuffer toFloatBuffer() {
        return FloatBuffer.wrap(this.vector).asReadOnlyBuffer();
    }
}
