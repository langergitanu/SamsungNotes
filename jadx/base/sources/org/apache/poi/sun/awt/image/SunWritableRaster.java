package org.apache.poi.sun.awt.image;

import org.apache.poi.java.awt.Image;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.DataBuffer;
import org.apache.poi.java.awt.image.DataBufferByte;
import org.apache.poi.java.awt.image.DataBufferInt;
import org.apache.poi.java.awt.image.DataBufferUShort;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.sun.java2d.StateTrackable;
import org.apache.poi.sun.java2d.StateTrackableDelegate;
import org.apache.poi.sun.java2d.SurfaceData;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SunWritableRaster extends WritableRaster {
    private static DataStealer stealer;
    private StateTrackableDelegate theTrackable;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DataStealer {
        byte[] getData(DataBufferByte dataBufferByte, int i);

        int[] getData(DataBufferInt dataBufferInt, int i);

        short[] getData(DataBufferUShort dataBufferUShort, int i);

        StateTrackableDelegate getTrackable(DataBuffer dataBuffer);

        void setTrackable(DataBuffer dataBuffer, StateTrackableDelegate stateTrackableDelegate);
    }

    public SunWritableRaster(SampleModel sampleModel, Point point) {
        super(sampleModel, point);
        this.theTrackable = stealTrackable(this.dataBuffer);
    }

    public static void makeTrackable(DataBuffer dataBuffer) {
        stealer.setTrackable(dataBuffer, StateTrackableDelegate.createInstance(StateTrackable.State.STABLE));
    }

    public static void markDirty(DataBuffer dataBuffer) {
        stealer.getTrackable(dataBuffer).markDirty();
    }

    public static void setDataStealer(DataStealer dataStealer) {
        if (stealer != null) {
            throw new InternalError("Attempt to set DataStealer twice");
        }
        stealer = dataStealer;
    }

    public static void setTrackable(DataBuffer dataBuffer, StateTrackableDelegate stateTrackableDelegate) {
        stealer.setTrackable(dataBuffer, stateTrackableDelegate);
    }

    public static byte[] stealData(DataBufferByte dataBufferByte, int i) {
        return stealer.getData(dataBufferByte, i);
    }

    public static StateTrackableDelegate stealTrackable(DataBuffer dataBuffer) {
        return stealer.getTrackable(dataBuffer);
    }

    public static void markDirty(WritableRaster writableRaster) {
        if (writableRaster instanceof SunWritableRaster) {
            ((SunWritableRaster) writableRaster).markDirty();
        } else {
            markDirty(writableRaster.getDataBuffer());
        }
    }

    public static short[] stealData(DataBufferUShort dataBufferUShort, int i) {
        return stealer.getData(dataBufferUShort, i);
    }

    public SunWritableRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point point) {
        super(sampleModel, dataBuffer, point);
        this.theTrackable = stealTrackable(dataBuffer);
    }

    public static int[] stealData(DataBufferInt dataBufferInt, int i) {
        return stealer.getData(dataBufferInt, i);
    }

    public SunWritableRaster(SampleModel sampleModel, DataBuffer dataBuffer, Rectangle rectangle, Point point, WritableRaster writableRaster) {
        super(sampleModel, dataBuffer, rectangle, point, writableRaster);
        this.theTrackable = stealTrackable(dataBuffer);
    }

    public static void markDirty(Image image) {
        SurfaceData.getPrimarySurfaceData(image).markDirty();
    }

    public final void markDirty() {
        this.theTrackable.markDirty();
    }
}
