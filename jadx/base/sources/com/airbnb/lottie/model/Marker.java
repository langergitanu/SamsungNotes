package com.airbnb.lottie.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Marker {
    private static final String CARRIAGE_RETURN = "\r";
    public final float durationFrames;
    private final String name;
    public final float startFrame;

    public Marker(String str, float f, float f4) {
        this.name = str;
        this.durationFrames = f4;
        this.startFrame = f;
    }

    public float getDurationFrames() {
        return this.durationFrames;
    }

    public String getName() {
        return this.name;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public boolean matchesName(String str) {
        if (this.name.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.name.endsWith("\r")) {
            String str2 = this.name;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
