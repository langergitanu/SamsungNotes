package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

import java.util.EnumMap;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.BeanToStringOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.DumpMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectDumperOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.PropertyOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathCharacterInterpretation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathCharacter {
    private final int codePoint;
    private final String inputCommandName;
    private final EnumMap<InterpretationType, Interpretation> interpretationMap;
    private final MathCharacterInterpretation mathCharacterInterpretation;
    private final MathCharacterType type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MathCharacterType {
        ACCENT,
        ALPHA,
        BIN,
        CLOSE,
        FENCE,
        NUMERIC,
        OP,
        OPEN,
        ORD,
        PUNCT,
        REL
    }

    public MathCharacter(int i, String str, MathCharacterType mathCharacterType) {
        this.codePoint = i;
        this.inputCommandName = str;
        this.type = mathCharacterType;
        MathCharacterInterpretation mathCharacterInterpretation = new MathCharacterInterpretation(this);
        this.mathCharacterInterpretation = mathCharacterInterpretation;
        EnumMap<InterpretationType, Interpretation> enumMap = new EnumMap<>(InterpretationType.class);
        this.interpretationMap = enumMap;
        enumMap.put(InterpretationType.MATH_CHARACTER, mathCharacterInterpretation);
    }

    public void addInterpretation(Interpretation interpretation) {
        this.interpretationMap.put(interpretation.getType(), interpretation);
    }

    public String getChars() {
        return new String(Character.toChars(this.codePoint));
    }

    public int getCodePoint() {
        return this.codePoint;
    }

    public String getInputCommandName() {
        return this.inputCommandName;
    }

    @ObjectDumperOptions(DumpMode.IGNORE)
    @BeanToStringOptions(PropertyOptions.IGNORE_PROPERTY)
    public EnumMap<InterpretationType, Interpretation> getInterpretationMap() {
        return this.interpretationMap;
    }

    @ObjectDumperOptions(DumpMode.IGNORE)
    @BeanToStringOptions(PropertyOptions.IGNORE_PROPERTY)
    public MathCharacterInterpretation getMathCharacterInterpretation() {
        return this.mathCharacterInterpretation;
    }

    public MathCharacterType getType() {
        return this.type;
    }

    public String toString() {
        return ObjectUtilities.beanToString(this);
    }
}
