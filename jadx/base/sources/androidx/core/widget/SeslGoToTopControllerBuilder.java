package androidx.core.widget;

import androidx.annotation.NonNull;
import androidx.core.widget.SeslGoToTopController;
import androidx.core.widget.SeslGoToTopControllerBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SeslGoToTopControllerBuilder<T extends SeslGoToTopController, B extends SeslGoToTopControllerBuilder<T, B>> {
    protected SeslGoToTopConfig config;
    protected SeslGoToTopController.Host host;

    public abstract T build();

    public B setConfig(@NonNull SeslGoToTopConfig seslGoToTopConfig) {
        this.config = seslGoToTopConfig;
        return this;
    }

    public B setHost(@NonNull SeslGoToTopController.Host host) {
        this.host = host;
        return this;
    }

    public void validate() {
        if (this.host == null) {
            throw new IllegalStateException("host required");
        }
        if (this.config == null) {
            throw new IllegalStateException("config required");
        }
    }
}
