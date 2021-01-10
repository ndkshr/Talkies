package com.kl51.talkies.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kl51.talkies.R
import com.kl51.talkies.databinding.BottomSheetMovieDetailBinding

class MoviePreviewBottomSheet : BottomSheetDialogFragment() {

    lateinit var binding: BottomSheetMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding =
            DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_movie_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movieTitle.text = arguments?.get(BUNDLE_TITLE).toString()
        binding.movieDescription.text = arguments?.get(BUNDLE_DESCRIPTION).toString()
        binding.buttonViewMovie.setOnClickListener {
            MovieDetailsActivity.start(activity, arguments?.get(BUNDLE_ID).toString())
            Toast.makeText(activity, arguments?.get(BUNDLE_ID).toString(), Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val BUNDLE_ID = "id"
        private const val BUNDLE_TITLE = "title"
        private const val BUNDLE_DESCRIPTION = "description"
        const val TAG = "Movie Preview Bottom Sheet Fragment"

        fun getInstance(movieId: Int, movieTitle: String, movieDescription: String) =
            MoviePreviewBottomSheet().apply {
                arguments = Bundle().apply {
                    putInt(BUNDLE_ID, movieId)
                    putString(BUNDLE_TITLE, movieTitle)
                    putString(BUNDLE_DESCRIPTION, movieDescription)
                }
            }
    }
}
