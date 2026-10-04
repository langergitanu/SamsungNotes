package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

import java.util.EnumMap;
import java.util.EnumSet;
import uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class BuiltinEnvironment extends BuiltinCommandOrEnvironment<EnvironmentHandler> implements Environment {
    private final LaTeXMode contentMode;

    public BuiltinEnvironment(String str, boolean z, int i, EnumSet<LaTeXMode> enumSet, LaTeXMode laTeXMode, EnumMap<InterpretationType, Interpretation> enumMap, EnvironmentHandler environmentHandler, TextFlowContext textFlowContext) {
        super(str, z, i, enumSet, enumMap, textFlowContext, environmentHandler);
        this.contentMode = laTeXMode;
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
        return LaTeXMode.PARAGRAPH;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.Environment
    public LaTeXMode getContentMode() {
        return this.contentMode;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommandOrEnvironment
    public /* bridge */ /* synthetic */ Interpretation getInterpretation(InterpretationType interpretationType) {
        return super.getInterpretation(interpretationType);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommandOrEnvironment
    public /* bridge */ /* synthetic */ EnumMap getInterpretationMap() {
        return super.getInterpretationMap();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommandOrEnvironment, uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment
    public /* bridge */ /* synthetic */ String getTeXName() {
        return super.getTeXName();
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommandOrEnvironment
    public /* bridge */ /* synthetic */ TextFlowContext getTextFlowContext() {
        return super.getTextFlowContext();
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
