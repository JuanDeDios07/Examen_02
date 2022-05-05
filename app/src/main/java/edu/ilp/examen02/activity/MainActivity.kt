package edu.ilp.examen02.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import edu.ilp.examen02.R
import edu.ilp.examen02.clases.Pregunta

class MainActivity : AppCompatActivity() {
    var preguntas = ArrayList<Pregunta>()
    var posicionActual = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ejercicio01();
        //ejercicio02();
        //ejercicio03()

        caragrPreguntas()
        mostrarPreguntas()

        val btnVerdad = findViewById<android.view.View>(R.id.btnverdadero)
        btnVerdad.setOnClickListener() {
            if (preguntas[posicionActual].respuesta)
                Toast.makeText(this, "La respuesta es Corecta", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "La respuesta es InCorecta", Toast.LENGTH_SHORT).show()
        }
        val btnincorecto = findViewById<android.view.View>(R.id.btnfalso)
        btnincorecto.setOnClickListener() {
            if (!preguntas[posicionActual].respuesta)
                Toast.makeText(this, "la respuesta es Corecta", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "La respuesta es InCorecta", Toast.LENGTH_SHORT).show()
        }

        val btnNext = findViewById<Button>(R.id.btnsiguiente)
        btnNext.setOnClickListener {
            try {
                posicionActual++
                mostrarPreguntas()
            }catch (e: Exception){
                println("FIN DE LAS ENCUESTAS")
                Toast.makeText(this, "FIN DE LAS ENCUESTAS", Toast.LENGTH_SHORT).show()
            }
        }


        val btnRetroceder = findViewById<Button>(R.id.btnatras)
        btnRetroceder.setOnClickListener {
            try {
                posicionActual =posicionActual-1
                mostrarPreguntas()
            }catch (e: Exception){
                println("NO HAY MAS ENCUESTAS ATRAS")
                Toast.makeText(this, "NO HAY MAS ENCUESTAS ATRAS", Toast.LENGTH_SHORT).show()
            }
        }

        val btnCloss=findViewById<Button>(R.id.btncerrar)
        btnCloss.setOnClickListener{
            finish();
            println("FIN DE LA APLICACIÓN")
        }
    }

    fun ejercicio01(){
        for (i in 50 downTo 1) {

            println("numero: $i ")
        }
        for (i in 50 downTo 0 step 2) {
            println("el valor impreso de manera inversa :$i")
        }
    }
    fun ejercicio02(){
        val num = 5
        var factorial: Long = 1
        for (i in 1..num) {
            factorial *= i.toLong()
        }
        println("Factorial de: $num = $factorial")
    }

    fun ejercicio03(){
        var base=5
        var altura:Int=6
        var area=(base*altura)/2
        println("EL AREA DE UN TRIANGULO ES IGUAL A: $area")
    }

    private fun mostrarPreguntas() {

        val TextoPregunta = findViewById<TextView>(R.id.tvPregunta)
        TextoPregunta.text = preguntas[posicionActual].enunciado

    }

    fun caragrPreguntas() {
        preguntas.add(Pregunta(enunciado = "Bogota es la capital de Colombia ?",true))
        preguntas.add(Pregunta(enunciado = "Arequipa es la capital de Brasil?",false))
        preguntas.add(Pregunta(enunciado = "España es un pais Europeo ?",true))
        preguntas.add(Pregunta(enunciado = "Brasil es considerado un continente ?",false))
        preguntas.add(Pregunta(enunciado = "Existen 5 continetes en el mundo ?",true))

    }
}