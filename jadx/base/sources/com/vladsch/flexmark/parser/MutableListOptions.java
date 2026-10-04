package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.util.data.DataHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MutableListOptions extends ListOptions {
    public MutableListOptions() {
        this.itemInterrupt = new ListOptions.MutableItemInterrupt(super.getItemInterrupt());
    }

    @Override // com.vladsch.flexmark.parser.ListOptions
    public MutableListOptions getMutable() {
        return new MutableListOptions(this);
    }

    @NotNull
    public MutableListOptions setAutoLoose(boolean z) {
        this.autoLoose = z;
        return this;
    }

    @NotNull
    public MutableListOptions setAutoLooseOneLevelLists(boolean z) {
        this.autoLooseOneLevelLists = z;
        return this;
    }

    @NotNull
    public MutableListOptions setCodeIndent(int i) {
        this.codeIndent = i;
        return this;
    }

    @NotNull
    public MutableListOptions setDelimiterMismatchToNewList(boolean z) {
        this.delimiterMismatchToNewList = z;
        return this;
    }

    @NotNull
    public MutableListOptions setEndOnDoubleBlank(boolean z) {
        this.endOnDoubleBlank = z;
        return this;
    }

    @NotNull
    public MutableListOptions setItemIndent(int i) {
        this.itemIndent = i;
        return this;
    }

    @NotNull
    public MutableListOptions setItemInterrupt(@NotNull ListOptions.MutableItemInterrupt mutableItemInterrupt) {
        this.itemInterrupt = mutableItemInterrupt;
        return this;
    }

    @NotNull
    public MutableListOptions setItemMarkerSpace(boolean z) {
        this.itemMarkerSpace = z;
        return this;
    }

    @NotNull
    public MutableListOptions setItemMarkerSuffixes(@NotNull String[] strArr) {
        this.itemMarkerSuffixes = strArr;
        return this;
    }

    @NotNull
    public MutableListOptions setItemTypeMismatchToNewList(boolean z) {
        this.itemTypeMismatchToNewList = z;
        return this;
    }

    @NotNull
    public MutableListOptions setItemTypeMismatchToSubList(boolean z) {
        this.itemTypeMismatchToSubList = z;
        return this;
    }

    @NotNull
    public MutableListOptions setLooseWhenBlankLineFollowsItemParagraph(boolean z) {
        this.looseWhenBlankLineFollowsItemParagraph = z;
        return this;
    }

    @NotNull
    public MutableListOptions setLooseWhenContainsBlankLine(boolean z) {
        this.looseWhenContainsBlankLine = z;
        return this;
    }

    @NotNull
    public MutableListOptions setLooseWhenHasLooseSubItem(boolean z) {
        this.looseWhenHasLooseSubItem = z;
        return this;
    }

    @NotNull
    public MutableListOptions setLooseWhenHasNonListChildren(boolean z) {
        this.looseWhenHasNonListChildren = z;
        return this;
    }

    @NotNull
    public MutableListOptions setLooseWhenHasTrailingBlankLine(boolean z) {
        this.looseWhenHasTrailingBlankLine = z;
        return this;
    }

    @NotNull
    public MutableListOptions setLooseWhenLastItemPrevHasTrailingBlankLine(boolean z) {
        this.looseWhenLastItemPrevHasTrailingBlankLine = z;
        return this;
    }

    @NotNull
    public MutableListOptions setLooseWhenPrevHasTrailingBlankLine(boolean z) {
        this.looseWhenPrevHasTrailingBlankLine = z;
        return this;
    }

    @NotNull
    public MutableListOptions setNewItemCodeIndent(int i) {
        this.newItemCodeIndent = i;
        return this;
    }

    @NotNull
    public MutableListOptions setNumberedItemMarkerSuffixed(boolean z) {
        this.numberedItemMarkerSuffixed = z;
        return this;
    }

    @NotNull
    public MutableListOptions setOrderedItemDotOnly(boolean z) {
        this.orderedItemDotOnly = z;
        return this;
    }

    @NotNull
    public MutableListOptions setOrderedListManualStart(boolean z) {
        this.orderedListManualStart = z;
        return this;
    }

    @NotNull
    public MutableListOptions setParserEmulationFamily(@NotNull ParserEmulationProfile parserEmulationProfile) {
        this.myParserEmulationProfile = parserEmulationProfile;
        return this;
    }

    public MutableListOptions(@Nullable DataHolder dataHolder) {
        this(ListOptions.get(dataHolder));
    }

    public MutableListOptions(@NotNull ListOptions listOptions) {
        super(listOptions);
        this.itemInterrupt = new ListOptions.MutableItemInterrupt(super.getItemInterrupt());
    }
}
