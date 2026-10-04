package com.samsung.android.support.senl.p148nt.base.winset.view.floater.layout;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/layout/IHorizontalDocking;", "", "isStartDockingArea", "", "position", "", "parentWidth", "isEndDockingArea", "isInStartDockingArea", "isInEndDockingArea", "getStartDockingArea", "getEndDockingArea", "getStartDockingPosition", "getEndDockingPosition", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IHorizontalDocking {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final float EXTRA_DOCKING_AREA_RATIO = 1.2f;
    public static final int LEFT_DOCKING_POSITION = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/layout/IHorizontalDocking$Companion;", "", "<init>", "()V", "LEFT_DOCKING_POSITION", "", "EXTRA_DOCKING_AREA_RATIO", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final float EXTRA_DOCKING_AREA_RATIO = 1.2f;
        public static final int LEFT_DOCKING_POSITION = 0;

        private Companion() {
        }
    }

    float getEndDockingArea(float parentWidth);

    float getEndDockingPosition(float parentWidth);

    float getStartDockingArea(float parentWidth);

    float getStartDockingPosition(float parentWidth);

    boolean isEndDockingArea(float position, float parentWidth);

    boolean isInEndDockingArea(float position, float parentWidth);

    boolean isInStartDockingArea(float position, float parentWidth);

    boolean isStartDockingArea(float position, float parentWidth);
}
