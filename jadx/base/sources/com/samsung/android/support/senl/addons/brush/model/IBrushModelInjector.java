package com.samsung.android.support.senl.addons.brush.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/IBrushModelInjector;", "", "thumbnailMargin", "Lcom/samsung/android/support/senl/addons/brush/model/IBrushModelInjector$Margin;", "getThumbnailMargin", "()Lcom/samsung/android/support/senl/addons/brush/model/IBrushModelInjector$Margin;", "Margin", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBrushModelInjector {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/IBrushModelInjector$Margin;", "", "horizontal", "", "vertical", "<init>", "(II)V", "getHorizontal", "()I", "getVertical", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Margin {
        private final int horizontal;
        private final int vertical;

        public Margin(int i, int i2) {
            this.horizontal = i;
            this.vertical = i2;
        }

        public final int getHorizontal() {
            return this.horizontal;
        }

        public final int getVertical() {
            return this.vertical;
        }
    }

    @NotNull
    Margin getThumbnailMargin();
}
