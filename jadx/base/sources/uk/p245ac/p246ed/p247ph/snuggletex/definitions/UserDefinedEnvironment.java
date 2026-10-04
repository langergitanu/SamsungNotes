package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

import uk.p245ac.p246ed.p247ph.snuggletex.internal.FrozenSlice;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class UserDefinedEnvironment extends UserDefinedCommandOrEnvironment implements Environment {
    private final FrozenSlice beginDefinitionSlice;
    private final FrozenSlice endDefinitionSlice;

    public UserDefinedEnvironment(String str, String str2, int i, FrozenSlice frozenSlice, FrozenSlice frozenSlice2) {
        super(str, str2, i);
        this.beginDefinitionSlice = frozenSlice;
        this.endDefinitionSlice = frozenSlice2;
    }

    public FrozenSlice getBeginDefinitionSlice() {
        return this.beginDefinitionSlice;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.Environment
    public LaTeXMode getContentMode() {
        return null;
    }

    public FrozenSlice getEndDefinitionSlice() {
        return this.endDefinitionSlice;
    }
}
