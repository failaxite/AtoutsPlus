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
/*    */ public class SpeedEvent
/*    */   implements Listener
/*    */ {
/*    */   private Main main;
/*    */   public ArrayList<Player> keep;
/*    */   
/*    */   public SpeedEvent(Main main) {
/* 29 */     this.keep = new ArrayList<>();
/*    */     this.main = main;
/*    */   }
/*    */   @EventHandler
/*    */   public void onConsume(PlayerInteractEvent e) {
/* 34 */     Player p = e.getPlayer();
/* 35 */     ItemStack hand = e.getItem();
/* 36 */     if (hand == null) {
/*    */       return;
/*    */     }
/* 39 */     ItemMeta meta = hand.getItemMeta();
/* 40 */     String name = meta.getDisplayName();
/* 41 */     if (e.getPlayer().getInventory().getItemInHand().getType().equals(Material.ENCHANTED_BOOK) && 
/* 42 */       e.getItem().getItemMeta().getDisplayName().equals(this.main.getConfig().getString("names.speedname").replace("&", "§"))) {
/* 43 */       if (e.getItem().getAmount() > 1) {
/* 44 */         e.setCancelled(true);
/* 45 */         e.getPlayer().sendMessage(this.main.getConfig().getString("messages.erreurstack"));
/*    */       } else {
/* 47 */         e.getPlayer().getInventory().remove(new ItemStack(Material.ENCHANTED_BOOK, 1));
/* 48 */         e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
/* 49 */         e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 0));
/* 50 */         e.getPlayer().getPlayer().sendMessage(this.main.getConfig().getString("use.speeduseme").replace("&", "§"));
/* 51 */         Bukkit.broadcastMessage(this.main.getConfig().getString("use.speeduseall").replace("&", "§").replace("{PLAYER}", e.getPlayer().getDisplayName()));
/* 52 */         removePlayerItemInHand(p);
/* 53 */         e.getPlayer().updateInventory();
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   private void removePlayerItemInHand(Player player) {
/* 59 */     ItemStack hand = new ItemStack(player.getItemInHand());
/* 60 */     int amount = hand.getAmount() - 1;
/* 61 */     if (amount == 0) {
/* 62 */       player.setItemInHand(new ItemStack(Material.AIR));
/*    */     } else {
/* 64 */       hand.setAmount(amount);
/* 65 */       player.setItemInHand(hand);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\faila\Desktop\AtoutsPlus - 1.0.jar!\fr\failaxite\atp\SpeedEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */