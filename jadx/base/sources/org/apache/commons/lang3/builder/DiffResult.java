package org.apache.commons.lang3.builder;

import com.opencsv.bean.C6618c;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DiffResult<T> implements Iterable<Diff<?>> {
    public static final String OBJECTS_SAME_STRING = "";
    private final List<Diff<?>> diffList;
    private final T lhs;
    private final T rhs;
    private final ToStringStyle style;
    private final String toStringFormat;

    public DiffResult(T t, T t2, List<Diff<?>> list, ToStringStyle toStringStyle, String str) {
        Objects.requireNonNull(list, "diffList");
        this.diffList = list;
        Objects.requireNonNull(t, "lhs");
        this.lhs = t;
        Objects.requireNonNull(t2, "rhs");
        this.rhs = t2;
        Objects.requireNonNull(toStringStyle, "style");
        this.style = toStringStyle;
        Objects.requireNonNull(str, "toStringFormat");
        this.toStringFormat = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toString$0(ToStringBuilder toStringBuilder, ToStringBuilder toStringBuilder2, Diff diff) {
        toStringBuilder.append(diff.getFieldName(), diff.getLeft());
        toStringBuilder2.append(diff.getFieldName(), diff.getRight());
    }

    public List<Diff<?>> getDiffs() {
        return Collections.unmodifiableList(this.diffList);
    }

    public T getLeft() {
        return this.lhs;
    }

    public int getNumberOfDiffs() {
        return this.diffList.size();
    }

    public T getRight() {
        return this.rhs;
    }

    public ToStringStyle getToStringStyle() {
        return this.style;
    }

    @Override // java.lang.Iterable
    public Iterator<Diff<?>> iterator() {
        return this.diffList.iterator();
    }

    public String toString() {
        return toString(this.style);
    }

    public String toString(ToStringStyle toStringStyle) {
        if (this.diffList.isEmpty()) {
            return "";
        }
        ToStringBuilder toStringBuilder = new ToStringBuilder(this.lhs, toStringStyle);
        ToStringBuilder toStringBuilder2 = new ToStringBuilder(this.rhs, toStringStyle);
        this.diffList.forEach(new C6618c(toStringBuilder, toStringBuilder2, 13));
        return String.format(this.toStringFormat, toStringBuilder.build(), toStringBuilder2.build());
    }
}
