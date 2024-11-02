package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    private lateinit var orderNameTextView: TextView
    private lateinit var foodNameTextView: TextView
    private lateinit var servingsTextView: TextView
    private lateinit var notesTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        orderNameTextView = findViewById(R.id.cName)
        foodNameTextView = findViewById(R.id.cFoodName)
        servingsTextView = findViewById(R.id.cNumber)
        notesTextView = findViewById(R.id.cNotes)
        backButton = findViewById(R.id.backtoMenu)

        val foodName = intent.getStringExtra("foodName") ?: ""
        val servings = intent.getIntExtra("servings", 0)
        val orderName = intent.getStringExtra("customerName") ?: ""
        val notes = intent.getStringExtra("notes") ?: ""

        orderNameTextView.text = orderName
        foodNameTextView.text = foodName
        servingsTextView.text = servings.toString()
        notesTextView.text = notes

        backButton.setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
        }
    }
}