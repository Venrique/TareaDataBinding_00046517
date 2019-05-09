package com.aldana.ejemplo14

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aldana.ejemplo14.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,R.layout.activity_main
        ).apply {
            this.puntos = scoreViewModel
        }

        val pointsObserverA = Observer<Int>{ newPoint ->
            tv_score_team_a.text = newPoint.toString()
        }

        val pointsObserverB = Observer<Int>{ newPoint ->
            tv_score_team_b.text = newPoint.toString()
        }

        scoreViewModel.scoreTeamA.observe(this,pointsObserverA)
        scoreViewModel.scoreTeamB.observe(this,pointsObserverB)

        // TODO: El ViewModel es restaurado si ya existía, si no, se crea uno nuevo.
        // TODO: Recuerde que el ViewModel solo sobrevive a cambios de configuración y no a la destrucción de la aplicación

    }


    // TODO: Accediendo y modificando datos almacenados en el ViewModel según el método utilizado

    fun addOneTeamA(v: View) {
        scoreViewModel.sumar(1,"equipoA")
    }

    fun addOneTeamB(v: View) {
        scoreViewModel.sumar(1,"equipoB")
    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.sumar(2,"equipoA")

    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.sumar(2,"equipoB")

    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.sumar(3,"equipoA")

    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.sumar(3,"equipoB")

    }

    fun resetScores(v: View) {
        scoreViewModel.reset()

    } // TODO: Limpiando datos


}
