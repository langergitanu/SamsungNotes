package com.vladsch.flexmark.util.sequence.builder;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.misc.DelimitedBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SegmentStats {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int NOT_REPEATED_CHAR = -2;
    public static final int NULL_REPEATED_CHAR = -1;
    protected final boolean trackFirst256;
    protected int textLength = 0;
    protected int textSegments = 0;
    protected int textSegmentLength = 0;
    protected int textSpaceLength = 0;
    protected int textSpaceSegments = 0;
    protected int textSpaceSegmentLength = 0;
    protected int textFirst256Length = 0;
    protected int textFirst256Segments = 0;
    protected int textFirst256SegmentLength = 0;
    protected int repeatedChar = -1;

    public SegmentStats(boolean z) {
        this.trackFirst256 = z;
    }

    public void add(SegmentStats segmentStats) {
        this.textLength += segmentStats.textLength;
        this.textSegments += segmentStats.textSegments;
        if (this.trackFirst256 && segmentStats.trackFirst256) {
            this.textSpaceLength += segmentStats.textSpaceLength;
            this.textSpaceSegments += segmentStats.textSpaceSegments;
            this.textFirst256Length += segmentStats.textFirst256Length;
            this.textFirst256Segments += segmentStats.textFirst256Segments;
        }
    }

    public void addText(CharSequence charSequence) {
        this.textLength = charSequence.length() + this.textLength;
        if (this.trackFirst256) {
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = charSequence.charAt(i);
                int i2 = this.repeatedChar;
                if (i2 == -1) {
                    this.repeatedChar = cCharAt;
                } else if (i2 != cCharAt) {
                    this.repeatedChar = -2;
                }
                if (cCharAt < 256) {
                    if (cCharAt == ' ') {
                        this.textSpaceLength++;
                    }
                    this.textFirst256Length++;
                }
            }
        }
    }

    public void clear() {
        this.textLength = 0;
        this.textSegments = 0;
        this.textSegmentLength = 0;
        this.repeatedChar = -1;
        if (this.trackFirst256) {
            this.textSpaceLength = 0;
            this.textSpaceSegments = 0;
            this.textSpaceSegmentLength = 0;
            this.textFirst256Length = 0;
            this.textFirst256Segments = 0;
            this.textFirst256SegmentLength = 0;
        }
    }

    public void commitText() {
        int i = this.textLength;
        int i2 = this.textSegmentLength;
        if (i > i2) {
            this.textSegments++;
            this.repeatedChar = -1;
            boolean z = this.trackFirst256;
            if (z) {
                int i4 = i - i2;
                if (this.textSpaceLength - this.textSpaceSegmentLength == i4) {
                    this.textSpaceSegments++;
                }
                if (this.textFirst256Length - this.textFirst256SegmentLength == i4) {
                    this.textFirst256Segments++;
                }
            }
            this.textSegmentLength = i;
            if (z) {
                this.textSpaceSegmentLength = this.textSpaceLength;
                this.textFirst256SegmentLength = this.textFirst256Length;
            }
        }
    }

    public SegmentStats committedCopy() {
        SegmentStats segmentStats = new SegmentStats(this.trackFirst256);
        segmentStats.textLength = this.textLength;
        segmentStats.textSegments = this.textSegments;
        segmentStats.textSegmentLength = this.textSegmentLength;
        if (this.trackFirst256) {
            segmentStats.textSpaceLength = this.textSpaceLength;
            segmentStats.textSpaceSegments = this.textSpaceSegments;
            segmentStats.textSpaceSegmentLength = this.textSpaceSegmentLength;
            segmentStats.textFirst256Length = this.textFirst256Length;
            segmentStats.textFirst256Segments = this.textFirst256Segments;
            segmentStats.textFirst256SegmentLength = this.textFirst256SegmentLength;
        }
        segmentStats.commitText();
        return segmentStats;
    }

    public int getTextFirst256Length() {
        return this.textFirst256Length;
    }

    public int getTextFirst256Segments() {
        return this.textFirst256Segments;
    }

    public int getTextLength() {
        return this.textLength;
    }

    public int getTextSegments() {
        return this.textSegments;
    }

    public int getTextSpaceLength() {
        return this.textSpaceLength;
    }

    public int getTextSpaceSegments() {
        return this.textSpaceSegments;
    }

    public boolean isEmpty() {
        if (this.textLength != 0 || this.textSegments != 0 || this.textSegmentLength != 0) {
            return false;
        }
        if (this.trackFirst256) {
            return this.textSpaceLength == 0 && this.textSpaceSegments == 0 && this.textSpaceSegmentLength == 0 && this.textFirst256Length == 0 && this.textFirst256Segments == 0 && this.textFirst256SegmentLength == 0;
        }
        return true;
    }

    public boolean isRepeatedText() {
        return this.repeatedChar >= 0;
    }

    public boolean isTextFirst256() {
        return this.textFirst256Length - this.textFirst256SegmentLength == this.textLength - this.textSegmentLength;
    }

    public boolean isTextRepeatedSpace() {
        return this.textSpaceLength - this.textSpaceSegmentLength == this.textLength - this.textSegmentLength;
    }

    public boolean isTrackTextFirst256() {
        return this.trackFirst256;
    }

    public boolean isValid() {
        int i;
        int i2;
        int i4;
        int i5 = this.textLength;
        int i6 = this.textSegments;
        if (i5 < i6) {
            return false;
        }
        if (!this.trackFirst256) {
            return true;
        }
        int i7 = this.textFirst256Length;
        return i5 >= i7 && i6 >= (i = this.textFirst256Segments) && i7 >= i && i7 >= (i2 = this.textSpaceLength) && i >= (i4 = this.textSpaceSegments) && i2 >= i4;
    }

    public void remove(SegmentStats segmentStats) {
        int i = this.textLength - segmentStats.textLength;
        this.textLength = i;
        this.textSegments -= segmentStats.textSegments;
        this.textSegmentLength = i;
        if (this.trackFirst256 && segmentStats.trackFirst256) {
            int i2 = this.textSpaceLength - segmentStats.textSpaceLength;
            this.textSpaceLength = i2;
            this.textSpaceSegments -= segmentStats.textSpaceSegments;
            int i4 = this.textFirst256Length - segmentStats.textFirst256Length;
            this.textFirst256Length = i4;
            this.textFirst256Segments -= segmentStats.textFirst256Segments;
            this.textSpaceSegmentLength = i2;
            this.textFirst256SegmentLength = i4;
        }
    }

    public void removeText(CharSequence charSequence) {
        this.textLength -= charSequence.length();
        if (this.trackFirst256) {
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = charSequence.charAt(i);
                int i2 = this.repeatedChar;
                if (i2 == -1) {
                    this.repeatedChar = cCharAt;
                } else if (i2 != cCharAt) {
                    this.repeatedChar = -2;
                }
                if (cCharAt < 256) {
                    if (cCharAt == ' ') {
                        this.textSpaceLength--;
                    }
                    this.textFirst256Length--;
                }
            }
        }
        if (this.textLength == this.textSegmentLength) {
            this.repeatedChar = -1;
        }
    }

    public String toString() {
        DelimitedBuilder delimitedBuilder = new DelimitedBuilder(SQLKeyword.COMMA);
        delimitedBuilder.append("s=").append(this.textSpaceSegments).append(":").append(this.textSpaceLength).mark().append("u=").append(this.textFirst256Segments).append(":").append(this.textFirst256Length).mark().append("t=").append(this.textSegments).append(":").append(this.textLength);
        return delimitedBuilder.toString();
    }

    public void addText(char c) {
        this.textLength++;
        if (this.trackFirst256) {
            int i = this.repeatedChar;
            if (i == -1) {
                this.repeatedChar = c;
            } else if (i != c) {
                this.repeatedChar = -2;
            }
            if (c < 256) {
                if (c == ' ') {
                    this.textSpaceLength++;
                }
                this.textFirst256Length++;
            }
        }
    }

    public void addText(char c, int i) {
        this.textLength += i;
        if (this.trackFirst256) {
            int i2 = this.repeatedChar;
            if (i2 == -1) {
                this.repeatedChar = c;
            } else if (i2 != c) {
                this.repeatedChar = -2;
            }
            if (c < 256) {
                if (c == ' ') {
                    this.textSpaceLength += i;
                }
                this.textFirst256Length += i;
            }
        }
    }
}
