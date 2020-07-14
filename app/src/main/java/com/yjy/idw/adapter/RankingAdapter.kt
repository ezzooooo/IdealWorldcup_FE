import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yjy.idw.R
import com.yjy.idw.data.RankingVO
import kotlinx.android.synthetic.main.ranking_item.view.*

class RankingAdapter(val context: Context, val RankingList: ArrayList<RankingVO>) : RecyclerView.Adapter<RankingAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.ranking_item, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return RankingList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(RankingList[position])
    }

    inner class Holder(rankingView: View) : RecyclerView.ViewHolder(rankingView) {
        private val ranking_image = rankingView.ranking_image
        private val ranking_name = rankingView.ranking_name
        private val ranking_rank_num = rankingView.ranking_rank_num
        private val ranking_trophy_rate = rankingView.ranking_trophy_rate
        private val ranking_win_rate = rankingView.ranking_win_rate
        private val ranking_trophy_image = rankingView.ranking_trophy_image
        private val ranking_win_image = rankingView.ranking_win_image

        internal val view: View = rankingView

        fun bind (ranking: RankingVO) {
            if (ranking.image_url != "") {
                Glide.with(view)
                    .load(ranking.image_url)
                    //.override(100)
                    .centerCrop()
                    .into(ranking_image)
            } else {
                ranking_image?.setImageResource(R.mipmap.ic_launcher)
            }
            ranking_name.text = ranking.name
            ranking_rank_num.text = ranking.rank_num
            ranking_trophy_rate.text = ranking.trophy_rate
            ranking_win_rate.text = ranking.win_rate
            ranking_trophy_image.setImageResource(R.drawable.trophy)
            ranking_win_image.setImageResource(R.drawable.vs)
        }
    }

}