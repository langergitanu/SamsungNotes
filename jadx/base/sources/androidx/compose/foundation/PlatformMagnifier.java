package androidx.compose.foundation;

import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J*\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/foundation/PlatformMagnifier;", "", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "dismiss", "", Constants.ARG_UPDATE, "sourceCenter", "Landroidx/compose/ui/geometry/Offset;", "magnifierCenter", "zoom", "", "update-Wko1d7g", "(JJF)V", "updateContent", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface PlatformMagnifier {
    void dismiss();

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo15498getSizeYbymL2g();

    /* JADX INFO: renamed from: update-Wko1d7g, reason: not valid java name */
    void mo15499updateWko1d7g(long sourceCenter, long magnifierCenter, float zoom);

    void updateContent();
}
