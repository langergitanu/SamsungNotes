package com.samsung.android.support.notes.bixby.bixby2.aid;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B5\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\u000bJ\b\u0010\u001b\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/aid/BixbyAiParam;", "", "<init>", "()V", "actionName", "", Bixby2Constants.BIXBY_ACTION_ADD_ACTION, "", "targetLanguageCode", "index", Bixby2Constants.BIXBY_PARAM_RANGE, "(Ljava/lang/String;ILjava/lang/String;II)V", "getActionName", "()Ljava/lang/String;", "setActionName", "(Ljava/lang/String;)V", "getAddAction", "()I", "setAddAction", "(I)V", "targetLanguage", "getTargetLanguage", "setTargetLanguage", "getIndex", "setIndex", "getRange", "setRange", "toString", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BixbyAiParam {

    @Nullable
    private String actionName;
    private int addAction;
    private int index;
    private int range;

    @Nullable
    private String targetLanguage;

    public BixbyAiParam() {
    }

    @Nullable
    public final String getActionName() {
        return this.actionName;
    }

    public final int getAddAction() {
        return this.addAction;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getRange() {
        return this.range;
    }

    @Nullable
    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    public final void setActionName(@Nullable String str) {
        this.actionName = str;
    }

    public final void setAddAction(int i) {
        this.addAction = i;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setRange(int i) {
        this.range = i;
    }

    public final void setTargetLanguage(@Nullable String str) {
        this.targetLanguage = str;
    }

    @NotNull
    public String toString() {
        String str = this.actionName;
        int i = this.addAction;
        String str2 = this.targetLanguage;
        int i2 = this.index;
        int i4 = this.range;
        StringBuilder sbM780v = AbstractC0541b.m780v("BixbyAiParam - ", i, str, SQLKeyword.COMMA, SQLKeyword.COMMA);
        sbM780v.append(str2);
        sbM780v.append(SQLKeyword.COMMA);
        sbM780v.append(i2);
        sbM780v.append(SQLKeyword.COMMA);
        sbM780v.append(i4);
        return sbM780v.toString();
    }

    public BixbyAiParam(@Nullable String str, int i, @Nullable String str2, int i2, int i4) {
        this();
        this.actionName = str;
        this.addAction = i;
        this.targetLanguage = str2;
        this.index = i2;
        this.range = i4;
    }
}
