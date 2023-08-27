
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
import net.mcreator.desafosahuaria.world.inventory.Muerte2Menu;
import net.mcreator.desafosahuaria.world.inventory.Muerte1Menu;
import net.mcreator.desafosahuaria.DesafosahuariaMod;

public class DesafosahuariaModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DesafosahuariaMod.MODID);
	public static final RegistryObject<MenuType<ReliquiaGUIMenu>> RELIQUIA_GUI = REGISTRY.register("reliquia_gui", () -> IForgeMenuType.create(ReliquiaGUIMenu::new));
	public static final RegistryObject<MenuType<Muerte1Menu>> MUERTE_1 = REGISTRY.register("muerte_1", () -> IForgeMenuType.create(Muerte1Menu::new));
	public static final RegistryObject<MenuType<Muerte2Menu>> MUERTE_2 = REGISTRY.register("muerte_2", () -> IForgeMenuType.create(Muerte2Menu::new));
}
