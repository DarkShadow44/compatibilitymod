package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.network.simpleimpl;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player.Compat_EntityPlayerMP;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.relauncher.Compat_Side;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class Compat_SimpleNetworkWrapper {

	private final SimpleNetworkWrapper original;

	public Compat_SimpleNetworkWrapper(SimpleNetworkWrapper original) {
		this.original = original;
	}

	public <REQ extends Compat_IMessage, REPLY extends Compat_IMessage> void Compat_registerMessage(Class<? extends Compat_IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, int discriminator, Compat_Side side) {
		original.registerMessage(messageHandler, requestMessageType, discriminator, side.getReal()); // TODO?
	}

	public void Compat_sendTo(Compat_IMessage message, Compat_EntityPlayerMP player) {
		original.sendTo(message, player.getReal());
	}
}
