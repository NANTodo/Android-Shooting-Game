package org.Game;

import com.example.gameframework.AppManager;
import com.example.gameframework.R;

public class Enemy_1 extends Enemy {

    public Enemy_1() {
        super(AppManager.getInstance().getBitmap(R.drawable.enemy1));
        hp = 10;
        speed = 2;
        this.initSpriteData(this.m_bitmap.getWidth()/6, this.m_bitmap.getHeight(), (int) (speed*2), 6);


    }

    public void Update(long GameTime){
        super.Update(GameTime);
        m_BoundBox.set(m_x, m_y, m_x + this.m_bitmap.getWidth()/6, m_y + this.m_bitmap.getHeight());
    }
}
