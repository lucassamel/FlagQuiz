package lucassamel.br.flagquiz

import android.graphics.Color
import android.graphics.Color.GREEN
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var paises: ArrayList<Locale>
    private lateinit var botoes: Array<Button>
    private var botaoRespostaCerta = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // FILTRANDO OS PAISES DISPONIVEIS
        paises = ArrayList()
        for (locale in Locale.getAvailableLocales()) {
            if (locale.country.length == 2) {
                paises.add(locale)
            }
        }

        botoes = arrayOf(
            this.findViewById(R.id.btn1),
            this.findViewById(R.id.btn2),
            this.findViewById(R.id.btn3)
        )
        for (i in 0..2) {
            botoes[i].setText("")
            botoes[i].setOnClickListener(this)
        }

    }

    override fun onClick(v: View?) {
        //Estou fazendo um Cast da View para botão pq eu sei ali que tem um botão
        val button: Button = v as Button
        val lblResposta = this.findViewById<TextView>(R.id.lblResposta)
        if (botoes[botaoRespostaCerta] == button) {
            lblResposta.setTextColor(Color.GREEN)
            lblResposta.setText(button.text.toString() + "CORRETO")
        } else {
            lblResposta.setTextColor(Color.RED)
            lblResposta.setText(button.text.toString() + "ERRADO")
        }
    }
}