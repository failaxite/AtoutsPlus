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
/*    */ public class StrengthEvent
/*    */   implements Listener
/*    */ {
/*    */   private Main main;
/*    */   public ArrayList<Player> keep;
/*    */   
/*    */   public StrengthEvent(Main main) {
/* 28 */     this.keep = new ArrayList<>();
/*    */     this.main = main;
/*    */   } @EventHandler
/*    */   public void onConsume(PlayerInteractEvent e) {
/* 32 */     Player p = e.getPlayer();
/* 33 */     ItemStack hand = e.getItem();
/* 34 */     if (hand == null) {
/*    */       return;
/*    */     }
/* 37 */     ItemMeta meta = hand.getItemMeta();
/* 38 */     String name = meta.getDisplayName();
/* 39 */     if (e.getPlayer().getInventory().getItemInHand().getType().equals(Material.ENCHANTED_BOOK) && 
/* 40 */       e.getItem().getItemMeta().getDisplayName().equals(this.main.getConfig().getString("names.forcename").replace("&", "§"))) {
/* 41 */       if (e.getItem().getAmount() > 1) {
/* 42 */         e.setCancelled(true);
/* 43 */         e.getPlayer().sendMessage(this.main.getConfig().getString("messages.erreurstack"));
/*    */       } else {
/* 45 */         e.getPlayer().getInventory().remove(new ItemStack(Material.ENCHANTED_BOOK, 1));
/* 46 */         e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
/* 47 */         e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2147483647, 0));
/* 48 */         e.getPlayer().getPlayer().sendMessage(this.main.getConfig().getString("use.forceuseme").replace("&", "§"));
/* 49 */         Bukkit.broadcastMessage(this.main.getConfig().getString("use.forceuseall").replace("&", "§").replace("{PLAYER}", e.getPlayer().getDisplayName()));
/* 50 */         removePlayerItemInHand(p);
/* 51 */         e.getPlayer().updateInventory();
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   private void removePlayerItemInHand(Player player) {
/* 57 */     ItemStack hand = new ItemStack(player.getItemInHand());
/* 58 */     int amount = hand.getAmount() - 1;
/* 59 */     if (amount == 0) {
/* 60 */       player.setItemInHand(new ItemStack(Material.AIR));
/*    */     } else {
/* 62 */       hand.setAmount(amount);
/* 63 */       player.setItemInHand(hand);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\faila\Desktop\AtoutsPlus - 1.0.jar!\fr\failaxite\atp\StrengthEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */