package androidx.appcompat.animation;

import android.annotation.SuppressLint;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RestrictTo;
import com.microsoft.identity.common.java.WarningType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class SeslAnimationUtils {

    @SuppressLint({WarningType.NewApi})
    public static final Interpolator SINE_IN_OUT_70 = new PathInterpolator(0.33f, 0.0f, 0.3f, 1.0f);

    @SuppressLint({WarningType.NewApi})
    public static final Interpolator SINE_IN_OUT_80 = new PathInterpolator(0.33f, 0.0f, 0.2f, 1.0f);

    @SuppressLint({WarningType.NewApi})
    public static final Interpolator SINE_IN_OUT_90 = new PathInterpolator(0.33f, 0.0f, 0.1f, 1.0f);

    @SuppressLint({WarningType.NewApi})
    public static final Interpolator SINE_OUT_33 = new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);

    @SuppressLint({WarningType.NewApi})
    public static final Interpolator SINE_OUT_80 = new PathInterpolator(0.17f, 0.17f, 0.2f, 1.0f);

    @SuppressLint({WarningType.NewApi})
    public static final Interpolator SINE_OUT_70 = new PathInterpolator(0.17f, 0.17f, 0.3f, 1.0f);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final Interpolator ELASTIC_40 = new SeslElasticInterpolator(1.0f, 0.8f);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final Interpolator ELASTIC_50 = new SeslElasticInterpolator(1.0f, 0.7f);
}
