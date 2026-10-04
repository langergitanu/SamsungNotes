package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

import java.util.EnumMap;
import java.util.EnumSet;
import uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathCharacterInterpretation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class BuiltinCommand extends BuiltinCommandOrEnvironment<CommandHandler> implements Command {
    private final LaTeXMode[] argumentModes;
    private final CombinerTargetMatcher combinerTargetMatcher;
    private final CommandType type;

    public BuiltinCommand(String str, CommandType commandType, boolean z, int i, EnumSet<LaTeXMode> enumSet, LaTeXMode[] laTeXModeArr, EnumMap<InterpretationType, Interpretation> enumMap, CommandHandler commandHandler, TextFlowContext textFlowContext, CombinerTargetMatcher combinerTargetMatcher) {
        super(str, z, i, enumSet, enumMap, textFlowContext, commandHandler);
        this.type = commandType;
        this.argumentModes = laTeXModeArr;
        this.combinerTargetMatcher = combinerTargetMatcher;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommandOrEnvironment
    public /* bridge */ /* synthetic */ EnumSet getAllowedModes() {
        return super.getAllowedModes();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommandOrEnvironment, uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment
    public /* bridge */ /* synthetic */ int getArgumentCount() {
        return super.getArgumentCount();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment
    public LaTeXMode getArgumentMode(int i) {
        LaTeXMode[] laTeXModeArr = this.argumentModes;
        if (laTeXModeArr != null) {
            return laTeXModeArr[i];
        }
        return null;
    }

    public CombinerTargetMatcher getCombinerTargetMatcher() {
        return this.combinerTargetMatcher;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommandOrEnvironment
    public /* bridge */ /* synthetic */ Interpretation getInterpretation(InterpretationType interpretationType) {
        return super.getInterpretation(interpretationType);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommandOrEnvironment
    public /* bridge */ /* synthetic */ EnumMap getInterpretationMap() {
        return super.getInterpretationMap();
    }

    public MathCharacter getMathCharacter() {
        MathCharacterInterpretation mathCharacterInterpretation = (MathCharacterInterpretation) getInterpretation(InterpretationType.MATH_CHARACTER);
        if (mathCharacterInterpretation != null) {
            return mathCharacterInterpretation.getMathCharacter();
        }
        return null;
    }

    public int getMathCharacterCodePoint() {
        MathCharacter mathCharacter = getMathCharacter();
        if (mathCharacter != null) {
            return mathCharacter.getCodePoint();
        }
        return -1;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommandOrEnvironment, uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment
    public /* bridge */ /* synthetic */ String getTeXName() {
        return super.getTeXName();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommandOrEnvironment
    public /* bridge */ /* synthetic */ TextFlowContext getTextFlowContext() {
        return super.getTextFlowContext();
    }

    public CommandType getType() {
        return this.type;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommandOrEnvironment
    public /* bridge */ /* synthetic */ boolean hasInterpretation(InterpretationType interpretationType) {
        return super.hasInterpretation(interpretationType);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommandOrEnvironment, uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment
    public /* bridge */ /* synthetic */ boolean isAllowingOptionalArgument() {
        return super.isAllowingOptionalArgument();
    }
}
