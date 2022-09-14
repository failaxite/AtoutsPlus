/*     */ package fr.failaxite.atp;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.ItemFlag;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public class Cmd
/*     */   implements CommandExecutor
/*     */ {
/*     */   private Main main;
/*     */   
/*     */   public Cmd(Main main) {
/*  22 */     this.main = main;
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/*  26 */     if (sender instanceof Player) {
/*  27 */       Player p = (Player)sender;
/*  28 */       String def = new String(ChatColor.GOLD + "[AtoutsPlus] " + ChatColor.GRAY);
/*  29 */       if (label.equalsIgnoreCase("atp") && 
/*  30 */         args.length == 0 && 
/*  31 */         p.hasPermission("atp.use")) {
/*  32 */         p.sendMessage(String.valueOf(def) + "Help - AtoutsPlus");
/*  33 */         p.sendMessage(String.valueOf(def) + "");
/*  34 */         p.sendMessage(String.valueOf(def) + "/atp give <ItemType> <Effect> <Player> | Give the items");
/*  35 */         p.sendMessage(String.valueOf(def) + "/atp list | Show the possibilities");
/*     */       } 
/*     */       
/*  38 */       if (args.length == 1 && args[0].equalsIgnoreCase("help") && 
/*  39 */         p.hasPermission("atp.use")) {
/*  40 */         p.sendMessage(String.valueOf(def) + "Help - AtoutsPlus");
/*  41 */         p.sendMessage(String.valueOf(def) + "");
/*  42 */         p.sendMessage(String.valueOf(def) + "/atp give <ItemType> <Effect> <Player> | PGive the items");
/*  43 */         p.sendMessage(String.valueOf(def) + "/atp list | Show the possibilities");
/*     */       } 
/*     */       
/*  46 */       if (args.length == 1 && args[0].equalsIgnoreCase("list") && 
/*  47 */         p.hasPermission("atp.list")) {
/*  48 */         p.sendMessage(String.valueOf(def) + "Help - AtoutsPlus");
/*  49 */         p.sendMessage(String.valueOf(def) + "");
/*  50 */         p.sendMessage(String.valueOf(def) + "Atouts : Fire, Speed, Force, Keep");
/*     */       } 
/*     */       
/*  53 */       if (args.length >= 1 && args.length <= 2 && args[0].equalsIgnoreCase("give")) {
/*  54 */         p.sendMessage(String.valueOf(def) + "Please specify the type of atouts");
/*  55 */         p.sendMessage(String.valueOf(def) + "For check the list of atouts : /atp list");
/*  56 */         p.sendMessage(String.valueOf(def) + "/atp give <Type> <Effets> <Player>");
/*     */       } 
/*     */       
/*  59 */       if ((args.length == 3 || args.length == 4) && 
/*  60 */         p.hasPermission("atp.give") && 
/*  61 */         args[0].equalsIgnoreCase("give")) {
/*  62 */         if (args[1].equalsIgnoreCase("atouts")) {
/*  63 */           if (args[2].equalsIgnoreCase("keep")) {
/*  64 */             ArrayList<String> keep = new ArrayList<>();
/*  65 */             ItemStack keepStack = new ItemStack(Material.ENCHANTED_BOOK);
/*  66 */             ItemMeta keepMeta = keepStack.getItemMeta();
/*  67 */             keepMeta.setDisplayName(this.main.getConfig().getString("names.keepname").replace("&", "§"));
/*  68 */             keepMeta.addEnchant(Enchantment.DURABILITY, 1, true);
/*  69 */             keepMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*  70 */             keep.add(this.main.getConfig().getString("description.keepdesc").replace("&", "§"));
/*  71 */             keepMeta.setLore(keep);
/*  72 */             keepStack.setItemMeta(keepMeta);
/*  73 */             if (args.length == 3) {
/*  74 */               p.getInventory().addItem(new ItemStack[] { keepStack });
/*  75 */               p.sendMessage(this.main.getConfig().getString("messages.secondevie").replace("&", "§"));
/*  76 */             } else if (args.length == 4) {
/*  77 */               boolean found = false;
/*  78 */               Player pla = null;
/*  79 */               for (Player player : Bukkit.getOnlinePlayers()) {
/*  80 */                 if (Bukkit.getPlayer(args[3]).equals(player)) {
/*  81 */                   found = true;
/*  82 */                   pla = Bukkit.getPlayer(args[3]);
/*     */                 } 
/*     */               } 
/*  85 */               if (!found || pla == null) {
/*  86 */                 p.sendMessage("messages.erreur");
/*     */               } else {
/*  88 */                 pla.getInventory().addItem(new ItemStack[] { keepStack });
/*  89 */                 pla.sendMessage(this.main.getConfig().getString("messages.secondevie").replace("&", "§"));
/*     */               } 
/*     */             } 
/*     */           } 
/*  93 */           if (args[2].equalsIgnoreCase("speed")) {
/*  94 */             ArrayList<String> speed = new ArrayList<>();
/*  95 */             ItemStack speedStack = new ItemStack(Material.ENCHANTED_BOOK);
/*  96 */             ItemMeta speedM = speedStack.getItemMeta();
/*  97 */             speedM.setDisplayName(this.main.getConfig().getString("names.speedname").replace("&", "§"));
/*  98 */             speedM.addEnchant(Enchantment.DURABILITY, 1, true);
/*  99 */             speedM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 100 */             speed.add(this.main.getConfig().getString("description.speeddesc").replace("&", "§"));
/* 101 */             speedM.setLore(speed);
/* 102 */             speedStack.setItemMeta(speedM);
/* 103 */             if (args.length == 3) {
/* 104 */               p.getInventory().addItem(new ItemStack[] { speedStack });
/* 105 */               p.sendMessage(this.main.getConfig().getString("messages.speed").replace("&", "§"));
/* 106 */             } else if (args.length == 4) {
/* 107 */               boolean found = false;
/* 108 */               Player pla = null;
/* 109 */               for (Player player : Bukkit.getOnlinePlayers()) {
/* 110 */                 if (Bukkit.getPlayer(args[3]).equals(player)) {
/* 111 */                   found = true;
/* 112 */                   pla = Bukkit.getPlayer(args[3]);
/*     */                 } 
/*     */               } 
/* 115 */               if (!found || pla == null) {
/* 116 */                 p.sendMessage("messages.erreur");
/*     */               } else {
/* 118 */                 pla.getInventory().addItem(new ItemStack[] { speedStack });
/* 119 */                 pla.sendMessage(this.main.getConfig().getString("messages.speed").replace("&", "§"));
/*     */               } 
/*     */             } 
/*     */           } 
/* 123 */           if (args[2].equalsIgnoreCase("force")) {
/* 124 */             ArrayList<String> force = new ArrayList<>();
/* 125 */             ItemStack forceStack = new ItemStack(Material.ENCHANTED_BOOK);
/* 126 */             ItemMeta forceM = forceStack.getItemMeta();
/* 127 */             forceM.setDisplayName(this.main.getConfig().getString("names.forcename").replace("&", "§"));
/* 128 */             forceM.addEnchant(Enchantment.DURABILITY, 1, true);
/* 129 */             forceM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 130 */             force.add(this.main.getConfig().getString("description.forcedesc").replace("&", "§"));
/* 131 */             forceM.setLore(force);
/* 132 */             forceStack.setItemMeta(forceM);
/* 133 */             if (args.length == 3) {
/* 134 */               p.getInventory().addItem(new ItemStack[] { forceStack });
/* 135 */               p.sendMessage(this.main.getConfig().getString("messages.force").replace("&", "§"));
/* 136 */             } else if (args.length == 4) {
/* 137 */               boolean found = false;
/* 138 */               Player pla = null;
/* 139 */               for (Player player : Bukkit.getOnlinePlayers()) {
/* 140 */                 if (Bukkit.getPlayer(args[3]).equals(player)) {
/* 141 */                   found = true;
/* 142 */                   pla = Bukkit.getPlayer(args[3]);
/*     */                 } 
/*     */               } 
/* 145 */               if (!found || pla == null) {
/* 146 */                 p.sendMessage("messages.erreur");
/*     */               } else {
/* 148 */                 pla.getInventory().addItem(new ItemStack[] { forceStack });
/* 149 */                 pla.sendMessage(this.main.getConfig().getString("messages.force").replace("&", "§"));
/*     */               } 
/*     */             } 
/*     */           } 
/* 153 */           if (args[2].equalsIgnoreCase("fire")) {
/* 154 */             ArrayList<String> fire = new ArrayList<>();
/* 155 */             ItemStack fireStack = new ItemStack(Material.ENCHANTED_BOOK);
/* 156 */             ItemMeta fireM = fireStack.getItemMeta();
/* 157 */             fireM.setDisplayName(this.main.getConfig().getString("names.firename").replace("&", "§"));
/* 158 */             fireM.addEnchant(Enchantment.DURABILITY, 1, true);
/* 159 */             fireM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 160 */             fire.add(this.main.getConfig().getString("description.firedesc").replace("&", "§"));
/* 161 */             fireM.setLore(fire);
/* 162 */             fireStack.setItemMeta(fireM);
/* 163 */             if (args.length == 3) {
/* 164 */               p.getInventory().addItem(new ItemStack[] { fireStack });
/* 165 */               p.sendMessage(this.main.getConfig().getString("messages.fire").replace("&", "§"));
/* 166 */             } else if (args.length == 4) {
/* 167 */               boolean found = false;
/* 168 */               Player pla = null;
/* 169 */               for (Player player : Bukkit.getOnlinePlayers()) {
/* 170 */                 if (Bukkit.getPlayer(args[3]).equals(player)) {
/* 171 */                   found = true;
/* 172 */                   pla = Bukkit.getPlayer(args[3]);
/*     */                 } 
/*     */               } 
/* 175 */               if (!found || pla == null) {
/* 176 */                 p.sendMessage("messages.erreur");
/*     */               } else {
/* 178 */                 pla.getInventory().addItem(new ItemStack[] { fireStack });
/* 179 */                 pla.sendMessage(this.main.getConfig().getString("messages.fire").replace("&", "§"));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } else {
/* 184 */           p.sendMessage(this.main.getConfig().getString("messages.permissions"));
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 189 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\faila\Desktop\AtoutsPlus - 1.0.jar!\fr\failaxite\atp\Cmd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */