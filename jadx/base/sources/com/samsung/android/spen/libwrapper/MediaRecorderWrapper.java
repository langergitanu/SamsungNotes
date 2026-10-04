package com.samsung.android.spen.libwrapper;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.spen.libinterface.MediaRecorderConfigInterface;
import com.samsung.android.spen.libinterface.MediaRecorderInterface;
import com.samsung.android.spen.libsdl.SdlMediaRecorder;
import com.samsung.android.spen.libse.SeMediaRecorder;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MediaRecorderWrapper {
    private static boolean isSeDevice;
    private MediaRecorderInterface instance;

    private MediaRecorderWrapper(MediaRecorderInterface mediaRecorderInterface) throws PlatformException {
        try {
            this.instance = mediaRecorderInterface;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static MediaRecorderWrapper create(Context context) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            isSeDevice = true;
            try {
                return new MediaRecorderWrapper(new SeMediaRecorder());
            } catch (Error | Exception e) {
                throw new PlatformException(PlatformException.f5434SE, e);
            }
        }
        isSeDevice = false;
        try {
            return new MediaRecorderWrapper(new SdlMediaRecorder());
        } catch (Error | Exception e2) {
            throw new PlatformException(PlatformException.SDL, e2);
        }
    }

    public static boolean isRecorderWorking() throws PlatformException {
        try {
            return isSeDevice ? SeMediaRecorder.isRecorderWorking() : SdlMediaRecorder.isRecorderWorking();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public boolean cancel() throws PlatformException {
        try {
            return this.instance.cancel();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public int getMaxAmplitude() throws PlatformException {
        try {
            return this.instance.getMaxAmplitude();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public boolean isPauseSupported() throws PlatformException {
        try {
            return this.instance.isPauseSupported();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public boolean isStarting() throws PlatformException {
        try {
            return this.instance.isStarting();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public boolean pause(MediaRecorderInterface.MediaRecorderListener mediaRecorderListener) throws PlatformException {
        try {
            return this.instance.pause(mediaRecorderListener);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void prepare() throws PlatformException {
        try {
            this.instance.prepare();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public boolean prepareRecording(String str, int i, int i2) throws PlatformException {
        try {
            return this.instance.prepareRecording(str, i, i2);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void release() throws PlatformException {
        try {
            this.instance.release();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void reset() throws PlatformException {
        try {
            this.instance.reset();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public boolean resume(MediaRecorderInterface.MediaRecorderListener mediaRecorderListener) throws PlatformException {
        try {
            return this.instance.resume(mediaRecorderListener);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setActionListener(MediaRecorderInterface.ActionListener actionListener) throws PlatformException {
        try {
            this.instance.setActionListener(actionListener);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setAudioEncoder(int i) throws PlatformException {
        try {
            this.instance.setAudioEncoder(i);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setAudioSource(int i) throws PlatformException {
        try {
            this.instance.setAudioSource(i);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setMediaRecorderConfig(@NonNull MediaRecorderConfigInterface mediaRecorderConfigInterface) {
        this.instance.setMediaRecorderConfig(mediaRecorderConfigInterface);
    }

    public void setOutputFile(String str) throws PlatformException {
        try {
            this.instance.setOutputFile(str);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setOutputFormat(int i) throws PlatformException {
        try {
            this.instance.setOutputFormat(i);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setTimeListener(MediaRecorderInterface.TimeListener timeListener) throws PlatformException {
        try {
            this.instance.setTimeListener(timeListener);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public boolean start(String str, MediaRecorderInterface.MediaRecorderListener mediaRecorderListener, int i, int i2) throws PlatformException {
        try {
            return this.instance.start(str, mediaRecorderListener, i, i2);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public boolean stop(MediaRecorderInterface.MediaRecorderListener mediaRecorderListener) throws PlatformException {
        try {
            return this.instance.stop(mediaRecorderListener);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static MediaRecorderWrapper create(MediaRecorderInterface mediaRecorderInterface) throws PlatformException {
        try {
            return new MediaRecorderWrapper(mediaRecorderInterface);
        } catch (Error | Exception e) {
            throw new PlatformException(PlatformException.f5434SE, e);
        }
    }
}
