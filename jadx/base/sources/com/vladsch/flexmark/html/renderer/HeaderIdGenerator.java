package com.vladsch.flexmark.html.renderer;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.vladsch.flexmark.ast.AnchorRefTarget;
import com.vladsch.flexmark.ast.util.AnchorRefTargetBlockPreVisitor;
import com.vladsch.flexmark.ast.util.AnchorRefTargetBlockVisitor;
import com.vladsch.flexmark.html.Disposable;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HeaderIdGenerator implements HtmlIdGenerator, Disposable {
    HashMap<String, Integer> headerBaseIds;
    boolean noDupedDashes;
    boolean nonAsciiToLowercase;
    String nonDashChars;
    boolean resolveDupes;
    String toDashChars;

    public HeaderIdGenerator() {
        this(null);
    }

    public static boolean isAlphabetic(char c) {
        return ((1086 >> Character.getType((int) c)) & 1) != 0;
    }

    @Override // com.vladsch.flexmark.html.Disposable
    public void dispose() {
        this.headerBaseIds = null;
    }

    public String generateId(String str) {
        if (str.isEmpty()) {
            return null;
        }
        String strGenerateId = generateId(str, this.toDashChars, this.nonDashChars, this.noDupedDashes, this.nonAsciiToLowercase);
        if (this.resolveDupes) {
            if (this.headerBaseIds.containsKey(strGenerateId)) {
                int iIntValue = this.headerBaseIds.get(strGenerateId).intValue() + 1;
                this.headerBaseIds.put(strGenerateId, Integer.valueOf(iIntValue));
                return strGenerateId + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + iIntValue;
            }
            this.headerBaseIds.put(strGenerateId, 0);
        }
        return strGenerateId;
    }

    @Override // com.vladsch.flexmark.html.renderer.HtmlIdGenerator
    public void generateIds(@NotNull Document document) {
        generateIds(document, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vladsch.flexmark.html.renderer.HtmlIdGenerator
    @Nullable
    public String getId(@NotNull Node node) {
        if (node instanceof AnchorRefTarget) {
            return ((AnchorRefTarget) node).getAnchorRefId();
        }
        return null;
    }

    public String getNonDashChars() {
        return this.nonDashChars;
    }

    public String getToDashChars() {
        return this.toDashChars;
    }

    public boolean isNoDupedDashes() {
        return this.noDupedDashes;
    }

    public boolean isNonAsciiToLowercase() {
        return this.nonAsciiToLowercase;
    }

    public boolean isResolveDupes() {
        return this.resolveDupes;
    }

    public void setNoDupedDashes(boolean z) {
        this.noDupedDashes = z;
    }

    public void setNonAsciiToLowercase(boolean z) {
        this.nonAsciiToLowercase = z;
    }

    public void setNonDashChars(String str) {
        this.nonDashChars = str;
    }

    public void setResolveDupes(boolean z) {
        this.resolveDupes = z;
    }

    public void setToDashChars(String str) {
        this.toDashChars = str;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements HeaderIdGeneratorFactory {
        @Override // com.vladsch.flexmark.html.renderer.HeaderIdGeneratorFactory
        @NotNull
        public HeaderIdGenerator create(@NotNull LinkResolverContext linkResolverContext) {
            return new HeaderIdGenerator();
        }

        @Override // com.vladsch.flexmark.html.renderer.HtmlIdGeneratorFactory
        @NotNull
        public HeaderIdGenerator create() {
            return new HeaderIdGenerator();
        }
    }

    public HeaderIdGenerator(@Nullable DataHolder dataHolder) {
        this.headerBaseIds = new HashMap<>();
        this.resolveDupes = HtmlRenderer.HEADER_ID_GENERATOR_RESOLVE_DUPES.get(dataHolder).booleanValue();
        this.toDashChars = HtmlRenderer.HEADER_ID_GENERATOR_TO_DASH_CHARS.get(dataHolder);
        this.nonDashChars = HtmlRenderer.HEADER_ID_GENERATOR_NON_DASH_CHARS.get(dataHolder);
        this.noDupedDashes = HtmlRenderer.HEADER_ID_GENERATOR_NO_DUPED_DASHES.get(dataHolder).booleanValue();
        this.nonAsciiToLowercase = HtmlRenderer.HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE.get(dataHolder).booleanValue();
    }

    @Override // com.vladsch.flexmark.html.renderer.HtmlIdGenerator
    public void generateIds(Document document, @Nullable final AnchorRefTargetBlockPreVisitor anchorRefTargetBlockPreVisitor) {
        this.headerBaseIds.clear();
        this.resolveDupes = HtmlRenderer.HEADER_ID_GENERATOR_RESOLVE_DUPES.get(document).booleanValue();
        this.toDashChars = HtmlRenderer.HEADER_ID_GENERATOR_TO_DASH_CHARS.get(document);
        this.nonDashChars = HtmlRenderer.HEADER_ID_GENERATOR_NON_DASH_CHARS.get(document);
        this.noDupedDashes = HtmlRenderer.HEADER_ID_GENERATOR_NO_DUPED_DASHES.get(document).booleanValue();
        this.nonAsciiToLowercase = HtmlRenderer.HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE.get(document).booleanValue();
        new AnchorRefTargetBlockVisitor() { // from class: com.vladsch.flexmark.html.renderer.HeaderIdGenerator.1
            @Override // com.vladsch.flexmark.ast.util.AnchorRefTargetBlockVisitor
            public boolean preVisit(@NotNull Node node) {
                AnchorRefTargetBlockPreVisitor anchorRefTargetBlockPreVisitor2 = anchorRefTargetBlockPreVisitor;
                return anchorRefTargetBlockPreVisitor2 == null || anchorRefTargetBlockPreVisitor2.preVisit(node, this);
            }

            @Override // com.vladsch.flexmark.ast.util.AnchorRefTargetBlockVisitor
            public void visit(AnchorRefTarget anchorRefTarget) {
                if (anchorRefTarget.getAnchorRefId().isEmpty()) {
                    String strGenerateId = HeaderIdGenerator.this.generateId(anchorRefTarget.getAnchorRefText());
                    if (strGenerateId != null) {
                        anchorRefTarget.setAnchorRefId(strGenerateId);
                    }
                }
            }
        }.visit(document);
    }

    @Override // com.vladsch.flexmark.html.renderer.HtmlIdGenerator
    @Nullable
    public String getId(@NotNull CharSequence charSequence) {
        return generateId(charSequence.toString());
    }

    public static String generateId(CharSequence charSequence, String str, boolean z, boolean z2) {
        return generateId(charSequence, str, null, z, z2);
    }

    public static String generateId(CharSequence charSequence, String str, String str2, boolean z, boolean z2) {
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        if (str == null) {
            str = HtmlRenderer.HEADER_ID_GENERATOR_TO_DASH_CHARS.get(null);
        }
        if (str2 == null) {
            str2 = HtmlRenderer.HEADER_ID_GENERATOR_NON_DASH_CHARS.get(null);
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (isAlphabetic(cCharAt)) {
                if (!z2 && (cCharAt < 'A' || cCharAt > 'Z')) {
                    sb.append(cCharAt);
                } else {
                    sb.append(Character.toLowerCase(cCharAt));
                }
            } else if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            } else if (str2.indexOf(cCharAt) != -1) {
                sb.append(cCharAt);
            } else if (str.indexOf(cCharAt) != -1 && (!z || ((cCharAt == '-' && sb.length() == 0) || (sb.length() != 0 && sb.charAt(sb.length() - 1) != '-')))) {
                sb.append('-');
            }
        }
        return sb.toString();
    }
}
