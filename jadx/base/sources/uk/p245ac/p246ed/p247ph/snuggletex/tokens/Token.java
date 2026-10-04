package uk.p245ac.p246ed.p247ph.snuggletex.tokens;

import java.util.EnumMap;
import uk.p245ac.p246ed.p247ph.snuggletex.SnugglePackage;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.ComputedStyle;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.MathCharacter;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.FrozenSlice;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.DumpMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectDumperOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathCharacterInterpretation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public abstract class Token {
    protected ComputedStyle computedStyle;
    protected final EnumMap<InterpretationType, Interpretation> interpretationMap;
    protected final LaTeXMode latexMode;
    protected final FrozenSlice slice;
    protected final TokenType type;

    public Token(FrozenSlice frozenSlice, TokenType tokenType, LaTeXMode laTeXMode, Interpretation... interpretationArr) {
        this.slice = frozenSlice;
        this.type = tokenType;
        this.latexMode = laTeXMode;
        this.interpretationMap = SnugglePackage.makeInterpretationMap(interpretationArr);
    }

    public ComputedStyle getComputedStyle() {
        return this.computedStyle;
    }

    public Interpretation getInterpretation(InterpretationType interpretationType) {
        EnumMap<InterpretationType, Interpretation> enumMap = this.interpretationMap;
        if (enumMap != null) {
            return enumMap.get(interpretationType);
        }
        return null;
    }

    @ObjectDumperOptions(DumpMode.TO_STRING)
    public EnumMap<InterpretationType, Interpretation> getInterpretationMap() {
        return this.interpretationMap;
    }

    public LaTeXMode getLatexMode() {
        return this.latexMode;
    }

    public MathCharacter getMathCharacter() {
        MathCharacterInterpretation mathCharacterInterpretation;
        EnumMap<InterpretationType, Interpretation> enumMap = this.interpretationMap;
        if (enumMap == null || (mathCharacterInterpretation = (MathCharacterInterpretation) enumMap.get(InterpretationType.MATH_CHARACTER)) == null) {
            return null;
        }
        return mathCharacterInterpretation.getMathCharacter();
    }

    public int getMathCharacterCodePoint() {
        MathCharacter mathCharacter = getMathCharacter();
        if (mathCharacter != null) {
            return mathCharacter.getCodePoint();
        }
        return -1;
    }

    @ObjectDumperOptions(DumpMode.TO_STRING)
    public FrozenSlice getSlice() {
        return this.slice;
    }

    public TokenType getType() {
        return this.type;
    }

    public boolean hasInterpretationType(InterpretationType... interpretationTypeArr) {
        if (this.interpretationMap == null) {
            return false;
        }
        for (InterpretationType interpretationType : interpretationTypeArr) {
            if (this.interpretationMap.containsKey(interpretationType)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCommand(BuiltinCommand builtinCommand) {
        return (this instanceof CommandToken) && ((CommandToken) this).getCommand() == builtinCommand;
    }

    public boolean isEnvironment(BuiltinEnvironment builtinEnvironment) {
        return (this instanceof EnvironmentToken) && ((EnvironmentToken) this).getEnvironment() == builtinEnvironment;
    }

    public void setComputedStyle(ComputedStyle computedStyle) {
        this.computedStyle = computedStyle;
    }

    public String toString() {
        return ObjectUtilities.beanToString(this);
    }

    public Token(FrozenSlice frozenSlice, TokenType tokenType, LaTeXMode laTeXMode, EnumMap<InterpretationType, Interpretation> enumMap) {
        this.slice = frozenSlice;
        this.type = tokenType;
        this.latexMode = laTeXMode;
        this.interpretationMap = enumMap;
    }
}
