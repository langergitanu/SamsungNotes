package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class PathKeyframe extends Keyframe<PointF> {

    @Nullable
    private Path path;
    private final Keyframe<PointF> pointKeyFrame;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.xInterpolator, keyframe.yInterpolator, keyframe.startFrame, keyframe.endFrame);
        this.pointKeyFrame = keyframe;
        createPath();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void createPath() {
        T t;
        T t2;
        T t5 = this.endValue;
        boolean z = (t5 == 0 || (t2 = this.startValue) == 0 || !((PointF) t2).equals(((PointF) t5).x, ((PointF) t5).y)) ? false : true;
        T t6 = this.startValue;
        if (t6 == 0 || (t = this.endValue) == 0 || z) {
            return;
        }
        Keyframe<PointF> keyframe = this.pointKeyFrame;
        this.path = Utils.createPath((PointF) t6, (PointF) t, keyframe.pathCp1, keyframe.pathCp2);
    }

    @Nullable
    public Path getPath() {
        return this.path;
    }
}
