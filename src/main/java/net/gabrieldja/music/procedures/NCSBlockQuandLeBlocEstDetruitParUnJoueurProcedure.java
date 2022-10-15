package net.gabrieldja.music.procedures;

import net.minecraft.world.entity.Entity;

public class NCSBlockQuandLeBlocEstDetruitParUnJoueurProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performPrefixedCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
						"stopsound @s music");
		}
	}
}
