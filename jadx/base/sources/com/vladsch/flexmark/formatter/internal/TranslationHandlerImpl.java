package com.vladsch.flexmark.formatter.internal;

import com.vladsch.flexmark.ast.AnchorRefTarget;
import com.vladsch.flexmark.formatter.FormatterOptions;
import com.vladsch.flexmark.formatter.MarkdownWriter;
import com.vladsch.flexmark.formatter.MergeContext;
import com.vladsch.flexmark.formatter.NodeFormatterContext;
import com.vladsch.flexmark.formatter.RenderPurpose;
import com.vladsch.flexmark.formatter.TranslatingSpanRender;
import com.vladsch.flexmark.formatter.TranslationHandler;
import com.vladsch.flexmark.formatter.TranslationPlaceholderGenerator;
import com.vladsch.flexmark.html.renderer.HtmlIdGenerator;
import com.vladsch.flexmark.html.renderer.HtmlIdGeneratorFactory;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TranslationHandlerImpl implements TranslationHandler {
    final HashMap<String, String> myAnchorTexts;
    final FormatterOptions myFormatterOptions;
    private HtmlIdGenerator myIdGenerator;
    final HtmlIdGeneratorFactory myIdGeneratorFactory;
    final ArrayList<String> myNonTranslatingSpans;
    final HashMap<String, String> myNonTranslatingTexts;
    final HashMap<String, String> myOriginalAnchors;
    final HashMap<String, Integer> myOriginalRefTargets;
    final Pattern myPlaceHolderMarkerPattern;
    private TranslationPlaceholderGenerator myPlaceholderGenerator;
    private RenderPurpose myRenderPurpose;
    final HashMap<String, String> myTranslatedAnchors;
    final HashMap<Integer, String> myTranslatedRefTargets;
    final ArrayList<String> myTranslatedSpans;
    final HashMap<String, String> myTranslatedTexts;
    final ArrayList<String> myTranslatingPlaceholders;
    final ArrayList<String> myTranslatingSpans;
    final HashMap<String, String> myTranslatingTexts;
    final MutableDataSet myTranslationStore;
    private MarkdownWriter myWriter;
    private int myPlaceholderId = 0;
    private int myAnchorId = 0;
    private int myTranslatingSpanId = 0;
    private int myNonTranslatingSpanId = 0;
    private Function<String, CharSequence> myNonTranslatingPostProcessor = null;
    private MergeContext myMergeContext = null;

    /* JADX INFO: renamed from: com.vladsch.flexmark.formatter.internal.TranslationHandlerImpl$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C118151 {
        static final /* synthetic */ int[] $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose;

        static {
            int[] iArr = new int[RenderPurpose.values().length];
            $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose = iArr;
            try {
                iArr[RenderPurpose.TRANSLATION_SPANS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[RenderPurpose.TRANSLATED_SPANS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[RenderPurpose.TRANSLATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[RenderPurpose.FORMAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public TranslationHandlerImpl(DataHolder dataHolder, HtmlIdGeneratorFactory htmlIdGeneratorFactory) {
        FormatterOptions formatterOptions = new FormatterOptions(dataHolder);
        this.myFormatterOptions = formatterOptions;
        this.myIdGeneratorFactory = htmlIdGeneratorFactory;
        this.myNonTranslatingTexts = new HashMap<>();
        this.myAnchorTexts = new HashMap<>();
        this.myTranslatingTexts = new HashMap<>();
        this.myTranslatedTexts = new HashMap<>();
        this.myOriginalAnchors = new HashMap<>();
        this.myTranslatedAnchors = new HashMap<>();
        this.myTranslatedRefTargets = new HashMap<>();
        this.myOriginalRefTargets = new HashMap<>();
        this.myTranslatingSpans = new ArrayList<>();
        this.myTranslatedSpans = new ArrayList<>();
        this.myTranslatingPlaceholders = new ArrayList<>();
        this.myNonTranslatingSpans = new ArrayList<>();
        this.myPlaceHolderMarkerPattern = Pattern.compile(formatterOptions.translationExcludePattern);
        this.myTranslationStore = new MutableDataSet();
    }

    public static String addPrefixSuffix(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        if (charSequence2 == null && charSequence3 == null && charSequence4 == null) {
            return charSequence.toString();
        }
        StringBuilder sb = new StringBuilder();
        if (charSequence2 != null) {
            sb.append(charSequence2);
        }
        sb.append(charSequence);
        if (charSequence3 != null) {
            sb.append(charSequence3);
        }
        if (charSequence4 != null) {
            sb.append(charSequence4);
        }
        return sb.toString();
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private String renderInSubContext(TranslatingSpanRender translatingSpanRender, boolean z) {
        MarkdownWriter markdownWriter = this.myWriter;
        NodeFormatterContext subContext = markdownWriter.getContext().getSubContext();
        MarkdownWriter markdown = subContext.getMarkdown();
        this.myWriter = markdown;
        translatingSpanRender.render(subContext, markdown);
        String string = markdown.toString(2, -1);
        this.myWriter = markdownWriter;
        if (z) {
            markdownWriter.append((CharSequence) string);
        }
        return string;
    }

    @Override // com.vladsch.flexmark.formatter.TranslationHandler
    public void beginRendering(@NotNull Document document, @NotNull NodeFormatterContext nodeFormatterContext, @NotNull MarkdownWriter markdownWriter) {
        this.myWriter = markdownWriter;
        HtmlIdGenerator htmlIdGeneratorCreate = this.myIdGeneratorFactory.create();
        this.myIdGenerator = htmlIdGeneratorCreate;
        htmlIdGeneratorCreate.generateIds(document);
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    public void customPlaceholderFormat(@NotNull TranslationPlaceholderGenerator translationPlaceholderGenerator, @NotNull TranslatingSpanRender translatingSpanRender) {
        if (this.myRenderPurpose != RenderPurpose.TRANSLATED_SPANS) {
            TranslationPlaceholderGenerator translationPlaceholderGenerator2 = this.myPlaceholderGenerator;
            this.myPlaceholderGenerator = translationPlaceholderGenerator;
            translatingSpanRender.render(this.myWriter.getContext(), this.myWriter);
            this.myPlaceholderGenerator = translationPlaceholderGenerator2;
        }
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    public HtmlIdGenerator getIdGenerator() {
        return this.myIdGenerator;
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    public MergeContext getMergeContext() {
        return this.myMergeContext;
    }

    public String getPlaceholderId(String str, int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        TranslationPlaceholderGenerator translationPlaceholderGenerator = this.myPlaceholderGenerator;
        String placeholder = translationPlaceholderGenerator != null ? translationPlaceholderGenerator.getPlaceholder(i) : String.format(str, Integer.valueOf(i));
        return (charSequence == null && charSequence2 == null && charSequence3 == null) ? placeholder : addPrefixSuffix(placeholder, charSequence, charSequence2, charSequence3);
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    @NotNull
    public RenderPurpose getRenderPurpose() {
        return this.myRenderPurpose;
    }

    @Override // com.vladsch.flexmark.formatter.TranslationHandler
    @NotNull
    public List<String> getTranslatingTexts() {
        this.myTranslatingPlaceholders.clear();
        this.myTranslatingPlaceholders.ensureCapacity(this.myTranslatedTexts.size() + this.myTranslatedSpans.size());
        ArrayList arrayList = new ArrayList(this.myTranslatedTexts.size() + this.myTranslatedSpans.size());
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : this.myTranslatingTexts.entrySet()) {
            if (isNotBlank(entry.getValue()) && !this.myPlaceHolderMarkerPattern.matcher(entry.getValue()).matches() && !map.containsKey(entry.getValue())) {
                map.put(entry.getValue(), Integer.valueOf(arrayList.size()));
                arrayList.add(entry.getValue());
                this.myTranslatingPlaceholders.add(entry.getKey());
            }
        }
        for (String str : this.myTranslatingSpans) {
            if (isNotBlank(str) && !this.myPlaceHolderMarkerPattern.matcher(str).matches()) {
                arrayList.add(str.toString());
            }
        }
        return arrayList;
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    public boolean isPostProcessingNonTranslating() {
        return this.myNonTranslatingPostProcessor != null;
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    public boolean isTransformingText() {
        return this.myRenderPurpose != RenderPurpose.FORMAT;
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    public void nonTranslatingSpan(@NotNull TranslatingSpanRender translatingSpanRender) {
        int i = C118151.$SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[this.myRenderPurpose.ordinal()];
        if (i == 1) {
            this.myNonTranslatingSpans.add(renderInSubContext(translatingSpanRender, false));
            int i2 = this.myNonTranslatingSpanId + 1;
            this.myNonTranslatingSpanId = i2;
            this.myWriter.append((CharSequence) getPlaceholderId(this.myFormatterOptions.translationIdFormat, i2, null, null, null));
            return;
        }
        if (i == 2) {
            renderInSubContext(translatingSpanRender, false);
            String str = this.myNonTranslatingSpans.get(this.myNonTranslatingSpanId);
            this.myNonTranslatingSpanId++;
            this.myWriter.append((CharSequence) str);
            return;
        }
        if (i != 3) {
            translatingSpanRender.render(this.myWriter.getContext(), this.myWriter);
        } else {
            renderInSubContext(translatingSpanRender, true);
            this.myNonTranslatingSpanId++;
        }
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    public void postProcessNonTranslating(@NotNull Function<String, CharSequence> function, @NotNull Runnable runnable) {
        Function<String, CharSequence> function2 = this.myNonTranslatingPostProcessor;
        try {
            this.myNonTranslatingPostProcessor = function;
            runnable.run();
        } finally {
            this.myNonTranslatingPostProcessor = function2;
        }
    }

    @Override // com.vladsch.flexmark.formatter.TranslationHandler
    public void setMergeContext(@NotNull MergeContext mergeContext) {
        this.myMergeContext = mergeContext;
    }

    @Override // com.vladsch.flexmark.formatter.TranslationHandler
    public void setRenderPurpose(@NotNull RenderPurpose renderPurpose) {
        this.myAnchorId = 0;
        this.myTranslatingSpanId = 0;
        this.myPlaceholderId = 0;
        this.myRenderPurpose = renderPurpose;
        this.myNonTranslatingSpanId = 0;
    }

    @Override // com.vladsch.flexmark.formatter.TranslationHandler
    public void setTranslatedTexts(@NotNull List<? extends CharSequence> list) {
        this.myTranslatedTexts.clear();
        this.myTranslatedTexts.putAll(this.myTranslatingTexts);
        this.myTranslatedSpans.clear();
        this.myTranslatedSpans.ensureCapacity(this.myTranslatingSpans.size());
        list.size();
        int size = this.myTranslatingPlaceholders.size();
        HashMap map = new HashMap();
        int i = 0;
        for (Map.Entry<String, String> entry : this.myTranslatingTexts.entrySet()) {
            if (isNotBlank(entry.getValue()) && !this.myPlaceHolderMarkerPattern.matcher(entry.getValue()).matches()) {
                Integer num = (Integer) map.get(entry.getValue());
                if (num != null) {
                    this.myTranslatedTexts.put(entry.getKey(), list.get(num.intValue()).toString());
                } else {
                    if (i >= size) {
                        break;
                    }
                    map.put(entry.getValue(), Integer.valueOf(i));
                    this.myTranslatedTexts.put(entry.getKey(), list.get(i).toString());
                    i++;
                }
            }
        }
        for (String str : this.myTranslatingSpans) {
            if (!isNotBlank(str) || this.myPlaceHolderMarkerPattern.matcher(str).matches()) {
                this.myTranslatedSpans.add(str.toString());
            } else {
                this.myTranslatedSpans.add(list.get(i).toString());
                i++;
            }
        }
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    @NotNull
    public CharSequence transformAnchorRef(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        String str;
        int i = C118151.$SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[this.myRenderPurpose.ordinal()];
        if (i == 1) {
            String str2 = this.myFormatterOptions.translationIdFormat;
            int i2 = this.myAnchorId + 1;
            this.myAnchorId = i2;
            String str3 = String.format(str2, Integer.valueOf(i2));
            this.myAnchorTexts.put(str3, charSequence2.toString());
            return str3;
        }
        if (i == 2) {
            String str4 = this.myFormatterOptions.translationIdFormat;
            int i4 = this.myAnchorId + 1;
            this.myAnchorId = i4;
            return String.format(str4, Integer.valueOf(i4));
        }
        if (i == 3) {
            String str5 = this.myFormatterOptions.translationIdFormat;
            int i5 = this.myAnchorId + 1;
            this.myAnchorId = i5;
            String str6 = String.format(str5, Integer.valueOf(i5));
            String str7 = this.myNonTranslatingTexts.get(charSequence.toString());
            if (str7 == null || str7.length() != 0) {
                String str8 = this.myAnchorTexts.get(str6);
                if (str8 != null) {
                    return str8;
                }
            } else {
                String str9 = this.myAnchorTexts.get(str6);
                if (str9 != null) {
                    Integer num = this.myOriginalRefTargets.get(str9);
                    return (num == null || (str = this.myTranslatedRefTargets.get(num)) == null) ? str9 : str;
                }
            }
        }
        return charSequence2;
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    @NotNull
    public CharSequence transformNonTranslating(CharSequence charSequence, @NotNull CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        if (charSequence4 == null) {
            charSequence4 = BasedSequence.m13437of(charSequence2).trimmedEOL();
        }
        CharSequence charSequence5 = charSequence4;
        int i = C118151.$SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[this.myRenderPurpose.ordinal()];
        if (i == 1) {
            String str = this.myFormatterOptions.translationIdFormat;
            int i2 = this.myPlaceholderId + 1;
            this.myPlaceholderId = i2;
            String placeholderId = getPlaceholderId(str, i2, charSequence, charSequence3, charSequence5);
            Function<String, CharSequence> function = this.myNonTranslatingPostProcessor;
            if (function != null) {
                placeholderId = function.apply(placeholderId).toString();
            }
            this.myNonTranslatingTexts.put(placeholderId, charSequence2.toString());
            return placeholderId;
        }
        if (i == 2) {
            String str2 = this.myFormatterOptions.translationIdFormat;
            int i4 = this.myPlaceholderId + 1;
            this.myPlaceholderId = i4;
            String placeholderId2 = getPlaceholderId(str2, i4, charSequence, charSequence3, charSequence5);
            Function<String, CharSequence> function2 = this.myNonTranslatingPostProcessor;
            return function2 != null ? function2.apply(placeholderId2) : placeholderId2;
        }
        if (i != 3 || charSequence2.length() <= 0) {
            return charSequence2;
        }
        String str3 = this.myNonTranslatingTexts.get(charSequence2.toString());
        if (str3 == null) {
            str3 = "";
        }
        Function<String, CharSequence> function3 = this.myNonTranslatingPostProcessor;
        return function3 != null ? function3.apply(str3) : str3;
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    @NotNull
    public CharSequence transformTranslating(CharSequence charSequence, @NotNull CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        int i = C118151.$SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[this.myRenderPurpose.ordinal()];
        if (i == 1) {
            String str = this.myFormatterOptions.translationIdFormat;
            int i2 = this.myPlaceholderId + 1;
            this.myPlaceholderId = i2;
            String placeholderId = getPlaceholderId(str, i2, charSequence, charSequence3, charSequence4);
            this.myTranslatingTexts.put(placeholderId, charSequence2.toString());
            return placeholderId;
        }
        if (i == 2) {
            String str2 = this.myFormatterOptions.translationIdFormat;
            int i4 = this.myPlaceholderId + 1;
            this.myPlaceholderId = i4;
            return getPlaceholderId(str2, i4, charSequence, charSequence3, charSequence4);
        }
        if (i == 3) {
            String str3 = this.myTranslatedTexts.get(((charSequence == null && charSequence3 == null && charSequence4 == null) ? charSequence2 : addPrefixSuffix(charSequence2, charSequence, charSequence3, charSequence4)).toString());
            if (str3 != null && (charSequence != null || charSequence3 != null || charSequence4 != null)) {
                return addPrefixSuffix(str3, charSequence, charSequence3, charSequence4);
            }
            if (str3 != null) {
                return str3;
            }
        }
        return charSequence2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vladsch.flexmark.formatter.TranslationContext
    public void translatingRefTargetSpan(@Nullable Node node, @NotNull TranslatingSpanRender translatingSpanRender) {
        int i = C118151.$SwitchMap$com$vladsch$flexmark$formatter$RenderPurpose[this.myRenderPurpose.ordinal()];
        if (i == 1) {
            String strRenderInSubContext = renderInSubContext(translatingSpanRender, true);
            if (node != 0 && (!(node instanceof AnchorRefTarget) || !((AnchorRefTarget) node).isExplicitAnchorRefId())) {
                this.myOriginalRefTargets.put(this.myIdGenerator.getId(node), Integer.valueOf(this.myTranslatingSpans.size()));
            }
            this.myTranslatingSpans.add(strRenderInSubContext);
            return;
        }
        if (i == 2) {
            renderInSubContext(translatingSpanRender, false);
            String str = this.myTranslatedSpans.get(this.myTranslatingSpanId);
            if (node != 0 && (!(node instanceof AnchorRefTarget) || !((AnchorRefTarget) node).isExplicitAnchorRefId())) {
                this.myTranslatedRefTargets.put(Integer.valueOf(this.myTranslatingSpanId), this.myIdGenerator.getId(str));
            }
            this.myTranslatingSpanId++;
            this.myWriter.append((CharSequence) str);
            return;
        }
        if (i != 3) {
            translatingSpanRender.render(this.myWriter.getContext(), this.myWriter);
            return;
        }
        if (node != 0 && (!(node instanceof AnchorRefTarget) || !((AnchorRefTarget) node).isExplicitAnchorRefId())) {
            this.myTranslatedRefTargets.put(Integer.valueOf(this.myTranslatingSpanId), this.myIdGenerator.getId(node));
        }
        this.myTranslatingSpanId++;
        renderInSubContext(translatingSpanRender, true);
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    public void translatingSpan(@NotNull TranslatingSpanRender translatingSpanRender) {
        translatingRefTargetSpan(null, translatingSpanRender);
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    @NotNull
    public MutableDataSet getTranslationStore() {
        return this.myTranslationStore;
    }

    @Override // com.vladsch.flexmark.formatter.TranslationContext
    @NotNull
    public <T> T postProcessNonTranslating(@NotNull Function<String, CharSequence> function, @NotNull Supplier<T> supplier) {
        Function<String, CharSequence> function2 = this.myNonTranslatingPostProcessor;
        try {
            this.myNonTranslatingPostProcessor = function;
            return supplier.get();
        } finally {
            this.myNonTranslatingPostProcessor = function2;
        }
    }
}
