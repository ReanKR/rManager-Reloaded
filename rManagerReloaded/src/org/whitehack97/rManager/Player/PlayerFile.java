package org.whitehack97.rManager.Player;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.whitehack97.rManager.Util.FileManager;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;

public class PlayerFile
{
	public void PlayerLoad(Player player)
	{
		MPlayer mplayer = MPlayer.get(player);
		Faction faction = null;
		String FactionName = null;
		if(mplayer.getFaction() != null)
		{
			faction = mplayer.getFaction();
			FactionName = faction.getName();
		}
		else
		{
			FactionName = "None";
		}
		YamlConfiguration PlayerSection = FileManager.LoadSourceFile("Players/" + player.getName());
		if(!PlayerSection.contains("UUID")) PlayerSection.set("UUID", player.getUniqueId().toString());
		if(!PlayerSection.contains("Faction-Name")) PlayerSection.set("Faction-Name", FactionName);
		if(!PlayerSection.contains("World.Faction-World")) PlayerSection.set("World.Faction-World", "None");
		if(!PlayerSection.contains("World.World-Passed")) PlayerSection.set("World.World-Passed", false);
		if(!PlayerSection.contains("World.Whitelist.Enabled")) PlayerSection.set("World.Whitelist.Enabled", false);
		if(!PlayerSection.contains("World.Blacklist.Enabled")) PlayerSection.set("World.Blacklist.Enabled", false);		
	}
}