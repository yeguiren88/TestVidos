package video.com.myvideo.listenter;

import android.support.v7.widget.RecyclerView;
public interface RecyclerViewItemViewListener {
    /**
     * itemView的点击事件
     * @param viewHolder
     * @param position
     */
    void onClickListener(RecyclerView.ViewHolder viewHolder, int position);
    /**
     * 是itemView的长按事件
     * @param viewHolder
     * @param position
     */
    void onLongClickListener(RecyclerView.ViewHolder viewHolder, int position);

}