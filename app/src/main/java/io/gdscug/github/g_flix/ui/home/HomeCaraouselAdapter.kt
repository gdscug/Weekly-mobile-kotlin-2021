package io.gdscug.github.g_flix.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.gdscug.github.g_flix.data.MovieEntity
import io.gdscug.github.g_flix.databinding.ItemsCarouselHomeBinding

class HomeCaraouselAdapter : RecyclerView.Adapter<HomeCaraouselAdapter.HomeCaraouselViewHolder>() {
    private lateinit var binding: ItemsCarouselHomeBinding

    private val listMovie = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies.isNullOrEmpty()) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCaraouselViewHolder {
        binding =
            ItemsCarouselHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeCaraouselViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeCaraouselViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

    class HomeCaraouselViewHolder(private val binding: ItemsCarouselHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvTitle.text = movie.movieTitle
                Glide.with(itemView.context)
                    .load(movie.moviePoster)
                    .centerCrop()
                    .into(ivPoster)
            }
        }
    }
}