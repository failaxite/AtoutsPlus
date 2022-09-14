/*    */ package fr.failaxite.atp;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KeepEvent
/*    */   implements Listener
/*    */ {
/*    */   private Main main;
/*    */   public ArrayList<Player> keep;
/*    */   
/*    */   public KeepEvent(Main main) {
/* 31 */     this.keep = new ArrayList<>();
/*    */     this.main = main;
/*    */   }
/*    */   @EventHandler
/*    */   public void onConsume(PlayerInteractEvent e) {
/* 36 */     Player p = e.getPlayer();
/* 37 */     ItemStack hand = e.getItem();
/* 38 */     if (hand == null) {
/*    */       return;
/*    */     }
/* 41 */     ItemMeta meta = hand.getItemMeta();
/* 42 */     String name = meta.getDisplayName();
/* 43 */     if (e.getPlayer().getInventory().getItemInHand().getType().equals(Material.ENCHANTED_BOOK) && 
/* 44 */       e.getItem().getItemMeta().getDisplayName().equals(this.main.getConfig().getString("names.keepname").replace("&", "§"))) {
/* 45 */       if (e.getItem().getAmount() > 1) {
/* 46 */         e.setCancelled(true);
/* 47 */         e.getPlayer().sendMessage(this.main.getConfig().getString("messages.erreurstack").replace("&", "§"));
/* 48 */         if (this.keep.contains(e.getPlayer())) {
/* 49 */           e.setCancelled(true);
/* 50 */           e.getPlayer().sendMessage(this.main.getConfig().getString("messages.erreurkeep").replace("&", "§"));
/*    */         } 
/*    */       } else {
/* 53 */         e.getPlayer().getInventory().remove(new ItemStack(Material.NETHER_STAR, 1));
/* 54 */         this.keep.add(e.getPlayer());
/* 55 */         e.getPlayer().getPlayer().sendMessage(this.main.getConfig().getString("use.keepuseme").replace("&", "§"));
/* 56 */         Bukkit.broadcastMessage(this.main.getConfig().getString("use.keepuseall").replace("&", "§").replace("{PLAYER}", e.getPlayer().getDisplayName()));
/* 57 */         removePlayerItemInHand(p);
/* 58 */         e.getPlayer().updateInventory();
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   private void removePlayerItemInHand(Player player) {
/* 64 */     ItemStack hand = new ItemStack(player.getItemInHand());
/* 65 */     int amount = hand.getAmount() - 1;
/* 66 */     if (amount == 0) {
/* 67 */       player.setItemInHand(new ItemStack(Material.AIR));
/*    */     } else {
/* 69 */       hand.setAmount(amount);
/* 70 */       player.setItemInHand(hand);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onPlayerDeath(PlayerDeathEvent event) {
/* 78 */     Player player = event.getEntity();
/* 79 */     if (this.keep.contains(event.getEntity())) {
/* 80 */       event.setKeepInventory(true);
/* 81 */       event.setKeepLevel(true);
/* 82 */       event.setDroppedExp(0);
/* 83 */       this.keep.remove(event.getEntity());
/*    */     } else {
/* 85 */       event.setKeepInventory(false);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\faila\Desktop\AtoutsPlus - 1.0.jar!\fr\failaxite\atp\KeepEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */