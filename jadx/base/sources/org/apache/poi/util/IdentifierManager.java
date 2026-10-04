package org.apache.poi.util;

import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IdentifierManager {
    public static final long MAX_ID = 9223372036854775806L;
    public static final long MIN_ID = 0;
    private final long lowerbound;
    private LinkedList<Segment> segments;
    private final long upperbound;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Segment {
        public long end;
        public long start;

        public Segment(long j, long j2) {
            this.start = j;
            this.end = j2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.start);
            sb.append("; ");
            return AbstractC2821a.m2224o(sb, "]", this.end);
        }
    }

    public IdentifierManager(long j, long j2) {
        if (j > j2) {
            StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "lowerbound must not be greater than upperbound, had ", " and ");
            sbM1323p.append(j2);
            throw new IllegalArgumentException(sbM1323p.toString());
        }
        if (j < 0) {
            throw new IllegalArgumentException("lowerbound must be greater than or equal to " + Long.toString(0L));
        }
        if (j2 > MAX_ID) {
            throw new IllegalArgumentException("upperbound must be less than or equal to " + Long.toString(MAX_ID) + " but had " + j2);
        }
        this.lowerbound = j;
        this.upperbound = j2;
        LinkedList<Segment> linkedList = new LinkedList<>();
        this.segments = linkedList;
        linkedList.add(new Segment(j, j2));
    }

    private void verifyIdentifiersLeft() {
        if (this.segments.isEmpty()) {
            throw new IllegalStateException("No identifiers left");
        }
    }

    public long getRemainingIdentifiers() {
        long j = 0;
        for (Segment segment : this.segments) {
            j = (j - segment.start) + segment.end + 1;
        }
        return j;
    }

    public boolean release(long j) {
        long j2 = this.lowerbound;
        if (j >= j2) {
            long j3 = this.upperbound;
            if (j <= j3) {
                if (j == j3) {
                    Segment last = this.segments.getLast();
                    long j5 = last.end;
                    long j6 = this.upperbound;
                    if (j5 == j6 - 1) {
                        last.end = j6;
                        return true;
                    }
                    if (j5 == j6) {
                        return false;
                    }
                    this.segments.add(new Segment(j6, j6));
                    return true;
                }
                if (j == j2) {
                    Segment first = this.segments.getFirst();
                    long j7 = first.start;
                    long j8 = this.lowerbound;
                    if (j7 == 1 + j8) {
                        first.start = j8;
                        return true;
                    }
                    if (j7 == j8) {
                        return false;
                    }
                    this.segments.addFirst(new Segment(j8, j8));
                    return true;
                }
                long j9 = j + 1;
                long j10 = j - 1;
                ListIterator<Segment> listIterator = this.segments.listIterator();
                while (listIterator.hasNext()) {
                    Segment next = listIterator.next();
                    long j11 = next.end;
                    if (j11 >= j10) {
                        long j12 = next.start;
                        if (j12 > j9) {
                            listIterator.previous();
                            listIterator.add(new Segment(j, j));
                            return true;
                        }
                        if (j12 == j9) {
                            next.start = j;
                            return true;
                        }
                        if (j11 != j10) {
                            return false;
                        }
                        next.end = j;
                        if (listIterator.hasNext()) {
                            Segment next2 = listIterator.next();
                            if (next2.start == next.end + 1) {
                                next.end = next2.end;
                                listIterator.remove();
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "Value for parameter 'id' was out of bounds, had ", ", but should be within [");
        sbM1323p.append(this.lowerbound);
        sbM1323p.append(":");
        throw new IllegalArgumentException(AbstractC2821a.m2224o(sbM1323p, "]", this.upperbound));
    }

    public long reserve(long j) {
        if (j < this.lowerbound || j > this.upperbound) {
            StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "Value for parameter 'id' was out of bounds, had ", ", but should be within [");
            sbM1323p.append(this.lowerbound);
            sbM1323p.append(":");
            throw new IllegalArgumentException(AbstractC2821a.m2224o(sbM1323p, "]", this.upperbound));
        }
        verifyIdentifiersLeft();
        if (j == this.upperbound) {
            Segment last = this.segments.getLast();
            long j2 = last.end;
            long j3 = this.upperbound;
            if (j2 != j3) {
                return reserveNew();
            }
            long j5 = j3 - 1;
            last.end = j5;
            if (last.start > j5) {
                this.segments.removeLast();
                return j;
            }
        } else {
            if (j != this.lowerbound) {
                ListIterator<Segment> listIterator = this.segments.listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        break;
                    }
                    Segment next = listIterator.next();
                    long j6 = next.end;
                    if (j6 >= j) {
                        long j7 = next.start;
                        if (j7 <= j) {
                            if (j7 == j) {
                                long j8 = 1 + j;
                                next.start = j8;
                                if (j6 < j8) {
                                    listIterator.remove();
                                    return j;
                                }
                            } else {
                                if (j6 != j) {
                                    listIterator.add(new Segment(j + 1, j6));
                                    next.end = j - 1;
                                    return j;
                                }
                                long j9 = j - 1;
                                next.end = j9;
                                if (j7 > j9) {
                                    listIterator.remove();
                                }
                            }
                        }
                    }
                }
                return reserveNew();
            }
            Segment first = this.segments.getFirst();
            long j10 = first.start;
            long j11 = this.lowerbound;
            if (j10 != j11) {
                return reserveNew();
            }
            long j12 = j11 + 1;
            first.start = j12;
            if (first.end < j12) {
                this.segments.removeFirst();
                return j;
            }
        }
        return j;
    }

    public long reserveNew() {
        verifyIdentifiersLeft();
        Segment first = this.segments.getFirst();
        long j = first.start;
        long j2 = 1 + j;
        first.start = j2;
        if (j2 > first.end) {
            this.segments.removeFirst();
        }
        return j;
    }
}
