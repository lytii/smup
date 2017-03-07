package com.example.longlam.mash.card;

import android.graphics.drawable.Drawable;

public class PlayerInfo {
   public int playerNumber;
   public Drawable colorBorder;
   public int colorRef;
   public int vp;

   public PlayerInfo(int playerNumber, Drawable colorBorder, int colorRef) {
      this.playerNumber = playerNumber;
      this.colorBorder = colorBorder;
      this.colorRef = colorRef;
      vp = 0;
   }

   public int increaseVP() {
      return increaseVP(1);
   }

   public int increaseVP(int increment) {
      vp += increment;
      return vp;
   }
}