
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.Toast.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vitalium.R
import com.example.vitalium.adapters.MedicamentosAdapter
import com.example.vitalium.models.Medicamento

import com.google.firebase.firestore.FirebaseFirestore
class MedicamentosActivity : AppCompatActivity() {

    private lateinit var medicamentoList: List<Medicamento>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicamentos)

        medicamentoList = listOf(
            Medicamento("Paracetamol", 3.5),
            Medicamento("Ibuprofeno", 5.0),
            // Agrega más medicamentos aquí
        )

        recyclerView = findViewById(R.id.recyclerViewMedicamentos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MedicamentosAdapter(medicamentoList)
        recyclerView.adapter = adapter

        // Función para validar la selección de medicamentos
        fun validarSeleccionMedicamento(medicamentosSeleccionados: List<Medicamento>): Boolean {
            if (medicamentosSeleccionados.isEmpty()) {
                makeText(this, "Seleccione al menos un medicamento", LENGTH_SHORT).show()
                return false
            }
            return true
        }

        // Ejemplo de uso
        val medicamentosSeleccionados = listOf<Medicamento>() // Actualiza con la lista real
        if (validarSeleccionMedicamento(medicamentosSeleccionados)) {
            fun validarOrden(medicamentosSeleccionados: List<Medicamento>, total: Double): Boolean {
                if (medicamentosSeleccionados.isEmpty()) {
                    makeText(this, "No se puede generar una orden sin medicamentos", LENGTH_SHORT).show()
                    return false
                }
                if (total <= 0) {
                    makeText(this, "El total no puede ser 0", LENGTH_SHORT).show()
                    return false
                }
                return true
            }

            // Ejemplo de validación de orden
            val total = medicamentosSeleccionados.sumOf { it.precio }
            validarOrden(medicamentosSeleccionados, total)
        }
    }
}
