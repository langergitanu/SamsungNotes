package com.vladsch.flexmark.parser;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.vladsch.flexmark.ast.BulletList;
import com.vladsch.flexmark.ast.ListBlock;
import com.vladsch.flexmark.ast.ListItem;
import com.vladsch.flexmark.ast.OrderedList;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSetter;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ListOptions implements MutableDataSetter {
    protected boolean autoLoose;
    protected boolean autoLooseOneLevelLists;
    protected int codeIndent;
    protected boolean delimiterMismatchToNewList;
    protected boolean endOnDoubleBlank;
    protected boolean itemContentAfterSuffix;
    protected int itemIndent;

    @NotNull
    protected ItemInterrupt itemInterrupt;
    protected boolean itemMarkerSpace;

    @NotNull
    protected String[] itemMarkerSuffixes;

    @NotNull
    protected String itemPrefixChars;
    protected boolean itemTypeMismatchToNewList;
    protected boolean itemTypeMismatchToSubList;
    protected boolean looseWhenBlankLineFollowsItemParagraph;
    protected boolean looseWhenContainsBlankLine;
    protected boolean looseWhenHasLooseSubItem;
    protected boolean looseWhenHasNonListChildren;
    protected boolean looseWhenHasTrailingBlankLine;
    protected boolean looseWhenLastItemPrevHasTrailingBlankLine;
    protected boolean looseWhenPrevHasTrailingBlankLine;

    @NotNull
    protected ParserEmulationProfile myParserEmulationProfile;
    protected int newItemCodeIndent;
    protected boolean numberedItemMarkerSuffixed;
    protected boolean orderedItemDotOnly;
    protected boolean orderedListManualStart;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MutableItemInterrupt extends ItemInterrupt {
        public MutableItemInterrupt() {
        }

        public boolean isBulletItemInterruptsItemParagraph() {
            return this.bulletItemInterruptsItemParagraph;
        }

        public boolean isBulletItemInterruptsParagraph() {
            return this.bulletItemInterruptsParagraph;
        }

        public boolean isEmptyBulletItemInterruptsItemParagraph() {
            return this.emptyBulletItemInterruptsItemParagraph;
        }

        public boolean isEmptyBulletItemInterruptsParagraph() {
            return this.emptyBulletItemInterruptsParagraph;
        }

        public boolean isEmptyBulletSubItemInterruptsItemParagraph() {
            return this.emptyBulletSubItemInterruptsItemParagraph;
        }

        public boolean isEmptyOrderedItemInterruptsItemParagraph() {
            return this.emptyOrderedItemInterruptsItemParagraph;
        }

        public boolean isEmptyOrderedItemInterruptsParagraph() {
            return this.emptyOrderedItemInterruptsParagraph;
        }

        public boolean isEmptyOrderedNonOneItemInterruptsItemParagraph() {
            return this.emptyOrderedNonOneItemInterruptsItemParagraph;
        }

        public boolean isEmptyOrderedNonOneItemInterruptsParagraph() {
            return this.emptyOrderedNonOneItemInterruptsParagraph;
        }

        public boolean isEmptyOrderedNonOneSubItemInterruptsItemParagraph() {
            return this.emptyOrderedNonOneSubItemInterruptsItemParagraph;
        }

        public boolean isEmptyOrderedSubItemInterruptsItemParagraph() {
            return this.emptyOrderedSubItemInterruptsItemParagraph;
        }

        public boolean isOrderedItemInterruptsItemParagraph() {
            return this.orderedItemInterruptsItemParagraph;
        }

        public boolean isOrderedItemInterruptsParagraph() {
            return this.orderedItemInterruptsParagraph;
        }

        public boolean isOrderedNonOneItemInterruptsItemParagraph() {
            return this.orderedNonOneItemInterruptsItemParagraph;
        }

        public boolean isOrderedNonOneItemInterruptsParagraph() {
            return this.orderedNonOneItemInterruptsParagraph;
        }

        public MutableItemInterrupt setBulletItemInterruptsItemParagraph(boolean z) {
            this.bulletItemInterruptsItemParagraph = z;
            return this;
        }

        public MutableItemInterrupt setBulletItemInterruptsParagraph(boolean z) {
            this.bulletItemInterruptsParagraph = z;
            return this;
        }

        public MutableItemInterrupt setEmptyBulletItemInterruptsItemParagraph(boolean z) {
            this.emptyBulletItemInterruptsItemParagraph = z;
            return this;
        }

        public MutableItemInterrupt setEmptyBulletItemInterruptsParagraph(boolean z) {
            this.emptyBulletItemInterruptsParagraph = z;
            return this;
        }

        public MutableItemInterrupt setEmptyBulletSubItemInterruptsItemParagraph(boolean z) {
            this.emptyBulletSubItemInterruptsItemParagraph = z;
            return this;
        }

        public MutableItemInterrupt setEmptyOrderedItemInterruptsItemParagraph(boolean z) {
            this.emptyOrderedItemInterruptsItemParagraph = z;
            return this;
        }

        public MutableItemInterrupt setEmptyOrderedItemInterruptsParagraph(boolean z) {
            this.emptyOrderedItemInterruptsParagraph = z;
            return this;
        }

        public MutableItemInterrupt setEmptyOrderedNonOneItemInterruptsItemParagraph(boolean z) {
            this.emptyOrderedNonOneItemInterruptsItemParagraph = z;
            return this;
        }

        public MutableItemInterrupt setEmptyOrderedNonOneItemInterruptsParagraph(boolean z) {
            this.emptyOrderedNonOneItemInterruptsParagraph = z;
            return this;
        }

        public MutableItemInterrupt setEmptyOrderedNonOneSubItemInterruptsItemParagraph(boolean z) {
            this.emptyOrderedNonOneSubItemInterruptsItemParagraph = z;
            return this;
        }

        public MutableItemInterrupt setEmptyOrderedSubItemInterruptsItemParagraph(boolean z) {
            this.emptyOrderedSubItemInterruptsItemParagraph = z;
            return this;
        }

        public MutableItemInterrupt setOrderedItemInterruptsItemParagraph(boolean z) {
            this.orderedItemInterruptsItemParagraph = z;
            return this;
        }

        public MutableItemInterrupt setOrderedItemInterruptsParagraph(boolean z) {
            this.orderedItemInterruptsParagraph = z;
            return this;
        }

        public MutableItemInterrupt setOrderedNonOneItemInterruptsItemParagraph(boolean z) {
            this.orderedNonOneItemInterruptsItemParagraph = z;
            return this;
        }

        public MutableItemInterrupt setOrderedNonOneItemInterruptsParagraph(boolean z) {
            this.orderedNonOneItemInterruptsParagraph = z;
            return this;
        }

        public MutableItemInterrupt(@Nullable DataHolder dataHolder) {
            super(dataHolder);
        }

        public MutableItemInterrupt(@NotNull ItemInterrupt itemInterrupt) {
            super(itemInterrupt);
        }
    }

    public ListOptions() {
        this((DataHolder) null);
    }

    public static void addItemMarkerSuffixes(@NotNull MutableDataHolder mutableDataHolder, String... strArr) {
        String[] strArr2 = Parser.LISTS_ITEM_MARKER_SUFFIXES.get(mutableDataHolder);
        int length = strArr.length;
        int length2 = strArr.length;
        for (String str : strArr2) {
            int i = 0;
            while (true) {
                if (i >= length2) {
                    break;
                }
                String str2 = strArr[i];
                if (str2 != null && str2.equals(str)) {
                    length--;
                    strArr[i] = null;
                    break;
                }
                i++;
            }
            if (length == 0) {
                break;
            }
        }
        if (length > 0) {
            String[] strArr3 = new String[strArr2.length + length];
            System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length);
            int length3 = strArr2.length;
            for (String str3 : strArr) {
                if (str3 != null) {
                    strArr3[length3] = str3;
                    length3++;
                }
            }
            mutableDataHolder.set(Parser.LISTS_ITEM_MARKER_SUFFIXES, strArr3);
        }
    }

    @NotNull
    public static ListOptions get(DataHolder dataHolder) {
        return new ListOptions(dataHolder);
    }

    @Deprecated
    @NotNull
    public static ListOptions getFrom(DataHolder dataHolder) {
        return get(dataHolder);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean canInterrupt(@NotNull ListBlock listBlock, boolean z, boolean z2) {
        boolean z3;
        boolean z4 = listBlock instanceof OrderedList;
        if (z4) {
            z3 = true;
            if (isOrderedListManualStart() && ((OrderedList) listBlock).getStartNumber() != 1) {
                z3 = false;
            }
        }
        return getItemInterrupt().canInterrupt(z4, z3, z, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean canStartSubList(@NotNull ListBlock listBlock, boolean z) {
        boolean z2;
        boolean z3 = listBlock instanceof OrderedList;
        if (z3) {
            z2 = true;
            if (isOrderedListManualStart() && ((OrderedList) listBlock).getStartNumber() != 1) {
                z2 = false;
            }
        }
        return getItemInterrupt().canStartSubList(z3, z2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListOptions)) {
            return false;
        }
        ListOptions listOptions = (ListOptions) obj;
        if (this.myParserEmulationProfile == listOptions.myParserEmulationProfile && this.autoLoose == listOptions.autoLoose && this.autoLooseOneLevelLists == listOptions.autoLooseOneLevelLists && this.delimiterMismatchToNewList == listOptions.delimiterMismatchToNewList && this.endOnDoubleBlank == listOptions.endOnDoubleBlank && this.itemMarkerSpace == listOptions.itemMarkerSpace && this.itemTypeMismatchToNewList == listOptions.itemTypeMismatchToNewList && this.itemTypeMismatchToSubList == listOptions.itemTypeMismatchToSubList && this.looseWhenPrevHasTrailingBlankLine == listOptions.looseWhenPrevHasTrailingBlankLine && this.looseWhenLastItemPrevHasTrailingBlankLine == listOptions.looseWhenLastItemPrevHasTrailingBlankLine && this.looseWhenHasNonListChildren == listOptions.looseWhenHasNonListChildren && this.looseWhenBlankLineFollowsItemParagraph == listOptions.looseWhenBlankLineFollowsItemParagraph && this.looseWhenHasLooseSubItem == listOptions.looseWhenHasLooseSubItem && this.looseWhenHasTrailingBlankLine == listOptions.looseWhenHasTrailingBlankLine && this.looseWhenContainsBlankLine == listOptions.looseWhenContainsBlankLine && this.numberedItemMarkerSuffixed == listOptions.numberedItemMarkerSuffixed && this.orderedItemDotOnly == listOptions.orderedItemDotOnly && this.orderedListManualStart == listOptions.orderedListManualStart && this.codeIndent == listOptions.codeIndent && this.itemIndent == listOptions.itemIndent && this.newItemCodeIndent == listOptions.newItemCodeIndent && this.itemMarkerSuffixes == listOptions.itemMarkerSuffixes && this.itemContentAfterSuffix == listOptions.itemContentAfterSuffix && this.itemPrefixChars.equals(listOptions.itemPrefixChars)) {
            return this.itemInterrupt.equals(listOptions.itemInterrupt);
        }
        return false;
    }

    public int getCodeIndent() {
        return this.codeIndent;
    }

    public int getItemIndent() {
        return this.itemIndent;
    }

    @NotNull
    public ItemInterrupt getItemInterrupt() {
        return this.itemInterrupt;
    }

    @NotNull
    public String[] getItemMarkerSuffixes() {
        return this.itemMarkerSuffixes;
    }

    @NotNull
    public String getItemPrefixChars() {
        return this.itemPrefixChars;
    }

    public MutableListOptions getMutable() {
        return new MutableListOptions(this);
    }

    public int getNewItemCodeIndent() {
        return this.newItemCodeIndent;
    }

    @NotNull
    public ParserEmulationProfile getParserEmulationProfile() {
        return this.myParserEmulationProfile;
    }

    public int hashCode() {
        return ((((((AbstractC1038a.m1202c((((((((((((((((((((((((((((((((((((((this.itemInterrupt.hashCode() + (this.myParserEmulationProfile.hashCode() * 31)) * 31) + (this.autoLoose ? 1 : 0)) * 31) + (this.autoLooseOneLevelLists ? 1 : 0)) * 31) + (this.delimiterMismatchToNewList ? 1 : 0)) * 31) + (this.endOnDoubleBlank ? 1 : 0)) * 31) + (this.itemMarkerSpace ? 1 : 0)) * 31) + (this.itemTypeMismatchToNewList ? 1 : 0)) * 31) + (this.itemTypeMismatchToSubList ? 1 : 0)) * 31) + (this.looseWhenPrevHasTrailingBlankLine ? 1 : 0)) * 31) + (this.looseWhenLastItemPrevHasTrailingBlankLine ? 1 : 0)) * 31) + (this.looseWhenHasNonListChildren ? 1 : 0)) * 31) + (this.looseWhenBlankLineFollowsItemParagraph ? 1 : 0)) * 31) + (this.looseWhenHasLooseSubItem ? 1 : 0)) * 31) + (this.looseWhenHasTrailingBlankLine ? 1 : 0)) * 31) + (this.looseWhenContainsBlankLine ? 1 : 0)) * 31) + (this.numberedItemMarkerSuffixed ? 1 : 0)) * 31) + (this.orderedItemDotOnly ? 1 : 0)) * 31) + (this.orderedListManualStart ? 1 : 0)) * 31) + (this.itemContentAfterSuffix ? 1 : 0)) * 31, 31, this.itemPrefixChars) + this.codeIndent) * 31) + this.itemIndent) * 31) + this.newItemCodeIndent) * 31) + Arrays.hashCode(this.itemMarkerSuffixes);
    }

    public boolean isAutoLoose() {
        return this.autoLoose;
    }

    public boolean isAutoLooseOneLevelLists() {
        return this.autoLooseOneLevelLists;
    }

    public boolean isDelimiterMismatchToNewList() {
        return this.delimiterMismatchToNewList;
    }

    public boolean isEndOnDoubleBlank() {
        return this.endOnDoubleBlank;
    }

    public boolean isInTightListItem(@NotNull Paragraph paragraph) {
        Block parent = paragraph.getParent();
        if (!(parent instanceof ListItem)) {
            return false;
        }
        ListItem listItem = (ListItem) parent;
        if (!listItem.isItemParagraph(paragraph)) {
            return false;
        }
        boolean zIsAutoLoose = isAutoLoose();
        if (zIsAutoLoose && isAutoLooseOneLevelLists()) {
            return isTightListItem(listItem);
        }
        if (zIsAutoLoose || !listItem.isParagraphInTightListItem(paragraph)) {
            return zIsAutoLoose && listItem.isInTightList();
        }
        return true;
    }

    public boolean isItemContentAfterSuffix() {
        return this.itemContentAfterSuffix;
    }

    public boolean isItemMarkerSpace() {
        return this.itemMarkerSpace;
    }

    public boolean isItemTypeMismatchToNewList() {
        return this.itemTypeMismatchToNewList;
    }

    public boolean isItemTypeMismatchToSubList() {
        return this.itemTypeMismatchToSubList;
    }

    public boolean isLooseWhenBlankLineFollowsItemParagraph() {
        return this.looseWhenBlankLineFollowsItemParagraph;
    }

    public boolean isLooseWhenContainsBlankLine() {
        return this.looseWhenContainsBlankLine;
    }

    public boolean isLooseWhenHasLooseSubItem() {
        return this.looseWhenHasLooseSubItem;
    }

    public boolean isLooseWhenHasNonListChildren() {
        return this.looseWhenHasNonListChildren;
    }

    public boolean isLooseWhenHasTrailingBlankLine() {
        return this.looseWhenHasTrailingBlankLine;
    }

    public boolean isLooseWhenLastItemPrevHasTrailingBlankLine() {
        return this.looseWhenLastItemPrevHasTrailingBlankLine;
    }

    public boolean isLooseWhenPrevHasTrailingBlankLine() {
        return this.looseWhenPrevHasTrailingBlankLine;
    }

    public boolean isNumberedItemMarkerSuffixed() {
        return this.numberedItemMarkerSuffixed;
    }

    public boolean isOrderedItemDotOnly() {
        return this.orderedItemDotOnly;
    }

    public boolean isOrderedListManualStart() {
        return this.orderedListManualStart;
    }

    public boolean isTightListItem(@NotNull ListItem listItem) {
        if (listItem.isLoose()) {
            return false;
        }
        boolean zIsAutoLoose = isAutoLoose();
        if (!zIsAutoLoose || !isAutoLooseOneLevelLists()) {
            return listItem.getFirstChild() == null || (!zIsAutoLoose && listItem.isTight()) || (zIsAutoLoose && listItem.isInTightList());
        }
        boolean z = listItem.getAncestorOfType(ListItem.class) == null && listItem.getChildOfType(ListBlock.class) == null;
        return listItem.getFirstChild() == null || (!z && listItem.isTight()) || (z && listItem.isInTightList());
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataSetter
    @NotNull
    public MutableDataHolder setIn(@NotNull MutableDataHolder mutableDataHolder) {
        mutableDataHolder.set(Parser.PARSER_EMULATION_PROFILE, getParserEmulationProfile());
        getItemInterrupt().setIn(mutableDataHolder);
        mutableDataHolder.set(Parser.LISTS_AUTO_LOOSE, Boolean.valueOf(this.autoLoose));
        mutableDataHolder.set(Parser.LISTS_AUTO_LOOSE_ONE_LEVEL_LISTS, Boolean.valueOf(this.autoLooseOneLevelLists));
        mutableDataHolder.set(Parser.LISTS_DELIMITER_MISMATCH_TO_NEW_LIST, Boolean.valueOf(this.delimiterMismatchToNewList));
        mutableDataHolder.set(Parser.LISTS_END_ON_DOUBLE_BLANK, Boolean.valueOf(this.endOnDoubleBlank));
        mutableDataHolder.set(Parser.LISTS_ITEM_MARKER_SPACE, Boolean.valueOf(this.itemMarkerSpace));
        mutableDataHolder.set(Parser.LISTS_ITEM_TYPE_MISMATCH_TO_NEW_LIST, Boolean.valueOf(this.itemTypeMismatchToNewList));
        mutableDataHolder.set(Parser.LISTS_ITEM_TYPE_MISMATCH_TO_SUB_LIST, Boolean.valueOf(this.itemTypeMismatchToSubList));
        mutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_PREV_HAS_TRAILING_BLANK_LINE, Boolean.valueOf(this.looseWhenPrevHasTrailingBlankLine));
        mutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_LAST_ITEM_PREV_HAS_TRAILING_BLANK_LINE, Boolean.valueOf(this.looseWhenLastItemPrevHasTrailingBlankLine));
        mutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_HAS_NON_LIST_CHILDREN, Boolean.valueOf(this.looseWhenHasNonListChildren));
        mutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_BLANK_LINE_FOLLOWS_ITEM_PARAGRAPH, Boolean.valueOf(this.looseWhenBlankLineFollowsItemParagraph));
        mutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_HAS_LOOSE_SUB_ITEM, Boolean.valueOf(this.looseWhenHasLooseSubItem));
        mutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_HAS_TRAILING_BLANK_LINE, Boolean.valueOf(this.looseWhenHasTrailingBlankLine));
        mutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_CONTAINS_BLANK_LINE, Boolean.valueOf(this.looseWhenContainsBlankLine));
        mutableDataHolder.set(Parser.LISTS_NUMBERED_ITEM_MARKER_SUFFIXED, Boolean.valueOf(this.numberedItemMarkerSuffixed));
        mutableDataHolder.set(Parser.LISTS_ORDERED_ITEM_DOT_ONLY, Boolean.valueOf(this.orderedItemDotOnly));
        mutableDataHolder.set(Parser.LISTS_ORDERED_LIST_MANUAL_START, Boolean.valueOf(this.orderedListManualStart));
        mutableDataHolder.set(Parser.LISTS_CODE_INDENT, Integer.valueOf(this.codeIndent));
        mutableDataHolder.set(Parser.LISTS_ITEM_INDENT, Integer.valueOf(this.itemIndent));
        mutableDataHolder.set(Parser.LISTS_NEW_ITEM_CODE_INDENT, Integer.valueOf(this.newItemCodeIndent));
        mutableDataHolder.set(Parser.LISTS_ITEM_MARKER_SUFFIXES, this.itemMarkerSuffixes);
        mutableDataHolder.set(Parser.LISTS_ITEM_CONTENT_AFTER_SUFFIX, Boolean.valueOf(this.itemContentAfterSuffix));
        mutableDataHolder.set(Parser.LISTS_ITEM_PREFIX_CHARS, this.itemPrefixChars);
        return mutableDataHolder;
    }

    public boolean startNewList(@NotNull ListBlock listBlock, @NotNull ListBlock listBlock2) {
        boolean z = listBlock instanceof OrderedList;
        return z == (listBlock2 instanceof OrderedList) ? z ? isDelimiterMismatchToNewList() && ((OrderedList) listBlock).getDelimiter() != ((OrderedList) listBlock2).getDelimiter() : isDelimiterMismatchToNewList() && ((BulletList) listBlock).getOpeningMarker() != ((BulletList) listBlock2).getOpeningMarker() : isItemTypeMismatchToNewList();
    }

    public boolean startSubList(@NotNull ListBlock listBlock, @NotNull ListBlock listBlock2) {
        return (listBlock instanceof OrderedList) != (listBlock2 instanceof OrderedList) && isItemTypeMismatchToSubList();
    }

    private ListOptions(@Nullable DataHolder dataHolder) {
        this.myParserEmulationProfile = Parser.PARSER_EMULATION_PROFILE.get(dataHolder);
        this.itemInterrupt = new ItemInterrupt(dataHolder);
        this.autoLoose = Parser.LISTS_AUTO_LOOSE.get(dataHolder).booleanValue();
        this.autoLooseOneLevelLists = Parser.LISTS_AUTO_LOOSE_ONE_LEVEL_LISTS.get(dataHolder).booleanValue();
        this.delimiterMismatchToNewList = Parser.LISTS_DELIMITER_MISMATCH_TO_NEW_LIST.get(dataHolder).booleanValue();
        this.endOnDoubleBlank = Parser.LISTS_END_ON_DOUBLE_BLANK.get(dataHolder).booleanValue();
        this.itemMarkerSpace = Parser.LISTS_ITEM_MARKER_SPACE.get(dataHolder).booleanValue();
        this.itemTypeMismatchToNewList = Parser.LISTS_ITEM_TYPE_MISMATCH_TO_NEW_LIST.get(dataHolder).booleanValue();
        this.itemTypeMismatchToSubList = Parser.LISTS_ITEM_TYPE_MISMATCH_TO_SUB_LIST.get(dataHolder).booleanValue();
        this.looseWhenPrevHasTrailingBlankLine = Parser.LISTS_LOOSE_WHEN_PREV_HAS_TRAILING_BLANK_LINE.get(dataHolder).booleanValue();
        this.looseWhenLastItemPrevHasTrailingBlankLine = Parser.LISTS_LOOSE_WHEN_LAST_ITEM_PREV_HAS_TRAILING_BLANK_LINE.get(dataHolder).booleanValue();
        this.looseWhenHasNonListChildren = Parser.LISTS_LOOSE_WHEN_HAS_NON_LIST_CHILDREN.get(dataHolder).booleanValue();
        this.looseWhenBlankLineFollowsItemParagraph = Parser.LISTS_LOOSE_WHEN_BLANK_LINE_FOLLOWS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
        this.looseWhenHasLooseSubItem = Parser.LISTS_LOOSE_WHEN_HAS_LOOSE_SUB_ITEM.get(dataHolder).booleanValue();
        this.looseWhenHasTrailingBlankLine = Parser.LISTS_LOOSE_WHEN_HAS_TRAILING_BLANK_LINE.get(dataHolder).booleanValue();
        this.looseWhenContainsBlankLine = Parser.LISTS_LOOSE_WHEN_CONTAINS_BLANK_LINE.get(dataHolder).booleanValue();
        this.numberedItemMarkerSuffixed = Parser.LISTS_NUMBERED_ITEM_MARKER_SUFFIXED.get(dataHolder).booleanValue();
        this.orderedItemDotOnly = Parser.LISTS_ORDERED_ITEM_DOT_ONLY.get(dataHolder).booleanValue();
        this.orderedListManualStart = Parser.LISTS_ORDERED_LIST_MANUAL_START.get(dataHolder).booleanValue();
        this.itemContentAfterSuffix = Parser.LISTS_ITEM_CONTENT_AFTER_SUFFIX.get(dataHolder).booleanValue();
        this.itemPrefixChars = Parser.LISTS_ITEM_PREFIX_CHARS.get(dataHolder);
        this.codeIndent = Parser.LISTS_CODE_INDENT.get(dataHolder).intValue();
        this.itemIndent = Parser.LISTS_ITEM_INDENT.get(dataHolder).intValue();
        this.newItemCodeIndent = Parser.LISTS_NEW_ITEM_CODE_INDENT.get(dataHolder).intValue();
        this.itemMarkerSuffixes = Parser.LISTS_ITEM_MARKER_SUFFIXES.get(dataHolder);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ItemInterrupt {
        protected boolean bulletItemInterruptsItemParagraph;
        protected boolean bulletItemInterruptsParagraph;
        protected boolean emptyBulletItemInterruptsItemParagraph;
        protected boolean emptyBulletItemInterruptsParagraph;
        protected boolean emptyBulletSubItemInterruptsItemParagraph;
        protected boolean emptyOrderedItemInterruptsItemParagraph;
        protected boolean emptyOrderedItemInterruptsParagraph;
        protected boolean emptyOrderedNonOneItemInterruptsItemParagraph;
        protected boolean emptyOrderedNonOneItemInterruptsParagraph;
        protected boolean emptyOrderedNonOneSubItemInterruptsItemParagraph;
        protected boolean emptyOrderedSubItemInterruptsItemParagraph;
        protected boolean orderedItemInterruptsItemParagraph;
        protected boolean orderedItemInterruptsParagraph;
        protected boolean orderedNonOneItemInterruptsItemParagraph;
        protected boolean orderedNonOneItemInterruptsParagraph;

        public ItemInterrupt() {
            this.bulletItemInterruptsParagraph = false;
            this.orderedItemInterruptsParagraph = false;
            this.orderedNonOneItemInterruptsParagraph = false;
            this.emptyBulletItemInterruptsParagraph = false;
            this.emptyOrderedItemInterruptsParagraph = false;
            this.emptyOrderedNonOneItemInterruptsParagraph = false;
            this.bulletItemInterruptsItemParagraph = false;
            this.orderedItemInterruptsItemParagraph = false;
            this.orderedNonOneItemInterruptsItemParagraph = false;
            this.emptyBulletItemInterruptsItemParagraph = false;
            this.emptyOrderedItemInterruptsItemParagraph = false;
            this.emptyOrderedNonOneItemInterruptsItemParagraph = false;
            this.emptyBulletSubItemInterruptsItemParagraph = false;
            this.emptyOrderedSubItemInterruptsItemParagraph = false;
            this.emptyOrderedNonOneSubItemInterruptsItemParagraph = false;
        }

        public boolean canInterrupt(boolean z, boolean z2, boolean z3, boolean z4) {
            return z ? z2 ? z4 ? this.orderedItemInterruptsItemParagraph && (!z3 || this.emptyOrderedItemInterruptsItemParagraph) : this.orderedItemInterruptsParagraph && (!z3 || this.emptyOrderedItemInterruptsParagraph) : z4 ? this.orderedNonOneItemInterruptsItemParagraph && (!z3 || this.emptyOrderedNonOneItemInterruptsItemParagraph) : this.orderedNonOneItemInterruptsParagraph && (!z3 || this.emptyOrderedNonOneItemInterruptsParagraph) : z4 ? this.bulletItemInterruptsItemParagraph && (!z3 || this.emptyBulletItemInterruptsItemParagraph) : this.bulletItemInterruptsParagraph && (!z3 || this.emptyBulletItemInterruptsParagraph);
        }

        public boolean canStartSubList(boolean z, boolean z2, boolean z3) {
            return z ? this.orderedItemInterruptsItemParagraph && (!z3 || (this.emptyOrderedSubItemInterruptsItemParagraph && this.emptyOrderedItemInterruptsItemParagraph)) && (z2 || (this.orderedNonOneItemInterruptsItemParagraph && (!z3 || (this.emptyOrderedNonOneSubItemInterruptsItemParagraph && this.emptyOrderedNonOneItemInterruptsItemParagraph)))) : this.bulletItemInterruptsItemParagraph && (!z3 || (this.emptyBulletSubItemInterruptsItemParagraph && this.emptyBulletItemInterruptsItemParagraph));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ItemInterrupt)) {
                return false;
            }
            ItemInterrupt itemInterrupt = (ItemInterrupt) obj;
            return this.bulletItemInterruptsParagraph == itemInterrupt.bulletItemInterruptsParagraph && this.orderedItemInterruptsParagraph == itemInterrupt.orderedItemInterruptsParagraph && this.orderedNonOneItemInterruptsParagraph == itemInterrupt.orderedNonOneItemInterruptsParagraph && this.emptyBulletItemInterruptsParagraph == itemInterrupt.emptyBulletItemInterruptsParagraph && this.emptyOrderedItemInterruptsParagraph == itemInterrupt.emptyOrderedItemInterruptsParagraph && this.emptyOrderedNonOneItemInterruptsParagraph == itemInterrupt.emptyOrderedNonOneItemInterruptsParagraph && this.bulletItemInterruptsItemParagraph == itemInterrupt.bulletItemInterruptsItemParagraph && this.orderedItemInterruptsItemParagraph == itemInterrupt.orderedItemInterruptsItemParagraph && this.orderedNonOneItemInterruptsItemParagraph == itemInterrupt.orderedNonOneItemInterruptsItemParagraph && this.emptyBulletItemInterruptsItemParagraph == itemInterrupt.emptyBulletItemInterruptsItemParagraph && this.emptyOrderedItemInterruptsItemParagraph == itemInterrupt.emptyOrderedItemInterruptsItemParagraph && this.emptyOrderedNonOneItemInterruptsItemParagraph == itemInterrupt.emptyOrderedNonOneItemInterruptsItemParagraph && this.emptyBulletSubItemInterruptsItemParagraph == itemInterrupt.emptyBulletSubItemInterruptsItemParagraph && this.emptyOrderedSubItemInterruptsItemParagraph == itemInterrupt.emptyOrderedSubItemInterruptsItemParagraph && this.emptyOrderedNonOneSubItemInterruptsItemParagraph == itemInterrupt.emptyOrderedNonOneSubItemInterruptsItemParagraph;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((this.bulletItemInterruptsParagraph ? 1 : 0) * 31) + (this.orderedItemInterruptsParagraph ? 1 : 0)) * 31) + (this.orderedNonOneItemInterruptsParagraph ? 1 : 0)) * 31) + (this.emptyBulletItemInterruptsParagraph ? 1 : 0)) * 31) + (this.emptyOrderedItemInterruptsParagraph ? 1 : 0)) * 31) + (this.emptyOrderedNonOneItemInterruptsParagraph ? 1 : 0)) * 31) + (this.bulletItemInterruptsItemParagraph ? 1 : 0)) * 31) + (this.orderedItemInterruptsItemParagraph ? 1 : 0)) * 31) + (this.orderedNonOneItemInterruptsItemParagraph ? 1 : 0)) * 31) + (this.emptyBulletItemInterruptsItemParagraph ? 1 : 0)) * 31) + (this.emptyOrderedItemInterruptsItemParagraph ? 1 : 0)) * 31) + (this.emptyOrderedNonOneItemInterruptsItemParagraph ? 1 : 0)) * 31) + (this.emptyBulletSubItemInterruptsItemParagraph ? 1 : 0)) * 31) + (this.emptyOrderedSubItemInterruptsItemParagraph ? 1 : 0)) * 31) + (this.emptyOrderedNonOneSubItemInterruptsItemParagraph ? 1 : 0);
        }

        public void setIn(@NotNull MutableDataHolder mutableDataHolder) {
            mutableDataHolder.set(Parser.LISTS_BULLET_ITEM_INTERRUPTS_PARAGRAPH, Boolean.valueOf(this.bulletItemInterruptsParagraph));
            mutableDataHolder.set(Parser.LISTS_ORDERED_ITEM_INTERRUPTS_PARAGRAPH, Boolean.valueOf(this.orderedItemInterruptsParagraph));
            mutableDataHolder.set(Parser.LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH, Boolean.valueOf(this.orderedNonOneItemInterruptsParagraph));
            mutableDataHolder.set(Parser.LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_PARAGRAPH, Boolean.valueOf(this.emptyBulletItemInterruptsParagraph));
            mutableDataHolder.set(Parser.LISTS_EMPTY_ORDERED_ITEM_INTERRUPTS_PARAGRAPH, Boolean.valueOf(this.emptyOrderedItemInterruptsParagraph));
            mutableDataHolder.set(Parser.LISTS_EMPTY_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH, Boolean.valueOf(this.emptyOrderedNonOneItemInterruptsParagraph));
            mutableDataHolder.set(Parser.LISTS_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.bulletItemInterruptsItemParagraph));
            mutableDataHolder.set(Parser.LISTS_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.orderedItemInterruptsItemParagraph));
            mutableDataHolder.set(Parser.LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.orderedNonOneItemInterruptsItemParagraph));
            mutableDataHolder.set(Parser.LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.emptyBulletItemInterruptsItemParagraph));
            mutableDataHolder.set(Parser.LISTS_EMPTY_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.emptyOrderedItemInterruptsItemParagraph));
            mutableDataHolder.set(Parser.LISTS_EMPTY_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.emptyOrderedNonOneItemInterruptsItemParagraph));
            mutableDataHolder.set(Parser.LISTS_EMPTY_BULLET_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.emptyBulletSubItemInterruptsItemParagraph));
            mutableDataHolder.set(Parser.LISTS_EMPTY_ORDERED_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.emptyOrderedSubItemInterruptsItemParagraph));
            mutableDataHolder.set(Parser.LISTS_EMPTY_ORDERED_NON_ONE_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.emptyOrderedNonOneSubItemInterruptsItemParagraph));
        }

        public ItemInterrupt(@Nullable DataHolder dataHolder) {
            this.bulletItemInterruptsParagraph = Parser.LISTS_BULLET_ITEM_INTERRUPTS_PARAGRAPH.get(dataHolder).booleanValue();
            this.orderedItemInterruptsParagraph = Parser.LISTS_ORDERED_ITEM_INTERRUPTS_PARAGRAPH.get(dataHolder).booleanValue();
            this.orderedNonOneItemInterruptsParagraph = Parser.LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH.get(dataHolder).booleanValue();
            this.emptyBulletItemInterruptsParagraph = Parser.LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_PARAGRAPH.get(dataHolder).booleanValue();
            this.emptyOrderedItemInterruptsParagraph = Parser.LISTS_EMPTY_ORDERED_ITEM_INTERRUPTS_PARAGRAPH.get(dataHolder).booleanValue();
            this.emptyOrderedNonOneItemInterruptsParagraph = Parser.LISTS_EMPTY_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH.get(dataHolder).booleanValue();
            this.bulletItemInterruptsItemParagraph = Parser.LISTS_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
            this.orderedItemInterruptsItemParagraph = Parser.LISTS_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
            this.orderedNonOneItemInterruptsItemParagraph = Parser.LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
            this.emptyBulletItemInterruptsItemParagraph = Parser.LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
            this.emptyOrderedItemInterruptsItemParagraph = Parser.LISTS_EMPTY_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
            this.emptyOrderedNonOneItemInterruptsItemParagraph = Parser.LISTS_EMPTY_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
            this.emptyBulletSubItemInterruptsItemParagraph = Parser.LISTS_EMPTY_BULLET_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
            this.emptyOrderedSubItemInterruptsItemParagraph = Parser.LISTS_EMPTY_ORDERED_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
            this.emptyOrderedNonOneSubItemInterruptsItemParagraph = Parser.LISTS_EMPTY_ORDERED_NON_ONE_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(dataHolder).booleanValue();
        }

        public ItemInterrupt(@NotNull ItemInterrupt itemInterrupt) {
            this.bulletItemInterruptsParagraph = itemInterrupt.bulletItemInterruptsParagraph;
            this.orderedItemInterruptsParagraph = itemInterrupt.orderedItemInterruptsParagraph;
            this.orderedNonOneItemInterruptsParagraph = itemInterrupt.orderedNonOneItemInterruptsParagraph;
            this.emptyBulletItemInterruptsParagraph = itemInterrupt.emptyBulletItemInterruptsParagraph;
            this.emptyOrderedItemInterruptsParagraph = itemInterrupt.emptyOrderedItemInterruptsParagraph;
            this.emptyOrderedNonOneItemInterruptsParagraph = itemInterrupt.emptyOrderedNonOneItemInterruptsParagraph;
            this.bulletItemInterruptsItemParagraph = itemInterrupt.bulletItemInterruptsItemParagraph;
            this.orderedItemInterruptsItemParagraph = itemInterrupt.orderedItemInterruptsItemParagraph;
            this.orderedNonOneItemInterruptsItemParagraph = itemInterrupt.orderedNonOneItemInterruptsItemParagraph;
            this.emptyBulletItemInterruptsItemParagraph = itemInterrupt.emptyBulletItemInterruptsItemParagraph;
            this.emptyOrderedItemInterruptsItemParagraph = itemInterrupt.emptyOrderedItemInterruptsItemParagraph;
            this.emptyOrderedNonOneItemInterruptsItemParagraph = itemInterrupt.emptyOrderedNonOneItemInterruptsItemParagraph;
            this.emptyBulletSubItemInterruptsItemParagraph = itemInterrupt.emptyBulletSubItemInterruptsItemParagraph;
            this.emptyOrderedSubItemInterruptsItemParagraph = itemInterrupt.emptyOrderedSubItemInterruptsItemParagraph;
            this.emptyOrderedNonOneSubItemInterruptsItemParagraph = itemInterrupt.emptyOrderedNonOneSubItemInterruptsItemParagraph;
        }
    }

    public ListOptions(@NotNull ListOptions listOptions) {
        this.myParserEmulationProfile = listOptions.getParserEmulationProfile();
        this.itemInterrupt = new ItemInterrupt(listOptions.getItemInterrupt());
        this.autoLoose = listOptions.isAutoLoose();
        this.autoLooseOneLevelLists = listOptions.isAutoLooseOneLevelLists();
        this.delimiterMismatchToNewList = listOptions.isDelimiterMismatchToNewList();
        this.endOnDoubleBlank = listOptions.isEndOnDoubleBlank();
        this.itemMarkerSpace = listOptions.isItemMarkerSpace();
        this.itemTypeMismatchToNewList = listOptions.isItemTypeMismatchToNewList();
        this.itemTypeMismatchToSubList = listOptions.isItemTypeMismatchToSubList();
        this.looseWhenPrevHasTrailingBlankLine = listOptions.isLooseWhenPrevHasTrailingBlankLine();
        this.looseWhenLastItemPrevHasTrailingBlankLine = listOptions.isLooseWhenLastItemPrevHasTrailingBlankLine();
        this.looseWhenHasNonListChildren = listOptions.isLooseWhenHasNonListChildren();
        this.looseWhenBlankLineFollowsItemParagraph = listOptions.isLooseWhenBlankLineFollowsItemParagraph();
        this.looseWhenHasLooseSubItem = listOptions.isLooseWhenHasLooseSubItem();
        this.looseWhenHasTrailingBlankLine = listOptions.isLooseWhenHasTrailingBlankLine();
        this.looseWhenContainsBlankLine = listOptions.isLooseWhenContainsBlankLine();
        this.numberedItemMarkerSuffixed = listOptions.isNumberedItemMarkerSuffixed();
        this.orderedItemDotOnly = listOptions.isOrderedItemDotOnly();
        this.orderedListManualStart = listOptions.isOrderedListManualStart();
        this.itemContentAfterSuffix = listOptions.isItemContentAfterSuffix();
        this.itemPrefixChars = listOptions.getItemPrefixChars();
        this.codeIndent = listOptions.getCodeIndent();
        this.itemIndent = listOptions.getItemIndent();
        this.newItemCodeIndent = listOptions.getNewItemCodeIndent();
        this.itemMarkerSuffixes = listOptions.getItemMarkerSuffixes();
    }
}
