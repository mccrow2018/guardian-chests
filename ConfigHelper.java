package me.twentyonez.guardianchest.util;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * GuardianChest mod
 *
 * @author TwentyOneZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 * Based on NightKosh's GraveStone mod, Dr.Cyano's Lootable Corpses mod and Tyler15555's Death Chest mod.
 */

public class ConfigHelper {

	public ConfigHelper() {
		
	}
	
	public static boolean makeAllItemsDrop;
	private static Property makeAllItemsDropProp;
	
	public static boolean requireGuardianIdol;
	private static Property requireGuardianIdolProp;
	
	public static boolean anyEnchantSoulBinds;
	private static Property anyEnchantSoulBindsProp;

	public static Integer levelCostGuardianTier1;
	private static Property levelCostGuardianTier1Prop;

	public static Integer levelCostBoundMapTier1;
	private static Property levelCostBoundMapTier1Prop;
	
	public static Integer maxRadiusToSearchForAFreeSpot;
	private static Property maxRadiusToSearchForAFreeSpotProp;

	public static Integer timeBeforeUnsecure;
	private static Property timeBeforeUnsecureProp;

	public static boolean broadcastChestCoords;
	private static Property broadcastChestCoordsProp;

	public static void setupConfig(Configuration cfg, Logger logger) {
		try {
			anyEnchantSoulBindsProp = cfg.get(LanguageRegistry.instance().getStringLocalization("config.Category.General"), "anyEnchantSoulBinds", false);
			anyEnchantSoulBindsProp.comment = LanguageRegistry.instance().getStringLocalization("config.Enchantments.AreAllSoulBound");
			anyEnchantSoulBinds = anyEnchantSoulBindsProp.getBoolean(false);

			makeAllItemsDropProp = cfg.get(LanguageRegistry.instance().getStringLocalization("config.Category.General"), "makeAllItemsDrop", true);
			makeAllItemsDropProp.comment = LanguageRegistry.instance().getStringLocalization("config.AllItems.MakeDrop");
			makeAllItemsDrop = makeAllItemsDropProp.getBoolean(true);

			levelCostGuardianTier1Prop = cfg.get(LanguageRegistry.instance().getStringLocalization("config.Category.General"), "levelCostGuardianTier1", 1);
			levelCostGuardianTier1Prop.comment = LanguageRegistry.instance().getStringLocalization("config.GuardianTier1.LevelRequirement").replace("%1", LanguageRegistry.instance().getStringLocalization("item.guardianTier0.name"));
			levelCostGuardianTier1 = levelCostGuardianTier1Prop.getInt(1);

			levelCostBoundMapTier1Prop = cfg.get(LanguageRegistry.instance().getStringLocalization("config.Category.General"), "levelCostBoundMapTier1", 10);
			levelCostBoundMapTier1Prop.comment = LanguageRegistry.instance().getStringLocalization("config.BoundMapTier1.LevelRequirement").replace("%1", LanguageRegistry.instance().getStringLocalization("item.boundMapTier0.name"));
			levelCostBoundMapTier1 = levelCostBoundMapTier1Prop.getInt(10);

			requireGuardianIdolProp = cfg.get(LanguageRegistry.instance().getStringLocalization("config.Category.General"), "requireGuardianIdol", true);
			requireGuardianIdolProp.comment = LanguageRegistry.instance().getStringLocalization("config.GuardianIdol.Requirement").replace("%1", LanguageRegistry.instance().getStringLocalization("item.guardianTier0.name"));
			requireGuardianIdol = requireGuardianIdolProp.getBoolean(true);

			maxRadiusToSearchForAFreeSpotProp = cfg.get(LanguageRegistry.instance().getStringLocalization("config.Category.General"), "maxRadiusToSearchForAFreeSpot", 5);
			maxRadiusToSearchForAFreeSpotProp.comment = LanguageRegistry.instance().getStringLocalization("config.maxDistanceToSearchForAFreeSpot.Radius").replace("%1", LanguageRegistry.instance().getStringLocalization("tile.guardianChest.name"));
			maxRadiusToSearchForAFreeSpot = maxRadiusToSearchForAFreeSpotProp.getInt(5);

			timeBeforeUnsecureProp = cfg.get(LanguageRegistry.instance().getStringLocalization("config.Category.General"), "timeBeforeUnsecure", 300);
			timeBeforeUnsecureProp.comment = LanguageRegistry.instance().getStringLocalization("config.timeBeforeUnsecure.Seconds").replace("%1", LanguageRegistry.instance().getStringLocalization("tile.guardianChest.name"));
			timeBeforeUnsecure = timeBeforeUnsecureProp.getInt(300);

			broadcastChestCoordsProp = cfg.get(LanguageRegistry.instance().getStringLocalization("config.Category.General"), "broadcastChestCoords", true);
			broadcastChestCoordsProp.comment = LanguageRegistry.instance().getStringLocalization("config.Broadcast.ChestCoordinates").replace("%1", LanguageRegistry.instance().getStringLocalization("tile.guardianChest.name"));
			broadcastChestCoords = broadcastChestCoordsProp.getBoolean(true);

		} catch(Exception e) {
			logger.log(Level.ERROR, LanguageRegistry.instance().getStringLocalization("config.Error.Message"));
			e.printStackTrace();
		} finally {
			if(cfg.hasChanged()) {
				cfg.save();
			}
		}
	}

}
