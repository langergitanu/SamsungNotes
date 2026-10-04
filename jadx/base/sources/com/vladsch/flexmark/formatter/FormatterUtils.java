package com.vladsch.flexmark.formatter;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import com.vladsch.flexmark.ast.HtmlCommentBlock;
import com.vladsch.flexmark.ast.HtmlInlineComment;
import com.vladsch.flexmark.ast.HtmlInnerBlockComment;
import com.vladsch.flexmark.ast.ListBlock;
import com.vladsch.flexmark.ast.ListItem;
import com.vladsch.flexmark.ast.OrderedList;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ast.ParagraphContainer;
import com.vladsch.flexmark.ast.SoftLineBreak;
import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.BlankLine;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockQuoteLike;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.DataKeyBase;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.NullableDataKey;
import com.vladsch.flexmark.util.format.MarkdownParagraph;
import com.vladsch.flexmark.util.format.TrackedOffset;
import com.vladsch.flexmark.util.format.TrackedOffsetList;
import com.vladsch.flexmark.util.format.options.BlockQuoteMarker;
import com.vladsch.flexmark.util.format.options.ListBulletMarker;
import com.vladsch.flexmark.util.format.options.ListNumberedMarker;
import com.vladsch.flexmark.util.format.options.ListSpacing;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.LineAppendable;
import com.vladsch.flexmark.util.sequence.LineInfo;
import com.vladsch.flexmark.util.sequence.RepeatedSequence;
import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
import com.vladsch.flexmark.util.sequence.mappers.SpaceMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;
import p074R1.C0232d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FormatterUtils {
    public static final DataKey<Function<CharSequence, Pair<Integer, Integer>>> LIST_ALIGN_NUMERIC;
    public static final NullableDataKey<ListSpacing> LIST_ITEM_SPACING;
    public static final Function<CharSequence, Pair<Integer, Integer>> NULL_PADDING;
    public static final DataKey<Integer> LIST_ITEM_NUMBER = new DataKey<>("LIST_ITEM_NUMBER", 0);
    public static final DataKey<Boolean> FIRST_LIST_ITEM_CHILD = new DataKey<>("FIRST_LIST_ITEM_CHILD", Boolean.FALSE);

    /* JADX INFO: renamed from: com.vladsch.flexmark.formatter.FormatterUtils$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C118051 {

        /* JADX INFO: renamed from: $SwitchMap$com$vladsch$flexmark$util$format$options$BlockQuoteMarker */
        static final /* synthetic */ int[] f8317xfb62d5f0;

        /* JADX INFO: renamed from: $SwitchMap$com$vladsch$flexmark$util$format$options$ListBulletMarker */
        static final /* synthetic */ int[] f8318x804d0e81;

        /* JADX INFO: renamed from: $SwitchMap$com$vladsch$flexmark$util$format$options$ListNumberedMarker */
        static final /* synthetic */ int[] f8319x62073967;
        static final /* synthetic */ int[] $SwitchMap$com$vladsch$flexmark$util$format$options$ListSpacing;

        static {
            int[] iArr = new int[ListBulletMarker.values().length];
            f8318x804d0e81 = iArr;
            try {
                iArr[ListBulletMarker.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8318x804d0e81[ListBulletMarker.DASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8318x804d0e81[ListBulletMarker.ASTERISK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8318x804d0e81[ListBulletMarker.PLUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ListNumberedMarker.values().length];
            f8319x62073967 = iArr2;
            try {
                iArr2[ListNumberedMarker.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8319x62073967[ListNumberedMarker.DOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8319x62073967[ListNumberedMarker.PAREN.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[ListSpacing.values().length];
            $SwitchMap$com$vladsch$flexmark$util$format$options$ListSpacing = iArr3;
            try {
                iArr3[ListSpacing.AS_IS.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$util$format$options$ListSpacing[ListSpacing.LOOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$util$format$options$ListSpacing[ListSpacing.TIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$util$format$options$ListSpacing[ListSpacing.LOOSEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$util$format$options$ListSpacing[ListSpacing.TIGHTEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr4 = new int[BlockQuoteMarker.values().length];
            f8317xfb62d5f0 = iArr4;
            try {
                iArr4[BlockQuoteMarker.AS_IS.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f8317xfb62d5f0[BlockQuoteMarker.ADD_COMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f8317xfb62d5f0[BlockQuoteMarker.ADD_COMPACT_WITH_SPACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f8317xfb62d5f0[BlockQuoteMarker.ADD_SPACED.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    static {
        C11812f c11812f = new C11812f(2);
        NULL_PADDING = c11812f;
        LIST_ALIGN_NUMERIC = new DataKey<>("LIST_ITEM_NUMBER", c11812f);
        LIST_ITEM_SPACING = new NullableDataKey<>("LIST_ITEM_SPACING");
    }

    public static void appendWhiteSpaceBetween(MarkdownWriter markdownWriter, Node node, Node node2, boolean z, boolean z2, boolean z3) {
        if (node2 == null || node == null) {
            return;
        }
        if (z || z2) {
            appendWhiteSpaceBetween(markdownWriter, node.getChars(), node2.getChars(), z, z2, z3);
        }
    }

    @NotNull
    public static String getActualAdditionalPrefix(BasedSequence basedSequence, MarkdownWriter markdownWriter) {
        return RepeatedSequence.repeatOf(" ", Utils.minLimit(0, basedSequence.baseColumnAtStart() - markdownWriter.getPrefix().length())).toString();
    }

    @NotNull
    public static String getAdditionalPrefix(BasedSequence basedSequence, BasedSequence basedSequence2) {
        return RepeatedSequence.repeatOf(" ", Utils.minLimit(0, basedSequence2.getStartOffset() - basedSequence.getStartOffset())).toString();
    }

    public static String getBlockLikePrefix(BlockQuoteLike blockQuoteLike, NodeFormatterContext nodeFormatterContext, BlockQuoteMarker blockQuoteMarker, @NotNull BasedSequence basedSequence) {
        boolean z;
        String string = blockQuoteLike.getOpeningMarker().toString();
        int i = C118051.f8317xfb62d5f0[blockQuoteMarker.ordinal()];
        if (i != 1) {
            if (i == 2) {
                string = string.trim();
            } else {
                if (i == 3) {
                    string = AbstractC0541b.m756B(string.trim(), " ");
                    z = true;
                    CharPredicate blockQuoteLikePrefixPredicate = nodeFormatterContext.getBlockQuoteLikePrefixPredicate();
                    String string2 = basedSequence.toString();
                    return (z || !string2.endsWith(" ") || string2.length() < 2 || !blockQuoteLikePrefixPredicate.test(string2.charAt(string2.length() - 2))) ? AbstractC0541b.m756B(string2, string) : AbstractC0541b.m756B(AbstractC2322a.m1614d(1, 0, string2), string);
                }
                if (i != 4) {
                    throw new IllegalStateException("Unexpected value: " + blockQuoteMarker);
                }
                string = AbstractC0541b.m756B(string.trim(), " ");
            }
        } else if (blockQuoteLike.getFirstChild() != null) {
            string = blockQuoteLike.getChars().baseSubSequence(blockQuoteLike.getOpeningMarker().getStartOffset(), blockQuoteLike.getFirstChild().getStartOffset()).toString();
        }
        z = false;
        CharPredicate blockQuoteLikePrefixPredicate2 = nodeFormatterContext.getBlockQuoteLikePrefixPredicate();
        String string22 = basedSequence.toString();
        if (z) {
        }
    }

    public static BasedSequence getSoftLineBreakSpan(Node node) {
        if (node == null) {
            return BasedSequence.NULL;
        }
        Node node2 = node;
        for (Node next = node.getNext(); next != null && !(next instanceof SoftLineBreak); next = next.getNext()) {
            node2 = next;
        }
        return Node.spanningChars(node.getChars(), node2.getChars());
    }

    public static boolean hasLooseItems(Iterable<Node> iterable) {
        for (Node node : iterable) {
            if ((node instanceof ListItem) && !((ListItem) node).isOwnTight() && node.getNext() != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFollowedByBlankLine(@Nullable Node node) {
        while (node != null) {
            if (node.getNextAnyNot(HtmlCommentBlock.class, HtmlInnerBlockComment.class, HtmlInlineComment.class) instanceof BlankLine) {
                return true;
            }
            if (node.getNextAnyNot(BlankLine.class, HtmlCommentBlock.class, HtmlInnerBlockComment.class, HtmlInlineComment.class) != null) {
                return false;
            }
            node = node.getParent();
        }
        return false;
    }

    public static boolean isLastOfItem(@Nullable Node node) {
        return node != null && node.getNextAnyNot(BlankLine.class, HtmlCommentBlock.class, HtmlInnerBlockComment.class, HtmlInlineComment.class) == null;
    }

    public static boolean isNotLastItem(@Nullable Node node) {
        while (node != null && !(node instanceof Document)) {
            if (node.getNextAnyNot(BlankLine.class, HtmlCommentBlock.class, HtmlInnerBlockComment.class, HtmlInlineComment.class) != null) {
                return true;
            }
            node = node.getParent();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Pair lambda$renderList$1(int i, CharSequence charSequence) {
        return Pair.m13429of(0, Integer.valueOf(Math.min(4, Math.max(0, i - charSequence.length()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Pair lambda$renderList$2(int i, CharSequence charSequence) {
        return Pair.m13429of(Integer.valueOf(Math.min(4, Math.max(0, i - charSequence.length()))), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Pair lambda$static$0(CharSequence charSequence) {
        return Pair.m13429of(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void renderBlockQuoteLike(BlockQuoteLike blockQuoteLike, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        FormatterOptions formatterOptions = nodeFormatterContext.getFormatterOptions();
        String blockLikePrefix = getBlockLikePrefix(blockQuoteLike, nodeFormatterContext, formatterOptions.blockQuoteMarkers, markdownWriter.getPrefix());
        markdownWriter.pushPrefix();
        DataKey<Boolean> dataKey = FIRST_LIST_ITEM_CHILD;
        if (dataKey.get(nodeFormatterContext.getDocument()).booleanValue()) {
            markdownWriter.pushOptions().removeOptions(LineAppendable.F_WHITESPACE_REMOVAL).append((CharSequence) getBlockLikePrefix(blockQuoteLike, nodeFormatterContext, formatterOptions.blockQuoteMarkers, BasedSequence.NULL)).popOptions();
            markdownWriter.setPrefix((CharSequence) blockLikePrefix, true);
        } else {
            if (formatterOptions.blockQuoteBlankLines) {
                markdownWriter.blankLine();
            }
            markdownWriter.setPrefix((CharSequence) blockLikePrefix, false);
        }
        int lineCountWithPending = markdownWriter.getLineCountWithPending();
        nodeFormatterContext.renderChildren((Node) blockQuoteLike);
        markdownWriter.popPrefix();
        if (!formatterOptions.blockQuoteBlankLines || lineCountWithPending >= markdownWriter.getLineCountWithPending() || dataKey.get(nodeFormatterContext.getDocument()).booleanValue()) {
            return;
        }
        markdownWriter.tailBlankLine();
    }

    public static void renderList(ListBlock listBlock, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (nodeFormatterContext.isTransformingText()) {
            nodeFormatterContext.renderChildren(listBlock);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Node firstChild = listBlock.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            arrayList.add(firstChild);
        }
        renderList(listBlock, nodeFormatterContext, markdownWriter, arrayList);
    }

    public static void renderListItem(ListItem listItem, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter, ListOptions listOptions, BasedSequence basedSequence, boolean z) {
        int i;
        char c;
        CharSequence charSequenceRepeatOf;
        String strM756B;
        String strM756B2;
        FormatterOptions formatterOptions = nodeFormatterContext.getFormatterOptions();
        DataKey<Boolean> dataKey = FIRST_LIST_ITEM_CHILD;
        Boolean bool = dataKey.get(nodeFormatterContext.getDocument());
        boolean zBooleanValue = bool.booleanValue();
        CharSequence additionalPrefix = " ";
        if (nodeFormatterContext.isTransformingText()) {
            BasedSequence openingMarker = listItem.getOpeningMarker();
            String actualAdditionalPrefix = getActualAdditionalPrefix(openingMarker, markdownWriter);
            if (listItem.getFirstChild() == null) {
                strM756B2 = AbstractC0541b.m756B(actualAdditionalPrefix, RepeatedSequence.repeatOf(' ', openingMarker.length() + (listOptions.isItemContentAfterSuffix() ? basedSequence.length() : 0) + 1).toString());
            } else {
                BasedSequence chars = listItem.getFirstChild().getChars();
                String strM756B3 = AbstractC0541b.m756B(actualAdditionalPrefix, getAdditionalPrefix(basedSequence.isEmpty() ? openingMarker : basedSequence, chars));
                additionalPrefix = getAdditionalPrefix(basedSequence.isEmpty() ? openingMarker.getEmptySuffix() : basedSequence.getEmptySuffix(), chars);
                strM756B2 = strM756B3;
            }
            ((MarkdownWriter) markdownWriter.pushPrefix()).addPrefix((CharSequence) strM756B2, true);
            ((MarkdownWriter) markdownWriter.append((CharSequence) actualAdditionalPrefix)).append((CharSequence) openingMarker);
            if (!basedSequence.isEmpty()) {
                ((MarkdownWriter) markdownWriter.append(getAdditionalPrefix(openingMarker.getEmptySuffix(), basedSequence))).append((CharSequence) basedSequence);
            }
            markdownWriter.append(additionalPrefix);
            if (!(listItem.getFirstChild() instanceof Paragraph)) {
                if (listItem.getFirstChild() == null) {
                    if (!zBooleanValue) {
                        markdownWriter.append("\n");
                    }
                } else if (listItem.endOfLine(openingMarker.getEndOffset()) < listItem.getFirstChild().getStartOffset()) {
                    markdownWriter.append("\n");
                }
            }
            nodeFormatterContext.renderChildren(listItem);
            markdownWriter.popPrefix();
        } else {
            if (formatterOptions.listRemoveEmptyItems && (!listItem.hasChildren() || listItem.getFirstChildAnyNot(BlankLine.class) == null)) {
                return;
            }
            CharSequence openingMarker2 = listItem.getOpeningMarker();
            if (listItem.isOrderedItem()) {
                char cCharAt = openingMarker2.charAt(openingMarker2.length() - 1);
                CharSequence charSequenceSubSequence = openingMarker2.subSequence(0, openingMarker2.length() - 1);
                int i2 = C118051.f8319x62073967[formatterOptions.listNumberedMarker.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        cCharAt = '.';
                    } else {
                        if (i2 != 3) {
                            throw new IllegalStateException(AbstractC0541b.m772n("Missing case for ListNumberedMarker ", formatterOptions.listNumberedMarker.name()));
                        }
                        cCharAt = PropertyUtils.MAPPED_DELIM2;
                    }
                }
                Document document = nodeFormatterContext.getDocument();
                if (formatterOptions.listRenumberItems) {
                    DataKey<Integer> dataKey2 = LIST_ITEM_NUMBER;
                    Integer num = dataKey2.get(document);
                    Locale locale = Locale.US;
                    Integer numValueOf = Integer.valueOf(num.intValue() + 1);
                    strM756B = String.format(locale, "%d%c", num, Character.valueOf(cCharAt));
                    document.set(dataKey2, numValueOf);
                } else {
                    strM756B = String.format("%s%c", charSequenceSubSequence, Character.valueOf(cCharAt));
                }
                Pair<Integer, Integer> pairApply = LIST_ALIGN_NUMERIC.get(document).apply(strM756B);
                if (pairApply.getFirst().intValue() > 0) {
                    strM756B = AbstractC0541b.m756B(RepeatedSequence.ofSpaces(pairApply.getFirst().intValue()).toString(), strM756B.toString());
                }
                openingMarker2 = pairApply.getSecond().intValue() > 0 ? AbstractC0541b.m756B(strM756B.toString(), RepeatedSequence.ofSpaces(pairApply.getSecond().intValue()).toString()) : strM756B;
            } else if (listItem.canChangeMarker() && (i = C118051.f8318x804d0e81[formatterOptions.listBulletMarker.ordinal()]) != 1) {
                if (i == 2) {
                    openingMarker2 = CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR;
                } else if (i == 3) {
                    openingMarker2 = "*";
                } else {
                    if (i != 4) {
                        throw new IllegalStateException(AbstractC0541b.m772n("Missing case for ListBulletMarker ", formatterOptions.listBulletMarker.name()));
                    }
                    openingMarker2 = Marker.ANY_NON_NULL_MARKER;
                }
            }
            int length = (listOptions.isItemContentAfterSuffix() || formatterOptions.listsItemContentAfterSuffix) ? basedSequence.length() : 0;
            int length2 = openingMarker2.length() + (listOptions.isItemContentAfterSuffix() ? basedSequence.length() : 0) + 1;
            if (formatterOptions.itemContentIndent) {
                c = ' ';
                charSequenceRepeatOf = RepeatedSequence.repeatOf(' ', length);
            } else {
                c = ' ';
                charSequenceRepeatOf = "";
            }
            CharSequence charSequenceRepeatOf2 = formatterOptions.itemContentIndent ? RepeatedSequence.repeatOf(c, length2) : RepeatedSequence.repeatOf(" ", listOptions.getItemIndent()).toString();
            BasedSequence openingMarker3 = listItem.getOpeningMarker();
            ((MarkdownWriter) markdownWriter.pushOptions()).preserveSpaces().append((CharSequence) ((SequenceBuilder) openingMarker3.getBuilder().append((CharSequence) openingMarker3.getEmptyPrefix()).append(openingMarker2)).append((CharSequence) openingMarker3.getEmptySuffix()).toSequence()).append(' ').append((CharSequence) basedSequence).popOptions();
            ((MarkdownWriter) markdownWriter.pushPrefix()).addPrefix(charSequenceRepeatOf2, true);
            Node firstChild = listItem.getFirstChild();
            if (firstChild != null && listItem.getFirstChildAnyNot(BlankLine.class) != null) {
                ((MarkdownWriter) markdownWriter.pushPrefix()).addPrefix(charSequenceRepeatOf, true);
                dataKey.set(nodeFormatterContext.getDocument(), Boolean.TRUE);
                nodeFormatterContext.render(firstChild);
                dataKey.set(nodeFormatterContext.getDocument(), Boolean.FALSE);
                markdownWriter.popPrefix();
                while (true) {
                    firstChild = firstChild.getNext();
                    if (firstChild == null) {
                        break;
                    } else {
                        nodeFormatterContext.render(firstChild);
                    }
                }
                if (z && ((listItem.isLoose() && nodeFormatterContext.getFormatterOptions().listSpacing == ListSpacing.LOOSEN) || nodeFormatterContext.getFormatterOptions().listSpacing == ListSpacing.LOOSE)) {
                    markdownWriter.tailBlankLine();
                }
            } else if (listItem.isLoose()) {
                markdownWriter.tailBlankLine();
            } else if (!zBooleanValue) {
                markdownWriter.line();
            }
            markdownWriter.popPrefix();
        }
        FIRST_LIST_ITEM_CHILD.set(nodeFormatterContext.getDocument(), bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void renderLooseItemParagraph(Paragraph paragraph, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        renderTextBlockParagraphLines(paragraph, nodeFormatterContext, markdownWriter);
        Block parent = paragraph.getParent();
        if (!(parent instanceof ListItem)) {
            markdownWriter.tailBlankLine();
            return;
        }
        if (!nodeFormatterContext.getFormatterOptions().blankLinesInAst) {
            if (nodeFormatterContext.getFormatterOptions().listSpacing == ListSpacing.TIGHTEN && parent.getNext() == null) {
                return;
            }
            markdownWriter.tailBlankLine();
            return;
        }
        boolean zIsParagraphEndWrappingDisabled = ((ParagraphContainer) parent).isParagraphEndWrappingDisabled(paragraph);
        ListItem listItem = (ListItem) parent;
        int i = C118051.$SwitchMap$com$vladsch$flexmark$util$format$options$ListSpacing[nodeFormatterContext.getFormatterOptions().listSpacing.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 5 || zIsParagraphEndWrappingDisabled) {
                        return;
                    }
                    if (listItem.isItemParagraph(paragraph)) {
                        if (!isFollowedByBlankLine(paragraph) || !isNotLastItem(paragraph)) {
                            return;
                        }
                    } else if (!isNotLastItem(paragraph)) {
                        return;
                    }
                } else {
                    if (!(parent.getParent() instanceof ListBlock) || !((ListBlock) parent.getParent()).isLoose() || !hasLooseItems(parent.getParent().getChildren())) {
                        return;
                    }
                    if ((!isFollowedByBlankLine(paragraph) || !isNotLastItem(parent)) && listItem.isOwnTight() && (!listItem.isItemParagraph(paragraph) || parent.getFirstChild() == null || parent.getFirstChild().getNext() == null)) {
                        return;
                    }
                }
            }
        } else if (!isFollowedByBlankLine(paragraph) || !isNotLastItem(parent)) {
            return;
        }
        markdownWriter.tailBlankLine();
    }

    public static void renderLooseParagraph(Paragraph paragraph, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        markdownWriter.blankLine();
        renderLooseItemParagraph(paragraph, nodeFormatterContext, markdownWriter);
    }

    public static void renderTextBlockParagraphLines(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        int startOffset;
        int endOffset;
        if (nodeFormatterContext.isTransformingText()) {
            nodeFormatterContext.translatingSpan(new C11253j(node, 14));
            markdownWriter.line();
            return;
        }
        FormatterOptions formatterOptions = nodeFormatterContext.getFormatterOptions();
        if (formatterOptions.rightMargin <= 0) {
            nodeFormatterContext.renderChildren(node);
            markdownWriter.line();
            return;
        }
        MutableDataHolder mutable = nodeFormatterContext.getOptions().toMutable();
        DataKey<Boolean> dataKey = Formatter.KEEP_SOFT_LINE_BREAKS;
        Boolean bool = Boolean.TRUE;
        MutableDataHolder mutableDataHolder = mutable.set(dataKey, bool).set(Formatter.KEEP_HARD_LINE_BREAKS, bool);
        SequenceBuilder builder = nodeFormatterContext.getDocument().getChars().getBuilder();
        NodeFormatterContext subContext = nodeFormatterContext.getSubContext(mutableDataHolder, builder.getBuilder());
        MarkdownWriter markdown = subContext.getMarkdown();
        markdown.removeOptions(LineAppendable.F_TRIM_TRAILING_WHITESPACE);
        subContext.renderChildren(node);
        BasedSequence basedSequenceTrimEOL = node.getChars().trimEOL();
        BasedSequence basedSequenceTrimmedEnd = node.getChars().trimmedEnd();
        if (basedSequenceTrimmedEnd.isNotEmpty() && !markdown.endsWithEOL()) {
            markdown.append((CharSequence) basedSequenceTrimmedEnd);
        }
        markdown.line();
        markdown.appendToSilently(builder, 0, -1);
        BasedSequence sequence = builder.toSequence();
        BasedSequence sequence2 = builder.toSequence(nodeFormatterContext.getTrackedSequence());
        boolean z = sequence != sequence2;
        TrackedOffsetList trackedOffsets = nodeFormatterContext.getTrackedOffsets();
        if (z) {
            BasedSequence basedSequenceTrimEnd = sequence2.trimEnd();
            startOffset = basedSequenceTrimEnd.getStartOffset();
            endOffset = basedSequenceTrimEnd.getEndOffset() + (basedSequenceTrimEOL.countTrailingWhitespace() - basedSequenceTrimEnd.countTrailingWhitespace()) + 1;
        } else {
            startOffset = basedSequenceTrimEOL.getStartOffset();
            endOffset = basedSequenceTrimEOL.getEndOffset();
        }
        TrackedOffsetList trackedOffsets2 = trackedOffsets.getTrackedOffsets(startOffset, endOffset);
        MarkdownParagraph markdownParagraph = new MarkdownParagraph(sequence, sequence2, formatterOptions.charWidthProvider);
        markdownParagraph.setOptions(nodeFormatterContext.getOptions());
        markdownParagraph.setWidth(formatterOptions.rightMargin - markdownWriter.getPrefix().length());
        markdownParagraph.setKeepSoftBreaks(false);
        markdownParagraph.setKeepHardBreaks(formatterOptions.keepHardLineBreaks);
        markdownParagraph.setRestoreTrackedSpaces(nodeFormatterContext.isRestoreTrackedSpaces());
        BasedSequence basedSequence = BasedSequence.NULL;
        markdownParagraph.setFirstIndent(basedSequence);
        markdownParagraph.setIndent(basedSequence);
        markdownParagraph.setFirstWidthOffset(markdownWriter.getAfterEolPrefixDelta() + (-markdownWriter.column()));
        if (formatterOptions.applySpecialLeadInHandlers) {
            markdownParagraph.setLeadInHandlers(Parser.SPECIAL_LEAD_IN_HANDLERS.get(nodeFormatterContext.getDocument()));
        }
        Iterator<TrackedOffset> it = trackedOffsets2.iterator();
        while (it.hasNext()) {
            markdownParagraph.addTrackedOffset(it.next());
        }
        BasedSequence mapped = markdownParagraph.wrapText().toMapped(SpaceMapper.fromNonBreakSpace);
        int lineCount = markdownWriter.getLineCount();
        int iColumn = markdownWriter.column();
        markdownWriter.pushOptions().preserveSpaces().append((CharSequence) mapped).line().popOptions();
        if (trackedOffsets2.isEmpty()) {
            return;
        }
        LineInfo lineInfo = markdownWriter.getLineInfo(lineCount);
        for (TrackedOffset trackedOffset : trackedOffsets2) {
            if (trackedOffset.isResolved()) {
                int index = trackedOffset.getIndex();
                trackedOffset.setIndex((lineInfo.sumLength - lineInfo.length) + iColumn + (markdownWriter.getLineInfo(mapped.lineColumnAtIndex(index).getFirst().intValue() + lineCount).sumPrefixLength - lineInfo.sumPrefixLength) + lineInfo.prefixLength + index);
            }
        }
    }

    public static CharSequence stripSoftLineBreak(CharSequence charSequence, CharSequence charSequence2) {
        Matcher matcher = Pattern.compile("\\s*(?:\r\n|\r|\n)\\s*").matcher(charSequence);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            matcher.appendReplacement(stringBuffer, charSequence2.toString());
        }
        if (stringBuffer == null) {
            return charSequence;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer;
    }

    public static void appendWhiteSpaceBetween(MarkdownWriter markdownWriter, BasedSequence basedSequence, BasedSequence basedSequence2, boolean z, boolean z2, boolean z3) {
        if (basedSequence2 == null || basedSequence == null) {
            return;
        }
        if ((z || z2) && basedSequence.getEndOffset() <= basedSequence2.getStartOffset()) {
            BasedSequence basedSequenceBaseSubSequence = basedSequence.baseSubSequence(basedSequence.getEndOffset(), basedSequence2.getStartOffset());
            if (basedSequenceBaseSubSequence.isEmpty() || !basedSequenceBaseSubSequence.isBlank()) {
                return;
            }
            if (z) {
                int options = markdownWriter.getOptions();
                markdownWriter.setOptions((~LineAppendable.F_TRIM_LEADING_WHITESPACE) & options);
                markdownWriter.append((CharSequence) basedSequenceBaseSubSequence);
                markdownWriter.setOptions(options);
                return;
            }
            if (!z3 || basedSequenceBaseSubSequence.indexOfAny(CharPredicate.ANY_EOL) == -1) {
                markdownWriter.append(' ');
            } else {
                markdownWriter.append('\n');
            }
        }
    }

    public static void renderList(ListBlock listBlock, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter, List<Node> list) {
        ListSpacing listSpacing;
        C0232d c0232d;
        FormatterOptions formatterOptions = nodeFormatterContext.getFormatterOptions();
        if (formatterOptions.listAddBlankLineBefore && !listBlock.isOrDescendantOfType(ListItem.class)) {
            markdownWriter.blankLine();
        }
        Document document = nodeFormatterContext.getDocument();
        ListSpacing listSpacing2 = LIST_ITEM_SPACING.get(document);
        DataKey<Integer> dataKey = LIST_ITEM_NUMBER;
        Integer num = dataKey.get(document);
        num.getClass();
        boolean z = listBlock instanceof OrderedList;
        int startNumber = (!z || (formatterOptions.listRenumberItems && formatterOptions.listResetFirstItemNumber)) ? 1 : ((OrderedList) listBlock).getStartNumber();
        DataKey<Function<CharSequence, Pair<Integer, Integer>>> dataKey2 = LIST_ALIGN_NUMERIC;
        Function<CharSequence, Pair<Integer, Integer>> function = dataKey2.get(document);
        document.set(dataKey, Integer.valueOf(startNumber));
        int i = C118051.$SwitchMap$com$vladsch$flexmark$util$format$options$ListSpacing[formatterOptions.listSpacing.ordinal()];
        if (i == 2) {
            listSpacing = ListSpacing.LOOSE;
        } else if (i == 3) {
            listSpacing = ListSpacing.TIGHT;
        } else if (i == 4) {
            listSpacing = hasLooseItems(list) ? ListSpacing.LOOSE : ListSpacing.TIGHT;
        } else if (i != 5) {
            listSpacing = null;
        } else {
            listSpacing = hasLooseItems(list) ? ListSpacing.AS_IS : ListSpacing.TIGHT;
        }
        document.remove((DataKeyBase<?>) dataKey2);
        if (!formatterOptions.listAlignNumeric.isNoChange() && z) {
            int iMax = Integer.MIN_VALUE;
            int iMin = Integer.MAX_VALUE;
            for (Node node : list) {
                if (!formatterOptions.listRemoveEmptyItems || (node.hasChildren() && node.getFirstChildAnyNot(BlankLine.class) != null)) {
                    int length = formatterOptions.listRenumberItems ? Integer.toString(startNumber).length() + 1 : ((ListItem) node).getOpeningMarker().length();
                    iMax = Math.max(iMax, length);
                    iMin = Math.min(iMin, length);
                    startNumber++;
                }
            }
            if (iMax != iMin) {
                DataKey<Function<CharSequence, Pair<Integer, Integer>>> dataKey3 = LIST_ALIGN_NUMERIC;
                if (formatterOptions.listAlignNumeric.isLeft()) {
                    c0232d = new C0232d(iMax, 2);
                } else {
                    c0232d = new C0232d(iMax, 3);
                }
                document.set((DataKey<C0232d>) dataKey3, c0232d);
            }
        }
        NullableDataKey<ListSpacing> nullableDataKey = LIST_ITEM_SPACING;
        ListSpacing listSpacing3 = ListSpacing.LOOSE;
        if (listSpacing != listSpacing3 || (listSpacing2 != null && listSpacing2 != listSpacing3)) {
            listSpacing3 = listSpacing;
        }
        document.set(nullableDataKey, listSpacing3);
        for (Node node2 : list) {
            ListSpacing listSpacing4 = ListSpacing.LOOSE;
            if (listSpacing == listSpacing4 && (listSpacing2 == null || listSpacing2 == listSpacing4)) {
                markdownWriter.blankLine();
            }
            nodeFormatterContext.render(node2);
        }
        document.set(LIST_ITEM_SPACING, listSpacing2);
        document.set(LIST_ITEM_NUMBER, num);
        document.set(LIST_ALIGN_NUMERIC, function);
        if (listBlock.isOrDescendantOfType(ListItem.class)) {
            return;
        }
        markdownWriter.tailBlankLine();
    }
}
