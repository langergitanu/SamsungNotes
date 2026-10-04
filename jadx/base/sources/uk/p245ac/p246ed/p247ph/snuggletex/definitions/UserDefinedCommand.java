package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

import uk.p245ac.p246ed.p247ph.snuggletex.internal.FrozenSlice;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class UserDefinedCommand extends UserDefinedCommandOrEnvironment implements Command {
    private final FrozenSlice definitionSlice;

    public UserDefinedCommand(String str, String str2, int i, FrozenSlice frozenSlice) {
        super(str, str2, i);
        this.definitionSlice = frozenSlice;
    }

    public FrozenSlice getDefinitionSlice() {
        return this.definitionSlice;
    }
}
