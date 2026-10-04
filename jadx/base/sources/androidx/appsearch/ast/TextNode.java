package androidx.appsearch.ast;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.core.util.Preconditions;
import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
public final class TextNode implements Node {
    private boolean mPrefix;
    private String mValue;
    private boolean mVerbatim;

    public TextNode(String str) {
        this.mPrefix = false;
        this.mVerbatim = false;
        this.mValue = (String) Preconditions.checkNotNull(str);
    }

    private void escapeString(StringBuilder sb) {
        for (int i = 0; i < this.mValue.length(); i++) {
            char cCharAt = this.mValue.charAt(i);
            if ((!this.mVerbatim && isSpecialCharacter(cCharAt)) || cCharAt == '\"') {
                sb.append('\\');
            } else if (!this.mVerbatim && isLatinLetter(cCharAt) && Character.isUpperCase(cCharAt)) {
                cCharAt = Character.toLowerCase(cCharAt);
            }
            sb.append(cCharAt);
        }
    }

    private boolean isLatinLetter(char c) {
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    private boolean isSpecialCharacter(char c) {
        if (c == '\"' || c == '&' || c == ':' || c == '\\' || c == '|') {
            return true;
        }
        switch (c) {
            case '(':
            case ')':
            case '*':
                return true;
            default:
                switch (c) {
                    case ',':
                    case '-':
                    case '.':
                        return true;
                    default:
                        switch (c) {
                            case '<':
                            case '=':
                            case '>':
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TextNode.class == obj.getClass()) {
            TextNode textNode = (TextNode) obj;
            if (this.mPrefix == textNode.mPrefix && this.mVerbatim == textNode.mVerbatim && Objects.equals(this.mValue, textNode.mValue)) {
                return true;
            }
        }
        return false;
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return Objects.hash(this.mValue, Boolean.valueOf(this.mPrefix), Boolean.valueOf(this.mVerbatim));
    }

    public boolean isPrefix() {
        return this.mPrefix;
    }

    public boolean isVerbatim() {
        return this.mVerbatim;
    }

    public void setPrefix(boolean z) {
        this.mPrefix = z;
    }

    public void setValue(String str) {
        this.mValue = (String) Preconditions.checkNotNull(str);
    }

    public void setVerbatim(boolean z) {
        this.mVerbatim = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PropertyUtils.MAPPED_DELIM);
        if (this.mVerbatim) {
            sb.append('\"');
        }
        escapeString(sb);
        if (this.mVerbatim) {
            sb.append('\"');
        }
        if (this.mPrefix) {
            sb.append('*');
        }
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }

    public TextNode(TextNode textNode) {
        this.mPrefix = false;
        this.mVerbatim = false;
        Preconditions.checkNotNull(textNode);
        this.mValue = textNode.mValue;
        this.mPrefix = textNode.mPrefix;
        this.mVerbatim = textNode.mVerbatim;
    }
}
