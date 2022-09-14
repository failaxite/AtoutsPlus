/*    */ package fr.failaxite.atp;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FireEvent
/*    */   implements Listener
/*    */ {
/*    */   private Main main;
/*    */   public ArrayList<Player> keep;
/*    */   
/*    */   public FireEvent(Main main) {
/* 30 */     this.keep = new ArrayList<>();
/*    */     this.main = main;
/*    */   }
/*    */   @EventHandler
/*    */   public void onConsume(PlayerInteractEvent e) {
/* 35 */     Player p = e.getPlayer();
/* 36 */     ItemStack hand = e.getItem();
/* 37 */     if (hand == null) {
/*    */       return;
/*    */     }
/* 40 */     ItemMeta meta = hand.getItemMeta();
/* 41 */     String name = meta.getDisplayName();
/* 42 */     if (e.getPlayer().getInventory().getItemInHand().getType().equals(Material.ENCHANTED_BOOK) && 
/* 43 */       e.getItem().getItemMeta().getDisplayName().equals(this.main.getConfig().getString("names.firename").replace("&", "§"))) {
/* 44 */       if (e.getItem().getAmount() > 1) {
/* 45 */         e.setCancelled(true);
/* 46 */         e.getPlayer().sendMessage(this.main.getConfig().getString("messages.erreurstack"));
/*    */       } else {
/* 48 */         e.getPlayer().getInventory().remove(new ItemStack(Material.ENCHANTED_BOOK, 1));
/* 49 */         e.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
/* 50 */         e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2147483647, 0));
/* 51 */         e.getPlayer().getPlayer().sendMessage(this.main.getConfig().getString("use.fireuseme").replace("&", "§"));
/* 52 */         Bukkit.broadcastMessage(this.main.getConfig().getString("use.fireuseall").replace("&", "§").replace("{PLAYER}", e.getPlayer().getDisplayName()));
/* 53 */         removePlayerItemInHand(p);
/* 54 */         e.getPlayer().updateInventory();
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   private void removePlayerItemInHand(Player player) {
/* 60 */     ItemStack hand = new ItemStack(player.getItemInHand());
/* 61 */     int amount = hand.getAmount() - 1;
/* 62 */     if (amount == 0) {
/* 63 */       player.setItemInHand(new ItemStack(Material.AIR));
/*    */     } else {
/* 65 */       hand.setAmount(amount);
/* 66 */       player.setItemInHand(hand);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\faila\Desktop\AtoutsPlus - 1.0.jar!\fr\failaxite\atp\FireEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */