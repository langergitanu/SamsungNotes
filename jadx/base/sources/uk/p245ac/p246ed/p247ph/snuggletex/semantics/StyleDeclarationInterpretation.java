package uk.p245ac.p246ed.p247ph.snuggletex.semantics;

import uk.p245ac.p246ed.p247ph.snuggletex.definitions.ComputedStyle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public enum StyleDeclarationInterpretation implements Interpretation {
    BF(ComputedStyle.FontFamily.BF, null),
    RM(ComputedStyle.FontFamily.RM, null),
    EM(ComputedStyle.FontFamily.EM, null),
    IT(ComputedStyle.FontFamily.IT, null),
    TT(ComputedStyle.FontFamily.TT, null),
    SC(ComputedStyle.FontFamily.SC, null),
    SL(ComputedStyle.FontFamily.SL, null),
    SF(ComputedStyle.FontFamily.SF, null),
    TINY(null, ComputedStyle.FontSize.TINY),
    SCRIPTSIZE(null, ComputedStyle.FontSize.SCRIPTSIZE),
    FOOTNOTESIZE(null, ComputedStyle.FontSize.FOOTNOTESIZE),
    SMALL(null, ComputedStyle.FontSize.SMALL),
    NORMALSIZE(null, ComputedStyle.FontSize.NORMALSIZE),
    LARGE(null, ComputedStyle.FontSize.LARGE),
    LARGE_2(null, ComputedStyle.FontSize.LARGE_2),
    LARGE_3(null, ComputedStyle.FontSize.LARGE_3),
    HUGE(null, ComputedStyle.FontSize.HUGE),
    HUGE_2(null, ComputedStyle.FontSize.HUGE_2);

    private final ComputedStyle.FontFamily fontFamily;
    private final ComputedStyle.FontSize fontSize;

    StyleDeclarationInterpretation(ComputedStyle.FontFamily fontFamily, ComputedStyle.FontSize fontSize) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }

    public ComputedStyle.FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public ComputedStyle.FontSize getFontSize() {
        return this.fontSize;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation
    public InterpretationType getType() {
        return InterpretationType.STYLE_DECLARATION;
    }
}
