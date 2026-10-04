package androidx.constraintlayout.motion.widget;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
interface ProxyInterface {
    int designAccess(int i, String str, Object obj, float[] fArr, int i2, float[] fArr2, int i4);

    float getKeyFramePosition(Object obj, int i, float f, float f4);

    Object getKeyframeAtLocation(Object obj, float f, float f4);

    Boolean getPositionKeyframe(Object obj, Object obj2, float f, float f4, String[] strArr, float[] fArr);

    long getTransitionTimeMs();

    void setAttributes(int i, String str, Object obj, Object obj2);

    void setKeyFrame(Object obj, int i, String str, Object obj2);

    boolean setKeyFramePosition(Object obj, int i, int i2, float f, float f4);

    void setToolPosition(float f);
}
