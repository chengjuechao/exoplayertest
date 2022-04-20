package com.chengjuechao.exoplayer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

/**
 * Created by chengjuechao on 2022/4/17.
 */
class PlayerFragment1 : Fragment() {

    companion object {
        fun newInstance(url: String): PlayerFragment1 {
            val args = Bundle()
            args.putString("url", url)
            val fragment = PlayerFragment1()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main1, container, false)
    }

    private var player: ExoPlayer? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val surfaceView = requireView() as SurfaceView
//        val lp = FrameLayout.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.MATCH_PARENT
//        )
//        (view as FrameLayout).addView(surfaceView, lp)
        player = ExoPlayer.Builder(requireContext()).build()
            .apply {
                setVideoSurfaceView(surfaceView)
                prepare()
            }
        val url = arguments!!.getString("url")
        MediaItem.fromUri(url!!).apply {
            player!!.setMediaItem(this)
        }
        player!!.play()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) {
            player?.pause()
        } else {
            player?.play()
        }
    }

}