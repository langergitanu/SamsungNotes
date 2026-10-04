package com.vladsch.flexmark.util.format;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.client.internal.MsalUtils;
import com.vladsch.flexmark.util.misc.BitFieldSet;
import opennlp.tools.parser.Parse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class TrackedOffset implements Comparable<TrackedOffset> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int flags;
    private int index;
    private boolean isSpliced;
    private final int offset;

    @Nullable
    private final TrackedOffset original;
    private int spacesAfter;
    private int spacesBefore;
    private static final int F_AFTER_SPACE_EDIT = BitFieldSet.intMask(Flags.AFTER_SPACE_EDIT);
    private static final int F_AFTER_INSERT = BitFieldSet.intMask(Flags.AFTER_INSERT);
    private static final int F_AFTER_DELETE = BitFieldSet.intMask(Flags.AFTER_DELETE);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Flags {
        AFTER_SPACE_EDIT,
        AFTER_INSERT,
        AFTER_DELETE
    }

    private TrackedOffset(int i, boolean z, boolean z2, boolean z3) {
        this.original = null;
        this.offset = i;
        int i2 = z ? F_AFTER_SPACE_EDIT : 0;
        i2 = z2 ? i2 | F_AFTER_INSERT : i2;
        this.flags = z3 ? i2 | F_AFTER_DELETE : i2;
        this.index = -1;
        this.spacesBefore = -1;
        this.spacesAfter = -1;
    }

    public static TrackedOffset track(@NotNull TrackedOffset trackedOffset) {
        return new TrackedOffset(trackedOffset);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (TrackedOffset.class == obj.getClass() || (obj instanceof Integer))) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue() == this.offset;
            }
            if (this.offset == ((TrackedOffset) obj).offset) {
                return true;
            }
        }
        return false;
    }

    public int getIndex() {
        int i = this.index;
        return i == -1 ? this.offset : i;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSpacesAfter() {
        return this.spacesAfter;
    }

    public int getSpacesBefore() {
        return this.spacesBefore;
    }

    public int hashCode() {
        return this.offset;
    }

    public boolean isAfterDelete() {
        return BitFieldSet.any(this.flags, F_AFTER_DELETE);
    }

    public boolean isAfterInsert() {
        return BitFieldSet.any(this.flags, F_AFTER_INSERT);
    }

    public boolean isAfterSpaceEdit() {
        return BitFieldSet.any(this.flags, F_AFTER_SPACE_EDIT);
    }

    public boolean isResolved() {
        return this.index != -1;
    }

    public boolean isSpliced() {
        return this.isSpliced;
    }

    @NotNull
    public TrackedOffset plusOffsetDelta(int i) {
        return new TrackedOffset(this, this.offset + i);
    }

    public void setIndex(int i) {
        TrackedOffset trackedOffset = this.original;
        if (trackedOffset != null) {
            trackedOffset.index = i;
        }
        this.index = i;
    }

    public void setSpacesAfter(int i) {
        this.spacesAfter = i;
    }

    public void setSpacesBefore(int i) {
        this.spacesBefore = i;
    }

    public void setSpliced(boolean z) {
        this.isSpliced = z;
    }

    public String toString() {
        String strM774p;
        String strM774p2;
        int i = this.offset;
        String str = isSpliced() ? " ><" : "";
        int i2 = this.spacesBefore;
        if (i2 >= 0 || this.spacesAfter >= 0) {
            String string = MsalUtils.QUERY_STRING_SYMBOL;
            String string2 = i2 >= 0 ? Integer.toString(i2) : MsalUtils.QUERY_STRING_SYMBOL;
            int i4 = this.spacesAfter;
            if (i4 >= 0) {
                string = Integer.toString(i4);
            }
            strM774p = AbstractC0541b.m774p(" ", string2, "|", string);
        } else {
            strM774p = "";
        }
        if (BitFieldSet.any(this.flags, F_AFTER_SPACE_EDIT | F_AFTER_INSERT | F_AFTER_DELETE)) {
            strM774p2 = AbstractC0541b.m774p(" ", isAfterSpaceEdit() ? "s" : "", isAfterInsert() ? "i" : "", isAfterDelete() ? "d" : "");
        } else {
            strM774p2 = "";
        }
        return AbstractC0622a.m1170p(isResolved() ? AbstractC0000a.m11h(this.index, " -> ") : "", "}", AbstractC2322a.m1629s(Parse.BRACKET_LCB, i, str, strM774p, strM774p2));
    }

    @NotNull
    public TrackedOffset withOffset(int i) {
        return new TrackedOffset(this, i);
    }

    public static TrackedOffset track(int i) {
        return track(i, false, false, false);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull TrackedOffset trackedOffset) {
        return Integer.compare(this.offset, trackedOffset.offset);
    }

    public static TrackedOffset track(int i, @Nullable Character ch, boolean z) {
        boolean z2 = false;
        boolean z3 = ch != null && ch.charValue() == ' ';
        if (ch != null && !z) {
            z2 = true;
        }
        return track(i, z3, z2, z);
    }

    public int compareTo(@NotNull Integer num) {
        return Integer.compare(this.offset, num.intValue());
    }

    public static TrackedOffset track(int i, boolean z, boolean z2, boolean z3) {
        return new TrackedOffset(i, z, z2, z3);
    }

    public int compareTo(int i) {
        return Integer.compare(this.offset, i);
    }

    private TrackedOffset(@NotNull TrackedOffset trackedOffset) {
        this.original = trackedOffset.original;
        this.offset = trackedOffset.offset;
        this.flags = trackedOffset.flags;
        this.index = -1;
        this.spacesBefore = trackedOffset.spacesBefore;
        this.spacesAfter = trackedOffset.spacesAfter;
    }

    private TrackedOffset(@NotNull TrackedOffset trackedOffset, int i) {
        this.original = trackedOffset;
        this.offset = i;
        this.flags = trackedOffset.flags;
        this.index = -1;
        this.spacesBefore = trackedOffset.spacesBefore;
        this.spacesAfter = trackedOffset.spacesAfter;
    }
}
