package androidx.constraintlayout.core.motion;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.core.motion.utils.Utils;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class CustomAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    private boolean mMethod;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.motion.CustomAttribute$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C22931 {

        /* JADX INFO: renamed from: $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType */
        static final /* synthetic */ int[] f1212xbc2a0812;

        static {
            int[] iArr = new int[AttributeType.values().length];
            f1212xbc2a0812 = iArr;
            try {
                iArr[AttributeType.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1212xbc2a0812[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1212xbc2a0812[AttributeType.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1212xbc2a0812[AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1212xbc2a0812[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1212xbc2a0812[AttributeType.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1212xbc2a0812[AttributeType.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1212xbc2a0812[AttributeType.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public CustomAttribute(String str, AttributeType attributeType) {
        this.mMethod = false;
        this.mName = str;
        this.mType = attributeType;
    }

    private static int clamp(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static HashMap<String, CustomAttribute> extractAttributes(HashMap<String, CustomAttribute> map, Object obj) {
        HashMap<String, CustomAttribute> map2 = new HashMap<>();
        Class<?> cls = obj.getClass();
        for (String str : map.keySet()) {
            try {
                map2.put(str, new CustomAttribute(map.get(str), cls.getMethod("getMap" + str, null).invoke(obj, null)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        return map2;
    }

    public static int hsvToRgb(float f, float f4, float f5) {
        float f6 = f * 6.0f;
        int i = (int) f6;
        float f7 = f6 - i;
        float f8 = f5 * 255.0f;
        int iM29z = (int) AbstractC0000a.m29z(1.0f, f4, f8, 0.5f);
        int i2 = (int) (((1.0f - (f7 * f4)) * f8) + 0.5f);
        int i4 = (int) (((1.0f - ((1.0f - f7) * f4)) * f8) + 0.5f);
        int i5 = (int) (f8 + 0.5f);
        if (i == 0) {
            return ((i5 << 16) + (i4 << 8) + iM29z) | (-16777216);
        }
        if (i == 1) {
            return ((i2 << 16) + (i5 << 8) + iM29z) | (-16777216);
        }
        if (i == 2) {
            return ((iM29z << 16) + (i5 << 8) + i4) | (-16777216);
        }
        if (i == 3) {
            return ((iM29z << 16) + (i2 << 8) + i5) | (-16777216);
        }
        if (i == 4) {
            return ((i4 << 16) + (iM29z << 8) + i5) | (-16777216);
        }
        if (i != 5) {
            return 0;
        }
        return ((i5 << 16) + (iM29z << 8) + i2) | (-16777216);
    }

    public static void setAttributes(Object obj, HashMap<String, CustomAttribute> map) {
        Class<?> cls = obj.getClass();
        for (String str : map.keySet()) {
            CustomAttribute customAttribute = map.get(str);
            String strM772n = !customAttribute.mMethod ? AbstractC0541b.m772n(FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, str) : str;
            try {
                int i = C22931.f1212xbc2a0812[customAttribute.mType.ordinal()];
                Class cls2 = Float.TYPE;
                Class cls3 = Integer.TYPE;
                switch (i) {
                    case 1:
                        cls.getMethod(strM772n, cls3).invoke(obj, Integer.valueOf(customAttribute.mIntegerValue));
                        break;
                    case 2:
                        cls.getMethod(strM772n, Boolean.TYPE).invoke(obj, Boolean.valueOf(customAttribute.mBooleanValue));
                        break;
                    case 3:
                        cls.getMethod(strM772n, CharSequence.class).invoke(obj, customAttribute.mStringValue);
                        break;
                    case 4:
                        cls.getMethod(strM772n, cls3).invoke(obj, Integer.valueOf(customAttribute.mColorValue));
                        break;
                    case 6:
                        cls.getMethod(strM772n, cls3).invoke(obj, Integer.valueOf(customAttribute.mIntegerValue));
                        break;
                    case 7:
                        cls.getMethod(strM772n, cls2).invoke(obj, Float.valueOf(customAttribute.mFloatValue));
                        break;
                    case 8:
                        cls.getMethod(strM772n, cls2).invoke(obj, Float.valueOf(customAttribute.mFloatValue));
                        break;
                }
            } catch (IllegalAccessException e) {
                StringBuilder sbM15l = AbstractC0000a.m15l(" Custom Attribute \"", str, "\" not found on ");
                sbM15l.append(cls.getName());
                Utils.loge(TAG, sbM15l.toString());
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                Utils.loge(TAG, e2.getMessage());
                Utils.loge(TAG, " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                Utils.loge(TAG, cls.getName() + " must have a method " + strM772n);
            } catch (InvocationTargetException e3) {
                StringBuilder sbM15l2 = AbstractC0000a.m15l(" Custom Attribute \"", str, "\" not found on ");
                sbM15l2.append(cls.getName());
                Utils.loge(TAG, sbM15l2.toString());
                e3.printStackTrace();
            }
        }
    }

    public void applyCustom(Object obj) {
        Class<?> cls = obj.getClass();
        String str = this.mName;
        String strM772n = !this.mMethod ? AbstractC0541b.m772n(FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, str) : str;
        try {
            int i = C22931.f1212xbc2a0812[this.mType.ordinal()];
            Class cls2 = Integer.TYPE;
            Class cls3 = Float.TYPE;
            switch (i) {
                case 1:
                case 6:
                    cls.getMethod(strM772n, cls2).invoke(obj, Integer.valueOf(this.mIntegerValue));
                    break;
                case 2:
                    cls.getMethod(strM772n, Boolean.TYPE).invoke(obj, Boolean.valueOf(this.mBooleanValue));
                    break;
                case 3:
                    cls.getMethod(strM772n, CharSequence.class).invoke(obj, this.mStringValue);
                    break;
                case 4:
                    cls.getMethod(strM772n, cls2).invoke(obj, Integer.valueOf(this.mColorValue));
                    break;
                case 7:
                    cls.getMethod(strM772n, cls3).invoke(obj, Float.valueOf(this.mFloatValue));
                    break;
                case 8:
                    cls.getMethod(strM772n, cls3).invoke(obj, Float.valueOf(this.mFloatValue));
                    break;
            }
        } catch (IllegalAccessException e) {
            StringBuilder sbM15l = AbstractC0000a.m15l(" Custom Attribute \"", str, "\" not found on ");
            sbM15l.append(cls.getName());
            Utils.loge(TAG, sbM15l.toString());
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            Utils.loge(TAG, e2.getMessage());
            Utils.loge(TAG, " Custom Attribute \"" + str + "\" not found on " + cls.getName());
            Utils.loge(TAG, cls.getName() + " must have a method " + strM772n);
        } catch (InvocationTargetException e3) {
            StringBuilder sbM15l2 = AbstractC0000a.m15l(" Custom Attribute \"", str, "\" not found on ");
            sbM15l2.append(cls.getName());
            Utils.loge(TAG, sbM15l2.toString());
            e3.printStackTrace();
        }
    }

    public boolean diff(CustomAttribute customAttribute) {
        AttributeType attributeType;
        if (customAttribute != null && (attributeType = this.mType) == customAttribute.mType) {
            switch (C22931.f1212xbc2a0812[attributeType.ordinal()]) {
                case 1:
                case 6:
                    if (this.mIntegerValue == customAttribute.mIntegerValue) {
                        return true;
                    }
                    break;
                case 2:
                    return this.mBooleanValue == customAttribute.mBooleanValue;
                case 3:
                    return this.mIntegerValue == customAttribute.mIntegerValue;
                case 4:
                case 5:
                    return this.mColorValue == customAttribute.mColorValue;
                case 7:
                    return this.mFloatValue == customAttribute.mFloatValue;
                case 8:
                    return this.mFloatValue == customAttribute.mFloatValue;
                default:
                    return false;
            }
        }
        return false;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (C22931.f1212xbc2a0812[this.mType.ordinal()]) {
            case 2:
                return this.mBooleanValue ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.mIntegerValue;
            case 7:
                return this.mFloatValue;
            case 8:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (C22931.f1212xbc2a0812[this.mType.ordinal()]) {
            case 2:
                fArr[0] = this.mBooleanValue ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i = (this.mColorValue >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i / 255.0f;
                return;
            case 6:
                fArr[0] = this.mIntegerValue;
                return;
            case 7:
                fArr[0] = this.mFloatValue;
                return;
            case 8:
                fArr[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    public boolean isContinuous() {
        int i = C22931.f1212xbc2a0812[this.mType.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        int i = C22931.f1212xbc2a0812[this.mType.ordinal()];
        return (i == 4 || i == 5) ? 4 : 1;
    }

    public void setColorValue(int i) {
        this.mColorValue = i;
    }

    public void setFloatValue(float f) {
        this.mFloatValue = f;
    }

    public void setIntValue(int i) {
        this.mIntegerValue = i;
    }

    public void setInterpolatedValue(Object obj, float[] fArr) {
        Class<?> cls = obj.getClass();
        String str = FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX + this.mName;
        try {
            int i = C22931.f1212xbc2a0812[this.mType.ordinal()];
            if (i == 2) {
                cls.getMethod(str, Boolean.TYPE).invoke(obj, Boolean.valueOf(fArr[0] > 0.5f));
                return;
            }
            if (i == 3) {
                throw new RuntimeException("unable to interpolate strings " + this.mName);
            }
            Class cls2 = Integer.TYPE;
            if (i == 4) {
                cls.getMethod(str, cls2).invoke(obj, Integer.valueOf(clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (fArr[3] * 255.0f)) << 24)));
                return;
            }
            if (i == 6) {
                cls.getMethod(str, cls2).invoke(obj, Integer.valueOf((int) fArr[0]));
                return;
            }
            Class cls3 = Float.TYPE;
            if (i == 7) {
                cls.getMethod(str, cls3).invoke(obj, Float.valueOf(fArr[0]));
            } else {
                if (i != 8) {
                    return;
                }
                cls.getMethod(str, cls3).invoke(obj, Float.valueOf(fArr[0]));
            }
        } catch (IllegalAccessException e) {
            StringBuilder sbM15l = AbstractC0000a.m15l("cannot access method ", str, " on View \"");
            sbM15l.append(obj.getClass().getName());
            sbM15l.append("\"");
            Utils.loge(TAG, sbM15l.toString());
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            StringBuilder sbM15l2 = AbstractC0000a.m15l("no method ", str, " on View \"");
            sbM15l2.append(obj.getClass().getName());
            sbM15l2.append("\"");
            Utils.loge(TAG, sbM15l2.toString());
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        switch (C22931.f1212xbc2a0812[this.mType.ordinal()]) {
            case 1:
            case 6:
                this.mIntegerValue = (int) fArr[0];
                return;
            case 2:
                this.mBooleanValue = ((double) fArr[0]) > 0.5d;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int iHsvToRgb = hsvToRgb(fArr[0], fArr[1], fArr[2]);
                this.mColorValue = iHsvToRgb;
                this.mColorValue = (clamp((int) (fArr[3] * 255.0f)) << 24) | (iHsvToRgb & 16777215);
                return;
            case 7:
                this.mFloatValue = fArr[0];
                return;
            case 8:
                this.mFloatValue = fArr[0];
                return;
            default:
                return;
        }
    }

    public CustomAttribute(String str, AttributeType attributeType, Object obj, boolean z) {
        this.mName = str;
        this.mType = attributeType;
        this.mMethod = z;
        setValue(obj);
    }

    public void setValue(Object obj) {
        switch (C22931.f1212xbc2a0812[this.mType.ordinal()]) {
            case 1:
            case 6:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case 2:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case 3:
                this.mStringValue = (String) obj;
                break;
            case 4:
            case 5:
                this.mColorValue = ((Integer) obj).intValue();
                break;
            case 7:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
            case 8:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
        }
    }

    public CustomAttribute(CustomAttribute customAttribute, Object obj) {
        this.mMethod = false;
        this.mName = customAttribute.mName;
        this.mType = customAttribute.mType;
        setValue(obj);
    }
}
