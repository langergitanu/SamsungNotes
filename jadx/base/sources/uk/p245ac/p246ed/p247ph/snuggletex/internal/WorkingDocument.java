package uk.p245ac.p246ed.p247ph.snuggletex.internal;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uk.p245ac.p246ed.p247ph.snuggletex.InputContext;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleInput;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class WorkingDocument implements InputContext {
    private final StringBuilder buffer;
    private int freezeIndex;
    private final SnuggleInput input;
    int lastResolvedSliceIndex = 0;
    private int length;
    private final List<Slice> scoreBoard;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CharacterSource {
        public final SourceContext context;
        private transient String stringRepresentation;
        public final CharacterSource substitutedSource;
        public final CharSequence substitutedText;
        public final int substitutionOffset;

        public CharacterSource(SourceContext sourceContext) {
            this(sourceContext, null, 0, null);
        }

        public String toString() {
            if (this.stringRepresentation == null) {
                StringBuilder sb = new StringBuilder(CharacterSource.class.getSimpleName());
                sb.append("(context=");
                sb.append(this.context);
                if (this.substitutedSource != null) {
                    sb.append(",substituted=");
                    sb.append(this.substitutedSource);
                    sb.append(",offset=");
                    sb.append(this.substitutionOffset);
                    sb.append(",substitutedText=");
                    sb.append(this.substitutedText);
                }
                sb.append(")");
                this.stringRepresentation = sb.toString();
            }
            return this.stringRepresentation;
        }

        public CharacterSource(SourceContext sourceContext, CharacterSource characterSource, int i, CharSequence charSequence) {
            this.context = sourceContext;
            this.substitutedSource = characterSource;
            this.substitutionOffset = i;
            this.substitutedText = charSequence;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IndexResolution {
        public final int indexInComponent;
        public final int scoreboardIndex;
        public final Slice slice;

        public IndexResolution(int i, Slice slice, int i2) {
            this.scoreboardIndex = i;
            this.slice = slice;
            this.indexInComponent = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append("(sbIndex=");
            sb.append(this.scoreboardIndex);
            sb.append(", slice=");
            sb.append(this.slice);
            sb.append(", indexInComponent=");
            return AbstractC2821a.m2223n(sb, ")", this.indexInComponent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Slice {
        public final int componentIndexOffset;
        public final int endIndex;
        public final CharacterSource resolvedComponent;
        public final int startIndex;

        public Slice(int i, int i2, CharacterSource characterSource, int i4) {
            this.startIndex = i;
            this.endIndex = i2;
            this.resolvedComponent = characterSource;
            this.componentIndexOffset = i4;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Slice.class.getSimpleName());
            sb.append("(span=[");
            sb.append(this.startIndex);
            sb.append(",");
            sb.append(this.endIndex);
            sb.append(") => ");
            sb.append(this.resolvedComponent);
            sb.append("; offset ");
            return AbstractC2821a.m2223n(sb, ")", this.componentIndexOffset);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SourceContext {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SubstitutionContext implements SourceContext {
        public CharSequence replacement;

        public SubstitutionContext(CharSequence charSequence) {
            this.replacement = charSequence;
        }

        public String toString() {
            return SubstitutionContext.class.getSimpleName() + "(replacement=" + ((Object) this.replacement) + ")";
        }
    }

    public WorkingDocument(CharSequence charSequence, SnuggleInputReader snuggleInputReader) {
        ArrayList arrayList = new ArrayList();
        this.scoreBoard = arrayList;
        this.freezeIndex = 0;
        StringBuilder sb = new StringBuilder(charSequence);
        this.buffer = sb;
        this.length = sb.length();
        this.input = snuggleInputReader.getInput();
        arrayList.add(new Slice(0, this.length, new CharacterSource(snuggleInputReader), 0));
    }

    private void checkIndex(int i, String str) {
        if (i < 0 || i > this.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" ");
            sb.append(i);
            sb.append(" is outwith the current bounds [0,");
            throw new IndexOutOfBoundsException(AbstractC2821a.m2223n(sb, ")", this.length));
        }
    }

    private void checkRange(int i, int i2) {
        checkIndex(i, "Start Index");
        checkIndex(i2, "End Index");
        if (i > i2) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(i, i2, "Start index ", " must be <= end index "));
        }
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.InputContext
    public int charAt(int i) {
        if (i < 0 || i >= this.length) {
            return -1;
        }
        return this.buffer.charAt(i);
    }

    public void dumpScoreboard() {
        Iterator<Slice> it = this.scoreBoard.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.InputContext
    public CharSequence extract() {
        return this.buffer;
    }

    public FrozenSlice freezeSlice(int i, int i2) {
        checkRange(i, i2);
        this.freezeIndex = Math.max(this.freezeIndex, i2);
        return new FrozenSlice(this, i, i2);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.InputContext
    public SnuggleInput getInput() {
        return this.input;
    }

    public int getSubstitutionDepth(int i) {
        int i2 = 0;
        CharacterSource characterSource = resolveIndex(i, false).slice.resolvedComponent;
        while (true) {
            characterSource = characterSource.substitutedSource;
            if (characterSource == null) {
                return i2;
            }
            i2++;
        }
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.InputContext
    public int indexOf(int i, char c) {
        while (i < length()) {
            if (charAt(i) == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.InputContext
    public boolean isRegionWhitespace(int i, int i2) {
        if (i == i2) {
            return false;
        }
        while (i < i2) {
            if (!Character.isWhitespace(charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.InputContext
    public int length() {
        return this.length;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.InputContext
    public boolean matchesAt(int i, char c) {
        return charAt(i) == c;
    }

    public IndexResolution resolveIndex(int i, boolean z) {
        checkIndex(i, Bixby2Constants.BIXBY_PARAM_INDEX);
        IndexResolution indexResolution = null;
        if (z && i == 0) {
            return null;
        }
        int i2 = this.lastResolvedSliceIndex;
        int size = this.scoreBoard.size();
        while (i2 >= 0 && i2 < size) {
            Slice slice = this.scoreBoard.get(i2);
            if (slice.startIndex > i) {
                i2--;
            } else {
                int i4 = slice.endIndex;
                if (i < i4 || (z && i == i4)) {
                    indexResolution = new IndexResolution(i2, slice, i + slice.componentIndexOffset);
                    break;
                }
                i2++;
            }
        }
        if (indexResolution == null) {
            i2 = this.lastResolvedSliceIndex;
        }
        this.lastResolvedSliceIndex = i2;
        return indexResolution;
    }

    public CharacterSource substitute(int i, int i2, CharSequence charSequence) {
        checkRange(i, i2);
        SubstitutionContext substitutionContext = new SubstitutionContext(charSequence);
        if (i < this.freezeIndex) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "Cannot modify frozen part of document (startIndex=", ",freezeIndex=");
            sbM778t.append(this.freezeIndex);
            sbM778t.append(",attemptedText=");
            StringBuilder sb = this.buffer;
            int i4 = this.freezeIndex;
            sbM778t.append(sb.substring(i4, Math.min(i4 + 20, this.length)));
            sbM778t.append(")");
            throw new IllegalArgumentException(sbM778t.toString());
        }
        int i5 = 0;
        IndexResolution indexResolutionResolveIndex = resolveIndex(i, false);
        if (indexResolutionResolveIndex == null) {
            CharacterSource characterSource = new CharacterSource(substitutionContext);
            int i6 = this.length;
            this.buffer.append(charSequence);
            int length = this.buffer.length();
            this.scoreBoard.add(new Slice(i6, length, characterSource, -i6));
            this.length = length;
            return characterSource;
        }
        CharSequence charSequenceSubSequence = this.buffer.subSequence(i, i2);
        this.buffer.delete(i, i2);
        this.buffer.insert(i, charSequence);
        int i7 = indexResolutionResolveIndex.scoreboardIndex;
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < i7; i8++) {
            arrayList.add(this.scoreBoard.get(i8));
        }
        Slice slice = indexResolutionResolveIndex.slice;
        int i9 = slice.startIndex;
        if (i > i9) {
            arrayList.add(new Slice(i9, i, slice.resolvedComponent, slice.componentIndexOffset));
        }
        int length2 = charSequence.length();
        CharacterSource characterSource2 = new CharacterSource(substitutionContext, indexResolutionResolveIndex.slice.resolvedComponent, indexResolutionResolveIndex.indexInComponent, charSequenceSubSequence);
        int i10 = length2 + i;
        arrayList.add(new Slice(i, i10, characterSource2, -i));
        IndexResolution indexResolutionResolveIndex2 = resolveIndex(i2, true);
        if (indexResolutionResolveIndex2 != null) {
            i5 = indexResolutionResolveIndex2.scoreboardIndex + 1;
            Slice slice2 = indexResolutionResolveIndex2.slice;
            int i11 = slice2.endIndex;
            if (i2 < i11) {
                int i12 = (i11 - i2) + i10;
                arrayList.add(new Slice(i10, i12, slice2.resolvedComponent, (slice2.componentIndexOffset + i2) - i10));
                i10 = i12;
            }
        }
        int size = this.scoreBoard.size();
        while (i5 < size) {
            Slice slice3 = this.scoreBoard.get(i5);
            int i13 = slice3.endIndex;
            int i14 = slice3.startIndex;
            int i15 = (i13 - i14) + i10;
            arrayList.add(new Slice(i10, i15, slice3.resolvedComponent, (slice3.componentIndexOffset + i14) - i10));
            i5++;
            i10 = i15;
        }
        this.scoreBoard.clear();
        this.scoreBoard.addAll(arrayList);
        if (this.buffer.length() == i10) {
            this.length = i10;
            return characterSource2;
        }
        throw new SnuggleLogicException("Failed sanity check: buffer length is " + this.buffer.length() + ", last board index=" + i10);
    }

    public void unfreeze(int i) {
        this.freezeIndex = i;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.InputContext
    public CharSequence extract(int i, int i2) {
        checkRange(i, i2);
        return this.buffer.subSequence(i, i2);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.InputContext
    public boolean matchesAt(int i, String str) {
        if (length() - i < str.length()) {
            return false;
        }
        return str.equals(extract(i, str.length() + i));
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.InputContext
    public int indexOf(int i, String str) {
        int length = length() - str.length();
        while (i <= length) {
            if (matchesAt(i, str)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
