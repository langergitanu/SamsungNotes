package com.samsung.android.sdk.scs.p142ai.text.unit;

import androidx.annotation.RestrictTo;
import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Quantity {
    private String name;
    private String symbol;
    private String type;
    private BigDecimal value;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Quantity() {
        this.type = "";
        this.name = "";
        this.symbol = "";
        this.value = BigDecimal.ZERO;
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getType() {
        return this.type;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setName(String str) {
        this.name = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setSymbol(String str) {
        this.symbol = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setType(String str) {
        this.type = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setValue(BigDecimal bigDecimal) {
        this.value = bigDecimal;
    }

    public String toString() {
        return this.value.toPlainString() + this.symbol;
    }

    public Quantity(String str, String str2, String str3, BigDecimal bigDecimal) {
        this.type = "";
        this.name = "";
        this.symbol = "";
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        this.type = str;
        this.name = str2;
        this.symbol = str3;
        this.value = bigDecimal;
    }
}
