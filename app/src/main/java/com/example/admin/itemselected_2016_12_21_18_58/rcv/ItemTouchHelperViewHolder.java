package com.example.admin.itemselected_2016_12_21_18_58.rcv;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/12/22 17:32 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/12/22 17:32 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public interface ItemTouchHelperViewHolder {

    /**
     * Called when the {@link ItemTouchHelper} first registers an item as being moved or swiped.
     * Implementations should update the item view to indicate it's active state.
     */
    void onItemSelected();


    /**
     * Called when the {@link ItemTouchHelper} has completed the move or swipe, and the active item
     * state should be cleared.
     */
    void onItemClear();
}
