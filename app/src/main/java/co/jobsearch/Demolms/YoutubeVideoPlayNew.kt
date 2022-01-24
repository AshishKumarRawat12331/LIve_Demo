package co.jobsearch.Demolms

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.SparseArray
import androidx.appcompat.app.AppCompatActivity
import at.huber.youtubeExtractor.VideoMeta
import at.huber.youtubeExtractor.YouTubeExtractor
import at.huber.youtubeExtractor.YtFile
import co.jobsearch.Demolms.Utils.ApplicationConstant
import co.jobsearch.Demolms.Utils.UtilMethods
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.activity_main_youtubeplay.*


class YoutubeVideoPlayNew  : AppCompatActivity() {


    private var videoPlayer: SimpleExoPlayer? = null
    private var sampleUrl = ""

    var partidval=""
    var time = 0
    var secandtime = 0
    private val mHandler = Handler()

    private fun runtime() {
        val runnable: Runnable = object : Runnable {
            override fun run() {
                ++time
                if (time <= 9) {


                    time.toString();

                } else {

                    time.toString();

                }
                mHandler.postDelayed(this, 1000)
            }
        }
        mHandler.post(runnable)
    }


    @SuppressLint("StaticFieldLeak")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportActionBar?.hide()

        setContentView(R.layout.activity_main_youtubeplay)

      //  val youtubeLink = "http://youtube.com/watch?v=DK_UsATwoxI"
        val video_id_link=intent.getStringExtra("video_id")
        val partid=intent.getStringExtra("contentid")

        val youtubeLink = ""+video_id_link
          partidval = ""+partid

        Log.e("video_id_link",""+ video_id_link +"  partid  :  "+  partid);

        object : YouTubeExtractor(this) {
            override fun onExtractionComplete(ytFiles: SparseArray<YtFile>?, vMeta: VideoMeta?) {
                if (ytFiles != null) {
                    val itag = 18
                    if (ytFiles[itag]!=null) {
                        sampleUrl = ytFiles[itag].url
                        initializePlayer()
                    }
                }
            }
        }.extract(youtubeLink)
    }

    private fun buildMediaSource(): MediaSource? {
        val dataSourceFactory = DefaultDataSourceFactory(this, "sample")
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(sampleUrl))
    }

    private fun initializePlayer() {

        videoPlayer = SimpleExoPlayer.Builder(this).build()
        video_player_view?.player = videoPlayer
        buildMediaSource()?.let {
            videoPlayer?.prepare(it)
            videoPlayer?.playWhenReady = true

            Log.e("stopppppinitialize","As :  "+ "prepare    "+time.toString() );
            runtime();

        }

    }

    override fun onResume() {
        super.onResume()
        videoPlayer?.playWhenReady = true
    }

    override fun onStop() {
        super.onStop()
        videoPlayer?.playWhenReady = false
        if (isFinishing) {
            releasePlayer()
        }

        Log.e("stoppppp","As :  "+ "Stop    "+time.toString() );

        val myPreferences = getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE)
        val contentid = myPreferences.getString(ApplicationConstant.INSTANCE.content_id, "")

        UtilMethods.INSTANCE.videoseen(
            this,
            contentid,
            partidval,
            time.toString() + "",
            null
        )


    }

    private fun releasePlayer() {
        videoPlayer?.release()
    }
}