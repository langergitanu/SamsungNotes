package org.apache.poi.java.awt;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.poi.sun.awt.SunHints;

/* JADX INFO: loaded from: classes10.dex */
public class RenderingHints implements Map<Object, Object>, Cloneable {
    HashMap hintmap;
    public static final Key KEY_ANTIALIASING = SunHints.KEY_ANTIALIASING;
    public static final Object VALUE_ANTIALIAS_ON = SunHints.VALUE_ANTIALIAS_ON;
    public static final Object VALUE_ANTIALIAS_OFF = SunHints.VALUE_ANTIALIAS_OFF;
    public static final Object VALUE_ANTIALIAS_DEFAULT = SunHints.VALUE_ANTIALIAS_DEFAULT;
    public static final Key KEY_RENDERING = SunHints.KEY_RENDERING;
    public static final Object VALUE_RENDER_SPEED = SunHints.VALUE_RENDER_SPEED;
    public static final Object VALUE_RENDER_QUALITY = SunHints.VALUE_RENDER_QUALITY;
    public static final Object VALUE_RENDER_DEFAULT = SunHints.VALUE_RENDER_DEFAULT;
    public static final Key KEY_DITHERING = SunHints.KEY_DITHERING;
    public static final Object VALUE_DITHER_DISABLE = SunHints.VALUE_DITHER_DISABLE;
    public static final Object VALUE_DITHER_ENABLE = SunHints.VALUE_DITHER_ENABLE;
    public static final Object VALUE_DITHER_DEFAULT = SunHints.VALUE_DITHER_DEFAULT;
    public static final Key KEY_TEXT_ANTIALIASING = SunHints.KEY_TEXT_ANTIALIASING;
    public static final Object VALUE_TEXT_ANTIALIAS_ON = SunHints.VALUE_TEXT_ANTIALIAS_ON;
    public static final Object VALUE_TEXT_ANTIALIAS_OFF = SunHints.VALUE_TEXT_ANTIALIAS_OFF;
    public static final Object VALUE_TEXT_ANTIALIAS_DEFAULT = SunHints.VALUE_TEXT_ANTIALIAS_DEFAULT;
    public static final Object VALUE_TEXT_ANTIALIAS_GASP = SunHints.VALUE_TEXT_ANTIALIAS_GASP;
    public static final Object VALUE_TEXT_ANTIALIAS_LCD_HRGB = SunHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB;
    public static final Object VALUE_TEXT_ANTIALIAS_LCD_HBGR = SunHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR;
    public static final Object VALUE_TEXT_ANTIALIAS_LCD_VRGB = SunHints.VALUE_TEXT_ANTIALIAS_LCD_VRGB;
    public static final Object VALUE_TEXT_ANTIALIAS_LCD_VBGR = SunHints.VALUE_TEXT_ANTIALIAS_LCD_VBGR;
    public static final Key KEY_TEXT_LCD_CONTRAST = SunHints.KEY_TEXT_ANTIALIAS_LCD_CONTRAST;
    public static final Key KEY_FRACTIONALMETRICS = SunHints.KEY_FRACTIONALMETRICS;
    public static final Object VALUE_FRACTIONALMETRICS_OFF = SunHints.VALUE_FRACTIONALMETRICS_OFF;
    public static final Object VALUE_FRACTIONALMETRICS_ON = SunHints.VALUE_FRACTIONALMETRICS_ON;
    public static final Object VALUE_FRACTIONALMETRICS_DEFAULT = SunHints.VALUE_FRACTIONALMETRICS_DEFAULT;
    public static final Key KEY_INTERPOLATION = SunHints.KEY_INTERPOLATION;
    public static final Object VALUE_INTERPOLATION_NEAREST_NEIGHBOR = SunHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR;
    public static final Object VALUE_INTERPOLATION_BILINEAR = SunHints.VALUE_INTERPOLATION_BILINEAR;
    public static final Object VALUE_INTERPOLATION_BICUBIC = SunHints.VALUE_INTERPOLATION_BICUBIC;
    public static final Key KEY_ALPHA_INTERPOLATION = SunHints.KEY_ALPHA_INTERPOLATION;
    public static final Object VALUE_ALPHA_INTERPOLATION_SPEED = SunHints.VALUE_ALPHA_INTERPOLATION_SPEED;
    public static final Object VALUE_ALPHA_INTERPOLATION_QUALITY = SunHints.VALUE_ALPHA_INTERPOLATION_QUALITY;
    public static final Object VALUE_ALPHA_INTERPOLATION_DEFAULT = SunHints.VALUE_ALPHA_INTERPOLATION_DEFAULT;
    public static final Key KEY_COLOR_RENDERING = SunHints.KEY_COLOR_RENDERING;
    public static final Object VALUE_COLOR_RENDER_SPEED = SunHints.VALUE_COLOR_RENDER_SPEED;
    public static final Object VALUE_COLOR_RENDER_QUALITY = SunHints.VALUE_COLOR_RENDER_QUALITY;
    public static final Object VALUE_COLOR_RENDER_DEFAULT = SunHints.VALUE_COLOR_RENDER_DEFAULT;
    public static final Key KEY_STROKE_CONTROL = SunHints.KEY_STROKE_CONTROL;
    public static final Object VALUE_STROKE_DEFAULT = SunHints.VALUE_STROKE_DEFAULT;
    public static final Object VALUE_STROKE_NORMALIZE = SunHints.VALUE_STROKE_NORMALIZE;
    public static final Object VALUE_STROKE_PURE = SunHints.VALUE_STROKE_PURE;

    public static abstract class Key {
        private static HashMap identitymap = new HashMap(17);
        private int privatekey;

        public Key(int i) {
            this.privatekey = i;
            recordIdentity(this);
        }

        private String getIdentity() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append(Log.TAG_SEPARATOR);
            sb.append(Integer.toHexString(System.identityHashCode(getClass())));
            sb.append(":");
            return AbstractC1974b.m1316i(this.privatekey, sb);
        }

        private static synchronized void recordIdentity(Key key) {
            Key key2;
            try {
                String identity = key.getIdentity();
                Object obj = identitymap.get(identity);
                if (obj != null && (key2 = (Key) ((WeakReference) obj).get()) != null && key2.getClass() == key.getClass()) {
                    throw new IllegalArgumentException(((Object) identity) + " already registered");
                }
                identitymap.put(identity, new WeakReference(key));
            } catch (Throwable th) {
                throw th;
            }
        }

        public final boolean equals(Object obj) {
            return this == obj;
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public final int intKey() {
            return this.privatekey;
        }

        public abstract boolean isCompatibleValue(Object obj);
    }

    public RenderingHints(Map<Key, ?> map) {
        HashMap map2 = new HashMap(7);
        this.hintmap = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    public void add(RenderingHints renderingHints) {
        this.hintmap.putAll(renderingHints.hintmap);
    }

    @Override // java.util.Map
    public void clear() {
        this.hintmap.clear();
    }

    public Object clone() {
        try {
            RenderingHints renderingHints = (RenderingHints) super.clone();
            HashMap map = this.hintmap;
            if (map != null) {
                renderingHints.hintmap = (HashMap) map.clone();
            }
            return renderingHints;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.hintmap.containsKey((Key) obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.hintmap.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return Collections.unmodifiableMap(this.hintmap).entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        HashMap map;
        if (obj instanceof RenderingHints) {
            map = this.hintmap;
            obj = ((RenderingHints) obj).hintmap;
        } else {
            if (!(obj instanceof Map)) {
                return false;
            }
            map = this.hintmap;
        }
        return map.equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.hintmap.get((Key) obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.hintmap.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.hintmap.isEmpty();
    }

    @Override // java.util.Map
    public Set<Object> keySet() {
        return this.hintmap.keySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        Key key = (Key) obj;
        if (key.isCompatibleValue(obj2)) {
            return this.hintmap.put(key, obj2);
        }
        throw new IllegalArgumentException(obj2 + " incompatible with " + obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Object, ? extends Object> map) {
        boolean zIsInstance = RenderingHints.class.isInstance(map);
        Iterator<Map.Entry<? extends Object, ? extends Object>> it = map.entrySet().iterator();
        if (zIsInstance) {
            while (it.hasNext()) {
                Map.Entry<? extends Object, ? extends Object> next = it.next();
                this.hintmap.put(next.getKey(), next.getValue());
            }
        } else {
            while (it.hasNext()) {
                Map.Entry<? extends Object, ? extends Object> next2 = it.next();
                put(next2.getKey(), next2.getValue());
            }
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.hintmap.remove((Key) obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.hintmap.size();
    }

    public String toString() {
        HashMap map = this.hintmap;
        if (map != null) {
            return map.toString();
        }
        return getClass().getName() + Log.TAG_SEPARATOR + Integer.toHexString(hashCode()) + " (0 hints)";
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.hintmap.values();
    }

    public RenderingHints(Key key, Object obj) {
        HashMap map = new HashMap(7);
        this.hintmap = map;
        map.put(key, obj);
    }
}
