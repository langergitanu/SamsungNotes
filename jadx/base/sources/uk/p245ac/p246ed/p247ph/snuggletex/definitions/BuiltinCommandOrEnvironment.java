package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.EnumMap;
import java.util.EnumSet;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ConstraintUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public abstract class BuiltinCommandOrEnvironment<H> implements CommandOrEnvironment {
    protected final EnumSet<LaTeXMode> allowedModes;
    protected final boolean allowingOptionalArgument;
    protected final int argumentCount;
    protected final H domBuildingHandler;
    protected final EnumMap<InterpretationType, Interpretation> interpretationMap;
    protected final String texName;
    protected final TextFlowContext textFlowContext;

    public BuiltinCommandOrEnvironment(String str, boolean z, int i, EnumSet<LaTeXMode> enumSet, EnumMap<InterpretationType, Interpretation> enumMap, TextFlowContext textFlowContext, H h) {
        ConstraintUtilities.ensureNotNull(str, "texName");
        ConstraintUtilities.ensureNotNull(enumSet, "allowedModes");
        this.texName = str;
        this.allowingOptionalArgument = z;
        this.argumentCount = i;
        this.allowedModes = enumSet;
        this.interpretationMap = enumMap;
        this.textFlowContext = textFlowContext;
        this.domBuildingHandler = h;
    }

    public EnumSet<LaTeXMode> getAllowedModes() {
        return this.allowedModes;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment
    public int getArgumentCount() {
        return this.argumentCount;
    }

    public H getDOMBuildingHandler() {
        return this.domBuildingHandler;
    }

    public Interpretation getInterpretation(InterpretationType interpretationType) {
        EnumMap<InterpretationType, Interpretation> enumMap = this.interpretationMap;
        if (enumMap != null) {
            return enumMap.get(interpretationType);
        }
        return null;
    }

    public EnumMap<InterpretationType, Interpretation> getInterpretationMap() {
        return this.interpretationMap;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment
    public String getTeXName() {
        return this.texName;
    }

    public TextFlowContext getTextFlowContext() {
        return this.textFlowContext;
    }

    public boolean hasInterpretation(InterpretationType interpretationType) {
        EnumMap<InterpretationType, Interpretation> enumMap = this.interpretationMap;
        return enumMap != null && enumMap.containsKey(interpretationType);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.CommandOrEnvironment
    public boolean isAllowingOptionalArgument() {
        return this.allowingOptionalArgument;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.texName;
        if (str == null) {
            str = Log.TAG_SEPARATOR + Integer.toHexString(hashCode());
        }
        return AbstractC0622a.m1170p(str, ")", sb);
    }
}
