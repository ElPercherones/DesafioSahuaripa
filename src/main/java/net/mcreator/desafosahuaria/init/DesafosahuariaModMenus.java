
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.desafosahuaria.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.desafosahuaria.world.inventory.ReliquiaGUIMenu;
import net.mcreator.desafosahuaria.DesafosahuariaMod;

public class DesafosahuariaModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DesafosahuariaMod.MODID);
	public static final RegistryObject<MenuType<ReliquiaGUIMenu>> RELIQUIA_GUI = REGISTRY.register("reliquia_gui", () -> IForgeMenuType.create(ReliquiaGUIMenu::new));
}
