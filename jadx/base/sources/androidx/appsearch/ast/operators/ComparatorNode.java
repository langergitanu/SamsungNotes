package androidx.appsearch.ast.operators;

import androidx.annotation.RestrictTo;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.PropertyPath;
import androidx.appsearch.ast.Node;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.core.util.Preconditions;
import androidx.glance.AbstractC2821a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
public final class ComparatorNode implements Node {
    public static final int EQUALS = 0;
    public static final int GREATER_EQUALS = 4;
    public static final int GREATER_THAN = 3;
    public static final int LESS_EQUALS = 2;
    public static final int LESS_THAN = 1;
    private static final int MAX_COMPARATOR_VALUE = 4;
    private int mComparator;
    private PropertyPath mPropertyPath;
    private long mValue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Comparator {
    }

    public ComparatorNode(int i, PropertyPath propertyPath, long j) {
        Preconditions.checkArgumentInRange(i, 0, 4, "Comparator intDef");
        this.mComparator = i;
        this.mPropertyPath = (PropertyPath) Preconditions.checkNotNull(propertyPath);
        this.mValue = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComparatorNode)) {
            return false;
        }
        ComparatorNode comparatorNode = (ComparatorNode) obj;
        return this.mComparator == comparatorNode.mComparator && this.mValue == comparatorNode.mValue && Objects.equals(this.mPropertyPath, comparatorNode.mPropertyPath);
    }

    public int getComparator() {
        return this.mComparator;
    }

    public PropertyPath getPropertyPath() {
        return this.mPropertyPath;
    }

    public long getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mComparator), this.mPropertyPath, Long.valueOf(this.mValue));
    }

    public void setComparator(int i) {
        Preconditions.checkArgumentInRange(i, 0, 4, "Comparator intDef");
        this.mComparator = i;
    }

    public void setPropertyPath(PropertyPath propertyPath) {
        this.mPropertyPath = (PropertyPath) Preconditions.checkNotNull(propertyPath);
    }

    public void setValue(long j) {
        this.mValue = j;
    }

    public String toString() {
        int i = this.mComparator;
        String str = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : ">=" : ">" : "<=" : "<" : "==";
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.mPropertyPath);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        return AbstractC2821a.m2224o(sb, ")", this.mValue);
    }
}
