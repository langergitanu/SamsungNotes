package androidx.customview.poolingcontainer;

import androidx.annotation.UiThread;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, m13886d2 = {"Landroidx/customview/poolingcontainer/PoolingContainerListener;", "", "onRelease", "", "customview-poolingcontainer_release"}, m13887k = 1, m13888mv = {1, 6, 0}, m13890xi = 48)
public interface PoolingContainerListener {
    @UiThread
    void onRelease();
}
