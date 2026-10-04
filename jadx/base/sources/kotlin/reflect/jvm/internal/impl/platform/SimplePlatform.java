package kotlin.reflect.jvm.internal.impl.platform;

import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SimplePlatform {

    @NotNull
    private final String platformName;

    @NotNull
    private final TargetPlatformVersion targetPlatformVersion;

    @NotNull
    public String getTargetName() {
        return getTargetPlatformVersion().getDescription();
    }

    @NotNull
    public TargetPlatformVersion getTargetPlatformVersion() {
        return this.targetPlatformVersion;
    }

    @NotNull
    public String toString() {
        String targetName = getTargetName();
        if (targetName.length() <= 0) {
            return this.platformName;
        }
        return this.platformName + " (" + targetName + PropertyUtils.MAPPED_DELIM2;
    }
}
