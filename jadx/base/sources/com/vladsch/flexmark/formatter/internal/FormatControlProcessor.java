package com.vladsch.flexmark.formatter.internal;

import com.vladsch.flexmark.ast.HtmlCommentBlock;
import com.vladsch.flexmark.ast.HtmlInnerBlockComment;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.formatter.FormatterOptions;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FormatControlProcessor {
    public static final String CLOSE_COMMENT = "-->";
    public static final String OPEN_COMMENT = "<!--";
    private volatile Pattern formatterOffPattern;
    private final String formatterOffTag;
    private volatile Pattern formatterOnPattern;
    private final String formatterOnTag;
    private boolean formatterTagsAcceptRegexp;
    private final boolean formatterTagsEnabled;
    private boolean myFormatterOff = false;
    private boolean justTurnedOffFormatting = false;
    private boolean justTurnedOnFormatting = false;

    public FormatControlProcessor(@NotNull Document document, @Nullable DataHolder dataHolder) {
        FormatterOptions formatterOptions = new FormatterOptions(dataHolder);
        this.formatterOnTag = formatterOptions.formatterOnTag;
        this.formatterOffTag = formatterOptions.formatterOffTag;
        this.formatterTagsEnabled = formatterOptions.formatterTagsEnabled;
        this.formatterTagsAcceptRegexp = formatterOptions.formatterTagsAcceptRegexp;
    }

    @Nullable
    private Pattern getPatternOrDisableRegexp(@NotNull String str) {
        try {
            return Pattern.compile(str);
        } catch (PatternSyntaxException unused) {
            this.formatterTagsAcceptRegexp = false;
            return null;
        }
    }

    @Nullable
    private Boolean isFormatterOffTag(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String strTrim = charSequence.toString().trim().substring(4, r4.length() - 3).trim();
        if (!this.formatterTagsAcceptRegexp || this.formatterOffPattern == null || this.formatterOnPattern == null) {
            if (this.formatterTagsEnabled) {
                if (strTrim.equals(this.formatterOnTag)) {
                    return Boolean.FALSE;
                }
                if (strTrim.equals(this.formatterOffTag)) {
                    return Boolean.TRUE;
                }
            }
        } else {
            if (this.formatterOnPattern.matcher(strTrim).matches()) {
                return Boolean.FALSE;
            }
            if (this.formatterOffPattern.matcher(strTrim).matches()) {
                return Boolean.TRUE;
            }
        }
        return null;
    }

    @Nullable
    public Pattern getFormatterOffPattern() {
        if (this.formatterOffPattern == null && this.formatterTagsEnabled && this.formatterTagsAcceptRegexp) {
            this.formatterOffPattern = getPatternOrDisableRegexp(this.formatterOffTag);
        }
        return this.formatterOffPattern;
    }

    public String getFormatterOffTag() {
        return this.formatterOffTag;
    }

    @Nullable
    public Pattern getFormatterOnPattern() {
        if (this.formatterOffPattern == null && this.formatterTagsEnabled && this.formatterTagsAcceptRegexp) {
            this.formatterOnPattern = getPatternOrDisableRegexp(this.formatterOnTag);
        }
        return this.formatterOnPattern;
    }

    public String getFormatterOnTag() {
        return this.formatterOnTag;
    }

    public boolean getFormatterRegExEnabled() {
        return this.formatterTagsAcceptRegexp;
    }

    public boolean getFormatterTagsEnabled() {
        return this.formatterTagsEnabled;
    }

    public void initializeFrom(@NotNull Node node) {
        this.myFormatterOff = !isFormattingRegion(node.getStartOffset(), node, true);
    }

    public boolean isFormattingOff() {
        return this.myFormatterOff;
    }

    public boolean isFormattingRegion() {
        return !this.myFormatterOff;
    }

    public boolean isJustTurnedOffFormatting() {
        return this.justTurnedOffFormatting;
    }

    public boolean isJustTurnedOnFormatting() {
        return this.justTurnedOnFormatting;
    }

    public void processFormatControl(@NotNull Node node) {
        this.justTurnedOffFormatting = false;
        this.justTurnedOnFormatting = false;
        if (((node instanceof HtmlCommentBlock) || (node instanceof HtmlInnerBlockComment)) && this.formatterTagsEnabled) {
            boolean z = this.myFormatterOff;
            Boolean boolIsFormatterOffTag = isFormatterOffTag(node.getChars());
            if (boolIsFormatterOffTag == null) {
                return;
            }
            boolean zBooleanValue = boolIsFormatterOffTag.booleanValue();
            this.myFormatterOff = zBooleanValue;
            if (!z && zBooleanValue) {
                this.justTurnedOffFormatting = true;
            }
            if (!z || zBooleanValue) {
                return;
            }
            this.justTurnedOnFormatting = true;
        }
    }

    private boolean isFormattingRegion(int i, @NotNull Node node, boolean z) {
        Boolean boolIsFormatterOffTag;
        while (node != null) {
            if (node.getStartOffset() <= i) {
                if ((node instanceof Block) && !(node instanceof Paragraph) && node.hasChildren()) {
                    Node lastChild = node.getLastChild();
                    return lastChild != null && isFormattingRegion(i, lastChild, false);
                }
                if (((node instanceof HtmlCommentBlock) || (node instanceof HtmlInnerBlockComment)) && (boolIsFormatterOffTag = isFormatterOffTag(node.getChars())) != null) {
                    return !boolIsFormatterOffTag.booleanValue();
                }
            }
            if (node.getPrevious() == null && z) {
                node = node.getParent();
                if (node instanceof Document) {
                    break;
                }
                if (node != null) {
                    node = node.getPrevious();
                }
            } else {
                node = node.getPrevious();
            }
        }
        return true;
    }

    public boolean isFormattingRegion(@NotNull Node node) {
        if (!this.formatterTagsEnabled || node.getStartOffset() == 0) {
            return true;
        }
        return isFormattingRegion(node.getStartOffset(), node, true);
    }
}
