package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

import androidx.collection.AbstractC0622a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public abstract class UserDefinedCommandOrEnvironment implements CommandOrEnvironment {
    protected final int argumentCount;
    protected final String optionalArgument;
    protected final String texName;

    public UserDefinedCommandOrEnvironment(String str, String str2, int i) {
        this.texName = str;
        this.optionalArgument = str2;
        this.argumentCount = i;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment
    public int getArgumentCount() {
        return this.argumentCount;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment
    public LaTeXMode getArgumentMode(int i) {
        return null;
    }

    public String getOptionalArgument() {
        return this.optionalArgument;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment
    public String getTeXName() {
        return this.texName;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment
    public boolean isAllowingOptionalArgument() {
        return this.optionalArgument != null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        return AbstractC0622a.m1170p(this.texName, ")", sb);
    }
}
