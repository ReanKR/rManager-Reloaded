package org.whitehack97.rManager.Factions.Listener;

import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.whitehack97.rManager.Util.FileManager;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.factions.event.EventFactionsCreate;
import com.massivecraft.factions.event.EventFactionsDisband;
import com.massivecraft.factions.event.EventFactionsNameChange;

public class FactionsListener implements Listener
{
	@EventHandler
	public void FactionsDisband(EventFactionsDisband event)
	{
		Faction faction = event.getFaction();
		List<MPlayer> mplayer = faction.getMPlayers();
		for(MPlayer mp : mplayer)
		{
			Player player = mp.getPlayer();
			YamlConfiguration PlayerSection = FileManager.LoadSourceFile("Players/" + player.getName());
			PlayerSection.set("Faction-Name", "None");
		}
	}
	
	@EventHandler
	public void FactionsChangeName(EventFactionsNameChange event)
	{
		List<MPlayer> mplayer = event.getFaction().getMPlayers();
		String factionName = event.getFaction().getName();
		for(MPlayer mp : mplayer)
		{
			Player player = mp.getPlayer();
			YamlConfiguration PlayerSection = FileManager.LoadSourceFile("Players/" + player.getName());
			PlayerSection.set("Faction-Name", factionName);
		}
	}
	
	@EventHandler
	public void FactionsCreate(EventFactionsCreate event)
	{
		event.get
	}
}
