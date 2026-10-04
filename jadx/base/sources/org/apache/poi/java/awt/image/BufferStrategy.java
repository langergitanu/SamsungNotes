package org.apache.poi.java.awt.image;

import org.apache.poi.java.awt.BufferCapabilities;
import org.apache.poi.java.awt.Graphics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class BufferStrategy {
    public abstract boolean contentsLost();

    public abstract boolean contentsRestored();

    public abstract BufferCapabilities getCapabilities();

    public abstract Graphics getDrawGraphics();

    public abstract void show();

    public void dispose() {
    }
}
