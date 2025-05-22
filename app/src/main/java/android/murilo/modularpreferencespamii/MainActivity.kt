package android.murilo.modularpreferencespamii

import android.graphics.Color
import android.murilo.modularpreferencespamii.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    companion object{
        const val  NOME_ARQUIVO = "arquivo_prefs.xml"
    }

    private  var cor = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide()
        window.statusBarColor = Color.WHITE
        binding = ActivityMainBinding.inflate(layoutInflater)


        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setContentView(binding.root)

        binding.cor1.setOnClickListener{
            cor = "#FF3700b3"
            salvarCor(cor)
        }

        binding.cor2.setOnClickListener{
            cor = "#FF03DAC5"
            salvarCor(cor)

        }
        binding.cor3.setOnClickListener{
            cor = "#F44336"
            salvarCor(cor)
        }

        binding.cor4.setOnClickListener{
            cor = "#4CAF50"
            salvarCor(cor)
        }
        binding.cor5.setOnClickListener{
            cor = "#FFC107"
            salvarCor(cor)
        }






    }
    private fun salvarCor(cor: String){

        binding.main.setBackgroundColor(Color.parseColor(cor))

        binding.btnTrocar.setOnClickListener{ view ->
            val preferencies = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
            val editor = preferencies.edit()
            editor.putString("cor", cor)
            editor.putString("nome","Murilo")
            editor.putInt("idade", 18)
            editor.apply()


            snackBar(view)

        }


    }

    private fun snackBar(view:View){
        val snackBar = Snackbar.make(view, "Cor de fundo alterada com sucesso", Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction("OK"){

        }

        snackBar.setActionTextColor(Color.BLUE)
        snackBar.setBackgroundTint(Color.LTGRAY)
        snackBar.setTextColor(Color.GREEN)
        snackBar.show()
    }
}