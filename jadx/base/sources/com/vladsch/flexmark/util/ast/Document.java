package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.DataKeyBase;
import com.vladsch.flexmark.util.data.DataSet;
import com.vladsch.flexmark.util.data.DataValueFactory;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.data.MutableDataSetter;
import com.vladsch.flexmark.util.data.NullableDataKey;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Document extends Block implements MutableDataHolder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Document NULL = new Document(null, BasedSequence.NULL);
    private final MutableDataSet dataSet;

    public Document(DataHolder dataHolder, BasedSequence basedSequence) {
        super(basedSequence);
        this.dataSet = new MutableDataSet(dataHolder);
    }

    @NotNull
    public static DataHolder aggregateActions(@NotNull DataHolder dataHolder, @NotNull DataHolder dataHolder2) {
        return DataSet.aggregateActions(dataHolder, dataHolder2);
    }

    public static MutableDataSet merge(DataHolder... dataHolderArr) {
        return MutableDataSet.merge(dataHolderArr);
    }

    @NotNull
    public DataHolder aggregate() {
        return this.dataSet.aggregate();
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public MutableDataHolder clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    public boolean contains(@NotNull DataKeyBase<?> dataKeyBase) {
        return this.dataSet.contains(dataKeyBase);
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public Map<? extends DataKeyBase<?>, Object> getAll() {
        return this.dataSet.getAll();
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public Collection<? extends DataKeyBase<?>> getKeys() {
        return this.dataSet.getKeys();
    }

    @Override // com.vladsch.flexmark.util.ast.ContentNode, com.vladsch.flexmark.util.ast.Content
    public int getLineCount() {
        List<BasedSequence> list = this.lineSegments;
        if (list != BasedSequence.EMPTY_LIST) {
            return list.size();
        }
        char cLastChar = getChars().lastChar();
        return getLineNumber(getChars().length()) + ((cLastChar == '\n' || cLastChar == '\r') ? 0 : 1);
    }

    public int getLineNumber(int i) {
        List<BasedSequence> list = this.lineSegments;
        int i2 = 0;
        if (list != BasedSequence.EMPTY_LIST) {
            int size = list.size();
            while (i2 < size) {
                if (i < this.lineSegments.get(i2).getEndOffset()) {
                    return i2;
                }
                i2++;
            }
            return size;
        }
        BasedSequence basedSequenceBaseSubSequence = getChars().baseSubSequence(0, Utils.maxLimit(i + 1, getChars().length()));
        if (basedSequenceBaseSubSequence.isEmpty()) {
            return 0;
        }
        int iEndOfLineAnyEOL = basedSequenceBaseSubSequence.endOfLineAnyEOL(0);
        int length = basedSequenceBaseSubSequence.length();
        while (iEndOfLineAnyEOL < length) {
            int iEolStartLength = basedSequenceBaseSubSequence.eolStartLength(iEndOfLineAnyEOL) + iEndOfLineAnyEOL;
            if (i >= iEolStartLength) {
                i2++;
            }
            iEndOfLineAnyEOL = basedSequenceBaseSubSequence.endOfLineAnyEOL(iEolStartLength);
        }
        return i2;
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder, com.vladsch.flexmark.util.data.DataHolder
    @Nullable
    public Object getOrCompute(@NotNull DataKeyBase<?> dataKeyBase, @NotNull DataValueFactory<?> dataValueFactory) {
        return this.dataSet.getOrCompute(dataKeyBase, dataValueFactory);
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return Node.EMPTY_SEGMENTS;
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public /* bridge */ /* synthetic */ MutableDataHolder remove(@NotNull DataKeyBase dataKeyBase) {
        return remove((DataKeyBase<?>) dataKeyBase);
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public <T> MutableDataHolder set(@NotNull DataKey<T> dataKey, @NotNull T t) {
        return this.dataSet.set((DataKey) dataKey, (Object) t);
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder, com.vladsch.flexmark.util.data.DataHolder, com.vladsch.flexmark.util.data.MutableDataSetter
    @NotNull
    public MutableDataHolder setIn(@NotNull MutableDataHolder mutableDataHolder) {
        return this.dataSet.setIn(mutableDataHolder);
    }

    @NotNull
    public static DataHolder aggregate(@Nullable DataHolder dataHolder, @Nullable DataHolder dataHolder2) {
        return DataSet.aggregate(dataHolder, dataHolder2);
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public MutableDataSet remove(@NotNull DataKeyBase<?> dataKeyBase) {
        return this.dataSet.remove(dataKeyBase);
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public <T> MutableDataHolder set(@NotNull NullableDataKey<T> nullableDataKey, @Nullable T t) {
        return this.dataSet.set((NullableDataKey) nullableDataKey, (Object) t);
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public MutableDataSet setAll(@NotNull DataHolder dataHolder) {
        return this.dataSet.setAll(dataHolder);
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public MutableDataSet setFrom(@NotNull MutableDataSetter mutableDataSetter) {
        return this.dataSet.setFrom(mutableDataSetter);
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public MutableDataSet toDataSet() {
        return this.dataSet.toDataSet();
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public DataSet toImmutable() {
        return this.dataSet.toImmutable();
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public MutableDataSet toMutable() {
        return this.dataSet.toMutable();
    }
}
