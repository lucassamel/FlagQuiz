package lucassamel.br.flagquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var paises: ArrayList<Locale>
    private lateinit var botoes : Array<Button>
    private  var botaoRespostaCerta = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // FILTRANDO OS PAISES DISPONIVEIS
        for (locale in Locale.getAvailableLocales()){
            if(locale.country.length == 2){
                paises.add(locale)
            }
        }

        botoes = arrayOf(this.findViewById(R.id.btn1),
            this.findViewById(R.id.btn2),
            this.findViewById(R.id.btn3))
        for (i in 0..2){
            botoes[i].setText("")
            botoes[i].setOnClickListener(this)
        }

    }

    override fun onClick(v: View?) {

    }
}