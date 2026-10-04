package io.netty.buffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class UnpooledDuplicatedByteBuf extends DuplicatedByteBuf {
    public UnpooledDuplicatedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i) {
        return unwrap()._getByte(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getInt(int i) {
        return unwrap()._getInt(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i) {
        return unwrap()._getIntLE(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLong(int i) {
        return unwrap()._getLong(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i) {
        return unwrap()._getLongLE(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShort(int i) {
        return unwrap()._getShort(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i) {
        return unwrap()._getShortLE(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i) {
        return unwrap()._getUnsignedMedium(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i) {
        return unwrap()._getUnsignedMediumLE(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setByte(int i, int i2) {
        unwrap()._setByte(i, i2);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setInt(int i, int i2) {
        unwrap()._setInt(i, i2);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i, int i2) {
        unwrap()._setIntLE(i, i2);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLong(int i, long j) {
        unwrap()._setLong(i, j);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i, long j) {
        unwrap()._setLongLE(i, j);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i, int i2) {
        unwrap()._setMedium(i, i2);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i, int i2) {
        unwrap()._setMediumLE(i, i2);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShort(int i, int i2) {
        unwrap()._setShort(i, i2);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i, int i2) {
        unwrap()._setShortLE(i, i2);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.ByteBuf
    public AbstractByteBuf unwrap() {
        return (AbstractByteBuf) super.unwrap();
    }
}
