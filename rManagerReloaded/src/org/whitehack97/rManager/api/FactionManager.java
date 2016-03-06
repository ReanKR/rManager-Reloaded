package org.whitehack97.rManager.api;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.massivecraft.factions.entity.Faction;

public class FactionManager
{
	private Player player;
	private World FactionWorld;
	private boolean WorldPassed = false;
	private boolean EnabledWhiteList = false;
	private boolean EnabledBlackList = false;
	private Faction faction;
	private List<String> WhiteList = new ArrayList<String>();
	private List<String> BlackList = new ArrayList<String>();
	
	public FactionManager(Player player)
	{
		this.player = player;
	}
	/*
	  	if(!PlayerSection.contains("UUID")) PlayerSection.set("UUID", player.getUniqueId().toString());
		if(!PlayerSection.contains("World.Faction-World")) PlayerSection.set("World.Faction-World", "None");
		if(!PlayerSection.contains("World.World-Passed")) PlayerSection.set("World.World-Passed", false);
		if(!PlayerSection.contains("World.Whitelist.Enabled")) PlayerSection.set("World.Whitelist.Enabled", false);
		if(!PlayerSection.contains("World.Blacklist.Enabled")) PlayerSection.set("World.Blacklist.Enabled", false);
	 */
	
	public void setFaction(Faction faction)
	{
		this.faction = faction;
	}
	
	public boolean setFactionWorld(String WorldName)
	{
		try
		{
			this.FactionWorld = Bukkit.getServer().getWorld(WorldName);
		}
		catch(NullPointerException e)
		{
			return false;
		}
		return true;
	}
	
	public void EnableWhiteList(boolean Enabled)
	{
		this.EnabledWhiteList = Enabled;
	}
	
	public void EnableBlackList(boolean Enabled)
	{
		this.EnabledBlackList = Enabled;
	}
	
	public boolean addWhiteList(String PlayerName)
	{
		if(WhiteList.contains(PlayerName.toLowerCase()))
		{
			return false;
		}
		else
		{
			this.WhiteList.add(PlayerName.toLowerCase());
			return true;
		}
	}
	
	public boolean delWhiteList(String PlayerName)
	{
		if(! WhiteList.contains(PlayerName.toLowerCase()))
		{
			return false;
		}
		else
		{
			this.WhiteList.remove(PlayerName.toLowerCase());
			return true;
		}
	}
	
	public boolean addBlackList(String PlayerName)
	{
		if(BlackList.contains(PlayerName.toLowerCase()))
		{
			return false;
		}
		else
		{
			this.BlackList.add(PlayerName.toLowerCase());
			return true;
		}
	}
	
	public boolean delBlackList(String PlayerName)
	{
		if(! BlackList.contains(PlayerName.toLowerCase()))
		{
			return false;
		}
		else
		{
			this.BlackList.remove(PlayerName.toLowerCase());
			return true;
		}
	}
	
	public Player getPlayer()
	{
		return this.player;
	}
	
	public Faction getFaction()
	{
		return this.faction;
	}
	
	public World getFactionWorld()
	{
		return this.FactionWorld;
	}
	
	public boolean isWorldPassed()
	{
		return this.WorldPassed;
	}
	
	public boolean WhiteListEnabled()
	{
		return this.EnabledWhiteList;
	}
	
	public boolean BlackListEnabled()
	{
		return this.EnabledBlackList;
	}
}
