package uk.p245ac.p246ed.p247ph.snuggletex.tokens;

import java.util.EnumMap;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.FrozenSlice;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.DumpMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectDumperOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class EnvironmentToken extends FlowToken {
    private final ArgumentContainerToken[] arguments;
    private final ArgumentContainerToken content;
    private final BuiltinEnvironment environment;
    private final ArgumentContainerToken optionalArgument;

    public EnvironmentToken(FrozenSlice frozenSlice, LaTeXMode laTeXMode, BuiltinEnvironment builtinEnvironment, ArgumentContainerToken argumentContainerToken) {
        this(frozenSlice, laTeXMode, builtinEnvironment, null, ArgumentContainerToken.EMPTY_ARRAY, argumentContainerToken);
    }

    @ObjectDumperOptions(DumpMode.DEEP)
    public ArgumentContainerToken[] getArguments() {
        return this.arguments;
    }

    @ObjectDumperOptions(DumpMode.DEEP)
    public ArgumentContainerToken getContent() {
        return this.content;
    }

    public BuiltinEnvironment getEnvironment() {
        return this.environment;
    }

    @ObjectDumperOptions(DumpMode.DEEP)
    public ArgumentContainerToken getOptionalArgument() {
        return this.optionalArgument;
    }

    public EnvironmentToken(FrozenSlice frozenSlice, LaTeXMode laTeXMode, BuiltinEnvironment builtinEnvironment, ArgumentContainerToken argumentContainerToken, ArgumentContainerToken[] argumentContainerTokenArr, ArgumentContainerToken argumentContainerToken2) {
        super(frozenSlice, TokenType.ENVIRONMENT, laTeXMode, builtinEnvironment.getTextFlowContext(), (EnumMap<InterpretationType, Interpretation>) builtinEnvironment.getInterpretationMap());
        this.environment = builtinEnvironment;
        this.optionalArgument = argumentContainerToken;
        this.arguments = argumentContainerTokenArr;
        this.content = argumentContainerToken2;
    }
}
