package androidx.compose.foundation.text.input.internal;

import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, m13886d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m16314updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM20452getLengthimpl;
        int iM20454getMinimpl = TextRange.m20454getMinimpl(j);
        int iM20453getMaximpl = TextRange.m20453getMaximpl(j);
        if (TextRange.m20458intersects5zctL8(j2, j)) {
            if (TextRange.m20446contains5zctL8(j2, j)) {
                iM20454getMinimpl = TextRange.m20454getMinimpl(j2);
                iM20453getMaximpl = iM20454getMinimpl;
            } else {
                if (TextRange.m20446contains5zctL8(j, j2)) {
                    iM20452getLengthimpl = TextRange.m20452getLengthimpl(j2);
                } else if (TextRange.m20447containsimpl(j2, iM20454getMinimpl)) {
                    iM20454getMinimpl = TextRange.m20454getMinimpl(j2);
                    iM20452getLengthimpl = TextRange.m20452getLengthimpl(j2);
                } else {
                    iM20453getMaximpl = TextRange.m20454getMinimpl(j2);
                }
                iM20453getMaximpl -= iM20452getLengthimpl;
            }
        } else if (iM20453getMaximpl > TextRange.m20454getMinimpl(j2)) {
            iM20454getMinimpl -= TextRange.m20452getLengthimpl(j2);
            iM20452getLengthimpl = TextRange.m20452getLengthimpl(j2);
            iM20453getMaximpl -= iM20452getLengthimpl;
        }
        return TextRangeKt.TextRange(iM20454getMinimpl, iM20453getMaximpl);
    }
}
