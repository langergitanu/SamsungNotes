package com.samsung.android.support.senl.p148nt.stt.common.util.search;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/common/util/search/SearchFoundItem;", "", "position", "", "subPosition", "deltaPosition", "keywordStart", "keywordEnd", "isTranslatedItem", "", "<init>", "(IIIIIZ)V", "getDeltaPosition", "()I", "getKeywordStart", "getKeywordEnd", "()Z", "toString", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SearchFoundItem {
    private final int deltaPosition;
    private final boolean isTranslatedItem;
    private final int keywordEnd;
    private final int keywordStart;

    @JvmField
    public final int position;

    @JvmField
    public final int subPosition;

    public SearchFoundItem(int i, int i2, int i4, int i5, int i6, boolean z) {
        this.position = i;
        this.subPosition = i2;
        this.deltaPosition = i4;
        this.keywordStart = i5;
        this.keywordEnd = i6;
        this.isTranslatedItem = z;
    }

    public final int getDeltaPosition() {
        return this.deltaPosition;
    }

    public final int getKeywordEnd() {
        return this.keywordEnd;
    }

    public final int getKeywordStart() {
        return this.keywordStart;
    }

    /* JADX INFO: renamed from: isTranslatedItem, reason: from getter */
    public final boolean getIsTranslatedItem() {
        return this.isTranslatedItem;
    }

    @NotNull
    public String toString() {
        int i = this.position;
        int i2 = this.deltaPosition;
        int i4 = this.keywordStart;
        int i5 = this.keywordEnd;
        boolean z = this.isTranslatedItem;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2 + i4, "position ", ", sortPosition ", ", delta ");
        AbstractC2821a.m2235z(sbM1173s, i2, i4, ", start ", ", end ");
        sbM1173s.append(i5);
        sbM1173s.append(", isTranslate ");
        sbM1173s.append(z);
        return sbM1173s.toString();
    }
}
