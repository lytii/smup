package com.example.longlam.mash.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.longlam.mash.R;

/**
 * Custom layout VIEW for Player Card factions(2) and current VP score
 */
public class PlayerCard extends RelativeLayout {

   ImageView faction0ImageView;
   TextView victoryPointsTextView;
   PlayerInfo playerInfo;

   @RequiresApi(api = Build.VERSION_CODES.M)
   public PlayerCard(Context context, AttributeSet attrs) {
      super(context, attrs);
      TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PlayerCard, 0, 0);
//      int colorId = a.getResourceId(R.styleable.PlayerCard_playerColor, R.color.playerOne);
//      initializePlayerColors(new PlayerInfo(0, getIconBorder(colorId), colorId));
      int playerNumber = a.getInt(R.styleable.PlayerCard_playerNumber, 0);
      initializePlayerColors(playerNumber);
   }

   @RequiresApi(api = Build.VERSION_CODES.M)
   private void initializePlayerColors(int playerNumber) {
      int playerColor = getResources().getIntArray(R.array.playerColors)[playerNumber];

      View view = inflate(getContext(), R.layout.player_card, this);
      faction0ImageView = (ImageView) findViewById(R.id.faction_card0_image_view);

      // Sets with color by playerInfo
      LinearLayout linearLayout = (LinearLayout) findViewById(R.id.player_card_layout);
      linearLayout.setForeground(getBorder(playerNumber));
      victoryPointsTextView = (TextView) findViewById(R.id.victory_points_text_view);
      victoryPointsTextView.setTextColor(playerColor);
   }

   public void setVP(int vp) {
      victoryPointsTextView.setText(vp);
   }

   public void setController(int playerNumber) {
      // do something about controller
   }

   private Drawable getBorder(int playerNumber) {
      switch (playerNumber) {
         case 0:
            return ContextCompat.getDrawable(getContext(), R.drawable.rediconborder);
         case 1:
            return ContextCompat.getDrawable(getContext(), R.drawable.blueiconborder);
         default:
            return ContextCompat.getDrawable(getContext(), R.drawable.rediconborder);
      }
   }
}