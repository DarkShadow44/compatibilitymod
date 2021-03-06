package compat.sandbox.net.minecraftforge.fml.common.network.simpleimpl;

import compat.sandbox.io.netty.buffer.Compat_ByteBuf;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public interface Compat_IMessage extends IMessage {
	public default void toBytes(ByteBuf buf) {
		Compat_toBytes(new Compat_ByteBuf(buf));
	}

	public default void fromBytes(ByteBuf buf) {
		Compat_fromBytes(new Compat_ByteBuf(buf));
	}

	public void Compat_toBytes(Compat_ByteBuf buf);

	public void Compat_fromBytes(Compat_ByteBuf buf);
}
