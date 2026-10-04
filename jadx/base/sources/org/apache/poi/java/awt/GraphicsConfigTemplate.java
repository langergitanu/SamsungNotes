package org.apache.poi.java.awt;

import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public abstract class GraphicsConfigTemplate implements Serializable {
    public static final int PREFERRED = 2;
    public static final int REQUIRED = 1;
    public static final int UNNECESSARY = 3;
    private static final long serialVersionUID = -8061369279557787079L;

    public abstract GraphicsConfiguration getBestConfiguration(GraphicsConfiguration[] graphicsConfigurationArr);

    public abstract boolean isGraphicsConfigSupported(GraphicsConfiguration graphicsConfiguration);
}
