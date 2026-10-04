package com.vladsch.flexmark.util.sequence.builder.tree;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OffsetInfo {
    public final int endIndex;
    public final boolean isEndOffset;
    public final int offset;
    public final int pos;
    public final int startIndex;

    public OffsetInfo(int i, int i2, boolean z, int i4) {
        this(i, i2, z, i4, i4);
    }

    public String toString() {
        String strM1164j;
        int i = this.pos;
        if (this.isEndOffset) {
            strM1164j = AbstractC0541b.m767i(this.offset, "[", ")");
        } else {
            int i2 = this.offset;
            strM1164j = AbstractC0622a.m1164j(i2, i2 + 1, "[", SQLKeyword.COMMA, ")");
        }
        return AbstractC2322a.m1625o(AbstractC2322a.m1629s("OffsetInfo{ p=", i, ", o=", strM1164j, ", i=["), this.startIndex, this.endIndex, SQLKeyword.COMMA, ") }");
    }

    public OffsetInfo(int i, int i2, boolean z, int i4, int i5) {
        this.pos = i;
        this.offset = i2;
        this.isEndOffset = z;
        this.startIndex = i4;
        this.endIndex = i5;
    }
}
