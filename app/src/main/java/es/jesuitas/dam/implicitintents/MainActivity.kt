package es.jesuitas.dam.implicitintents

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import es.jesuitas.dam.implicitintents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnWeb.setOnClickListener(this)
        binding.btnWebsearch.setOnClickListener(this)
        binding.btnMap.setOnClickListener(this)
        binding.btnMail.setOnClickListener(this)
        binding.btnPhone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_web -> openWeb("https://www.jesuitasrioja.org")
            R.id.btn_websearch -> searchWeb("Jesuitas Rioja")
            R.id.btn_map -> openMap()
            R.id.btn_mail -> sendMail()
            R.id.btn_phone -> phoneCall()
        }
    }

    private fun phoneCall() {
        Toast.makeText(this, "Phone",Toast.LENGTH_LONG).show()
    }

    private fun sendMail() {
        Toast.makeText(this,R.string.mail,Toast.LENGTH_LONG).show()

    }

    private fun openMap() {
        Toast.makeText(this,R.string.map,Toast.LENGTH_LONG).show()
    }

    private fun searchWeb(query: String) {
        val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
            putExtra(SearchManager.QUERY, query)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openWeb(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}