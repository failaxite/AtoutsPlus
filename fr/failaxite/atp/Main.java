/*    */ package fr.failaxite.atp;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class Main
/*    */   extends JavaPlugin
/*    */ {
/*    */   static Main instance;
/*    */   
/*    */   public void onEnable() {
/* 17 */     saveDefaultConfig();
/* 18 */     Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[AtoutsPlus] Made By failaxite#6716");
/* 19 */     Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[AtoutsPlus] if u need support : https://discord.gg/s4byxSRJYM");
/* 20 */     Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[AtoutsPlus] AtoutsPlus enabled");
/* 21 */     Bukkit.getPluginManager().registerEvents(new KeepEvent(this), (Plugin)this);
/* 22 */     Bukkit.getPluginManager().registerEvents(new FireEvent(this), (Plugin)this);
/* 23 */     Bukkit.getPluginManager().registerEvents(new SpeedEvent(this), (Plugin)this);
/* 24 */     Bukkit.getPluginManager().registerEvents(new StrengthEvent(this), (Plugin)this);
/* 25 */     getCommand("atp").setExecutor(new Cmd(this));
/* 26 */     getCommand("configreload").setExecutor((CommandExecutor)this);
/* 27 */     instance = this;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
/* 32 */     if (!command.getName().equals("configreload")) return super.onCommand(sender, command, label, args); 
/* 33 */     if (sender.hasPermission("atp.reload")) {
/* 34 */       reloadConfig();
/* 35 */       sender.sendMessage(getConfig().getString("messages.reload").replace("&", "§"));
/* 36 */       return true;
/*    */     } 
/* 38 */     return false;
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 42 */     Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[AtoutsPlus] AtoutsPlus was disabled");
/*    */   }
/*    */ }


/* Location:              C:\Users\faila\Desktop\AtoutsPlus - 1.0.jar!\fr\failaxite\atp\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */