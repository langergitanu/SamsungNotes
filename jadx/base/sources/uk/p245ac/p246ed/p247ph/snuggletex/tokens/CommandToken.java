package uk.p245ac.p246ed.p247ph.snuggletex.tokens;

import java.util.EnumMap;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.FrozenSlice;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class CommandToken extends FlowToken {
    private final ArgumentContainerToken[] arguments;
    private final ArgumentContainerToken combinerTarget;
    private final BuiltinCommand command;
    private final ArgumentContainerToken optionalArgument;

    public CommandToken(FrozenSlice frozenSlice, LaTeXMode laTeXMode, BuiltinCommand builtinCommand) {
        this(frozenSlice, laTeXMode, builtinCommand, null, null, null);
    }

    public ArgumentContainerToken[] getArguments() {
        return this.arguments;
    }

    public ArgumentContainerToken getCombinerTarget() {
        return this.combinerTarget;
    }

    public BuiltinCommand getCommand() {
        return this.command;
    }

    public ArgumentContainerToken getOptionalArgument() {
        return this.optionalArgument;
    }

    public CommandToken(FrozenSlice frozenSlice, LaTeXMode laTeXMode, BuiltinCommand builtinCommand, ArgumentContainerToken argumentContainerToken) {
        this(frozenSlice, laTeXMode, builtinCommand, argumentContainerToken, null, null);
    }

    public CommandToken(FrozenSlice frozenSlice, LaTeXMode laTeXMode, BuiltinCommand builtinCommand, ArgumentContainerToken argumentContainerToken, ArgumentContainerToken[] argumentContainerTokenArr) {
        this(frozenSlice, laTeXMode, builtinCommand, null, argumentContainerToken, argumentContainerTokenArr);
    }

    private CommandToken(FrozenSlice frozenSlice, LaTeXMode laTeXMode, BuiltinCommand builtinCommand, ArgumentContainerToken argumentContainerToken, ArgumentContainerToken argumentContainerToken2, ArgumentContainerToken[] argumentContainerTokenArr) {
        super(frozenSlice, TokenType.COMMAND, laTeXMode, builtinCommand.getTextFlowContext(), (EnumMap<InterpretationType, Interpretation>) builtinCommand.getInterpretationMap());
        this.command = builtinCommand;
        this.combinerTarget = argumentContainerToken;
        this.optionalArgument = argumentContainerToken2;
        this.arguments = argumentContainerTokenArr;
    }
}
