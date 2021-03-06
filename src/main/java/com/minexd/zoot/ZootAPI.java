package com.minexd.zoot;

import com.minexd.zoot.profile.Profile;
import com.minexd.zoot.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ZootAPI {

	public static ChatColor getColorOfPlayer(Player player) {
		Profile profile = Profile.getProfiles().get(player.getUniqueId());
		return profile == null ? ChatColor.WHITE : profile.getActiveRank().getColor();
	}

	public static String getColoredName(Player player) {
		Profile profile = Profile.getProfiles().get(player.getUniqueId());
		return (profile == null ? ChatColor.WHITE : profile.getActiveRank().getColor()) + player.getName();
	}

	public static Rank getRankOfPlayer(Player player) {
		Profile profile = Profile.getProfiles().get(player.getUniqueId());
		return profile == null ? Rank.getDefaultRank() : profile.getActiveRank();
	}

	public static boolean isInStaffMode(Player player) {
		Profile profile = Profile.getProfiles().get(player.getUniqueId());
		return profile != null && player.hasPermission("zoot.staff") && profile.getStaffOptions().staffModeEnabled();
	}

}
