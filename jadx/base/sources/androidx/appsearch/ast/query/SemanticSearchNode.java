package androidx.appsearch.ast.query;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.ast.FunctionNode;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.core.util.Preconditions;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
public final class SemanticSearchNode implements FunctionNode {
    private int mDistanceMetric;
    private float mLowerBound;
    private float mUpperBound;
    private int mVectorIndex;

    public SemanticSearchNode(int i, float f, float f4, int i2) {
        Preconditions.checkArgument(i >= 0, "Vector index must be non-negative.");
        Preconditions.checkArgument(f <= f4, "Provided lower bound must be less than or equal to the provided upper bound.");
        Preconditions.checkArgumentInRange(i2, 0, 3, "Embedding search metric type");
        this.mVectorIndex = i;
        this.mLowerBound = f;
        this.mUpperBound = f4;
        this.mDistanceMetric = i2;
    }

    private void formatBound(StringBuilder sb, float f) {
        sb.append(SQLKeyword.COMMA);
        if (Float.isFinite(f)) {
            sb.append(f);
        } else if (f == Float.NEGATIVE_INFINITY) {
            sb.append(-3.4028235E38f);
        } else {
            sb.append(Float.MAX_VALUE);
        }
    }

    private String getEmbeddingMetricString() {
        int i = this.mDistanceMetric;
        if (i == 1) {
            return "\"COSINE\"";
        }
        if (i == 2) {
            return "\"DOT_PRODUCT\"";
        }
        if (i == 3) {
            return "\"EUCLIDEAN\"";
        }
        throw new IllegalStateException("Invalid Metric Type");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SemanticSearchNode.class == obj.getClass()) {
            SemanticSearchNode semanticSearchNode = (SemanticSearchNode) obj;
            if (this.mVectorIndex == semanticSearchNode.mVectorIndex && Float.compare(this.mLowerBound, semanticSearchNode.mLowerBound) == 0 && Float.compare(this.mUpperBound, semanticSearchNode.mUpperBound) == 0 && this.mDistanceMetric == semanticSearchNode.mDistanceMetric) {
                return true;
            }
        }
        return false;
    }

    public int getDistanceMetric() {
        return this.mDistanceMetric;
    }

    @Override // androidx.appsearch.ast.FunctionNode
    public String getFunctionName() {
        return FunctionNode.FUNCTION_NAME_SEMANTIC_SEARCH;
    }

    public float getLowerBound() {
        return this.mLowerBound;
    }

    public float getUpperBound() {
        return this.mUpperBound;
    }

    public int getVectorIndex() {
        return this.mVectorIndex;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mVectorIndex), Float.valueOf(this.mLowerBound), Float.valueOf(this.mUpperBound), Integer.valueOf(this.mDistanceMetric));
    }

    public void setBounds(float f, float f4) {
        Preconditions.checkArgument(f <= f4, "Provided lower bound must be less than or equal to the provided upper bound");
        this.mLowerBound = f;
        this.mUpperBound = f4;
    }

    public void setDistanceMetric(int i) {
        Preconditions.checkArgumentInRange(i, 0, 3, "Embedding search metric type");
        this.mDistanceMetric = i;
    }

    public void setVectorIndex(int i) {
        Preconditions.checkArgument(i >= 0, "Vector Index must be non-negative.");
        this.mVectorIndex = i;
    }

    public String toString() {
        StringBuilder sbM12325j = AbstractC11014a.m12325j(FunctionNode.FUNCTION_NAME_SEMANTIC_SEARCH, "(getEmbeddingParameter(");
        sbM12325j.append(this.mVectorIndex);
        sbM12325j.append(")");
        if (this.mDistanceMetric != 0) {
            formatBound(sbM12325j, this.mLowerBound);
            formatBound(sbM12325j, this.mUpperBound);
            sbM12325j.append(SQLKeyword.COMMA);
            sbM12325j.append(getEmbeddingMetricString());
        } else if (this.mUpperBound != Float.POSITIVE_INFINITY) {
            formatBound(sbM12325j, this.mLowerBound);
            formatBound(sbM12325j, this.mUpperBound);
        } else {
            float f = this.mLowerBound;
            if (f != Float.NEGATIVE_INFINITY) {
                formatBound(sbM12325j, f);
            }
        }
        sbM12325j.append(")");
        return sbM12325j.toString();
    }

    public SemanticSearchNode(int i, float f, float f4) {
        this(i, f, f4, 0);
    }

    public SemanticSearchNode(int i, float f) {
        this(i, f, Float.POSITIVE_INFINITY);
    }

    public SemanticSearchNode(int i) {
        this(i, Float.NEGATIVE_INFINITY);
    }
}
