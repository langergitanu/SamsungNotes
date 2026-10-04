package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

import androidx.collection.AbstractC0622a;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.DumpMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectDumperOptions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@ObjectDumperOptions(DumpMode.TO_STRING)
public final class ComputedStyle {
    public static final ComputedStyle DEFAULT_STYLE = new ComputedStyle(null, FontFamily.NORMAL, FontSize.NORMALSIZE);
    private final FontFamily fontFamily;
    private final FontSize fontSize;
    private final ComputedStyle parentStyle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum FontFamily {
        NORMAL("div", "rm", "span", "rm", FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL),
        BF("div", "bf", "b", null, "bold"),
        RM("div", "rm", "span", "rm", FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL),
        EM("div", "em", "em", null, "italic"),
        IT("div", LangPackConfigConstants.LANGUAGE_CODE_IT, "i", null, "italic"),
        TT("div", "tt", "span", "tt", "monospace"),
        SC("div", "sc", "span", "sc", null),
        SL("div", "sl", "span", "sl", null),
        SF("div", "sf", "span", "sf", "sans-serif");

        private final String targetBlockCSSClassName;
        private final String targetBlockXHTMLElementName;
        private final String targetInlineCSSClassName;
        private final String targetInlineXHTMLElementName;
        private final String targetMathMLMathVariantName;

        FontFamily(String str, String str2, String str3, String str4, String str5) {
            this.targetBlockXHTMLElementName = str;
            this.targetBlockCSSClassName = str2;
            this.targetInlineXHTMLElementName = str3;
            this.targetInlineCSSClassName = str4;
            this.targetMathMLMathVariantName = str5;
        }

        public String getTargetBlockCSSClassName() {
            return this.targetBlockCSSClassName;
        }

        public String getTargetBlockXHTMLElementName() {
            return this.targetBlockXHTMLElementName;
        }

        public String getTargetInlineCSSClassName() {
            return this.targetInlineCSSClassName;
        }

        public String getTargetInlineXHTMLElementName() {
            return this.targetInlineXHTMLElementName;
        }

        public String getTargetMathMLMathVariantName() {
            return this.targetMathMLMathVariantName;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum FontSize {
        TINY("tiny"),
        SCRIPTSIZE("scriptsize"),
        FOOTNOTESIZE("footnotesize"),
        SMALL("small"),
        NORMALSIZE("normalsize"),
        LARGE("large"),
        LARGE_2("large2"),
        LARGE_3("large3"),
        HUGE("huge"),
        HUGE_2("huge2");

        private final String targetCSSClassName;

        FontSize(String str) {
            this.targetCSSClassName = str;
        }

        public String getTargetCSSClassName() {
            return this.targetCSSClassName;
        }
    }

    public ComputedStyle(ComputedStyle computedStyle, FontFamily fontFamily, FontSize fontSize) {
        this.parentStyle = computedStyle;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }

    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public FontSize getFontSize() {
        return this.fontSize;
    }

    public ComputedStyle getParentStyle() {
        return this.parentStyle;
    }

    public boolean isEquivalentTo(ComputedStyle computedStyle) {
        return this.fontFamily == computedStyle.fontFamily && this.fontSize == computedStyle.fontSize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ComputedStyle@");
        sb.append(Integer.toString(hashCode(), 16));
        sb.append("(fontFamily=");
        sb.append(this.fontFamily);
        sb.append(",fontSize=");
        sb.append(this.fontSize);
        sb.append(",parentStyle=");
        ComputedStyle computedStyle = this.parentStyle;
        return AbstractC0622a.m1170p(computedStyle != null ? Integer.toString(computedStyle.hashCode(), 16) : null, ")", sb);
    }
}
