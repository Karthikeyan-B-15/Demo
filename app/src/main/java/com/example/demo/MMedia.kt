package com.example.demo

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MMedia : AppCompatActivity() {
    private lateinit var seekbar:SeekBar
    private var mediaPlayer:MediaPlayer?=null
    private lateinit var runnable: Runnable
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mmedia)
        handler= Handler(Looper.getMainLooper())
        val play=findViewById<FloatingActionButton>(R.id.fabplay)
        val pause=findViewById<FloatingActionButton>(R.id.fabpause)
        val stop=findViewById<FloatingActionButton>(R.id.fabstop)
        seekbar=findViewById(R.id.seekBar)
        play.setOnClickListener{
            if(mediaPlayer==null) {
                mediaPlayer=MediaPlayer.create(this,R.raw.kushi)
                initialize()
            }
            mediaPlayer?.start()
        }
        pause.setOnClickListener{
            mediaPlayer?.pause()
        }
        stop.setOnClickListener{
            mediaPlayer?.stop()
            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer=null
            handler.removeCallbacks(runnable)
            seekbar.progress=0
        }
    }
    private fun initialize(){
        seekbar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) mediaPlayer?.seekTo(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

        })
        seekbar.max= mediaPlayer!!.duration
        runnable= Runnable {
                seekbar.progress= mediaPlayer!!.currentPosition
                handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)
    }
}