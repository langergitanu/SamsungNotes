package opennlp.tools.p217ml.model;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import opennlp.tools.p217ml.ArrayMath;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractModel implements MaxentModel {
    protected EvalParameters evalParams;
    protected ModelType modelType;
    protected String[] outcomeNames;
    protected Map<String, Context> pmap;
    protected Prior prior;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ModelType {
        Maxent,
        Perceptron,
        MaxentQn,
        NaiveBayes
    }

    public AbstractModel(Context[] contextArr, String[] strArr, Map<String, Context> map, String[] strArr2) {
        this.pmap = map;
        this.outcomeNames = strArr2;
        this.evalParams = new EvalParameters(contextArr, strArr2.length);
    }

    private void init(String[] strArr, Context[] contextArr, String[] strArr2) {
        this.pmap = new LinkedHashMap(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            this.pmap.put(strArr[i], contextArr[i]);
        }
        this.outcomeNames = strArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractModel) {
            AbstractModel abstractModel = (AbstractModel) obj;
            if (this.pmap.equals(abstractModel.pmap) && Objects.deepEquals(this.outcomeNames, abstractModel.outcomeNames) && Objects.equals(this.prior, abstractModel.prior)) {
                return true;
            }
        }
        return false;
    }

    @Override // opennlp.tools.p217ml.model.MaxentModel
    public final String getAllOutcomes(double[] dArr) {
        if (dArr.length != this.outcomeNames.length) {
            return "The double array sent as a parameter to AbstractModel.getAllOutcomes() must not have been produced by this model.";
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");
        StringBuilder sb = new StringBuilder(dArr.length * 2);
        sb.append(this.outcomeNames[0]);
        sb.append("[");
        sb.append(decimalFormat.format(dArr[0]));
        sb.append("]");
        for (int i = 1; i < dArr.length; i++) {
            sb.append(Constant.WHITE_SPACE_FOR_LINK_ICON);
            sb.append(this.outcomeNames[i]);
            sb.append("[");
            sb.append(decimalFormat.format(dArr[i]));
            sb.append("]");
        }
        return sb.toString();
    }

    @Override // opennlp.tools.p217ml.model.MaxentModel
    public final String getBestOutcome(double[] dArr) {
        return this.outcomeNames[ArrayMath.argmax(dArr)];
    }

    public final Object[] getDataStructures() {
        return new Object[]{this.evalParams.getParams(), this.pmap, this.outcomeNames};
    }

    @Override // opennlp.tools.p217ml.model.MaxentModel
    public int getIndex(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.outcomeNames;
            if (i >= strArr.length) {
                return -1;
            }
            if (strArr[i].equals(str)) {
                return i;
            }
            i++;
        }
    }

    public ModelType getModelType() {
        return this.modelType;
    }

    @Override // opennlp.tools.p217ml.model.MaxentModel
    public int getNumOutcomes() {
        return this.evalParams.getNumOutcomes();
    }

    @Override // opennlp.tools.p217ml.model.MaxentModel
    public final String getOutcome(int i) {
        return this.outcomeNames[i];
    }

    public int hashCode() {
        return Objects.hash(this.pmap, Integer.valueOf(Arrays.hashCode(this.outcomeNames)), this.evalParams, this.prior);
    }

    public AbstractModel(Context[] contextArr, String[] strArr, String[] strArr2) {
        init(strArr, contextArr, strArr2);
        this.evalParams = new EvalParameters(contextArr, strArr2.length);
    }
}
